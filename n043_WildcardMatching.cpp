bool isMatch(const char *s, const char *p) {

    int i;
    bool star = false;

startLoop:
    {
        for( i = 0; s[i] ; i++){
            switch(p[i])
            {
            case '?':
                break;
            case '*': //如果当前 为*， 那么匹配上刚刚不能匹配的那个字符，并且将p移动到 * 结束后的 第一个字符  
                star = true;  //p 每次指向的位置，要么是最开始，要么是 * 结束的第一个位置
                p += i;
                s += i;
                while(*p == '*'){++p;} //检测p是不是后面全是 *
                if(!(*p)) return true;
  
                goto startLoop; //重新开始循环, p 指向 * 结束后的 第一个 非*
            default:
                if(s[i] != p[i]){ //如果 s[i] != p[i]
                    goto starCheck;
                }
            }
        }
    }
    while(p[i] == '*')i++;
    return !(p[i]);

starCheck:
    {
		if(star){ //当 s[i] != p[i], 检测 p 之前是不是 *， 如果是 *，那么我们将s 向后移动一个，其实就是枚举 s 到 s[i],和 p[0] 匹配。  
			s++;
            goto startLoop;
         }
         return false;
     }
}
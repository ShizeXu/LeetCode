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
            case '*': //�����ǰ Ϊ*�� ��ôƥ���ϸող���ƥ����Ǹ��ַ������ҽ�p�ƶ��� * ������� ��һ���ַ�  
                star = true;  //p ÿ��ָ���λ�ã�Ҫô���ʼ��Ҫô�� * �����ĵ�һ��λ��
                p += i;
                s += i;
                while(*p == '*'){++p;} //���p�ǲ��Ǻ���ȫ�� *
                if(!(*p)) return true;
  
                goto startLoop; //���¿�ʼѭ��, p ָ�� * ������� ��һ�� ��*
            default:
                if(s[i] != p[i]){ //��� s[i] != p[i]
                    goto starCheck;
                }
            }
        }
    }
    while(p[i] == '*')i++;
    return !(p[i]);

starCheck:
    {
		if(star){ //�� s[i] != p[i], ��� p ֮ǰ�ǲ��� *�� ����� *����ô���ǽ�s ����ƶ�һ������ʵ����ö�� s �� s[i],�� p[0] ƥ�䡣  
			s++;
            goto startLoop;
         }
         return false;
     }
}
package LeetCode;
public class n069_SqrtX {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        double tmp = x/2.0;
        while(Math.abs(tmp*tmp-x)>0.01) {
            tmp += x/tmp;
            tmp /= 2;
        }
        return (int)tmp;
    }
}
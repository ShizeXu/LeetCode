#include <iostream>
using namespace std;

class P_201 {
public:
    int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        for (int i = 30; i >= 0; i--)
        {
            int tmp = (1 << i);
            if ((n & tmp) > (m & tmp))
            {
                break;
            }
            res |= (m & tmp);
        }
        return res;
    }

    void RunTest()
    {
        int res = rangeBitwiseAnd(5, 7);
        cout << res << endl;
    }
}; 
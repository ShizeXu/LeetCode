#include <iostream>
#include <unordered_set>
using namespace std;

class P_202 {
public:
    bool isHappy(int n) {
        unordered_set<int> tmp;
        while (true)
        {
            int newN = 0;
            while (n > 0)
            {
                int num = n%10;
                newN += num*num;
                n = n / 10;
            }
            
            if (newN == 1) return true;
            else if (tmp.find(newN) != tmp.end()) return false;

            tmp.insert(newN);
            n = newN;
        }
    }

    void RunTest()
    {
        cout << isHappy(18) << endl;
    }
};
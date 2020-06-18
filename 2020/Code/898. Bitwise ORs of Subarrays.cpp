#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

class P_898 {
public:
    int subarrayBitwiseORs(vector<int>& A) {
        unordered_set<int> res;
        unordered_set<int> curSet;
        unordered_set<int> tmpSet;
        curSet.insert(0);
        for (int i = 0; i < A.size(); ++i)
        {
            tmpSet.insert(A[i]);
            res.insert(A[i]);

            // Expect the size of this set to be much smaller then i
            for (auto j = curSet.begin(); j != curSet.end(); ++j)
            {
                int x = A[i] | (*j);
                tmpSet.insert(x) ;
                res.insert(x);
            }

            curSet.clear();

            // This function calls unordered_set::swap, which exchanges internal pointers to data between two sets.
            swap(curSet, tmpSet);
        }

        return res.size();
    }

    void RunTest()
    {
        vector<int> A = {1, 2, 4};
        cout << subarrayBitwiseORs(A) << endl;
    }
};
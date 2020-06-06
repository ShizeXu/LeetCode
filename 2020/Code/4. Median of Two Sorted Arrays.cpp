#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class P_4 {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2)
    {
        int n1 = nums1.size(), n2 = nums2.size();
        int l = 0, r = n1 - 1;
        int k = (n1 + n2 - 1) / 2;
        while (l <= r)
        {
            int m1 = (l + r) / 2;
            int m2 = k - m1;
            if (m2 < 0 || (m2 < n2 && nums2[m2] < nums1[m1]))
            {
                r = m1 - 1;
            }
            else if (m2 > n2 || (m2 > 0 && nums2[m2 - 1] > nums1[m1]))
            {
                l = m1 + 1;
            }
            else //if ((m2 == n2 || nums2[m2] >= nums1[m1]) && (m2 == 0 || nums2[m2-1] <= nums1[m1]))
            {
                // Satisfied
                if ((n1 + n2) % 2 == 1)
                {
                    // Odd
                    return (double)nums1[m1];
                }
                else
                {
                    // Even
                    int other;
                    if (m2 == n2) other = nums1[m1 + 1];
                    else if (m1 + 1 == n1) other = nums2[m2];
                    else other = min(nums1[m1 + 1], nums2[m2]);

                    return ((double)nums1[m1] + other) / 2.0;
                }
            }
        }

        return findMedianSortedArrays(nums2, nums1);
    }

    void RunTest()
    {
        vector<int> nums1 = {1, 2};
        vector<int> nums2 = {3, 4};
        double res = findMedianSortedArrays(nums1, nums2);
        cout << res << endl;
    }
}; 
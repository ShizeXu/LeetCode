// Hello.cpp : Defines the entry point for the console application.
//


#include "stdafx.h"
#include<iostream>
#include<math.h>
using namespace std;

/**
目标：判断所给的圆是否存在交集（面积非零）。

先开一条竖直的扫描线。由于圆是凸集，所以任意多个圆的交集仍然为凸。
也就是说，交集位置最多就是三种可能：扫描线的左侧、扫描线的右侧、与线相交。跨越是不可能的。

不管这个扫描线在什么地方，我们都可以在O(n)的时间内计算出它与n个圆相交的区间。
我们设第k个圆的区间的上端点为k+，下端点为k-。
我们会发现，如果扫描线正好打到交集的话，此时顶点的排列形式一定是a+ b+ c+ .. p+ q- ... x- y- z-。
也就是说任何一个区间的起始点，都一定在任何一个区间的终点上方。
如果出现了种情况，我们可以立即判定交集存在。
否则的话，也就是说存在一个区间，它的终点在另一个区间起点的上方。

令这两个区间对应的远为A与B。此时我们可以肯定没有打到交集，但是很容易的知道以下三个事实：
(1) n个圆的总交集一定包含在A与B的交集内。
(2) A与B若无交集，则答案必然不存在。
(3) A与B若有交集，交集位于线的哪一侧可以很容易的计算出来。
所以我们会发现，这时我们可以完全确定总交集和线的位置关系，究竟是在线的哪一侧。
（注：判断方法为检查两圆两个交点连线的中点在扫描线的哪一侧）

所以根据这个思想，可以设计一个二分算法。
考虑可行区间[Xmin, Xmax]，每次取中间位置mid，在这个位置上放扫描线。
检测一下交集和线的位置关系，然后根据结果在相应的半个区间上继续查询就好了。
（注：终止结果为区间大小小于某一个阈值）

这个算法每次检测的时间是O(n)，因为只要算一下最下方的起点和最上方的终点位置就好了。
所以总的复杂度是O(n lgL)。
**/

bool hasOverlap(double x[], double y[], double r[], int n) {
	double lr = 1000000000;
	double rr = -1000000000;
	for (int i = 0; i < n; i++) {
		if(x[i] < lr) lr = x[i];
		if(x[i] > rr) rr = x[i];
	}

	bool lFlag = false;
	bool rFlag = false;
	double upper = 1000000000;
	double lower = -1000000000;
	int upIndex = 0;
	int lowIndex = 0;
	do {
		double cur = (lr + rr)/2.0;
		lFlag = false;
		rFlag = false;
		upper = 1000000000;
		lower = -1000000000;
		for(int i=0; i<n; i++) {
			if(x[i]+r[i]<=cur) { // shift left
				lFlag = true;
			}
			else if(x[i]-r[i]>=cur) { // shift right
				rFlag = true;
			}
			else { // has two point
				double tmp = sqrt((double)(r[i]*r[i]-(cur-x[i])*(cur-x[i])));
				if(y[i]+tmp<upper) {
					upper = y[i]+tmp;
					upIndex = i;
				}
				if(y[i]-tmp>lower) {
					lower = y[i]-tmp;
					lowIndex = i;
				}
			}
		}
		if(lFlag && rFlag) {
			return false;
		}
		else if(lFlag) rr = cur; // shift left
		else if(rFlag) lr = cur; // shift right
		else {	// all has two point
			if(upper > lower) {	// key condition
				return true;
			}
			// calcuate the length between two circles
			double leng = (x[upIndex]-x[lowIndex])*(x[upIndex]-x[lowIndex]) + (y[upIndex]-y[lowIndex])*(y[upIndex]-y[lowIndex]);
			if(leng >= (r[upIndex]+r[lowIndex])*(r[upIndex]+r[lowIndex])) { // has no intersection
				return false;
			}
			// decide the mid point of the intersecting segment is on which side, with specific formula
			double d = (r[upIndex]*r[upIndex] - r[lowIndex]*r[lowIndex] + leng) / (2.0*sqrt(leng));
			if((double)x[upIndex]+((double)(x[lowIndex]-x[upIndex]))*d/sqrt(leng) > cur) lr = cur; // shift right
			else rr = cur; // shift left
		}
	} while(rr-lr>0.1);
	return false;
}
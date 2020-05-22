// Hello.cpp : Defines the entry point for the console application.
//


/*
*  题目要求：判断线段是否跟矩形相交 
*  注意：线段完全在矩形内也是相交 
*  解法：分别判断线段是否跟矩形的四条边相交，再判断线段的两个端点是否都在矩形内 
*/

#include <cstdio>
#include <cstdlib>
#include <iostream>

using namespace std;

struct point {
	double x;
	double y;
}A, B, C, D, E, F;

double crossProd(point A, point B, point C) {
	return (B.x-A.x)*(C.y-A.y) - (B.y-A.y)*(C.x-A.x);  //AB与AC叉乘，>0说明AB在AC的顺时针，<0在逆时针，=0则共线
}

bool segIntersect(point A, point B, point C, point D) {//判断线段是否相交 
	if (max(A.x, B.x) >= min(C.x, D.x) &&
		max(C.x, D.x) >= min(A.x, B.x) &&
		max(A.y, B.y) >= min(C.y, D.y) &&
		max(C.y, D.y) >= min(A.y, B.y) &&
		crossProd(C, D, A)*crossProd(C, B, D)>=0 &&
		crossProd(A, B, C)*crossProd(A, D, B)>=0) return true;  //必须要互相判断
	return false;
}

bool pointInRectangle(point S, point A, point B) {//判断点是否在矩形内 
	if (max(A.x, B.x) >= S.x &&
		min(A.x, B.x) <= S.x &&
		max(A.y, B.y) >= S.y &&
		min(A.y, B.y) <= S.y) return true;
	return false;
}

bool segXRectangle() {
	if (segIntersect(A, B, C, E)) return true;//判断线段是否跟矩形的边相交 
	else if (segIntersect(A, B, C, F)) return true;
	else if (segIntersect(A, B, D, E)) return true;
	else if (segIntersect(A, B, D, F)) return true;
	if (pointInRectangle(A, C, D) && pointInRectangle(B, C, D)) return true;//判断线段的两端点是否都在矩形内 
	return false;
}

int main() {
	int t;
	scanf ("%d", &t);
	while (t--) {
		scanf ("%lf%lf%lf%lf%lf%lf%lf%lf", &A.x, &A.y, &B.x, &B.y, &C.x, &C.y, &D.x, &D.y);
		E.x = C.x;
		E.y = D.y;
		F.x = D.x;
		F.y = C.y;
		bool yes = segXRectangle();
		if (yes) printf ("T\n");
		else printf ("F\n");
	}
	return 0;
}
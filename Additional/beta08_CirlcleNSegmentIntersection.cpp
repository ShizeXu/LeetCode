// Hello.cpp : Defines the entry point for the console application.
//


/*
*  ��ĿҪ���ж��߶��Ƿ�������ཻ 
*  ע�⣺�߶���ȫ�ھ�����Ҳ���ཻ 
*  �ⷨ���ֱ��ж��߶��Ƿ�����ε��������ཻ�����ж��߶ε������˵��Ƿ��ھ����� 
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
	return (B.x-A.x)*(C.y-A.y) - (B.y-A.y)*(C.x-A.x);  //AB��AC��ˣ�>0˵��AB��AC��˳ʱ�룬<0����ʱ�룬=0����
}

bool segIntersect(point A, point B, point C, point D) {//�ж��߶��Ƿ��ཻ 
	if (max(A.x, B.x) >= min(C.x, D.x) &&
		max(C.x, D.x) >= min(A.x, B.x) &&
		max(A.y, B.y) >= min(C.y, D.y) &&
		max(C.y, D.y) >= min(A.y, B.y) &&
		crossProd(C, D, A)*crossProd(C, B, D)>=0 &&
		crossProd(A, B, C)*crossProd(A, D, B)>=0) return true;  //����Ҫ�����ж�
	return false;
}

bool pointInRectangle(point S, point A, point B) {//�жϵ��Ƿ��ھ����� 
	if (max(A.x, B.x) >= S.x &&
		min(A.x, B.x) <= S.x &&
		max(A.y, B.y) >= S.y &&
		min(A.y, B.y) <= S.y) return true;
	return false;
}

bool segXRectangle() {
	if (segIntersect(A, B, C, E)) return true;//�ж��߶��Ƿ�����εı��ཻ 
	else if (segIntersect(A, B, C, F)) return true;
	else if (segIntersect(A, B, D, E)) return true;
	else if (segIntersect(A, B, D, F)) return true;
	if (pointInRectangle(A, C, D) && pointInRectangle(B, C, D)) return true;//�ж��߶ε����˵��Ƿ��ھ����� 
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
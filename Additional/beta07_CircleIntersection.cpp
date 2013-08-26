// Hello.cpp : Defines the entry point for the console application.
//


#include "stdafx.h"
#include<iostream>
#include<math.h>
using namespace std;

/**
Ŀ�꣺�ж�������Բ�Ƿ���ڽ�����������㣩��

�ȿ�һ����ֱ��ɨ���ߡ�����Բ��͹��������������Բ�Ľ�����ȻΪ͹��
Ҳ����˵������λ�����������ֿ��ܣ�ɨ���ߵ���ࡢɨ���ߵ��Ҳࡢ�����ཻ����Խ�ǲ����ܵġ�

�������ɨ������ʲô�ط������Ƕ�������O(n)��ʱ���ڼ��������n��Բ�ཻ�����䡣
�������k��Բ��������϶˵�Ϊk+���¶˵�Ϊk-��
���ǻᷢ�֣����ɨ�������ô򵽽����Ļ�����ʱ�����������ʽһ����a+ b+ c+ .. p+ q- ... x- y- z-��
Ҳ����˵�κ�һ���������ʼ�㣬��һ�����κ�һ��������յ��Ϸ���
�������������������ǿ��������ж��������ڡ�
����Ļ���Ҳ����˵����һ�����䣬�����յ�����һ�����������Ϸ���

�������������Ӧ��ԶΪA��B����ʱ���ǿ��Կ϶�û�д򵽽��������Ǻ����׵�֪������������ʵ��
(1) n��Բ���ܽ���һ��������A��B�Ľ����ڡ�
(2) A��B���޽�������𰸱�Ȼ�����ڡ�
(3) A��B���н���������λ���ߵ���һ����Ժ����׵ļ��������
�������ǻᷢ�֣���ʱ���ǿ�����ȫȷ���ܽ������ߵ�λ�ù�ϵ�����������ߵ���һ�ࡣ
��ע���жϷ���Ϊ�����Բ�����������ߵ��е���ɨ���ߵ���һ�ࣩ

���Ը������˼�룬�������һ�������㷨��
���ǿ�������[Xmin, Xmax]��ÿ��ȡ�м�λ��mid�������λ���Ϸ�ɨ���ߡ�
���һ�½������ߵ�λ�ù�ϵ��Ȼ����ݽ������Ӧ�İ�������ϼ�����ѯ�ͺ��ˡ�
��ע����ֹ���Ϊ�����СС��ĳһ����ֵ��

����㷨ÿ�μ���ʱ����O(n)����ΪֻҪ��һ�����·����������Ϸ����յ�λ�þͺ��ˡ�
�����ܵĸ��Ӷ���O(n lgL)��
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
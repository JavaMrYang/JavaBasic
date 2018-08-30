package com.person.math.sort;

public class Mpsort {
public static void sort(int[] data) {
	int length=data.length;
	if(length<=1) return;
	for(int i=0;i<length;i++) {
		for(int j=0;j<length-1-i;j++) {
			if(data[j]>data[j+1]) {
				int temp=data[j+1];
				data[j+1]=data[j];
				data[j]=temp;
			}
		}
	}
}
public static int serachHalf(int[] arr,int target) {
	int left=0,right=arr.length-1;
	while(left<=right) {
		int middle=(left+right)/2;
		if(arr[middle]==target) {
			return middle;
		}else if(target<arr[middle]) {
			right=middle-1;
		}else {
			left=middle+1;
		}
	}
	return -1;
}
public static void main(String[] args) {
	int data[]= {1,4,5,8,2,41,36,21};
	selectsort(data);
	System.out.println(serachHalf(data, 8));
	for(int i:data) 
		System.out.print(i+",");
}
public static void insertsort(int[] data) {
	int length=data.length;
	if(length<=1) return;
	for(int i=1;i<length;i++) {
		int j=i-1;
		int key=data[i];
		while(j>=0&&key<data[j]) {
			data[j+1]=data[j];
			j--;
		}
		data[j+1]=key;
	}
}

public static void selectsort(int[] data) {
	int length=data.length;
	if(length<=1) return;
	for(int i=0;i<length;i++) {
		int min=i;
		for(int j=length-1;j>i;j--) {
			if(data[j]<data[min]) 
				min=j;
		}
			int temp=data[i];
			data[i]=data[min];
			data[min]=temp;
	}
}
}

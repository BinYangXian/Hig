package com.cdsxt.customer.po;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		// myAbsComparator();
//		printNum(2, 5000);
		System.out.println(countAge(1,3));
	}

	private static void myAbsComparator() {
		// 产生一个20个随机整数的数组（有正有负）
		Random rnd = new Random();
		Integer[] integers = new Integer[20];
		for (int i = 0; i < integers.length; i++)
			integers[i] = new Integer(rnd.nextInt(100) * (rnd.nextBoolean() ? 1 : -1));
		System.out.println("用Integer内置方法排序：");
		Arrays.sort(integers);
		System.out.println(Arrays.asList(integers));

		System.out.println("用AbsComparator排序：");
		Arrays.sort(integers, new AbsComparator());
		System.out.println(Arrays.asList(integers));
	}

	static void printNum(int x, int limit) {
		System.out.println(x);
		x = x * 2;
		if (x <= limit) {
			printNum(x, limit);
		}
	}
	static int countAge(int start,int end){
		int sum=0;
		for (int i = start; i <= end; i++) {
			sum+=i;
		}
		return sum;
	}
}

class ThreadB extends Thread {
	int total;

	public void run() {
		synchronized (this) {
			System.out.println("ThreadB is running..");
			notify();
			for (int i = 0; i <= 100000000; i++) {
				total += i;
			}
			System.out.println("total is " + total);
		}
	}
}

class A implements Comparator<ThreadB> {
	int total;

	public void run() {
		synchronized (this) {
			System.out.println("ThreadB is running..");
			notify();
			for (int i = 0; i <= 100000000; i++) {
				total += i;
			}
			System.out.println("total is " + total);
		}
	}

	@Override
	public int compare(ThreadB o1, ThreadB o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class C implements Comparable<ThreadB> {
	int total;

	public void run() {
		synchronized (this) {
			System.out.println("ThreadB is running..");
			notify();
			for (int i = 0; i <= 100000000; i++) {
				total += i;
			}
			System.out.println("total is " + total);
		}
	}

	@Override
	public int compareTo(ThreadB o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + total;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		C other = (C) obj;
		if (total != other.total)
			return false;
		return true;
	}

}

class AbsComparator implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		int v1 = Math.abs(((Integer) o1).intValue());
		int v2 = Math.abs(((Integer) o2).intValue());
		return v1 > v2 ? 1 : (v1 == v2 ? 0 : -1);
	}

}

interface D {
	int x = 1;
}

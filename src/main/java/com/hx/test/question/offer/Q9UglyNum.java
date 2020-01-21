package com.hx.test.question.offer;

import java.util.Date;

public class Q9UglyNum {
	private Date date = new Date(1000000000);

	@Override
	public String toString() {
		return "Q9UglyNum [date=" + date + "]";
	}

	public static int GetUglyNumber_Solution(int index) {
		if (index <= 0) {
			return 0;
		}
		int[] arr = new int[index];
		int p2 = 0, p3 = 0, p5 = 0, num = 1;
		int temp = 0;
		arr[0] = num;
		while (temp < index - 1) {
			num = Math.min(arr[p2] * 2, Math.min(arr[p3] * 3, arr[p5] * 5));
			if (num == arr[p2] * 2)
				p2++;
			if (num == arr[p3] * 3)
				p3++;
			if (num == arr[p5] * 5)
				p5++;
			arr[++temp] = num;
		}
		return num;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {

			System.out.println(GetUglyNumber_Solution(i));
		}
	}

}

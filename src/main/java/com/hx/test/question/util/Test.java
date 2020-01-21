package com.hx.test.question.util;

import java.io.FileWriter;

public class Test {
	public static void main(String[] args) {

		// try (FileReader fr = new FileReader("D:/add3.txt"); BufferedReader br
		// = new BufferedReader(fr);) {
		// int temp;
		// String str = null;
		// int arr[] = new int[1000000];
		// int heap[] = new int[50001];
		// int index = 0;
		// long begin3 = System.currentTimeMillis();
		// while ((str = br.readLine()) != null) {
		// temp = Integer.valueOf(str);
		// arr[index] = temp;
		// index++;
		//
		// }
		// for (int i = 1; i < 50001; i++) {
		// heap[i] = arr[i - 1];
		// }
		// adJustMinHeap(heap, 1, heap.length - 1);
		// for (int i = 50000; i < arr.length; i++) {
		// if (arr[i] <= heap[1]) {
		// continue;
		// } else {
		// heap[1] = arr[i];
		// adJustMinHeap(heap, 1, heap.length - 1);
		// }
		// }
		// int count = 0;
		// for (int i = 0; i < 50001; i++) {
		// if (heap[i] == 0)
		// count++;
		// }
		//
		// System.out.println(JSON.toJSON(heap));
		// long end3 = System.currentTimeMillis();
		// System.out.println("FileReader执行耗时:" + (end3 - begin3) + " 豪秒");
		// Arrays.sort(arr);
		// System.out.println(arr[0] + "!!!!!!!!" + arr[949999] + "!!!!!" +
		// arr[945000]);
		// System.out.println(count);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		int[] arr = { 0, 50, 10, 90, 30, 70, 40, 80, 600, 20 };
		heapSort(arr);

		// int[] heap = new int[6];
		// for (int i = 1; i < 6; i++) {
		// heap[i] = arr[i - 1];
		// }
		// adJustMinHeap(heap, 1, heap.length - 1);
		// for (int i = 5; i < arr.length; i++) {
		// if (arr[i] <= heap[1]) {
		// continue;
		// } else {
		// heap[1] = arr[i];
		// adJustMinHeap(heap, 1, heap.length - 1);
		// }
		// }
		// System.out.println(JSON.toJSONString(heap));
	}

	private static void heapSort(int[] arr) {
		int l = arr.length - 1;
		for (int i = l / 2; i > 0; i--) {
			adJustMaxHeap(arr, i, l);
		}
		// for (int i = l; i > 1; i--) {
		// SortUtils.swap(arr, 1, i);
		// adJustMaxHeap(arr, 1, i - 1);
		// }
	}

	private static void heapSort1(int[] arr) {
		int l = arr.length - 1;
		for (int i = l / 2; i > 0; i--) {
			adJustMinHeap(arr, i, l);
		}
		for (int i = l; i > 1; i--) {
			SortUtils.swap(arr, 1, i);
			adJustMinHeap(arr, 1, i - 1);
		}
	}

	private static void adJustMaxHeap(int[] arr, int s, int m) {
		int t = arr[s];
		for (int i = 2 * s; i <= m; i *= 2) {
			if (i < m && arr[i] < arr[i + 1]) {
				i++;
			}
			if (t > arr[i]) {
				break;
			}
			arr[s] = arr[i];
			s = i;

		}
		arr[s] = t;
	}

	private static void adJustMinHeap(int[] arr, int s, int m) {
		int t = arr[s];
		for (int i = 2 * s; i <= m; i *= 2) {
			if (i < m && arr[i] > arr[i + 1]) {
				i++;
			}
			if (t < arr[i]) {
				break;
			}
			arr[s] = arr[i];
			s = i;
		}
		arr[s] = t;
	}

	@SuppressWarnings("unused")
	private static void madeData() {

		int count = 1000000;// 写文件行数
		try (FileWriter fw = new FileWriter("D:/add3.txt");) {
			int temp = (int) (Math.random() * 1000000);
			long begin3 = System.currentTimeMillis();
			for (int i = 0; i < count; i++) {
				temp = (int) (Math.random() * 1000000);
				fw.write(temp + "\r\n");
			}

			long end3 = System.currentTimeMillis();
			System.out.println("FileWriter执行耗时:" + (end3 - begin3) + " 豪秒");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

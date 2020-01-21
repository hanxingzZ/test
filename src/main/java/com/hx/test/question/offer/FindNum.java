package com.hx.test.question.offer;

/**
 * 
 * @description: 
 *               在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数
 *               ，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月5日 下午4:27:06
 * @version 1.0
 */
public class FindNum {

	public static boolean find(int[][] array, int target) {
		int l1 = array.length;
		if (l1 == 0) {
			return false;
		}
		int index = 0;
		int l2 = array[0].length - 1;
		while (l2 >= 0 && index < l1) {
			if (array[index][l2] > target) {
				l2--;
			} else if (array[index][l2] < target) {
				index++;
			} else {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

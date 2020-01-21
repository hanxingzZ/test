package com.hx.test.question.offer;

/**
 * 
 * @description: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are
 *               Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月5日 下午4:50:21
 * @version 1.0
 */
public class ReplaceSpace {

	public static String replaceSpace(StringBuffer str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i) == ' ' ? "%20" : str.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(replaceSpace(new StringBuffer("We Are Happy.")));

	}

}

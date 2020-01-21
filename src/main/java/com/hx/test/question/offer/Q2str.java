package com.hx.test.question.offer;
/**
 * 
 * 替换空格
 *
 */
public class Q2str {
	public static String replaceSpace(StringBuffer str) {
		if(str == null){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)==' '){
				sb.append("%20");
			}else{
				sb.append(str.charAt(i));
			}
		}

		return sb.toString();

	}

	public static void main(String[] args) {
		System.out.println(replaceSpace(new StringBuffer("  ")));

	}

}

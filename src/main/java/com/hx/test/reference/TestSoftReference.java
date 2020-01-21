package com.hx.test.reference;

import java.lang.ref.SoftReference;

public class TestSoftReference {

	public static void main(String[] args) {
		String str = new String("测试软引用");
		// 创建一个弱引用，让这个软引用引用到字符串
		SoftReference<String> weakReference = new SoftReference<>(str);
		// 切断str引用和字符串之间的引用
		str = null;
		// 取出软引用所引用的对象
		System.out.println(weakReference.get());
		// 强制进行垃圾回收
		System.gc();
		System.runFinalization();
		// 再次取出软引用所引用的对象
		System.out.println(weakReference.get());

	}

}

package com.hx.test.reference;

import java.lang.ref.WeakReference;

public class TestWeakReference {

	public static void main(String[] args) {
		String str = new String("测试弱引用");
		// 创建一个弱引用，让这个弱引用引用到字符串
		WeakReference<String> weakReference = new WeakReference<>(str);
		// 切断str引用和字符串之间的引用
		str = null;
		// 取出弱引用所引用的对象
		System.out.println(weakReference.get());
		// 强制进行垃圾回收
		System.gc();
		System.runFinalization();
		// 再次取出弱引用所引用的对象
		System.out.println(weakReference.get());

	}

}

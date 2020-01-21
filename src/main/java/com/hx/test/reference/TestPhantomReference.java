package com.hx.test.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class TestPhantomReference {

	public static void main(String[] args) {
		// 创建一个字符串引用
		String str = new String("测试虚引用");
		// 创建一个引用队列
		ReferenceQueue<?> referenceQueue = new ReferenceQueue<>();
		// 创建一个虚引用 让次虚引用引用到字符串
		@SuppressWarnings("unchecked")
		PhantomReference<String> phantomReference = new PhantomReference(str,
				referenceQueue);
		// 取出虚引用所引用的对象，并不能通过虚引用访问被引用的对象，
		// 所以此处输出的应该是null
		System.out.println(phantomReference.get());
		// 切断str和之间的引用关系
		str = null;
		// 强制进行垃圾回收
		System.gc();
		System.runFinalization();
		// 取出引用队列最先进入队列中的引用于phantomReference进行比较
		System.out.println(referenceQueue.poll() == phantomReference);

	}

}

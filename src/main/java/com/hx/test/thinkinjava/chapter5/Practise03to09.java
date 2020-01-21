package com.hx.test.thinkinjava.chapter5;

/**
 * 3.默认构造器的类，在构造器打印消息 4.重载构造器，接受一个字符串打印消息 5.Dog类 重载bark方法 打印不同类型的信息
 * 6.两个重载方法各自核实两个类型不同的参数并且顺序相反 7.没有构造器验证编译器是否工作 8.分别用this和不用this调用类中的另一个方法
 * 9.用this调用其他构造器，必须放在第一行即只能有一个
 * 
 * @author xingh
 *
 */
public class Practise03to09 {
	static class Dog {
		Dog() {
			System.out.println("it is a dog");
		}

		Dog(String color) {
			System.out.println("it is a " + color + " dog");
		}

		Dog(String color, String wehight) {
			this(color);
			System.out.println("it is a " + wehight + " dog");
		}

		/**
		 * 狗吠barking
		 * 
		 * @param a
		 * @param b
		 */
		public void bark(int a, float b) {
			System.out.println("the dog is barking");
		}

		/**
		 * 咆哮howling
		 * 
		 * @param a
		 * @param b
		 */
		public void bark(float a) {
			System.out.println("the dog is howling");
		}

		/**
		 * 狗吠barking
		 * 
		 * @param a
		 * @param b
		 */
		public void bark(int a) {
			System.out.println("the dog is barking");
		}

		/**
		 * 咆哮howling
		 * 
		 * @param a
		 * @param b
		 */
		public void bark(float a, int b) {
			System.out.println("the dog is howling");
		}

		public void thisBark(float a, int b) {
			bark(a, b);
			this.bark(a, b);
		}

	}

	static class Cat {

	}

	class Cat1 {

	}

	public static void main(String[] args) {
		Dog dog = new Dog();
		Dog dog1 = new Dog("black");
		Dog dog2 = new Dog("black", "80kg");
		dog.bark(1.0f);
		dog.bark(1);
		dog.bark(1.0f, 0);
		dog.bark(1, 0f);
		Cat cat = new Cat();

		Practise03to09 p1 = new Practise03to09();
		Cat1 c = p1.new Cat1();
		dog.thisBark(1f, 1);
	}
}

package com.hx.test.java8.inaction.stream.pojo;

import static java.util.Comparator.*;

import java.util.Comparator;

public class Point {

	private int x;

	private int y;

	public final static Comparator<Point> compareByXAndThenY = comparing(Point::getX).thenComparing(Point::getY);

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point moveRight(int x) {
		return new Point(this.x + x, this.y);
	}

}

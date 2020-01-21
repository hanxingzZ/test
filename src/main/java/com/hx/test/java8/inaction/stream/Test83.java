package com.hx.test.java8.inaction.stream;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.hx.test.java8.inaction.stream.pojo.Point;

/**
 * Description：
 *
 * @author 韩兴(13039997950@163.com)
 * @param:
 * @return:
 * @date: 2019/10/24  16:24
 */
public class Test83 {

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(12, 2));
        points.stream().map(p -> p.getX()).forEach(System.out::println);

    }

    @Test
    public void testMoveRight() {
        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRight(-10);
        assertEquals(5, p2.getX());
        assertEquals(5, p2.getY());
    }

    /**
     * Description：
     *
     * @author 韩兴(13039997950@163.com)
     * @param:
     * @return:
     * @date: 2019/10/24  16:24
     */
    @Test
    public void testCompare() {
        Point p1 = new Point(10, 15);
        Point p2 = new Point(10, 20);
        int result = Point.compareByXAndThenY.compare(p1, p2);
        assertEquals(-1, result);
        System.out.println("success");
    }

}

package test.primitivesTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import primitives.*;

public class RayTest {
    Ray testRay = new Ray(new Vector(1,1,1) , new Point(0, 0, 0));
    public ArrayList<Point> list = new ArrayList<Point>();
    @Test
    void testFindClosestPoint() {
        list.add(new Point(1,1,3));
        list.add(new Point(2,2,3));
        list.add(new Point(4,6,3));
        list.add(new Point(0,0,2));
        list.add(new Point(2,5,12));
        list.add(new Point(5,54,2));
        list.add(new Point(-4,5,-2.5));
    // ============ Equivalence Partitions Tests ==============
    assertEquals(testRay.findClosestPoint(list),new Point(0,0,2));
    // =============== Boundary Values Tests ==================
    // TC01: empty list
    assertNull(testRay.findClosestPoint(new ArrayList<Point>()));
    // TC02: the first point is the closest point
    list.add(new Point(0, 0, 1));
    assertEquals(testRay.findClosestPoint(list),new Point(0,0,1));
    // TC03: the last point is the closest point
    list.add(new Point(0, 0, 0.5));
    assertEquals(testRay.findClosestPoint(list),new Point(0,0,0.5));
    }
}

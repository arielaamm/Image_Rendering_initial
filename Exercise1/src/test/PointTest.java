package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Vector;

public class PointTest {
    Point p1 = new Point(2,4,5);
    Point p2 = new Point(3.5,4.4,4.5);
    Vector v1 = new Vector(2,4,5);
    Vector v2 = new Vector(3.5,4.4,4.5);
    /** 
     * @return 
     */
    @Test
    void testAdd() {
        assertEquals(new Point(5.5, 8.4, 9.5), p2.add(v1));
        assertEquals(new Point(5.5, 8.4, 9.5), p1.add(v2));
    }

    
    /** 
     * @return 
     */
    @Test
    void testDistance() {
        Point p1 = new Point(0,0,4);
        Point p2 = new Point(0,0,6);
        assertTrue(2 == p2.distance(p1));
        assertTrue(2 == p1.distance(p2));
    }

    
    /** 
     * @return 
     */
    @Test
    void testDistanceSquared() {
        Point p1 = new Point(0,0,4);
        Point p2 = new Point(0,0,6);
        assertTrue(4 == p2.distanceSquared(p1,p2));
        assertTrue(4 == p1.distanceSquared(p1,p2));
    } 
    /** 
     * @return 
     */
    /**
     * This function tests the subtract function
     */
    @Test
    void testSubtract() {
        assertEquals(new Point(1.5, 0.4, -0.5), p2.subtract(v1));
        assertEquals(new Point(-1.5, -0.4, 0.5), p1.subtract(v2));
    }

}

package test.geometriesTests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.Plane;
import primitives.*;

public class PlaneTest {
    Point p1 = new Point(29,78,2);
    Point p2 = new Point(5, -78, -7);
    Point p3 = new Point(1, 89, 1);

    Point p4 = new Point(1, 1, 1);
    Point p5 = new Point(2, 2, 2);

    Point coalesce_p1 =new Point(29,78,2);
    Point sameLine  = new Point(3,3,3);
    Plane p = new Plane(p1,p2,p3);

    @Test
    void testGetNormal() { 

        // ============ Equivalence Partitions Tests ==============
        assertEquals("normal u:" + new Vector(0.0549,0.04909,-0.99728).normalize().length() + " normal code:" + p.getNormal(p1).length(),new Vector(0.0549,0.04909,-0.99728).normalize(), p.getNormal(p1));

    }

    @Test
    void testPlane() {    
        // =============== Boundary Values Tests ==================
        assertThrows(IllegalArgumentException.class, ()-> new Plane(coalesce_p1, p2, p1));
        assertThrows(IllegalArgumentException.class, ()-> new Plane(p4, p5,sameLine));
    }
  

    @Test
    void testGetQ0() {
        assertEquals(p1,p.getQ0());
    }
    @Test
    void testFindIntersections()
    {
        // ============ Equivalence Partitions Tests ==============
        // TC-EP: Ray to the plane (1 point)
        Point point = new Point(-6.6043,-10.3456,-4.2641);
        List<Point> result = p.findIntersections(new Ray(new Vector(2d, -9d, -2.5), new Point(-12, 14, 2.5)));
        assertEquals(1, result.size(), "Wrong number of points");
        assertEquals(List.of(point), result, "Ray crosses sphere");

        // =============== Boundary Values Tests ==================
        // TC-BVA: Ray to the point that creates the plane 
        point = new Point(4.8324,-77.5499,-6.9449000000000005);
        result = p.findIntersections(new Ray(new Vector(7.14d, -38.65d, -3.99), new Point(-12, 14, 2.5)));
        assertEquals(1, result.size(), "Wrong number of points");
        assertEquals(List.of(point), result, "Ray crosses sphere");
    }
}

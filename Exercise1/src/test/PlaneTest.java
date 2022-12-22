package test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import geometries.Plane;
import primitives.Point;
import primitives.Vector;

public class PlaneTest {
    Point p1 = new Point(29,78,2);
    Point p2 = new Point(5, -78, -7);
    Point p3 = new Point(1, 89, 1);

    Point p4 = new Point(1, 1, 1);
    Point p5 = new Point(2, 2, 2);

    Point coalesce_p1 =new Point(29,78,2);
    Point sameLine  = new Point(3,3,3);

    @Test
    void testGetNormal() { 
          Plane p = new Plane(p1,p2,p3);

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
        // assertEquals("",p1,p.getQ0());
    }
}

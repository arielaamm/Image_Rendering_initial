package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import geometries.Tube;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class TubeTest {
    Tube t = new Tube(new Ray(new Vector(2, 2, 2), new Point(0, 0, 0)), 3);
    @Test
    void testGetAxisRay() {
        assertEquals(new Ray(new Vector(2, 2, 2), new Point(0, 0, 0)),t.getAxisRay());
    }
// the P is new Point(0,3.67,0) 
    @Test
    void testGetNormal() {
        //TODO todo the testGetNormal for tube
    }

    @Test
    void testGetRadius() {
        assertTrue( t.getRadius() == 3);
    }
}

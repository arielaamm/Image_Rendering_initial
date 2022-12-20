package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import geometries.Cylinder;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class CylinderTest {
    Cylinder c = new Cylinder(new Ray(new Vector(2, 2, 2), new Point(0, 0, 0)), 3,3);
    @Test
    void testGetHeight() {
        assertTrue(3 == c.getHeight());
    }

    @Test
    void testGetNormal() {
        
    }
}

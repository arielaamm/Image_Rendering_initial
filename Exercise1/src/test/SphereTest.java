package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import geometries.Sphere;
import primitives.Point;

public class SphereTest {
    Sphere s = new Sphere(new Point(2,2,2),3);
    @Test
    void testGetCenter() {
        assertEquals(new Point(2, 2, 2), s.getCenter());
    }

    @Test
    void testGetNormal() {
        assertEquals((new Point(0, 3, 0)).subtract(new Point(2, 2, 2)).normalize(), s.getNormal(new Point(0, 3, 0)));
    }

    @Test
    void testGetRadius() {
        assertTrue(3 == s.getRadius());
    }


}

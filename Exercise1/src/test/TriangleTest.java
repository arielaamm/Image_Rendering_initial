package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import geometries.Triangle;
import primitives.Point;
import primitives.Vector;

public class TriangleTest {

    Triangle t = new Triangle(new Point(0, 0, 0),new Point(1, 0, 1),new Point(0, 2, 2));

    @Test
    void testGetNormal() {
        assertEquals(new Vector(-2.0,-2.0,2.0).normalize(),t.getNormal(new Point(0, 0, 0)));
    }
}

package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import geometries.Plane;
import primitives.Point;

public class PlaneTest {
    Plane p = new Plane(
        new Point(2,0,2),
        new Point(0, 0, 0),
        new Point(1, 1, 0)
    );
    @Test
    void testGetNormal() {
        assertEquals(
                    (new Point(2,0,2)).subtract(
                     new Point(0,0,0))
                     .crossProduct(
                     new Point(1,1,0).subtract(
                     new Point(0,0,0))).normalize()
            , p.getNormal(new Point(2,0,2)));
    }

    @Test
    void testGetQ0() {
        assertEquals(new Point(2,0,2),p.getQ0());
    }


}

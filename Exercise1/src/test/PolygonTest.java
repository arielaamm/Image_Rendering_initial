package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import geometries.Polygon;
import primitives.Point;

public class PolygonTest {
    Polygon p = new Polygon(
        new Point(2,2,2),
        new Point(2,3,1),
        new Point(3,0,4),
        new Point(7,3,4)
    );
    /** 
     * @return 
     */
    @Test
    void testGetNormal() {
        assertEquals(
                    (new Point(2,2,2)).subtract(
                     new Point(2,3,1))
                     .crossProduct(
                     new Point(3,0,4).subtract(
                     new Point(2,3,1))).normalize()
            , p.getNormal(new Point(2,2,2)));
    }
}

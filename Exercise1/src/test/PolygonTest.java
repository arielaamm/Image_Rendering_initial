package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import geometries.Polygon;
import primitives.Point;
import primitives.Vector;

public class PolygonTest {

    /**
     * @return
     */
    @Test
    void testGetNormal() {
        Polygon p = new Polygon(
                new Point(1, 1, 0),
                new Point(2, 2, 0),
                new Point(3, 1, 0),
                new Point(3, 0, 0),
                new Point(1, -1, 0));
        Vector expectedNormal = new Vector(0.0, 0.0, 1.0);
        Vector actualNormal = p.getNormal(new Point(1, 1, 0));
        assertEquals(expectedNormal, actualNormal);
        // Polygon p = new Polygon(
        // new Point(1, 1, 1),
        // new Point(2, 2, 0),
        // new Point(3, 1, 0),
        // new Point(2, 0, 0),
        // new Point(1, -1, 0));
        // assertEquals(new Vector (0.577, 0.577, 0.577).normalize(), p.getNormal(new
        // Point(1, 1, 2)));
    }
}

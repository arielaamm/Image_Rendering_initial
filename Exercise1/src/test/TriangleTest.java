package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import geometries.Triangle;
import primitives.Point;
import primitives.Vector;

public class TriangleTest {


    @Test
    void testGetNormal() {    
        
        
        Triangle t = new Triangle(new Point(-8,3,2),new Point(-4,6,1),new Point(-7,4,-1));

        assertEquals(new Vector(-0.5865,0.8065,0.0733).normalize(),t.getNormal(new Point(-8,3,2)));
    }
}

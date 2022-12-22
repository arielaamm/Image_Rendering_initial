package geometries;

import primitives.Point;
import primitives.Vector;

public class Triangle extends Polygon{

    public Triangle(Point point1, Point point2, Point point3) {
        super(point1, point2, point3);
    }
    
    /** 
     * @param p
     * @return  normal {@link Vector}
     */
    @Override
    public Vector getNormal(Point p) {
        return super.getNormal(p);
    }

    
    /** 
     * @return 
     */
    @Override
    public String toString() {
        return "Triangle " + super.toString();
    }
   
    
}

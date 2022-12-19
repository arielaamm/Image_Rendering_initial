package geometries;

import primitives.Point;
import primitives.Vector;

public class Triangle extends Polygon{

    public Triangle(Point point1, Point point2, Point point3) {
        //TODO: חסר הקוד שמשלים נמצא בקבצים שמודל

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

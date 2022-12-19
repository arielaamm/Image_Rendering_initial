package geometries;

import primitives.*;

public class Plane implements Geometry {
    private Point q0;
    private Vector normal;

    public Plane(Point point1, Point point2, Point point3) {
        normal = null;
        q0 = point1;
    }

    public Plane(Vector v, Point p) {
        q0 = p;
        normal = v.normalize();
    }

    
    /** 
     * @return normal {@link Vector}
     */
    public Vector getNormal() {
        return normal;
    }

    
    /** 
     * @param p
     * @return  normal {@link Vector}
     */
    public Vector getNormal(Point p) {
        return getNormal();
    }

    
    /** 
     * @return q0 {@link Point}
     */
    public Point getQ0() {
        return q0;
    }

    
    /** 
     * @return 
     */
    @Override
    public String toString() {
        return "Plane [q0=" + q0 + ", normal=" + normal + "]";
    }

}

package geometries;

import java.util.List;

import primitives.*;

public class Tube extends Geometry {
    protected Ray axisRay;
    protected double radius;

    public Tube(Ray axisRay, double radius) {
        this.axisRay = axisRay;
        this.radius = radius;
    }

    
    /** 
     * @return axisRay {@link Ray}
     */
    public Ray getAxisRay() {
        return axisRay;
    }

    
    /** 
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    
    /** 
     * @param p
     * @return normal {@link Vector} 
     */
    public Vector getNormal(Point p) {

        Vector displacement = p.subtract(axisRay.getP0());
        double component = displacement.dotProduct( axisRay.getDir()) /  axisRay.getDir().length();
        if ( component != 0 ) {
            Vector projection = axisRay.getDir().scale(component);
            return (displacement).subtract(projection).normalize();
        }
        return displacement.normalize();

    }
    /** 
     * @return 
     */
    @Override
    public String toString() {
        return "Tube [axisRay=" + axisRay + ", radius=" + radius + "]";
    }


    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        // TODO Auto-generated method stub
        return null;
    }
}

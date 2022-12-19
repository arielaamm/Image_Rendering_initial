package geometries;

import primitives.*;

public class Tube implements Geometry {
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
        return null;
    }

    
    /** 
     * @return 
     */
    @Override
    public String toString() {
        return "Tube [axisRay=" + axisRay + ", radius=" + radius + "]";
    }
}

package geometries;

import primitives.*;

public class Sphere implements Geometry {
    private Point center;
    private double radius;

    public Sphere(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    
    /** 
     * @return center of the sphere {@link Point}
     */
    public Point getCenter() {
        return center;
    }
    
    /** 
     * @return radius of the sphere
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
        return "Sphere [center=" + center + ", radius=" + radius + "]";
    }


}

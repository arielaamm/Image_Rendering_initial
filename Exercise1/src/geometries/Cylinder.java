package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube {

    protected double height;

    public Cylinder(Ray axisRay, double radius, double height) {
        super(axisRay, radius);
        this.height = height;
    }

    /**
     * @param p
     * @return normal {@link Vector}.
     */
    @Override 
    public Vector getNormal(Point p) {
        return super.getNormal(p);
    }

    /**
     * @return height of the cylinder.
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Cylinder [height=" + height + "] " + super.toString();
    }

}

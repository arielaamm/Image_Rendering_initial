package geometries;

import java.util.List;

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
        Plane baseA = new Plane(axisRay.getDir(), axisRay.getP0());
        Plane baseB = new Plane(axisRay.getDir(), axisRay.getP0().add(axisRay.getDir().scale(height)));
        if (baseA.isOnPlane(p) && p.distance(axisRay.getP0()) <= 3) {
            return baseA.getNormal().scale(-1);
        } else if (baseB.isOnPlane(p) && p.distance(axisRay.getP0().add(axisRay.getDir().scale(height))) <= 3) {
            return baseB.getNormal();
        }
        return super.getNormal(p);
    }

    /**
     * @return height of the cylinder.
     */
    public double getHeight() {
        return height;
    }

    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Cylinder [height=" + height + "] " + super.toString();
    }

}

package geometries;

import java.util.LinkedList;
import java.util.List;
import primitives.Ray;

/*LinkedList is more like the structer that we build */
public class Geometries extends Intersectable {
    public List<Intersectable> intersecList;

    public Geometries() {
        intersecList = new LinkedList<Intersectable>();
    }

    public Geometries(Intersectable... geometries) {
        intersecList = new LinkedList<Intersectable>();
        for (Intersectable geometrie : geometries) {
            intersecList.add(geometrie);
        }
    }

    public void add(Intersectable... geometries) {
        for (Intersectable geometrie : geometries) {
            intersecList.add(geometrie);
        }
    }
    
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {

        List<GeoPoint> intersection = null;

        for (Intersectable geometry : this.intersecList) { // loop on all the geometry that implement "the Intersectables"
            // list of crossing point between the ray ana the geometry//
            var geoIntersections = geometry.findGeoIntersections(ray);
            if (geoIntersections != null) { // if there is a crossing
                if (intersection == null) {
                    intersection = new LinkedList<>();
                }
                intersection.addAll(geoIntersections);
            }
        }

        return intersection;
    }

}

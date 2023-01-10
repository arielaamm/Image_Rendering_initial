package geometries;

import java.util.LinkedList;
import java.util.List;

import primitives.Point;
import primitives.Ray;

/*LinkedList is more like the structer that we build */
public class Geometries implements Intersectable {
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
        intersecList = new LinkedList<Intersectable>();
        for (Intersectable geometrie : geometries) {
            intersecList.add(geometrie);
        }
    }

    @Override
    public List<Point> findIntersections(Ray ray) {
        List<Point> list = new LinkedList<Point>();
        List<Point> Templist = new LinkedList<Point>();
        for (Intersectable intersectable : intersecList) {
            Templist = intersectable.findIntersections(ray);
            if (Templist != null) {
                list.addAll(Templist);
            }
        }
        return list.size() == 0 ? null : list;
    }

}

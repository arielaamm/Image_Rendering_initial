package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Point;
import primitives.Ray;

/*LinkedList uses more memory than an ArrayList because it needs to store additional pointers to the next and previous elements in the list soo ArrayList */
public class Geometries implements Intersectable {
    public List<Intersectable> intersecList;

    public Geometries() {
        intersecList = new ArrayList<Intersectable>();
    }

    public Geometries(Intersectable... geometries) {
        intersecList = new ArrayList<Intersectable>();
        for (Intersectable geometrie : geometries) {
            intersecList.add(geometrie);
        }
    }

    public void add(Intersectable... geometries) {
        intersecList = new ArrayList<Intersectable>();
        for (Intersectable geometrie : geometries) {
            intersecList.add(geometrie);
        }
    }

    @Override
    public List<Point> findIntersections(Ray ray) {
        List<Point> list = new ArrayList<Point>();
        List<Point> Templist = new ArrayList<Point>();
        for (Intersectable intersectable : intersecList) {
            Templist = intersectable.findIntersections(ray);
            if (Templist != null) {
                list.addAll(Templist);
            }
        }
        return list.size() == 0 ? null : list;
    }

}

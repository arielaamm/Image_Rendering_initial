package geometries;
import primitives.*;

public abstract class Geometry extends Intersectable {
    public abstract Vector getNormal(Point p);
    protected Color emission = Color.BLACK;
    private Material material = new Material();
    
    public Material getMaterial() {
        return material;
    }

    public Geometry setMaterial(Material material) {
        this.material = material;
        return this;
    }

    /** 
     * @return emission
     */
    public Color getEmission() {
        return emission;
    }
    
    /** 
     * @param emission
     * @return the {@link Geometry} instance
     */
    public Geometry setEmission(Color emission) {
        this.emission = emission;
        return this;
    }
}

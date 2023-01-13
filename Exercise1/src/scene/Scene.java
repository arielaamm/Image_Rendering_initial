package scene;

import geometries.Geometries;
import lighting.AmbientLight;
import primitives.Color;

public class Scene {
    public String name;
    public Color background = Color.BLACK;
    public AmbientLight ambientLight = new AmbientLight();
    public Geometries geometries = new Geometries();

    /**
     * @param name - the name of the scene
     */
    public Scene(String name) {
        this.name = name;
        geometries = new Geometries();
    }

    
    /** 
     * @param background
     * @return this {@link Scene} instance
     */
    public Scene setBackground(Color background) {
        this.background = background;
        return this;
    }

    
    /** 
     * @param ambientLight
     * @return this {@link Scene} instance
     */
    public Scene setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }

    
    /** 
     * @param geometries   
     * @return this {@link Scene} instance
     */
    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }
}

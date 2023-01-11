package lighting;

import primitives.Color;
import primitives.Double3;

public class AmbientLight {

    Color intensity;
    /**
     * @param Ia - light intensity 
     * @param Ka - attenuation coefficient
     */
    public AmbientLight(Color Ia, Double3 Ka) {
        intensity = Ia.scale(Ka);
    }
    
    public AmbientLight() {
        intensity = Color.BLACK;
    }
    
    /** 
     * @return intensity {@link Color}
     */
    public Color getIntensity() {
        return intensity;
    }
}

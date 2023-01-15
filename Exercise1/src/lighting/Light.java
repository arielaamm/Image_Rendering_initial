package lighting;

import primitives.Color;

abstract class Light {
    private Color intensity;

    protected Light(Color color) {
        this.intensity = color;
    }

    /**
     * @return intensity {@link Color}
     */
    public Color getIntensity() {
        return this.intensity;
    }

}

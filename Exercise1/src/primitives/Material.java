package primitives;

public class Material {
    public Double3 kD = Double3.ZERO, kS = Double3.ZERO;
    public int nShininess = 0;

    public Material setKd(Double3 kD) {
        this.kD = kD;
        return this;
    }

    public Material setKs(Double3 kS) {
        this.kS = kS;
        return this;
    }

    public Material setKd(double kD) {
        this.kD = new Double3(kD);
        return this;
    }

    public Material setKs(double kS) {
        this.kS = new Double3(kS);
        return this;
    }

    public Material setShininess(int nShiniess) {
        this.nShininess = nShiniess;
        return this;
    }
}

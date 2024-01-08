package org.example;

public class Material {
    private Color color;
    private double ambient;
    private double diffuse;
    private double specular;
    private double shininess;

    public Material(Color color, double ambient, double diffuse, double specular, double shininess) {
        this.color = color;
        this.ambient = ambient;
        this.diffuse = diffuse;
        this.specular = specular;
        this.shininess = shininess;
    }

    public Material()
    {
        this.color = new Color("white");
        this.ambient = 0.1;
        this.diffuse = 0.9;
        this.specular = 0.9;
        this.shininess = 200;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || getClass() != obj.getClass()) return false;
        Material other = (Material) obj;

        return this.getColor().equals(other.getColor()) &&
                Math.abs(this.getAmbient() - other.getAmbient()) < 0.00001 &&
                Math.abs(this.getDiffuse() - other.getDiffuse()) < 0.00001 &&
                Math.abs(this.getShininess() - other.getShininess()) < 0.00001 &&
                Math.abs(this.getSpecular() - other.getSpecular()) < 0.00001;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getAmbient() {
        return ambient;
    }

    public void setAmbient(double ambient) {
        this.ambient = ambient;
    }

    public double getDiffuse() {
        return diffuse;
    }

    public void setDiffuse(double diffuse) {
        this.diffuse = diffuse;
    }

    public double getSpecular() {
        return specular;
    }

    public void setSpecular(double specular) {
        this.specular = specular;
    }

    public double getShininess() {
        return shininess;
    }

    public void setShininess(double shininess) {
        this.shininess = shininess;
    }

    public Color phongLighting(LightSource lightSource, Point surface, Vector spectator, Vector normal)
    {
        //I = kaO + ILOkd(n⋅l) + ILks(v⋅r)^kn

        //Werte für die Formel
        Color O = color;
        LightSource IL = lightSource;
        Color ILC = IL.getColor().multiply(IL.getIntensity());

        Vector n = normal;
        Vector l = IL.getPosition().sub(surface).norm();
        Vector r = l.negative().reflect(n);
        Vector v = spectator;

        double ka = ambient;
        double kd = diffuse;
        double ks = specular;
        double kn = shininess;

        double nl = n.dot(l);
        double vr = r.dot(v);

        //ambient
        Color ambient = O.multiply(ka);

        //diffuse
        //Color diffuse = ILC.multiply(O).multiply(kd * nl);
        Color diffuse = ILC.multiply(O).multiply(kd).multiply(Math.max(nl, 0));


        //specular
        double specularFactor = Math.pow(vr, kn);
       // Color specular = ILC.multiply(ks * specularFactor);
        Color specular = new Color(0, 0, 0);
        if (vr > 0) {
            specular = ILC.multiply(ks).multiply(specularFactor);
        }

        //final
        Color I = ambient.add(diffuse).add(specular);

        return I;

    }
}

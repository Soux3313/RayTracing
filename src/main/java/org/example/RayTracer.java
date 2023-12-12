package org.example;

public class RayTracer {
    private final Scene scene;
    private final Camera cam;
    private final Canvas renderTarget;

    public RayTracer(Scene scene, Camera cam)
    {
        this.scene = scene;
        this.cam = cam;
        renderTarget = new Canvas(cam.getWidth(),cam.getHeight());
    }

    public Canvas getRenderTarget() {
        return renderTarget;
    }

    public void render()
    {
        for (int y = 0; y < cam.getHeight(); y++) {
            for (int x = 0; x < cam.getWidth(); x++) {
                Ray ray = cam.generateRay(x, y);
                Intersections intersections = scene.traceRay(ray);
                if(intersections.hit() != null) renderTarget.setPixel(x, y, new Color("cyan"));
                else renderTarget.setPixel(x, y, new Color("blue"));
            }
        }
    }

}

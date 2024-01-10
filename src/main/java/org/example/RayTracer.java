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
                Intersection hit = scene.traceRay(ray).hit();
                if(hit == null) renderTarget.setPixel(x, y, new Color("cyan"));
                else
                {
                    HitInfo hitInfo = hit.prepareHitInfo(ray);
                    Color color = scene.shadeHit(hitInfo);
                    renderTarget.setPixel(x, y, color);
                }
            }
        }
    }

}

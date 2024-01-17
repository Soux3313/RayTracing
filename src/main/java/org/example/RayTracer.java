package org.example;

import java.util.List;

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
                Color superSamplingColor = new Color("black");
                var sampler = scene.getSampler();
                List<Point> list = sampler.generateSamplePoints(9);

                for (Point offset : list) {
                    double offsetX = offset.getX();
                    double offsetY = offset.getY();
                    Ray ray = cam.generateRay(x + offsetX, y + offsetY);
                    Color color = scene.colorAt(ray, 1);
                    superSamplingColor = superSamplingColor.add(color);
                }

                Color color = superSamplingColor.multiply(1.0/list.size());

                renderTarget.setPixel(x,y,color);
            }
        }
    }

}

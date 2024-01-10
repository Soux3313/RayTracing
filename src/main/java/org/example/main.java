package org.example;

public class main {
    public static void main(String[] args) {

        Material mat = new Material(new Color(1,0.2,1),0.1,0.9,0.9,200);

        Sphere sph1 = new Sphere();
        sph1.setRadius(1);
        sph1.setCenter(new Point(-0.5,1,0.5));
        //sph1.setMaterial(mat);

        Sphere sph2 = new Sphere();
        sph2.setRadius(0.5);
        sph2.setCenter(new Point(1.5,0.5,-0.5));
        //sph2.setMaterial(mat);

        Sphere sph3 = new Sphere();
        sph3.setRadius(0.33);
        sph3.setCenter(new Point(-1.5,0.33,-0.75));
        //sph3.setMaterial(mat);

        Sphere ground = new Sphere();
        Matrix groundM = Matrix.scale(10,0.1,10);
        ground.setTransformation(groundM);

        LightSource ls = new PointLightSource(new Point(-10,10,-10), new Color("white"),1);
        Scene scene = new Scene(sph1, sph2, sph3, ground);
        scene.addLight(ls);

        Scene defaultScene = Scene.defaultScene();

        int width = 800;
        int height = 400;
        double fov = 60;
        Point position = new Point(0,1.5,-5);
        Point lookAt = new Point(0,1,0);
        Vector up = new Vector(0,1,0);
        Camera camera = new Camera(width,height,fov,position,lookAt,up);
        RayTracer rt = new RayTracer(scene, camera);
        rt.render();
        Canvas canvas = rt.getRenderTarget();
        canvas.saveToFile("shadowScene1");
    }
    private static double abs(double value)
    {
        if (value < 0)
        {
            return value * -1;
        }
        else return value;
    }
}

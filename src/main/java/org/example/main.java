package org.example;

public class main {
    public static void main(String[] args) {

        Scene defaultScene = Scene.defaultScene();

        Material mat = new Material(new Color("red"),0.1,0.9,0.9,200, 0.3);
        Material mat2 = new Material(new Color("blue"),0.1,0.9,0.9,200,0);
        Material mat3 = new Material(new Color("yellow"), 0.1,0.9,0.9,200,1);
        Material mat4 = new Material(new Color("white"),0.1,0.9,0.9,200,1);

        Sphere sph1 = new Sphere();
        sph1.setTransformation(Matrix.translate(-0.5,2,0.5));
        sph1.setMaterial(mat);

        Sphere sph2 = new Sphere();
        sph2.setTransformation((Matrix.translate(2,0.5,-0.5).mult(Matrix.scale(0.5, 0.5, 0.5))));
        sph2.setMaterial(mat4);

        Sphere sph3 = new Sphere();
        sph3.setTransformation(Matrix.translate(-1.5,0.33,-0.75).mult(Matrix.scale(0.2, 0.2, 0.2)));
        sph3.setMaterial(mat3);

        Sphere sph4 = new Sphere();
        sph4.setTransformation(Matrix.translate(0,0.5,0).mult(Matrix.scale(0.4, 0.4, 0.4)));
        sph4.setMaterial(mat2);

        Sphere ground = new Sphere();
        Matrix groundM = Matrix.scale(10,0.0001,10);
        ground.setTransformation(groundM);
        ground.setMaterial(mat4);

        LightSource ls = new DirectionalLightSource(new Color("white"),1,new Vector(10,-10,10));
        LightSource ls2 = new DirectionalLightSource(new Color("blue"),1,new Vector(10,10,10));
        Scene scene = new Scene(sph1, sph2, sph3, sph4, ground);
        scene.addLight(ls);
        //scene.addLight(ls2);

        Sampler rSamp = new RandomSampler();
        Sampler offSamp = new OffsetSampler();
        Sampler noSamp = new NoSampler();

        scene.setSampler(noSamp);

        int width = 800;
        int height = 800;
        double fov = 60;
        Point position = new Point(0,1.5,-5);
        Point lookAt = new Point(0,1,0);
        Vector up = new Vector(0,1,0);
        Camera camera = new Camera(width,height,fov,position,lookAt,up);
        RayTracer rt = new RayTracer(scene, camera);
        rt.render();
        Canvas canvas = rt.getRenderTarget();
        canvas.saveToFile("Custom Scene No Anti Aliasing");
    }

}

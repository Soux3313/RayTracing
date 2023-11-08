package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Canvas {
    int x;
    int y;
    String fileName;
    BufferedImage outputImage;

    public Canvas(int width, int height)
    {
        this.x = width;
        this.y = height;
        this.fileName = "unnamed";
        outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }
    public Canvas(int width, int height, String fileName)
    {
        this.x = width;
        this.y = height;
        this.fileName = fileName;

        outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        saveToFile(fileName);
    }

    public int getWidth() {
        return x;
    }

    public int getHeight() {
        return y;
    }

    public String getFileName() {
        return fileName;
    }

    public void setPixel(int x, int y, Color c)
    {
        outputImage.setRGB(x,y, c.toImageColor());
    }

    public Color getPixel(int x, int y)
    {
        int imageColor = outputImage.getRGB(x, y);
        return Color.fromImageColor(imageColor);
    }

    public void saveToFile(String filename) {
        try {
            File output = new File("C:\\Users\\fraja\\OneDrive\\Desktop\\Uni-Zeugs\\3. Semester\\RayTracing\\Bilder\\" + filename + ".png");
            ImageIO.write(outputImage, "png", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

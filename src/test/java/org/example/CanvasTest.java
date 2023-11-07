package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CanvasTest {
    @Test
    void unnamed(){
        Canvas c = new Canvas(300,300);
        assertEquals("unnamed",c.getFileName());
    }

    @Test
    void named(){
        Canvas c = new Canvas(300,300, "test");
        assertEquals("test",c.getFileName());
    }

    @Test
    void setPixel() {
        Canvas c = new Canvas(300,300);
        Color c1 = new Color(0.5,0.5,0.5);
        c.setPixel(30,30,c1);

        double[] expected = {0.5, 0.5, 0.5};
        double[] actual = {c.getPixel(30,30).getR(),c.getPixel(30,30).getG(),c.getPixel(30,30).getB()};

        assertArrayEquals(expected,actual);
    }
    @Test
    public void testSaveToFile() {

        Canvas canvas = new Canvas(200, 200);


        canvas.setPixel(50, 50, new Color(255, 0, 0)); // Red
        canvas.setPixel(100, 100, new Color(0, 255, 0)); // Green
        canvas.setPixel(150, 150, new Color(0, 0, 255)); // Blue


        canvas.saveToFile("test_image");

        File imageFile = new File("test_image");
        assertTrue(imageFile.exists());

        imageFile.delete();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Graphics;
import com.tngtech.jgiven.junit.ScenarioTest;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import javax.imageio.ImageIO;
import static org.junit.Assert.*;

/**
 *
 * @author benjamin
 */
public class SVGImageFigureTest extends ScenarioTest<GivenThereIsACanvas, WhenInsertingImage, ThenImageExistsOnCanvas> {
    
    SVGImageFigure Image1;
    SVGImageFigure Image2;
    BufferedImage image;
    Graphics2D g;
    
    public SVGImageFigureTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.Image1 = new SVGImageFigure(0, 0, 0, 0);
        this.Image2 = new SVGImageFigure(10, 10, 10, 10);

        image = loadImage();
        Graphics grap = ((BufferedImage) image).createGraphics();
        this.g = (Graphics2D) grap.create();
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testClone() {
        if(g == null){
            System.out.println("No graphics");
        } else {
            System.out.println("Graphics exits");
        }
        Graphics2D cloneg = g;//(Graphics2D) g.create();
        Image1.draw(g);
        assertEquals(g, cloneg);
        
        
        SVGImageFigure cloneImage = Image1.clone();
        
        assertNotSame(Image1, cloneImage);
        
    }
    
    @Test
    public void testLoadImage() throws IOException {
        
        URL input = SVGImageFigureTest.class.getResource("/sadge.jpg");
        File file = null; //new File("sadge.jpg");
        if (input != null) {
            System.out.println("URL exists");
            file = new File(input.getFile());
            Image2.loadImage(file);
            assertNotNull(Image2.getBufferedImage());
            
        } else {
            System.out.println("No image");
            fail("No Image");
        }

        
    }
    
    @Test
    public void acceptanceTest() throws IOException {
        given().thereIsACanvas();
        when().insertingAnImage();
        then().imageExistsOnCanvas();
    } 
    
    
    
    
    private BufferedImage loadImage(){
        BufferedImage image = null;
        try {
            image = ImageIO.read(SVGImageFigureTest.class.getResource("/sadge.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return image;
    }
}

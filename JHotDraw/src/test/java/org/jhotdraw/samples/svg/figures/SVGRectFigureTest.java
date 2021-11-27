/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author peter
 */
public class SVGRectFigureTest {
    
    SVGRectFigure instance = new SVGRectFigure(30.50, 40.20, 60.90, 80.80);

    /**
     * Test of getX method, of class SVGRectFigure.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        double expResult = 30.50;
        double result = instance.getX();
        assertEquals(expResult, result, 30.50);
    }

    /**
     * Test of getY method, of class SVGRectFigure.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        //SVGRectFigure instance = new SVGRectFigure();
        double expResult = 40.20;
        double result = instance.getY();
        assertEquals(expResult, result, 40.20);
    }

    /**
     * Test of getWidth method, of class SVGRectFigure.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        SVGRectFigure instance = new SVGRectFigure();
        double expResult = 60.90;
        double result = instance.getWidth();
        assertEquals(expResult, result, 60.90);
    }

    /**
     * Test of getHeight method, of class SVGRectFigure.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        SVGRectFigure instance = new SVGRectFigure();
        double expResult = 80.80;
        double result = instance.getHeight();
        assertEquals(expResult, result, 80.80);
    }
    
}

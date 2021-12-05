/*
 * @(#)CanvasToolBar.java  1.0  2008-05-18
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.samples.svg.gui;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.text.JavaNumberFormatter;
import org.jhotdraw.gui.*;
import org.jhotdraw.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.LabelUI;
import javax.swing.plaf.SliderUI;
import javax.swing.plaf.TextUI;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.gui.plaf.palette.*;
import org.jhotdraw.text.ColorFormatter;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * CanvasToolBar.
 *
 * @author Werner Randelshofer
 * @version 1.0 2008-05-18 Created.
 */
public class CanvasToolBar extends AbstractToolBar {
    
    /** Creates new instance. */
    @FeatureEntryPoint(JHotDrawFeatures.CANVASTOOLBAR)    
    public CanvasToolBar() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString(getID() + ".toolbar"));
        setDisclosureStateCount(3);
    }

    private JPanel addFillColorButton(JPanel p, ResourceBundleUtil labels, GridBagConstraints gbc){
        AbstractButton btn;
        btn = ButtonFactory.createDrawingColorButton(editor,
                            CANVAS_FILL_COLOR, ButtonFactory.HSV_COLORS, ButtonFactory.HSV_COLORS_COLUMN_COUNT,
                            "attribute.canvasFillColor", labels, null, new Rectangle(3, 3, 10, 10));
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        new DrawingComponentRepainter(editor, btn);
        ((JPopupButton) btn).setAction(null, null);
        
        p.add(btn, gbc);

        return p;
    }

    private JPanel addOpacitySliderButton(JPanel p, ResourceBundleUtil labels, GridBagConstraints gbc){
        JPopupButton opacityPopupButton = new JPopupButton();
        JAttributeSlider opacitySlider = new JAttributeSlider(JSlider.VERTICAL, 0, 100, 100);
        opacitySlider.setUI((SliderUI) PaletteSliderUI.createUI(opacitySlider));
        opacitySlider.setScaleFactor(100d);
        new DrawingAttributeEditorHandler<Double>(CANVAS_FILL_OPACITY, opacitySlider, editor);
        opacityPopupButton.add(opacitySlider);
        labels.configureToolBarButton(opacityPopupButton, "attribute.canvasFillOpacity");
        opacityPopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(opacityPopupButton));
        opacityPopupButton.setIcon(
                new DrawingOpacityIcon(editor, CANVAS_FILL_OPACITY, CANVAS_FILL_COLOR, null, getClass().getResource(labels.getString("attribute.canvasFillOpacity.icon")),
                new Rectangle(5, 5, 6, 6), new Rectangle(4, 4, 7, 7)));
        new DrawingComponentRepainter(editor, opacityPopupButton);
       
        p.add(opacityPopupButton, gbc);

        return p;
    }
    
    private JPanel addFillColorField(JPanel p, ResourceBundleUtil labels, GridBagConstraints gbc){
        JAttributeTextField<Color> colorField = new JAttributeTextField<Color>();
        colorField.setColumns(7);
        colorField.setToolTipText(labels.getString("attribute.canvasFillColor.toolTipText"));
        colorField.putClientProperty("Palette.Component.segmentPosition", "first");
        colorField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(colorField));
        colorField.setFormatterFactory(ColorFormatter.createFormatterFactory());
        colorField.setHorizontalAlignment(JTextField.LEFT);
        new DrawingAttributeEditorHandler<Color>(CANVAS_FILL_COLOR, colorField, editor);
        
        p.add(colorField, gbc);
        
        return p;
    }
    
    private JPanel addOpacityField(JPanel p, ResourceBundleUtil labels, GridBagConstraints gbc){
        JAttributeTextField<Double> opacityField = new JAttributeTextField<Double>();
        opacityField.setColumns(7);
        opacityField.setToolTipText(labels.getString("attribute.figureOpacity.toolTipText"));
        opacityField.putClientProperty("Palette.Component.segmentPosition", "first");
        opacityField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(opacityField));
        opacityField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(0d, 100d, 100d, true, false));
        opacityField.setHorizontalAlignment(JTextField.LEADING);
        new DrawingAttributeEditorHandler<Double>(CANVAS_FILL_OPACITY, opacityField, editor);
        p.add(opacityField, gbc);
        
        return p;
    }
    
    private JPanel addField(JPanel p, String toolTipText, GridBagConstraints gbc, JAttributeTextField<Double> field, AttributeKey<Double> drawingAttributeKey){

        field.setUI((TextUI) PaletteFormattedTextFieldUI.createUI(field));
        field.setColumns(3);
        field.setToolTipText(toolTipText);
        field.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(1d, 4096d, 1d, true, false));
        field.setHorizontalAlignment(JTextField.LEADING);
        new DrawingAttributeEditorHandler<Double>(drawingAttributeKey, field, editor);
        p.add(field, gbc);

        return p;
    }

    private JPanel addLabel(JPanel p, String toolTipText, String text, GridBagConstraints gbc, JAttributeTextField<Double> field, JLabel widthLabel){

        widthLabel.setUI((LabelUI) PaletteLabelUI.createUI(widthLabel));
        widthLabel.setLabelFor(field);
        widthLabel.setToolTipText(toolTipText);
        widthLabel.setText(text);
        p.add(widthLabel, gbc);
        
        return p;
    }

    private JPanel addFieldWithLabel(JPanel p, GridBagConstraints gbc, AttributeKey<Double> fieldKey, String toolTipText, String text, Integer labelGridx, Integer labelGridy, Integer fieldGridx, Integer fieldGridy, Integer fieldGridWidth){
        JLabel label = new javax.swing.JLabel();
        JAttributeTextField<Double> field = new JAttributeTextField<Double>();

        gbc = this.createGridBagConstraints(labelGridx, labelGridy, null, null, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  new Insets(3,0,0,0));
        p = this.addLabel(p, toolTipText, text, gbc, field, label);
        
        gbc = this.createGridBagConstraints(fieldGridx, fieldGridy, null, fieldGridWidth, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,  new Insets(3,3,0,0));
        p = this.addField(p, toolTipText, gbc, field, fieldKey);

        return p;
    }

    private JPanel createHalfToolBar(JPanel p, ResourceBundleUtil labels, GridBagConstraints gbc){

        //Add Fill color button
        gbc = this.createGridBagConstraints(null, 0, null, 2, GridBagConstraints.FIRST_LINE_START, null, null);
        p = this.addFillColorButton(p, labels, gbc);

        //Add Opacity slider
        gbc = this.createGridBagConstraints(2, 0, null, null, GridBagConstraints.FIRST_LINE_START, null, new Insets(0, 3, 0, 0));
        p = this.addOpacitySliderButton(p, labels, gbc);

        //Add Width and height fields
        p = this.addFieldWithLabel(p, gbc, CANVAS_WIDTH, labels.getString("attribute.canvasWidth.toolTipText"), labels.getString("attribute.canvasWidth.text"), 0, 1, 1, 1, 2);
        p = this.addFieldWithLabel(p, gbc, CANVAS_HEIGHT, labels.getString("attribute.canvasHeight.toolTipText"), labels.getString("attribute.canvasHeight.text"), 0, 2, 1, 2, 2);

        return p;
    }

    private JPanel createFullToolBar(JPanel p, JPanel p1, JPanel p2, JPanel p3, ResourceBundleUtil labels, GridBagConstraints gbc){

        // Fill color field with button
        gbc = this.createGridBagConstraints(null, null, null, 2, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL, null);
        p1 = this.addFillColorField(p1, labels, gbc);
        
        gbc = this.createGridBagConstraints(null, null, null, null, GridBagConstraints.FIRST_LINE_START, null, null);
        p1 = this.addFillColorButton(p1, labels, gbc);

        // Opacity field with slider
        gbc = this.createGridBagConstraints(0, 1, null, null, GridBagConstraints.FIRST_LINE_START, null, new Insets(3, 0, 0, 0));
        p2 = this.addOpacityField(p2, labels, gbc);
        
        //Add opacity slider
        gbc = this.createGridBagConstraints(1, 1, null, null, GridBagConstraints.FIRST_LINE_START, null, new Insets(3, 0, 0, 0));
        p2 = this.addOpacitySliderButton(p2, labels, gbc);

        //Add Width and height fields
        p3 = this.addFieldWithLabel(p3, gbc, CANVAS_WIDTH, labels.getString("attribute.canvasWidth.toolTipText"), labels.getString("attribute.canvasWidth.text"), 0, 2, 1, 2, 2);
        p3 = this.addFieldWithLabel(p3, gbc, CANVAS_HEIGHT, labels.getString("attribute.canvasHeight.toolTipText"), labels.getString("attribute.canvasHeight.text"), 3, 2, 4, 2, 2);

        // Add horizontal strips
        gbc = this.createGridBagConstraints(null, 0, null, null, GridBagConstraints.FIRST_LINE_START, null, null);
        p.add(p1, gbc);
        gbc = this.createGridBagConstraints(null, 1, null, null, GridBagConstraints.FIRST_LINE_START, null, null);
        p.add(p2, gbc);
        gbc = this.createGridBagConstraints(null, 2, null, null, GridBagConstraints.FIRST_LINE_START, null, null);
        p.add(p3, gbc);

        return p;
    }

    @Override
    @FeatureEntryPoint(JHotDrawFeatures.CANVASTOOLBAR)
    protected JComponent createDisclosedComponent(int state) {
        JPanel p = null;
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        GridBagConstraints gbc = new GridBagConstraints();

        switch (state) {
            case 1:
                 {
                    p = this.createPanel(false, new EmptyBorder(5, 5, 5, 8));
                   p = this.createHalfToolBar(p, labels, gbc);
                }
                break;
            case 2:
                 {
                    p = this.createPanel(false, new EmptyBorder(5, 5, 5, 8));

                    JPanel p1 = this.createPanel(false, null);
                    JPanel p2 = this.createPanel(false, null);
                    JPanel p3 = this.createPanel(false, null);
                    this.createFullToolBar(p, p1, p2, p3, labels, gbc);
                }
                break;
        }
        return p;
    }

    @Override
    @FeatureEntryPoint(JHotDrawFeatures.CANVASTOOLBAR)
    protected String getID() {
        return "canvas";
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

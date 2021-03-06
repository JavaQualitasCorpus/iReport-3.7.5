/*
 * iReport - Visual Designer for JasperReports.
 * Copyright (C) 2002 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 * 
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 * 
 * This program is part of iReport.
 * 
 * iReport is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * iReport is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with iReport. If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * LayerItemPanel.java
 *
 * Created on 25-feb-2010, 10.34.34
 */

package com.jaspersoft.ireport.addons.layers;

import com.jaspersoft.ireport.designer.IReportManager;
import com.jaspersoft.ireport.designer.ModelUtils;
import com.jaspersoft.ireport.designer.ReportObjectScene;
import com.jaspersoft.ireport.designer.editor.ExpressionContext;
import com.jaspersoft.ireport.designer.editor.ExpressionEditor;
import com.jaspersoft.ireport.designer.sheet.properties.AbstractProperty;
import com.jaspersoft.ireport.designer.undo.PropertyUndoableEdit;
import com.jaspersoft.ireport.designer.utils.Misc;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.HashSet;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import net.sf.jasperreports.engine.design.JRDesignDataset;
import net.sf.jasperreports.engine.design.JRDesignElement;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignTextField;

/**
 *
 * @author gtoffoli
 */
public class LayerItemPanel extends javax.swing.JPanel {

    public static final String PROPERTY_SELECTED = "PROPERTY_SELECTED";

    private boolean editing = false;
    private boolean selected = false;
    private boolean updatingUI = false;

    private Layer layer = null;

    /** Creates new form LayerItemPanel */
    public LayerItemPanel() {
        initComponents();
    }

    @Override
    public Dimension getMaximumSize() {
        Dimension d = super.getMaximumSize();
        d.height = getPreferredSize().width;
        return d;
    }

    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItemPrintWhenExpression = new javax.swing.JMenuItem();
        jMenuItemSelectLayerElements = new javax.swing.JMenuItem();
        jMenuItemMergeDown = new javax.swing.JMenuItem();
        jMenuDeleteLayer = new javax.swing.JMenuItem();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        jMenuItemPrintWhenExpression.setText(org.openide.util.NbBundle.getMessage(LayerItemPanel.class, "LayerItemPanel.jMenuItemPrintWhenExpression.text")); // NOI18N
        jMenuItemPrintWhenExpression.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPrintWhenExpressionActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemPrintWhenExpression);

        jMenuItemSelectLayerElements.setText(org.openide.util.NbBundle.getMessage(LayerItemPanel.class, "LayerItemPanel.jMenuItemSelectLayerElements.text")); // NOI18N
        jMenuItemSelectLayerElements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSelectLayerElementsActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemSelectLayerElements);

        jMenuItemMergeDown.setText(org.openide.util.NbBundle.getMessage(LayerItemPanel.class, "LayerItemPanel.jMenuItemMergeDown.text")); // NOI18N
        jMenuItemMergeDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMergeDownActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemMergeDown);

        jMenuDeleteLayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/addons/layers/delete.gif"))); // NOI18N
        jMenuDeleteLayer.setText(org.openide.util.NbBundle.getMessage(LayerItemPanel.class, "LayerItemPanel.jMenuDeleteLayer.text")); // NOI18N
        jMenuDeleteLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDeleteLayerActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuDeleteLayer);

        setLayout(new java.awt.GridBagLayout());

        jCheckBox1.setText(org.openide.util.NbBundle.getMessage(LayerItemPanel.class, "LayerItemPanel.jCheckBox1.text")); // NOI18N
        jCheckBox1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/addons/layers/always_visible.png"))); // NOI18N
        jCheckBox1.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/addons/layers/always_visible.png"))); // NOI18N
        jCheckBox1.setFocusPainted(false);
        jCheckBox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/addons/layers/not_visible.png"))); // NOI18N
        jCheckBox1.setPreferredSize(new java.awt.Dimension(22, 22));
        jCheckBox1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/addons/layers/visible.png"))); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        add(jCheckBox1, new java.awt.GridBagConstraints());

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jTextField1.setEditable(false);
        jTextField1.setText(org.openide.util.NbBundle.getMessage(LayerItemPanel.class, "LayerItemPanel.jTextField1.text")); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField1.setOpaque(false);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField1MousePressed(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel1.add(jTextField1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(jPanel1, gridBagConstraints);

        jSeparator1.setPreferredSize(new java.awt.Dimension(1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(jSeparator1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked


        if (SwingUtilities.isLeftMouseButton(evt))
        {
            if (evt.getClickCount() == 2)
            {
                setEditing(true);
            }
        }
        
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost

         setEditing(false);

    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER)
        {
            setEditing(false);
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        jTextField1MousePressed(evt);
    }//GEN-LAST:event_jPanel1MousePressed

    private void jTextField1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MousePressed
        if (SwingUtilities.isLeftMouseButton(evt))
        {
            if (getParent() instanceof LayersListPanel)
            {
                evt.setSource(this);
                ((LayersListPanel)getParent()).itemMousePressed(evt);
            }
        }
        else if (SwingUtilities.isRightMouseButton(evt) && !editing)
        {
            Object source = evt.getSource();
            // Select the item...
            evt.setSource(this);
            ((LayersListPanel)getParent()).itemMousePressed(evt);
            evt.setSource(source);

            jMenuDeleteLayer.setEnabled(!getLayer().isBackgroundLayer());
            jMenuItemMergeDown.setEnabled(!getLayer().isBackgroundLayer());
            jMenuItemPrintWhenExpression.setEnabled(!getLayer().isBackgroundLayer());

            jPopupMenu1.show((JComponent)evt.getSource(), evt.getPoint().x, evt.getPoint().y);
        }
    }//GEN-LAST:event_jTextField1MousePressed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        if (getLayer() != null)
        {
            getLayer().setVisible(jCheckBox1.isSelected());
        }

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jMenuDeleteLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDeleteLayerActionPerformed

        LayersSupport.getInstance().removeLayer(getLayer());

    }//GEN-LAST:event_jMenuDeleteLayerActionPerformed

    private void jMenuItemSelectLayerElementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSelectLayerElementsActionPerformed

        List<JRDesignElement> elements = LayersSupport.getInstance().getLayerElements(getLayer());
        
        ReportObjectScene scene = LayersSupport.getInstance().getScene();
        HashSet set = new HashSet();
        set.addAll(elements);
        scene.setSelectedObjects(set);
        scene.revalidate();
        scene.validate();

    }//GEN-LAST:event_jMenuItemSelectLayerElementsActionPerformed

    private void jMenuItemMergeDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMergeDownActionPerformed

        // get previous layer..
        int index = LayersSupport.getInstance().getLayers().indexOf(getLayer());
        if (index > 0)
        {
            Layer newLayer =  LayersSupport.getInstance().getLayers().get(index-1);

            List<JRDesignElement> elements = LayersSupport.getInstance().getLayerElements(getLayer());
            for (JRDesignElement element : elements)
            {
               LayersSupport.getInstance().addElementToLayer(element, newLayer);
            }
            LayersSupport.getInstance().updateAllLayers();
            LayersSupport.getInstance().removeLayer(getLayer());
        }


    }//GEN-LAST:event_jMenuItemMergeDownActionPerformed

    private void jMenuItemPrintWhenExpressionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPrintWhenExpressionActionPerformed

        ExpressionEditor editor = new ExpressionEditor();

        // get the common expression context or null if the context is not common...
        List<JRDesignElement> elements = LayersSupport.getInstance().getLayerElements(getLayer());

        JRDesignDataset dataset = null;
        for (JRDesignElement element : elements)
        {
            JRDesignDataset ds = ModelUtils.getElementDataset(element, LayersSupport.getInstance().getJasperDesign());

            if (dataset == null)
            {
                dataset = ds;
            }
            else if (dataset != ds)
            {
                dataset = null;
                break;
            }
        }

        if (dataset != null)
        {
            editor.setExpressionContext( new ExpressionContext(dataset));
        }

        // Show the layer print when expression...
        editor.setExpression(  Misc.nvl(getLayer().getPrintWhenExpression(), ""));

        if (editor.showDialog(Misc.getMainFrame()) == JOptionPane.OK_OPTION)
        {
            layer.setPrintWhenExpression(editor.getExpression());
            // we don't handle undo here...
            JRDesignExpression newExp = Misc.createExpression("java.lang.Boolean", editor.getExpression());

            for (JRDesignElement element : elements)
            {
                element.setPrintWhenExpression(newExp);
            }

            IReportManager.getInstance().notifyReportChange();
        }

    }//GEN-LAST:event_jMenuItemPrintWhenExpressionActionPerformed


    public void setEditing(boolean b)
    {
        if (this.editing == b || getLayer().isBackgroundLayer()) return;

        this.editing = b;

        if (this.editing)
        {
            jTextField1.setBorder(new LineBorder(Color.BLACK));
            jTextField1.setOpaque(true);
            jTextField1.setEditable(true);
            jTextField1.selectAll();
            jTextField1.requestFocusInWindow();
            jTextField1.setForeground(UIManager.getColor("List.foreground"));
        }
        else
        {
            String s = jTextField1.getText();
            if (s.trim().length() > 0)
            {
                if (getLayer() != null)
                {
                    updatingUI = true;
                    getLayer().setName(s);
                    updatingUI = false;
                }
            }
            jTextField1.setEditable(false);
            jTextField1.setOpaque(false);
            jTextField1.setBorder(new EmptyBorder(new Insets(1, 1, 1, 1)));
            jTextField1.setForeground(UIManager.getColor("List.selectionForeground"));
        }

            
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JMenuItem jMenuDeleteLayer;
    private javax.swing.JMenuItem jMenuItemMergeDown;
    private javax.swing.JMenuItem jMenuItemPrintWhenExpression;
    private javax.swing.JMenuItem jMenuItemSelectLayerElements;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public void setSelected(boolean b) {

        if (selected == b) return;
        selected = b;
        if (!selected)
        {
            setEditing(false);
            jPanel1.setBackground( UIManager.getColor("Label.background") );
            jTextField1.setForeground(UIManager.getColor("List.foreground"));
            jTextField1.setSelectionStart(0);
            jTextField1.setSelectionEnd(0);
        }
        else
        {
            jPanel1.setBackground(UIManager.getColor("List.selectionBackground"));
            jTextField1.setForeground(UIManager.getColor("List.selectionForeground"));
         }

        firePropertyChange(PROPERTY_SELECTED, !selected, selected);
    }

    /**
     * @return the layer
     */
    public Layer getLayer() {
        return layer;
    }

    /**
     * @param layer the layer to set
     */
    public void setLayer(Layer layer) {
        this.layer = layer;
        jTextField1.setText(layer.getName());
        jCheckBox1.setSelected(layer.isVisible());
        if (layer.isBackgroundLayer())
        {
            jCheckBox1.setEnabled(false);
        }
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    


}

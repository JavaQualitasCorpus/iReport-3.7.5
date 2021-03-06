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
package com.jaspersoft.ireport.designer.tools;

import com.jaspersoft.ireport.locale.I18n;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import net.sf.jasperreports.engine.JRChartPlot;
import net.sf.jasperreports.engine.base.JRBaseChartPlot;

/**
 *
 * @author  gtoffoli
 */
public class SeriesColorsPanel extends javax.swing.JPanel {
    
    private JDialog dialog = null;
    private List seriescolors = null;
    
    private int dialogResult = javax.swing.JOptionPane.CANCEL_OPTION;
    public static List clipboard = new ArrayList();
    public static List lastSeries = new ArrayList();
    
    private boolean init = false;

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }
    
    
    /** Creates new form SeriesColorsPanel */
    public SeriesColorsPanel() {
        initComponents();
        
        jPanel1.setVisible(false);
        
        jList1.setModel(new DefaultListModel());
        jList1.setCellRenderer(new ColorsListCellRenderer());
        
        jList1ValueChanged(null);
        
        jButtonPasteSeries.setEnabled( clipboard.size() > 0 );
        jButtonUseLast.setEnabled( lastSeries.size() > 0 );
        //applyI18n();
        
        jList1.getModel().addListDataListener(new ListDataListener() {

            public void intervalAdded(ListDataEvent e) {
                updateSeriesColors();
            }

            public void intervalRemoved(ListDataEvent e) {
                updateSeriesColors();
            }

            public void contentsChanged(ListDataEvent e) {
                updateSeriesColors();
            }
        });
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jButtonAddColor = new javax.swing.JButton();
        jButtonModify = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonMoveUp = new javax.swing.JButton();
        jButtonMoveDown = new javax.swing.JButton();
        jButtonCopySeries = new javax.swing.JButton();
        jButtonPasteSeries = new javax.swing.JButton();
        jButtonUseLast = new javax.swing.JButton();
        jButtonRandomColor = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jButtonOk = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(250, 2));

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel3.add(jScrollPane1, gridBagConstraints);

        jPanel2.setMinimumSize(new java.awt.Dimension(150, 150));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 283));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButtonAddColor.setText(org.openide.util.NbBundle.getMessage(SeriesColorsPanel.class, "SeriesColorsPanel.jButtonAddColor.text")); // NOI18N
        jButtonAddColor.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jButtonAddColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddColorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        jPanel2.add(jButtonAddColor, gridBagConstraints);

        jButtonModify.setText(org.openide.util.NbBundle.getMessage(SeriesColorsPanel.class, "SeriesColorsPanel.jButtonModify.text")); // NOI18N
        jButtonModify.setEnabled(false);
        jButtonModify.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jButtonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        jPanel2.add(jButtonModify, gridBagConstraints);

        jButtonDelete.setText(org.openide.util.NbBundle.getMessage(SeriesColorsPanel.class, "SeriesColorsPanel.jButtonDelete.text")); // NOI18N
        jButtonDelete.setEnabled(false);
        jButtonDelete.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        jPanel2.add(jButtonDelete, gridBagConstraints);

        jButtonMoveUp.setText(org.openide.util.NbBundle.getMessage(SeriesColorsPanel.class, "SeriesColorsPanel.jButtonMoveUp.text")); // NOI18N
        jButtonMoveUp.setEnabled(false);
        jButtonMoveUp.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jButtonMoveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoveUpActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        jPanel2.add(jButtonMoveUp, gridBagConstraints);

        jButtonMoveDown.setText(org.openide.util.NbBundle.getMessage(SeriesColorsPanel.class, "SeriesColorsPanel.jButtonMoveDown.text")); // NOI18N
        jButtonMoveDown.setEnabled(false);
        jButtonMoveDown.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jButtonMoveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoveDownActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 14, 4);
        jPanel2.add(jButtonMoveDown, gridBagConstraints);

        jButtonCopySeries.setText(org.openide.util.NbBundle.getMessage(SeriesColorsPanel.class, "SeriesColorsPanel.jButtonCopySeries.text")); // NOI18N
        jButtonCopySeries.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jButtonCopySeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCopySeriesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        jPanel2.add(jButtonCopySeries, gridBagConstraints);

        jButtonPasteSeries.setText(org.openide.util.NbBundle.getMessage(SeriesColorsPanel.class, "SeriesColorsPanel.jButtonPasteSeries.text")); // NOI18N
        jButtonPasteSeries.setEnabled(false);
        jButtonPasteSeries.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jButtonPasteSeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPasteSeriesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        jPanel2.add(jButtonPasteSeries, gridBagConstraints);

        jButtonUseLast.setText(org.openide.util.NbBundle.getMessage(SeriesColorsPanel.class, "SeriesColorsPanel.jButtonUseLast.text")); // NOI18N
        jButtonUseLast.setEnabled(false);
        jButtonUseLast.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jButtonUseLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUseLastActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        jPanel2.add(jButtonUseLast, gridBagConstraints);

        jButtonRandomColor.setText(org.openide.util.NbBundle.getMessage(SeriesColorsPanel.class, "SeriesColorsPanel.jButtonRandomColor.text")); // NOI18N
        jButtonRandomColor.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jButtonRandomColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRandomColorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        jPanel2.add(jButtonRandomColor, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 4);
        jPanel3.add(jPanel2, gridBagConstraints);

        jSeparator1.setMinimumSize(new java.awt.Dimension(0, 2));
        jSeparator1.setPreferredSize(new java.awt.Dimension(3, 2));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(jSeparator1, gridBagConstraints);

        jPanel1.setPreferredSize(new java.awt.Dimension(320, 23));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jButtonOk.setForeground(new java.awt.Color(255, 51, 204));
        jButtonOk.setText(org.openide.util.NbBundle.getMessage(SeriesColorsPanel.class, "SeriesColorsPanel.jButtonOk.text")); // NOI18N
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        jPanel1.add(jButtonOk, gridBagConstraints);

        jButtonCancel.setText(org.openide.util.NbBundle.getMessage(SeriesColorsPanel.class, "SeriesColorsPanel.jButtonCancel.text")); // NOI18N
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancel, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel3.add(jPanel1, gridBagConstraints);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
            jButtonModifyActionPerformed(null);
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        if (jList1.getSelectedIndex() >= 0) {
            jButtonDelete.setEnabled(true);
            jButtonModify.setEnabled(true);
            jButtonMoveUp.setEnabled(jList1.getSelectedIndex() > 0);
            jButtonMoveDown.setEnabled(jList1.getSelectedIndex() < ((DefaultListModel)jList1.getModel()).size()-1);
        } else {
            jButtonModify.setEnabled(false);
            jButtonDelete.setEnabled(false);
            jButtonMoveUp.setEnabled(false);
            jButtonMoveDown.setEnabled(false);
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void jButtonAddColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddColorActionPerformed
        java.awt.Color c = HexColorChooserPanel.showDialog(this,I18n.getString("SeriesColorsPanel.Dialog.Title"),null);
        if (c != null) {
            ((DefaultListModel)jList1.getModel()).addElement(c);
        }
    }//GEN-LAST:event_jButtonAddColorActionPerformed

    private void jButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifyActionPerformed
        int index = jList1.getSelectedIndex();
        if (index >=0) {
            java.awt.Color c = (java.awt.Color)jList1.getSelectedValue();
            c = HexColorChooserPanel.showDialog(this,I18n.getString("SeriesColorsPanel.Dialog.Title"),c);
            if (c != null) {
                ((DefaultListModel)jList1.getModel()).setElementAt(c, index);
            }
        }
    }//GEN-LAST:event_jButtonModifyActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        int[] indexes = jList1.getSelectedIndices();
        
        for (int i=indexes.length-1;  i>=0; --i) {
            ((DefaultListModel)jList1.getModel()).removeElementAt(indexes[i]);
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonMoveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMoveUpActionPerformed
        if (jList1.getSelectedValues() != null) {
            int[] indices = jList1.getSelectedIndices();
            for (int i=0; i<indices.length; ++i) {
                if (indices[i] == 0) continue;
                Object val = ((DefaultListModel)jList1.getModel()).remove( indices[i] );
                ((DefaultListModel)jList1.getModel()).insertElementAt(val, indices[i]-1);
                indices[i]--;
            }
            jList1.setSelectedIndices(indices);
            updateSeriesColors();
        }
    }//GEN-LAST:event_jButtonMoveUpActionPerformed

    private void jButtonMoveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMoveDownActionPerformed
        if (jList1.getSelectedValues() != null) {
            int[] indices = jList1.getSelectedIndices();
            for (int i=indices.length-1; i>=0; --i) {
                if (indices[i] >= ((DefaultListModel)jList1.getModel()).size() -1 ) continue;
                
                Object val = ((DefaultListModel)jList1.getModel()).remove( indices[i] );
                ((DefaultListModel)jList1.getModel()).insertElementAt(val, indices[i]+1);
                indices[i]++;
            }
            jList1.setSelectedIndices(indices);
            updateSeriesColors();
        }
    }//GEN-LAST:event_jButtonMoveDownActionPerformed

    @SuppressWarnings("unchecked")
    private void jButtonCopySeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCopySeriesActionPerformed
        DefaultListModel dtm = ((DefaultListModel)jList1.getModel());
        if (dtm.size() > 0) {
            clipboard.clear();
            for (int i=0; i<dtm.size(); ++i) {
                clipboard.add(  new Color(  ((Color)dtm.get(i)).getRGB() ));
            }
        }
        
        jButtonPasteSeries.setEnabled(true);
    }//GEN-LAST:event_jButtonCopySeriesActionPerformed

    private void jButtonPasteSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPasteSeriesActionPerformed
        DefaultListModel dtm = ((DefaultListModel)jList1.getModel());
        setInit(true);
        if (clipboard.size() > 0) {
            for (int i=0; i<clipboard.size(); ++i) {
                dtm.addElement(  new Color(  ((Color)clipboard.get(i)).getRGB() ));
            }
        }
        setInit(false);
        updateSeriesColors();
    }//GEN-LAST:event_jButtonPasteSeriesActionPerformed

    private void jButtonUseLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUseLastActionPerformed
        DefaultListModel dtm = ((DefaultListModel)jList1.getModel());
        setInit(true);
        if (lastSeries.size() > 0) {
            for (int i=0; i<lastSeries.size(); ++i) {
                dtm.addElement(  new Color(  ((Color)lastSeries.get(i)).getRGB() ));
            }
        }
        setInit(false);
        updateSeriesColors();
    }//GEN-LAST:event_jButtonUseLastActionPerformed

    private void jButtonRandomColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRandomColorActionPerformed
        Color c = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255) );
        DefaultListModel dtm = ((DefaultListModel)jList1.getModel());
        dtm.addElement(c);
    }//GEN-LAST:event_jButtonRandomColorActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        if (dialog != null)
        {
            setDialogResult(JOptionPane.OK_OPTION);
            dialog.setVisible(false);
            dialog.dispose();
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        
        if (dialog != null)
        {
            setDialogResult( JOptionPane.CANCEL_OPTION);
            dialog.setVisible(false);
            dialog.dispose();
        }
    }//GEN-LAST:event_jButtonCancelActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddColor;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonCopySeries;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonModify;
    private javax.swing.JButton jButtonMoveDown;
    private javax.swing.JButton jButtonMoveUp;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonPasteSeries;
    private javax.swing.JButton jButtonRandomColor;
    private javax.swing.JButton jButtonUseLast;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
    
    public int showDialog(Component c)
    {
        Object pWin = SwingUtilities.windowForComponent(c);
        if (pWin instanceof Frame) dialog = new JDialog((Frame)pWin);
        else if (pWin instanceof Dialog) dialog = new JDialog((Dialog)pWin);
        else dialog = new JDialog();

        dialog.setLocationRelativeTo(null);
        dialog.getRootPane().setLayout(new BorderLayout());
        dialog.getRootPane().add( this, BorderLayout.CENTER );
                
        dialog.pack();
        jPanel1.setVisible(true);
        
        dialog.setVisible(true);
        
        return getDialogResult();
    }
    
    
    public int getDialogResult() {
        return dialogResult;
    }

    public void setDialogResult(int dialogResult) {
        this.dialogResult = dialogResult;
    }

    public List getSeriescolors() {
        return seriescolors;
    }

    @SuppressWarnings("unchecked")
    public void setSeriescolors(List seriesColors) {
        
        setInit(true);
        try {
            this.seriescolors = new ArrayList();
            for(Iterator it = seriesColors.iterator(); it.hasNext();)
            {
                this.seriescolors.add(((JRChartPlot.JRSeriesColor) it.next()).clone());
            }


            DefaultListModel dlm = (DefaultListModel)jList1.getModel();
            dlm.removeAllElements();

            for(Iterator it = this.seriescolors.iterator(); it.hasNext();)
            {
                JRChartPlot.JRSeriesColor c =(JRChartPlot.JRSeriesColor)it.next();
                dlm.addElement(c.getColor());
            }

        } finally {
           setInit(false); 
        }
    }
    
    @SuppressWarnings("unchecked")
    private void updateSeriesColors()
    {
        if (isInit()) return;
        
        DefaultListModel dtm = ((DefaultListModel)jList1.getModel());
        
        lastSeries.clear();
        seriescolors.clear();
        
        for (int i=0; i<dtm.size(); ++i) {
            JRBaseChartPlot.JRBaseSeriesColor sc = new JRBaseChartPlot.JRBaseSeriesColor(i, (java.awt.Color)dtm.get(i));
            seriescolors.add(sc);
            lastSeries.add( (java.awt.Color)dtm.get(i) );
        }
    }
}

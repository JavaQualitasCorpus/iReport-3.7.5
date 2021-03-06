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

import com.jaspersoft.ireport.designer.IReportManager;
import com.jaspersoft.ireport.locale.I18n;
import com.jaspersoft.ireport.designer.JrxmlPreviewView;
import com.jaspersoft.ireport.designer.templates.TemplateRenderer;
import com.jaspersoft.ireport.designer.utils.Misc;
import com.keypoint.PngEncoder;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Constructor;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import net.sf.jasperreports.engine.util.JRClassLoader;
import net.sf.jasperreports.swing.JRViewerController;
import net.sf.jasperreports.swing.JRViewerEvent;
import net.sf.jasperreports.swing.JRViewerListener;
import net.sf.jasperreports.view.JRSaveContributor;
import net.sf.jasperreports.view.save.JRPrintSaveContributor;
import org.openide.util.Exceptions;

/**
 *
 * @author  gtoffoli
 */
public class JrxmlPreviewToolbar extends JToolBar implements JRViewerListener
{
    private JrxmlPreviewView view = null;

    private final JRViewerController viewerContext;

    protected float MIN_ZOOM = 0.5f;
    protected float MAX_ZOOM = 10f;
    protected int zooms[] = {50, 75, 100, 125, 150, 175, 200, 250, 400, 800};
    protected int defaultZoomIndex = 2;
    protected List saveContributors = new ArrayList();
    protected File lastFolder = null;
    protected JRSaveContributor lastSaveContributor = null;
    protected DecimalFormat zoomDecimalFormat = new DecimalFormat("#.##");


    /** Creates new form JrxmlEditorToolbar */
    public JrxmlPreviewToolbar(JrxmlPreviewView view, JRViewerController viewerContext)
    {
        this.viewerContext = viewerContext;
        this.viewerContext.addListener(this);

        initComponents();
        initSaveContributors();
        
        this.view = view;

        btnSave.setText(I18n.getString("JrxmlPreviewToolbar.btnSave.text")); // NOI18N
        btnSave.setToolTipText(I18n.getString("JrxmlPreviewToolbar.btnSave.toolTipText")); // NOI18N
        btnPrint.setText(I18n.getString("JrxmlPreviewToolbar.btnPrint.text")); // NOI18N
        btnPrint.setToolTipText(I18n.getString("JrxmlPreviewToolbar.btnPrint.toolTipText")); // NOI18N
        btnActualSize.setText(I18n.getString("JrxmlPreviewToolbar.btnActualSize.text")); // NOI18N
        btnFitPage.setText(I18n.getString("JrxmlPreviewToolbar.btnFitPage.text")); // NOI18N
        btnFitPage.setToolTipText(I18n.getString("JrxmlPreviewToolbar.btnFitPage.toolTipText")); // NOI18N
        btnFitWidth.setText(I18n.getString("JrxmlPreviewToolbar.btnFitWidth.text")); // NOI18N
        btnFitWidth.setToolTipText(I18n.getString("JrxmlPreviewToolbar.btnFitWidth.toolTipText")); // NOI18N
        btnZoomIn.setText(I18n.getString("JrxmlPreviewToolbar.btnZoomIn.text")); // NOI18N
        btnZoomIn.setToolTipText(I18n.getString("JrxmlPreviewToolbar.btnZoomIn.toolTipText")); // NOI18N
        btnZoomOut.setText(I18n.getString("JrxmlPreviewToolbar.btnZoomOut.text")); // NOI18N
        btnZoomOut.setToolTipText(I18n.getString("JrxmlPreviewToolbar.btnZoomOut.toolTipText")); // NOI18N
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnRefresh = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        txtGoTo = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnActualSize = new javax.swing.JToggleButton();
        btnFitPage = new javax.swing.JToggleButton();
        btnFitWidth = new javax.swing.JToggleButton();
        btnZoomIn = new javax.swing.JButton();
        btnZoomOut = new javax.swing.JButton();
        cmbZoom = new javax.swing.JComboBox();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();

        setBorder(null);
        setRollover(true);
        add(jSeparator1);

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/refresh-16.png"))); // NOI18N
        btnRefresh.setToolTipText("Run again");
        btnRefresh.setFocusable(false);
        btnRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefresh.setMaximumSize(new java.awt.Dimension(23, 23));
        btnRefresh.setMinimumSize(new java.awt.Dimension(23, 23));
        btnRefresh.setPreferredSize(new java.awt.Dimension(23, 23));
        btnRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/save.GIF"))); // NOI18N
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setMaximumSize(new java.awt.Dimension(23, 23));
        btnSave.setMinimumSize(new java.awt.Dimension(23, 23));
        btnSave.setPreferredSize(new java.awt.Dimension(23, 23));
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave);

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/print.GIF"))); // NOI18N
        btnPrint.setFocusable(false);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setMaximumSize(new java.awt.Dimension(23, 23));
        btnPrint.setMinimumSize(new java.awt.Dimension(23, 23));
        btnPrint.setPreferredSize(new java.awt.Dimension(23, 23));
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        add(btnPrint);
        add(jSeparator2);

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/first.GIF"))); // NOI18N
        btnFirst.setFocusable(false);
        btnFirst.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFirst.setMaximumSize(new java.awt.Dimension(23, 23));
        btnFirst.setMinimumSize(new java.awt.Dimension(23, 23));
        btnFirst.setPreferredSize(new java.awt.Dimension(23, 23));
        btnFirst.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        add(btnFirst);

        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/previous.GIF"))); // NOI18N
        btnPrevious.setFocusable(false);
        btnPrevious.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrevious.setMaximumSize(new java.awt.Dimension(23, 23));
        btnPrevious.setMinimumSize(new java.awt.Dimension(23, 23));
        btnPrevious.setPreferredSize(new java.awt.Dimension(23, 23));
        btnPrevious.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        add(btnPrevious);

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/next.GIF"))); // NOI18N
        btnNext.setFocusable(false);
        btnNext.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNext.setMaximumSize(new java.awt.Dimension(23, 23));
        btnNext.setMinimumSize(new java.awt.Dimension(23, 23));
        btnNext.setPreferredSize(new java.awt.Dimension(23, 23));
        btnNext.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext);

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/last.GIF"))); // NOI18N
        btnLast.setFocusable(false);
        btnLast.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLast.setMaximumSize(new java.awt.Dimension(23, 23));
        btnLast.setMinimumSize(new java.awt.Dimension(23, 23));
        btnLast.setPreferredSize(new java.awt.Dimension(23, 23));
        btnLast.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        add(btnLast);

        txtGoTo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGoTo.setMaximumSize(new java.awt.Dimension(40, 2147483647));
        txtGoTo.setMinimumSize(new java.awt.Dimension(40, 20));
        txtGoTo.setPreferredSize(new java.awt.Dimension(40, 20));
        txtGoTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGoToActionPerformed(evt);
            }
        });
        add(txtGoTo);
        add(jSeparator3);

        btnActualSize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/actualsize.GIF"))); // NOI18N
        btnActualSize.setFocusable(false);
        btnActualSize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualSize.setMaximumSize(new java.awt.Dimension(23, 23));
        btnActualSize.setMinimumSize(new java.awt.Dimension(23, 23));
        btnActualSize.setPreferredSize(new java.awt.Dimension(23, 23));
        btnActualSize.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualSizeActionPerformed(evt);
            }
        });
        add(btnActualSize);

        btnFitPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/fitpage.GIF"))); // NOI18N
        btnFitPage.setFocusable(false);
        btnFitPage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFitPage.setMaximumSize(new java.awt.Dimension(23, 23));
        btnFitPage.setMinimumSize(new java.awt.Dimension(23, 23));
        btnFitPage.setPreferredSize(new java.awt.Dimension(23, 23));
        btnFitPage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFitPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFitPageActionPerformed(evt);
            }
        });
        add(btnFitPage);

        btnFitWidth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/fitwidth.GIF"))); // NOI18N
        btnFitWidth.setFocusable(false);
        btnFitWidth.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFitWidth.setMaximumSize(new java.awt.Dimension(23, 23));
        btnFitWidth.setMinimumSize(new java.awt.Dimension(23, 23));
        btnFitWidth.setPreferredSize(new java.awt.Dimension(23, 23));
        btnFitWidth.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFitWidth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFitWidthActionPerformed(evt);
            }
        });
        add(btnFitWidth);

        btnZoomIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/zoomin-16.png"))); // NOI18N
        btnZoomIn.setFocusable(false);
        btnZoomIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZoomIn.setMaximumSize(new java.awt.Dimension(23, 23));
        btnZoomIn.setMinimumSize(new java.awt.Dimension(23, 23));
        btnZoomIn.setPreferredSize(new java.awt.Dimension(23, 23));
        btnZoomIn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnZoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomInActionPerformed(evt);
            }
        });
        add(btnZoomIn);

        btnZoomOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/zoomout-16.png"))); // NOI18N
        btnZoomOut.setFocusable(false);
        btnZoomOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZoomOut.setMaximumSize(new java.awt.Dimension(23, 23));
        btnZoomOut.setMinimumSize(new java.awt.Dimension(23, 23));
        btnZoomOut.setPreferredSize(new java.awt.Dimension(23, 23));
        btnZoomOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnZoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomOutActionPerformed(evt);
            }
        });
        add(btnZoomOut);

        cmbZoom.setEditable(true);
        cmbZoom.setModel(getZoomComboBoxModel());
        cmbZoom.setMaximumSize(new java.awt.Dimension(70, 32767));
        cmbZoom.setMinimumSize(new java.awt.Dimension(70, 20));
        cmbZoom.setPreferredSize(new java.awt.Dimension(70, 22));
        cmbZoom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbZoomItemStateChanged(evt);
            }
        });
        cmbZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbZoomActionPerformed(evt);
            }
        });
        add(cmbZoom);
        add(jSeparator4);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/resources/template_preview.png"))); // NOI18N
        jButton1.setToolTipText("Create a preview image");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
    }// </editor-fold>//GEN-END:initComponents

    private DefaultComboBoxModel getZoomComboBoxModel()
    {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(int i = 0; i < zooms.length; i++)
        {
            model.addElement("" + zooms[i] + "%");
        }
        return model;
    }

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        getView().setNeedRefresh(true);
        getView().componentShowing();
}//GEN-LAST:event_btnRefreshActionPerformed

    private void btnZoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomInActionPerformed
        btnActualSize.setSelected(false);
        btnFitPage.setSelected(false);
        btnFitWidth.setSelected(false);

        int newZoomInt = (int)(100 * getZoomRatio());
        int index = Arrays.binarySearch(zooms, newZoomInt);
        if (index < 0)
        {
            getViewerContext().setZoomRatio(zooms[- index - 1] / 100f);
        }
        else if (index < cmbZoom.getModel().getSize() - 1)
        {
            getViewerContext().setZoomRatio(zooms[index + 1] / 100f);
        }
}//GEN-LAST:event_btnZoomInActionPerformed

    private void btnZoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomOutActionPerformed
        btnActualSize.setSelected(false);
        btnFitPage.setSelected(false);
        btnFitWidth.setSelected(false);

        int newZoomInt = (int)(100 * getZoomRatio());
        int index = Arrays.binarySearch(zooms, newZoomInt);
        if (index > 0)
        {
            getViewerContext().setZoomRatio(zooms[index - 1] / 100f);
        }
        else if (index < -1)
        {
            getViewerContext().setZoomRatio(zooms[- index - 2] / 100f);
        }
}//GEN-LAST:event_btnZoomOutActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        getViewerContext().setPageIndex(0);
        getViewerContext().refreshPage();
}//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        getViewerContext().setPageIndex(getViewerContext().getPageIndex() - 1);
        getViewerContext().refreshPage();
}//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        getViewerContext().setPageIndex(getViewerContext().getPageIndex() + 1);
        getViewerContext().refreshPage();
}//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        getViewerContext().setPageIndex(getViewerContext().getPageCount() - 1);
        getViewerContext().refreshPage();
}//GEN-LAST:event_btnLastActionPerformed

    private void txtGoToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGoToActionPerformed
        try
        {
            int pageNumber = Integer.parseInt(txtGoTo.getText());
            if (
                pageNumber != getViewerContext().getPageIndex() + 1
                && pageNumber > 0
                && pageNumber <= getViewerContext().getPageCount()
                )
            {
                getViewerContext().setPageIndex(pageNumber - 1);
                getViewerContext().refreshPage();
            }
        }
        catch(NumberFormatException e)
        {
        }
    }//GEN-LAST:event_txtGoToActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        JFileChooser fileChooser = new JFileChooser();
            fileChooser.setLocale(this.getLocale());
            fileChooser.updateUI();
            for(int i = 0; i < saveContributors.size(); i++)
            {
                    fileChooser.addChoosableFileFilter((JRSaveContributor)saveContributors.get(i));
            }

            if (saveContributors.contains(lastSaveContributor))
            {
                    fileChooser.setFileFilter(lastSaveContributor);
            }
            else if (saveContributors.size() > 0)
            {
                    fileChooser.setFileFilter((JRSaveContributor)saveContributors.get(0));
            }

            if (lastFolder != null)
            {
                    fileChooser.setCurrentDirectory(lastFolder);
            }

            int retValue = fileChooser.showSaveDialog(this);
            if (retValue == JFileChooser.APPROVE_OPTION)
            {
                    FileFilter fileFilter = fileChooser.getFileFilter();
                    File file = fileChooser.getSelectedFile();

                    lastFolder = file.getParentFile();

                    JRSaveContributor contributor = null;

                    if (fileFilter instanceof JRSaveContributor)
                    {
                            contributor = (JRSaveContributor)fileFilter;
                    }
                    else
                    {
                            int i = 0;
                            while(contributor == null && i < saveContributors.size())
                            {
                                    contributor = (JRSaveContributor)saveContributors.get(i++);
                                    if (!contributor.accept(file))
                                    {
                                            contributor = null;
                                    }
                            }

                            if (contributor == null)
                            {
                                    contributor = new JRPrintSaveContributor(getLocale(), getViewerContext().getResourceBundle());
                            }
                    }

                    lastSaveContributor = contributor;

                    ClassLoader oldClassLoader = Thread.currentThread().getContextClassLoader();
                    try
                    {
                            Thread.currentThread().setContextClassLoader(IReportManager.getJRExtensionsClassLoader());
                            contributor.save(getViewerContext().getJasperPrint(), file);
                    }
                    catch (JRException e)
                    {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(this, getViewerContext().getBundleString(I18n.getString("JrxmlPreviewToolbar.Message.Warning")));
                    }
                    finally
                    {
                        Thread.currentThread().setContextClassLoader(oldClassLoader);
                    }
            }
}//GEN-LAST:event_btnSaveActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        Thread thread =
			new Thread(
				new Runnable()
				{
					public void run()
					{
						try
						{
							JasperPrintManager.printReport(getViewerContext().getJasperPrint(), true);
						}
						catch (Exception ex)
						{
							ex.printStackTrace();
							JOptionPane.showMessageDialog(getView(), getViewerContext().getBundleString(I18n.getString("JrxmlPreviewToolbar.Message.Warning2")));
						}
					}
				}
			);

		thread.start();
}//GEN-LAST:event_btnPrintActionPerformed

    private void btnActualSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualSizeActionPerformed
        if (btnActualSize.isSelected())
        {
            btnFitPage.setSelected(false);
            btnFitWidth.setSelected(false);
            cmbZoom.setSelectedIndex(-1);
            getViewerContext().setZoomRatio(1);
            btnActualSize.setSelected(true);
        }
    }//GEN-LAST:event_btnActualSizeActionPerformed

    private void btnFitPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFitPageActionPerformed
        if (btnFitPage.isSelected())
        {
            btnActualSize.setSelected(false);
            btnFitWidth.setSelected(false);
            cmbZoom.setSelectedIndex(-1);
            getViewerContext().fitPage();
            btnFitPage.setSelected(true);
        }
    }//GEN-LAST:event_btnFitPageActionPerformed

    private void btnFitWidthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFitWidthActionPerformed
        if (btnFitWidth.isSelected())
        {
            btnActualSize.setSelected(false);
            btnFitPage.setSelected(false);
            cmbZoom.setSelectedIndex(-1);
            getViewerContext().fitWidth();
            btnFitWidth.setSelected(true);
        }
    }//GEN-LAST:event_btnFitWidthActionPerformed

    private void cmbZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbZoomActionPerformed
        float newZoom = getZoomRatio();

        if (newZoom < MIN_ZOOM)
        {
            newZoom = MIN_ZOOM;
        }

        if (newZoom > MAX_ZOOM)
        {
            newZoom = MAX_ZOOM;
        }

        getViewerContext().setZoomRatio(newZoom);
    }//GEN-LAST:event_cmbZoomActionPerformed

    private void cmbZoomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbZoomItemStateChanged
        btnActualSize.setSelected(false);
        btnFitPage.setSelected(false);
        btnFitWidth.setSelected(false);
    }//GEN-LAST:event_cmbZoomItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (getViewerContext().getJasperPrint() != null &&
            getViewerContext().getJasperPrint().getPages().size() > 0 &&
            getViewerContext().getPageIndex() >= 0)
        {
            JasperPrint print = getViewerContext().getJasperPrint();

            BufferedImage bufImage = new BufferedImage(2*print.getPageWidth(), 2*print.getPageHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = bufImage.createGraphics();
            // Export the page in a buffered image...
            
            JRGraphics2DExporter exporter;
            try {
                exporter = new JRGraphics2DExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                exporter.setParameter(JRGraphics2DExporterParameter.ZOOM_RATIO, new Float(2.0));
                exporter.setParameter(JRExporterParameter.PAGE_INDEX, getViewerContext().getPageIndex());
                exporter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D, g);
                exporter.exportReport();

                bufImage = TemplateRenderer.getFasterScaledInstance(bufImage, print.getPageWidth(), print.getPageHeight(),RenderingHints.VALUE_INTERPOLATION_BILINEAR, true);
                Graphics2D gfx = bufImage.createGraphics();
                gfx.setColor(Color.DARK_GRAY);
                gfx.drawRect(0,0,print.getPageWidth()-1, print.getPageHeight()-1);

            } catch (JRException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                return;
            }

            JFileChooser chooser = null;


            if (IReportManager.getPreferences().get("templateChooserDirectory", null) != null)
            {
                chooser = new JFileChooser(IReportManager.getPreferences().get("templateChooserDirectory", null));
            }
            else
            {
                chooser = new JFileChooser(Misc.findStartingDirectory());
            }

            chooser.setFileFilter(new FileFilter() {

                @Override
                public boolean accept(File f) {
                    return f.isDirectory() || f.getName().toLowerCase().endsWith(".png");
                }

                @Override
                public String getDescription() {
                    return "PNG Image";
                }
            });
            
            String fname = print.getName() + ".png";
            fname = Misc.string_replace("_", " ", fname);
            chooser.setSelectedFile(new File(fname));
            try {
                fname = IReportManager.getInstance().getActiveVisualView().getEditorSupport().getDataObject().getPrimaryFile().getNameExt();
                fname = Misc.changeFileExtension(fname, ".png");
                chooser.setSelectedFile(new File(fname));
            } catch (Exception ex){}

            if (chooser.showSaveDialog(Misc.getMainFrame()) == JFileChooser.APPROVE_OPTION)
            {
                IReportManager.getPreferences().put("templateChooserDirectory", chooser.getSelectedFile().getParent());
                try {
                ImageIO.write(bufImage, "png", chooser.getSelectedFile());
                } catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                }
            }


            

        }
         
    }//GEN-LAST:event_jButton1ActionPerformed

    public void init()
    {
        cmbZoom.setSelectedIndex(defaultZoomIndex);
    }

    public void addComponentKeyListener(KeyListener listener)
    {
        btnSave.addKeyListener(listener);
        btnPrint.addKeyListener(listener);
        btnRefresh.addKeyListener(listener);
        btnFirst.addKeyListener(listener);
        btnPrevious.addKeyListener(listener);
        btnPrevious.addKeyListener(listener);
        btnLast.addKeyListener(listener);
        txtGoTo.addKeyListener(listener);
        btnActualSize.addKeyListener(listener);
        btnFitPage.addKeyListener(listener);
        btnFitWidth.addKeyListener(listener);
        btnZoomIn.addKeyListener(listener);
        btnZoomOut.addKeyListener(listener);
        cmbZoom.addKeyListener(listener);
    }



	/**
	 *
	 */
	public void addSaveContributor(JRSaveContributor contributor)
	{
		saveContributors.add(contributor);
	}


	/**
	 *
	 */
	public void removeSaveContributor(JRSaveContributor contributor)
	{
		saveContributors.remove(contributor);
	}


	/**
	 *
	 */
	public JRSaveContributor[] getSaveContributors()
	{
		return (JRSaveContributor[])saveContributors.toArray(new JRSaveContributor[saveContributors.size()]);
	}


	/**
	 * Replaces the save contributors with the ones provided as parameter. 
	 */
	public void setSaveContributors(JRSaveContributor[] saveContributors)
	{
		this.saveContributors = new ArrayList();
		if (saveContributors != null)
		{
			this.saveContributors.addAll(Arrays.asList(saveContributors));
		}
	}


	/**
	 *
	 */
	protected void initSaveContributors()
	{
		final String[] DEFAULT_CONTRIBUTORS =
			{
				"net.sf.jasperreports.view.save.JRPrintSaveContributor",
				"net.sf.jasperreports.view.save.JRPdfSaveContributor",
				"net.sf.jasperreports.view.save.JRRtfSaveContributor",
				"net.sf.jasperreports.view.save.JROdtSaveContributor",
				"net.sf.jasperreports.view.save.JRHtmlSaveContributor",
				"net.sf.jasperreports.view.save.JRSingleSheetXlsSaveContributor",
				"net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor",
				"net.sf.jasperreports.view.save.JRCsvSaveContributor",
				"net.sf.jasperreports.view.save.JRXmlSaveContributor",
				"net.sf.jasperreports.view.save.JREmbeddedImagesXmlSaveContributor"
			};

		for(int i = 0; i < DEFAULT_CONTRIBUTORS.length; i++)
		{
			try
			{
				Class saveContribClass = JRClassLoader.loadClassForName(DEFAULT_CONTRIBUTORS[i]);
				Constructor constructor = saveContribClass.getConstructor(new Class[]{Locale.class, ResourceBundle.class});
				JRSaveContributor saveContrib = (JRSaveContributor)constructor.newInstance(new Object[]{getLocale(), getViewerContext().getResourceBundle()});
				saveContributors.add(saveContrib);
			}
			catch (Exception e)
			{
			}
		}
	}

	protected void reportLoaded()
	{
                // GT: I prefer to have this button always active
		//btnRefresh.setEnabled(getViewerContext().isReloadSupported());
	}

	protected void refreshPage()
	{
		if (!viewerContext.hasPages())
		{
			btnSave.setEnabled(false);
			btnPrint.setEnabled(false);
			btnActualSize.setEnabled(false);
			btnFitPage.setEnabled(false);
			btnFitWidth.setEnabled(false);
			btnZoomIn.setEnabled(false);
			btnZoomOut.setEnabled(false);
			cmbZoom.setEnabled(false);

			return;
		}

		btnSave.setEnabled(true);
		btnPrint.setEnabled(true);
		btnActualSize.setEnabled(true);
		btnFitPage.setEnabled(true);
		btnFitWidth.setEnabled(true);
		btnZoomIn.setEnabled(getViewerContext().getZoom() < MAX_ZOOM);
		btnZoomOut.setEnabled(getViewerContext().getZoom() > MIN_ZOOM);
		cmbZoom.setEnabled(true);
	}

	protected void pageChanged()
	{
		if (getViewerContext().hasPages())
		{
			int pageIndex = getViewerContext().getPageIndex();
			btnFirst.setEnabled( (pageIndex > 0) );
			btnPrevious.setEnabled( (pageIndex > 0) );
			boolean notLast = pageIndex < getViewerContext().getPageCount() - 1;
			btnNext.setEnabled(notLast);
			btnLast.setEnabled(notLast);
			txtGoTo.setEnabled(btnFirst.isEnabled() || btnLast.isEnabled());
			txtGoTo.setText("" + (pageIndex + 1));
		}
		else
		{
			btnFirst.setEnabled(false);
			btnPrevious.setEnabled(false);
			btnNext.setEnabled(false);
			btnLast.setEnabled(false);
			txtGoTo.setEnabled(false);
			txtGoTo.setText("");
		}
	}

	protected float getZoomRatio()
	{
		float newZoom = getViewerContext().getZoom();

		try
		{
			newZoom =
				zoomDecimalFormat.parse(
					String.valueOf(cmbZoom.getEditor().getItem())
					).floatValue() / 100f;
		}
		catch(ParseException e)
		{
		}

		return newZoom;
	}

	protected void zoomChanged()
	{
		cmbZoom.getEditor().setItem(zoomDecimalFormat.format(getViewerContext().getZoom() * 100) + "%");
	}

	public boolean isFitPage()
	{
		return btnFitPage.isSelected();
	}

	public boolean isFitWidth()
	{
		return btnFitPage.isSelected();
	}

	public void setFitWidth()
	{
		btnFitWidth.setSelected(true);
	}

	protected void fitPage()
	{
		btnFitPage.setSelected(true);
	}

	protected void fitWidth()
	{
		btnFitWidth.setSelected(true);
	}

	public void viewerEvent(JRViewerEvent event)
	{
		switch (event.getCode())
		{
		case JRViewerEvent.EVENT_FIT_PAGE:
			fitPage();
			break;
		case JRViewerEvent.EVENT_FIT_WIDTH:
			fitWidth();
			break;
		case JRViewerEvent.EVENT_PAGE_CHANGED:
			pageChanged();
			break;
		case JRViewerEvent.EVENT_REFRESH_PAGE:
			refreshPage();
			break;
		case JRViewerEvent.EVENT_ZOOM_CHANGED:
			zoomChanged();
			break;
		case JRViewerEvent.EVENT_REPORT_LOADED:
			reportLoaded();
			break;
		}
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnActualSize;
    private javax.swing.JButton btnFirst;
    private javax.swing.JToggleButton btnFitPage;
    private javax.swing.JToggleButton btnFitWidth;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnZoomIn;
    private javax.swing.JButton btnZoomOut;
    private javax.swing.JComboBox cmbZoom;
    private javax.swing.JButton jButton1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JTextField txtGoTo;
    // End of variables declaration//GEN-END:variables

    public JRViewerController getViewerContext() {
        return viewerContext;
    }

    public JrxmlPreviewView getView() {
        return view;
    }

    
}

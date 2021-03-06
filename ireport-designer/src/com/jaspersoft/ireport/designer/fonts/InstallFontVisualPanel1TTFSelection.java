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

package com.jaspersoft.ireport.designer.fonts;

import com.jaspersoft.ireport.designer.IReportManager;
import java.io.File;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public final class InstallFontVisualPanel1TTFSelection extends JPanel {

    InstallFontWizardPanel2TTFSelection wizardPanel = null;
    /** Creates new form InstallFontVisualPanel1 */
    public InstallFontVisualPanel1TTFSelection(InstallFontWizardPanel2TTFSelection wizardPanel) {
        initComponents();
        this.wizardPanel = wizardPanel;

        jTextFieldTTFFont.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                notifyChange();
            }

            public void removeUpdate(DocumentEvent e) {
                notifyChange();
            }

            public void changedUpdate(DocumentEvent e) {
                notifyChange();
            }
        });
    }

    public void notifyChange()
    {
        if (wizardPanel != null)
        {
            wizardPanel.fireChangeEvent();
        }
    }

    @Override
    public String getName() {
        return "Font selection";
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelTTFFont = new javax.swing.JLabel();
        jTextFieldTTFFont = new javax.swing.JTextField();
        jButtonBrowse = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(InstallFontVisualPanel1TTFSelection.class, "InstallFontVisualPanel1TTFSelection.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabelTTFFont, org.openide.util.NbBundle.getMessage(InstallFontVisualPanel1TTFSelection.class, "InstallFontVisualPanel1TTFSelection.jLabelTTFFont.text")); // NOI18N

        jTextFieldTTFFont.setText(org.openide.util.NbBundle.getMessage(InstallFontVisualPanel1TTFSelection.class, "InstallFontVisualPanel1TTFSelection.jTextFieldTTFFont.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButtonBrowse, org.openide.util.NbBundle.getMessage(InstallFontVisualPanel1TTFSelection.class, "InstallFontVisualPanel1TTFSelection.jButtonBrowse.text")); // NOI18N
        jButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jTextFieldTTFFont, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButtonBrowse))
                    .add(jLabelTTFFont))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 87, Short.MAX_VALUE)
                .add(jLabelTTFFont)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jButtonBrowse)
                    .add(jTextFieldTTFFont, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(75, 75, 75))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseActionPerformed
        InstallFontWizardDescriptor.browseForTTFFile(jTextFieldTTFFont);
    }//GEN-LAST:event_jButtonBrowseActionPerformed


    public void validateForm() throws IllegalArgumentException
    {
        if (jTextFieldTTFFont.getText().trim().length() == 0) throw new IllegalArgumentException("Please specify a valid TrueType font file");
        File f = new File(jTextFieldTTFFont.getText().trim());
        if (!f.exists())
        {
            throw new IllegalArgumentException("The file specified does not exist.");
        }
    }

    public void readSettings(Object settings) {



    }

    public void storeSettings(Object settings) {

        ((InstallFontWizardDescriptor)settings).putProperty("normal_ttf_file", jTextFieldTTFFont.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBrowse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTTFFont;
    private javax.swing.JTextField jTextFieldTTFFont;
    // End of variables declaration//GEN-END:variables
}


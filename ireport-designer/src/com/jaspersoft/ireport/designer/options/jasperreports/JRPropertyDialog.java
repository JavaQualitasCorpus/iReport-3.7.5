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
package com.jaspersoft.ireport.designer.options.jasperreports;

import com.jaspersoft.ireport.locale.I18n;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author  Administrator
 */
public class JRPropertyDialog extends javax.swing.JDialog {
    /** Creates new form JRParameterDialog */
    private String originalName = null;
    private List<String> existingPropertiesNames = new ArrayList<String>();
    private String propertyName = null;
    private String propertyValue = null;

    
    public JRPropertyDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initAll();
    }

    public JRPropertyDialog(java.awt.Frame parent, boolean modal) {        
        super(parent, modal);
        initAll();
    }

    public void initAll()
    {
        initComponents();
        applyI18n();

        javax.swing.KeyStroke escape =  javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0, false);
        javax.swing.Action escapeAction = new javax.swing.AbstractAction() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                jButtonCancelActionPerformed(e);
            }
        };
       
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, I18n.getString("Global.Pane.Escape"));
        getRootPane().getActionMap().put(I18n.getString("Global.Pane.Escape"), escapeAction);


       
        //to make the default button ...
        this.getRootPane().setDefaultButton(this.jButtonOK);
        this.pack();
        this.setLocationRelativeTo(null);
    }

   
    
  
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jTextFieldName1 = new javax.swing.JTextField();
        jLabelSpecialCharacters = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setTitle("Add property");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setText("Property name");
        jLabel1.setMaximumSize(new java.awt.Dimension(1000, 100));
        jLabel1.setMinimumSize(new java.awt.Dimension(100, 15));
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 15));

        jLabel4.setText("Property value");

        jButtonOK.setMnemonic('o');
        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonCancel.setMnemonic('c');
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabelSpecialCharacters.setText("<html>Special characters:<br><b>\\n</b>\tfor newline<br><b>\\r</b>\tfor carriage return<br><b>\\t</b>\tfor tab and<br><b>\\\\</b>\tfor a single backslash");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jTextFieldName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 242, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jTextFieldName1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabelSpecialCharacters)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(383, Short.MAX_VALUE)
                .add(jButtonOK)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButtonCancel)
                .addContainerGap())
            .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(2, 2, 2)
                .add(jTextFieldName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextFieldName1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelSpecialCharacters)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButtonCancel)
                    .add(jButtonOK))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-527)/2, (screenSize.height-262)/2, 527, 262);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        setVisible(false);
        this.setDialogResult( javax.swing.JOptionPane.CANCEL_OPTION);
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        
        if (this.jTextFieldName.getText().trim().length() <= 0)
        {
            javax.swing.JOptionPane.showMessageDialog(this,
                    I18n.getString("JRPropertyDialog.Message.Warning"),I18n.getString("JRPropertyDialog.Message.Warning2"),
                    //I18n.getString( "messages.jRPropertyDialog.notValidName","Please insert a valid property name!"),
                    //I18n.getString( "messages.jRPropertyDialog.notValidNameCaption","Invalid property!"),
                    javax.swing.JOptionPane.WARNING_MESSAGE );
            return;
        }
        
        // check if the name is valid...
        if (getExistingPropertiesNames() != null)
        {
            String name = jTextFieldName.getText().trim();
            if (getExistingPropertiesNames().contains(name))
            {
                if (originalName == null || !originalName.equals(name))
                {
                    javax.swing.JOptionPane.showMessageDialog(this,
                    I18n.getString("JRPropertyDialog.Message.warning3"),I18n.getString("JRPropertyDialog.Message.Warning4"),
                    //I18n.getString( "messages.jRPropertyDialog.notValidName","Please insert a valid property name!"),
                    //I18n.getString( "messages.jRPropertyDialog.notValidNameCaption","Invalid property!"),
                    javax.swing.JOptionPane.WARNING_MESSAGE );
                    return;
                }
            }
        }

        this.propertyName = jTextFieldName.getText().trim();
        this.propertyValue = jTextFieldName1.getText();
                
        setVisible(false);
        this.setDialogResult( javax.swing.JOptionPane.OK_OPTION);
        dispose();
    }//GEN-LAST:event_jButtonOKActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        this.setDialogResult( javax.swing.JOptionPane.CLOSED_OPTION);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new JRPropertyDialog(new javax.swing.JFrame(), true).setVisible(true);
    }
    
    

    public void setPropertyName(String name) {
        this.jTextFieldName.setText( name);
        originalName = name;
    }


    public void setPropertyValue(String value) {
        this.jTextFieldName1.setText( value);
    }
    
    /** Getter for property dialogResult.
     * @return Value of property dialogResult.
     *
     */
    public int getDialogResult() {
        return dialogResult;
    }
    
    /** Setter for property dialogResult.
     * @param dialogResult New value of property dialogResult.
     *
     */
    public void setDialogResult(int dialogResult) {
        this.dialogResult = dialogResult;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelSpecialCharacters;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldName1;
    // End of variables declaration//GEN-END:variables

    private int dialogResult;    
    
    public void applyI18n(){
        /*
                // Start autogenerated code ----------------------
                jButtonCancel.setText(I18n.getString("jRPropertyDialog.buttonCancel","Cancel"));
                jButtonOK.setText(I18n.getString("jRPropertyDialog.buttonOK","OK"));
                jLabel1.setText(I18n.getString("jRPropertyDialog.label1","Property name"));
                jLabel4.setText(I18n.getString("jRPropertyDialog.label4","Property value"));
                // End autogenerated code ----------------------
                
                this.setTitle(I18n.getString("jRPropertyDialog.title","Add/modify property"));
                jButtonCancel.setMnemonic(I18n.getString("jRPropertyDialog.buttonCancelMnemonic","c").charAt(0));
                jButtonOK.setMnemonic(I18n.getString("jRPropertyDialog.buttonOKMnemonic","o").charAt(0));
         */
    }

   
    /**
     * @return the propertyName
     */
    public String getPropertyName() {
        return propertyName;
    }

   
    /**
     * @return the propertyValue
     */
    public String getPropertyValue() {
        return propertyValue;
    }

 
    /**
     * @return the existingPropertiesNames
     */
    public List<String> getExistingPropertiesNames() {
        return existingPropertiesNames;
    }

    /**
     * @param existingPropertiesNames the existingPropertiesNames to set
     */
    public void setExistingPropertiesNames(List<String> existingPropertiesNames) {
        this.existingPropertiesNames = existingPropertiesNames;
    }
}

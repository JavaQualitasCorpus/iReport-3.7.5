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
import com.jaspersoft.ireport.designer.editor.ExpressionContext;
import com.jaspersoft.ireport.designer.utils.Misc;
import java.awt.Dialog;
import java.awt.Frame;
import java.util.Map;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignSubreportParameter;

/**
 *
 * @author  Administrator
 */
public class JRSubreportParameterDialog extends javax.swing.JDialog {
    /** Creates new form JRParameterDialog */
    JRDesignSubreportParameter tmpParameter = null;
    private String oldName = null;
    private Map currentParameters = null;
    
    public JRSubreportParameterDialog(Dialog parent, Map currentParameters) 
    {
         super(parent);
         initAll(currentParameters);
    }

    /** Creates new form ReportQueryFrame */
    public JRSubreportParameterDialog(Frame parent, Map currentParameters) 
    {
         super(parent);
         initAll(currentParameters);
    }

    
    public void initAll(Map currentParameters) {
   
        setModal(true);
        initComponents();
        this.currentParameters = currentParameters;
        //applyI18n();
        this.jRTextExpressionAreaDefaultExpression.setText("");   
        
        // we have to force the context of the parameter.
        setLocationRelativeTo(null);
        
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
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRTextExpressionAreaDefaultExpression = new com.jaspersoft.ireport.designer.editor.ExpressionEditorArea();
        jSeparator1 = new javax.swing.JSeparator();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/jaspersoft/ireport/locale/Bundle"); // NOI18N
        setTitle(bundle.getString("JRSubreportParameterDialog.Title.AddModParam")); // NOI18N
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButtonOK.setMnemonic('o');
        jButtonOK.setText(bundle.getString("Global.Button.Ok")); // NOI18N
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonOK);

        jButtonCancel.setMnemonic('c');
        jButtonCancel.setText(bundle.getString("Global.Button.Cancel")); // NOI18N
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setPreferredSize(new java.awt.Dimension(350, 250));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText(bundle.getString("JRSubreportParameterDialog.Label.SubreportParamName")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        jPanel2.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        jPanel2.add(jTextFieldName, gridBagConstraints);

        jLabel3.setText(bundle.getString("JRSubreportParameterDialog.Label.ValueExpression")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(jLabel3, gridBagConstraints);

        jRTextExpressionAreaDefaultExpression.setPreferredSize(new java.awt.Dimension(300, 80));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 3, 3);
        jPanel2.add(jRTextExpressionAreaDefaultExpression, gridBagConstraints);

        jSeparator1.setMinimumSize(new java.awt.Dimension(2, 2));
        jSeparator1.setPreferredSize(new java.awt.Dimension(2, 2));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(jSeparator1, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 320, 220);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        setVisible(false);
        this.setDialogResult( javax.swing.JOptionPane.CANCEL_OPTION);
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        
        String newName = this.jTextFieldName.getText().trim();
        if (newName.length() <= 0)
        {
            javax.swing.JOptionPane.showMessageDialog(this,
                    I18n.getString("JRSubreportParameterDialog.Message.Warning"),
                    I18n.getString("JRSubreportParameterDialog.Message.Error"),
                    javax.swing.JOptionPane.WARNING_MESSAGE );
            return;
        }
        
        if (oldName != null && 
            !oldName.equals(newName) &&
            currentParameters != null &&
            currentParameters.containsKey(newName))
        {
            javax.swing.JOptionPane.showMessageDialog(this,
                    I18n.getString("JRSubreportParameterDialog.Message.Warning2"),
                    I18n.getString("JRSubreportParameterDialog.Message.Error2"),
                    javax.swing.JOptionPane.WARNING_MESSAGE );
            return;
        }
        
        tmpParameter = new JRDesignSubreportParameter();

        tmpParameter.setName(this.jTextFieldName.getText().trim());
        JRDesignExpression exp = new JRDesignExpression();
        exp.setText(this.jRTextExpressionAreaDefaultExpression.getText());
        exp.setValueClassName("java.lang.Object");
        tmpParameter.setExpression(exp);
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
    
    /** Getter for property tmpParameter.
     * @return Value of property tmpParameter.
     *
     */
    public JRDesignSubreportParameter getParameter() {
        return tmpParameter;
    }    
    
    /** Setter for property tmpParameter.
     * @param tmpParameter New value of property tmpParameter.
     *
     */
    public void setParameter(JRDesignSubreportParameter tmpParameter) {
        this.jTextFieldName.setText( tmpParameter.getName() );
        
        oldName =tmpParameter.getName();
        
        String text = "";
        
        if (tmpParameter.getExpression() != null  &&
            tmpParameter.getExpression().getText() != null )
        {
            text = tmpParameter.getExpression().getText();
        }
                    
        this.jRTextExpressionAreaDefaultExpression.setText( text );                       
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.jaspersoft.ireport.designer.editor.ExpressionEditorArea jRTextExpressionAreaDefaultExpression;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables

    private int dialogResult;    
    
    /*
    public void applyI18n(){
                // Start autogenerated code ----------------------
                jButtonCancel.setText(I18n.getString("jRSubreportParameterDialog.buttonCancel","Cancel"));
                jButtonOK.setText(I18n.getString("jRSubreportParameterDialog.buttonOK","OK"));
                jLabel1.setText(I18n.getString("jRSubreportParameterDialog.label1","Subreport parameter name"));
                jLabel3.setText(I18n.getString("jRSubreportParameterDialog.label3","Default value expression"));
                // End autogenerated code ----------------------
                this.setTitle(I18n.getString("jRSubreportParameterDialog.title","Add/modify parameter"));
                jButtonCancel.setMnemonic(I18n.getString("jRSubreportParameterDialog.buttonCancelMnemonic","c").charAt(0));
                jButtonOK.setMnemonic(I18n.getString("jRSubreportParameterDialog.buttonOKMnemonic","o").charAt(0));
    }
     */
    
    public static final int COMPONENT_NONE=0;
    public static final int COMPONENT_PARAM_NAME=1;
    public static final int COMPONENT_PARAM_EXPRESSION=2;
    
    /**
     * This method set the focus on a specific component.
     * Valid constants are something like:
     * COMPONENT_NONE, COMPONENT_PARAM_NAME, ...
     *
     */
    public void setFocusedExpression(int expID)
    {
        try {
            switch (expID)
            {
                case COMPONENT_PARAM_EXPRESSION:
                    Misc.selectTextAndFocusArea(jRTextExpressionAreaDefaultExpression);
                    break;
                case COMPONENT_PARAM_NAME:
                    Misc.selectTextAndFocusArea(jTextFieldName);
                    break;  
            }
        } catch (Exception ex) { }
    }    
    
    public void setExpressionContext(ExpressionContext context)
    {
        this.jRTextExpressionAreaDefaultExpression.setExpressionContext(context);
    }
}

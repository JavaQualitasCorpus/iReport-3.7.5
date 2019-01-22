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
package com.jaspersoft.jrx;

import com.jaspersoft.ireport.designer.IReportConnection;
import com.jaspersoft.ireport.designer.IReportConnectionEditor;
import com.jaspersoft.ireport.designer.tools.FieldPatternDialog;
import com.jaspersoft.ireport.designer.tools.LocaleSelectorDialog;
import com.jaspersoft.ireport.designer.tools.TimeZoneDialog;
import com.jaspersoft.ireport.designer.utils.Misc;
import com.jaspersoft.ireport.locale.I18n;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author  gtoffoli
 */
public class JRXMLDataSourceConnectionEditor extends javax.swing.JPanel implements IReportConnectionEditor {
    
    private IReportConnection iReportConnection = null;
    private boolean init = false;
    private Locale tmpXMLLocale = null;
    private TimeZone tmpXMLTimeZone = null;
    
    /** Creates new form JRXMLDataSourceConnectionEditor */
    public JRXMLDataSourceConnectionEditor() {
        initComponents();
        applyI18n();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelXML = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldXMLFile = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabelXMLDatePattern = new javax.swing.JLabel();
        jTextFieldXMLDatePattern = new javax.swing.JTextField();
        jButtonXMLDatePattern = new javax.swing.JButton();
        jLabelXMLNumberPattern = new javax.swing.JLabel();
        jTextFieldXMLNumberPattern = new javax.swing.JTextField();
        jButtonXMLNumberPattern = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabelXMLLocale = new javax.swing.JLabel();
        jTextFieldXMLLocaleValue = new javax.swing.JTextField();
        jLabelXMLTimeZone = new javax.swing.JLabel();
        jButtonXMLLocale = new javax.swing.JButton();
        jTextFieldXMLTimeZoneValue = new javax.swing.JTextField();
        jButtonXMLTimeZone = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanelXML.setLayout(new java.awt.GridBagLayout());

        jPanelXML.setPreferredSize(new java.awt.Dimension(1, 30));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel9.setText("XML URL");
        jLabel9.setMinimumSize(new java.awt.Dimension(20, 14));
        jLabel9.setPreferredSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jLabel9, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jTextFieldXMLFile, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelXML.add(jPanel1, gridBagConstraints);

        jSeparator9.setPreferredSize(new java.awt.Dimension(2, 2));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 4, 8, 4);
        jPanelXML.add(jSeparator9, gridBagConstraints);

        jLabelXMLDatePattern.setText("Date pattern");
        jLabelXMLDatePattern.setPreferredSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanelXML.add(jLabelXMLDatePattern, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 232;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanelXML.add(jTextFieldXMLDatePattern, gridBagConstraints);

        jButtonXMLDatePattern.setText("Create");
        jButtonXMLDatePattern.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jButtonXMLDatePattern.setMaximumSize(new java.awt.Dimension(100, 25));
        jButtonXMLDatePattern.setMinimumSize(new java.awt.Dimension(70, 25));
        jButtonXMLDatePattern.setPreferredSize(new java.awt.Dimension(70, 25));
        jButtonXMLDatePattern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed1(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.ipady = -3;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 7);
        jPanelXML.add(jButtonXMLDatePattern, gridBagConstraints);

        jLabelXMLNumberPattern.setText("Number pattern");
        jLabelXMLNumberPattern.setPreferredSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.insets = new java.awt.Insets(1, 3, 3, 3);
        jPanelXML.add(jLabelXMLNumberPattern, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 232;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 3, 3, 3);
        jPanelXML.add(jTextFieldXMLNumberPattern, gridBagConstraints);

        jButtonXMLNumberPattern.setText("Create");
        jButtonXMLNumberPattern.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jButtonXMLNumberPattern.setMaximumSize(new java.awt.Dimension(100, 25));
        jButtonXMLNumberPattern.setMinimumSize(new java.awt.Dimension(70, 25));
        jButtonXMLNumberPattern.setPreferredSize(new java.awt.Dimension(70, 25));
        jButtonXMLNumberPattern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXMLDatePatternjButton2ActionPerformed1(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.ipady = -3;
        gridBagConstraints.insets = new java.awt.Insets(1, 3, 3, 7);
        jPanelXML.add(jButtonXMLNumberPattern, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Locale / Time zone"));
        jLabelXMLLocale.setText("Locale");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel3.add(jLabelXMLLocale, gridBagConstraints);

        jTextFieldXMLLocaleValue.setEditable(false);
        jTextFieldXMLLocaleValue.setText("Default");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 232;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 4);
        jPanel3.add(jTextFieldXMLLocaleValue, gridBagConstraints);

        jLabelXMLTimeZone.setText("Time zone");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        jPanel3.add(jLabelXMLTimeZone, gridBagConstraints);

        jButtonXMLLocale.setText("Select...");
        jButtonXMLLocale.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jButtonXMLLocale.setMaximumSize(new java.awt.Dimension(100, 25));
        jButtonXMLLocale.setMinimumSize(new java.awt.Dimension(70, 25));
        jButtonXMLLocale.setPreferredSize(new java.awt.Dimension(70, 25));
        jButtonXMLLocale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXMLDatePatternjButton2ActionPerformed11(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.ipady = -3;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 8);
        jPanel3.add(jButtonXMLLocale, gridBagConstraints);

        jTextFieldXMLTimeZoneValue.setEditable(false);
        jTextFieldXMLTimeZoneValue.setText("Default");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 232;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 4);
        jPanel3.add(jTextFieldXMLTimeZoneValue, gridBagConstraints);

        jButtonXMLTimeZone.setText("Select...");
        jButtonXMLTimeZone.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jButtonXMLTimeZone.setMaximumSize(new java.awt.Dimension(100, 25));
        jButtonXMLTimeZone.setMinimumSize(new java.awt.Dimension(70, 25));
        jButtonXMLTimeZone.setPreferredSize(new java.awt.Dimension(70, 25));
        jButtonXMLTimeZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXMLDatePattern1jButtonXMLDatePatternjButton2ActionPerformed11(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.ipady = -3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 8);
        jPanel3.add(jButtonXMLTimeZone, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 3, 0, 4);
        jPanelXML.add(jPanel3, gridBagConstraints);

        add(jPanelXML, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String fileName = "";
	    javax.swing.JFileChooser jfc = new javax.swing.JFileChooser( Misc.findStartingDirectory());
	    
	    jfc.setDialogTitle("Select XML file....");
	    
	    jfc.addChoosableFileFilter( new javax.swing.filechooser.FileFilter() {
		    public boolean accept(java.io.File file) {
			    String filename = file.getName();
			    return (filename.toLowerCase().endsWith(".xml") || file.isDirectory()) ;
		    }
		    public String getDescription() {
			    return "XML *.xml";
		    }
	    });
	    
	    jfc.setMultiSelectionEnabled(false);
	    jfc.setDialogType( javax.swing.JFileChooser.OPEN_DIALOG);
	    if  (jfc.showOpenDialog( this) == javax.swing.JOptionPane.OK_OPTION) {
		    java.io.File file = jfc.getSelectedFile();		
                    try {
                        jTextFieldXMLFile.setText( file.getAbsolutePath() );
                    } catch (Exception ex){}
	    }        
        
        
    }    
    
    private void jButtonXMLDatePattern1jButtonXMLDatePatternjButton2ActionPerformed11(java.awt.event.ActionEvent evt) {                                                                                      

            TimeZoneDialog lsd = new TimeZoneDialog((JDialog)SwingUtilities.getWindowAncestor(this), true);
            if (this.tmpXMLTimeZone != null)
            {
                lsd.setReportTimeZoneId( tmpXMLTimeZone.getID() );
            }
            
            lsd.setVisible(true);
            
            if (lsd.getDialogResult() == JOptionPane.OK_OPTION)
            {
                if (lsd.getReportTimeZoneId() == null)
                {
                    tmpXMLTimeZone = null;
                    jTextFieldXMLTimeZoneValue.setText( I18n.getString("timezone.default") );
                }
                else
                {
                    tmpXMLTimeZone = TimeZone.getTimeZone( lsd.getReportTimeZoneId() );
                    jTextFieldXMLTimeZoneValue.setText( tmpXMLTimeZone.getDisplayName( Locale.getDefault() ) );
                }
            }
    }                                                                                     

    private void jButtonXMLDatePatternjButton2ActionPerformed11(java.awt.event.ActionEvent evt) {                                                                

            LocaleSelectorDialog lsd = new LocaleSelectorDialog((JDialog)SwingUtilities.getWindowAncestor(this), true);
            if (this.tmpXMLLocale != null)
            {
                lsd.setSelectedLocale( this.tmpXMLLocale );
            }
            
            lsd.setVisible(true);
            
            if (lsd.getDialogResult() == JOptionPane.OK_OPTION)
            {
                tmpXMLLocale = lsd.getSelectedLocale();
                jTextFieldXMLLocaleValue.setText( 
                        (tmpXMLLocale == null) ? I18n.getString("timezone.default") :
                        tmpXMLLocale.getDisplayName( Locale.getDefault()) );
            }
        
    }                                                               

    private void jButtonXMLDatePatternjButton2ActionPerformed1(java.awt.event.ActionEvent evt) {                                                               

            FieldPatternDialog fpd = new FieldPatternDialog((JDialog)SwingUtilities.getWindowAncestor(this), true);
            fpd.setOnlyNumbers(true);
            if (jTextFieldXMLNumberPattern.getText().length() >0)
            {
                fpd.setPattern( jTextFieldXMLNumberPattern.getText() );
            }
            
            fpd.setVisible(true);
            
            if (fpd.getDialogResult() == JOptionPane.OK_OPTION)
            {
                jTextFieldXMLNumberPattern.setText( fpd.getPattern() );
            }
        
        
    }                                                              

    private void jButton2ActionPerformed1(java.awt.event.ActionEvent evt) {                                          
            
            FieldPatternDialog fpd = new FieldPatternDialog((JDialog)SwingUtilities.getWindowAncestor(this), true);
            fpd.setOnlyDate(true);
            if (jTextFieldXMLDatePattern.getText().length() >0)
            {
                fpd.setPattern( jTextFieldXMLDatePattern.getText() );
            }
            
            fpd.setVisible(true);
            
            if (fpd.getDialogResult() == JOptionPane.OK_OPTION)
            {
                jTextFieldXMLDatePattern.setText( fpd.getPattern() );
            }
    }  

    public void setIReportConnection(IReportConnection c) {
        
        this.iReportConnection = c;
        if (iReportConnection instanceof JRXMLDataSourceConnection)
        {
            JRXMLDataSourceConnection con = (JRXMLDataSourceConnection)iReportConnection;
            this.jTextFieldXMLFile.setText( con.getFilename() );
            
            this.jTextFieldXMLDatePattern.setText( Misc.nvl(con.getDatePattern() ,"") );
            this.jTextFieldXMLNumberPattern.setText( Misc.nvl(con.getNumberPattern() ,"") );
            
            this.tmpXMLLocale = con.getLocale();
            if (this.tmpXMLLocale != null )
            {
                jTextFieldXMLLocaleValue.setText(  this.tmpXMLLocale.getDisplayName( Locale.getDefault()) );
            }
            else
            {
                jTextFieldXMLLocaleValue.setText( I18n.getString("timezone.default") );
            }
            
            this.tmpXMLTimeZone = con.getTimeZone();
            if (this.tmpXMLLocale != null)
            {
                jTextFieldXMLTimeZoneValue.setText(  tmpXMLTimeZone.getDisplayName( Locale.getDefault() ) );
            }
            else
            {
                jTextFieldXMLTimeZoneValue.setText( I18n.getString("timezone.default") );
            }
        }
    }

    public IReportConnection getIReportConnection() {
        
        IReportConnection irConn = new JRXMLDataSourceConnection();
        ((JRXMLDataSourceConnection)irConn).setFilename( this.jTextFieldXMLFile.getText().trim() );
        //((JRXMLDataSourceConnection)irConn).setSelectExpression( this.jTextFieldRecordPath.getText().trim() );
        ((JRXMLDataSourceConnection)irConn).setUseConnection( true );

        ((JRXMLDataSourceConnection)irConn).setDatePattern( jTextFieldXMLDatePattern.getText());
        ((JRXMLDataSourceConnection)irConn).setNumberPattern( jTextFieldXMLNumberPattern.getText());
        ((JRXMLDataSourceConnection)irConn).setLocale( this.tmpXMLLocale );
        ((JRXMLDataSourceConnection)irConn).setTimeZone( this.tmpXMLTimeZone );

        iReportConnection = irConn;
        return iReportConnection;
    }
    
    
        public void applyI18n(){
                // Start autogenerated code ----------------------
                //jRadioButtonXML_connection.setText(I18n.getString("connectionDialog.radioButtonXML_connection","Use the report XPath expression when filling the report"));
                //jRadioButtonXML_datasource.setText(I18n.getString("connectionDialog.radioButtonXML_datasource","Create a datasource using this expression"));
                // End autogenerated code ----------------------
                // Start autogenerated code ----------------------
                //jButton2.setText(I18n.getString("connectionDialog.button2","Browse"));
                //jLabel9.setText(I18n.getString("connectionDialog.label9","XML file"));
                //jLabelXMLRecordPath.setText(I18n.getString("connectionDialog.labelXMLRecordPath","Select Expression"));
                // End autogenerated code ----------------------
                
                
                
                jTextFieldXMLTimeZoneValue.setText( I18n.getString("timezone.default") );
                jTextFieldXMLLocaleValue.setText( I18n.getString("timezone.default") );
                
                ((javax.swing.border.TitledBorder)jPanel3.getBorder()).setTitle( I18n.getString("connectionDialog.borderXMLLocaleTimeZone","Locale / Time zone") );
                
                jLabelXMLLocale.setText( I18n.getString("connectionDialog.labelXMLLocale") );
                jLabelXMLTimeZone.setText( I18n.getString("connectionDialog.labelXMLTimeZone") );
                jLabelXMLDatePattern.setText( I18n.getString("connectionDialog.labelXMLDatePattern") );
                jLabelXMLNumberPattern.setText( I18n.getString("connectionDialog.labelXMLNumberPattern") );
                jButtonXMLDatePattern.setText( I18n.getString("connectionDialog.buttonXMLDatePattern") );
                jButtonXMLNumberPattern.setText( I18n.getString("connectionDialog.buttonXMLNumberPattern") );
                jButtonXMLLocale.setText( I18n.getString("connectionDialog.buttonXMLLocale") );
                jButtonXMLTimeZone.setText( I18n.getString("connectionDialog.buttonXMLTimeZone") );
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonXMLDatePattern;
    private javax.swing.JButton jButtonXMLLocale;
    private javax.swing.JButton jButtonXMLNumberPattern;
    private javax.swing.JButton jButtonXMLTimeZone;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelXMLDatePattern;
    private javax.swing.JLabel jLabelXMLLocale;
    private javax.swing.JLabel jLabelXMLNumberPattern;
    private javax.swing.JLabel jLabelXMLTimeZone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelXML;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextFieldXMLDatePattern;
    private javax.swing.JTextField jTextFieldXMLFile;
    private javax.swing.JTextField jTextFieldXMLLocaleValue;
    private javax.swing.JTextField jTextFieldXMLNumberPattern;
    private javax.swing.JTextField jTextFieldXMLTimeZoneValue;
    // End of variables declaration//GEN-END:variables
    
}

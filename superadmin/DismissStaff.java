/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superadmin;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author franq
 */
public class DismissStaff extends javax.swing.JFrame {

    /**
     * Creates new form EditStaff
     */
    
    private ArrayList<String> staffdetails;
    private static String disptitle, dispsurname,dispfname;
    private static int currentuserid;
    private static String surnamel,fnamel,lnamel,searchid; 
    private java.util.Date today;
    private static String contactID;
    
    public DismissStaff(int userid, int sid,String surnamec, String fnamec, String lnamec) {
        initComponents();
        currentuserid = userid;
        searchid = Integer.toString(sid);
        surnamel = surnamec;
        fnamel = fnamec;
        lnamel = lnamec;
        today = new java.util.Date();
        
        //get results set from query
        
        if(sid != 0)
        staffdetails = selects.QuerySearchStaff.getStudentInfo(searchid);
        else if(sid == 0)
        staffdetails = selects.QuerySearchStaff.getStudentInfo(surnamec, fnamec, lnamec);
        
        
        
        String gender,dob,nationalID, title, surname, fname,lname, jobtitle, role, whetherworkingstr;
        boolean whetherworking;
        java.util.Date parsed = null;
        
        //get all the required data from the databaseto be updated
        //data is got from the result set
        gender = staffdetails.get(0);
        dob = staffdetails.get(1);
        nationalID = staffdetails.get(2);
        title = staffdetails.get(3);
        disptitle = title;
        surname = staffdetails.get(4);
        dispsurname = surname;
        fname = staffdetails.get(5);
        dispfname = fname;
        lname = staffdetails.get(6);
        jobtitle = staffdetails.get(7);
        role =  staffdetails.get(8);
        whetherworkingstr = staffdetails.get(9);
        contactID = staffdetails.get(10);
        
        //initialize forms data after its loaded
        cmbstaffgender.setSelectedItem(gender);
        
        //date         
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            parsed = format.parse(dob);
        } catch (ParseException ex) {
            Logger.getLogger(DismissStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        jtfnationalid.setText(nationalID);
        cmbstafftitle.setSelectedItem(title);
        jtfsurname.setText(surname);
        jtffirstname.setText(fname);
        jtflastname.setText(lname);
        jtfjobtitle.setText(jobtitle);
        jtarole.setText(role);
        //set the edit staff details
        if(Integer.parseInt(whetherworkingstr)==1)
        {
            whetherworking = true;
            jrworking.setSelected(true);
            jrnotworking.setSelected(false);
        }
        else if(Integer.parseInt(whetherworkingstr)==0)
        {
            whetherworking=false;
            jrworking.setSelected(false);
            jrnotworking.setSelected(true);
        }
        jXDOB.setDate(parsed);
        
        this.setTitle("Edit Staff");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        staffdetailspanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbstaffgender = new javax.swing.JComboBox();
        cmbstafftitle = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jtfsurname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtffirstname = new javax.swing.JTextField();
        jtflastname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jtfjobtitle = new javax.swing.JTextField();
        jbtcancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtarole = new javax.swing.JTextArea();
        jtfnationalid = new javax.swing.JFormattedTextField();
        jXDOB = new com.toedter.calendar.JDateChooser();
        jbtcancel1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jrworking = new javax.swing.JRadioButton();
        jrnotworking = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Staff");
        setIconImage(selects.QueryMainDetails.setIcon());
        setResizable(false);

        staffdetailspanel.setForeground(new java.awt.Color(0, 0, 240));

        jLabel1.setForeground(new java.awt.Color(0, 0, 240));
        jLabel1.setText("National ID");

        jLabel2.setForeground(new java.awt.Color(0, 0, 240));
        jLabel2.setText("Gender");

        jLabel10.setForeground(new java.awt.Color(0, 0, 240));
        jLabel10.setText("Title");

        cmbstaffgender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "MALE", "FEMALE" }));
        cmbstaffgender.setEnabled(false);

        cmbstafftitle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "MR", "MRS", "MISS", "DR", "PROF" }));
        cmbstafftitle.setEnabled(false);
        cmbstafftitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbstafftitleActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(0, 0, 240));
        jLabel11.setText("Surname");

        jtfsurname.setEnabled(false);

        jLabel12.setForeground(new java.awt.Color(0, 0, 240));
        jLabel12.setText("First Name");

        jLabel13.setForeground(new java.awt.Color(0, 0, 240));
        jLabel13.setText("Last Name");

        jtffirstname.setEnabled(false);

        jtflastname.setEnabled(false);

        jLabel14.setForeground(new java.awt.Color(0, 0, 240));
        jLabel14.setText("Date of Birth");

        jLabel15.setForeground(new java.awt.Color(0, 0, 240));
        jLabel15.setText("Job Title");

        jLabel16.setForeground(new java.awt.Color(0, 0, 240));
        jLabel16.setText("Role");

        jtfjobtitle.setEnabled(false);

        jbtcancel.setText("Cancel");
        jbtcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtcancelActionPerformed(evt);
            }
        });

        jtarole.setColumns(20);
        jtarole.setRows(5);
        jtarole.setEnabled(false);
        jScrollPane2.setViewportView(jtarole);

        try {
            jtfnationalid.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfnationalid.setEnabled(false);
        jtfnationalid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfnationalidActionPerformed(evt);
            }
        });

        jXDOB.setEnabled(false);

        jbtcancel1.setText("Dismiss Staff");
        jbtcancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtcancel1ActionPerformed(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(0, 0, 240));
        jLabel17.setText("More Details");

        jrworking.setForeground(new java.awt.Color(0, 0, 240));
        jrworking.setText("Woking");
        jrworking.setEnabled(false);
        jrworking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrworkingActionPerformed(evt);
            }
        });

        jrnotworking.setForeground(new java.awt.Color(0, 0, 240));
        jrnotworking.setText("No Longer Working");
        jrnotworking.setEnabled(false);
        jrnotworking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrnotworkingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout staffdetailspanelLayout = new javax.swing.GroupLayout(staffdetailspanel);
        staffdetailspanel.setLayout(staffdetailspanelLayout);
        staffdetailspanelLayout.setHorizontalGroup(
            staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffdetailspanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(staffdetailspanelLayout.createSequentialGroup()
                        .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel14)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXDOB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbstaffgender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfnationalid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffdetailspanelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtcancel)
                            .addComponent(cmbstafftitle, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(staffdetailspanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffdetailspanelLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfsurname, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffdetailspanelLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addComponent(jtffirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffdetailspanelLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtflastname, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffdetailspanelLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfjobtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(staffdetailspanelLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(45, 45, 45)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(staffdetailspanelLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(41, 41, 41)
                                .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrnotworking, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jrworking))))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffdetailspanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtcancel1)
                        .addGap(172, 172, 172))))
        );
        staffdetailspanelLayout.setVerticalGroup(
            staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffdetailspanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(staffdetailspanelLayout.createSequentialGroup()
                        .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbstaffgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jtfsurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(51, 51, 51)
                        .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jXDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(jtffirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfnationalid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13)
                    .addComponent(jtflastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jrworking, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jrnotworking)
                .addGap(6, 6, 6)
                .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfjobtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cmbstafftitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(staffdetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtcancel)
                    .addComponent(jbtcancel1))
                .addGap(27, 27, 27))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 240));
        jLabel6.setText("Dismiss Member of Staff");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(staffdetailspanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(27, 27, 27)
                .addComponent(staffdetailspanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbstafftitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbstafftitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbstafftitleActionPerformed

    private void jbtcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtcancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbtcancelActionPerformed

    private void jtfnationalidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfnationalidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfnationalidActionPerformed

    private void jbtcancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtcancel1ActionPerformed
        try {
            int confirm = JOptionPane.showConfirmDialog(null, "You are About to Dismiss "+ disptitle+ " " + dispsurname+ " " +dispfname+
            "\nPress Ok to Continue", "Confirm", JOptionPane.OK_CANCEL_OPTION);
            if(confirm == JOptionPane.OK_OPTION)
            {
                 sqlupdates.Dismiss.DismissStaff(currentuserid);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Some Error Occured Please Contact Sustem Admin For Help\n", "Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbtcancel1ActionPerformed

    private void jrworkingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrworkingActionPerformed
        // TODO add your handling code here:
        if(jrworking.isSelected() == true)
        {
            jrnotworking.setSelected(false);
        }
        else if(jrworking.isSelected() == false)
        {
            jrnotworking.setSelected(true);
        }
    }//GEN-LAST:event_jrworkingActionPerformed

    private void jrnotworkingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrnotworkingActionPerformed
        // TODO add your handling code here:
        if(jrnotworking.isSelected() == true)
        {
            jrworking.setSelected(false);
        }
        else if(jrnotworking.isSelected() == false)
        {
            jrworking.setSelected(true);
        }
    }//GEN-LAST:event_jrnotworkingActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DismissStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DismissStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DismissStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DismissStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DismissStaff(currentuserid,Integer.parseInt(searchid),surnamel,fnamel,lnamel).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbstaffgender;
    private javax.swing.JComboBox cmbstafftitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jXDOB;
    private javax.swing.JButton jbtcancel;
    private javax.swing.JButton jbtcancel1;
    private javax.swing.JRadioButton jrnotworking;
    private javax.swing.JRadioButton jrworking;
    private javax.swing.JTextArea jtarole;
    private javax.swing.JTextField jtffirstname;
    private javax.swing.JTextField jtfjobtitle;
    private javax.swing.JTextField jtflastname;
    private javax.swing.JFormattedTextField jtfnationalid;
    private javax.swing.JTextField jtfsurname;
    private javax.swing.JPanel staffdetailspanel;
    // End of variables declaration//GEN-END:variables
}
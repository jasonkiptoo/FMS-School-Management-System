/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clerk;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import selects.QueryClassDetails;
import selects.QueryStudentDetails;

/**
 *
 * @author franq
 */
public class EditStudent extends javax.swing.JFrame {

    /**
     * Creates new form EditStudent
     */
    private static int searchid;
    private static String searchsurname,searchfname,searchlname;
    private String surname,fname,lname,gender,transport,dob,current_class,residence,meals,registeredBy,whetherStudent;
    private int contactID,studentNumber;
    private ArrayList<String> studentInfo;
    private ArrayList<String> classnamesinfo,residencenames,mealsinfo,transportinfo;
    private static int currentuserid;
    private java.util.Date today;
    private static int counter;
    
    
    public EditStudent(int userid,int id,String surname,String fname,String lname) {
        /**/
        
          initComponents();
          today = new java.util.Date();
          currentuserid = userid;
          searchsurname = surname;
          searchfname = fname;
          searchlname = lname;
          searchid = id;
          counter = 0;
         
          
          
          classnamesinfo = QueryClassDetails.getClassNames();
          cmbclass.setModel(new DefaultComboBoxModel(classnamesinfo.toArray(new String[classnamesinfo.size()])));
          
          residencenames = QueryStudentDetails.getResidenceNames();
          cmbresidence.setModel(new DefaultComboBoxModel(residencenames.toArray(new String[residencenames.size()])));
        
          
          
          
           if(searchid != 0)
          {
                 studentInfo = selects.QuerySearchStudent.getStudentInfo(searchid);
          }
          else if(searchid == 0)
          {
                 studentInfo = selects.QuerySearchStudent.getStudentInfo(surname, fname, lname);
          }
           
        this.setTitle("Edit Student Details");
     
        surname = studentInfo.get(0);
        fname = studentInfo.get(1);
        lname = studentInfo.get(2);
        gender = studentInfo.get(3);
       // dob = studentInfo.get(4);
        //java.util.Date utildate = new java.util.Date(dob);
        
        contactID = Integer.parseInt(studentInfo.get(5));
        current_class = studentInfo.get(6);
        residence = studentInfo.get(7);
        meals =studentInfo.get(8);
        transport = studentInfo.get(9);
        registeredBy = studentInfo.get(10);
        whetherStudent = studentInfo.get(11);
        studentNumber = Integer.parseInt(studentInfo.get(12));
        
        
        //set the initial text on loading
        
        tfsurname.setText(surname);
        tffirstname.setText(fname);
        tflastname.setText(lname);
        cmbstaffgender1.setSelectedItem(gender);
        
        //jXDOB.setDate(utildate.);
        
        cmbresidence.setSelectedItem(residence);
        cmbmeals.setSelectedItem(meals);
        cmbclass.setSelectedItem(current_class);
        
        
       //get the classid
       selects.QueryClassDetails.getClassNames();
       int classidid = selects.QueryClassDetails.listofnames.indexOf(current_class);
       int classid = Integer.parseInt(selects.QueryClassDetails.listofids.get(classidid).toString());
        
        transportinfo = QueryStudentDetails.getTransportNames(classid);
        cmbtransport.setModel(new DefaultComboBoxModel(transportinfo.toArray(new String[transportinfo.size()])));
        
        mealsinfo = QueryStudentDetails.getMealsNames(classid);
        cmbmeals.setModel(new DefaultComboBoxModel(mealsinfo.toArray(new String[mealsinfo.size()])));
        
        cmbmeals.setSelectedItem(meals);
        cmbtransport.setSelectedItem(transport);
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfsurname = new javax.swing.JTextField();
        tffirstname = new javax.swing.JTextField();
        tflastname = new javax.swing.JTextField();
        cmbclass = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jXDOB = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmbstaffgender1 = new javax.swing.JComboBox();
        cmbresidence = new javax.swing.JComboBox();
        cmbmeals = new javax.swing.JComboBox();
        cmbtransport = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jbtcancel = new javax.swing.JButton();
        jbtsave = new javax.swing.JButton();
        jbtcancel1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jrstudent = new javax.swing.JRadioButton();
        jralumni = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(selects.QueryMainDetails.setIcon());
        setResizable(false);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setForeground(new java.awt.Color(0, 0, 240));
        jLabel8.setText("Surname");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 14, -1, -1));

        jLabel10.setForeground(new java.awt.Color(0, 0, 240));
        jLabel10.setText("First Name");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 68, -1, -1));

        jLabel11.setForeground(new java.awt.Color(0, 0, 240));
        jLabel11.setText("Last Name");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 124, -1, -1));

        jLabel12.setForeground(new java.awt.Color(0, 0, 240));
        jLabel12.setText("Gender");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 183, -1, -1));
        jPanel2.add(tfsurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 11, 193, -1));
        jPanel2.add(tffirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 65, 193, -1));
        jPanel2.add(tflastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 121, 193, -1));

        cmbclass.setEnabled(true);
        cmbclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbclassActionPerformed(evt);
            }
        });
        jPanel2.add(cmbclass, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 65, 208, -1));

        jLabel13.setForeground(new java.awt.Color(0, 0, 240));
        jLabel13.setText("Date of Birth");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 14, -1, -1));

        jXDOB.setEnabled(true);
        jPanel2.add(jXDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 11, 208, -1));

        jLabel14.setForeground(new java.awt.Color(0, 0, 240));
        jLabel14.setText("Class");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 68, -1, -1));

        jLabel15.setForeground(new java.awt.Color(0, 0, 240));
        jLabel15.setText("Residence");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 124, -1, -1));

        jLabel16.setForeground(new java.awt.Color(0, 0, 240));
        jLabel16.setText("Meals");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 183, -1, -1));

        cmbstaffgender1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "MALE", "FEMALE" }));
        cmbstaffgender1.setEnabled(true);
        jPanel2.add(cmbstaffgender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 180, 193, -1));

        cmbresidence.setEnabled(true);
        jPanel2.add(cmbresidence, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 121, 208, -1));

        cmbmeals.setEnabled(true);
        jPanel2.add(cmbmeals, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 180, 208, -1));

        cmbtransport.setEnabled(true);
        jPanel2.add(cmbtransport, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 250, 193, -1));

        jLabel18.setForeground(new java.awt.Color(0, 0, 240));
        jLabel18.setText("Transport");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 253, -1, -1));

        jbtcancel.setText("Contacts");
        jbtcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtcancelActionPerformed(evt);
            }
        });
        jPanel2.add(jbtcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, -1, -1));

        jbtsave.setText("Save");
        jbtsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtsaveActionPerformed(evt);
            }
        });
        jPanel2.add(jbtsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));

        jbtcancel1.setText("Cancel");
        jbtcancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtcancel1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtcancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));

        jLabel17.setForeground(new java.awt.Color(0, 0, 240));
        jLabel17.setText("More Details");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 253, -1, -1));

        jrstudent.setForeground(new java.awt.Color(0, 0, 240));
        jrstudent.setSelected(true);
        jrstudent.setText("Student");
        jrstudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrstudentActionPerformed(evt);
            }
        });
        jPanel2.add(jrstudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, 20));

        jralumni.setForeground(new java.awt.Color(0, 0, 240));
        jralumni.setText("Alumni");
        jralumni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jralumniActionPerformed(evt);
            }
        });
        jPanel2.add(jralumni, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 120, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 891, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(19, 19, 19)))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 240));
        jLabel6.setText("Edit Student Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtcancelActionPerformed
        // TODO add your handling code here:
        if(counter ==0)
            JOptionPane.showMessageDialog(null,
                        "Please Save This Information First\n Click The Save Buttton then Continue", "Warning",JOptionPane.WARNING_MESSAGE);
        else
        {
            EditStudentContactDetails newcontacts = new EditStudentContactDetails(contactID);
            newcontacts.main(new String[9]);
            this.hide();
        }
       

    }//GEN-LAST:event_jbtcancelActionPerformed

    private void jbtsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtsaveActionPerformed
        // TODO add your handling code here:
        String surname, firstname, lastname,gender, dob, classidstr, residenceidstr, mealsidstr, transportidstr;
        int classid,residenceid,mealsid,transportid, registeredby;
        int whetherstudent = 1,studentid;
       //String surname, firstname, lastname,gender, dob, classid, residenceid, mealsid, transportid, registeredby;
        
       surname = tfsurname.getText();
       firstname = tffirstname.getText();
       lastname = tflastname.getText();
       gender = cmbstaffgender1.getSelectedItem().toString();
       
       java.util.Date utildate = jXDOB.getDate();
       java.sql.Date sqldate = new java.sql.Date(utildate.getYear(),utildate.getMonth(),utildate.getDate());
       java.sql.Date todaysqldate = new java.sql.Date(today.getYear(), today.getMonth(), today.getDate());
       dob = sqldate.toString().toUpperCase();
       
        //get the names of tehse variable below
       classidstr = cmbclass.getSelectedItem().toString();
       residenceidstr = cmbresidence.getSelectedItem().toString();
       mealsidstr = cmbmeals.getSelectedItem().toString();
       transportidstr = cmbtransport.getSelectedItem().toString();
       registeredby = currentuserid;
       
       //get the spefic ids
       selects.QueryClassDetails.getClassNames();
       int classidid = selects.QueryClassDetails.listofnames.indexOf(classidstr);
       classid = Integer.parseInt(selects.QueryClassDetails.listofids.get(classidid).toString());
       
       selects.QueryResidenceDetails.getResidenceNames();
       int residenceidid = selects.QueryResidenceDetails.listofnames.indexOf(residenceidstr);
       residenceid = Integer.parseInt(selects.QueryResidenceDetails.listofids.get(residenceidid).toString());
       
       selects.QueryMealsDetails.getMealDetails();
       int mealsidid = selects.QueryMealsDetails.listofnames.indexOf(mealsidstr);
       mealsid = Integer.parseInt(selects.QueryMealsDetails.listofids.get(mealsidid).toString());
       
       selects.QueryTransportDetails.getTranportDetails(classid);
       int transportidid = selects.QueryTransportDetails.listofnames.indexOf(transportidstr);
       transportid = Integer.parseInt(selects.QueryTransportDetails.listofids.get(transportidid).toString());
               
       if(jrstudent.isSelected() == true)
       {
           whetherstudent = 1;
       }
       else if(jrstudent.isSelected() == false)
       {
           whetherstudent = 0;
       }
       
       if("".equals(surname))
       {
           JOptionPane.showMessageDialog(null,
                        "Please Enter Surname to Continue\n", "Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if("".equals(firstname))
       {
           JOptionPane.showMessageDialog(null,
                        "Please Enter First Name to Continue\n", "Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if("".equals(lastname))
       {
           JOptionPane.showMessageDialog(null,
                        "Please Enter Last Name to Continue\n", "Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if("Select".equals(gender))
       {
           JOptionPane.showMessageDialog(null,
                        "Please Enter Gender to Continue\n", "Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if("Select".equals(transportidstr))
       {
           JOptionPane.showMessageDialog(null,
                        "Please Enter Transport Details to Continue\n", "Warning",JOptionPane.WARNING_MESSAGE);
       }
        else if("".equals(dob)||dob==null||sqldate==todaysqldate)
        {
            JOptionPane.showMessageDialog(null,
                        "Please Enter Date of Birth to Continue\n", "Warning",JOptionPane.WARNING_MESSAGE);
        }
       else if("Select Class Name".equals(classidstr))
       {
           JOptionPane.showMessageDialog(null,
                        "Please Enter Class Details to Continue\n", "Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if("Select".equals(residenceidstr))
       {
           JOptionPane.showMessageDialog(null,
                        "Please Enter Residence Details to Continue\n", "Warning",JOptionPane.WARNING_MESSAGE);
       }
       else if("Select".equals(mealsidstr))
       {
           JOptionPane.showMessageDialog(null,
                        "Please Enter Meals Details to Continue\n", "Warning",JOptionPane.WARNING_MESSAGE);
       }
       else
       {
         
         
         try {
            // sqlinserts.NewStudent.createNewStudent(surname, firstname, lastname,gender,dob,classid,residenceid,mealsid,transportid, registeredby);
            sqlupdates.StudentInfo.createNewStudent(surname, firstname, lastname, gender,
                    dob, classid, residenceid, mealsid, transportid, whetherstudent,studentNumber);
             
             JOptionPane.showMessageDialog(null,
                        "Student Details Updated Successfully\n"
                     + "Press Ok to Continue", "Success",JOptionPane.WARNING_MESSAGE);
             
             counter++;
         } catch (SQLException ex) {
             Logger.getLogger(NewStudent.class.getName()).log(Level.SEVERE, null, ex);
         }
       }
       
    }//GEN-LAST:event_jbtsaveActionPerformed

    private void jbtcancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtcancel1ActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_jbtcancel1ActionPerformed

    private void jrstudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrstudentActionPerformed
        // TODO add your handling code here:
        if(jrstudent.isSelected() == true)
        {
            jralumni.setSelected(false);
        }
        else if(jrstudent.isSelected() == false)
        {
            jralumni.setSelected(true);
        }
    }//GEN-LAST:event_jrstudentActionPerformed

    private void jralumniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jralumniActionPerformed
        // TODO add your handling code here:
        if(jrstudent.isSelected() == false)
        {
            jralumni.setSelected(true);
        }
        else if(jrstudent.isSelected() == true)
        {
            jralumni.setSelected(false);
        }
    }//GEN-LAST:event_jralumniActionPerformed

    private void cmbclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbclassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbclassActionPerformed

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
            java.util.logging.Logger.getLogger(EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditStudent(currentuserid,searchid,searchsurname,searchfname,searchlname).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbclass;
    private javax.swing.JComboBox cmbmeals;
    private javax.swing.JComboBox cmbresidence;
    private javax.swing.JComboBox cmbstaffgender1;
    private javax.swing.JComboBox cmbtransport;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser jXDOB;
    private javax.swing.JButton jbtcancel;
    private javax.swing.JButton jbtcancel1;
    private javax.swing.JButton jbtsave;
    private javax.swing.JRadioButton jralumni;
    private javax.swing.JRadioButton jrstudent;
    private javax.swing.JTextField tffirstname;
    private javax.swing.JTextField tflastname;
    private javax.swing.JTextField tfsurname;
    // End of variables declaration//GEN-END:variables
}
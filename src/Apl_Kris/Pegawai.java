/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apl_Kris;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author micro
 */
public class Pegawai extends javax.swing.JFrame {

    Koneksi kon = new Koneksi();

    private String sql;
    private DefaultTableModel dtm;

    /**
     * Creates new form Pegawai
     */
    public Pegawai() {
        initComponents();
        kon.koneksi();
        table();
        
        tidbantu.setVisible(false);
    }

    private void autoId() {
        try {
            kon.koneksi();
            String sql = "SELECT Id_bantu as x FROM data_pegawai order by Id_bantu desc";
            Statement st = kon.con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String No_Urut = rs.getString("x");
                int a = Integer.parseInt(No_Urut);
//<editor-fold defaultstate="collapsed" desc="for gaperlu">
//                int panjang = No_Urut.length();

//                for (int i = 0; i < 2 - panjang; i++) {
//                    a = a;
//                }
//</editor-fold>
                tidUser.setText("USR" + Integer.toString(a + 1));
                tidbantu.setText(Integer.toString(a + 1));
            } else {
                tidbantu.setText("1");
                tidUser.setText("USR1");
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
//<editor-fold defaultstate="collapsed" desc="kaya padosen">
//        String no = null;
//        try {
//            kon.koneksi();
//            String sql = "Select right(Id_user,3)+1 from data_pegawai";
//            PreparedStatement pst = kon.con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                rs.last();
//                no = rs.getString(1);
//                while (no.length() < 3) {
//                    no = "00" + no;
//                    no = "B" + no;
//                    tidUser.setText(no);
//                }
//            } else {
//                no = "B001";
//                tidUser.setText(no);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//        return no;
//</editor-fold>
    }

    private void table() {
        dtm = new DefaultTableModel();
        dtm.addColumn("NO");
        dtm.addColumn("ID PEGAWAI");
        dtm.addColumn("USERNAME");
        dtm.addColumn("PASSWORD");

        try {
            int no = 1;
            sql = "select * from data_pegawai";
            kon.st = kon.con.createStatement();
            kon.rs = kon.st.executeQuery(sql);
            while (kon.rs.next()) {
                dtm.addRow(new Object[]{no++, kon.rs.getString("Id_user"), kon.rs.getString("Username"), kon.rs.getString("Password")});
            }
            table.setModel(dtm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            table.setModel(dtm);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        tidUser = new javax.swing.JTextField();
        tuserName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btambah = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bupdate = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        tpassword = new javax.swing.JTextField();
        tidbantu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, 125));

        tidUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidUserActionPerformed(evt);
            }
        });
        getContentPane().add(tidUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 170, -1));
        getContentPane().add(tuserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 170, -1));

        jLabel1.setText("ID User");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 34, -1, -1));

        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 74, -1, -1));

        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 116, -1, -1));

        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });
        getContentPane().add(btambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        bedit.setText("Edit");
        getContentPane().add(bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        bbatal.setText("Batal");
        getContentPane().add(bbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        bupdate.setText("Update");
        getContentPane().add(bupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        bdelete.setText("Hapus");
        getContentPane().add(bdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));
        getContentPane().add(tpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 170, -1));

        tidbantu.setText("id bantu");
        getContentPane().add(tidbantu, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tidUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidUserActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        try {
            sql = "insert into data_pegawai values ('" + tidUser.getText() + "','" + tidbantu.getText() + "','" + tuserName.getText() + "','" + tpassword.getText() + "')";
            kon.st = kon.con.createStatement();
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "USER SUKSES TERSIMPAN");
            table();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lengkapi data\n" + e.getMessage());
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
        autoId();
    }//GEN-LAST:event_btambahActionPerformed

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
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JButton bupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField tidUser;
    private javax.swing.JLabel tidbantu;
    private javax.swing.JTextField tpassword;
    private javax.swing.JTextField tuserName;
    // End of variables declaration//GEN-END:variables
}
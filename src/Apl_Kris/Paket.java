/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apl_Kris;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author micro
 */
public class Paket extends javax.swing.JFrame {

    Koneksi kon = new Koneksi();

    private String sql;
    private DefaultTableModel dtm;

    /**
     * Creates new form Pegawai
     */
    public Paket() {
        initComponents();
        kon.koneksi();
        table();
        nonAktif();
        tidbantu.setVisible(false);
    }

    private void nonAktif() {
        bsimpan.setEnabled(false);
        bupdate.setEnabled(false);
        bdelete.setEnabled(false);
        bedit.setEnabled(false);

        tidUser.setEnabled(false);
        tuserName.setEnabled(false);
        tpassword.setEnabled(false);
    }

    private void aktif() {
        bsimpan.setEnabled(true);

        tidUser.setEnabled(true);
        tuserName.setEnabled(true);
        tpassword.setEnabled(true);
    }

    private void kosong() {
        tidUser.setText("");
        tuserName.setText("");
        tpassword.setText("");
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
//        dtm.addColumn("");

        try {
            int no = 1;
            sql = "select * from data_pegawai";
            kon.st = kon.con.createStatement();
            kon.rs = kon.st.executeQuery(sql);
            while (kon.rs.next()) {
                dtm.addRow(new Object[]{no++, kon.rs.getString("Id_user"), kon.rs.getString("Username"), kon.rs.getString("Password"), kon.rs.getString("Id_bantu")});
            }
            tableData.setModel(dtm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            tableData.setModel(dtm);
        }
//        tableData.getColumn("").setMinWidth(0);
//        tableData.getColumn("").setMaxWidth(0);
//        tableData.getColumn("").setWidth(0);
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
        tableData = new javax.swing.JTable();
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
        bclose = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableData.setModel(new javax.swing.table.DefaultTableModel(
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
        tableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableData);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, 125));

        tidUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidUserActionPerformed(evt);
            }
        });
        getContentPane().add(tidUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 170, -1));
        getContentPane().add(tuserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 170, -1));

        jLabel1.setText("ID User");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });
        getContentPane().add(btambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        bedit.setText("Edit");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        getContentPane().add(bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });
        getContentPane().add(bbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        bupdate.setText("Update");
        bupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bupdateActionPerformed(evt);
            }
        });
        getContentPane().add(bupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        bdelete.setText("Hapus");
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });
        getContentPane().add(bdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));
        getContentPane().add(tpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 170, -1));

        tidbantu.setText("id bantu");
        getContentPane().add(tidbantu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        bclose.setText("Tutup");
        bclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcloseActionPerformed(evt);
            }
        });
        getContentPane().add(bclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 80, 70));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 620, 420));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel2.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("DATA PEGAWAI");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel10);
        jLabel10.setBounds(150, 10, 290, 33);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 60));

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
            kosong();
            bbatalActionPerformed(evt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lengkapi data\n" + e.getMessage());
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
        kosong();
        autoId();
        aktif();
        
    }//GEN-LAST:event_btambahActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        // TODO add your handling code here:
        aktif();
        bupdate.setEnabled(true);
        bdelete.setEnabled(true);

        btambah.setEnabled(false);
        bedit.setEnabled(false);
        bsimpan.setEnabled(false);
    }//GEN-LAST:event_beditActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        // TODO add your handling code here:
        kosong();
        nonAktif();
        btambah.setEnabled(true);
    }//GEN-LAST:event_bbatalActionPerformed

    private void tableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataMouseClicked
        // TODO add your handling code here:
        tidUser.setText(tableData.getValueAt(tableData.getSelectedRow(), 1).toString());
        tuserName.setText(tableData.getValueAt(tableData.getSelectedRow(), 2).toString());
        tpassword.setText(tableData.getValueAt(tableData.getSelectedRow(), 3).toString());
//        tidbantu.setText(tableData.getValueAt(tableData.getSelectedRow(), 4).toString());
        bedit.setEnabled(true);
    }//GEN-LAST:event_tableDataMouseClicked

    private void bupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bupdateActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Yakin di Update ?", "Konfirmasi Update", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try{
            sql = "update data_pegawai set Id_user='" + tidUser.getText() + "', Username='" + tuserName.getText() + "', Password='" + tpassword.getText() + "' where Id_user='"+tidUser.getText()+"'";
            PreparedStatement edit = kon.con.prepareStatement(sql);
            edit.execute();
            JOptionPane.showMessageDialog(null, "UPDATE DATA BERHASIL");
            table();
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "GAGAL DIUPDATE\n"+e.getMessage());
            }
        }
    }//GEN-LAST:event_bupdateActionPerformed

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Yakin dihapus ?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try{
            sql = "delete from data_pegawai where Id_user='"+tidUser.getText()+"'";
            PreparedStatement edit = kon.con.prepareStatement(sql);
            edit.execute();
            JOptionPane.showMessageDialog(null, "HAPUS DATA BERHASIL");
            table();
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "GAGAL DIHAPUS\n"+e.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "HAPUS DIBATALKAN");
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void bcloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcloseActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Yakin Ditutup?", "keluar", JOptionPane.YES_NO_OPTION);
        if (ok == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_bcloseActionPerformed

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
            java.util.logging.Logger.getLogger(Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Paket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bclose;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JButton bupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField tidUser;
    private javax.swing.JLabel tidbantu;
    private javax.swing.JTextField tpassword;
    private javax.swing.JTextField tuserName;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apl_Kris;
//testos
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author micro
 */
public class Apl_laundry extends javax.swing.JFrame {

    private String sql;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private DefaultTableModel dtm;
    public int harga;
    public float berat, totalbyr;

    /**
     * Creates new form Apl_laundry
     */
    public Apl_laundry() {
        initComponents();
        koneksi();
        tgl();

        try {
            tabel();
        } catch (Exception e) {
        }

    }

    public void koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/laundrykris", "root", "");
            Lbstatus.setText("***DATABASE TERKONEKSI***");
        } catch (Exception e) {
            Lbstatus.setText("DATABASE TIDAK TERKONEKSI");
            JOptionPane.showMessageDialog(null, "DATABASE TIDAK TERKONEKSI");
        }
    }

    private void tgl() {
        Date ys = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        ttgl.setText(s.format(ys));
    }

    public void tabel() {
        dtm = new DefaultTableModel();
        dtm.addColumn("NO");
        dtm.addColumn("TANGGAL");
        dtm.addColumn("KODE PELANGGAN");
        dtm.addColumn("NAMA PELANGGAN");
        dtm.addColumn("NO TELP");
        dtm.addColumn("ALAMAT PELANGGAN");
        dtm.addColumn("BERAT PAKAIAN");
        dtm.addColumn("HARGA");
        dtm.addColumn("TOTAL BAYAR");

        try {
            int no = 1;
            sql = "select * from laundry";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                dtm.addRow(new Object[]{no++, rs.getString("Tanggal"), rs.getString("Kode_pelanggan"),
                    rs.getString("Nama_pelanggan"), rs.getString("No_telp"), rs.getString("Alamat"),
                    rs.getString("Berat_Pakaian"), rs.getString("Harga"), rs.getString("Total_bayar")});
            }
            tabeldata.setModel(dtm);
        } catch (SQLException e) {
            System.out.println("error :" + e.getMessage());
        }
    }

    public void hitung() {
        try {

            berat = Float.valueOf(tberat.getText());
            harga = Integer.parseInt(tharga.getText());
            totalbyr = berat * harga;

            ttotalbayar.setText(String.valueOf(totalbyr));
            tharga.setText(String.valueOf(harga));
        } catch (Exception e) {
        }
    }

    public void kosong() {
        tberat.setText("");
        tharga.setText("");
        tnotlp.setText("");
        ttotalbayar.setText("");
        tkodepel.setText("");
        tnamapel.setText("");
        talamat.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tkodepel = new javax.swing.JTextField();
        ttgl = new javax.swing.JTextField();
        tnamapel = new javax.swing.JTextField();
        tberat = new javax.swing.JTextField();
        tharga = new javax.swing.JTextField();
        ttotalbayar = new javax.swing.JTextField();
        bcancel = new javax.swing.JButton();
        bexit = new javax.swing.JButton();
        tnotlp = new javax.swing.JTextField();
        bview = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bupdate = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeldata = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Lbstatus = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        talamat = new javax.swing.JTextArea();
        breconnect = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbharga = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tkodepel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkodepelActionPerformed(evt);
            }
        });
        getContentPane().add(tkodepel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 160, -1));

        ttgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttglActionPerformed(evt);
            }
        });
        getContentPane().add(ttgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 160, -1));

        tnamapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamapelActionPerformed(evt);
            }
        });
        getContentPane().add(tnamapel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 160, -1));

        tberat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tberatActionPerformed(evt);
            }
        });
        tberat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tberatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tberatKeyTyped(evt);
            }
        });
        getContentPane().add(tberat, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 160, -1));

        tharga.setEditable(false);
        tharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thargaActionPerformed(evt);
            }
        });
        getContentPane().add(tharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 160, -1));

        ttotalbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttotalbayarActionPerformed(evt);
            }
        });
        ttotalbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ttotalbayarKeyReleased(evt);
            }
        });
        getContentPane().add(ttotalbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 160, -1));

        bcancel.setText("Cancel");
        bcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcancelActionPerformed(evt);
            }
        });
        getContentPane().add(bcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, -1, -1));

        bexit.setText("Exit");
        bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitActionPerformed(evt);
            }
        });
        getContentPane().add(bexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, -1, -1));

        tnotlp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnotlpActionPerformed(evt);
            }
        });
        getContentPane().add(tnotlp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 160, -1));

        bview.setText("View (Refresh Table)");
        bview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bviewActionPerformed(evt);
            }
        });
        getContentPane().add(bview, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 160, -1));

        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        bupdate.setText("Update");
        bupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bupdateActionPerformed(evt);
            }
        });
        getContentPane().add(bupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        bdelete.setText("Delete");
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });
        getContentPane().add(bdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, -1, -1));

        tabeldata.setModel(new javax.swing.table.DefaultTableModel(
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
        tabeldata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeldataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeldata);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 850, 230));

        jLabel1.setText("Kode Pelanggan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel2.setText("Tanggal");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, -1));

        jLabel3.setText("Alamat");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 70, -1));

        jLabel4.setText("Nama Pelanggan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, -1));

        jLabel5.setText("No Telp");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 120, -1));

        jLabel6.setText("Berat Pakaian (kg)");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 140, -1));

        jLabel7.setText("Harga /kg");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        jLabel8.setText("Total Bayar");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 120, -1));

        jLabel9.setText("Status Koneksi :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, -1));

        Lbstatus.setText("status");
        getContentPane().add(Lbstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 230, -1));

        talamat.setColumns(20);
        talamat.setRows(5);
        jScrollPane2.setViewportView(talamat);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        breconnect.setText("Reconnect");
        breconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breconnectActionPerformed(evt);
            }
        });
        getContentPane().add(breconnect, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 100, 20));

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel10.setText("KRIS LAUNDRY");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        cbharga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=PILIH HARGA=", "3 Hari (Rp 5000/kg)", "1 Hari (Rp 9000/kg)", "7 Jam (Rp 15000/kg)", " ", " " }));
        cbharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbhargaActionPerformed(evt);
            }
        });
        getContentPane().add(cbharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tkodepelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkodepelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkodepelActionPerformed

    private void ttglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttglActionPerformed

    private void tnamapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamapelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamapelActionPerformed

    private void tberatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tberatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tberatActionPerformed

    private void thargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thargaActionPerformed

    private void ttotalbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttotalbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttotalbayarActionPerformed

    private void tnotlpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnotlpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnotlpActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        try {
            sql = "insert into laundry values ('" + ttgl.getText() + "',"
                    + "'" + tkodepel.getText() + "','" + tnamapel.getText() + "',"
                    + "'" + tnotlp.getText() + "','" + talamat.getText() + "',"
                    + "'" + tberat.getText() + "','" + tharga.getText() + "','" + ttotalbayar.getText() + "')";
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "SUKSES TERSIMPAN");
            kosong();
            bviewActionPerformed(evt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "GAGAL MENYIMPAN\n" + e.getMessage());
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bviewActionPerformed
        // TODO add your handling code here:
        dtm = new DefaultTableModel();
        dtm.addColumn("NO");
        dtm.addColumn("TANGGAL");
        dtm.addColumn("KODE PELANGGAN");
        dtm.addColumn("NAMA PELANGGAN");
        dtm.addColumn("NO TELP");
        dtm.addColumn("ALAMAT PELANGGAN");
        dtm.addColumn("BERAT PAKAIAN");
        dtm.addColumn("HARGA");
        dtm.addColumn("TOTAL BAYAR");

        try {
            int no = 1;
            sql = "select * from laundry";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                dtm.addRow(new Object[]{no++, rs.getString("Tanggal"), rs.getString("Kode_pelanggan"), 
                    rs.getString("Nama_pelanggan"), rs.getString("No_telp"), rs.getString("Alamat"),
                    rs.getString("Berat_Pakaian"), rs.getString("Harga"), rs.getString("Total_bayar")});
            }
            tabeldata.setModel(dtm);
        } catch (SQLException e) {
            System.out.println("error :" + e.getMessage());
        }
    }//GEN-LAST:event_bviewActionPerformed

    private void tabeldataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeldataMouseClicked
        // TODO add your handling code here:
        ttgl.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 1).toString());
        tkodepel.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 2).toString());
        tnamapel.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 3).toString());
        tnotlp.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 4).toString());
        talamat.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 5).toString());
        tberat.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 6).toString());
        tharga.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 7).toString());
        ttotalbayar.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 8).toString());
    }//GEN-LAST:event_tabeldataMouseClicked

    private void bupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bupdateActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Yakin di Update ?", "Konfirmasi Update", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                sql = "update laundry set Tanggal='" + ttgl.getText() + "', Kode_pelanggan='" + tkodepel.getText() + "', "
                        + "Nama_pelanggan='" + tnamapel.getText() + "', No_telp='" + tnotlp.getText() + "', Alamat='" + talamat.getText() + "', "
                        + "Berat_Pakaian='" + tberat.getText() + "', Harga='" + tharga.getText() + "', "
                        + "Total_bayar='" + ttotalbayar.getText() + "' where Kode_pelanggan='" + tkodepel.getText() + "'";
                PreparedStatement edit = con.prepareStatement(sql);
                edit.execute();
                JOptionPane.showMessageDialog(null, "UPDATE DATA BERHASIL");
                bviewActionPerformed(evt);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "GAGAL DIUPDATE" + e.getMessage());
            }
        }
    }//GEN-LAST:event_bupdateActionPerformed

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Yakin dihapus?", "hapus", JOptionPane.YES_NO_OPTION);
        if (ok == JOptionPane.YES_OPTION) {
            try {
                sql = "delete from laundry where Kode_pelanggan='" + tkodepel.getText() + "'";
                PreparedStatement st = con.prepareStatement(sql);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "HAPUS DATA SUKSES");
                bviewActionPerformed(evt);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "GAGAL DIHAPUS\n" + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "HAPUS DATA DIBATALKAN");
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void bexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Yakin Keluar?", "keluar", JOptionPane.YES_NO_OPTION);
        if (ok == JOptionPane.YES_OPTION) {
            dispose();
        }

    }//GEN-LAST:event_bexitActionPerformed

    private void bcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcancelActionPerformed
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_bcancelActionPerformed

    private void breconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breconnectActionPerformed
        // TODO add your handling code here:
        koneksi();
    }//GEN-LAST:event_breconnectActionPerformed

    private void cbhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbhargaActionPerformed
        // TODO add your handling code here:
        String pil = cbharga.getSelectedItem().toString();

        if (pil.equals("3 Hari (Rp 5000/kg)")) {
            tharga.setText("5000");
        } else if (pil.equals("3 Hari (Rp 5000/kg)")) {
            tharga.setText("5000");
        } else if (pil.equals("1 Hari (Rp 9000/kg)")) {
            tharga.setText("9000");
        } else if (pil.equals("7 Jam (Rp 15000/kg)")) {
            tharga.setText("15000");
        } else {
            tharga.setText("");
        }

        hitung();
    }//GEN-LAST:event_cbhargaActionPerformed

    private void tberatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tberatKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tberatKeyTyped

    private void tberatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tberatKeyReleased
        // TODO add your handling code here:
        String isi = tberat.getText();

        if (isi.equals("")) {
            ttotalbayar.setText("");
        } else {
            hitung();
        }
    }//GEN-LAST:event_tberatKeyReleased

    private void ttotalbayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttotalbayarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ttotalbayarKeyReleased

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
            java.util.logging.Logger.getLogger(Apl_laundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Apl_laundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Apl_laundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Apl_laundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Apl_laundry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbstatus;
    private javax.swing.JButton bcancel;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bexit;
    private javax.swing.JButton breconnect;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bupdate;
    private javax.swing.JButton bview;
    private javax.swing.JComboBox<String> cbharga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabeldata;
    private javax.swing.JTextArea talamat;
    private javax.swing.JTextField tberat;
    private javax.swing.JTextField tharga;
    private javax.swing.JTextField tkodepel;
    private javax.swing.JTextField tnamapel;
    private javax.swing.JTextField tnotlp;
    private javax.swing.JTextField ttgl;
    private javax.swing.JTextField ttotalbayar;
    // End of variables declaration//GEN-END:variables
}

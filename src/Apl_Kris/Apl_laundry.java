/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apl_Kris;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Tesssssar
 *
 * @author Krisno
 */
public class Apl_laundry extends javax.swing.JFrame {

    Koneksi kon = new Koneksi();

    private String sql;
    private DefaultTableModel dtm;

    /**
     * Creates new form Apl_laundry
     */
    public Apl_laundry() {
        initComponents();
        kon.koneksi();
        status();
        tgl();
        tabel();
        nonAktif();
    }

    private void status() {
        try {
            kon.koneksi();
            Lbstatus.setText("***DATABASE TERKONEKSI***");
        } catch (Exception e) {
            Lbstatus.setText("DATABASE TIDAK TERKONEKSI");
        }
    }

    private void nonAktif() {
        bsimpan.setEnabled(false);
        bupdate.setEnabled(false);
        bdelete.setEnabled(false);
        cbharga.setEnabled(false);
        bedit.setEnabled(false);

        tkodepel.setEnabled(false);
        talamat.setEnabled(false);
        tberat.setEnabled(false);
        tharga.setEnabled(false);
        tkodepel.setEnabled(false);
        tnamapel.setEnabled(false);
        tnotlp.setEnabled(false);
        ttotalbayar.setEnabled(false);
    }

    private void aktif() {
        bsimpan.setEnabled(true);
        cbharga.setEnabled(true);

        tkodepel.setEnabled(true);
        talamat.setEnabled(true);
        tberat.setEnabled(true);
        tharga.setEnabled(true);
        tkodepel.setEnabled(true);
        tnamapel.setEnabled(true);
        tnotlp.setEnabled(true);
        ttotalbayar.setEnabled(true);
    }

    private void tgl() {
        Date ys = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        ttgl.setText(s.format(ys));
    }

    private void tabel() {
        dtm = new DefaultTableModel();
        dtm.addColumn("NO");
        dtm.addColumn("TANGGAL");
        dtm.addColumn("KODE PELANGGAN");
        dtm.addColumn("NAMA PELANGGAN");
        dtm.addColumn("NO TELP");
        dtm.addColumn("ALAMAT PELANGGAN");
        dtm.addColumn("BERAT PAKAIAN");
        dtm.addColumn("PAKET");
        dtm.addColumn("TOTAL BAYAR");

        try {
            int no = 1;
            sql = "select * from laundry";
            kon.st = kon.con.createStatement();
            kon.rs = kon.st.executeQuery(sql);
            while (kon.rs.next()) {
                dtm.addRow(new Object[]{no++, kon.rs.getString("Tanggal"), kon.rs.getString("Kode_pelanggan"),
                    kon.rs.getString("Nama_pelanggan"), kon.rs.getString("No_telp"), kon.rs.getString("Alamat"),
                    kon.rs.getString("Berat_Pakaian"), kon.rs.getString("Harga"), kon.rs.getString("Total_bayar")});
            }
            tabeldata.setModel(dtm);
        } catch (Exception e) {
            tabeldata.setModel(dtm);
        }
    }

    //variabel
    private int harga = 0, jaket = 0, seprai = 0, sepatu = 0;
    private float berat = 0, totalbyr = 0;

    private void hitungTambahan() {
        if (cbJaket.isSelected()) {
            jaket = 15000;
        } else {
            jaket = 0;
        }
        if (cbSeprai.isSelected()) {
            seprai = 20000;
        } else {
            seprai = 0;
        }
        if (cbSepatu.isSelected()) {
            sepatu = 10000;
        } else {
            sepatu = 0;
        }
        int tambahan = jaket + seprai + sepatu;
        ttambahan.setText(String.valueOf(tambahan));
        hitung();
    }

    private void hitung() {
        try {
            if (tberat.getText().equals("")) {
                //ttotalbayar.setText("");
                berat = 0;
                tharga.setText("");
            } else {
                berat = Float.valueOf(tberat.getText());
            }
            if (tharga.getText().equals("")) {
                //ttotalbayar.setText("");
                harga = 0;
            } else {
                harga = Integer.parseInt(tharga.getText());
            }
//            berat = Float.valueOf(tberat.getText());
//            harga = Integer.parseInt(tharga.getText());

            totalbyr = (berat * harga) + (jaket + seprai + sepatu);
            ttotalbayar.setText(String.valueOf(totalbyr));
            tharga.setText(String.valueOf(harga));
        } catch (Exception e) {
        }
    }

    private void kosong() {
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
        bexit = new javax.swing.JButton();
        tnotlp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeldata = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Lbstatus = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        talamat = new javax.swing.JTextArea();
        breconnect = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbJaket = new javax.swing.JCheckBox();
        cbSeprai = new javax.swing.JCheckBox();
        cbSepatu = new javax.swing.JCheckBox();
        btambah = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bcancel = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        bupdate = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ttotalbayar = new javax.swing.JTextField();
        ttambahan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tharga = new javax.swing.JTextField();
        cbharga = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
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

        bexit.setText("Tutup");
        bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitActionPerformed(evt);
            }
        });
        getContentPane().add(bexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 70, -1));

        tnotlp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnotlpActionPerformed(evt);
            }
        });
        getContentPane().add(tnotlp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 160, -1));

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

        jLabel9.setText("Status Koneksi :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 100, -1));

        Lbstatus.setText("status");
        getContentPane().add(Lbstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, 230, -1));

        talamat.setColumns(20);
        talamat.setRows(5);
        jScrollPane2.setViewportView(talamat);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 250, 170, -1));

        breconnect.setText("Reconnect");
        breconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breconnectActionPerformed(evt);
            }
        });
        getContentPane().add(breconnect, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 590, 100, 20));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(null);

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Apl_Kris/washing-machine small.png"))); // NOI18N
        jPanel1.add(icon);
        icon.setBounds(260, 5, 70, 60);

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel10.setText("KRIS LAUNDRY KILOAN");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(330, 20, 290, 33);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 70));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tambahan"));

        cbJaket.setText("Jaket Rp15000");
        cbJaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJaketActionPerformed(evt);
            }
        });

        cbSeprai.setText("Seprai Rp20000");
        cbSeprai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSepraiActionPerformed(evt);
            }
        });

        cbSepatu.setText("Sepatu Rp10000");
        cbSepatu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSepatuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSeprai)
                    .addComponent(cbSepatu)
                    .addComponent(cbJaket))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(cbJaket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSeprai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSepatu)
                .addContainerGap())
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(690, 90, 160, 106);

        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });
        jPanel2.add(btambah);
        btambah.setBounds(350, 200, 73, 22);

        bedit.setText("Edit");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        jPanel2.add(bedit);
        bedit.setBounds(440, 200, 70, 22);

        bcancel.setText("Batal");
        bcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcancelActionPerformed(evt);
            }
        });
        jPanel2.add(bcancel);
        bcancel.setBounds(530, 200, 70, 22);

        bdelete.setText("Hapus");
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });
        jPanel2.add(bdelete);
        bdelete.setBounds(530, 240, 72, 22);

        bupdate.setText("Update");
        bupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bupdateActionPerformed(evt);
            }
        });
        jPanel2.add(bupdate);
        bupdate.setBounds(440, 240, 72, 22);

        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(bsimpan);
        bsimpan.setBounds(350, 240, 72, 22);

        jLabel8.setText("Total Bayar");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(360, 130, 120, 16);

        ttotalbayar.setEditable(false);
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
        jPanel2.add(ttotalbayar);
        ttotalbayar.setBounds(500, 120, 160, 22);

        ttambahan.setEditable(false);
        ttambahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttambahanActionPerformed(evt);
            }
        });
        jPanel2.add(ttambahan);
        ttambahan.setBounds(500, 86, 160, 22);

        jLabel11.setText("Tambahan");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(360, 89, 130, 16);

        jLabel7.setText("Paket");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(360, 55, 120, 16);

        jLabel6.setText("Berat Pakaian (kg)");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(360, 18, 140, 16);

        tharga.setEditable(false);
        tharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thargaActionPerformed(evt);
            }
        });
        tharga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                thargaKeyReleased(evt);
            }
        });
        jPanel2.add(tharga);
        tharga.setBounds(500, 52, 160, 22);

        cbharga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=PILIH PAKET=", "3 Hari (Rp 5000/kg)", "1 Hari (Rp 9000/kg)", "7 Jam (Rp 15000/kg)" }));
        cbharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbhargaActionPerformed(evt);
            }
        });
        jPanel2.add(cbharga);
        cbharga.setBounds(691, 52, 160, 22);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 880, 580));

        setBounds(0, 0, 896, 655);
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

        bedit.setEnabled(true);
    }//GEN-LAST:event_tabeldataMouseClicked

    private void bexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Yakin Keluar?", "keluar", JOptionPane.YES_NO_OPTION);
        if (ok == JOptionPane.YES_OPTION) {
            dispose();
        }

    }//GEN-LAST:event_bexitActionPerformed

    private void breconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breconnectActionPerformed
        // TODO add your handling code here:
        kon.koneksi();
        tabel();
    }//GEN-LAST:event_breconnectActionPerformed

    private void cbhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbhargaActionPerformed
        // TODO add your handling code here:
        String pil = cbharga.getSelectedItem().toString();

        if (pil.equals("3 Hari (Rp 5000/kg)")) {
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
//        if (tberat.getText().equals("")) {
//            //ttotalbayar.setText("");
//            berat = 0;
//        } else {
            hitung();
//        }
    }//GEN-LAST:event_tberatKeyReleased

    private void ttotalbayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttotalbayarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ttotalbayarKeyReleased

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        try {
            sql = "insert into laundry values ('" + ttgl.getText() + "',"
                    + "'" + tkodepel.getText() + "','" + tnamapel.getText() + "',"
                    + "'" + tnotlp.getText() + "','" + talamat.getText() + "',"
                    + "'" + tberat.getText() + "','" + tharga.getText() + "','" + ttotalbayar.getText() + "')";
            kon.st = kon.con.createStatement();
            kon.st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "SUKSES TERSIMPAN");
            kosong();
            tabel();
            bcancelActionPerformed(evt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA\n" + e.getMessage());
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bupdateActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Yakin di Update ?", "Konfirmasi Update", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                sql = "update laundry set Tanggal='" + ttgl.getText() + "', Kode_pelanggan='" + tkodepel.getText() + "', "
                        + "Nama_pelanggan='" + tnamapel.getText() + "', No_telp='" + tnotlp.getText() + "', Alamat='" + talamat.getText() + "', "
                        + "Berat_Pakaian='" + tberat.getText() + "', Harga='" + tharga.getText() + "', "
                        + "Total_bayar='" + ttotalbayar.getText() + "' where Kode_pelanggan='" + tkodepel.getText() + "'";
                PreparedStatement edit = kon.con.prepareStatement(sql);
                edit.execute();
                JOptionPane.showMessageDialog(null, "UPDATE DATA BERHASIL");
                tabel();
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
                PreparedStatement st = kon.con.prepareStatement(sql);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "HAPUS DATA SUKSES");
                tabel();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "GAGAL DIHAPUS\n" + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "HAPUS DATA DIBATALKAN");
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void bcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcancelActionPerformed
        // TODO add your handling code here:
        kosong();
        nonAktif();
        btambah.setEnabled(true);
    }//GEN-LAST:event_bcancelActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        // TODO add your handling code here:
        aktif();
        bupdate.setEnabled(true);
        bdelete.setEnabled(true);

        btambah.setEnabled(false);
        bedit.setEnabled(false);
        bsimpan.setEnabled(false);
    }//GEN-LAST:event_beditActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
        kosong();
        aktif();
        btambah.setEnabled(false);
        bedit.setEnabled(false);
    }//GEN-LAST:event_btambahActionPerformed

    private void cbSepatuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSepatuActionPerformed
        // TODO add your handling code here:
        hitungTambahan();
    }//GEN-LAST:event_cbSepatuActionPerformed

    private void cbJaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJaketActionPerformed
        // TODO add your handling code here:
        hitungTambahan();
    }//GEN-LAST:event_cbJaketActionPerformed

    private void ttambahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttambahanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttambahanActionPerformed

    private void cbSepraiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSepraiActionPerformed
        // TODO add your handling code here:
        hitungTambahan();
    }//GEN-LAST:event_cbSepraiActionPerformed

    private void thargaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thargaKeyReleased
        // TODO add your handling code here:
//        if (tharga.getText().equals("")) {
//            //ttotalbayar.setText("");
//            harga = 0;
//        } else {
//            hitung();
//        }
    }//GEN-LAST:event_thargaKeyReleased

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
    private javax.swing.JButton bedit;
    private javax.swing.JButton bexit;
    private javax.swing.JButton breconnect;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JButton bupdate;
    private javax.swing.JCheckBox cbJaket;
    private javax.swing.JCheckBox cbSepatu;
    private javax.swing.JCheckBox cbSeprai;
    private javax.swing.JComboBox<String> cbharga;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabeldata;
    private javax.swing.JTextArea talamat;
    private javax.swing.JTextField tberat;
    private javax.swing.JTextField tharga;
    private javax.swing.JTextField tkodepel;
    private javax.swing.JTextField tnamapel;
    private javax.swing.JTextField tnotlp;
    private javax.swing.JTextField ttambahan;
    private javax.swing.JTextField ttgl;
    private javax.swing.JTextField ttotalbayar;
    // End of variables declaration//GEN-END:variables
}

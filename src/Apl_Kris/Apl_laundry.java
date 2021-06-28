/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apl_Kris;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
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
        isiNamaPaket();
        tidbantu.setVisible(false);
        jLabel9.setVisible(false);
        Lbstatus.setVisible(false);
//        breconnect.setVisible(false);
        
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
        
        jPanel3.setEnabled(false);
        cbJaket.setEnabled(false);
        cbSeprai.setEnabled(false);
        cbSepatu.setEnabled(false);
        cbJaket.setSelected(false);
        cbSeprai.setSelected(false);
        cbSepatu.setSelected(false);
        
        

        tkodepel.setEnabled(false);
        talamat.setEnabled(false);
        tberat.setEnabled(false);
//        tharga.setEnabled(false);
        tkodepel.setEnabled(false);
        tnamapel.setEnabled(false);
        tnotlp.setEnabled(false);
//        ttotalbayar.setEnabled(false);
    }

    private void aktif() {
        bsimpan.setEnabled(true);
        cbharga.setEnabled(true);
        
        jPanel3.setEnabled(true);
        cbJaket.setEnabled(true);
        cbSeprai.setEnabled(true);
        cbSepatu.setEnabled(true);

//        tkodepel.setEnabled(true);
        talamat.setEnabled(true);
        tberat.setEnabled(true);
//        tharga.setEnabled(true);
//        tkodepel.setEnabled(true);
        tnamapel.setEnabled(true);
        tnotlp.setEnabled(true);
//        ttotalbayar.setEnabled(true);
    }

    private void tgl() {
        Date ys = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        ttgl.setText(s.format(ys));
    }

    private void autoId() {
        try {
            kon.koneksi();
            String sql = "SELECT Id_bantu as x FROM laundry order by Id_bantu desc";
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
                tkodepel.setText("TRS" + Integer.toString(a + 1));
                tidbantu.setText(Integer.toString(a + 1));
            } else {
                tidbantu.setText("1");
                tkodepel.setText("TRS1");
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void refreshJframe(){
        Apl_laundry main = new Apl_laundry();
        main.setVisible(true);
        this.dispose();
        //<editor-fold defaultstate="collapsed" desc="comment">
        
//        cbharga.setVisible(true);
//        cbharga.removeAllItems();
//        try {
//            sql = "select * from paket";
//            kon.st = kon.con.createStatement();
//            kon.rs = kon.st.executeQuery(sql);
//            while (kon.rs.next()) {
//                cbharga.removeAllItems();
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//</editor-fold>
    }
    
    private void isiNamaPaket() {
        try {
            sql = "select * from paket";
            kon.st = kon.con.createStatement();
            kon.rs = kon.st.executeQuery(sql);
            while (kon.rs.next()) {
                cbharga.addItem(kon.rs.getString("Nama_paket"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void tabel() {
        dtm = new DefaultTableModel();
        dtm.addColumn("No");
        dtm.addColumn("TANGGAL");
        dtm.addColumn("KODE TRANSAKSI");
        dtm.addColumn("NAMA");
        dtm.addColumn("No TELP");
        dtm.addColumn("ALAMAT");
        dtm.addColumn("BERAT (kg)");
        dtm.addColumn("PAKET");
        dtm.addColumn("TAMBAHAN");
        dtm.addColumn("TOTAL BAYAR");

        try {
            int no = 1;
            sql = "select * from laundry";
            kon.st = kon.con.createStatement();
            kon.rs = kon.st.executeQuery(sql);
            while (kon.rs.next()) {
                dtm.addRow(new Object[]{no++, kon.rs.getString("Tanggal"), kon.rs.getString("Kode_pelanggan"),
                    kon.rs.getString("Nama_pelanggan"), kon.rs.getString("No_telp"), kon.rs.getString("Alamat"),
                    kon.rs.getString("Berat_Pakaian"), kon.rs.getString("Harga"), kon.rs.getString("Tambahan"), kon.rs.getString("Total_bayar")});
            }
            tabeldata.setModel(dtm);
        } catch (Exception e) {
            tabeldata.setModel(dtm);
        }

        tabeldata.getColumn("No").setMaxWidth(30);
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
//                tharga.setText("");
            } else {
                berat = Float.valueOf(tberat.getText());
            }
            if (tharga.getText().equals("")) {
                //ttotalbayar.setText("");
                harga = 0;
            } else {
                harga = Integer.parseInt(tharga.getText());
            }
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
        ttambahan.setText("");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSmall = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tidbantu = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelBig = new javax.swing.JPanel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        talamat = new javax.swing.JTextArea();
        breconnect = new javax.swing.JButton();
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
        Lbstatus = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelSmall.setBackground(new java.awt.Color(153, 255, 204));
        panelSmall.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Apl_Kris/washing-machine small.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel10.setText("KRIS LAUNDRY KILOAN");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tidbantu.setText("idbantu");

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelSmallLayout = new javax.swing.GroupLayout(panelSmall);
        panelSmall.setLayout(panelSmallLayout);
        panelSmallLayout.setHorizontalGroup(
            panelSmallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSmallLayout.createSequentialGroup()
                .addGroup(panelSmallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSmallLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tidbantu))
                    .addGroup(panelSmallLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55))
        );
        panelSmallLayout.setVerticalGroup(
            panelSmallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSmallLayout.createSequentialGroup()
                .addGroup(panelSmallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSmallLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tidbantu))
                    .addComponent(icon)
                    .addGroup(panelSmallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSmallLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSmallLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jLabel10))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBig.setBackground(new java.awt.Color(0, 204, 204));

        tkodepel.setEditable(false);
        tkodepel.setEnabled(false);

        ttgl.setEditable(false);
        ttgl.setEnabled(false);

        tberat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tberatKeyReleased(evt);
            }
        });

        bexit.setText("Tutup");
        bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitActionPerformed(evt);
            }
        });

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

        jLabel1.setText("Kode Transaksi");

        jLabel2.setText("Tanggal");

        jLabel3.setText("Alamat");

        jLabel4.setText("Nama Pelanggan");

        jLabel5.setText("No Telp");

        talamat.setColumns(20);
        talamat.setRows(5);
        jScrollPane2.setViewportView(talamat);

        breconnect.setText("Refresh");
        breconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breconnectActionPerformed(evt);
            }
        });

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

        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        bedit.setText("Edit");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });

        bcancel.setText("Batal");
        bcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcancelActionPerformed(evt);
            }
        });

        bdelete.setText("Hapus");
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });

        bupdate.setText("Update");
        bupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bupdateActionPerformed(evt);
            }
        });

        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        jLabel8.setText("Total Bayar");

        ttotalbayar.setEditable(false);
        ttotalbayar.setEnabled(false);

        ttambahan.setEditable(false);
        ttambahan.setEnabled(false);

        jLabel11.setText("Tambahan");

        jLabel7.setText("Paket");

        jLabel6.setText("Berat Pakaian (kg)");

        tharga.setEditable(false);
        tharga.setEnabled(false);

        cbharga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=PILIH PAKET=" }));
        cbharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbhargaActionPerformed(evt);
            }
        });

        Lbstatus.setText("status");
        Lbstatus.setEnabled(false);

        jLabel9.setText("Status Koneksi :");
        jLabel9.setEnabled(false);

        javax.swing.GroupLayout panelBigLayout = new javax.swing.GroupLayout(panelBig);
        panelBig.setLayout(panelBigLayout);
        panelBigLayout.setHorizontalGroup(
            panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBigLayout.createSequentialGroup()
                .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBigLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(panelBigLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(Lbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(breconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelBigLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBigLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(78, 78, 78)
                                .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBigLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(39, 39, 39)
                                .addComponent(tkodepel, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBigLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(29, 29, 29)
                                .addComponent(tnamapel, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBigLayout.createSequentialGroup()
                                .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGap(83, 83, 83)
                                .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addComponent(tnotlp, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))))
                        .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBigLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tharga, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                    .addComponent(ttambahan, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                    .addComponent(ttotalbayar, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                    .addComponent(tberat)))
                            .addGroup(panelBigLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelBigLayout.createSequentialGroup()
                                        .addComponent(btambah, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelBigLayout.createSequentialGroup()
                                        .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bdelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bcancel, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                                .addGap(88, 88, 88)))
                        .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBigLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(bexit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE))
                            .addGroup(panelBigLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbharga, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panelBigLayout.setVerticalGroup(
            panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBigLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(tberat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bexit)
                    .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tkodepel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBigLayout.createSequentialGroup()
                        .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tnamapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(ttambahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tnotlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(ttotalbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(panelBigLayout.createSequentialGroup()
                                .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bcancel)
                                    .addComponent(bedit)
                                    .addComponent(btambah))
                                .addGap(27, 27, 27)
                                .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bupdate)
                                    .addComponent(bdelete)
                                    .addComponent(bsimpan)))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbstatus)
                    .addComponent(jLabel9)
                    .addComponent(breconnect))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSmall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBig, javax.swing.GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSmall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelBig, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1088, 626);
    }// </editor-fold>//GEN-END:initComponents

    private void cbhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbhargaActionPerformed
        // TODO add your handling code here
        try {
            String sql = "Select * from paket where Nama_paket='"+cbharga.getSelectedItem()+"'";
            kon.rs = kon.st.executeQuery(sql);
            if (kon.rs.next()){
                tharga.setText(kon.rs.getString("Harga_paket"));
            }
        }catch (SQLException e){

        }
        hitung();
        //<editor-fold defaultstate="collapsed" desc="if yang lama">
        //        String pil = cbharga.getSelectedItem().toString();
        //
        //        if (pil.equals("3 Hari (Rp 5000/kg)")) {
            //            tharga.setText("5000");
            //        } else if (pil.equals("1 Hari (Rp 9000/kg)")) {
            //            tharga.setText("9000");
            //        } else if (pil.equals("7 Jam (Rp 15000/kg)")) {
            //            tharga.setText("15000");
            //        } else {
            //            tharga.setText("");
            //        }
        //</editor-fold>
    }//GEN-LAST:event_cbhargaActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        try {
            sql = "insert into laundry values ('" + ttgl.getText() + "',"
            + "'" + tkodepel.getText() + "','" + tnamapel.getText() + "',"
            + "'" + tnotlp.getText() + "','" + talamat.getText() + "',"
            + "'" + tberat.getText() + "','" + tharga.getText() + "','" + ttambahan.getText() + "','" + ttotalbayar.getText() + "','" + tidbantu.getText() + "')";
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
                + "Berat_Pakaian='" + tberat.getText() + "', Harga='" + tharga.getText() + "', Tambahan='" + ttambahan.getText() + "',"
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
        autoId();
        btambah.setEnabled(false);
        bedit.setEnabled(false);
    }//GEN-LAST:event_btambahActionPerformed

    private void cbSepatuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSepatuActionPerformed
        // TODO add your handling code here:
        hitungTambahan();
    }//GEN-LAST:event_cbSepatuActionPerformed

    private void cbSepraiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSepraiActionPerformed
        // TODO add your handling code here:
        hitungTambahan();
    }//GEN-LAST:event_cbSepraiActionPerformed

    private void cbJaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJaketActionPerformed
        // TODO add your handling code here:
        hitungTambahan();
    }//GEN-LAST:event_cbJaketActionPerformed

    private void breconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breconnectActionPerformed
        // TODO add your handling code here:
//        kon.koneksi();
//        tabel();
        refreshJframe();
    }//GEN-LAST:event_breconnectActionPerformed

    private void tabeldataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeldataMouseClicked
        // TODO add your handling code here:
        ttgl.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 1).toString());
        tkodepel.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 2).toString());
        tnamapel.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 3).toString());
        tnotlp.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 4).toString());
        talamat.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 5).toString());
        tberat.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 6).toString());
        tharga.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 7).toString());
        ttambahan.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 8).toString());
        ttotalbayar.setText(tabeldata.getValueAt(tabeldata.getSelectedRow(), 9).toString());

        bedit.setEnabled(true);
    }//GEN-LAST:event_tabeldataMouseClicked

    private void bexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Yakin Ditutup?", "keluar", JOptionPane.YES_NO_OPTION);
        if (ok == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_bexitActionPerformed

    private void tberatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tberatKeyReleased
        // TODO add your handling code here:
        hitung();
    }//GEN-LAST:event_tberatKeyReleased

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
    private javax.swing.JPanel panelBig;
    private javax.swing.JPanel panelSmall;
    private javax.swing.JTable tabeldata;
    private javax.swing.JTextArea talamat;
    private javax.swing.JTextField tberat;
    private javax.swing.JTextField tharga;
    private javax.swing.JLabel tidbantu;
    private javax.swing.JTextField tkodepel;
    private javax.swing.JTextField tnamapel;
    private javax.swing.JTextField tnotlp;
    private javax.swing.JTextField ttambahan;
    private javax.swing.JTextField ttgl;
    private javax.swing.JTextField ttotalbayar;
    // End of variables declaration//GEN-END:variables
}

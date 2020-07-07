/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuran;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;       

 
/**
 *
 * @author Rofi
 */
public class UI_PPU extends javax.swing.JFrame implements Struk{
    Connection con, conn = null;
    Statement st, stmt = null;
    ResultSet res, rs = null;
    String nomor,gID, nama, kode, tanggal, kode_pt, nama_pt, tanggal_bayar;
    int ID, gaji, tunjangan, angkel, jumlahpenghasilan, iuran, total, bulan;
    LocalDate now = LocalDate.now();
    
    
    
    /**
     * Creates new form FormMenuUtama
     */
    @Override
    public void cetakStruk(String fileName, String fileContent) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(fileContent);
            fileWriter.close();
            System.out.println("File sudah ditulis ulang!");
        }catch (IOException e) {
            System.out.println("Terjadi kesalahan karena: " + e.getMessage());
        }
    }

    
    private void hapuslayar() {
      txtkaryawan.setText("");
      txtgaji.setText("");
      txttunjangan.setText("");
      txtangkel.setText("");
      txtjumlah.setText("");
      txttanggal.setText("");
      txtiuran.setText("");
    }
    
    private void Tampilkan_Data(){
        
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("ID");
        model.addColumn("Nama Karyawan");
        model.addColumn("Gaji Pokok");
        model.addColumn("Tunjangan");
        model.addColumn("Anggota Keluarga");
        model.addColumn("Jumlah Penghasilan");
        model.addColumn("Tanggal Bayar");
        model.addColumn("Iuran BPJS");
        
        tabdata.setModel(model);
        
        try {
            
            int no = 1;
            
            Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/bpjs","root","");
                st = con.createStatement();
//                String sql = "Select * from data_ppu where kode_pt "
                
            String sql = "Select * from data_ppu where kode_pt='"+nomor+"'";;
                    
            res = st .executeQuery(sql);
            while (res.next()){
                model.addRow(new Object[]{res.getInt("ID"),res.getString("nama"),
                    res.getString("gaji"), res.getString("tunjangan"),
                    res.getString("angkel"), res.getString("jumlahpenghasilan"),
                    res.getString("tanggal"),res.getString("iuran")});
                }

            
            } catch(Exception e){
                System.out.println("Error : " + e.getMessage());
            
        }
    }
    
    public UI_PPU(){
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        Tampilkan_Data();
        hapuslayar();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtkaryawan = new javax.swing.JTextField();
        txtgaji = new javax.swing.JTextField();
        txttunjangan = new javax.swing.JTextField();
        txtangkel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnhitung = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtjumlah = new javax.swing.JTextField();
        btnhitungiuran = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtiuran = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        btdelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabdata = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnbayar = new javax.swing.JButton();
        txttanggal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 162, 73));
        jPanel1.setPreferredSize(new java.awt.Dimension(1199, 421));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nama Karyawan     : ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 53, 114, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tunjangan Tetap   : ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 115, 115, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gaji Pokok             : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 85, 116, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pembayaran PPU");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(540, 20, 260, 30);

        txtkaryawan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtkaryawan.setEnabled(false);
        jPanel1.add(txtkaryawan);
        txtkaryawan.setBounds(134, 50, 150, 21);

        txtgaji.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtgaji.setEnabled(false);
        jPanel1.add(txtgaji);
        txtgaji.setBounds(136, 82, 148, 21);

        txttunjangan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txttunjangan.setEnabled(false);
        jPanel1.add(txttunjangan);
        txttunjangan.setBounds(135, 112, 150, 21);

        txtangkel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtangkel.setEnabled(false);
        jPanel1.add(txtangkel);
        txtangkel.setBounds(135, 144, 150, 21);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Anggota Keluarga  : ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 147, 113, 15);

        btnhitung.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnhitung.setText("Jumlah");
        btnhitung.setEnabled(false);
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });
        jPanel1.add(btnhitung);
        btnhitung.setBounds(132, 203, 69, 23);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jumlah Penghasilan :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 240, 112, 15);

        txtjumlah.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtjumlah.setEnabled(false);
        jPanel1.add(txtjumlah);
        txtjumlah.setBounds(132, 237, 149, 21);

        btnhitungiuran.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnhitungiuran.setText("Hasil");
        btnhitungiuran.setEnabled(false);
        btnhitungiuran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungiuranActionPerformed(evt);
            }
        });
        jPanel1.add(btnhitungiuran);
        btnhitungiuran.setBounds(132, 269, 64, 23);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Iuran BPJS            :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 309, 110, 15);

        txtiuran.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtiuran.setEnabled(false);
        jPanel1.add(txtiuran);
        txtiuran.setBounds(132, 306, 160, 21);

        btnsave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnsave.setText("Save");
        btnsave.setEnabled(false);
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnsave);
        btnsave.setBounds(450, 270, 71, 23);

        btnedit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnedit.setText("Update");
        btnedit.setEnabled(false);
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit);
        btnedit.setBounds(540, 270, 80, 23);

        btncancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btncancel.setText("Cancel");
        btncancel.setEnabled(false);
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        jPanel1.add(btncancel);
        btncancel.setBounds(640, 270, 69, 23);

        btdelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btdelete.setText("Delete");
        btdelete.setEnabled(false);
        btdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btdelete);
        btdelete.setBounds(720, 270, 69, 23);

        tabdata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Karyawan", "Gaji Pokok", "Tunjangan", "Anggota Keluarga", "Jumlah Penghasilan", "Iuran BPJS"
            }
        ));
        tabdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabdataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabdata);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(360, 60, 780, 191);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total Iuran :");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(810, 320, 68, 15);

        btnbayar.setText("Bayar");
        btnbayar.setEnabled(false);
        btnbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayarActionPerformed(evt);
            }
        });
        jPanel1.add(btnbayar);
        btnbayar.setBounds(960, 350, 73, 23);

        txttanggal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txttanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttanggalActionPerformed(evt);
            }
        });
        jPanel1.add(txttanggal);
        txttanggal.setBounds(135, 171, 150, 21);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tanggal Bayar       :");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 174, 113, 15);

        jButton1.setText("Cek");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(300, 20, 51, 23);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(135, 20, 150, 20);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Masukan Kode PT       : ");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 20, 112, 14);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Rp. ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(900, 320, 35, 22);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iuran/Icon/logo bpjs kesehatan white opacity 30%.png"))); // NOI18N
        jPanel1.add(jLabel12);
        jLabel12.setBounds(400, 0, 430, 400);

        jMenu1.setText("Menu Utama ");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Pembayaran");

        jMenuItem1.setText("PBI");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Mandiri");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("PPU");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Exit");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
       int penghasilan = Integer.parseInt(txtgaji.getText()) + Integer.parseInt(txttunjangan.getText());
       txtjumlah.setText(""+penghasilan);
       
    }//GEN-LAST:event_btnhitungActionPerformed

    private void btnhitungiuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungiuranActionPerformed

        int angkel = Integer.parseInt(txtangkel.getText());
        if (angkel == 1 ){
           int iuran = Integer.parseInt(txtjumlah.getText()) * 5/100;
           txtiuran.setText(""+iuran);
        }
        else if (angkel == 2 ){
           int iuran = Integer.parseInt(txtjumlah.getText()) * 6/100;
           txtiuran.setText(""+iuran); 
        }
        else if (angkel == 3 ){
           int iuran = Integer.parseInt(txtjumlah.getText()) * 7/100;
           txtiuran.setText(""+iuran); 
        }
        else if (angkel == 4 ){
           int iuran = Integer.parseInt(txtjumlah.getText()) * 8/100;
           txtiuran.setText(""+iuran); 
        }
        else if (angkel == 5 ){
           int iuran = Integer.parseInt(txtjumlah.getText()) * 9/100;
           txtiuran.setText(""+iuran); 
        }
        else if (angkel == 6 ){
           int iuran = Integer.parseInt(txtjumlah.getText()) * 10/100;
           txtiuran.setText(""+iuran); 
        }
            
    }//GEN-LAST:event_btnhitungiuranActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
String user="root";
String pswd ="";
String host="localhost";
String db="bpjs";
String url="";

try {
Class.forName("com.mysql.jdbc.Driver");
url="jdbc:mysql://"+ host +"/"+ db + "?user=" + user +"&password="+ pswd;
Connection conn=DriverManager.getConnection(url);
PreparedStatement pStatement = 
        conn.prepareStatement("INSERT INTO data_ppu(kode_pt,nama,gaji,tunjangan,angkel,jumlahpenghasilan,tanggal,iuran)" + "VALUES (?,?,?,?,?,?,?,?)");
pStatement.setString(1, jTextField1.getText());
pStatement.setString(2, txtkaryawan.getText());
pStatement.setString(3, txtgaji.getText());
pStatement.setString(4, txttunjangan.getText());
pStatement.setString(5, txtangkel.getText());
pStatement.setString(6, txtjumlah.getText());
pStatement.setString(7, txttanggal.getText());
pStatement.setString(8, txtiuran.getText());


if (pStatement.executeUpdate()>0)
JOptionPane.showMessageDialog(this,
"Penambahan sukses", "Informasi",
JOptionPane.INFORMATION_MESSAGE);


else 
JOptionPane.showMessageDialog(this,
"Penambahan gagal", "Informasi",
JOptionPane.INFORMATION_MESSAGE);


pStatement.close();
conn.close();
txtkaryawan.setText("");
txtgaji.setText("");
txttunjangan.setText("");
txtangkel.setText("");
txtjumlah.setText("");
txtiuran.setText("");
}
catch(ClassNotFoundException e) {
System.out.println("jdbc.Driver tidak ditemukan");
}
catch (SQLException e){
System.out.println("koneksi gagal " + e.toString());
}

        Tampilkan_Data();
        hapuslayar();   
                                            
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdeleteActionPerformed
        try{
            String sql = "DELETE FROM data_ppu WHERE nama ='"+txtkaryawan.getText()+"'";
            Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/bpjs","root","");
                st = con.createStatement();
                
            st.executeUpdate(sql);   
            JOptionPane.showMessageDialog(null,"HAPUS DATA BERHASIL");
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Data Telah Terdaftar",
                    "Pesan",JOptionPane.WARNING_MESSAGE);
        }
        Tampilkan_Data();
        hapuslayar(); 
    }//GEN-LAST:event_btdeleteActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        hapuslayar();// TODO add your handling code here:
    }//GEN-LAST:event_btncancelActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        try{
            Class.forName("com.mysql.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/bpjs","root","");
               st = con.createStatement();
            String sql = "UPDATE data_ppu SET nama='"+txtkaryawan.getText()
                    +"', gaji='"+txtgaji.getText()
                    +"', tunjangan='"+txttunjangan.getText()
                    +"', angkel='"+txtangkel.getText()
                    +"', jumlahpenghasilan='"+txtjumlah.getText()
                    +"', tanggal='"+txttanggal.getText()
                    +"', iuran='"+txtiuran.getText()
                    +"' where ID="+gID;
            
            st.executeUpdate(sql);
            Tampilkan_Data();
            JOptionPane.showMessageDialog(null, "EDIT DATA BERHASIL");
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UI_PPU.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditActionPerformed


    private void txttanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttanggalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtkaryawan.setEnabled(true);
        txtgaji.setEnabled(true);
        txttunjangan.setEnabled(true);
        txtangkel.setEnabled(true);
        btnhitung.setEnabled(true); 
        btnhitungiuran.setEnabled(true);
        btnsave.setEnabled(true);
        btnedit.setEnabled(true);
        btncancel.setEnabled(true);
        btnbayar.setEnabled(true);
        btdelete.setEnabled(true);
        bulan=0;
        total=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bpjs","root","");
            stmt = conn.createStatement();
            
            nomor = jTextField1.getText();
            rs = stmt.executeQuery("Select * from data_ppu where kode_pt='"+nomor+"'");
           
            while(rs.next()){
                ID = rs.getInt("ID");
                kode = rs.getString("kode_pt");
                nama = rs.getString("nama");
                gaji = rs.getInt("gaji");
                tunjangan = rs.getInt("tunjangan");
                angkel = rs.getInt("angkel");
                jumlahpenghasilan = rs.getInt("jumlahpenghasilan");
                tanggal = rs.getString("tanggal");
                iuran = rs.getInt("iuran");
                total += iuran;
          }
            PPU z = new PPU(ID, kode, nama, gaji, tunjangan, angkel, jumlahpenghasilan, tanggal, iuran);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date data = formatter.parse(z.tanggal);
            //Converting obtained Date object to LocalDate object
            Instant instant = data.toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate localDate = zone.toLocalDate();
            now = LocalDate.now();
            // Penghitungan untuk mendapatkan selisih tunggakan bulan 
            Period diff = Period.between(localDate, now);
            System.out.println(diff.getMonths());
            btnbayar.setEnabled(true);
            if(kode.equals(nomor)){
                Tampilkan_Data();
                if(diff.getYears() > 0){
                bulan = bulan+(12*diff.getYears());
                }
                if(diff.getMonths() <= 0 && diff.getYears() == 0){
                    bulan = 0;
                    JOptionPane.showMessageDialog(null, "Perusahaan Anda Tidak Memiliki Tunggakan");
                    btnbayar.setEnabled(false);
                }else{
                    bulan = bulan+diff.getMonths();
                }
                jLabel8.setText(String.valueOf("Rp. "+bulan*total));
            }else{
                Tampilkan_Data();
                jLabel8.setText("Rp. 0");
                JOptionPane.showMessageDialog(null, "Kode yang anda masukan salah");
                
            }
         } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UI_PPU.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(UI_PPU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayarActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bpjs","root","");
            stmt = conn.createStatement();
            stmt.executeUpdate("Update data_ppu set tanggal = '"+now+"' where kode_pt = '"+jTextField1.getText()+"'");
            jLabel8.setText("Rp. 0");
            JOptionPane.showMessageDialog(null,"Pembayaran Sukses");
            Tampilkan_Data();
            rs = stmt.executeQuery("SELECT akun_ppu.kode_pt, akun_ppu.namaperusahaan, data_ppu.ID, data_ppu.tanggal\n" +
                                    "FROM akun_ppu\n" +
                                    "INNER JOIN data_ppu\n" +
                                    "ON akun_ppu.kode_pt = data_ppu.kode_pt where data_ppu.kode_pt='"+kode+"'");
            int i=0;
            while(rs.next()){
                kode_pt = rs.getString("kode_pt");
                nama_pt = rs.getString("namaperusahaan");
                tanggal_bayar = rs.getString("tanggal");
                i++;
            }
            String fileName = "src/PPU_"+kode_pt+"_"+tanggal_bayar+".txt";
            String fileContent = 
                   "===Pembayaran BPJS===\n"
                   +"Pembayaran PPU "+tanggal_bayar+"\n"
                   +"Kode PT            : " +kode_pt+"\n"
                   +"Nama Perusahaan    : " +nama_pt+"\n"
                   +"Karyawan           : " +i+" Orang\n"
                   +"Periode            : " +bulan+" Bulan\n"
                   +"======================\n"
                   +"Total Bayar : "+bulan*total;
            cetakStruk(fileName, fileContent);
            JOptionPane.showMessageDialog(null, "Silahkan Ambil Struk");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UI_PPU.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnbayarActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new UI_Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new UI_PBI().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new UI_Mandiri().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new UI_PPU().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void tabdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabdataMouseClicked
        int baris = tabdata.rowAtPoint(evt.getPoint());

        gID = tabdata.getValueAt(baris, 0).toString();
        String nama = tabdata.getValueAt(baris, 1).toString();
        txtkaryawan.setText(nama);

        String gaji = tabdata.getValueAt(baris, 2).toString();
        txtgaji.setText(gaji);

        String tunjangan = tabdata.getValueAt(baris, 3).toString();
        txttunjangan.setText(tunjangan);

        String angkel = tabdata.getValueAt(baris, 4).toString();
        txtangkel.setText(angkel);

        String jumlahpenghasilan = tabdata.getValueAt(baris, 5).toString();
        txtjumlah.setText(jumlahpenghasilan);

        String tanggal = tabdata.getValueAt(baris, 6).toString();
        txttanggal.setText(tanggal);

        String iuran = tabdata.getValueAt(baris, 7).toString();
        txtiuran.setText(iuran);

        // TODO add your handling code here:
    }//GEN-LAST:event_tabdataMouseClicked

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
            java.util.logging.Logger.getLogger(UI_PPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_PPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_PPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_PPU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_PPU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdelete;
    private javax.swing.JButton btnbayar;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhitung;
    private javax.swing.JButton btnhitungiuran;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabdata;
    private javax.swing.JTextField txtangkel;
    private javax.swing.JTextField txtgaji;
    private javax.swing.JTextField txtiuran;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkaryawan;
    private javax.swing.JTextField txttanggal;
    private javax.swing.JTextField txttunjangan;
    // End of variables declaration//GEN-END:variables

    


}

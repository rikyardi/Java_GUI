/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuran;

/**
 *
 * @author rikya
 */

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.Date;

public class Main extends Pembayaran{
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    static int total, bulan, tahun;
    static double total_ppu;
    static String nama, alamat, ttl, faskes, status, nomor, kk, nik, kelas, bayar;
//    static Date bayar;

    public Main(String nomor, String nama, String alamat, String ttl, String kk, String nik, String faskes, String status, String bayar) {
        super(nomor, nama, alamat, ttl, kk, nik, faskes, status, bayar);
    }
    
    public static String ShowData(String where){
        String sql = "select * from peserta where nomor_kartu='"+where+"'";
//        String sql = "SELECT kartu.nomor_kartu, data_diri.nama, data_diri.alamat, data_diri.ttl, data_diri.nomor_kk, data_diri.nik, kartu.faskes, kartu.status, kelas_mandiri.kelas, kartu.terakhir_bayar FROM kartu INNER JOIN data_diri on kartu.nik = data_diri.nik INNER JOIN kelas_mandiri on kelas_mandiri.kelas = kartu.kelas where kartu.nomor_kartu='"+where+"'";
        System.out.println(sql);
        return sql;
    }

    
    public static void main(String[] args) throws ClassNotFoundException, ParseException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bpjs","root","");
            stmt = conn.createStatement();
            
            System.out.println("Masukan Nomor Kartu Anda : ");
            Scanner input1 = new Scanner(System.in);
            String a = input1.nextLine();
//            PreparedStatement ps = conn.prepareStatement(ShowData(a));
//            
            rs = stmt.executeQuery(ShowData(a));
//            System.out.println(rs.getString("nomor_kartu"));           
            
            while(rs.next()){
                nomor = rs.getString("nomor");
                nama = rs.getString("nama");
                alamat = rs.getString("alamat");
                kk = rs.getString("nomor_kk");
                nik = rs.getString("nik");
                faskes = rs.getString("faskes");
                status = rs.getString("status");
                kelas = rs.getString("kelas");
                bayar = rs.getString("pembayaran");
            }
            
            Pembayaran p = new Pembayaran(nomor, nama, alamat, kk, nik, faskes, status, kelas, bayar);
            System.out.println(p.nomor);
            System.out.println(p.nama);
            System.out.println(p.alamat);
            System.out.println(p.kk);
            
            
            //Converting String to Date
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(p.bayar);
            System.out.println(p.bayar);
 
            //Converting obtained Date object to LocalDate object
            Instant instant = date.toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate localDate = zone.toLocalDate();
            LocalDate now = LocalDate.now();
            Period diff = Period.between(localDate, now);
            System.out.printf("\nDifference is %d years, %d months and %d days old\n\n", diff.getYears(), diff.getMonths(), diff.getDays());
            
            if(diff.getDays()>0){
                bulan = diff.getMonths()+1;
            }
            System.out.println(bulan);
            
            if(diff.getYears()>0){
                bulan = bulan+(12*diff.getYears());
            }
            System.out.println(bulan);
            

            System.out.println("jika anda peserta pbi : "+p.bayar_peserta_pbi(bulan));
            
        }catch (SQLException e) {
        	throw new IllegalStateException("Unable to connect to the database. " + e.getMessage());
        }
    }
    
}

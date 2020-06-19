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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    static Date date;
    static int total, bulan, tahun, harga;
    static double total_ppu;
    static String nama, alamat, ttl, faskes, status, nomor, kk, nik, kelas, bayar;
    static String[] nomor_kartu_kk, nama_kk, alamat_kk, ttl_kk, nik_kk, faskes_kk = new String[10];
    

    public static String ShowData(String where){
        String sql = "SELECT kartu.nomor_kartu, data_diri.nama, data_diri.alamat, data_diri.ttl, data_diri.nomor_kk, data_diri.nik, kartu.faskes, kartu.status, kelas_mandiri.kelas, kartu.terakhir_bayar FROM kartu INNER JOIN data_diri on kartu.nik = data_diri.nik INNER JOIN kelas_mandiri on kelas_mandiri.kelas = kartu.kelas where kartu.nomor_kartu='"+where+"'";
        return sql;
    }
    
    public static String getBanyakKeluarga(String where){
        String sql = "SELECT kartu.nomor_kartu, data_diri.nama, data_diri.alamat, data_diri.ttl, data_diri.nomor_kk, data_diri.nik, kartu.faskes, kartu.status, kelas_mandiri.kelas, kartu.terakhir_bayar FROM kartu INNER JOIN data_diri on kartu.nik = data_diri.nik INNER JOIN kelas_mandiri on kelas_mandiri.kelas = kartu.kelas where data_diri.nomor_kk='"+where+"'";        
        return sql;
    }
    
    public static String getDataKelas(String where){
        String sql = "Select * from kelas_mandiri where kelas = '"+where+"' ";
        return sql;
    }
    
//    public static HashMap<String, Integer> getData(String a){
//            // Converting String to Date
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            date = formatter.parse(a);
//        } catch (ParseException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            //Converting obtained Date object to LocalDate object
//            Instant instant = date.toInstant();
//            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
//            LocalDate localDate = zone.toLocalDate();
//            LocalDate now = LocalDate.now();
//            
//            // Penghitungan untuk mendapatkan selisih tunggakan bulan 
//            Period diff = Period.between(localDate, now);
// 
////            System.out.printf("\nDifference is %d years, %d months and %d days old\n\n", diff.getYears(), diff.getMonths(), diff.getDays());
//            HashMap<String, Integer> days = new HashMap<String, Integer>();
//            days.put("Hari", diff.getDays());
//            days.put("Bulan", diff.getMonths());
//            days.put("Tahun", diff.getYears());
//            return days;
//    }
    
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bpjs","root","");
            stmt = conn.createStatement();
            
            System.out.println("Masukan Nomor Kartu Anda : ");
            Scanner input1 = new Scanner(System.in);
            String a = input1.nextLine();

            rs = stmt.executeQuery(ShowData(a));
            
            while(rs.next()){
                nomor = rs.getString("nomor_kartu");
                nama = rs.getString("nama");
                alamat = rs.getString("alamat");
                ttl = rs.getString("ttl");
                kk = rs.getString("nomor_kk");
                nik = rs.getString("nik");
                faskes = rs.getString("faskes");
                status = rs.getString("status");
                kelas = rs.getString("kelas");
                bayar = rs.getString("terakhir_bayar");
                 
            }
            
            Mandiri p = new Mandiri(nomor, nama, alamat, ttl, kk, nik, faskes, status, kelas, bayar);
            
            //Converting String to Date
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.parse(p.bayar);
            //Converting obtained Date object to LocalDate object
            Instant instant = date.toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate localDate = zone.toLocalDate();
            LocalDate now = LocalDate.now();
            
            // Penghitungan untuk mendapatkan selisih tunggakan bulan 
            Period diff = Period.between(localDate, now);
            
            rs = stmt.executeQuery(getDataKelas(p.kelas));
            while(rs.next()){
                harga = rs.getInt("iuran_perbulan");
            }

            rs = stmt.executeQuery(getBanyakKeluarga(p.kk));
            int i = 1;
            while(rs.next()){
//                for(int bar = 0; rs.next(); bar++){
//                    for(int kol = 0; rs.next(); kol++){
//                        nomor_kartu_kk[bar][kol] = rs.getString("nomor_kartu");
//                        nama_kk[bar][kol] = rs.getString("nama");
//                        alamat_kk[bar][kol] = rs.getString("alamat");
//                        ttl_kk[bar][kol] = rs.getString("ttl");
//                        nik_kk[bar][kol] = rs.getString("nik");
//                        faskes_kk[bar][kol] = rs.getString("faskes");
//                    }
//                }
//                nomor_kartu_kk[i] = rs.getString("nomor_kartu");
//                nama_kk[i] = rs.getString("nama");
//                alamat_kk[i] = rs.getString("alamat");
//                ttl_kk[i] = rs.getString("ttl");
//                nik_kk[i] = rs.getString("nik");
//                faskes_kk[i] = rs.getString("faskes");
                i++;
            }
            System.out.println("Anda adalah peserta "+p.status+" Kelas "+p.kelas+" Terdiri dari "+i+" orang keluarga");
            
            if(diff.getMonths()<=0){
                System.out.println("Anda Tidak Memiliki Tunggakan");
            }
            if(diff.getDays()>0){
                bulan = diff.getMonths()+1;
            }
            if(diff.getYears()>0){
                bulan = bulan+(12*diff.getYears());
            }
            
            System.out.println("Tunggakan anda "+bulan+" bulan");
//            for(int n=0; n<=i; n++){
//           0002743817274     System.out.println("Nomor Kartu    : "+nomor_kartu_kk[n]);
//                System.out.println("NIK            : "+nik_kk[n]);
//                System.out.println("Nama           : "+nama_kk[n]);
//                System.out.println("Alamat         : "+alamat_kk[n]);
//                System.out.println("TTL            : "+ttl_kk[n]);
//                System.out.println("Faskes         : "+faskes_kk[n]);
//                
//            }
            total = p.hitungbayar(bulan, harga, i);
            System.out.println(total);

        }catch (SQLException e ) {
        	throw new IllegalStateException("Unable to connect to the database. " + e.getMessage());
        } catch (ClassNotFoundException | ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

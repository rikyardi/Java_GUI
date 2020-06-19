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
//import java.time.LocalDate;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.TimeZone;

public class Pembayaran {
    int total;
    double total_ppu;
    String bulan, nama, alamat, ttl, faskes, status, kelas, nomor, nik, kk, bayar;
    static int pbi = 42000;
    static double ppu = 0.05;
 
    public Pembayaran(String nomor, String nama, String alamat, String ttl, String kk, String nik, String faskes, String status, String bayar){
        this.nomor = nomor;
        this.nama = nama;
        this.alamat = alamat;
        this.ttl = ttl;
        this.kk = kk;
        this.nik = nik;
        this.faskes = faskes;
        this.status = status;
        this.bayar = bayar;
    }

}

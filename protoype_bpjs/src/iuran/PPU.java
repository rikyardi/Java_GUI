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
public class PPU {
   
    int ID, gaji, tunjangan, angkel, jumlahpenghasilan, iuran;
    String kode_pt, nama, tanggal;
    double total;
    public PPU(int ID, String kode_pt, String nama, int gaji, int tunjangan, int angkel, int jumlahpenghasilan, String tanggal, int iuran) {
        this.ID = ID;
        this.kode_pt = kode_pt;
        this.nama = nama;
        this.gaji = gaji;
        this.tunjangan = tunjangan;
        this.angkel = angkel;
        this.jumlahpenghasilan = jumlahpenghasilan;
        this.tanggal = tanggal;
        this.iuran = iuran;
    }
    
    double gaji(int x){
        total = x * Pembayaran.ppu;
        return total;
    }
}

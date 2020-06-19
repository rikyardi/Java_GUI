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
public class PPU extends Pembayaran{
    int gaji;
    double total;
    public PPU(String nomor, String nama, String alamat, String ttl, String kk, String nik, String faskes, String status, int gaji, String bayar) {
        super(nomor, nama, alamat, ttl, kk, nik, faskes, status, bayar);
        gaji = this.gaji;
    }
    
    double gaji(int x){
        total = x * Pembayaran.ppu;
        return total;
    }
}

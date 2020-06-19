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
public class Mandiri extends Pembayaran{
    String kelas;
    int total;
    
    public Mandiri(String nomor, String nama, String alamat, String ttl, String kk, String nik, String faskes, String status, String kelas, String bayar) {
        super(nomor, nama, alamat, ttl, kk, nik, faskes, status, bayar);
        this.kelas = kelas;
    }

    int hitungbayar(int x, int y, int z){
        total = x * y * z;
        return total;
        
    }
    }


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
public class PBI extends Pembayaran{
    int total;
    public PBI(String nomor, String nama, String alamat, String ttl, String kk, String nik, String faskes, String status, String bayar) {
        super(nomor, nama, alamat, ttl, kk, nik, faskes, status, bayar);
    }
    
    int hitungbayar(int x){
        total = x * Pembayaran.pbi;
        return total;
    }
    
}

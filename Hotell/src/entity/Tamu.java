/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

// Class Entitas
public class Tamu extends Penduduk {
    private String alamat;
    private String noTelp;

    public Tamu() {
    }

    // Constructor
    public Tamu(String nik, String nama, String alamat, String noTelp) {
        this.nik = nik;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }

    // Method
    public void dataTamu() {
        System.out.println("Nama Tamu       : " + nama);
        System.out.println("NIK Tamu        : " + nik);
        System.out.println("Alamat          : " + alamat);
        System.out.println("No Telp         : " + noTelp);
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

}
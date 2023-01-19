/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author RIO
 */
import entity.Kamar;
import entity.Reservasi;
import entity.Staff;
import entity.Tamu;
import java.util.ArrayList;
import utils.DateString;

// Class Inti (Core)
public class Hotell {
    public static ArrayList<Kamar> daftarKamar = new ArrayList<>();
    public static ArrayList<Staff> daftarStaff = new ArrayList<>();
    public static ArrayList<Reservasi> daftarReservasi = new ArrayList<>();
    Kamar kamar = new Kamar();
    
    public static ArrayList<Kamar> getKamarList() {
     return daftarKamar;
    }
    public static void initialKamar() {
        daftarKamar.add(new Kamar("101", "Single Bed", 400000, true));
        daftarKamar.add(new Kamar("102", "Single Bed", 400000, true));
        daftarKamar.add(new Kamar("103", "Double Bed", 600000, true));
        daftarKamar.add(new Kamar("104", "Superior Room", 820000, true));
    }

    public static void initalStaff() {
        daftarStaff.add(new Staff("Staff 1", "123", "1"));
        daftarStaff.add(new Staff("Staff 2", "654321", "123321"));
    }

    public static Kamar cariKamar(String kode) {
        for (Kamar kamar : daftarKamar) {
            if (kamar.getKodeKamar().equals(kode)) {
                return kamar;
            }
        }
        return null;
    }

    private static void updateStatusKamar(Kamar kamar, boolean status) {
        for (Kamar kamar2 : daftarKamar) {
            if (kamar.getKodeKamar().equals(kamar2.getKodeKamar())) {
                kamar2.setStatus(status);
                break;
            }
        }
    }

    public static void checkIn(Tamu tamu, Kamar kamar, int malam) {
        Reservasi checkIn = new Reservasi(tamu, kamar, malam);

        updateStatusKamar(kamar, false);

        daftarReservasi.add(checkIn);
    }

    public static int cariReservasibyKodeKamar(String kodeKamar) {
        int i = -1;
        for (Reservasi reservasi : daftarReservasi) {
            i += 1;
            if (reservasi.getKamar().getKodeKamar().equals(kodeKamar)) {
                if (!reservasi.getKamar().isStatus()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void checkOut(int indexReservasi) {
        Reservasi reservasi = daftarReservasi.get(indexReservasi);
        reservasi.setTanggalCheckOut(DateString.now());
        Kamar kamar = reservasi.getKamar();
        updateStatusKamar(kamar, true);

        daftarReservasi.set(indexReservasi, reservasi);
    }
}


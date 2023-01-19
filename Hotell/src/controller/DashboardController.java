/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.Hotell;
import entity.Kamar;
import entity.Penduduk;
import entity.Reservasi;
import entity.Staff;
import entity.Tamu;
import java.util.ArrayList;
/**
 *
 * @author RIO
 */
public class DashboardController {
    
    public void toView(){    
    
}
    
    public ArrayList <Kamar> daftarKamar() {
        return Hotell.getKamarList();
    }
    
     public Staff userLogged() {
        return Staff.getStaffLogged();
    }
}






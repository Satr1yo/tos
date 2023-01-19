/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotell;

import entity.Staff;

// Class Inti (Core)
public class Auth {
    static Staff staffLogged = null;

    public static Staff getStaffLogged() {
        return staffLogged;
    }

    public static boolean login(String nip, String password) {

        for (Staff staff : Hotell.daftarStaff) {
            if ((staff.getNip().equals(nip)) && (staff.getPassword().equals(password))) {
                staffLogged = staff;
                return true;
            }
        }
        return false;
    }
    
    public static void logout() {
        staffLogged = null;
    }
}
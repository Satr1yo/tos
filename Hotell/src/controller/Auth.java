/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Staff;
import view.auth.LoginFrame;
/**
 *
 * @author RIO
 */
public class Auth {
    static Staff staffLogged = null;

    public static Staff getStaffLogged() {
        return staffLogged;
    }
    public void toViewLogin() {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }

    public static boolean login(String nip, String password) {

        for (Staff staff : hotell.Hotell.daftarStaff) {
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
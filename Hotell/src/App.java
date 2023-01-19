/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import view.LoginPage;
import view.auth.LoginFrame;
/**
 *
 * @author RIO
 */

public class App {
    public static void main(String[] args) {
        hotell.Hotell.initalStaff();
        hotell.Hotell.initialKamar();
        
 new LoginFrame().setVisible(true);
    } 
}

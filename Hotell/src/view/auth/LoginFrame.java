/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.auth;


import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Auth;
import view.MainFrame;
import view.home.DashboardFrame;

public class LoginFrame extends MainFrame {
    private JLabel iconLabel;
    private JLabel titleLabel;

    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton masukBtn, daftarBtn;

    private Auth _authC = new Auth();

    public LoginFrame() {
        super("LOGIN", 400, 600);
    }

    @Override
    protected void component() {
        ImageIcon imgLoad = loadImage("src/assets/icon-login.png", 195, 195);
        iconLabel = new JLabel(imgLoad);
        boundedAdd(iconLabel, 103, 30, 195, 195);

        titleLabel = new JLabel("LOGIN");
        setFontSize(titleLabel, 30);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 155, 245, 92, 40);

        usernameLabel = new JLabel("Nama Staff");
        setFontSize(usernameLabel, 12);
        setFontStyle(usernameLabel, Font.BOLD);
        boundedAdd(usernameLabel, 172, 305, 56, 16);

        usernameField = new JTextField();
        boundedAdd(usernameField, 35, 325, 333, 32);

        passwordLabel = new JLabel("Password");
        setFontSize(passwordLabel, 12);
        setFontStyle(passwordLabel, Font.BOLD);
        boundedAdd(passwordLabel, 172, 375, 55, 16);

        passwordField = new JPasswordField();
        boundedAdd(passwordField, 35, 395, 333, 32);

        masukBtn = new JButton("Login");
        masukBtn.setBackground(color("#00D4FF")); // #00D4FF
        masukBtn.setForeground(color("#FFFFFF"));
        masukBtn.setFocusPainted(false);
        boundedAdd(masukBtn, 158, 467, 85, 32);

        daftarBtn = new JButton("daftar disini");
        daftarBtn.setBackground(color("#F0F0F0"));
        daftarBtn.setFocusPainted(false);
        daftarBtn.setBorderPainted(false);
        setFontSize(daftarBtn, 10);
        boundedAdd(daftarBtn, 158, 506, 85, 32);
    }

    @Override
    protected void event() {
        masukBtn.addActionListener((e) -> {
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            boolean status = _authC.login(username, password);

            if (status) {
                // View Dashboard / View Home
                new DashboardFrame().setVisible(true);
                dispose();
                
            } else {
                JOptionPane.showMessageDialog(null,
                        "Username atau Password Salah",
                        "Login Gagal",
                        JOptionPane.ERROR_MESSAGE);
            }

        });
    }

}


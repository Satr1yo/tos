/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.Component;
import java.awt.Font;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class MainFrame extends JFrame {
    // Default Konfigurasi Warna
    protected Color backgroundColor = Color.decode("#F0F0F0");
    protected Color primaryColor = Color.decode("#2490EC");
    protected Color secondaryColor = Color.decode("#D9D9D9");

    // Default Konfigurasi Tulisan
    protected String defaultFontName = "SegoeUI";
    protected int defaultFontSize = 18;

    /**
     * Constructor utama pembuatan Frame.
     * 
     * @param title  [String] - Title dari Frame
     * @param width  [int] - ukuran lebar Frame
     * @param height [int] - ukuran tinggi Frame
     */
    public MainFrame(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setBackground(backgroundColor);
        setLayout(null);
        setLocation(500, 250);

    }

    /**
     * Method component() dan event() dipindah sebelum setVisible di jalankan.
     * dengan syarat nilai boolean == true
     */
    @Override
    public void setVisible(boolean b) {
        if (b == true) {
            component();
            event();
        }
        super.setVisible(b);
    }

    /**
     * Method untuk Mendefinisikan / Membuat Component GUI
     * HARUS di Override di Anak Class
     */
    protected abstract void component();

    /**
     * Method untuk Mendefinisikan sebuah Interaksi / Event dari Component
     * HARUS di Override di Anak Class
     */
    protected abstract void event();

    /**
     * Method untuk mengatur posisi Component sekaligus menambahkan ke Frame
     * 
     * @param comp   [Component] - Component Java Swing
     * @param x      [int] - Posisi koordinat X
     * @param y      [int] - Posisi koordinat Y
     * @param width  [int] - Ukuran Lebar (Width)
     * @param height [int] - Ukuran Tinggi (Height)
     */
    protected void boundedAdd(Component comp, int x, int y, int width, int height) {
        int constX = 15, constY = 55;
        x = x - (constX / 2);
        y = y - (constY / 2);
        width = width + (constX / 2);
        comp.setBounds(x, y, width, height);
        add(comp);
    }

    /**
     * Membuat sebuah Component yang dapat menampilkan Gambar
     * dengan ukuran default: 150 x 150
     * Component ini dapat digunakan di JLabel sebagai tempat menampilkan Gambarnya
     * 
     * Contoh:
     * ImageIcon img = loadImage(imagePath);
     * JLabel imgLabel = new JLabel(img);
     * 
     * @param imagePath [String] - Tempat / Lokasi Image
     * @return ImageIcon
     */
    protected ImageIcon loadImage(String imagePath) {
        return loadImage(imagePath, 150, 150);
    }

    /**
     * Membuat sebuah Component yang dapat menampilkan Gambar
     * dengan ukuran yang dapat diatur
     * Component ini dapat digunakan di JLabel sebagai tempat menampilkan Gambarnya
     * 
     * Contoh:
     * ImageIcon img = loadImage(imagePath, 300, 200);
     * JLabel imgLabel = new JLabel(img);
     * 
     * @param imagePath [String] - Tempat / Lokasi Image
     * @param width     [int] - Lebar Gambar
     * @param height    [int] - Tinggi Gambar
     * @return ImageIcon
     */
    protected ImageIcon loadImage(String imagePath, int width, int height) {
        try {
            BufferedImage bImage;
            Image imgResize;
            ImageIcon imgIcon = null;

            bImage = ImageIO.read(new File(imagePath));

            imgResize = bImage.getScaledInstance(
                    width, height,
                    Image.SCALE_SMOOTH);

            imgIcon = new ImageIcon(imgResize);

            return imgIcon;
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * Mengatur Font Style dari Tulisan suatu Component.
     * 
     * Constanta Class Font:
     * Font.PLAIN | Font.BOLD | Font.ITALIC
     * 
     * @param comp  [Component] - Component yang mengandung Text (Tulisan)
     * @param style [int] - Constanta dari Class Font
     */
    protected void setFontStyle(Component comp, int style) {
        Font fontLama = comp.getFont();
        Font fontBaru = new Font(fontLama.getFontName(), style, fontLama.getSize());
        comp.setFont(fontBaru);
    }

    /**
     * Mengatur ukuran dari Tulisan suatu Component.
     * 
     * @param comp [Component] - Component yang mengandung Text (Tulisan)
     * @param size [int] - ukuran Font yang baru
     */
    protected void setFontSize(Component comp, int size) {
        Font fontLama = comp.getFont();
        Font fontBaru = new Font(fontLama.getFontName(), fontLama.getStyle(), size);
        comp.setFont(fontBaru);
    }

    /**
     * Mengatur Font Family dari Tulisan suatu Component.
     * 
     * "Arial", "Segoe UI", dsb
     * 
     * @param comp       [Component] - Component yang mengandung Text (Tulisan)
     * @param fontFamily [String] - nama Font Family
     */
    protected void setFontFamily(Component comp, String fontFamily) {
        Font fontLama = comp.getFont();
        Font fontBaru = new Font(fontFamily, fontLama.getStyle(), fontLama.getSize());
        comp.setFont(fontBaru);
    }

    /**
     * Menerjemahkan Kode Warna menjadi Class Color yang
     * dapat dipakai pada Component.
     * 
     * Kode "#fff" --> Putih
     * 
     * @param code [String] - Code dari Warna (diawali dengan #)
     * @return Color Object
     */
    protected Color color(String code) {
        return Color.decode(code);
    }
}
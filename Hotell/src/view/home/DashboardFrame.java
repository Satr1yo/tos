/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.home;

import java.awt.Font;
import java.util.ArrayList;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Hotell;
 import controller.DashboardController;
import entity.*;
import static hotell.Hotell.daftarKamar;
import view.MainFrame;

public class DashboardFrame extends MainFrame {
    private JLabel iconLabel;
    private JLabel titleLabel, subTitleLabel;
    private JButton lihatBtn, tambahBtn, editBtn, hapusBtn;
    private JButton refreshBtn;

    private JTable barangTable;
    private JScrollPane scrollPane;

    private JTextField selectedField = new JTextField();

    private DashboardController _dashboardC = new DashboardController();

    private Staff user;

    public DashboardFrame() {
        super("Dashboard", 800, 600);

        user = _dashboardC.userLogged();
    }

    @Override
    protected void component() {
        ImageIcon imgLoad = loadImage("src/assets/icon-login.png", 55, 55);
        iconLabel = new JLabel(imgLoad);
        boundedAdd(iconLabel, 34, 40, 55, 55);

        titleLabel = new JLabel("WELCOME");
        setFontSize(titleLabel, 15);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 102, 53, 73, 20);

   //     subTitleLabel = new JLabel();
        // subTitleLabel = new JLabel("");
     //   setFontSize(subTitleLabel, 20);
       // setFontStyle(subTitleLabel, Font.BOLD);
        //boundedAdd(subTitleLabel, 102, 68, 200, 27);

        refreshBtn = new JButton("Refresh");
        refreshBtn.setForeground(color("#00FF88"));
        refreshBtn.setBorder(new LineBorder(color("#00FF88"), 2, true));
        refreshBtn.setContentAreaFilled(false);
        refreshBtn.setFocusPainted(false);
        boundedAdd(refreshBtn, 690, 69, 80, 28);

        lihatBtn = new JButton("Lihat");
        lihatBtn.setBackground(color("#00FF88"));
        lihatBtn.setForeground(color("#FFFFFF"));
        lihatBtn.setFocusPainted(false);
        boundedAdd(lihatBtn, 690, 107, 80, 28);

        tambahBtn = new JButton("Tambah");
        tambahBtn.setBackground(color("#0080FF"));
        tambahBtn.setForeground(color("#FFFFFF"));
        tambahBtn.setFocusPainted(false);
        boundedAdd(tambahBtn, 600, 107, 80, 28);

        editBtn = new JButton("Edit");
        editBtn.setBackground(color("#FFD500"));
        editBtn.setForeground(color("#FFFFFF"));
        editBtn.setFocusPainted(false);
        boundedAdd(editBtn, 510, 107, 80, 28);

        hapusBtn = new JButton("Hapus");
        hapusBtn.setBackground(color("#FF0000"));
        hapusBtn.setForeground(color("#FFFFFF"));
        hapusBtn.setFocusPainted(false);
        boundedAdd(hapusBtn, 420, 107, 80, 28);

        // Tabel
        barangTable = new JTable();
        TableModel model = createTableModel();
        barangTable.setModel(model);

        // Scroll Table
        scrollPane = new JScrollPane(barangTable);
        boundedAdd(scrollPane, 31, 145, 738, 430);
    }

    @Override
    protected void event() {
        barangTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = barangTable.getSelectedRow();
                String selectedId = barangTable.getValueAt(i, 0).toString();
                selectedField.setText(selectedId);
            }
        });

        refreshBtn.addActionListener((e) -> {
            barangTable.setModel(createTableModel());
        });
    }

    private TableModel createTableModel() {
        DefaultTableModel dataTable = new DefaultTableModel();

        Object[] column = {
                "kode kamar",
                "jenis kamar ",
                "Harga",
              
        };
        dataTable.setColumnIdentifiers(column);

        ArrayList<Kamar> kamarList = _dashboardC.daftarKamar();

        for (Kamar barang : daftarKamar) {
            Object[] data = new String[] {
                    String.valueOf(barang.getKodeKamar()),
                    barang.getJenisKamar(),
                    String.valueOf(barang.getHargaPerMalam()),
                   
                    
            };

            dataTable.addRow(data);
        }
        return dataTable;
    }

}

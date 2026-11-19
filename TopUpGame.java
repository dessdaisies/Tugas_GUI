import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TopUpGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplikasi Top Up Diamond Game");
        BorderLayout layoutUtama = new BorderLayout(5, 5);
        frame.getContentPane().setLayout(layoutUtama);

        JPanel panel1 = new JPanel();
        GridLayout layoutGrid = new GridLayout(5, 2);
        layoutGrid.setHgap(5);
        layoutGrid.setVgap(8);
        panel1.setLayout(layoutGrid);

        JLabel label1 = new JLabel("Pilih Game");
        String[] listGame = {"Mobile Legends", "Free Fire", "PUBG Mobile", "Valorant"};
        JComboBox<String> combo1 = new JComboBox<String>(listGame);

        JLabel label2 = new JLabel("User ID / Server");
        JTextField text1 = new JTextField();

        JLabel label3 = new JLabel("Pilih Nominal");
        String[] listNominal = {
            "50 Diamond - Rp 15000",
            "140 Diamond - Rp 38000",
            "355 Diamond - Rp 95000",
            "720 Diamond - Rp 190000"
        };
        JComboBox<String> combo2 = new JComboBox<String>(listNominal);

        JLabel label4 = new JLabel("Metode Bayar");
        String[] listBayar = {"DANA", "GoPay", "OVO", "QRIS"};
        JComboBox<String> combo3 = new JComboBox<String>(listBayar);

        JLabel label5 = new JLabel("Promo");
        JCheckBox check1 = new JCheckBox("Diskon Member Rp 3.000");

        panel1.add(label1);
        panel1.add(combo1);
        panel1.add(label2);
        panel1.add(text1);
        panel1.add(label3);
        panel1.add(combo2);
        panel1.add(label4);
        panel1.add(combo3);
        panel1.add(label5);
        panel1.add(check1);

        JTextArea area1 = new JTextArea(6, 30);
        area1.setEditable(false);
        JScrollPane scroll1 = new JScrollPane(area1);

        JPanel panel2 = new JPanel();
        FlowLayout layoutFlow = new FlowLayout(FlowLayout.CENTER);
        layoutFlow.setHgap(10);
        layoutFlow.setVgap(10);
        panel2.setLayout(layoutFlow);

        JButton btn1 = new JButton("Top Up Sekarang");
        JButton btn2 = new JButton("Reset");
        panel2.add(btn1);
        panel2.add(btn2);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = text1.getText();
                if (userId.equals("")) {
                    JOptionPane.showMessageDialog(frame, "User ID wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    int harga = 0;
                    int index = combo2.getSelectedIndex();
                    if (index == 0) {
                        harga = 15000;
                    } else if (index == 1) {
                        harga = 38000;
                    } else if (index == 2) {
                        harga = 95000;
                    } else if (index == 3) {
                        harga = 190000;
                    }

                    if (check1.isSelected()) {
                        harga = harga - 3000;
                    }

                    String struk = "=== STRUK TOP UP ===\n"
                            + "Game   : " + combo1.getSelectedItem() + "\n"
                            + "ID     : " + userId + "\n"
                            + "Item   : " + combo2.getSelectedItem() + "\n"
                            + "Bayar  : " + combo3.getSelectedItem() + "\n"
                            + "Total  : Rp " + harga + "\n"
                            + "Status : Berhasil\n\n";

                    area1.append(struk);
                    JOptionPane.showMessageDialog(frame, "Top Up Berhasil!\nTotal Bayar: Rp " + harga, "Informasi", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                combo1.setSelectedIndex(0);
                text1.setText("");
                combo2.setSelectedIndex(0);
                combo3.setSelectedIndex(0);
                check1.setSelected(false);
                area1.setText("");
            }
        });

        frame.getContentPane().add(panel1, BorderLayout.NORTH);
        frame.getContentPane().add(scroll1, BorderLayout.CENTER);
        frame.getContentPane().add(panel2, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setVisible(true);
    }
}
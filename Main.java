import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh Tombol");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Tombol pertama (Button 1)
        JButton button1 = new JButton("Button 1");
        frame.add(button1);

        // Tombol kedua (Button 2)
        JButton button2 = new JButton("Button 2");
        frame.add(button2);
        button2.setVisible(false); // Mengatur visibilitas awal Button 2 menjadi false

        // Menambahkan aksi pada Button 1 untuk menampilkan Button 2
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setVisible(true); // Menampilkan Button 2 saat Button 1 ditekan
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}

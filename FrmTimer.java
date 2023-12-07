import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrmTimer extends JFrame implements ActionListener {
    JFrame tampilan = new JFrame("Aplikasi");
    JLabel lbSelamat = new JLabel("Welcome To Java!!!");
    String tampilkan[] = {"Selamat Belajar", "Pemrograman Java", "Fakultas Teknik", "Universitas Mandiri"};
    Timer timer = new Timer(1000, this);
    int count;

    public FrmTimer() {
        tampilan.setSize(new Dimension(370, 120));
        tampilan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tampilan.setLocationRelativeTo(null);
        tampilan.setVisible(true);

        lbSelamat.setHorizontalAlignment(JLabel.CENTER);
        lbSelamat.setFont(new Font("Serif", Font.BOLD, 22));
        lbSelamat.setBackground(Color.CYAN);
        lbSelamat.setForeground(new Color(0, 0, 0));
        lbSelamat.setOpaque(true);
        lbSelamat.setPreferredSize(new Dimension(100, 80));

        tampilan.add(lbSelamat, BorderLayout.NORTH);
        timer.start();
    }

    public static void main(String[] args) {
        FrmTimer frm = new FrmTimer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lbSelamat.setText(tampilkan[count % 4]);
        count = (count + 1) % 4;
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tombol extends JFrame implements ActionListener{
    JFrame tampilan = new JFrame("Aplikasi");
    JLabel lbSelamat = new JLabel();
    JButton btnHitung, btnStart, btnStop, btnReset;
    int jumlah = 0;
    Timer timer;
    boolean isRunning = false;

    public tombol(){
        tampilan.setSize(new Dimension(250, 300));
        tampilan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tampilan.setLocationRelativeTo(null);
        tampilan.setLayout(null);
        tampilan.setVisible(true);

        lbSelamat.setHorizontalAlignment(JLabel.CENTER);
        lbSelamat.setFont(new Font("Serif", Font.BOLD, 70));
        lbSelamat.setBackground(Color.CYAN);
        lbSelamat.setForeground(Color.RED);
        lbSelamat.setBounds(40, 20, 150, 100);

        btnHitung = new JButton("add");
        btnHitung.setBounds(40, 150, 150, 20);
        btnHitung.addActionListener(this);

        // Start button
        btnStart = new JButton("Start");
        btnStart.setBounds(40, 180, 70, 20);
        btnStart.addActionListener(e -> startTimer());

        // Stop button
        btnStop = new JButton("Stop");
        btnStop.setBounds(120, 180, 70, 20);
        btnStop.addActionListener(e -> stopTimer());

        // Reset button
        btnReset = new JButton("Reset");
        btnReset.setBounds(40, 210, 150, 20);
        btnReset.addActionListener(e -> reset());

        tampilan.add(btnHitung);
        tampilan.add(btnStart);
        tampilan.add(btnStop);
        tampilan.add(btnReset);
        tampilan.add(lbSelamat);
    }

    public static void main(String []args){
        tombol frm = new tombol();
    }
    public void actionPerformed(ActionEvent e){
        jumlah++;
        lbSelamat.setText(String.valueOf(jumlah));
    }

    public void startTimer() {
        if (!isRunning) {
            timer = new Timer(1000, e -> {
                jumlah++;
                lbSelamat.setText(String.valueOf(jumlah));
            });
            timer.start();
            isRunning = true;
        }
    }

    public void stopTimer() {
        if (isRunning && timer != null) {
            timer.stop();
            isRunning = false;
        }
    }
    
    public void reset() {
        jumlah = 0;
        lbSelamat.setText(String.valueOf(jumlah));
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lampu extends JFrame implements ActionListener{
    JButton jbLight1 = new JButton();
    JButton jbLight2 = new JButton();
    JButton jbLight3 = new JButton();
    JButton jbLight4 = new JButton();
    JButton jbLight5 = new JButton();

    JButton jbRight = new JButton(" > ");
    JButton jbLeft = new JButton(" < ");
    JButton jbStart = new JButton(" Start ");
    JButton jbStop = new JButton(" Stop ");

    int jbNo=1;
    Timer timer;

    public Lampu(){
        setLayout(null);
        setComponents();
        setTitle("Lampu Kelap Kelip");
        setSize(330,160);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void setComponents(){
        jbLight1.setBounds(10,20,50,20);
        jbLight2.setBounds(70,20,50,20);
        jbLight3.setBounds(130,20,50,20);
        jbLight4.setBounds(190,20,50,20);
        jbLight5.setBounds(250,20,50,20);

        jbLight1.setBackground(Color.RED);
        jbLight2.setBackground(Color.BLACK);
        jbLight3.setBackground(Color.BLACK);
        jbLight4.setBackground(Color.BLACK);
        jbLight5.setBackground(Color.BLACK);

        jbLeft.setBounds(100, 60, 50, 20);
        jbRight.setBounds(160, 60, 50, 20);
        jbStart.setBounds(10, 60, 80, 30);
        jbStop.setBounds(220, 60, 80, 30);

        add(jbLight1);
        add(jbLight2);
        add(jbLight3);
        add(jbLight4);
        add(jbLight5);

        add(jbRight);
        add(jbLeft);
        add(jbStart);
        add(jbStop);;

        jbRight.addActionListener(this);
        jbLeft.addActionListener(this);
        jbStart.addActionListener(this);
        jbStop.addActionListener(this);
    }

    public void setButtonLight(){
        jbLight1.setBackground(Color.BLACK);
        jbLight2.setBackground(Color.BLACK);
        jbLight3.setBackground(Color.BLACK);
        jbLight4.setBackground(Color.BLACK);
        jbLight5.setBackground(Color.BLACK);
    switch (jbNo) {
            case 1 :
                jbLight1.setBackground(Color.red);break;
            case 2 :
                jbLight2.setBackground(Color.red);break;
            case 3 :
                jbLight3.setBackground(Color.red);break;
            case 4 :
                jbLight4.setBackground(Color.red);break;
            case 5 :
                jbLight5.setBackground(Color.red);break;
        }
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jbRight){
            if(jbNo<5)
                jbNo++;
            else
                jbNo = 1;
        }
        if(ae.getSource()==jbLeft){
            if(jbNo>1)
                jbNo--;
            else
                jbNo = 5;
        }

        if (ae.getSource() == jbStart) {
            // Start the timer to cycle through lights every second
            timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbNo = (jbNo % 5) + 1;
                    setButtonLight();
                }
            });
            timer.start();
        }

        if (ae.getSource() == jbStop) {
            // Stop the timer
            if (timer != null && timer.isRunning()) {
                timer.stop();
            }
        }

        setButtonLight();
    }

    public static void main(String []args){
        Lampu lampu = new Lampu();
    }
}
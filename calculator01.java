package 계산기_만들기;

import javax.swing.*;
import java.awt.*;

public class calculator01 extends JFrame {
    JTextField cal_text;
    String button_names[] = {"C","✏","%","÷",
            "7","8","9","×",
            "4","5","6","－",
            "1","2","3","＋",
            "+/-","0",".","="};
    public calculator01() {
        setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(335, 538);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        showNorth();
        showCenter();

        setVisible(true);
    }
    void showNorth() {
        cal_text = new JTextField();

        add(cal_text, BorderLayout.NORTH);
    }
    void showCenter() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,4,2,2));
        JButton buttons[] = new JButton[button_names.length];

        for(int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(button_names[i]);
            panel.add(buttons[i]);
        }
        this.add(panel, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        new calculator01();
    }
}

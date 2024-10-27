package 계산기_만들기;

import javax.swing.*;
import java.awt.*;

public class calculator01 extends JFrame {
    JTextField cal_text;
    JPanel panel;
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
        c.setBackground(Color.YELLOW);
        c.setLayout(new BorderLayout(5, 5));

        showNorth();
        showCenter();
        showEast();
        showWest();
        showSouth();

        setVisible(true);
    }
    void showNorth() {
        panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        cal_text = new JTextField("0");
        cal_text.setHorizontalAlignment(JTextField.RIGHT);

        Font font = new Font("아무거나", Font.BOLD, 30); // 글자 크기 설정
        cal_text.setFont(font);

        cal_text.setPreferredSize(new Dimension(300, 80)); // 크기 고정 설정
        panel.add(cal_text);

        add(panel, BorderLayout.NORTH);

    }
    void showCenter() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(5,4,10,10));
        panel.setBackground(Color.YELLOW);
        JButton buttons[] = new JButton[button_names.length];

        for(int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(button_names[i]);
            panel.add(buttons[i]);
        }
        this.add(panel, BorderLayout.CENTER);
    }

    void showEast() {
        panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        add(panel, BorderLayout.EAST);
    }

    void showWest() {                                           // 이하는 배경 양옆 색깔 지정 및 버튼 띄우기
        panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        add(panel, BorderLayout.WEST);
    }

    void showSouth() {
        panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        add(panel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new calculator01();
    }
}

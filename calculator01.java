package 계산기_만들기;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        cal_text.setEditable(false);

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
            buttons[i].addActionListener(new ButtonListener());
        }
        this.add(panel, BorderLayout.CENTER);
    }

    void showEast() {
        panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        add(panel, BorderLayout.EAST);
    }

    class ButtonListener implements ActionListener {            // 버튼 누르면 글자 출력
        public void actionPerformed(ActionEvent e) {
            String text = e.getActionCommand();
            if(text.equals("C")) {
                cal_text.setText("");
            }
            else if(text.equals("✏")) {
                int t = cal_text.getText().length();
                if(t == 0 || cal_text.getText().equals("0")) { // cal_text가 0이거나 없으면 0 으로 씀
                    cal_text.setText("0");
                }
                else {
                    String back = cal_text.getText().substring(0, t-1); //backspace 구현

                    cal_text.setText(back);
                }
            }
            else if(text.equals("=")) {

            }
            else if(text.equals("+/-")) {

            }
            else  {
                cal_text.setText(cal_text.getText() + e.getActionCommand());
            }
        }
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
        new calculator04();
    }
}

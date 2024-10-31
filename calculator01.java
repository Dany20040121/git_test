package 계산기_만들기;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class calculator01 extends JFrame {
    JTextField cal_text;

    JPanel panel;

    String button_names[] = {"C","✏","%","÷",
            "7","8","9","×",
            "4","5","6","-",
            "1","2","3","+",
            "+/-","0",".","="};

    ArrayList<String> calequre = new ArrayList<String>();

    String num = "";

    String prev_operation = "";

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

        Font font = new Font("Arial", Font.BOLD, 30); // 글자 크기 설정
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
                String result = Double.toString(calculate(cal_text.getText()));
                cal_text.setText("" + result);
                num = "";
            }
            else if(text.equals("+/-")) {
                String temp = cal_text.getText();
                if (temp.equals("0.")) {
                    return;
                }
                else {
                    if (temp.charAt(0) != '-') {
                        cal_text.setText('-' + temp);
                    }
                    else {
                        cal_text.setText(temp.substring(1));
                    }
                }
            }
            else if(text.equals("+") || text.equals("-") || text.equals("×") || text.equals("÷")) {
                if (cal_text.getText().equals("") && text.equals("-")) {
                    cal_text.setText(cal_text.getText() + e.getActionCommand());

                } else if (!cal_text.getText().equals("") && !prev_operation.equals("+") && !prev_operation.equals("-") && !prev_operation.equals("×") && !prev_operation.equals("÷")) {
                    cal_text.setText(cal_text.getText() + e.getActionCommand());
                }
            }
            else  {
                if(cal_text.getText().equals("0")) {
                    cal_text.setText(text);
                }
                else {
                    cal_text.setText(cal_text.getText() + text);
                }

            }
            prev_operation = e.getActionCommand(); //마지막으로 누른 버튼 기억
        }
    }

    void fullTextParseing(String inputText) {       // inputText에서 수식을 숫자와 연산 기호로 나누어 calequare 리스트에 순서대로 정리 즉 문자열과 수식 분리
        calequre.clear();       // 저장된 내용 있다면 삭제

        for (int i = 0; i < inputText.length(); i++) {  // 계산식 글자를 하나하나 거처감
            char ch = inputText.charAt(i);

            if (ch == '-' || ch == '+'|| ch == '×' || ch == '÷'){
                calequre.add(num);
                num = ""; // num 초기화
                calequre.add(ch + ""); // 연산기호를 ArrayList에 추가
            }
            else {
                num = num + ch;
            }
        }
        calequre.add(num); //반복문 끝나고 남아있는 숫자값 추가
    }

    public double calculate(String inputText) {
        fullTextParseing(inputText);

        double prev = 0;            // 계산 결과 저장, 초기값 = 0
        double current = 0;         // 현재 계산 중인 숫자를 저장
        String mode = "";           // 현제 연산 모드를 저장해 덧, 뺄, 곱, 나눗셈 구분

        for (String s : calequre) {
            if (s.equals("+")) {
                mode = "add";
            }
            else if (s.equals("-")) {
                mode = "min";
            }
            else if (s.equals("×")) {
                mode = "mul";
            }
            else if (s.equals("÷")) {
                mode = "div";
            }
            else {
                current = Double.parseDouble(s);

                if (mode.equals("add")) {               // s가 숫자일 경우 문자열을 Double로 변환해 current에 저장, mode 값에 따라 연산 수행
                    prev = current + prev;
                }
                else if (mode.equals("min")) {
                    prev = current - prev;
                }
                else if (mode.equals("mul")) {
                    prev = current * prev;
                }
                else if (mode.equals("div")) {
                    prev = current / prev;
                }
                else {
                    prev = current;         // 초기값 prev가 0 일때 처음 값을 그대로 prev에 할당
                }
            }
        }
        return prev;

    }

    void showWest() {                                           // 이하는 배경 양옆 색깔 지정 및 버튼 띄우기
        panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        add(panel, BorderLayout.WEST);
    }
    
    void showEast() {
        panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        add(panel, BorderLayout.EAST);
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

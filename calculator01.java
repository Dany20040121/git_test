package 계산기_만들기;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * 기본적인 사칙연산을 포함한 GUI 계산기 애플리케이션.
 * 이 클래스는 더하기, 빼기, 곱하기, 나누기와 같은 기본적인 수학 연산을 수행하며,
 * 백스페이스, 화면 지우기, 퍼센트 계산 등의 기능을 제공합니다.
 *
 * 버튼을 통한 입력을 지원하며, 계산 결과는 상단의 JTextField에 표시됩니다.
 */

public class calculator01 extends JFrame {
    /**
     * 현재 계산 텍스트와 결과를 표시하는 JTextField입니다.
     */
    JTextField cal_text;

    JPanel panel;
    /**
     * 계산기의 기능을 위한 버튼 라벨 배열입니다.
     */
    String button_names[] = {"C","←","%","÷",
            "7","8","9","×",
            "4","5","6","-",
            "1","2","3","+",
            "+/-","0",".","="};

    /**
     * 계산 식의 각 요소(숫자와 연산 기호)를 저장하는 리스트입니다.
     */
    ArrayList<String> calequre = new ArrayList<String>();

    /**
     * 숫자를 임시로 저장하는 문자열입니다.
     */
    String num = "";

    /**
     * 마지막으로 사용자가 누른 연산을 저장하는 문자열입니다.
     */
    String prev_operation = "";

    public calculator01() {
        setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(335, 538);
        Container c = getContentPane();
        c.setBackground(new Color(0xF3F3F3));
        c.setLayout(new BorderLayout(5, 5));

        showNorth();
        showCenter();
        showEast();
        showWest();
        showSouth();

        setVisible(true);
    }
    /**
     * 계산기 상단에 JTextField를 표시하는 메서드로
     * 텍스트 필드의 글자 크기와 배경색, 정렬 등을 설정합니다.
     */
    void showNorth() {
        panel = new JPanel();
        panel.setBackground(new Color(0xF3F3F3));
        cal_text = new JTextField("0"){

            public void setBorder(Border border) { // JTextField 태두리 없애기

            }
        };
        cal_text.setHorizontalAlignment(JTextField.RIGHT);
        cal_text.setBackground(new Color(0xF3F3F3));

        Font font = new Font("Arial", Font.ITALIC, 40); // 글자 크기 설정

        cal_text.setFont(font);
        cal_text.setEditable(false);

        cal_text.setPreferredSize(new Dimension(300, 80)); // 크기 고정 설정
        panel.add(cal_text);

        add(panel, BorderLayout.NORTH);

    }
    /**
     * 계산기의 중앙에 배치될 숫자와 연산 버튼을 표시하는 메서드입니다.
     * 그리드 레이아웃을 사용하여 버튼을 배치하고, 각 버튼에 기능을 추가합니다.
     */
    void showCenter() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(5,4,3,3));
        panel.setBackground(new Color(0xF3F3F3));
        Font font = new Font("Arial", Font.BOLD, 15);
        JButton buttons[] = new JButton[button_names.length];

        for(int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(button_names[i]);
            panel.add(buttons[i]);
            buttons[i].addActionListener(new ButtonListener());
            buttons[i].setFont(font);
            buttons[i].setBorder(new LineBorder(new Color(0xE1E1E1), 3, true));
            if(0 <= i && i <= 3) {
                buttons[i].setBackground(new Color(0xF9F9F9));
            }
            else if(i == 7 || i == 11 || i == 15){
                buttons[i].setBackground(new Color(0xF9F9F9));
            } else if (i == 19) {
                buttons[i].setBackground(new Color(0xB10247));
                buttons[i].setForeground(new Color(0xF3F3F3));
            }
            else{
                buttons[i].setBackground(new Color(0xFFFFFF));
            }
        }
        this.add(panel, BorderLayout.CENTER);
    }

    /**
     * 계산기 버튼의 액션을 처리하는 내부 클래스입니다.
     * 버튼 클릭 시 조작하고 JTextField에 반영하는 기능을 수행합니다.
     */
    class ButtonListener implements ActionListener {            // 버튼 누르면 글자 출력
        public void actionPerformed(ActionEvent e) {
            String text = e.getActionCommand();

            if(text.equals("C")) {      // 전부 지우기
                cal_text.setText("");
            }
            else if(text.equals("←")) {     //지우기
                int t = cal_text.getText().length();
                if(t == 0 || cal_text.getText().equals("0")) { // cal_text가 0이거나 없으면 0 으로 씀
                    cal_text.setText("0");
                }
                else {
                    String back = cal_text.getText().substring(0, t-1); //backspace 구현

                    cal_text.setText(back);
                }
            }
            else if(text.equals("=")) {     // 계산
                String result = Double.toString(calculate(cal_text.getText()));
                cal_text.setText("" + result);
                num = "";
            }

            else if(text.equals("+/-")) {       //양수, 음수
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
            else if (text.equals("%")) { // % 버튼 기능
                String temp = cal_text.getText();
                if (!temp.isEmpty()) {
                    double percentage = Double.parseDouble(temp) / 100;
                    cal_text.setText(String.valueOf(percentage));
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

    /**
     * 입력된 계산 식을 숫자와 연산 기호로 분리하여
     * `calequre` 리스트에 순서대로 정리하는 메서드입니다.
     *
     * @param inputText 계산식 문자열
     */
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
        calequre.remove(""); // 처음에 -가 있음 에러발생, ""을 제거
        calequre.add(0, "0");
        calequre.add(1, "+");
    }

    /**
     * 주어진 계산식 문자열을 계산하여 결과를 반환하는 메서드입니다.
     * 곱셈과 나눗셈을 우선 처리한 후 덧셈과 뺄셈을 수행합니다.
     *
     * @param inputText 계산식 문자열
     * @return 계산 결과
     */
    public double calculate(String inputText) {             // 계산 기능
        fullTextParseing(inputText);

        double prev = 0;            // 계산 결과 저장, 초기값 = 0
        double current = 0;         // 현재 계산 중인 숫자를 저장
        String mode = "";           // 현제 연산 모드를 저장해 덧, 뺄, 곱, 나눗셈 구분

        for (int i = 0; i < calequre.size(); i++) { // 연산자 우선순위 적용
            String s = calequre.get(i);

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
                if ((mode.equals("mul") || mode.equals("div")) && !s.equals("+") && !s.equals("-") && !s.equals("×") && !s.equals("÷")) {
                    Double one = Double.parseDouble(calequre.get(i - 2));
                    Double two = Double.parseDouble(calequre.get(i));
                    Double result = 0.0;

                    if (mode.equals("mul")) {
                        result = one * two;
                    }
                    else if (mode.equals("div")) {
                        result = one / two;
                    }
                    calequre.add(i + 1, Double.toString(result));

                    for(int j = 0; j < 3; j++){
                        calequre.remove(i - 2);
                    }

                    i -= 2;
                }
            }
        }   // 곱셈, 나눗셈 먼저 계산

        for(String s : calequre) {
            if (s.equals("+")) {
                mode = "add";
            }
            else if (s.equals("-")) {
                mode = "min";
            }

            else {
                current = Double.parseDouble(s);

                if (mode.equals("add")) {
                    prev += current;
                }
                else if (mode.equals("min")) {
                    prev -= current;
                }
                else {
                    prev = current;
                }
            }
            prev = Math.round(prev * 100000) / 100000.0; // 소수 여섯번째 자리에서 반올림
        }
        return prev;        // 값 반환

    }

    /**
     * 이하는 배경 양옆 색깔 지정 및 버튼 띄우기
     */
    void showWest() {
        panel = new JPanel();
        panel.setBackground(new Color(0xF3F3F3));
        add(panel, BorderLayout.WEST);
    }

    void showEast() {
        panel = new JPanel();
        panel.setBackground(new Color(0xF3F3F3));
        add(panel, BorderLayout.EAST);
    }

    void showSouth() {
        panel = new JPanel();
        panel.setBackground(new Color(0xF3F3F3));
        add(panel, BorderLayout.SOUTH);
    }

    /**
     * 인용코드
     *
     * @see <a herf="https://shgdx.tistory.com/3">JPanel 사용하는 아이디어 제공</a>
     * @see <a herf="https://beautifulkim.tistory.com/309">"setPreferredSize" 알려줌</a>
     * @see <a herf="https://code-review.tistory.com/entry/%ED%81%B4%EB%A1%A0%EC%BD%94%EB%94%A9-%EC%9E%90%EB%B0%94%EB%A1%9C-%EA%B3%84%EC%82%B0%EA%B8%B0-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0">자바 계산기 코딩 짜기에 전반적인 기초를 알려줌</a>
     * @see <a herf="https://limunosekai.github.io/java/2021/01/04/java-day-20/">배경 정하는거 도와줌</a>
     * @see <a herf="https://m.blog.naver.com/10hsb04/221607286384">글자 크기 설정 도와줌</a>
     * @see <a herf="https://itdeveloper.tistory.com/25">backspace 알려줌</a>
     * @see <a herf="https://chatgpt.com/g/g-FvT4UOsoA-caesgpt/c/6723b1cf-fea0-800a-b0b8-c30c201f03a6">코드 해석 및 보완</a>
     *
     */
    public static void main(String[] args) {
        new calculator01();
    }
}

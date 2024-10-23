package 예제_테스트라능;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class easyCal extends JFrame {
    JTextField cal01, cal02;
    JButton equal;
    JTextArea area;
    JComboBox plusminus;

    public easyCal() {
        setTitle("초보 계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 200);
        setLayout(new FlowLayout());

        cal01 = new JTextField(10); // 첫 번째 값

        String[] plma = {"＋", "－"};
        plusminus = new JComboBox<>(plma); // 콤보박스

        cal02 = new JTextField(10); //두 번째 값

        equal = new JButton("="); // 버튼

        area = new JTextArea();
        area.setSize(20, 20);// 결과창
        area.setText("여기에 답이 나오네요^^");
        area.setEditable(false);

        ActionListener finalLevel = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == equal) {
                    if(cal01.getText().isEmpty() || cal02.getText().isEmpty()) {
                        area.setText("값을 않적었자나!!");
                    }
                    else {
                        String s1 = cal01.getText();
                        String s2 = cal02.getText();
                        double scala01 = Double.parseDouble(s1);
                        double scala02 = Double.parseDouble(s2);
                        if(plusminus.getSelectedIndex() == 0){
                            double result = scala01 + scala02;
                            area.setText("" + result);
                        }
                        else  {
                            double result = scala01 - scala02;
                            area.setText("" + result);
                        }
                    }
                }
            }
        };


        equal.addActionListener(finalLevel);
        add(cal01);
        add(plusminus);
        add(cal02);
        add(equal);
        add(area);

        setVisible(true);
    }
    public static void main(String[] args) {
        new easyCal();
    }
}

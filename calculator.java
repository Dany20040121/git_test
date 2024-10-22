import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculator extends JFrame{
	
	JTextField text;
	
	calculator() {
		setTitle("계산기");
		setSize(520, 250);
		
		showNorth();  // TextField 부분
		showCenter(); // button 부분
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	void showNorth() {
		
		text = new JTextField();
		text.setText("0");
		text.setForeground(Color.GRAY); 		// 글자 색을 회색으로
		text.setEditable(false);				// 사용 불가능
		this.add(text, BorderLayout.NORTH);
	}
	void showCenter() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 5, 3, 3));
		
		String button_names[] = {"Backspace", "", "", "CE", "C", "7", "8", "9", "/", "sqrt", "4", "5", "6", "×", "%", "1", "2", "3", "－", "1/x", "0", "＋/－", ".", "＋", "="};
		JButton buttons[] = new JButton[button_names.length];  // button을 만든 배열 수만큼 생성
		
		for (int i = 0; i < button_names.length; i++) {
			buttons[i] = new JButton(button_names[i]); // 배열 수만큼 버튼 추가
			buttons[i].setBackground(Color.YELLOW);
			if((i >= 0 && 2 >= i) || (i >= 5 && 7 >= i) || (i >= 10 && 12 >= i) || (i >= 15 && 17 >= i) || (i >= 20 && 22 >= i)) {
				buttons[i].setForeground(Color.BLUE); // 지정한 구역 버튼의 글자 색은 파란색으로
			}
			else {
				buttons[i].setForeground(Color.red);  // 나머지 구역 글자 색깔은 빨간색으로
			}
			panel.add(buttons[i]);					  // 버튼을 패널에 추가
		}
		this.add(panel, BorderLayout.CENTER); // 패널을 BorderLayout의 CENTER에 추가
	}

	public static void main(String[] args) {
		calculator cal = new calculator();
	}

}

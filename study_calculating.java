import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class study_calculating extends JFrame {
	public study_calculating() {
		setTitle("계산기");
		
		setLayout(new BorderLayout());
		showNorth();
		showCenter();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 300);
		setVisible(true);
	}
	
	void showNorth() { // 북 텍스트 박스 성공
		JPanel panel = new JPanel();
		
		JTextField t1 = new JTextField(20);
		t1.setEnabled(false);
		
		panel.add(t1);
		
		add(panel, BorderLayout.NORTH);
	}
	
	void showCenter() { //센터 버튼 성공
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		
		JPanel panel = new JPanel();
		
		JButton on = new JButton("on"); // 패널 온 오프
		JButton off = new JButton("off");
		p1.add(on);
		p1.add(off);
		
		JButton seven = new JButton("7"); // 패널 789+
		JButton eight = new JButton("8");
		JButton nine = new JButton("9");
		JButton plus = new JButton("+");
		p2.add(seven);
		p2.add(eight);
		p2.add(nine);
		p2.add(plus);
		
		JButton four = new JButton("4"); // 패널 456-
		JButton five = new JButton("5");
		JButton six = new JButton("6");
		JButton miner = new JButton("-");
		p3.add(four);
		p3.add(five);
		p3.add(six);
		p3.add(miner);
		
		JButton one = new JButton("1"); // 패널 123x
		JButton two = new JButton("2");
		JButton three = new JButton("3");
		JButton Times = new JButton("X");
		p4.add(one);
		p4.add(two);
		p4.add(three);
		p4.add(Times);
		
		JButton zero = new JButton("0"); // 패널0.=÷
		JButton point = new JButton(".");
		JButton equal = new JButton("=");
		JButton Obelus = new JButton("÷");
		p5.add(zero);
		p5.add(point);
		p5.add(equal);
		p5.add(Obelus);
		
		panel.add(p1);
		panel.add(p2);
		panel.add(p3);
		panel.add(p4);
		panel.add(p5);
		add(panel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new study_calculating();
	}

}

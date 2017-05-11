package battlePic;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class battlePic {
	public battlePic(){
		JFrame frameS = new JFrame();
		JFrame frame1 = new JFrame();
		Container contentPaneS = frameS.getContentPane();
		Container contentPane1 = frame1.getContentPane();
		
		JButton btn1 = new JButton("line");
		JButton btn2 = new JButton("circle");
		JButton btn3 = new JButton("triangle");
		contentPane1.setLayout(new BorderLayout());
		contentPane1.add(btn1,BorderLayout.NORTH);
		contentPane1.add(btn2, BorderLayout.CENTER);
		contentPane1.add(btn3, BorderLayout.SOUTH);
		frame1.pack();
		frame1.show();
		frame1.setTitle("frame1");
		
		JPanel panel = new JPanel();
			
		contentPaneS.setLayout(new BorderLayout());
		contentPaneS.add(frame1, BorderLayout.EAST);
		contentPaneS.add(panel,BorderLayout.CENTER);
		frameS.pack();
		frameS.show();
		frameS.setTitle("frameS");
		
		
	}
	
	public static void main(String[] args) {
//		Frame frame = new Frame();
//		
//		JButton LnBtn = new JButton("Line");

		battlePic a = new battlePic();
	}

}

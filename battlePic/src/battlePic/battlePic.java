package battlePic;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class battlePic implements ActionListener{
//让frame自己去addMouseListener,而不是利用actionPerformed.降低耦合
	//似乎必须把frame传给startMouse???
	int[] a = new int[6];
	protected JFrame frame;
	public battlePic(JFrame frame){
		this.frame=frame;
	//	btn0.addActionListener(gg);
	//	btn2.addActionListener(gg);
	//	btn3.addActionListener(gg);
	//	btn4.addActionListener(gg);
	//	btn5.addActionListener(gg);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(a[1]== 1){
			a[1]=0;
//			frame.removeMouseListener(l);
		}
		else{
			a[1]++;
		}
		for( int j=0;j<a.length;j++){
			if(j==1){
				j++;
			}
			a[j]=0;
		}
		
//		a[1]++;
		if(a[1]==1){
			StartMouse okmouse = new StartMouse(frame , "Line");
			frame.addMouseListener(okmouse);
			frame.addMouseMotionListener(okmouse);	
		}	
//		else{
//			a[1]
//		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Container contentPane = frame.getContentPane();
		JPanel paintPic = new JPanel(new GridLayout(6,1));
		 JButton btn0 = new JButton("thick");
		 JButton btn1 = new JButton("line");
		 JButton btn2 = new JButton("circle");
		 JButton btn3 = new JButton("triangle");
		 JButton btn4 = new JButton("rectangle");
		 JButton btn5 = new JButton("eraser");
		 
		 paintPic.add(btn0);
		 paintPic.add(btn1);
		 paintPic.add(btn2);
		 paintPic.add(btn3);
		 paintPic.add(btn4);
		 paintPic.add(btn5);
		 paintPic.setPreferredSize( new Dimension(100,400));
		 
		 contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			contentPane.add(paintPic);
			frame.setSize( new Dimension(700,600));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setTitle("frameS");
			frame.setVisible(true);
			
		 
		battlePic btP =new battlePic(frame);
		btn1.addActionListener( btP );
		
		
		
	
	}


	


	
}

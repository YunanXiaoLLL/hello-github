package battlePic;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class battlePic {
	//截至目前，我已经可以产生一条直线，并且移动它了。
	
	//现在我想实现数据与表现分离，数据是鼠标坐标，表现是M继承JPanel
	//让View得到mouselistener的数据去paint,update等等，View只管接收数据去画，mouse只管提供数据，可以做？
	//为了得到鼠标数据,在Main函数中去new一个鼠标对象出来，让它去getX,Y??或者在View中new一个鼠标对象？
	//修改StartMouse?让它有一个Shape数组，存储画出来的对象。让Shape类有一个isSelected方法知道被选中？
	//extends JPanel干嘛？
	//每画完一次都要重新按按钮？以便于对画出来的对象进行选中操作？
	//用到ereaser时相当于给对象颜色变成背景色，就看不到了嘛。
//	int[] a = new int[6];
//	public battlePic(M m){
//		
//	
//	}

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		M panel = new M();
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(panel);
		frame.setSize( new Dimension(700,600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("frameS");
		frame.setVisible(true);
		
	
	}


	


	
}

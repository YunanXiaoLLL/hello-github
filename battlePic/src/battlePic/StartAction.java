package battlePic;
import java.awt.event.*;
public class StartAction implements ActionListener{
	//能不能不要传这个m过来?
	private M m;
	public StartAction(M m){
		this.m=m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
//		m.controlShape(0);			//每次按按钮都要开始画图，所以切换到画图状态，而不是移动图像状态。
		
		if(e.getSource()==m.btn0){
			
		}
		else if(e.getSource() == m.btn1){		
			m.addmouse();
			m.changeType("Line");
		}
		else if(e.getSource() == m.btn2){
			m.changeType("Circle");
		}
		else if(e.getSource() == m.btn3){
			m.changeType("Triangle");
		}
		else if(e.getSource() == m.btn4){
			m.changeType("Eraser");
		}
		else if(e.getSource() == m.btn5){
			
		}
	
	}
	

}

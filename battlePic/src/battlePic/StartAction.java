package battlePic;
import java.awt.event.*;
public class StartAction implements ActionListener{
	//�ܲ��ܲ�Ҫ�����m����?
	private M m;
	public StartAction(M m){
		this.m=m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
//		m.controlShape(0);			//ÿ�ΰ���ť��Ҫ��ʼ��ͼ�������л�����ͼ״̬���������ƶ�ͼ��״̬��
		
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

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
		m.removeKey();
		m.controlShape(0);			//ÿ�ΰ���ť��Ҫ��ʼ��ͼ�������л�����ͼ״̬���������ƶ�ͼ��״̬��
		m.addmouse();
		if(e.getSource()==m.btn0){
			
		}
		else if(e.getSource() == m.btn1){		
			m.changeType("Line");
		}
		else if(e.getSource() == m.btn2){
			m.changeType("Circle");
		}
		else if(e.getSource() == m.btn3){
			m.changeType("Rectangle");
		}
		else if(e.getSource() == m.btn5){
			m.changeType("Eraser");
		}
	
		
	}
	

}

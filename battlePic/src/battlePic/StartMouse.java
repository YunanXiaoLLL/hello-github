package battlePic;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import Shape.Shape;
import Shape.*;

public class StartMouse implements MouseListener,MouseMotionListener{
	int startx,starty,endx,endy;
	private M m;

	//�ǲ�����startmouseֻ�ṩ�����������������ܣ�
	//��갴��press�󣬵���һ��m�ĺ���(������������x,y)����m����list����ÿһ��shape��������ж��Ƿ�selected��
	//����ǣ����ǽ�����m�еõ������������ã�ͬʱshape��isSelected���Զ��������Ĳ���ֵ��m��
	//��ʱӦ����m����һ�ָı�ͼ��λ�õ�״̬��
	//���Ż���m����������м�������
	//��꿪ʼdrag
	//���release֮��õ�endx,endy��Ȼ�����m��repaint��
	
	
	//������ǣ�����drag,release������״̬����ͼ�����Ծʹ�������һ�����󣬲���������shape
	
	public StartMouse(M m ){
		this.m=m;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		endx=e.getX();
		endy=e.getY();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		startx=starty=endx=endy=0;				//���մ�ʩ��ÿһ��Press��Ӧ�����µĿ�ʼ��
		startx=e.getX();
		starty=e.getY();
		m.ItisClicked(startx,starty); 
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		endx=e.getX();
		endy=e.getY();
		m.repaint();  	
	}
	
	public int[] getPRXY(){
		int[] a = {startx,starty,endx,endy};
		return a;
	}
	
	
	@Override
	public void mouseMoved(MouseEvent e) {	}
	@Override
	public void mouseEntered(MouseEvent e) {	}
	@Override
	public void mouseExited(MouseEvent e) { 	}
	@Override
	public void mouseClicked(MouseEvent e) {	}
}

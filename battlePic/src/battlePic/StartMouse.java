package battlePic;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import Shape.Shape;
import Shape.*;

public class StartMouse implements MouseListener,MouseMotionListener{
	int clickx,clicky;
	int startx,starty,endx,endy;
	int[] lastdrag = new int[2];
	private M m;
	
	int reserveSum;
	public StartMouse(M m ){
		this.m=m;
	}
	
	//�������Ҫ��Ҫ��M�Լ���ʵ�֣�
//	public void createShape(Graphics g){
//		if(type.equals("Line")){
//			Line line = new Line(startx,starty,endx,endy);
//			line.draw(g);
//		}
//	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		endx=e.getX();
		endy=e.getY();
		m.repaint();
		m.removeSh(reserveSum);
		lastdrag[0]=endx;                       //������ε�����������һ�����Ƚϡ����㡣
		lastdrag[1]=endy;
		//eraser������������������������İ�
	//	System.out.println("drag it!");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("in click");
//		m.changeRealShape(0);
		clickx=e.getX();
		clicky=e.getY();

		if( m.ItisClicked(clickx,clicky) ){
//			m.controlShape(1);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		startx=starty=endx=endy=0;	//���մ�ʩ��ÿһ��Press��Ӧ�����µĿ�ʼ��
		startx=e.getX();
		starty=e.getY();

//		System.out.println("Press!");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		m.changeRealShape(1);
		reserveSum++;     //ÿһ�ε�release��Ӧ����һ����ɺõ�ͼ�Σ���Ӧ��ɾ�������꿴mousedrag��M��removeSh.
		endx=e.getX();
		endy=e.getY();
		m.repaint();   //�ƺ���û��ֱ��ȥ����������������Ǽ�ס����£�ֱ�Ӽ�����������ĳ����������click����ô��Ҫpress����release,��ʱ��ס��repaint,����Ҫ����click��������click����repaint
		
//		System.out.println("Released!");
		
	}
	
	public int[] getPRXY(){
		int[] a = {startx,starty,lastdrag[0],lastdrag[1],endx,endy};
		return a;
	}
	
	
	@Override
	public void mouseMoved(MouseEvent e) {	}
	@Override
	public void mouseEntered(MouseEvent e) {	}
	@Override
	public void mouseExited(MouseEvent e) { 	}
}

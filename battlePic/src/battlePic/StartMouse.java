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
	
	//这个函数要不要由M自己来实现？
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
		lastdrag[0]=endx;                       //保存这次的数据用于下一次作比较、计算。
		lastdrag[1]=endy;
		//eraser可以用这个，其它就用其它的把
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
		startx=starty=endx=endy=0;	//保险措施。每一次Press都应该是新的开始。
		startx=e.getX();
		starty=e.getY();

//		System.out.println("Press!");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		m.changeRealShape(1);
		reserveSum++;     //每一次的release都应该是一次完成好的图形，不应该删除掉。详看mousedrag和M的removeSh.
		endx=e.getX();
		endy=e.getY();
		m.repaint();   //似乎并没有直接去调用这个函数，而是记住这件事，直接继续进行下面的程序。如果用了click，那么先要press，再release,这时记住了repaint,但又要继续click，所以先click后再repaint
		
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

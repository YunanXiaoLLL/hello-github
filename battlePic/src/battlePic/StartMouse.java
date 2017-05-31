package battlePic;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import Shape.Shape;
import Shape.*;

public class StartMouse implements MouseListener,MouseMotionListener{
	int startx,starty,endx,endy;
	private M m;

	//是不是让startmouse只提供坐标点的数据其它不管？
	//鼠标按下press后，调用一个m的函数(并传入这个点的x,y)，让m遍历list，对每一个shape对象进行判断是否被selected，
	//如果是，我们将会在m中得到这个对象的引用，同时shape的isSelected会自动返回它的参数值给m。
	//这时应该让m进入一种改变图形位置的状态。
	//接着会在m的这个函数中继续运算
	//鼠标开始drag
	//鼠标release之后得到endx,endy，然后调用m的repaint，
	
	
	//如果不是，继续drag,release，由于状态是作图，所以就创建生成一个对象，并画出它的shape
	
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
		startx=starty=endx=endy=0;				//保险措施。每一次Press都应该是新的开始。
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

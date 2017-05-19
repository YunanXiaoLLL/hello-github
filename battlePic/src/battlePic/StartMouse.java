package battlePic;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class StartMouse implements MouseListener,MouseMotionListener{
	int x,y;
	int startx,starty,endx,endy;
	private JFrame frame;
	private Graphics2D g;
	private String type ="";
	
	
	public StartMouse(JFrame frame , String type){
		this.frame=frame;
		this.g = (Graphics2D)frame.getGraphics();
		this.type = type;
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		x=e.getX();
		y=e.getY();
		//eraser可以用这个，其它就用其它的把
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {	}

	@Override
	public void mouseEntered(MouseEvent e) {	}

	@Override
	public void mouseExited(MouseEvent e) { 	}

	@Override
	public void mousePressed(MouseEvent e) {
		startx=e.getX();
		starty=e.getY();
		//坐标全部得到，调用其它函数去draw的时机就在此。
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		endx=e.getX();
		endy=e.getY();
		if(type.equals("Line")){
			g.drawLine(startx, starty, endx, endy);
			startx=starty=endx=endy=0;
		}

	}
	
	public int[] getPRXY(){
		int[] a = {startx,starty,endx,endy};
		return a;
	}
	public int[] getDXY(){
		int[] b = {x,y};
		return b;
	}
}

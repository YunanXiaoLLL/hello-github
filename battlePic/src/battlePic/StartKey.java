package battlePic;

import java.awt.event.*;

public class StartKey implements KeyListener{
	private M m;
	
	public StartKey(M m){
		this.m=m;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(">");
		if(e.isShiftDown()&&e.getKeyCode()==46){
			
		}
		if(e.isShiftDown() &&e.getKeyCode()==44){
			System.out.print("<");
		}
		else if(e.isShiftDown() && e.getKeyCode()==61){
			System.out.println("+");
			m.controlShape(2);	//让m进入加粗减细状态
			m.setShapewidth(1);//改变shape的stroke
			m.repaint();
		}
		else if(e.getKeyCode()==45){
			System.out.println("-");
			m.controlShape(2);
			m.setShapewidth(0);
			
			
			m.repaint();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar()=='o'){
			System.out.println("ooooooooo");
		}
	}

}

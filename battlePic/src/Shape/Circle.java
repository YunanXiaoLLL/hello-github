package Shape;

import java.awt.Graphics;

public class Circle extends Shape {
	private int x;
	private int y;
	private int radius;
	private Graphics g;
	public Circle(Graphics g,int x,int y,int radius){
		this.g=g;
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawOval(x, y, radius*2, radius*2);
	}
	
	@Override
	public boolean isSelected(int[] arg0){
		boolean x = false;
		
		
		return x;
	}
	@Override
	public int[] getPM(){
		int[] a={x,y,radius};
		return a;
	}
	@Override
	public String getType(){
		return new String("Circle");
	}
	@Override 
	public void changePM(int[] arg0){
		x=arg0[0];
		y=arg0[1];
		radius=arg0[2];
	}
}

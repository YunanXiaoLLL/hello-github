package Shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Shape {
	private int x;
	private int y;
	private int radius;
	private Graphics g;
	private int f=1;
	private Color color = Color.black;
	
	private int startx,starty;
	public Circle(Graphics g,int x,int y,int radius){
		this.g=g;
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	@Override
	public void draw(Graphics g) {
		System.out.println("fcicle="+f);
		g.setColor(color);
		g.drawOval(x-radius, y-radius, radius*2, radius*2);
		
		if(f>1){
			int a=f;
			for(int i=1; a>1 ;i++,a--){
				g.drawOval(x-radius-i, y-radius-i, (radius+i)*2, (radius+i)*2);
				g.drawOval(x-radius+i, y-radius+i, (radius-i)*2, (radius-i)*2);
			}
		}
		
	}
	
	@Override
	public boolean isSelected(int[] arg0){
		boolean j = false;
		startx=arg0[0];
		starty=arg0[1];
		if(startx>=x-radius && startx<=x+radius &&
				starty>=y-radius && starty<=y+radius){
			j=true;
		}
		
		return j;
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
	public void setColor(Color arg0){
		this.color=arg0;
	}
	
	@Override
	public void overStriking() {
		f+=1;
	}
	@Override
	public void attenuate() {
		f-=1;
	}
	@Override
	public int getF() {
		int i=f;
		return i;
	}
	@Override
	public void setF(int i) {
		f=i;
	}
}

package Shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle extends Shape {
	//为了让返回参数时，直接返回矩形左上角的点坐标和长度宽度，那么需要对传进来的数据先进行一定的处理。再draw.
	private int x1;
	private int y1;
	private int width;
	private int height;
	//用于拖动。
	private int startx,starty;
	private Graphics g;
	private int f=1;
	private Color color =Color.black;
	public Rectangle(Graphics g,int a1,int b1,int a2,int b2){
		this.g=g;
		if(a1<a2){
			if(b1<b2){
				x1=a1; y1=b1; width=a2-a1; height=b2-b1;
			}
			else{
				x1=a1;y1=b2;width=a2-a1;height=b1-b2;
			}
		}
		else{
			if(b1<b2){
				x1=a2 ; y1=b1 ; width=a1-a2 ; height=b2-b1;
			}
			else{
				x1=a2 ;y1=b2 ; width=a1-a2 ; height=b1-b2 ;
			}
		}
		
	}
	@Override
	public void draw(Graphics g) {
		System.out.println("frectang="+f);
		g.setColor(color);
		g.drawRect(x1,y1,width,height);
		
		if(f>1){
			int a=f;
			for(int i=1; a>1; i++,a--){
				g.drawRect(x1-i, y1-i, width+2*i, height+2*i);
				g.drawRect(x1+i, y1+i, width-2*i, height-2*i);
			}
		}
		
	}

	@Override
	public boolean isSelected(int[] arg0) {
		boolean j=false;
		startx=arg0[0];
		starty=arg0[1];
		if(startx>=x1 && startx<=x1+width &&
				starty>=y1 && starty<=y1+height){
			j=true;
		}
	
		return j;
	}

	@Override
	public int[] getPM() {
		int[] a ={x1,y1,width,height};
		return a;
	}

	@Override
	public String getType() {
		return new String("Rectangle");
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

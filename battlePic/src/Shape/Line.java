package Shape;

import java.awt.Graphics;
	
public class Line extends Shape {
	private int x1,y1,x2,y2;
	private Graphics g;
	//private int[] isPoint;
	public Line(Graphics g,int x1,int y1,int x2,int y2){
		this.g=g;
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
	}
	@Override
	public void draw(Graphics g) {
		g.drawLine(x1, y1, x2, y2);
		
	}
	@Override
	public boolean isSelected(int[] arg0){
		boolean x = false;
		int clickx= arg0[0];
		int clicky= arg0[1];
		if(y1 == y2){				//Ð±ÂÊÎª0
			if(x1<x2){
				if((clicky==y1)&&(clickx>x1)&&(clickx<x2)){
					x = true;
				}
			}
			else{
				if((clicky==y1)&&(clickx>x2)&&(clickx<x1)){
					x = true;
				}
			}
		}
		else if( (clicky-y1)/(y1-y2)==(clickx-x1)/(x1-x2) ){
			x=true;
		}

		return x;
	}
	@Override
	public String getType(){
		return new String("Line");
	}
	@Override
	public int[] getPM(){
		int[] a ={x1,y1,x2,y2};
		return a;
	}
	@Override
	public void changePM(int[] arg0){
		x1=arg0[0];
		y1=arg0[1];
		x2=arg0[2];
		y2=arg0[3];
	}
}

package Shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Line extends Shape {
	private int x1,y1,x2,y2;
	private Graphics g;
	private int f=1;
	private Color color=Color.black;
	

	public Line(Graphics g,int x1,int y1,int x2,int y2){
		this.g=g;
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		System.out.println("fline="+f);
		g.drawLine(x1, y1, x2, y2);
		
		if(f>1){
			int a=f;
			for(int i=1 ; a>1 ; i++,a--){
				if(y1!=y2){
					g.drawLine(x1+i, y1, x2+i, y2);
					g.drawLine(x1-i, y1, x2-i, y2);
				}
				else{
					g.drawLine(x1, y1+i, x2, y2+i);
					g.drawLine(x1, y1-i, x2, y2-i);
				}
			}	
		}
	}
	@Override
	public boolean isSelected(int[] arg0){
		boolean x = false;
		int clickx= arg0[0];
		int clicky= arg0[1];
		int[] clickx1={clickx-1,clickx,clickx+1};
		int[] clicky1={clicky-1,clicky,clicky+1};
		for(int i=0;i<clickx1.length;i++){
			for(int j=0;j<clickx1.length;j++){
		
			if(y1 == y2){				//Ð±ÂÊÎª0
				if(x1<x2){
					if((clicky1[j]==y1)&&(clickx1[j]>x1)&&(clickx1[j]<x2)){
						x = true;
						break;
					}
				}
				else{
					if((clicky1[j]==y1)&&(clickx1[i]>x2)&&(clickx1[i]<x1)){
						x = true;
						break;
					}
				}
			}
			else if( x1!=x2 && 
					(clicky1[j]-y1)/(y1-y2)==(clickx1[i]-x1)/(x1-x2) ){
				x=true;
				break;
				//....
			}
			
			}}

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
	public void setF(int i){
		f=i;
	}
}

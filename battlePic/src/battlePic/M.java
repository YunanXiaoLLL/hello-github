package battlePic;
import battlePic.StartMouse;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Shape.*;
import Shape.Shape;
//下一步思考list中是如何存每一个对象的，是否在选中这些对象时会出现什么问题。
public class M extends JPanel{
	private StartAction StA ;
	private StartMouse StM ;
	private String type ="";//为什么一定要给一个空字符串才能不出错？如果什么都不给直接出异常。
	private Shape s;
	private ArrayList<Shape> list = new ArrayList<>();
	private int startx,starty,dragx,dragy,endx,endy;
	private int conShape; //控制Paint状态。为0时正常作图，为1时是移动图像。
	private int realShape;//为0时是假图，还没确定，为1时则正式确定图像移动后的位置。
	private int[] a;
	private int[] b;
	protected JButton btn0;
	protected JButton btn1;
	protected JButton btn2;
	protected JButton btn3;
	protected JButton btn4;
	protected JButton btn5;
	private JPanel smallPan = new JPanel();
	//所有东西都做好了，用一个最大的JPanel把所有东西包裹起来，然后在main中的JFrame中加入它，直接成型。
	//现在我需要利用回调函数让M去addActionListener,不通过接口了，直接将自己传给StA.
	//StartMouse还没有改。
	public M(){	
		StA= new StartAction(this);
		StM= new StartMouse(this);
		setLayout( new FlowLayout(FlowLayout.RIGHT));
		smallPan.setLayout(new GridLayout(6,1));
		 btn0 = new JButton("Thick");
		 btn1 = new JButton("Line");
		 btn2 = new JButton("Circle");
		 btn3 = new JButton("Triangle");
		 btn4 = new JButton("Rectangle");
		 btn5 = new JButton("Eraser");
		 smallPan.add(btn0);
		 smallPan.add(btn1);
		 smallPan.add(btn2);
		 smallPan.add(btn3);
		 smallPan.add(btn4);
		 smallPan.add(btn5);
		 smallPan.setPreferredSize(new Dimension(100,400));
		 add(smallPan);
		 //下面这行代码实际上就是override getPrefersized
	//	 setPreferredSize( new Dimension(100,400));
		
		btn0.addActionListener(StA);
		btn1.addActionListener(StA);
		btn2.addActionListener(StA);
		btn3.addActionListener(StA);
		btn4.addActionListener(StA);
		btn5.addActionListener(StA);
		
	}
	
	public void addmouse(){
		addMouseListener(StM);
		addMouseMotionListener(StM);
		System.out.println("hello1");
	}
//	public void removemouse(){
//		removeMouseListener(StM);
//		removeMouseListener(StM);
//	}
	public void changeType(String type){
		this.type=type;
	}
	public boolean ItisClicked(int clickx,int clicky){
		boolean j=false;
		int[] c ={clickx,clicky};
		for(int i=0;i<list.size();i++){
			s=list.get(i);
			type=s.getType();
			if( s.isSelected(c) ){
//				System.out.println("it is be selected!");
				b=s.getPM();
				j=true;
				break; //在自己的线上 就一定不能在别的线上，所以还要完善这个函数。
			}
		}
		return j;
	}
	
//	@Override
//	public void update(Graphics arg0) {
//		super.update(arg0);
//		arg0.setColor(this.getBackground());
//		arg0.fillRect(0, 0, getWidth(), getHeight());
//		paint(arg0);
//	}

	//如何将画出来的东西删除掉？似乎可以用update函数将画面清空，然后再根据list对象重画。被移动的对象图形的前身应该会被删除。
	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		System.out.println("hey,paint");
		a=StM.getPRXY();
		startx=a[0]; starty=a[1]; dragx=a[2]; dragy=a[3];endx=a[4];endy=a[5];
		
//	    if(type.equals("Line")){
//	    	if(conShape==1){
//	    		System.out.println("in if drag");
//	    		int x3=endx-startx;
//	    		int y3=endy-starty;
//	    		int x4=endx-dragx;
//	    		int y4=endy-dragy;
//	    		int x=0;
//	    		int y=0;
//	    		if(realShape==1){
//		    		x=x3;y=y3;
//		  
//		    		realShape=0;
//	    		}
//	    		else{
//		    		x=x4;y=y4;
//	    		}
//	    		for(int i=0;i<b.length;i++){
//	    			if(i%2==0){
//	    				b[i]+=x;
//	    			}
//	    			else{
//	    				b[i]+=y;
//	    			}
//	    		}
//	    		s.changePM(b);
//	    		s.draw(g);
//	    		System.out.println("in dragShape");
//	    		System.out.println(conShape);
//	    	//	conShape = 0;
//			}
//	    	 if(conShape==0){
//	    		System.out.println("in createShape");
				s=new Line(g,startx,starty,endx,endy);
				list.add(s);
				s.draw(g);
//			}
	    	if( !list.isEmpty() ){
				for(int i=0;i<list.size();i++){
					s=list.get(i);
					s.draw(g);
					
				}
			}
	    	
	    }
	    //....
	    
		
		
//	}
	
	//用来删除mousedrag中的重影图形。
	public void removeSh(int sum){
		if(conShape==0){
			if(list.size() > sum){
				list.remove(list.size()-1);
			}
		}
	}

//	public void controlShape(int c){			//控制Paint状态。为0时正常作图，为1时是移动图像。
//		conShape=c;
//	}
//	public void changeRealShape(int c){			//为0时是假图，还没确定，为1时则正式确定图像移动后的位置
//		realShape=c;
//	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(100,400);
	}

	

	
	
}

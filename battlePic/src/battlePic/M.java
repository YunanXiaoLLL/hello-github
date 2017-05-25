package battlePic;
import battlePic.StartMouse;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Shape.*;
import Shape.Shape;
//��һ��˼��list������δ�ÿһ������ģ��Ƿ���ѡ����Щ����ʱ�����ʲô���⡣
public class M extends JPanel{
	private StartAction StA ;
	private StartMouse StM ;
	private String type ="";//Ϊʲôһ��Ҫ��һ�����ַ������ܲ��������ʲô������ֱ�ӳ��쳣��
	private Shape s;
	private ArrayList<Shape> list = new ArrayList<>();
	private int startx,starty,dragx,dragy,endx,endy;
	private int conShape; //����Paint״̬��Ϊ0ʱ������ͼ��Ϊ1ʱ���ƶ�ͼ��
	private int realShape;//Ϊ0ʱ�Ǽ�ͼ����ûȷ����Ϊ1ʱ����ʽȷ��ͼ���ƶ����λ�á�
	private int[] a;
	private int[] b;
	protected JButton btn0;
	protected JButton btn1;
	protected JButton btn2;
	protected JButton btn3;
	protected JButton btn4;
	protected JButton btn5;
	private JPanel smallPan = new JPanel();
	//���ж����������ˣ���һ������JPanel�����ж�������������Ȼ����main�е�JFrame�м�������ֱ�ӳ��͡�
	//��������Ҫ���ûص�������MȥaddActionListener,��ͨ���ӿ��ˣ�ֱ�ӽ��Լ�����StA.
	//StartMouse��û�иġ�
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
		 //�������д���ʵ���Ͼ���override getPrefersized
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
				break; //���Լ������� ��һ�������ڱ�����ϣ����Ի�Ҫ�������������
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

	//��ν��������Ķ���ɾ�������ƺ�������update������������գ�Ȼ���ٸ���list�����ػ������ƶ��Ķ���ͼ�ε�ǰ��Ӧ�ûᱻɾ����
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
	
	//����ɾ��mousedrag�е���Ӱͼ�Ρ�
	public void removeSh(int sum){
		if(conShape==0){
			if(list.size() > sum){
				list.remove(list.size()-1);
			}
		}
	}

//	public void controlShape(int c){			//����Paint״̬��Ϊ0ʱ������ͼ��Ϊ1ʱ���ƶ�ͼ��
//		conShape=c;
//	}
//	public void changeRealShape(int c){			//Ϊ0ʱ�Ǽ�ͼ����ûȷ����Ϊ1ʱ����ʽȷ��ͼ���ƶ����λ��
//		realShape=c;
//	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(100,400);
	}

	

	
	
}

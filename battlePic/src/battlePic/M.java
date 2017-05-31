package battlePic;
import battlePic.StartMouse;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Shape.*;
import Shape.Rectangle;
import Shape.Shape;
//��һ��˼��list������δ�ÿһ������ģ��Ƿ���ѡ����Щ����ʱ�����ʲô���⡣
public class M extends JPanel{
	private StartAction StA ;
	private StartMouse StM ;
	private StartKey StK;
	private String type ="";//Ϊʲôһ��Ҫ��һ�����ַ������ܲ��������ʲô������ֱ�ӳ��쳣��
	private Shape s;
	private ArrayList<Shape> list = new ArrayList<>();
	private int startx,starty,endx,endy;
	private int conShape; //����Paint״̬��Ϊ0ʱ������ͼ��Ϊ1ʱ���ƶ�ͼ��
	private int[] a;
	private int[] b;
	private int listID;
	protected JButton btn0;
	protected JButton btn1;
	protected JButton btn2;
	protected JButton btn3;
	protected JButton btn5;
	private JPanel smallPan = new JPanel();
	private JPanel colorchoose = new JPanel();
	private JPanel secondaryPanel = new JPanel();
	private ButtonColorAction BCA;
	protected Color oddColor=Color.black;

	//���ж����������ˣ���һ������JPanel�����ж�������������Ȼ����main�е�JFrame�м�������ֱ�ӳ��͡�
	//��������Ҫ���ûص�������MȥaddActionListener,��ͨ���ӿ��ˣ�ֱ�ӽ��Լ�����StA.
	//StartMouse��û�иġ�
	public M(){	
		BCA = new ButtonColorAction(this);
		StA= new StartAction(this);
		StM= new StartMouse(this);
		StK= new StartKey(this);
		setLayout( new FlowLayout(FlowLayout.RIGHT));
		smallPan.setLayout(new GridLayout(5,1));
		secondaryPanel.setLayout(new GridLayout(3, 1));
		colorchoose.setLayout(new FlowLayout());
		//smallpan
		 btn0 = new JButton("Thick");
		 btn1 = new JButton("Line");
		 btn2 = new JButton("Circle");
		 btn3 = new JButton("Rectangle");
		 btn5 = new JButton("Eraser");
		 smallPan.add(btn0);
		 smallPan.add(btn1);
		 smallPan.add(btn2);
		 smallPan.add(btn3);
		 smallPan.add(btn5);
		 smallPan.setPreferredSize(new Dimension(100,400));
//		 add(smallPan);
		 //�������д���ʵ���Ͼ���override getPrefersized
	//	 setPreferredSize( new Dimension(100,400));
		
		btn0.addActionListener(StA);
		btn1.addActionListener(StA);
		btn2.addActionListener(StA);
		btn3.addActionListener(StA);
		btn5.addActionListener(StA);
		
		
		//colorchoose
		JButton[] buttonColor= new JButton[6];
		Color[] color={Color.black,Color.blue,Color.green,Color.pink,Color.yellow,Color.orange};
		for(int i=0;i<buttonColor.length;i++){
			buttonColor[i] = new JButton();
			buttonColor[i].setPreferredSize(new Dimension(30,30));
			buttonColor[i].setBackground(color[i]);
			buttonColor[i].addActionListener(BCA);
			colorchoose.add(buttonColor[i]);
		}
		secondaryPanel.setPreferredSize(new Dimension(100,800));
		colorchoose.setPreferredSize(new Dimension(100,100));
		secondaryPanel.add(smallPan);
		secondaryPanel.add(colorchoose);
		add(secondaryPanel);
		requestFocus(); 
		
		
	}
	
	public void addmouse(){
		addMouseListener(StM);
		addMouseMotionListener(StM);
		System.out.println("hello1");
	}
	
	
	public void changeType(String type){
		this.type=type;
	}
	public void knowColor(Color comColor){
		this.oddColor=comColor;
	}
	public void setShapewidth(int i){//i=1�Ӵ֣�i=0��ϸ
		if(i==1){
			s.overStriking();
		}
		else if(i==0){
			s.attenuate();
		}
		
	}
	public void ItisClicked(int clickx,int clicky){
		boolean j=false;
		int[] c ={clickx,clicky};
		for(listID=0 ; listID<list.size() ; listID++){
			s=list.get(listID);
			if( s.isSelected(c) ){
				System.out.println("is selected");
				type=s.getType();
				b=s.getPM();
				j=true;
				addKeyListener(StK);
				requestFocus(); 
				break; 
			}
		}
		System.out.println("listID"+listID);
		if(j){
			//��Ϊ��ѡ���ˣ����Դ�ʱ��m����һ�ָı�shapeλ�õ�״̬��
			conShape=1;
		}
		
	}
	

	//��ν��������Ķ���ɾ�������ƺ�������update������������գ�Ȼ���ٸ���list�����ػ������ƶ��Ķ���ͼ�ε�ǰ��Ӧ�ûᱻɾ����
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("paint");
		a=StM.getPRXY();
		startx=a[0]; starty=a[1]; endx=a[2];endy=a[3];
		int movex=endx-startx;
		int movey=endy-starty;
	    if(type.equals("Line")){
	    	if(conShape==2){
	    		int[] aa=s.getPM();
	    		int x1=aa[0];int y1=aa[1];int x2=aa[2];int y2=aa[3];
	    		int f=s.getF();
	    		
	            Shape s1=new Line(g,x1,y1,x2,y2);
                list.remove(listID);
                s1.setF(f);
                s1.draw(g);
	    		list.add(s1);	
	    		
	    	}
	    	if(conShape==1){
	    		int x1 =b[0];int y1 =b[1];int x2 =b[2];int y2 =b[3];
	    		x1+=movex;x2+=movex;y1+=movey;y2+=movey;
	    		
	    		Shape s1=new Line(g,x1,y1,x2,y2);
	    		list.remove(listID);
	    		s1.draw(g);
	    		list.add(s1);
	    	}
	    	if(conShape==0){
				s=new Line(g,startx,starty,endx,endy);
				s.setColor(oddColor);
				list.add(s);
				s.draw(g);	
			}
	    	
	    	conShape=0;
	    }
	    if(type.equals("Circle")){
	    	if(conShape==2){
	    		int[] aa=s.getPM();
	    		int x1=aa[0];int y1=aa[1];int radius=aa[2];
	    		int f= s.getF();
	    		s=new Circle(g,x1,y1,radius);
	    		s.setF(f);
	    		list.remove(listID);
	    		s.draw(g);
	    		list.add(s);
	    	}
	    	if(conShape==1){//��Ҫ����Բ�����꣬��Բ�ϵ������Լ���뾶radius
	    		System.out.println("circle!!!!!!");
	    		int x1=b[0];int y1=b[1];int radius=b[2]; //Բ���ƶ����뾶�ǲ���ġ�
	    		System.out.println("x1="+x1+" y1="+y1+" radius"+radius);
	    		x1+=movex;
	    		y1+=movey;

	    		Shape s1=new Circle(g,x1,y1,radius);
	    		list.remove(listID);
	    		s1.draw(g);
	    		list.add(s1);
	    	}
	    	if(conShape==0){
		    	int radius=0;
		    	if(endy>starty)
		    		radius=endy-starty;
		    	else{
		    		radius=starty-endy;
		    	}
		    	s=new Circle(g,startx,starty,radius); //Բ��ֻ�����Ű����ſ���Ŷ
		    	s.setColor(oddColor);
		    	list.add(s);
		    	s.draw(g);
	    	}
	    	conShape=0;
	    }
	    if(type.equals("Rectangle")){
	    	if(conShape==2){
	    		int[] aa=s.getPM();
	    		int x1=aa[0];int y1=aa[1];int width=aa[2];int height=aa[3];
	    		
	    		int f= s.getF();
	    		s=new Rectangle(g,x1,y1,width+x1,height+y1);
	    		s.setF(f);
	    		list.remove(listID);
	    		s.draw(g);
	    		list.add(s);	
	    	}
	    	if(conShape==1){
	    		int startx=b[0];int starty=b[1];
	    		int width=b[2];int height=b[3];
	    		
	    		startx+=movex;starty+=movey;
	    		endx=startx+width;endy=starty+height;
	    		
	    		Shape s1= new Rectangle(g,startx,starty,endx,endy);
	    		list.remove(listID);
	    		s1.draw(g);
	    		list.add(s1);  		
	    	}
	    	if(conShape==0){
		    	s=new Rectangle(g,startx,starty,endx,endy);
		    	s.setColor(oddColor);
		    	list.add(s);
		    	s.draw(g);
	    	}
	
	    	conShape=0;
	    }
	    
	
	    if( !list.isEmpty() ){
	    	System.out.println("is ����");
			for(int i=0;i<list.size();i++){
				s=list.get(i);
				System.out.println("i="+i);
				s.draw(g);	
			}
		}
	    
	    System.out.println();
	}

	public void controlShape(int c){	//����Paint״̬��Ϊ0ʱ������ͼ��Ϊ1ʱ���ƶ�ͼ��Ϊ2ʱΪ�Ӵּ�ϸ
		conShape=c;
	}
	public void removeKey(){
		removeKeyListener(StK);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(100,400);
	}

	

	
	
}

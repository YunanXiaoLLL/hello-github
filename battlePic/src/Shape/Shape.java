package Shape;
import java.awt.Graphics;

public abstract class Shape {
	
	public abstract void draw(Graphics g);
	
	public abstract boolean isSelected(int[] arg0);//判断是否被选中
	
	//用于移动图像
	public abstract int[] getPM();	//得到构图的坐标位置
	public abstract String getType();//得到它的类型
	public abstract void changePM(int[] arg0);//修改构图的坐标位置，也就是将来用来移动的数据。
}

package Shape;
import java.awt.Graphics;
import java.awt.*;
public abstract class Shape {
	//让所有的shape的子类都拥有x1y1x2y2的私有坐标值。让它自己去计算该怎么draw。
	//这样方便外面直接得到两个点的坐标，而不用重新计算。
	
	public abstract void draw(Graphics g);
	
	public abstract boolean isSelected(int[] arg0);//判断是否被选中
	
	//用于移动图像
	public abstract int[] getPM();	//得到构图的坐标位置
	public abstract String getType();//得到它的类型
	public abstract void setColor(Color arg0); //用于设置图形颜色
	public abstract void overStriking();
	public abstract void attenuate();
	public abstract int getF();
	public abstract void setF(int i);
}

package Shape;
import java.awt.Graphics;
import java.awt.*;
public abstract class Shape {
	//�����е�shape�����඼ӵ��x1y1x2y2��˽������ֵ�������Լ�ȥ�������ôdraw��
	//������������ֱ�ӵõ�����������꣬���������¼��㡣
	
	public abstract void draw(Graphics g);
	
	public abstract boolean isSelected(int[] arg0);//�ж��Ƿ�ѡ��
	
	//�����ƶ�ͼ��
	public abstract int[] getPM();	//�õ���ͼ������λ��
	public abstract String getType();//�õ���������
	public abstract void setColor(Color arg0); //��������ͼ����ɫ
	public abstract void overStriking();
	public abstract void attenuate();
	public abstract int getF();
	public abstract void setF(int i);
}

package Shape;
import java.awt.Graphics;

public abstract class Shape {
	
	public abstract void draw(Graphics g);
	
	public abstract boolean isSelected(int[] arg0);//�ж��Ƿ�ѡ��
	
	//�����ƶ�ͼ��
	public abstract int[] getPM();	//�õ���ͼ������λ��
	public abstract String getType();//�õ���������
	public abstract void changePM(int[] arg0);//�޸Ĺ�ͼ������λ�ã�Ҳ���ǽ��������ƶ������ݡ�
}

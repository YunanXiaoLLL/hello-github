package battlePic;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class battlePic {
	//����Ŀǰ�����Ѿ����Բ���һ��ֱ�ߣ������ƶ����ˡ�
	
	//��������ʵ����������ַ��룬������������꣬������M�̳�JPanel
	//��View�õ�mouselistener������ȥpaint,update�ȵȣ�Viewֻ�ܽ�������ȥ����mouseֻ���ṩ���ݣ���������
	//Ϊ�˵õ��������,��Main������ȥnewһ�����������������ȥgetX,Y??������View��newһ��������
	//�޸�StartMouse?������һ��Shape���飬�洢�������Ķ�����Shape����һ��isSelected����֪����ѡ�У�
	//extends JPanel���
	//ÿ����һ�ζ�Ҫ���°���ť���Ա��ڶԻ������Ķ������ѡ�в�����
	//�õ�ereaserʱ�൱�ڸ�������ɫ��ɱ���ɫ���Ϳ��������
//	int[] a = new int[6];
//	public battlePic(M m){
//		
//	
//	}

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		M panel = new M();
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(panel);
		frame.setSize( new Dimension(700,600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("frameS");
		frame.setVisible(true);
		
	
	}


	


	
}

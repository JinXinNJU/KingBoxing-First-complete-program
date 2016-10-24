package main;

import javax.swing.JPanel;

import ui.GameFrame;
import ui.PanelAnimation;
import ui.PanelBegin;
import ui.PanelSpecial;

public class GameMain {
	public static void main(String[] args){
		GameFrame gameFrame = new GameFrame();
		PanelAnimation panelAnimation=new PanelAnimation(gameFrame);
		gameFrame.setContentPane(panelAnimation);
	}
}


                                                                                                //172.26.23.37

//��Ϸ��������ݣ�
//internet�İ��������⣻���ֲ������ʲôʱ��ֹͣ��Ŀǰֻ�ܿ�ʼ��һֱѭ����
//ѡ�����Ҫ�ǵƿ��Ժ��������ľͺ��ˣ�ѡ������close��ťҪ�޸ģ���ü�����С����ť��
//����ģʽ���߸��̶��Ѷ����ε�������1��2��3��4��5��6��7��ֵ
//����һ������ģʽ��ת��ת�����ʼ����ս�Ե���Ϸ,����ģʽ���߸����䣬�߸����̣��߸�ģʽ�����������Ǳ����
//���ֵ��ν���Ҫ��������ģʽ��
//��һЩ����ʼʲô����ʾ
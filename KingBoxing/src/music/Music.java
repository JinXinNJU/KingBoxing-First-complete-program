//package music;
//
//import java.awt.BorderLayout;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.File;
//
//import javax.sound.sampled.AudioFormat;
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.DataLine.Info;
//import javax.sound.sampled.FloatControl;
//import javax.sound.sampled.SourceDataLine;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JSlider;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//
///**
// * ���Բ���MP3 wav ogg��ʽ����Ƶ <br />
// * ���Ե�����������ͣ<br />
// * ������������ҵ���~��Ȼ�����Լ�����Ը�޸�����ע�͡�
// *
// * @author ������
// * @since 2014 / 3 / 17<br />
// *        2 : 35 AM
// */
//public class Music implements Runnable {
//
//	/**
//	 * �Ƿ�Ϊ��ͣ״̬
//	 */
//	private boolean isPause = true;
//	/**
//	 * �����ķ�Χ��0��2.0
//	 */
//	private static double volume = 2.0;
//	/**
//	 * ���ڿ��������ĸ���ֵ��Χ
//	 */
//	private static FloatControl floatControl = null;
//	/**
//	 * �ļ�·��
//	 */
//	private String filePath = null;
//	/**
//	 * �Ƿ�ѭ��
//	 */
//	private boolean loop = true;
//
//	/**
//	 * ���캯���ʼ�����ֵ�·��
//	 *
//	 * @param filePath
//	 */
//	public Music(String filePath) {
//		this.filePath = filePath;
//	}
//
//	/**
//	 * �����Ƿ�ѭ������
//	 *
//	 * @param loop
//	 *            trueΪѭ��<br />
//	 *            falseΪ��ѭ��<br />
//	 *            Ĭ�ϲ�ѭ��
//	 */
//	public void setLoop(boolean loop) {
//		this.loop = loop;
//	}
//
//	@Override
//	public void run() {
//		do {
//			// ����ѭ��yeah����Ϊ�ƺ�û��api���ҵ��Դ��loop�����������û����233
//			try {
//				init();
//				play();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} while (loop);
//	}
//
//	/**
//	 * ��ʼ�����ֵ������ݣ���ʵ���뼸�����ǹ̶���
//	 */
//	// ��Ƶ������, ��FileInputStream����
//	AudioInputStream audioInputStream = null;
//	SourceDataLine sourceDataLine = null;
//
//	public void init() throws Exception {
//
//		// 1�����ļ�ת��Ϊ��Ƶ������
//		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
//		// 2����ȡ����ļ�����Ƶ��ʽ
//		AudioFormat audioFormat = audioInputStream.getFormat();
//		// mp3 ogg wav ת��
//		// �����ж�audioFormat.getEncoding() != AudioFormat.Encoding.PCM_SIGNED
//		// ����ΪMP3��ʽ��Ϊ�����ʽ��������������ƣ�PCM������Ƶ��ݣ�����PCM_SIGNED��PCM_SIGNED������
//		if (filePath.endsWith(".ogg")
//				|| (filePath.endsWith(".mp3") || (filePath.endsWith(".wav") & audioFormat
//						.getEncoding() != AudioFormat.Encoding.PCM_SIGNED))) {
//			// �½�һ���涨����Ƶ��ʽ
//			audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,// �����ʽ
//					audioFormat.getSampleRate(), // ԭ���Ĳ��β�����
//					16,// 16λ˫�ֽڲɼ�
//					audioFormat.getChannels(),// ԭ���������
//					// ���������ÿ֡�е��ֽ���ÿ���ÿ֡�ֽ���2�ֽڣ��ټ���˫��������������2��*�ֽ���2��
//					audioFormat.getChannels() * 2, audioFormat.getSampleRate(), // ÿ���֡��
//					false);// ������������
//			// ����ǰ����Ƶ��ת����ָ���ĸ�ʽ
//			audioInputStream = AudioSystem.getAudioInputStream(audioFormat,
//					audioInputStream);
//		}
//		// 3��������Ƶ�е���Ϣ
//		Info info = new Info(SourceDataLine.class, audioFormat);
//		// 4���ƺ��ǽ�����Ƶ�С��Ѿ���ʼ���ײ��ʵ�����Ҳ�����
//		sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
//		sourceDataLine.open(audioFormat);// ����Ƶ�����������Ƶ��
//		sourceDataLine.start();
//		// ��ʼ��FloatControl�� FloatControl.Type.MASTER_GAIN��ĳһ�����������Ŀؼ�
//		floatControl = (FloatControl) sourceDataLine
//				.getControl(FloatControl.Type.MASTER_GAIN);
//		// ����ΪĬ�ϵ�������С
//		setVolume(volume, false);
//	}
//
//	/**
//	 * ������Ƶ�ļ�
//	 */
//	public void play() {
//		try {
//			int nByte = 0;
//			final int SIZE = 1024;// ����1KB
//			byte[] buffer = new byte[SIZE];
//			while (nByte != -1) {
//				// ���������stop֮����Ƶ������ɻᴫ�䵽sourceDataLine��
//				// ֻ�ǻᱻ���������233�������������һ���������䣬
//				// System.out.println(buffer);//���Կ���stop֮��buffer�����ڸı�
//				if (!isPause) {
//					continue;
//				}
//				// ����Ƶ���д���Ƶ�������ð����Ѿ�������233
//				sourceDataLine.write(buffer, 0, nByte);
//				nByte = audioInputStream.read(buffer, 0, SIZE);
//			}
//			// �����ֹͣ
//			sourceDataLine.stop();
//			// ��ջ�������ʵӦ��ûʲô��Ҫ��������֮ǰ���ˣ���������б�Ҫ��
//			sourceDataLine.drain();
//			sourceDataLine.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * ���������Ĵ�С
//	 *
//	 * @param newVolume
//	 * <br />
//	 *            ���ֱ�������ѹֵ, ��ΧΪ0.0 ~ 2.0<br />
//	 *            �������Ϊ�ٷֱ�, ��ΧΪ0.0 ~ 100.0<br />
//	 * @param isPercent
//	 * <br />
//	 *            �������Ϊ�ٷֱ�, ��˴�Ϊtrue
//	 * @see FloatControl.Type.MASTER_GAIN
//	 */
//	public static void setVolume(Double newVolume, boolean isPercent) {
//		if (isPercent) {
//			// ���ٷֱ�ת����0.0~2.0
//			volume = newVolume / 50.0;
//		}
//		// �����и��ֱ��ļ��㹫ʽ dB = 20lg(E/Er) E-ʵ�ʲ�����ѹֵ��Er-�ο���ѹֵ
//		// �������newVolume����ʾ��ѹֵ��ΪE/Er
//		// ��ϸ��FloatControl.Type.MASTER_GAIN��API�ĵ�����̫������orz
//		float dB = (float) (Math.log(volume == 0.0 ? 0.0001 : volume)
//				/ Math.log(10.0) * 20.0);
//		floatControl.setValue(dB);
//	}
//
//	/**
//	 * ��ͣ�ķ���<br />
//	 * ��ʵ���Ǻܼ򵥵�һ�����ã��ص�����stop���׸���ʲô����ʵstop��Ͳ��������ֹͣ<br />
//	 * �ҵĿ����ǵ�����stop֮����sourceDataLine�����в��Ŷ��ѡ���ϸ��ڶ�����ɫ����
//	 */
//	public void pause() {
//		if (isPause) {
//			sourceDataLine.stop();
//		} else {
//			sourceDataLine.start();
//		}
//		isPause = !isPause;
//	}
//
//	// TODO ��������
////	public static void main(String[] args) {
////		final PlayMP3 musicPlay = new PlayMP3("sounds/sounds1/panel_game_bgm.mp3");
////		musicPlay.setLoop(true);
////
////		JFrame jFrame = new JFrame();
////		jFrame.setSize(100, 80);
////		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �������˳�
////		jFrame.setResizable(false);// ���ɸı��С
////		jFrame.setLocationRelativeTo(null);// ������С���Ҫ��setSize֮��
////
////		final JSlider slider1 = new JSlider(JSlider.HORIZONTAL, 0, 100, 80);
////		// �Ӽ������ϲ�������������ڲ���233�������������ž�����233
////		slider1.addChangeListener(new ChangeListener() {
////			public void stateChanged(ChangeEvent e) {
////				PlayMP3.setVolume((double) slider1.getValue(), true);
////			}
////		});
////		jFrame.add(slider1, BorderLayout.NORTH);
////		jFrame.setVisible(true);
////
////		final JButton test = new JButton("click");
////		test.addMouseListener(new MouseAdapter() {
////			@Override
////			public void mouseClicked(MouseEvent e) {
////				musicPlay.pause();
////			}
////		});
////		jFrame.add(test, BorderLayout.SOUTH);
////
////		new Thread(musicPlay).start();
////	}
//
//}

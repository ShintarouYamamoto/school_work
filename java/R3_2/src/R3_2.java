import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class R3_2 extends JPanel{
	Calendar today = new GregorianCalendar();
	int month = today.get(Calendar.MONTH) + 1;
	int date = today.get(Calendar.DATE);
	
	BufferedImage[] img = new BufferedImage[10];
	public R3_2() {
		try{
			img[0] = ImageIO.read(new File("0.png"));
			img[1] = ImageIO.read(new File("1.png"));
			img[2] = ImageIO.read(new File("2.png"));
			img[3] = ImageIO.read(new File("3.png"));
			img[4] = ImageIO.read(new File("4.png"));
			img[5] = ImageIO.read(new File("5.png"));
			img[6] = ImageIO.read(new File("6.png"));
			img[7] = ImageIO.read(new File("7.png"));
			img[8] = ImageIO.read(new File("8.png"));
			img[9] = ImageIO.read(new File("9.png"));
		}catch (Exception ex){
			ex.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img[month/10],0,0,null);
		g.drawImage(img[month%10],300,0,null);
		g.drawImage(img[date/10],0,500,null);
		g.drawImage(img[date%10],350,500,null);
		
	}
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.add(new R3_2()); 
		f.setBounds(0,0,1200,1200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true); 
		}
}
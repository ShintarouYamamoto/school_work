import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class R2_6 {
	public static void main(String[] args){
			JFrame f = new JFrame();
			f.add(new MyPanel()); 
			f.setBounds(0,0,1000,1000);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true); 
	}
	static class MyPanel extends JPanel{
	public void paintComponent(Graphics g){
		int r=200;
		double s=2*Math.PI/5;
		double x0=r*Math.sin(0*s);
		double y0=r*Math.cos(0*s);
		double x1=r*Math.sin(1*s);
		double y1=r*Math.cos(1*s);
		double x2=r*Math.sin(2*s);
		double y2=r*Math.cos(2*s);
		double x3=r*Math.sin(3*s);
		double y3=r*Math.cos(3*s);
		double x4=r*Math.sin(4*s);
		double y4=r*Math.cos(4*s);
		g.setColor(Color.RED);
		g.fillOval((int)x0+500,(int)y0+500,100,100); 
		g.setColor(Color.BLUE);
		g.fillOval((int)x1+500,(int)y1+500,100,100); 
		g.setColor(Color.GREEN);
		g.fillOval((int)x2+500,(int)y2+500,100,100); 
		g.setColor(Color.PINK);
		g.fillOval((int)x3+500,(int)y3+500,100,100);  
		g.setColor(Color.BLACK);
		g.fillOval((int)x4+500,(int)y4+500,100,100); 
		}
	}
}
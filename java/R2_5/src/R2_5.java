import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class R2_5 extends JPanel {
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0,0,1000,1000);
		g.setColor(Color.gray);
		g.fillOval(0,0,800,500);
		g.setColor(Color.white);
		g.fillOval(75,75,650,350);
		g.setColor(Color.gray);
		g.fillOval(175,50,450,200);
		g.setColor(Color.white);
		g.fillOval(237,50,330,150);
		g.setColor(Color.gray);
		g.fillOval(300,50,200,400);
		g.setColor(Color.white);
		g.fillOval(335,120,125,275);
		g.setColor(Color.gray);
		g.fillRect(300,190,180,52);
		
		
		
	}
	
	public static void main(String[] args){
			JFrame f = new JFrame();
			f.add(new R2_5()); 
			f.setBounds(0,0,1000,1000);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true); 
	}
	
}
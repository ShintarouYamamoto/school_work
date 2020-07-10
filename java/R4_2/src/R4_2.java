import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class R4_2 extends JPanel {
	DoubleCircle a1= new DoubleCircle(Color.blue,Color.GREEN,100,100,100,50);
	public R4_2() {
		setOpaque(false);
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				a1.moveTo(evt.getX(), evt.getY()); 
				repaint(); 
			}
		});
	}
	public void paintComponent(Graphics g) {		
		a1.draw(g);		
		} 	
	public static void main(String[] args){		
		JFrame app = new JFrame();
		app.add(new R4_2());		
		app.setSize(800,800);		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		app.setVisible(true);	} 	
	
	static class Circle {	
		Color col;		
		int xpos, ypos, rad; 		
		public Circle(Color c, int x, int y, int r) {
			col = c; xpos = x ;ypos = y; rad = r;
			} 		
		public void draw(Graphics g) {		
			g.setColor(col);			
			g.fillOval(xpos - rad, ypos - rad, rad * 2, rad * 2);
			}	
		}
	static class DoubleCircle{
		Circle c1;
		Circle c2;
		Color col1,col2;
		int xpos,ypos,r1,r2;
		public DoubleCircle(Color cl1,Color cl2,int x,int y,int c,int d){
		col1=cl1; col2=cl2; xpos=x; ypos=y; r1=c; r2=d;
		c1 = new Circle(cl1,x,y,c);
		c2 = new Circle(cl2,x,y,d);
		}
		public void moveTo(int x, int y) {
			c1.xpos=x;
			c1.ypos=y;
			c2.xpos=x;
			c2.ypos=y;
		}
		public void draw(Graphics g) {
			c1.draw(g);
			c2.draw(g);
		}
	}
}
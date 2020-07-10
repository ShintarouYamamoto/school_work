import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class R4_4 extends JPanel{
	
	DoubleCircle a1= new DoubleCircle(Color.blue,Color.GREEN,200,100,50,25);
	Rect b1=new Rect(Color.red,400,200,100,100);
	Triangle e1=new Triangle(Color.yellow,600,200,500,350,700,350);
	Rect d1=new Rect(Color.white,800,400,100,100);
	Circle c1=new Circle(Color.gray,1000,500,50);
	
	public R4_4() {
		setOpaque(false);
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				d1.moveTo(evt.getX(), evt.getY()); 
				repaint(); 
			}
		});
		 addMouseListener(new MouseAdapter() {
	         public void mouseReleased(MouseEvent evt){
				d1.setColor(Color.pink);
				repaint();
			}
		});
	}
	public void paintComponent(Graphics g) {
		c1.draw(g);
		a1.draw(g);		
		b1.draw(g);
		d1.draw(g);
		e1.draw(g);
		g.setColor(Color.black);;
		g.drawLine(0,0,2000,1000);
		} 	
	
	public static void main(String[] args){		
		JFrame app = new JFrame();
		app.add(new R4_4());		
		app.setSize(1500,1000);		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		app.setVisible(true);	
		}
	
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
		public DoubleCircle(Color cl1,Color cl2,int a,int b,int c,int d){
		c1 = new Circle(cl1,a,b,c);	
		c2 = new Circle(cl2,a,b,d);	
		}
		public void draw(Graphics g) {
			c1.draw(g);
			c2.draw(g);
		}
	}
	
	static class Rect{
		Color col;
		int xpos,ypos,width,height;
		public Rect(Color c,int x, int y, int w, int h){
			col=c; xpos=x; ypos=y; width=w; height=h;
		}
		public void setColor(Color c){
			col=c;
		}
		public void moveTo(int x, int y) {
			xpos=x;
			ypos=y;
		}
		public void draw(Graphics g) {
			g.setColor(col);
			g.fillRect(xpos-width/2, ypos-height/2, width, height);
		}
	}
	
	
	static class Triangle{
		Color col;
		int[] xs,ys;
		public Triangle(Color c,int x0, int y0, int x1,int y1, int x2, int y2){
			col=c; xs=new int[]{x0,x1,x2}; ys=new int[]{y0,y1,y2};
		}
	public void draw(Graphics g){
		g.setColor(col);
		g.fillPolygon(xs,ys,3);
		}
	}
	
}
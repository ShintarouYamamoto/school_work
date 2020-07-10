import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class R5A_3 extends JPanel {
	ArrayList<Figure> figs = new ArrayList<Figure>();
	Figure sel = null;
	
	public R5A_3(){
		setOpaque(false);
		figs.add(new Circle(Color.GREEN,220,80,30));
		figs.add(new Circle(Color.PINK,200,100,40));
		figs.add(new Rect(Color.YELLOW,240,60,30,40));
		figs.add(new Rect(Color.BLUE,260,40,80,40));
		figs.add(new Picture("Koala.png",500,500));
		figs.add(new Name(Color.RED,500,160,600,600));
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt){
			sel=pick(evt.getX(), evt.getY()); 
		}
	});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				if (sel == null) {
					return;
				}
				sel.moveTo(evt.getX(), evt.getY()); 
				repaint();
			}
		});
	}
	
	private Figure pick(int x, int y) {
		Figure p = null;
		for (Figure f : figs) {
			if (f.hit(x, y)) {
			p = f;
			}
		}
		return p;
		
	}
	
	public void paintComponent(Graphics g) {
		for (Figure f : figs) {
			f.draw(g);
		}
	}
	
	public static void main(String[] args){		
		JFrame app = new JFrame();
		app.add(new R5A_3());		
		app.setSize(1500,1000);		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		app.setVisible(true);	
		}
	
	interface Figure {
		public void draw(Graphics g); 
		public boolean hit(int x, int y);
		public void moveTo(int x, int y); 
	}
	
	static class Circle implements Figure {	
		Color col;		
		int xpos, ypos, rad; 		
		public Circle(Color c, int x, int y, int r) {
			col = c; xpos = x ;ypos = y; rad = r;
			}
		public boolean hit(int x, int y) {
			return (xpos - x) * (xpos - x) + (ypos - y) * (ypos - y) <= rad
					* rad;
		}
		public void moveTo(int x, int y) {
			xpos=x;
			ypos=y;
		}
		public void draw(Graphics g) {		
			g.setColor(col);			
			g.fillOval(xpos - rad, ypos - rad, rad * 2, rad * 2);
			}	
	}
		static class Picture implements Figure {	
			BufferedImage img;		
			int xpos, ypos, width, height; 		
			public Picture(String fname, int x, int y) {
				try{
					img= ImageIO.read(new File("Koala.png"));
				}catch (Exception ex){
					ex.printStackTrace();
					System.exit(-1);
				}
				xpos = x ;ypos = y;width=img.getHeight();height=img.getWidth();
				}
			public boolean hit(int x, int y) {
				return  xpos - width / 2 <= x && x <= xpos + width / 2
						&& ypos - height / 2 <= y && y <= ypos + height / 2;
			}
			public void moveTo(int x, int y) {
				xpos=x;
				ypos=y;
			}
		public void draw(Graphics g) {	
			int x=xpos-width/2,y=ypos-height/2;
			g.drawImage(img,x,y,null);
			}	
		}
	static class Rect implements Figure {
		Color col;
		int xpos,ypos,width,height;
		public Rect(Color c,int x, int y, int w, int h){
			col=c; xpos=x; ypos=y; width=w; height=h;
		}
		public boolean hit(int x, int y) {
			return xpos - width / 2 <= x && x <= xpos + width / 2
					&& ypos - height / 2 <= y && y <= ypos + height / 2;
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
	static class Name implements Figure {
		Color col;
		int xpos,ypos,width,height;
		public Name(Color c,int x,int y,int w,int h){
			col=c; xpos=x; ypos=y; width=w; height=h;
		}
		public boolean hit(int x, int y) {
			return xpos - width / 2 <= x && x <= xpos + width / 2
					&& ypos - height / 2 <= y && y <= ypos + height / 2;
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
			g.drawLine(xpos+100,ypos+200,xpos+100,ypos+250);
			g.drawLine(xpos+50,ypos+225,xpos+150,ypos+225);
			g.drawLine(xpos+50,ypos+250,xpos+150,ypos+250);
			g.drawLine(xpos+50,ypos+250,xpos+50,ypos+340);
			g.drawLine(xpos+150,ypos+250,xpos+150,ypos+340);
			g.drawLine(xpos+50,ypos+280,xpos+150,ypos+280);
			g.drawLine(xpos+50,ypos+310,xpos+150,ypos+310);
			g.drawLine(xpos+50,ypos+340,xpos+150,ypos+340);
			g.drawLine(xpos+25,ypos+360,xpos+175,ypos+360);
			g.drawLine(xpos+75,ypos+380,xpos+45,ypos+390);
			g.drawLine(xpos+125,ypos+380,xpos+155,ypos+390);
			
			g.drawLine(xpos+250,ypos+250,xpos+350,ypos+250);
			g.drawLine(xpos+315,ypos+220,xpos+300,ypos+250);
			g.drawLine(xpos+300,ypos+250,xpos+250,ypos+350);
			g.drawLine(xpos+300,ypos+250,xpos+350,ypos+350);
			g.drawLine(xpos+300,ypos+320,xpos+320,ypos+350);
			
			g.drawLine(xpos+400,ypos+250,xpos+500,ypos+250);
			g.drawLine(xpos+400,ypos+250,xpos+400,ypos+350);
			g.drawLine(xpos+400,ypos+350,xpos+500,ypos+350);
			g.drawLine(xpos+500,ypos+250,xpos+500,ypos+350);
			
			g.drawLine(xpos+600,ypos+250,xpos+700,ypos+250);
			g.drawLine(xpos+650,ypos+225,xpos+650,ypos+250);
			g.drawLine(xpos+600,ypos+250,xpos+600,ypos+270);
			g.drawLine(xpos+700,ypos+250,xpos+630,ypos+350);


		}
	}
	
}
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

public class R11_8 extends JPanel {
	ArrayList<Figure> figs = new ArrayList<Figure>();
	ArrayList<Figure> figs2 = new ArrayList<Figure>();
	ArrayList<Figure> figs3 = new ArrayList<Figure>();
	Figure sel = null;
	
	public R11_8(){
		setOpaque(false);
		Circle a1=new Circle(Color.GREEN,420,80,100);
		Circle a2=new Circle(Color.PINK,200,100,40);
		Rect b1=new Rect(Color.YELLOW,540,260,30,40);
		Rect b2=new Rect(Color.BLUE,260,340,80,40);
		Picture c1=new Picture("Koala.jpg",500,500);
		Picture2 c2=new Picture2("2.jpg",500,500);
		
		figs2.add(a1);
		figs2.add(a2);
		figs3.add(b1);
		figs3.add(b2);
		figs.add(c1);
		
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
		
		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent evt){
				if (sel == null) {
					return;
				}
				if (sel == c1) {
				figs.add(c2);
				figs.remove(c1);
				repaint();
				}
		}
	});
		
		addMouseMotionListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent evt){
				if (sel == null) {
					return;
				}
				if (sel == a1) {
					a1.setScale(200);
					repaint();
				}
				if (sel == a2) {
					a2.setScale(200);
					repaint();
				}
				if (sel == b1) {
					b1.setColor(Color.black);
					repaint();
				}
				if (sel == b2) {
					b1.setColor(Color.white);
					repaint();
				}
				
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
		for (Figure f : figs2) {
			if (f.hit(x, y)) {
			p = f;
			}
		}
		for (Figure f : figs3) {
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
		for (Figure f : figs2) {
			f.draw(g);
		}
		for (Figure f : figs3) {
			f.draw(g);
		}
	}
	
	public static void main(String[] args){		
		JFrame app = new JFrame();
		app.add(new R11_8());		
		app.setSize(1500,1000);		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		app.setVisible(true);	
		}
	
	interface Figure {
		public void draw(Graphics g); 
		public boolean hit(int x, int y);
		public void moveTo(int x, int y); 
		public void setScale(int ds);
		public void setColor(Color c);
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
		public void setScale(int ds){
			rad=ds;
		}
		public void setColor(Color c){
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
					img= ImageIO.read(new File("Koala.jpg"));
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
			public void setColor(Color c){
				}
			public void setScale(int ds){
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
		
		static class Picture2 implements Figure {	
			BufferedImage img;		
			int xpos, ypos, width, height; 		
			public Picture2(String fname, int x, int y) {
				try{
					img= ImageIO.read(new File("2.jpg"));
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
			public void setScale(int ds){
			}
			public void setColor(Color c){
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
		public void setScale(int ds){
			width=ds;
			height=ds;
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
}

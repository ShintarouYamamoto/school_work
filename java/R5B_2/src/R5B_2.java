import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

	public class R5B_2 extends JPanel {
		ArrayList<Figure> figs = new ArrayList<Figure>();
		Figure sel = null;
		
		public R5B_2(){
			setOpaque(false);
			figs.add(new Batsu(Color.red,400,300,100)); 
			figs.add(new Maru(Color.red,200,200,100));
			figs.add(new Circle(Color.GREEN,150,400,100));
			figs.add(new Circle(Color.PINK,120,500,100));
			figs.add(new Rect(Color.YELLOW,240,300,30,40));
			figs.add(new Rect(Color.BLUE,260,40,80,40));
			figs.add(new Name(Color.BLACK, 650, 160, 700, 700));
			figs.add(new Picture("Koala.png",500,500));
			addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent evt) {
					sel = pick(evt.getX(), evt.getY());
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
			app.add(new R5B_2());		
			app.setSize(1500,1000);		
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
			app.setVisible(true);	
			}
		
		interface Figure {
			public void draw(Graphics g); 
			public boolean hit(int x, int y);
			public void moveTo(int x, int y); 
		}
		
		static abstract class SimpleFigure implements Figure{
			int xpos, ypos;	
			Color col;
			public SimpleFigure(int x, int y) {
				xpos = x;
				ypos = y;
			}
			
			public void moveTo(int x, int y) {
				xpos = x;
				ypos = y;
			}
			
			public abstract boolean hit(int x, int y); 
			
			public abstract void draw(Graphics g); 
		}
		
		static class Circle extends SimpleFigure  {	
			Color col;		
			int  rad; 		
			public Circle(Color c, int x, int y, int r) {
				super(x, y);
				col=c;
				rad = r;
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
		static class Picture extends SimpleFigure {	
			BufferedImage img;		
			int xpos, ypos, width, height; 		
			public Picture(String fname, int x, int y) {
				super(x, y);
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
		static class Rect extends SimpleFigure {
		
			Color col;
			int xpos,ypos,width,height;
			public Rect(Color c,int x, int y, int w, int h){
				super(x, y);
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
		static class Name extends SimpleFigure {
			int width, height;
			public Name(Color c, int x, int y, int w, int h) {
				super(x,y);
				width = w;
				height = h;
				}
			public boolean hit(int x, int y) { 
				return xpos - width / 2 <= x && x <= xpos + width / 2&& ypos - height / 2 <= y && y <= ypos + height / 2;
				}
			public void draw(Graphics g) {
				g.setColor(col);
				g.drawLine(xpos-100,ypos+0,xpos-100,ypos+50);
				g.drawLine(xpos-150,ypos+25,xpos-50,ypos+25);
				g.drawLine(xpos-150,ypos+50,xpos-50,ypos+50);
				g.drawLine(xpos-150,ypos+50,xpos-150,ypos+140);
				g.drawLine(xpos-50,ypos+50,xpos-50,ypos+140);
				g.drawLine(xpos-150,ypos+80,xpos-50,ypos+80);
				g.drawLine(xpos-150,ypos+110,xpos-50,ypos+110);
				g.drawLine(xpos-150,ypos+140,xpos-50,ypos+140);
				g.drawLine(xpos-175,ypos+160,xpos-25,ypos+160);
				g.drawLine(xpos-125,ypos+180,xpos-155,ypos+190);
				g.drawLine(xpos-75,ypos+180,xpos-45,ypos+190);
				
				g.drawLine(xpos+50,ypos+50,xpos+150,ypos+50);
				g.drawLine(xpos+115,ypos+20,xpos+100,ypos+50);
				g.drawLine(xpos+100,ypos+50,xpos+50,ypos+150);
				g.drawLine(xpos+100,ypos+50,xpos+150,ypos+150);
				g.drawLine(xpos+100,ypos+120,xpos+120,ypos+150);
				
				g.drawLine(xpos+200,ypos+50,xpos+300,ypos+50);
				g.drawLine(xpos+200,ypos+50,xpos+200,ypos+150);
				g.drawLine(xpos+200,ypos+150,xpos+300,ypos+150);
				g.drawLine(xpos+300,ypos+50,xpos+300,ypos+150);
				
				g.drawLine(xpos+400,ypos+50,xpos+500,ypos+50);
				g.drawLine(xpos+450,ypos+25,xpos+450,ypos+50);
				g.drawLine(xpos+400,ypos+50,xpos+400,ypos+70);
				g.drawLine(xpos+500,ypos+50,xpos+430,ypos+150);
				}
			}
		
	static class Maru extends SimpleFigure {
		int size;
		public Maru(Color c,int x, int y, int s) {
			super(x,y);
			size = s;
			}
		public boolean hit(int x, int y) {
			return (xpos - x) * (xpos - x) + (ypos - y) * (ypos - y) <= size* size;
			}
		public void draw(Graphics g) {
			((Graphics2D) g).setStroke(new BasicStroke(4));
			g.drawOval(xpos-size, ypos - size, 2 * size, 2 * size);
			}
		}
		static class Batsu extends SimpleFigure{
			int size;
			Color col;
			public Batsu(Color c,int x, int y, int s) {
				super(x,y);
				col=c;
				size = s;
				}
			public boolean hit(int x, int y) {
				return (xpos - x) * (xpos - x) + (ypos - y) * (ypos - y) <= size* size;
				}
			public void draw(Graphics g) {
				g.setColor(col);
				((Graphics2D) g).setStroke(new BasicStroke(4));
				g.drawLine(xpos - size, ypos - size, xpos + size, ypos + size);
				g.drawLine(xpos - size, ypos + size, xpos + size, ypos - size);
				}
			}
		}
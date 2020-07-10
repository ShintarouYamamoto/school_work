import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class R5B_3 extends JPanel {
	ArrayList<Figure> figs = new ArrayList<Figure>();
	boolean turn=true;
	public R5B_3(){
		for (int i = 0; i < 9; ++i) {
			int r = i / 3, c = i % 3;
			figs.add(new Rect(Color.red, 80 + r * 60, 40 + c * 60,30,30));
			}
		figs.add(new human("human.jpg",300, 40,0,0));
		setOpaque(false);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				Rect r = pick(evt.getX(), evt.getY());
				if (r == null) {
					return;
					}
				figs.remove(figs.size() - 1);
				if (turn) {
					figs.add(new human("human.jpg",r.getX()-20,r.getY()-20,0,0));
					figs.add(new koala("koala.png",300, 40,0,0));
					}
				else {
					figs.add(new koala("koala.png",r.getX()-20, r.getY()-20,0,0 ));
					figs.add(new human("human.jpg",300, 40,0,0));
					}
				turn = !turn;
				repaint();
				}
			});
		}
	public Rect pick(int x, int y) {
		Rect r = null;
		for (Figure f : figs) {
			if (f instanceof Rect && ((Rect) f).hit(x, y)) {
				r = (Rect) f;
				}
			}
		return r;
		}
	public void paintComponent(Graphics g) {
		for (Figure f : figs) {
			f.draw(g);
			}
		}
	public static void main(String[] args) {
		JFrame app = new JFrame();
		app.add(new R5B_3());
		app.setSize(400, 300);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		}
	interface Figure {
		public void draw(Graphics g);
		}
	static abstract class SimpleFigure implements Figure {
		int xpos, ypos;
		public SimpleFigure(int x, int y) {
			xpos = x; ypos = y;
			}
		public void moveTo(int x, int y) {
			xpos = x;
			ypos = y;
			}
		public void draw(Graphics g) {
			g.setColor(Color.BLACK);
			((Graphics2D) g).setStroke(new BasicStroke(4));
			}
		interface Figure {
			public void draw(Graphics g);
			}
		}
	static class Rect extends SimpleFigure {
		Color col;
		int width, height;
		public Rect(Color c, int x, int y, int w, int h) {
			super(x, y);
			col = c;
			width = w;
			height = h;
			}
		public boolean hit(int x, int y) {
			return xpos - width / 2 <= x && x <= xpos + width / 2 && ypos - height / 2 <= y && y <= ypos + height / 2;
			}
		public int getX() {
			return xpos;
			}
		public int getY() {
			return ypos;
			}
		public void draw(Graphics g) {
			g.setColor(col);
			g.fillRect(xpos - width / 2, ypos - height / 2, width, height);
			}
		}

	static class koala extends SimpleFigure {
		BufferedImage img;
		int width,height;
		public koala(String fname,int x,int y,int w,int h){
			super(x, y);
			try{
				img=ImageIO.read(new File(fname));
				}
			catch(Exception ex){
				} width=img.getWidth();
				height=img.getHeight();
				}
		public void draw(Graphics g) {
			int w=width/10;
			int h = height/10;
			int x=xpos-width/80,y=ypos-height/80;
			
			g.drawImage(img, x, y,w,h,null);
			}
		}
	static class human extends SimpleFigure {
		BufferedImage img;
		int width,height;
		public human(String fname,int x,int y,int w,int h){
			super(x, y);
			try{
				img=ImageIO.read(new File(fname));
				}
			catch(Exception ex){
				}
			width=img.getWidth();
			height=img.getHeight();
			}
		public void draw(Graphics g) {
			int w=width/10;
			int h = height/10;
			int x=xpos-width/80,y=ypos-height/80;
			
			g.drawImage(img, x, y,w,h,null);
			}
		}
}
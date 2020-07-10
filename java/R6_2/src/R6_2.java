import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class R6_2 extends JPanel {
	ArrayList<Figure> figs = new ArrayList<Figure>(); 
	Font fn = new Font("Serif", Font.BOLD, 36);
	Text t1 = new Text(20, 30, "Click when red", fn);
	Text t2 = new Text(20, 60, "0", fn);
	Rect r1 = new Rect(Color.gray, 230,420,500,500); 
	block[] a = new block[5];
	Rect[] b = new Rect[5];
	int count;
	public R6_2() {
		setOpaque(false); figs.add(t1);
		figs.add(t2);
		for (int i = 0; i < 5; ++i) {
			a[i] = new block(Color.GREEN, 50 + 50 * i, 180, 20);
			figs.add(a[i]);
			}
		figs.add(r1);
		for (int i = 0; i < 5; ++i) {
			b[i] = new Rect(Color.yellow, 50 +50 * i, 165, 40, 10);
			figs.add(b[i]);
			}
		count = 0;
		final long tm0 = System.currentTimeMillis();
		new javax.swing.Timer(30, new ActionListener() {
			double tmc = 1.0 + 3.0 * Math.random();
			double tm = 0.0;
			public void actionPerformed(ActionEvent evt) {
				if (tm >= 40.0) {
					return; 
					}
				tm = 0.001 * (System.currentTimeMillis() - tm0);
				if (tm >= tmc) {
					tmc = tm + (40.0 - tm) * 0.1 * Math.random();
					int i = (int) (a.length * Math.random());
					if (a[i].getColor() != Color.red) {
						a[i].setColor(Color.red); a[i].start();
						}
					}
				for (block c1 : a) {
					c1.proceed();
					}
				t1.setText(String.format("%2.2f", 40.0 - tm));
				repaint();
				} }).start(); 
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) { 
				for (block c1 : a) {
					if (c1.getColor() == Color.red && c1.hit(evt.getX(), evt.getY())) 
					{
						c1.setColor(Color.blue);
						++count;
						t2.setText(String.format("%d", count));
						}
					}
				}
			}
		);
		}
	public void paintComponent(Graphics g) {
		for (Figure f : figs) {
			f.draw(g);
			}
		}
	public static void main(String[] args) {
		JFrame app = new JFrame();
		app.add(new R6_2());
		app.setSize(500, 500);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		}
	interface Figure {
		public void draw(Graphics g);
		}
	static class Circle implements Figure {
		Color col;
		int xpos, ypos, rad;
		public Circle(Color c, int x, int y, int r) {
			col = c; xpos = x; ypos = y; rad = r;
			}
		public boolean hit(int x, int y) {
			return (xpos - x) * (xpos - x) + (ypos - y) * (ypos - y) <= rad * rad;
			}
		public void setColor(Color c) {
			col = c;
			}
		public void moveTo(int x, int y) {
			xpos = x; ypos = y; 
			}
		public void draw(Graphics g) {
			g.setColor(col);
			g.fillOval(xpos - rad, ypos - rad, rad * 2, rad * 2);
			g.fillRect(xpos - rad, ypos + rad-20, 40, 80);
			g.setColor(Color.WHITE);
			g.fillOval(xpos-15, ypos-15, 30, 15);
			g.setColor(Color.black);
			g.fillOval(xpos-6, ypos-15, 14, 10);
			
			}
		}
	static class block extends Circle {
		int ybase, mcount;
		public block(Color c, int x, int y, int r) {
			super(c, x, y, r);
			ybase = y;
			mcount = 0;
			}
		public Color getColor() {
			return col;
			}
		public void start() {
			mcount = 20;
			}
		public void proceed() {
			if (mcount <= 0) {
				return; } mcount -= 1;
				ypos = ybase - 100 + Math.abs(mcount - 10) * 10;
				if (mcount == 0) {
					col = Color.BLUE;
					}
				}
		}
	static class Rect implements Figure{
		Color col;
		int xpos, ypos, width, height;
		public Rect(Color c, int x, int y, int w, int h) {
			col = c; xpos = x; ypos = y; width = w; height = h;
			}
		public void draw(Graphics g) {
			g.setColor(col);
			g.fillRect(xpos - width / 2, ypos - height / 2, width, height);
			}
		}
	static class Text implements Figure {
		int xpos, ypos; String txt;
		Font fn;
		public Text(int x, int y, String t, Font f) {
			xpos = x;
			ypos = y;
			txt = t;
			fn = f;
			}
		public void setText(String t) {
			txt = t;
			}
		public void draw(Graphics g) {
			g.setColor(Color.BLACK);
			g.setFont(fn);
			g.drawString(txt, xpos, ypos);
			}
		}
	}

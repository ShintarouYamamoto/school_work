import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class R6_1 extends JPanel {
	ArrayList<Figure> figs = new ArrayList<Figure>();
	Circle c1 = new Circle(Color.green, 100, 100, 30);
	int x=50,y=30,dx=5,dy=10;
	public R6_1(){
		setOpaque(false);
		figs.add(c1);
		new javax.swing.Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (x > getWidth()) {
					dx = -dx;
					c1.setColor(Color.WHITE);
				}
				if(x<0){
					dx=-dx;
					c1.setColor(Color.BLACK);
				}
				if(y<0){
					dy=-dy;
					c1.setColor(Color.PINK);
				}
				if(y>getHeight()){
					dy=-dy;
					c1.setColor(Color.RED);
				}
				x=x+dx;
				y=y+dy;
				c1.moveTo(x,y);
				repaint();
			}
		}).start();
	}
		
		public void paintComponent(Graphics g) {
			for (Figure f : figs) {
				f.draw(g);
			}
		}
		
		public static void main(String[] args) {
			JFrame app = new JFrame();
			app.add(new R6_1());
			app.setSize(400, 300);
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
				col = c;
				xpos = x;
				ypos = y;
				rad = r;
			}
			public boolean hit(int x, int y) {
				return (xpos - x) * (xpos - x) + (ypos - y) * (ypos - y) <= rad
						* rad;
			}
			public void setColor(Color c) {
				col = c;
			}
			public void moveTo(int x, int y) {
				xpos = x;
				ypos = y;
			}
			public void draw(Graphics g) {
				g.setColor(col);
				g.fillOval(xpos - rad, ypos - rad, rad * 2, rad * 2);
			}
		}
}
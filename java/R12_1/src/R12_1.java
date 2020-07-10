import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class R12_1 extends JPanel {
	ArrayList<Figure> figs = new ArrayList<Figure>();
	int x=50,y=300,m=0,dx=(int)(5*Math.random()),dy=(int)(5*Math.random()); 
	
	Circle[] a = new Circle[100000];

	public R12_1(){
		
		setOpaque(false);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt){
				int i=evt.getClickCount();
				Circle c2 = new Circle(Color.green, 100, 100, 30);
				a[i] = new Circle(Color.BLUE, evt.getX(),evt.getY(), 20);
				figs.add(a[i]);
				figs.add(c2);
			}
			});
	
		
		new javax.swing.Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (x > getWidth()) {
					dx = -dx;
				}
				if(x<0){
					dx=-dx;
				}
				if(y<0){
					dy=-dy;
				}
				if(y>getHeight()){
					dy=-dy;
				}
				
				x=x+dx;
				y=y+dy;
				c2.moveTo(x,y);
				a[i].moveTo(x,y);
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
			app.add(new R12_1());
			app.setSize(800, 800);
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app.setVisible(true);
		}
		
		interface Figure {
			public void draw(Graphics g);
			public void moveTo(int x, int y); 
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
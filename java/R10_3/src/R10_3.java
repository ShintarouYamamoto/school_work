import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class R10_3 extends JFrame {
	ArrayList<Figure> figs = new ArrayList<Figure>();
	Figure sel = null;
	Triangle a1=new Triangle(Color.red,300,300,240);
	Rect a2=new Rect(Color.blue,200,200,200,200);
	gokaku a3 =new gokaku(Color.green,50);
	
	public R10_3() {
		
		JMenuBar mbar = new JMenuBar();
		setJMenuBar(mbar);
		JMenu m1 = new JMenu("File");
		mbar.add(m1);	
		JMenuItem i1 = new JMenuItem("プログラムの終了");
		m1.add(i1);
		
		JMenu m2 = new JMenu("形状");
		mbar.add(m2);
		JMenuItem i2 = new JMenuItem("三角");
		JMenuItem i3 = new JMenuItem("四角");
		JMenuItem i4 = new JMenuItem("五角");
		m2.add(i2);
		m2.add(i3);
		m2.add(i4);
		
		JMenu m3 = new JMenu("大きさ");
		mbar.add(m3);
		JMenuItem i5 = new JMenuItem("大");
		JMenuItem i6 = new JMenuItem("中");
		JMenuItem i7 = new JMenuItem("小");
		m3.add(i5);
		m3.add(i6);
		m3.add(i7);
		
		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
				}
			});
		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				figs.add(a1);
				sel=a1;
				repaint();
				}
			});
		i3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				figs.add(a2);
				sel=a2;
				repaint();
				}
			});
		i4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				figs.add(a3);
				sel=a3;
				repaint();
				repaint();
				}
			});
		i5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sel.setScale(300);
				repaint();
				}
			});
		i6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sel.setScale(100);
				repaint();
				}
			});
		i7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sel.setScale(20);
				repaint();
				}
			});
		JTabbedPane tabs = new JTabbedPane();
		add(tabs);
		tabs.add("field", new JPanel() {
			public void paintComponent(Graphics g) {
				setOpaque(false);
				for (Figure f : figs) {
					f.draw(g);
				}
				}		
			});
		}
	interface Figure {
		public void draw(Graphics g); 
		public void setScale(int ds);
	}
	static class Triangle implements Figure{
		Color col;
		int[] xs,ys;
		int x0,y0,x1,y1,x2,y2,a,gx,gy;
		double h;
		double l;
		
		
	public Triangle(Color c,int g1,int g2,int h1){
			col=c; gx=g1; gy=g2; h=h1;
			
			l=2*(h/Math.sqrt(3));
			
			x0=gx;
			y0=(int)((double)gy-h*2/3);
			
			x1=(int)(gx-(double)l*1/2);
			y1=(int)((double)gy+h*1/3);
			
			x2=(int)(gx+(double)l*1/2);
			y2=y1;
			
			xs=new int[]{x0,x1,x2}; ys=new int[]{y0,y1,y2};
		}
	public void setScale(int ds){
		h=ds;
	}
	public void draw(Graphics g){
		l=2*(h/Math.sqrt(3));
		x0=gx;
		y0=(int)((double)gy-h*2/3);
		x1=(int)(gx-(double)l*1/2);
		y1=(int)((double)gy+h*1/3);
		x2=(int)(gx+(double)l*1/2);
		y2=y1;
		xs=new int[]{x0,x1,x2}; ys=new int[]{y0,y1,y2};
		
		g.setColor(col);
		g.fillPolygon(xs,ys,3);
		}
	}

	static class Rect implements Figure {
		
		Color col;
		int xpos,ypos,width,height;
		
		
		public Rect(Color c,int x, int y, int w, int h){
			col=c; xpos=x; ypos=y; width=w; height=h;
		}
		
		public void setColor(Color c){
			col=c;
		}
		public void setScale(int ds){
			width=ds; height=ds;
		}
		
		public void draw(Graphics g) {
			g.setColor(col);
			g.fillRect(xpos-width/2, ypos-height/2, width, height);
		}
	}
	
	static class gokaku implements Figure{
		Color col;
		int r;
		int[] x= new int[5];
		int[] y= new int[5];
		double s=2*Math.PI/5;
	public gokaku(Color c,int g){
		col=c;
		r=g;
		for(int  i=0; i<5; i++){
			x[i]=(int)(r*Math.sin(i*s))+300;
			y[i]=(int)(r*Math.cos(i*s))+400;
		}
		
	}
	public void setScale(int ds){
		r=ds;
		
	}
	public void draw(Graphics g){
		for(int  i=0; i<5; i++){
			x[i]=(int)(r*Math.sin(i*s))+300;
			y[i]=(int)(r*Math.cos(i*s))+400;
		}
		g.setColor(col);
		g.fillPolygon(x,y,5);
		}
	}
	public static void main(String args[]) {		
		JFrame app = new R10_3();	
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		app.setPreferredSize(new Dimension(1500,1000));	
		app.pack();
		app.setVisible(true);
		}
}
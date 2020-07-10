import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class R9_1 extends JPanel {
  ArrayList<Figure> figs = new ArrayList<Figure>(); 
  ArrayList<Animation> anim = new ArrayList<Animation>(); 
  
  public R9_1() { 
  Color col1 = Color.RED, col2 = Color.PINK; 
  Circle c1 = new Circle(col1, 100, 400, 1); 
  int s1=1,s2=150;
  figs.add(c1);  
  anim.add(new LinearMove(c1, 1, 100, 400, 5, 300, 60));  
  anim.add(new ColorTrans(c1, 1, col1, 5, col2));  
  anim.add(new ScaleTrans(c1, 1, s1, 5, s2)); 
  setOpaque(false); 
  final long tm0 = System.currentTimeMillis();
  new javax.swing.Timer(30, new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    float tm = 0.001f * (System.currentTimeMillis() - tm0);  
    for (Animation a : anim) {  
      a.setTime(tm);  
      }  
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
  app.add(new R9_1()); 
  app.setSize(500, 500); 
  app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  app.setVisible(true);
  }
  
  interface Figure { 
  public void draw(Graphics g);  
  public void moveTo(float x, float y); 
  public void setColor(Color c);
  public void setScale(float ds);
  }
  
  interface Animation { 
  public void setTime(float dt); 
  }
  
  static abstract class SimpleFigure implements Figure { 
  Color col;  
  float xpos, ypos;  
  public SimpleFigure(Color c, float x, float y) { 
    col = c;  
    xpos = x;  
    ypos = y;  
    }  
  public void moveTo(float x, float y) { 
    xpos = x;  
    ypos = y;  
    }  
  public void setColor(Color c) {  
    col = c; 
    }  
  public void draw(Graphics g) {  
    g.setColor(col); 
    } 
  }
  
  static class Circle extends SimpleFigure { 
  float rad;  
  public Circle(Color c, float x, float y, float r) { 
    super(c, x, y);  
    rad = r; 
    }  
  public void draw(Graphics g) {  
    int x = (int) (xpos - rad), y = (int) (ypos - rad);  
    super.draw(g);  
    g.fillOval(x, y, (int) rad * 2, (int) rad * 2); 
    } 
  public void setScale(float ds){
    rad=ds;
  }
  

  
  static class LinearMove implements Animation { 
  Figure fig; 
  float time1, xpos1, ypos1, time2, xpos2, ypos2; 
  public LinearMove(Figure f, float t1, float x1, float y1, float t2, 
    float x2, float y2) {  
    time1 = t1;  
    xpos1 = x1; 
    ypos1 = y1;  
    time2 = t2;  
    xpos2 = x2;  
    ypos2 = y2;  
    fig = f;  
    }  
  public void setTime(float t) {  
  if (t < time1 || time2 < t) {  
    return;  
    }  
    float p = (time2 - t) / (time2 - time1), q = 1.0f - p; 
    fig.moveTo(p * xpos1 + q * xpos2, p * ypos1 + q * ypos2); 
    } 
  }
  
  static class ColorTrans implements Animation { 
  Figure fig;  
  float time1, time2; 
  int r1, g1, b1, a1, r2, g2, b2, a2;  
  public ColorTrans(Figure f, float t1, Color c1, float t2, Color c2) { 
    fig = f;  
    time1 = t1; 
    time2 = t2;  
    r1 = c1.getRed();
    g1 = c1.getGreen();
    b1 = c1.getBlue();  
    a1 = c1.getAlpha();
    r2 = c2.getRed();  
    g2 = c2.getGreen();  
    b2 = c2.getBlue();  
    a2 = c2.getAlpha();  
    }  
  public void setTime(float t) {  
  if (t < time1 || time2 < t) {  
    return;  
    }  
    float p = (time2 - t) / (time2 - time1), q = 1.0f - p;  
    fig.setColor(new Color((int) (p * r1 + q * r2), (int) (p * g1 + q 
      * g2), (int) (p * b1 + q * b2), (int) (p * a1 + q * a2))); 
    } 
  }
    static class ScaleTrans implements Animation{
	  Figure fig;  
	  float time1, time2,scale1,scale2; 
	  
	  public ScaleTrans(Figure f, float t1, float ss1, float t2, float ss2){
	    fig=f;
	    time1=t1;
	    time2=t2;
	    scale1=ss1;
	    scale2=ss2;
	    
	  }
	  public void setTime(float t) {
	  if (t < time1 || time2 < t) {
	    return;
	    }
	    float p = (time2 - t) / (time2 - time1), q = 1.0f - p;  
	    fig.setScale((p * scale1) + (q * scale2));
	    } 
	  }
  }

}
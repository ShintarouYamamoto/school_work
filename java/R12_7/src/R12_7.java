import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
	public class R12_7 extends JFrame{
		
		public R12_7() {
			
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					if(evt.getKeyChar() == '0'){
						Clip clip = createClip(new File("0.wav"));
						clip.start();
					} 
					if(evt.getKeyChar() == '1' ){
						Clip clip = createClip(new File("1.wav"));
						clip.start();
					} 
					if(evt.getKeyChar() == '2'){
						Clip clip = createClip(new File("2.wav"));
						clip.start();
					}
					if(evt.getKeyChar() == '3'){
						Clip clip = createClip(new File("3.wav"));
						clip.start();
					}
					if(evt.getKeyChar() == '4'){
						Clip clip = createClip(new File("4.wav"));
						clip.start();
					}
					if(evt.getKeyChar() == '5'){
						Clip clip = createClip(new File("5.wav"));
						clip.start();
					}
					if(evt.getKeyChar() == '6'){
						Clip clip = createClip(new File("6.wav"));
						clip.start();
					}
					if(evt.getKeyChar() == '7'){
						Clip clip = createClip(new File("7.wav"));
						clip.start();
					}
					if(evt.getKeyChar() == '8'){
						Clip clip = createClip(new File("8.wav"));
						clip.start();
					}
					if(evt.getKeyChar() == '9'){
						Clip clip = createClip(new File("9.wav"));
						clip.start();
					}
				}
				});
		}

		public static void main(String args[]) {
			JFrame app = new R12_7();
			app.setDefaultCloseOperation(EXIT_ON_CLOSE);
			app.setPreferredSize(new Dimension(400, 200));
			app.pack();
			app.setVisible(true);
			}
		public static Clip createClip(File path) {
			try (AudioInputStream ais = AudioSystem.getAudioInputStream(path)){
				AudioFormat af = ais.getFormat();
				DataLine.Info dataLine = new DataLine.Info(Clip.class,af);
				Clip a = (Clip)AudioSystem.getLine(dataLine);
				a.open(ais);
				
				return a;
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

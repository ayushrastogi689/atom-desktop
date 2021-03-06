package me.atom.windowsj;

import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 * Atom.java created by Guillaume Cendre (aka chlkbumper)
 *
 *  Atom's main class. Checks either the required directory (AppData/Atom) exists
 *  or not. If it doesn't, it creates it. It also initializes the user interface.
 */	


public class Atom {
	
	static DialogWindow window;
	static int screenHeight;
	static int screenWidth;
	
	public static void main(String[] args) throws IOException, FontFormatException, InterruptedException {
		
		String appDataPath = System.getenv("APPDATA");
		File audioDirectory = new File(appDataPath + "\\Atom");
		
		if (!audioDirectory.exists()) {
			try {
				if(audioDirectory.mkdir()) {
				} else {
				}
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
		
		startAtom();
		
	}
	
		public static void startAtom() throws IOException, FontFormatException, InterruptedException {
			String appDataPath = System.getenv("APPDATA");
			System.out.println(appDataPath);
		try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		e.printStackTrace();
		}
				
		Image icon = Toolkit.getDefaultToolkit().getImage("images/iconsmall.png");
		window = new DialogWindow();
		window.setIconImage(icon);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int)screenSize.getWidth();
        screenHeight = (int)screenSize.getHeight();
        int x = (int) (screenWidth - (screenWidth/3.5));
        
        window.setLocation(x, 10);
        window.setSize(new Dimension((int) (screenWidth/3.5)-10,(int) (screenHeight-45)));        
        window.setAlwaysOnTop(true);
		
	}	
		
}		
		
		
package life;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Abiogenesis implements Runnable{
	private static final int WIN_H = 700;
	private static final int WIN_W = 700;
	private static final Dimension WIN_S = new Dimension(WIN_W, WIN_H);
	private static final Color ALIVE = new Color(0,255,0);
	private static final Color DEAD = new Color(0,0,0);
	private MainPanel panel;
	private BufferedImage buffer;
	private long generations = 50;
	private long currentGen = 0;
	private static final int CELL_X = WIN_W / 2;
	private static final int CELL_Y = WIN_H / 2;
	private static boolean[][] cells = new boolean[CELL_X][CELL_Y];
	private String birth;
	private String survival;
	private static final int refreshperiod = 50;
	
	public Abiogenesis(String birth, String survival, long generations){
		if (generations > 0) this.generations = generations;
		this.birth = birth;
		this.survival = survival;
		
		for (int x = 0; x < CELL_X; x++){
			for (int y = 0; y < CELL_Y; y++){
				cells[x][y] = false;
			}
		}
		
		LifeMaker.addDRGlider(cells, 10, 10);
		
		LifeMaker.addULGlider(cells, 70, 70);
		
		LifeMaker.addBeacon(cells, 55, 55);
		
		LifeMaker.addLightweightSpaceShip(cells, 200, 100);
		
		LifeMaker.addLoafer(cells, 300, 100);
		
		// Acorn: 5206 generation, 633 cells, 13 gliders
//		cells[175][175] = true;
//		cells[173][174] = true;
//		cells[172][176] = true;
//		cells[173][176] = true;
//		cells[176][176] = true;
//		cells[177][176] = true;
//		cells[178][176] = true;
		
		// Gosper glider gun
		LifeMaker.addGosperGliderGun(cells, 70, 100);
		
		LifeMaker.addVerticalPentadecathlon(cells, 200, 230);
		LifeMaker.addVerticalToad(cells, 208, 234);
		LifeMaker.addVerticalPentadecathlon(cells, 215, 230);
		
		
		panel = new MainPanel();
		panel.setSize(WIN_S);
		
		JFrame frame = new JFrame("Conway's Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		//frame.setContentPane(panel);
		frame.setResizable(false);
		frame.setSize(WIN_W, WIN_H);
		frame.setLocation(50,50);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		// Conway's Game of life	B3/S23
		// HalfLife					B36/S23
		// Seeds					B3/S
		// No name					B25/S4
		// Life Without Death		B3/S012345678
		// 34 Life					B34/S34
		// Diamoeba					B35678/S5678
		// Explosive 1				B17/S78
		// Explosive 2				B145/S34
		// The Crash				B367/S2357
		// Bowtie Oblivion			B367/S235
		
		Thread t = new Thread(new Abiogenesis("3", "23", 1000));
		t.start();
	}
	
	public void run(){
		//long i = 0;
		while (true){
			try {
				Thread.sleep(refreshperiod);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			panel.repaint();
			nextGeneration();
			currentGen++;
			//i++;
		}
	}
	
	private void nextGeneration(){
		boolean[][] cells2 = new boolean[CELL_X][CELL_Y];
		for (int x = 0; x < CELL_X; x++){
			for (int y = 0; y < CELL_Y; y++){
				cells2[x][y] = checkRules(x,y);
			}
		}
		cells = cells2;
	}
	
	private boolean checkRules(int x, int y){
		boolean b = cells[x][y];
		int n = neighborCount(x,y);
//		if (n > 0){
//			System.out.println("Cell " + x + "," + y + " has " + n + " neighbors.");
//		}
		String c = String.valueOf(n);
		if (b){	// If cell is alive, check survival
			if (survival.contains(c)){
				return b;
			} else {
				return !b;
			}
		} else {			// If cell is dead, check birth
			if (birth.contains(c)){
				return !b;
			} else {
				return b;
			}
		}
	}
	
	private int neighborCount(int x, int y){
		int c = 0;
		for (int x2 = x - 1; x2 < x + 2; x2++){
			for (int y2 = y - 1; y2 < y + 2; y2++){
				if ((x2 > -1 && x2 < CELL_X) &&
					(y2 > -1 && y2 < CELL_Y) &&
					!(x2 == x && y2 == y)){
					c += cells[x2][y2] ? 1 : 0;
				}
			}
		}
		return c;
	}
	
	private BufferedImage drawBuffer(){
		buffer = new BufferedImage(WIN_W, WIN_H, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffer.createGraphics();
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHints(rh);
		
		g.setColor(DEAD);
		g.fillRect(0, 0, WIN_W, WIN_H);
		
		for (int x = 0; x < CELL_X; x++){
			for (int y = 0; y < CELL_Y; y++){
				if (cells[x][y]) {
					g.setColor(ALIVE);
				} else {
					g.setColor(DEAD);
				}
				g.fillRect(x*2, y*2, 2, 2);
			}
		}
		
		if (currentGen > generations){
			g.setColor(new Color(255,0,0));
		} else {
			g.setColor(new Color(0,255,150));
		}
		g.drawString(String.valueOf(currentGen), 5, 15);
		
		
		return buffer;
	}
	
	private class MainPanel extends JPanel{
		private static final long serialVersionUID = 1L;
		
		@Override
		public void paint(Graphics g){
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(drawBuffer(),0,0,this);
		}
	}
}

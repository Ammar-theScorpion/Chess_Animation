package com.chess.chessAnimation;

import java.awt.Color;
import java.awt.Graphics;

public class Sanimation {

	private final int WIDTH = 30;
	private final int HEIGHT = 15;
	private int GAP = 15;
	public void render(Graphics g)
	{
		g.setColor(Color.BLACK);
		for (int i = 0; i < 64; i++) {
			g.fillRect((( GAP*2) +(((int)(i/8))%2!=0 ? WIDTH/2 :15*i ) + (WIDTH*2 )*(i%8)) , HEIGHT*(int)(i/8) ,WIDTH,HEIGHT);
			
		}
		 
	}
	public void tick()
	{
		
	}
}

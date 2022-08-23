package com.chess.chessAnimation;

 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.chess.chessAnimation.display.Display;
 
 
 

public class Player implements Runnable{
	private final static int WIDTH = 600,
							 HEIGHT = 500;
	private boolean running;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private Display display;
	private Thread thread;
	private Chess chess;
	int count = 0;
	Sanimation s;
 
	 
	
	public Player()
	{
		display = new Display(WIDTH, HEIGHT);
		chess = new Chess();
		s = new Sanimation();
	}
	public void render()
	{
		 
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {display.getCanvas().createBufferStrategy(3);return;}
		g = bs.getDrawGraphics();
		 
		//////////
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
 		chess.render(g);
//		s.render(g);
 
		
		//
		bs.show();
		g.dispose();
	}
	@Override
	public void run()
	{
		 int fps =  60;
	        double timePerTick = 1000000000 / fps;
	        double dalta = 0;
	        long now;
	        long lastTime = System.nanoTime();
	        int counter = 0;
	        long Counter =0;
	        while(running)
	        {
	            now = System.nanoTime();
	            dalta += (now - lastTime) / timePerTick;
	            Counter+=now-lastTime;
	            lastTime = now;
	            if(dalta >=1)
	            {
	                  
	                    render();
	                     
	                dalta--;
	                counter++;
	                 
	             }
//	            if(Counter>=838000000)
//	            {
//	            	chess.START = false;
//	            }
	            if(Counter>=1650000000)
	            {
	             
	            	System.err.println(counter);
	            	Counter = 0;
	            	counter = 0;
	            	tick();
	            }
 	  
	        }
	         
	}
	
	private void tick() {
		 
 		chess.tick();
	}
	
	public synchronized void start()
	{
		if(running)return;
		thread = new Thread(this);
		running = true;
		thread.start();
	}
	public synchronized void stop() throws InterruptedException
	{
		if(!running)return;
		thread.join();
		running = false;
	}
	
	
	
}

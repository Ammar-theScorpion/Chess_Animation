package com.chess.chessAnimation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

public class Chess {
	private final static int WIDTH = 50;
	private final static int HEIGHT = 50;
	private final static int END = 450;
	private final static int GAP = 15;
	public boolean START = true;
	Color color = Color.BLACK;
	private double angle = 0;
	boolean rotate = false;
	public void render(Graphics g)
	{ 
//		Graphics2D gg = (Graphics2D) g.create();
// 		gg.setColor(Color.BLACK);
 		 for (int i = 0; i < 32; i++) {
 			if(START)
				 angle+=0.0005;
 			Graphics2D gg = (Graphics2D) g.create();
 			Graphics2D gg2 = (Graphics2D) g.create();
 	
 			 if(rotate)
 			 {
 				 if(i==0) {
 					 g.setColor(Color.WHITE);
 					 g.fillRect(50+GAP*2, 50, 400, 400);}
 				 gg.rotate(angle,  ((50+GAP*2+(((int)(i/4))%2!=0 ? WIDTH:0) + (WIDTH*2 )*(i%4))  +WIDTH/2)   ,  50+50*(int)(i/4) +25   );
 				gg.setColor(Color.black);
 	 			gg.fillRect(((50+GAP*2) +(((int)(i/4))%2!=0 ? WIDTH:0) + (WIDTH*2 )*(i%4))  
 	 					, 50+50*(int)(i/4)  
 	 					, WIDTH, HEIGHT );
 			 
 				 
 			 }
 			 else {
  				// gg.setColor(Color.BLACK);
  				 //gg.fillRect(50, 100, 500, 500);
 				 if(i==0) {
 					 g.setColor(Color.black);
 					 g.fillRect(50+GAP*2, 50, 400, 400);}
  				 gg2.rotate(-angle,  (((50 +GAP*2) +(((int)(i/4))%2==0 ? WIDTH:0) + (WIDTH*2 )*(i%4))  +WIDTH/2)   ,  50+50*(int)(i/4) +25   );
  				 gg2.setColor(Color.WHITE);
  				 gg2.fillRect(((50+GAP*2) +(((int)(i/4))%2==0 ? WIDTH:0) + (WIDTH*2 )*(i%4))  
  						 , 50+50*(int)(i/4)  
  						 , WIDTH, HEIGHT );
 		 
 				 
 	
 				 
 			 }
 			 
 		 
 			
 			 }
 			  
 		
 	 

// 
//		for (int i = 1; i <= 2; i++) {
//			
//		 double x =100;// Math.cos(angle/57.2957795)+100*i;
//		 double y = 100;//Math.sin(angle/57.2957795)+100;
//		 gg.rotate(angle,  x*i, y);
//		 gg.fillRect((int)x, (int)y, WIDTH, HEIGHT);	
//		 
//		 
//		 Rectangle2D myRect = new Rectangle2D.Double(100, 100, 100, 100);
//		 AffineTransform at = AffineTransform.getRotateInstance(angle/57.2957, 50, 50);
//		 Shape rotatedRect = at.createTransformedShape(myRect);
//		 
//		 gg.draw(rotatedRect);
		//}	
//		 for (int i = 0; i < 32; i++) {
			 
//			 
//			 double x = Math.cos(angle/57.2957795) ;
//			 double y = Math.sin(angle/57.2957795)  ;
//			 angle+=0.0005;
// 			 x*=START+GAP*2+(( (1/4))%2!=0 ? WIDTH:0) + (WIDTH*2 )* x;
//  			 y *= 50+50*(int)(1/4) ;
//  		 for (int i = 1; i <= 2; i++) {
//  			Graphics2D gg = (Graphics2D) g.create();
//  			gg.setColor(Color.BLACK);
//  			 angle+=0.005;
//			 gg.rotate(angle,  ((50*i)+WIDTH/2)   ,  ((50*i) + 25) );
//	  			 
// 			 
// 			 
// 			 gg.fillRect((int)(50*i), (int)(50*i) , WIDTH, HEIGHT );
// 			 
// 		 
//  		 }	
 
 			 
// 		 }	 
 			
  	
	}
	 

		 
	public void tick() {
		 START = true;
		rotate = !rotate;
	}
}

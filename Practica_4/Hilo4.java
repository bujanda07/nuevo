import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;

class Hilo4 implements Runnable{

	Enemigo enemigo4;
	public Hilo4(Enemigo enemigo4){
		this.enemigo4=enemigo4;
	}

	@Override
	public void run()
	{
		while(true)
		{
			
			for(int y=300;y<750;y=y+5)
			{
				this.enemigo4.setLocation(630,y);
				retardo(20);

			 }
					for(int y=750;y>299;y=y-5)
					{
						this.enemigo4.setLocation(630,y);
						retardo(20);
					}
			

		}
	}
	public void retardo(int ms)
 {
  try
  {
  	Thread.sleep(ms);
  	}catch(Exception e){
   			System.out.println("Error al ejecutar el sleep");
  		}
 }

	
	
}
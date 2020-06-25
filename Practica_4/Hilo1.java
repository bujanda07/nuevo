import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;

class Hilo1 implements Runnable{

	Enemigo enemigo;
	public Hilo1(Enemigo enemigo){
		this.enemigo=enemigo;
	}

	@Override
	public void run()
	{
		while(true)
		{
			
			for(int y=300;y<750;y=y+5)
			{
				this.enemigo.setLocation(250,y);
				retardo(50);

			 }
					for(int y=750;y>299;y=y-5)
					{
						this.enemigo.setLocation(250,y);
						retardo(50);
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
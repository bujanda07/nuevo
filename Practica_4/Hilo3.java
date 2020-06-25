import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;

class Hilo3 implements Runnable{

	Enemigo enemigo3;
	public Hilo3(Enemigo enemigo3){
		this.enemigo3=enemigo3;
	}

	@Override
	public void run()
	{
		while(true)
		{
			
			for(int y=300;y<750;y=y+5)
			{
				this.enemigo3.setLocation(377,y);
				retardo(25);

			 }
					for(int y=750;y>299;y=y-5)
					{
						this.enemigo3.setLocation(377,y);
						retardo(25);
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
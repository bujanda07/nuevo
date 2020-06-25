import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;

class Hilo2 implements Runnable{

	Enemigo enemigo2;
	public Hilo2(Enemigo enemigo2){
		this.enemigo2=enemigo2;
	}

	@Override
	public void run()
	{
		while(true)
		{
			
			for(int y=300;y<750;y=y+5)
			{
				this.enemigo2.setLocation(728,y);
				retardo(18);

			 }
					for(int y=750;y>299;y=y-5)
					{
						this.enemigo2.setLocation(728,y);
						retardo(18);
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;

class Hilo5 implements Runnable{

	Enemigo2 enemigoz;
	public Hilo5(Enemigo2 enemigoz){
		this.enemigoz=enemigoz;
	}

	@Override
	public void run()
	{
		while(true)
		{
			
			for(int x=250;x<728;x=x+5)
			{
				this.enemigoz.setLocation(x,280);
				retardo(50);

			 }
					for(int x=728;x>249;x=x-5)
					{
						this.enemigoz.setLocation(x,280);
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
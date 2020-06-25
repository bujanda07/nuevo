import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;

class Hilo8 implements Runnable{

	Enemigo2 enemigoz4;
	public Hilo8(Enemigo2 enemigoz4){
		this.enemigoz4=enemigoz4;
	}

	@Override
	public void run()
	{
		while(true)
		{
			
			for(int x=250;x<728;x=x+5)
			{
				this.enemigoz4.setLocation(x,750);
				retardo(20);

			 }
					for(int x=728;x>249;x=x-5)
					{
						this.enemigoz4.setLocation(x,750);
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;


class Hilo9 implements Runnable{

	Comida comida_1;
	
	public Hilo9(Comida comida_1)
	{
		this.comida_1=comida_1;
		
	}
	@Override
	public void run()
	{
					int x;
					x= (int)(Math.random()*(758-256+1)+256);
					int y;
					y=(int)(Math.random()*(850-190+1)+190);

					this.comida_1.setLocation(x,y);

	}
	

	
}
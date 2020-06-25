import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
class Comida extends JPanel{
	
	BufferedImage imagen4;
	Image subimagen;

	public Comida()
	{
		try{
			imagen4=ImageIO.read(new File("./imagenes/comida.png"));

		}catch(IOException e){
			e.printStackTrace();
		}

		subimagen=imagen4.getSubimage(0,0,23,16);
		//this.imagen2=imagen2;
		this.setVisible(true);
		this.setLayout(null);
	}
	public void paintComponent(Graphics g){

		super.paintComponent(g);
		g.drawImage(subimagen,0,0,23,16,null);
	}
}
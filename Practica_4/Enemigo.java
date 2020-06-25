import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;

class Enemigo extends JPanel{

	BufferedImage imagen3;
	Image subimagen;

	public Enemigo()
	{
		try{
			imagen3=ImageIO.read(new File("./imagenes/enemigo.png"));

		}catch(IOException e){
			e.printStackTrace();
		}

		subimagen=imagen3.getSubimage(0,0,20,18);
		//this.imagen2=imagen2;
		this.setVisible(true);
		this.setLayout(null);
	}
	public void paintComponent(Graphics g){

		super.paintComponent(g);
		g.drawImage(subimagen,0,0,20,18,null);
	}
}
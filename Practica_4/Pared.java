import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;



class Pared extends JPanel{

	BufferedImage imagen2;
	Image subimagen;
	public Pared ()
	{

		try{
			imagen2=ImageIO.read(new File("./imagenes/pared.png"));
		}
		catch(IOException e){
			e.printStackTrace();
		}

		subimagen=imagen2.getSubimage(0,0,512,46);
		//this.imagen2=imagen2;
		this.setVisible(true);
		this.setLayout(null);
		
	}


	public void paintComponent(Graphics g){

		super.paintComponent(g);
		g.drawImage(subimagen,0,0,512,46,null);
	}
	
}
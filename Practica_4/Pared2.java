import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;



class Pared2 extends JPanel{

	BufferedImage imagen3;
	Image subimagen;
	public Pared2 ()
	{

		try{
			imagen3=ImageIO.read(new File("./imagenes/pared2.png"));
		}
		catch(IOException e){
			e.printStackTrace();
		}

		subimagen=imagen3.getSubimage(0,0,46,512);
		//this.imagen2=imagen2;
		this.setVisible(true);
		this.setLayout(null);
		
	}


	public void paintComponent(Graphics g){

		super.paintComponent(g);
		g.drawImage(subimagen,0,0,46,512,null);
	}
	
}
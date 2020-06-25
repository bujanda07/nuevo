import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class Monito extends JPanel{

	BufferedImage imagen;
	

	public Monito(BufferedImage imagen)
	{
		this.imagen = imagen;
		this.setBounds(0,0,64,64);
	}

	@Override
	public void paintComponent(Graphics g){

		super.paintComponent(g);
		this.setLayout(null);


		
		//g.drawRect(0,65,65,65);
		g.setColor(Color.BLUE);
		g.fillRect(0,0,64,64);
		g.drawImage(imagen,0,0,64,64,null);
	}




}
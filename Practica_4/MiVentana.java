import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import javax.sound.midi.*;

class MiVentana extends JFrame implements KeyListener{

	BufferedImage imagen;
	BufferedImage subImagen;

	Pared pared;
	Pared pared2;

	Enemigo enemigo;
	Thread hilo1;
	Enemigo enemigo2;
	Thread hilo2;
	Enemigo enemigo3;
	Thread hilo3;
	Enemigo enemigo4;
	Thread hilo4;

	Enemigo2 enemigoz;
	Thread hilo5;
	Enemigo2 enemigoz2;
	Thread hilo6;
	Enemigo2 enemigoz3;
	Thread hilo7;
	Enemigo2 enemigoz4;
	Thread hilo8;

	Thread hilo9;

	Comida comida_1;

	Pared2 pared_1;
	Pared2 pared_2;
	Pared2 pared_3;
	Pared2 pared_4;

	MiReproductor mr;

	
	
	JPanel panel;

	Monito monito;
	int indiceX=0;


	public MiVentana()
	{

		try{
			imagen = ImageIO.read(new File("./imagenes/professor_walk.png"));

		}catch(Exception e)
		{
			System.out.println("Error al cargar la imagen");
		}

		subImagen = imagen.getSubimage(0,64*3,64,64);
		monito = new Monito(subImagen);
		monito.setBounds(500,190,64,64);

		pared= new Pared();
		pared.setBounds(246,144,512,46);
		pared2=new Pared();
		pared2.setBounds(246,856,512,46);

		pared_1=new Pared2();
		pared_1.setBounds(200,144,46,512);
		pared_2=new Pared2();
		pared_2.setBounds(758,144,46,512);
		pared_3=new Pared2();
		pared_3.setBounds(200,390,46,512);
		pared_4=new Pared2();
		pared_4.setBounds(758,390,46,512);

		enemigo= new Enemigo();
		enemigo.setBounds(300,300,20,18);

		enemigo2=new Enemigo();
		enemigo2.setBounds(728,300,20,18);

		enemigo3= new Enemigo();
		enemigo3.setBounds(377,300,20,18);

		enemigo4= new Enemigo();
		enemigo4.setBounds(630,300,20,18);

		enemigoz= new Enemigo2();
		enemigoz.setBounds(250,350,20,18);

		enemigoz2=new Enemigo2();
		enemigoz2.setBounds(250,450,20,18);

		enemigoz3=new Enemigo2();
		enemigoz3.setBounds(250,650,20,18);

		enemigoz4=new Enemigo2();
		enemigoz4.setBounds(250,750,20,18);

		comida_1= new Comida();
		comida_1.setBounds(500,500,23,16);

 		mr=new MiReproductor();
			
		
		

		/*try{
			imagen2= ImageIO.read(new File("./imagenes/pared.png"));
		}catch(Exception e)
		{
			System.out.println("error");
		}
		subImagen2= imagen2.getSubimage(0,64,64,64);
		pared= new Pared(subImagen2);

		subImagen3= imagen2.getSubimage(0,64,100,64);
		pared2=new Pared(subImagen3);*/


		panel=new JPanel();
		panel.setLayout(null);


		//monito y paredes
		panel.add(monito);
		panel.add(pared);
		panel.add(pared2);
		panel.add(pared_1);
		panel.add(pared_2);
		panel.add(pared_3);
		panel.add(pared_4);

		//enemigos rojos
		panel.add(enemigo);
		crearHilo1();
		panel.add(enemigo2);
		crearHilo2();
		panel.add(enemigo3);
		crearHilo3();
		panel.add(enemigo4);
		crearHilo4();

		//enemigos azules
		panel.add(enemigoz);
		crearHilo5();
		panel.add(enemigoz2);
		crearHilo6();
		panel.add(enemigoz3);
		crearHilo7();
		panel.add(enemigoz4);
		crearHilo8();




		//comiditas
		panel.add(comida_1);




		this.add(panel);
		this.setTitle("EL MEJOR JUEGO POO");
		this.setBounds(0,0,1000,1000);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(this);
		//panel.setBackground(Color.BLACK);

		
		while (true)
		{
			Extremo();
			gameOver();
		}


		/*while(true)
		{
			gameOver();
			
		}*/

		/*while (true)
		{
			if(monito.getBounds().intersects(comida_1.getBounds()))
			{
				crearHilo9();
			}
		}*/






		

	}
	         



	public void keyPressed(KeyEvent e)
	{
		//System.out.println("Tecla presionada = "+e.getKeyCode());
		int t = e.getKeyCode();


		Point pos = monito.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();
		//System.out.println( (int) pos.getX() );

		if(t==68)
		{
			x = x+5;
			indiceX = ((indiceX + 1) % 9) * 64;
			monito.imagen = imagen.getSubimage(indiceX,64*3,64,64);

		}

		else if(t==65)
		{
			x = x-5;
			indiceX = ((indiceX + 1) % 9) * 64;
			monito.imagen = imagen.getSubimage(indiceX,64*1,64,64);
		}

		else if(t==83)
		{
			y = y+5;
			indiceX = ((indiceX + 1) % 9) * 64;
			monito.imagen = imagen.getSubimage(indiceX,64*2,64,64);
		}
		else if(t==87)
		{
			y = y-5;
			indiceX = ((indiceX + 1) % 9) * 64;
			monito.imagen = imagen.getSubimage(indiceX,64*0,64,64);
		}


		monito.setLocation(x,y);

		 if(colisionx())
		{
			y = y-5;
			monito.setLocation(x,y);
			
		}
		if(colisiony())
		{
			y=y+5;
			monito.setLocation(x,y);
		}
		if(colision2x())
		{
			x=x+5;
			monito.setLocation(x,y);
		}
		if(colision2y())
		{
			x=x-5;
			monito.setLocation(x,y);
		}
		if(colision3x())
		{
			x=x+5;
			monito.setLocation(x,y);
		}
		if (colision3y())
		{
			x=x-5;
			monito.setLocation(x,y);
		}

	}


	public void keyReleased(KeyEvent e)
	{
		//System.out.println("Tecla liberada.");
	}

	public void keyTyped(KeyEvent e)
	{
		//System.out.println("Tecla en el buffer.");

	}
	public boolean colisionx()
	{
		this.pared2=pared2;
		return pared2.getBounds().intersects(monito.getBounds());
	}
	public boolean colisiony()
	{
		this.pared=pared;
		return pared.getBounds().intersects(monito.getBounds());
	}
	public boolean colision2x()
	{
		this.pared_1=pared_1;
		return pared_1.getBounds().intersects(monito.getBounds());
	}
	public boolean colision2y()
	{
		this.pared_2=pared_2;
		return pared_2.getBounds().intersects(monito.getBounds());
	}
	public boolean colision3x()
	{
		this.pared_3=pared_3;
		return pared_3.getBounds().intersects(monito.getBounds());
	}
	public boolean colision3y()
	{
		this.pared_4=pared_4;
		return pared_4.getBounds().intersects(monito.getBounds());
	}

	public void crearHilo1(){
		Hilo1 h1=new Hilo1(this.enemigo);
		hilo1 =new Thread(h1);
		hilo1.start();
	}
	public void crearHilo2()
	{
		Hilo2 h2=new Hilo2(this.enemigo2);
		hilo2=new Thread(h2);
		hilo2.start();
	}
	public void crearHilo3()
	{
		Hilo3 h3= new Hilo3(this.enemigo3);
		hilo3=new Thread(h3);
		hilo3.start();
	}
	public void crearHilo4()
	{
		Hilo4 h4= new Hilo4(this.enemigo4);
		hilo4= new Thread (h4);
		hilo4.start();
	}
	public void crearHilo5()
	{
		Hilo5 h5= new Hilo5(this.enemigoz);
		hilo5=new Thread(h5);
		hilo5.start();
	}
	public void crearHilo6()
	{
		Hilo6 h6= new Hilo6(this.enemigoz2);
		hilo6= new Thread(h6);
		hilo6.start();
	}
	public void crearHilo7()
	{
		Hilo7 h7 = new Hilo7(this.enemigoz3);
		hilo7=new Thread(h7);
		hilo7.start();
	}
	public void crearHilo8()
	{
		Hilo8 h8= new Hilo8(this.enemigoz4);
		hilo8=new Thread(h8);
		hilo8.start();
	}
	public void crearHilo9()
	{
		Hilo9 h9= new Hilo9(this.comida_1);
		hilo9=new Thread(h9);
		hilo9.start();
	}


	public void gameOver()
	{
		mr.inicializar();
		//mr.coco();
		if(monito.getBounds().intersects(enemigo.getBounds())||monito.getBounds().intersects(enemigo2.getBounds())
			||monito.getBounds().intersects(enemigo3.getBounds())||monito.getBounds().intersects(enemigo4.getBounds())
			||monito.getBounds().intersects(enemigoz.getBounds())||monito.getBounds().intersects(enemigoz2.getBounds())
			||monito.getBounds().intersects(enemigoz3.getBounds())||monito.getBounds().intersects(enemigoz4.getBounds()))
		{
			mr.coco();
			JOptionPane.showMessageDialog(this,"EL VIRUS ENTRO A TU SISTEMA","RIP TU MONITO",JOptionPane.YES_NO_OPTION);
			//System.exit(ABORT);
			Reinicio();
			
		}
		
	}

	public void Extremo()
	{

		if (monito.getBounds().intersects(comida_1.getBounds()))
				{
					int x;
					x= (int)(Math.random()*(758-256+1)+256);
					int y;
					y=(int)(Math.random()*(850-190+1)+190);

					this.comida_1.setLocation(x,y);

				}
	}

	public void Reinicio()
	{
		this.monito.setLocation(500,190);
	}

	/*public void Musiquita(){

		ArrayList<String> contenido = new ArrayList<String>();
		ArrayList<Integer> contenidoInt = new ArrayList<Integer>();


	}*/
	

}
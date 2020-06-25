import javax.sound.midi.*;

import java.util.*;

import java.io.*;

class MiReproductor{



private Synthesizer synthe = null;

private int intensity = 100;

private MidiChannel [] channels;

private MidiChannel channel;


public MiReproductor(){

    try{

        synthe = MidiSystem.getSynthesizer();

    }catch(Exception e){

        System.out.println("Error: al obtener synthe.");

    }

}

public void inicializar(){

    try{

        synthe.open();

        channels = synthe.getChannels();

    }catch(Exception e){

        System.out.println("Error: al inizializar el synthe.");

    }

}


public void reproducirNota(int nota, int canal, int duracion){

   

    channel = channels[canal];

    channel.noteOn(nota, intensity);

    try{

            Thread.sleep(duracion);

        }catch(Exception e){

            System.out.println("ERROR: en sleep.");

        }

    channel.noteOff(nota);

}

public void reproducirAcorde3Notas(int nota1, int nota2, int nota3, int canal, int duracion){

   

    channel = channels[canal];

    channel.noteOn(nota1, intensity);

    channel.noteOn(nota2, intensity);

    channel.noteOn(nota3, intensity);

    try{

            Thread.sleep(duracion);

        }catch(Exception e){

            System.out.println("ERROR: en sleep.");

        }

    channel.noteOff(nota1);

    channel.noteOff(nota2);

    channel.noteOff(nota3);

}

public void reproducirAcordeNnotas(ArrayList<Integer> notas, int n, int canal, int duracion){

   

    channel = channels[canal];

    for(int i=0; i<n; i++)

        channel.noteOn(notas.get(i), intensity);


    try{

            Thread.sleep(duracion);

        }catch(Exception e){

            System.out.println("ERROR: en sleep.");

        }

    for(int i=0; i<n; i++)

        channel.noteOff(notas.get(i));

}

public void finalizar(){

    try{

        synthe.close();

    }catch(Exception e){

        System.out.println("Error: al finalizar el synthe.");

    }

}

public static ArrayList<String> leerTodo(String nombreArchivo)

    {

        ArrayList<String> contenido = new ArrayList<String>();

        String cadena = new String();

       

        try(FileInputStream fis = new FileInputStream(nombreArchivo);

            DataInputStream din = new DataInputStream(fis);

            BufferedReader br = new BufferedReader(new InputStreamReader(din));)

        {

            cadena = br.readLine();

            while(cadena != null)

            {

                contenido.add(cadena);

                cadena = br.readLine();

            }  

        }

        catch(Exception e)

        {

            e.printStackTrace();

        }

        return contenido;

   

}
    public void pause(int duracion){
 try{
 System.out.println("\nPAUSE...");
 Thread.sleep(duracion);
 }catch(InterruptedException e){
 System.out.println("ERROR: al suspender el synthe");
 }
 }
 public void play(int nota, int canal, int duracion)
 {
 channel = channels [canal];
 channel.noteOn(nota, intensity);
 try
 {
 System.out.println("PLAY.....\n");
 Thread.sleep(duracion);

 }
 catch ( Exception e)
 {
 System.out.println("ERROR: en reanudar el synthe.");
 e.printStackTrace();
 }
 channel.noteOff(nota);

 }
 public void coco(){
    inicializar();
    reproducirNota(62,1,500);
    reproducirNota(64,1,1000);
    reproducirNota(60,1,500);

 reproducirNota(55,1,1500);
 reproducirNota(55,1,500);
 reproducirNota(53,1,250);
 reproducirNota(53,1,500);
 reproducirNota(60,1,500);
 reproducirNota(60,1,500);
 reproducirNota(62,1,250);
 reproducirNota(62,1,500);
 /*reproducirNota(62,1,500);
 reproducirNota(64,1,1000);
 reproducirNota(60,1,500);
 reproducirNota(55,1,1500);
 reproducirNota(64,1,500);
 reproducirNota(65,1,500);
 reproducirNota(64,1,500);
 reproducirNota(64,1,500);
 reproducirNota(62,1,250);
 reproducirNota(62,1,500);*/

 }

}
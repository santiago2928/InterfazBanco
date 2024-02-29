/**
 *Descripcion de la clase: En la clase Utilidades extendimos la libreria "TimerTask" y aqui creamos los diferentes metodos para que el algoritmo cumpla su funcionamiento.
 *
 * @author kevin.aristizabal@uao.edu.co Kevin Aristizabal 2226235
 * @author santiago.osorio_gra@uao.edu.co Santiago Osorio 2226367
 * @author Daniel.Cardenas
 * @Date 28 Feb 2024
 */
package cola;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.TimerTask;
import modelo.Cajero;
import modelo.Clientes;

public class utilidades{
    
    private ArrayList<Cajero> cajeros;

    private LinkedList<Clientes> almacenarCli;
    private Cola<Clientes> colaPreferencial;
    private Cola<Clientes> colaBanco;
    private Cola<Clientes> colaClientes;
    private Random random;

    public utilidades() {
        
        cajeros = new ArrayList<>();
        almacenarCli = new LinkedList();
        colaPreferencial = new Cola<>();
        colaClientes = new Cola<>();
        colaBanco = new Cola<>();
        random = new Random();

    }

    
    public  void crearCliente(){

        
        int numClientes = random.nextInt(5) + 1;

        for (int i = 0; i < numClientes; i++) {
            int edad = random.nextInt(83) + 18;
            int tiempo = random.nextInt(10) + 1;
            boolean esCliente = random.nextBoolean();
            Clientes cliente = new Clientes(edad, tiempo, esCliente);
            almacenarCli.add(cliente);

        }

        System.out.println("Clientes agregados: " + numClientes);
        for (Clientes cliente : almacenarCli) {
            System.out.println(cliente);
        }

    }

    //Metodo para llenar la ColaPreferencial si el cliente es mayor o igual a 60 años.
    public void llenarPreferencial() {
        
        for (Clientes cliente : almacenarCli) { 
            if (cliente.getEdad() >= 60) {
                colaPreferencial.encolar(cliente);
            }    
            
        }
        
        System.out.println("Clientes preferenciales agregados a la cola:");
        while (!colaPreferencial.estaVacia()) {
            System.out.println(colaPreferencial.desencolar());
        }
        
    }

    //Metodo para llenar la colaBanco en la cula si el cliente es igual a False se encola en la colaBanco.
    public void llenarBanco() {

        for (Clientes cliente : almacenarCli) {
                if (cliente.isEsCliente() == false && cliente.getEdad() < 60) {
                    colaBanco.encolar(cliente);
            }
        }

        System.out.println("Clientes de Banco agregados a la cola:");
        while (!colaBanco.estaVacia()) {
            System.out.println(colaBanco.desencolar());
        }

    }

    // Metodo para llenar la colaClientes en la cual si el cliente es igual a True se encola a la colaClientes.
    public void llenarClientes() {
        for (Clientes cliente : almacenarCli) {
            if (cliente.isEsCliente() == true && cliente.getEdad() < 60) {
                colaClientes.encolar(cliente);
            }
        }
        System.out.println("Clientes agregados a la cola:");
        while (!colaClientes.estaVacia()) {
            System.out.println(colaClientes.desencolar());
        }
    }
    
    
    
    
   //----------------------------------------------------------------------------------
 /*
    public void sistemaCajeros(){
        
        
        Cajero cajero1 = new Cajero("Cajero 1", colaPreferencial);
        Cajero cajero2 = new Cajero("Cajero 2", colaPreferencial);
        Cajero cajero3 = new Cajero("Cajero 3", colaBanco);
        Cajero cajero4 = new Cajero("Cajero 4", colaBanco);
        Cajero cajero5 = new Cajero("Cajero 5", colaClientes);
        Cajero cajero6 = new Cajero("Cajero 6", colaClientes);

        cajeros.add(cajero1);
        cajeros.add(cajero2);
        cajeros.add(cajero3);
        cajeros.add(cajero4);
        cajeros.add(cajero5);
        cajeros.add(cajero6);

        for (Cajero cajero : cajeros) {
          cajero.start();
        }

       Random rand = new Random();
      }
        
    
        
   
        
        for (Clientes cliente : almacenarCli) {
            if (cliente.getEdad() >= 60) {
                colaPreferencial.desencolar();
                
            }
        }
        
        
        Cajero c1 = new Cajero();
        Cajero c2 = new Cajero();
        
        
        
        while (colaPreferencial.estaVacia()) {
            if (!colaPreferencial.estaVacia()) {
                System.out.println("entro al if1");
                if (!c1.estaOcupado()) {
                    c1.atenderCliente(colaPreferencial.desencolar());
                }
                if (!c2.estaOcupado()) {
                    c2.atenderCliente(colaPreferencial.desencolar());
                }
            }
            
            
        }

        
        
    }
    
    private void asignarCliente() {
        for (Cajero cajero : cajeros) {
            if (!cajero.estaOcupado() && !colaPreferencial.estaVacia()) {
                Clientes cliente = colaPreferencial.desencolar();
                cajero.atenderCliente(cliente);
            }
        }
    }
    */
   //----------------------------------------------------------------------------------

    // Metodo Para la Creacion de Cliente con edad y tiempo Aleatorio.
    public void run() {


        llenarPreferencial();
        llenarBanco();
        llenarClientes();
        
    }
}

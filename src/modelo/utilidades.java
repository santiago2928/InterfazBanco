/**
 *Descripcion de la clase: En la clase Utilidades extendimos la libreria "TimerTask" y aqui creamos los diferentes metodos para que el algoritmo cumpla su funcionamiento.
 *
 * @author kevin.aristizabal@uao.edu.co Kevin Aristizabal 2226235
 * @author santiago.osorio_gra@uao.edu.co Santiago Osorio 2226367
 * @author Daniel.Cardenas
 * @Date 28 Feb 2024
 */
package modelo;

import cola.Cola;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.TimerTask;
import modelo.Cajero;
import modelo.Clientes;

public class utilidades extends TimerTask {
    
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
            System.out.println(colaBanco.desencolar().toString());
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
    public void sistemaCajeros(){
        int numCajeros = 6;
        
        for (int i = 0; i < numCajeros; i++) {
            cajeros.add(new Cajero());
        }
        
    
        /*
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
            
            
        }*/

        
        
    }
    
    private void asignarCliente() {
        for (Cajero cajero : cajeros) {
            if (!cajero.estaOcupado() && !colaPreferencial.estaVacia()) {
                Clientes cliente = colaPreferencial.desencolar();
                cajero.atenderCliente(cliente);
            }
        }
    }
   //----------------------------------------------------------------------------------

    // Metodo Para la Creacion de Cliente con edad y tiempo Aleatorio.
    @Override
    public void run() {

        crearCliente();
        

        llenarPreferencial();
        llenarBanco();
        llenarClientes();
        asignarCliente();
        
    }
}

/**
 *Descripcion de la clase: En la clase Clientes creamos los objetos de tipo cliente con atributos de edad,tiempo y esCliente, con su respectivos getters y setters,y su constructor.
 * @author kevin.aristizabal@uao.edu.co Kevin Aristizabal 2226235
 * @author santiago.osorio
 * @author Daniel.Cardenas
 * @Date 28 Feb 2024
 */
package modelo;


import cola.Base;

public class Clientes extends Base{
    
    private int edad;
        
    private int tiempo;
    
        private boolean esCliente;

    /**
     * Get the value of esCliente
     *
     * @return the value of esCliente
     */
    public boolean isEsCliente() {
        return esCliente;
    }

    /**
     * Set the value of esCliente
     *
     * @param esCliente new value of esCliente
     */
    public void setEsCliente(boolean esCliente) {
        this.esCliente = esCliente;
    }


    /**
     * Get the value of tiempo
     *
     * @return the value of tiempo
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * Set the value of tiempo
     *
     * @param tiempo new value of tiempo
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }


    /**
     * Get the value of edad
     *
     * @return the value of edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Set the value of edad
     *
     * @param edad new value of edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    
    public Clientes() {
    }

    public Clientes(int edad, int tiempo, boolean esCliente) {
        this.edad = edad;
        this.tiempo = tiempo;
        this.esCliente = esCliente;
    }
    
    
    
    
    
    
    

    @Override
    public String toString() {
        return "Clientes{" + "edad=" + edad + ", tiempo=" + tiempo + ", esCliente: "+esCliente+'}'+"\n";
    }
    
    
    
    

    @Override
    public Base copy() {
        
        return new Clientes(edad,tiempo,esCliente);
        
    }
    
    

    
}

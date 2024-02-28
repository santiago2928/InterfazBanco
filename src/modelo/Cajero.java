
package modelo;


public class Cajero {
    
    private boolean ocupado;

    public Cajero() {
        this.ocupado = false;
    }
    
    public void atenderCliente(Clientes cliente){
        
        ocupado = true;
        System.out.println("Cajero ocupado atendiendo cliente...");
        try {
            Thread.sleep(cliente.getTiempo() * 1000); // Simular tiempo de atención
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Cajero terminó de atender al cliente.");
        ocupado = false;
        
    }


    public boolean estaOcupado() {
        return ocupado;
    }
        
    
    
    
    
}

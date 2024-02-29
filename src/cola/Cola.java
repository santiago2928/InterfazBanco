/**
 *Descripcion de la clase: En la Clase cola se crearon los diferentes metodos para que las colas creadas durante el codigo puedan utilizarlos.
 *
 * @author kevin.aristizabal@uao.edu.co Kevin Aristizabal 2226235
 * @author santiago.osorio_gra@uao.edu.co Santiago Osorio 2226367
 * @author Daniel.Cardenas
 * @Date 28 Feb 2024
 */
package cola;

import java.util.LinkedList;

public class Cola<T extends Base> {

    private LinkedList<T> elementos;

    public Cola() {

        elementos = new LinkedList();

    }
    // Metodo para Encolar

    public void encolar(T elemento) {

        elementos.addLast(elemento);

    }
    // Metodo para Desencolar

    public T desencolar() {

        return elementos.removeFirst();
    }
    // Metodo de EstaVacia

    public boolean estaVacia() {

        return elementos.isEmpty();
    }

    @Override
    public String toString() {
        String cad = "[";
        for (T e : elementos) {
            cad += " " + e.toString();

        }

        return cad + "]";
    }

}

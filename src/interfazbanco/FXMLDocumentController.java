/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package interfazbanco;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import modelo.Clientes;
import modelo.Cajero;
import cola.Cola;
import modelo.utilidades;
import java.util.Timer;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




/**
 *
 * @author santi
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private ProgressIndicator cajero1;

    @FXML
    private ProgressIndicator cajero2;

    @FXML
    private ProgressIndicator cajero3;

    @FXML
    private ProgressIndicator cajero4;

    @FXML
    private ProgressIndicator cajero5;

    @FXML
    private ProgressIndicator cajero6;
    
    @FXML
    private TextArea colaP;
    
    @FXML
    private TextArea colaB;
    
    @FXML
    private TextArea colaC;
    
    @FXML 
    private Button handleIniciarButton;

    LinkedList<Clientes> almacenarCli;
    Cola<Clientes>colaPreferencial;
    Cola<Clientes>colaBanco;
    Cola<Clientes>colaClientes;
        
    Timer timer;
    Random random;
    
    private ArrayList<Cajero> cajeros;

    
   
    
    
    
    
    
    
    @FXML 
    private void handleIniciarButton(ActionEvent i){
        
        
     Timer timer = new Timer (); 
        
     TimerTask miTimerTask = new TimerTask(){
        public void run(){
            
        int numClientes = random.nextInt(5) + 1;
             
            for (int i = 0; i < numClientes; i++) {
            int edad = random.nextInt(83) + 18;
            int tiempo = random.nextInt(10) + 1;
            boolean esCliente = random.nextBoolean();
            Clientes cliente = new Clientes(edad, tiempo, esCliente);
            almacenarCli.add(cliente);
        } 
        
        }

     };
     
     
      timer.schedule(miTimerTask, 5000);
   
        
     

      
        
    
        
        
        
        
     
     
     
     
     
     
     
     
     
     
     
        
        // metodo para que se Muevan los Progress Indicator
        cajero1.setVisible(true);
        cajero2.setVisible(true);
        cajero3.setVisible(true);
        cajero4.setVisible(true);
        cajero5.setVisible(true);
        cajero6.setVisible(true);

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    updateProgress(i, 100); // Actualizar el progreso
                    
                    // Dormir para simular una tarea que toma un tiempo
                    Thread.sleep(100);
                }
                return null;
            }
        };

        cajero1.progressProperty().bind(task.progressProperty());
        cajero2.progressProperty().bind(task.progressProperty());
        cajero3.progressProperty().bind(task.progressProperty());
        cajero4.progressProperty().bind(task.progressProperty());
        cajero5.progressProperty().bind(task.progressProperty());
        cajero6.progressProperty().bind(task.progressProperty());
        
        task.setOnSucceeded(event ->{
            cajero1.setVisible(false);
            cajero2.setVisible(false);
            cajero3.setVisible(false);
            cajero4.setVisible(false);
            cajero5.setVisible(false);
            cajero6.setVisible(false);
            
            // Ocultar los otros ProgressIndicator aquí
        });
        
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
        
        
        
        
     
       
    }
    
    @FXML
    private void Resumen(ActionEvent event){
        
    }
    
    
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        almacenarCli = new LinkedList<>();
        colaPreferencial = new Cola<>();
        colaBanco = new Cola<>();
        colaClientes = new Cola<>();
        
        random = new Random();
        timer = new Timer();
  
    
    }    

}
    




    
 
    
    

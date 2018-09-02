/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import objetosUtileria.Estudiante;

/**
 *
 * @author rafaelm
 */
public class Consultor {
    
    List<Estudiante> estudiantes;
    onConsultorInterface laSecre;
    
    public Consultor(onConsultorInterface secre){
        this.laSecre=secre;
        estudiantes=new ArrayList<Estudiante>();
    }
    
    
    public void agregarEstudianteALista(Estudiante estudiante){
        estudiantes.add(estudiante);
        laSecre.onCreateEstudiante(); 
    }
    
    public void buscar(String nombre){
        for(Estudiante estudianteARevisar:estudiantes){
            System.out.println("Estudiante iterado "+estudianteARevisar.getNombre());
            if(nombre.equals(estudianteARevisar.getNombre())){
                laSecre.onEstudianteEncontrado(estudianteARevisar);
                break;
            }
        }
    }
    
    public void borrar(String nombre){
        int indice = 0;
        for(Estudiante estudianteARevisar:estudiantes){
            System.out.println("Estudiante iterado "+estudianteARevisar.getNombre());
            if(nombre.equals(estudianteARevisar.getNombre())){
                estudiantes.remove(indice);
                laSecre.onEstudianteBorrado(nombre);
                break;
            }
            indice++;
        }
    }
    
    public void modificar(String nombre){
        for(Estudiante estudianteARevisar:estudiantes){
            int indice = 0;
            System.out.println("Estudiante iterado "+estudianteARevisar.getNombre());
            if(nombre.equals(estudianteARevisar.getNombre())){
                laSecre.onEstudianteAModificarEncontrado(estudianteARevisar);
                estudiantes.remove(indice);
                break;
            }
            indice++;
        }
    }   
    
  
    public void muestra(){
        for(Estudiante estudianteARevisar:estudiantes){
            System.out.println("Estudiante iterado "+estudianteARevisar.getNombre()+" "+estudianteARevisar.getPaterno()+" "+estudianteARevisar.getMaterno());
            
        }
    }
    
    
    
    
    public interface onConsultorInterface{
        public void onConsulta();
        public void onError();
        public void onCreateEstudiante();
        public void onEstudianteEncontrado(Estudiante estudiante);
        public void onEstudianteAModificarEncontrado(Estudiante estudiante);
        public void onEstudianteBorrado(String data);
    }
    
}

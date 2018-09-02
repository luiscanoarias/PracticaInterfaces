/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosUtileria;

import acciones.Capturista;
import acciones.Capturista.onCapturistaAction;
import acciones.Consultor;
import acciones.Consultor.onConsultorInterface;
import java.util.Scanner;

public class Secretaria implements onConsultorInterface,onCapturistaAction {

    Consultor consultor;
    Capturista capturista;
    
    public Secretaria(){
        consultor=new Consultor(this);
        capturista=new Capturista(this);
        boolean cond=true;
        while(cond){
            System.out.println("1) Crear estudiante \n"
                    + "2) Buscar estudiante \n"
                    + "3) Modificar estudiante \n"
                    + "4) Eliminar estudiante \n"
                    + "5) Mostrar estudiantes \n"
                    + "6) Salir \n");
            Scanner scanner=new Scanner(System.in);
            int entrada=scanner.nextInt();
            switch(entrada){
                case 1:
                    capturista.capturar();
                    break;
                case 2:
                    capturista.ingresoDeNombre();
                    break;
                case 3:
                    capturista.ingresoDeNombreAModificar();
                    break;
                case 4:
                    capturista.ingresoDeNombreABorrar();
                    break;
                case 5:
                    consultor.muestra();
                    break;
                case 6:
                    cond=false;
                    break;
            }
        }
    }

    @Override
    public void onConsulta() {
        
    }

    @Override
    public void onError() {
        
    }

    @Override
    public void onCreateEstudiante() {
        System.out.println("---->Tu estudiante ya fue ingresado en la lista");
    }

    @Override
    public void onCaptura() {
        System.out.println("---->Inicia procedimiento de creacion de estudiante");
    }

    @Override
    public void onErrorOnCaptura() {
        
    }

    @Override
    public void onCapturaTerminada(Estudiante estudiante) {
        consultor.agregarEstudianteALista(estudiante);
    }

    @Override
    public void onNombreABuscarIngresado(String ingresado) {
        System.out.println("----->Nombre ingresado");
        consultor.buscar(ingresado);
    }

    @Override
    public void onEstudianteEncontrado(Estudiante estudiante) {
        System.out.println("Nombre encontrado: "+estudiante.getNombre()+" "+estudiante.getPaterno()+" "+estudiante.getMaterno());
    }

    @Override
    public void onIngresadoParaBorrar(String ingresado) {
        System.out.println("----->Nombre ingresado");
        consultor.borrar(ingresado);
    }

    @Override
    public void onIngresadoParaModificar(String ingresado) {
        System.out.println("----->Nombre ingresado");
        consultor.modificar(ingresado);
    }
    
    @Override
    public void onEstudianteAModificarEncontrado(Estudiante estudiante) {
        System.out.println("----->Lista para modificar estudiante");
        capturista.ingresoDeModificaciones(estudiante);
    }
    
    @Override
    public void onEstudianteBorrado(String data) {
        System.out.println("Estudiante borrado ->"+data);
        //consultor.muestra();
    }
    
    @Override
    public void onCapturaDeModificacionesTerminada(Estudiante estudiante) {
        System.out.println("Estudiante modificado ->"+estudiante.getNombre());
        consultor.agregarEstudianteALista(estudiante);
    }

    @Override
    public void onCapturaDeModificaciones(Estudiante estudiante) {
        System.out.println("Inicio de captura de modificaciones");
                
    }
    
}

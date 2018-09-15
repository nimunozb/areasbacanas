/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.practica;
import becker.robots.*;
/**
 *
 * @author Horacio
 */
public class Robotbase {
    private static Lote lote;
    private static Robot estudiante;
    private static Posicion posicion;
     private static int dir=4;
    
     public static void main(String[] args) {
         lote=new Lote();
         estudiante=new Robot(lote.getCity(),1, 3, Direction.WEST,1999);
         posicion=new Posicion();
       boolean quit=false;
         while(!quit){
         mirartodoslados();}
         
     }
 public static void faceNorth(){
            if (dir==4) {
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.turnLeft();
            }
            if (dir==3) {
                estudiante.turnLeft();
                estudiante.turnLeft();
            }
            if (dir==2) {
                estudiante.turnLeft();
            }dir=1;
            
        }
    public static void faceEast(){
            if (dir==1) {
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.turnLeft();
            }
            if (dir==4) {
                estudiante.turnLeft();
                estudiante.turnLeft();
            }
            if (dir==3) {
                estudiante.turnLeft();
            }dir=2;
            
        }
    public static void faceSouth(){
            if (dir==2) {
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.turnLeft();
            }
            if (dir==1) {
                estudiante.turnLeft();
                estudiante.turnLeft();
            }
            if (dir==4) {
                estudiante.turnLeft();
            }dir=3;
            
        }
    public static void faceWest(){
            if (dir==3) {
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.turnLeft();
            }
            if (dir==2) {
                estudiante.turnLeft();
                estudiante.turnLeft();
            }
            if (dir==1) {
                estudiante.turnLeft();
            }dir=4;
            
        }
   
   
    
    
    /**
    *@deprecated: de la matriz utilizada en miraratodoslados escoge de entre todas las posiciones posibles 
    * la optima para el desarrollo del juego
    */
    public static void prioridad(boolean miradas[]){
      if ((miradas[2]==true)&&(miradas[3]==false)&& //si hay una pared unicamente en el lado sur 
          (miradas[0]==false)&&(miradas[1]==false)){
          faceWest();estudiante.move();
      }else{
          if((miradas[2]==false)&&(miradas[3]==false)&& //si no hay pared en ninguna direccion 
             (miradas[0]==false)&&(miradas[1]==false)&& //y el robot no ha estado ahi
           !((posicion.getAvenue()==estudiante.getAvenue())&&
           (posicion.getStreed()==estudiante.getStreet()))){  
           faceNorth();estudiante.move();
           posicion.guardarsiyaestuveaqui(estudiante);
            }else{
          if((miradas[2]==false)&&(miradas[3]==false)&&  
           (miradas[0]==false)&&(miradas[1]==false)&& 
           ((posicion.getAvenue()==estudiante.getAvenue())&&
           (posicion.getStreed()==estudiante.getStreet()))) {  // si no hay ninguna pared y el robot si ha estado ahi 
           faceSouth();estudiante.move();estudiante.move();
          }else{
              if((miradas[2]==false)&&(miradas[3]==false)&&  
           (miradas[0]==false)&&(miradas[1]==true)){
                  faceSouth();estudiante.move();
              }
          }

      
      
      }
          
   
   
       
       
       
   }}
   /** 
   *@deprecated: mira a todas las direcciones y guarda las posiciones en donde hay una pared en una matriz
   * que luego sera utilizada por la funcion prioridad.
   */
   public static void mirartodoslados(){
    boolean [] miradas=new boolean[4];
    for (int i = 0; i < 4; i++) {miradas[i]=false;}
   faceSouth();estudiante.frontIsClear();
        if(estudiante.frontIsClear()==false){miradas[2]=true;}
   faceEast();estudiante.frontIsClear();
        if(estudiante.frontIsClear()==false){miradas[1]=true;}
    faceNorth();estudiante.frontIsClear();
        if(estudiante.frontIsClear()==false){miradas[0]=true;} 
   faceWest();estudiante.frontIsClear();
        if(estudiante.frontIsClear()==false){miradas[3]=true;}
     prioridad(miradas);
   
   }
    
    
    
}

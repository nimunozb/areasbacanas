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
    private static int estado=0;
    private static int maxAv =0;
    private static int maxStre=0;
    private static boolean figura[][] =new boolean[30][30]; 
    public static void main(String[] args) {
         lote=new Lote();
         estudiante=new Robot(lote.getCity(),2, 0, Direction.WEST,1999);
         posicion=new Posicion();
       estudiante.putThing();
         do{
         mirartodoslados();}while(!estudiante.canPickThing());
         System.out.println("El area del lote es "+calcularArea()+"m2");
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
    *@deprecated: de la matriz utilizada en miraratodoslados escoge de entre todas las direcciones posibles 
    * la optima para el desarrollo del juego
    */
    public static void prioridad(boolean miradas[]){
        
      if ((miradas[2]==true)&&(miradas[3]==false)&& //si hay una pared unicamente en el lado sur 
          (miradas[0]==false)&&(miradas[1]==false)){
          faceWest();estudiante.move();           //se mueve hacia el occidente(aqui puedes poner que guarde esta posicion dentro de la matriz)
          estado=3;// guarda el estado de la direccion en donde venia el robot
    }else{//es para la interseccion superior izquierda
          if((miradas[2]==false)&&(miradas[3]==false)&&(estado==3)&& //si no hay pared en ninguna direccion y viene del este hacia el oste
             (miradas[0]==false)&&(miradas[1]==false)&& //y el robot no ha estado ahi
           !((posicion.getAvenue()==estudiante.getAvenue())&&
           (posicion.getStreed()==estudiante.getStreet()))){  
           faceSouth();estudiante.move();
           posicion.guardarsiyaestuveaqui(estudiante);
            }else{
          if((miradas[2]==false)&&(miradas[3]==false)&&(estado==3)&&  
           (miradas[0]==false)&&(miradas[1]==false)&& 
           ((posicion.getAvenue()==estudiante.getAvenue())&&
           (posicion.getStreed()==estudiante.getStreet()))) {  // si no hay ninguna pared y el robot si ha estado ahi 
           faceNorth();estudiante.move();estudiante.move();
   
          
        }else{//para la interseccion inferior izquierda
              if((miradas[2]==false)&&(miradas[3]==false)&&  
           (miradas[0]==false)&&(miradas[1]==true)){ //si hay una pared unicamente en el este  (aqui puedes poner que guarde esta posicion dentro de la matriz)
                  faceSouth();estudiante.move();// se mueve hacia abajo
             estado=2;
              }else{
             if((miradas[2]==false)&&(miradas[3]==false)&&(estado==2)&& //si no hay pared en ninguna direccion y viene del norte hacia el sur
             (miradas[0]==false)&&(miradas[1]==false)&& //y el robot no ha estado en esa posicion
           !((posicion.getAvenue()==estudiante.getAvenue())&&
           (posicion.getStreed()==estudiante.getStreet()))){  
           faceEast();estudiante.move();
           posicion.guardarsiyaestuveaqui(estudiante);
            }else{
          if((miradas[2]==false)&&(miradas[3]==false)&&(estado==2)&&  
           (miradas[0]==false)&&(miradas[1]==false)&& 
           ((posicion.getAvenue()==estudiante.getAvenue())&&
           (posicion.getStreed()==estudiante.getStreet()))) {  // si no hay ninguna pared y el robot si ha estado en esa posicion
           faceWest();estudiante.move();estudiante.move();
    
          
          
     }else{
           if((miradas[2]==false)&&(miradas[3]==false)&&  
           (miradas[0]==true)&&(miradas[1]==false)){ //si hay una pared unicamente en el norte  (aqui puedes poner que guarde esta posicion dentro de la matriz)
                  faceEast();estudiante.move();// se mueve hacia el este
             estado=1;
              }else{
             if((miradas[2]==false)&&(miradas[3]==false)&&(estado==1)&& //si no hay pared en ninguna direccion, y viene de occidente hacia el oriente
             (miradas[0]==false)&&(miradas[1]==false)&& //y el robot no ha estado ahi
           !((posicion.getAvenue()==estudiante.getAvenue())&&
           (posicion.getStreed()==estudiante.getStreet()))){  
           faceNorth();estudiante.move();
           posicion.guardarsiyaestuveaqui(estudiante);
            }else{
          if((miradas[2]==false)&&(miradas[3]==false)&&(estado==1)&&  
           (miradas[0]==false)&&(miradas[1]==false)&& 
           ((posicion.getAvenue()==estudiante.getAvenue())&&
           (posicion.getStreed()==estudiante.getStreet()))) {  // si no hay ninguna pared y el robot si ha estado ahi 
           faceSouth();estudiante.move();estudiante.move();
   }else{
          
              
              if((miradas[2]==false)&&(miradas[3]==true)&&  
           (miradas[0]==false)&&(miradas[1]==false)){ //si hay una pared unicamente en el occidente (aqui puedes poner que guarde esta posicion dentro de la matriz)
            faceNorth();estudiante.move();// se mueve hacia arriba
             estado=0;
              }else{
             if((miradas[2]==false)&&(miradas[3]==false)&&(estado==0)&& //si no hay pared en ninguna direccion y viene del sur hacia el norte
             (miradas[0]==false)&&(miradas[1]==false)&& //y el robot no ha estado ahi
           !((posicion.getAvenue()==estudiante.getAvenue())&&
           (posicion.getStreed()==estudiante.getStreet()))){  
           faceWest();estudiante.move();
           posicion.guardarsiyaestuveaqui(estudiante);
            }else{
          if((miradas[2]==false)&&(miradas[3]==false)&&(estado==0)&&  
           (miradas[0]==false)&&(miradas[1]==false)&& 
           ((posicion.getAvenue()==estudiante.getAvenue())&&
           (posicion.getStreed()==estudiante.getStreet()))) {  // si no hay ninguna pared y el robot si ha estado ahi 
           faceEast();estudiante.move();estudiante.move();
   }else{
             
              
              
              if ((miradas[2]==true)&&(miradas[3]==false)&&  // si la figura en donde le robot va a pasar tiene la forma de la equina inferior derecha de un cuadrado
           (miradas[0]==false)&&(miradas[1]==true)) {// entonces el robot se mueve hacia el occidente
                  faceWest();estudiante.move();//(aqui puedes poner que guarde esta posicion dentro de la matriz)
              }else{
                  if((miradas[2]==false)&&(miradas[3]==true)&&  // si la figura en donde le robot va a pasar tiene la forma de la equina superior izquierda de un cuadrado
           (miradas[0]==true)&&(miradas[1]==false)) {// entonces el robot se mueve hacia el este
                  faceEast();estudiante.move();//(aqui puedes poner que guarde esta posicion dentro de la matriz)
              }else{
                  if((miradas[2]==false)&&(miradas[3]==false)&&// si la figura en donde le robot va a pasar tiene la forma de la equina superior derecha de un cuadrado
           (miradas[0]==true)&&(miradas[1]==true)) {// entonces el robot se mueve hacia el sur
                  faceSouth();estudiante.move();estado=2;//(aqui puedes poner que guarde esta posicion dentro de la matriz)
             }else{
                  if((miradas[2]==true)&&(miradas[3]==true)&&// si la figura en donde le robot va a pasar tiene la forma de la equina inferior izquierda de un cuadrado
           (miradas[0]==false)&&(miradas[1]==false)) {// entonces el robot se mueve hacia el norte
                  faceNorth();estudiante.move();estado=0; //(aqui puedes poner que guarde esta posicion dentro de la matriz)   
                  }else{
           
            if((miradas[2]==true)&&(miradas[3]==false)&&  //si el robot esta pasando por un espacio entre dos paredes muy pegadas horizontalmente y viene de norte a sur 
           (miradas[0]==true)&&(miradas[1]==false)&&(estado==2)){//entonces se mueve hacia el este
                        faceEast();estudiante.move();//(aqui puedes poner que guarde esta posicion dentro de la matriz)
                  }else{
           if((miradas[2]==true)&&(miradas[3]==false)&&  //si llega a un callejon sin salida y viene de oeste al este , entonces se devuelve
           (miradas[0]==true)&&(miradas[1]==true)) {   
           faceWest();estudiante.move();estado=3;//guarda la direccion de salida(cotraria al callejon sin salida)estado=3;
           }else{
               if((miradas[2]==true)&&(miradas[3]==false)&&  //
           (miradas[0]==true)&&(miradas[1]==false)&&(estado==3)){//continua en la direccion de salida
                        faceWest();estudiante.move();
                  }else{
                    
                   
                   if((miradas[2]==false)&&(miradas[3]==true)&&  //si el robot esta pasando por un espacio entre dos paredes muy pegadas verticalmente y viene de oetse a este 
           (miradas[0]==false)&&(miradas[1]==true)&&(estado==1)){//entonces se mueve hacia el norte
                        faceNorth();estudiante.move();//(aqui puedes poner que guarde esta posicion dentro de la matriz)
                  }else{
           if((miradas[2]==false)&&(miradas[3]==true)&&  //si llega a un callejon sin salida y viene de sur al norte , entonces se devuelve
           (miradas[0]==true)&&(miradas[1]==true)) {   
           faceSouth();estudiante.move();estado=2;//guarda la direccion de salida(cotraria al callejon sin salida)estado=2;
           }else{
               if((miradas[2]==false)&&(miradas[3]==true)&&  
           (miradas[0]==false)&&(miradas[1]==true)&&(estado==2)){//continua en la direccion de salida
                        faceSouth();estudiante.move();
                  }else{
                   
                   if((miradas[2]==true)&&(miradas[3]==false)&&  //si el robot esta pasando por un espacio entre dos paredes muy pegadas horizontalmente y viene de sur a norte 
           (miradas[0]==true)&&(miradas[1]==false)&&(estado==0)){//entonces se mueve hacia el este
                        faceWest();estudiante.move();//(aqui puedes poner que guarde esta posicion dentro de la matriz)
                  }else{
           if((miradas[2]==true)&&(miradas[3]==true)&&  //si llega a un callejon sin salida y viene de este al oeste , entonces se devuelve
           (miradas[0]==true)&&(miradas[1]==false)) {   
           faceEast();estudiante.move();estado=1;//guarda la direccion de salida(cotraria al callejon sin salida)estado=1;
           }else{
               if((miradas[2]==true)&&(miradas[3]==false)&&  
           (miradas[0]==true)&&(miradas[1]==false)&&(estado==1)){//continua en la direccion de salida
                        faceEast();estudiante.move();
                  }else{
                   
                  
                   if((miradas[2]==false)&&(miradas[3]==true)&&  //si el robot esta pasando por un espacio entre dos paredes muy pegadas verticalmente y viene de este a oeste 
           (miradas[0]==false)&&(miradas[1]==true)&&(estado==3)){//entonces se mueve hacia el sur
                        faceSouth();estudiante.move();//(aqui puedes poner que guarde esta posicion dentro de la matriz)
                  }else{
           if((miradas[2]==true)&&(miradas[3]==true)&&  //si llega a un callejon sin salida y viene de norte al sur , entonces se devuelve
           (miradas[0]==false)&&(miradas[1]==true)) {   
           faceNorth();estudiante.move();estado=0;//guarda la direccion de salida(cotraria al callejon sin salida)estado=0;
           }else{
               if((miradas[2]==false)&&(miradas[3]==true)&&  
           (miradas[0]==false)&&(miradas[1]==true)&&(estado==0)){//continua en la direccion de salida
                        faceNorth();estudiante.move();
                  }}}}}}}}}}}}}}}}}}}}}}}}}}}}}
    
    public static void area(/*boolean miradas[]*/ ){
       
        
        /*for (int i = 0; i < 4; i++) {
            if(miradas[i]==true){
                figura[estudiante.getStreet()][estudiante.getAvenue()]=true;
            }
        }*/
        figura[estudiante.getStreet()][estudiante.getAvenue()]=true;
        int a=0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if(figura[i][j]){
                a=1;    
                }else{
                    a=0;
                }
                //System.out.print(a+" ");
            }//System.out.println("");
        }
        if (maxAv<estudiante.getAvenue()) {
            maxAv = estudiante.getAvenue();
        }
        if (maxStre<estudiante.getStreet()){
            maxStre= estudiante.getStreet();
        }
            
    }
    
    
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
        area();
        prioridad(miradas);
   
   }
   
   public static int calcularArea(){

       int conteo[]= new int[30];
       int resultado = 0;
       for (int i = 0; i < maxStre; i++) {
           boolean aux =false;
           int num1 = 0;
           for (int j = 0; j < maxAv; j++) {
               
               for (int k = 0; k < maxAv; k++) {
                   if(figura[i][k]){
                       num1 =num1+1;
                       
                   }
               }
               if (num1%2!=0) {
                   if (aux) {
                   conteo[i]++;
               }
               if(((figura[i][j])&&(figura[i][j+1]==false))||((figura[i][j]))&&(aux)){
                   aux=!aux;
               }
               }else {
                   
                       int f=0;

                           if (f!=num1) {
                               if(figura[i][j]){
                               f++;
                           }else{
                               conteo[i]++;
                           }
                           }
                           
                       
   
                   
               }
               
           }
       }
       for (int i = 0; i < 30; i++) {
           resultado=resultado +conteo[i];
       }
       return resultado;
   }
    
    
}

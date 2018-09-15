/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.practica;
import becker.robots.*;

/**
 *
 * @author Andres
 */
public class Lote {
   private static City city=new City();
   
    public Lote() {
         
        for (int i = 0; i < 5; i++) {
            Wall pared = new Wall(city, 2, i+1, Direction.NORTH);
            Wall pared1 = new Wall(city, 6, i+1, Direction.SOUTH);
            Wall pared3 = new Wall(city, i+3, 7, Direction.EAST);
            Wall pared4 = new Wall(city, i+3, -1, Direction.WEST);
        }
        for (int i = 0; i < 2; i++) {
             Wall pared1 = new Wall(city, 2,-1+i, Direction.SOUTH);
              Wall pared2 = new Wall(city, 2,6+i, Direction.SOUTH);
               Wall pared3 = new Wall(city, 8,-1+i, Direction.NORTH);
                Wall pared4 = new Wall(city, 8,6+i, Direction.NORTH);
        }
       Wall pared5 = new Wall(city, 2,0, Direction.EAST);
        Wall pared1 = new Wall(city, 7,0, Direction.EAST);
       Wall pared2 = new Wall(city, 2,6, Direction.WEST);
        Wall pared3 = new Wall(city, 7,6, Direction.WEST);
    }

    public  City getCity() {
        return city;
    }

    public void setCity(City city) {
        Lote.city = city;
    }

 



}
       
        
    
   
   /* public void area(){
        int pared =0;
        estudiante.putThing();
        if (!estudiante.frontIsClear()) {
            faceNorth();
            pared = 1;
        }
        if (estudiante.frontIsClear()) {
            faceWest();
            pared =4;
        }
        if (estudiante.frontIsClear()) {
            faceSouth();
            pared=3;
        }
        if (estudiante.frontIsClear()) {
            faceEast();
            pared =2;
        }
        
        switch (pared){
            case 1: faceEast();estudiante.move();break;
            case 2: faceNorth();estudiante.move();break;
            case 3: faceWest();estudiante.move();break;
            case 4: faceSouth();estudiante.move();break;
        }
        
        while (!estudiante.canPickThing()) {            
            if (comprobarPared()) {
                this.area[estudiante.getAvenue()][estudiante.getStreet()]= comprobarPared();
            }else{int a =dir;
               interseccion(a);
            }
        }
    } 
    private boolean comprobarPared(){
                if (estudiante.frontIsClear()) {
            faceEast();
                    if (estudiante.frontIsClear()) {
                        return true;
                    }
        }
        if (estudiante.frontIsClear()) {
            faceSouth();
                    if (estudiante.frontIsClear()) {
                        return true;
                    }
        }
        if (estudiante.frontIsClear()) {
            faceWest();
                    if (estudiante.frontIsClear()) {
                        return true;
                    }
        }
        if (estudiante.frontIsClear()) {
            faceNorth();
                    if (estudiante.frontIsClear()) {
                        return true;
                    }
        }
        return false;
        
    }
    private int interseccion(int dir){
        if(dir!=1){
        faceNorth();
        estudiante.move();
        if(comprobarPared()){
            return 1;
        }else{
            faceSouth();
            estudiante.move();
        }}
        if(dir!=2){
        faceEast();
        estudiante.move();
        if(comprobarPared()){
            return 2;
        }else{
            faceWest();
            estudiante.move();
        }}
        if(dir!=3){
        faceSouth();
        estudiante.move();
        if(comprobarPared()){
            return 3;
        }else{
            faceNorth();
            estudiante.move();
        }}
        if(dir!=4){
        faceWest();
        estudiante.move();
        if(comprobarPared()){
            return 4;
        }else{
            faceEast();
            estudiante.move();
        }}
        return 0;
    }*/


    


    
    
    
   


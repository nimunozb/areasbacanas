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
   private City city;
   private final Robot estudiante;
   private int dir;
   private boolean area[][]; 
   
    public Lote() {
        this.dir =1;
        this.area =  new boolean[10][10];
        this.city = new City();
        for (int i = 0; i < 5; i++) {
            Wall pared = new Wall(city, 2, i+1, Direction.NORTH);
            Wall pared1 = new Wall(city, 6, i+1, Direction.SOUTH);
            Wall pared3 = new Wall(city, i+2, 5, Direction.EAST);
            Wall pared4 = new Wall(city, i+2, 1, Direction.WEST);
        
        }this.estudiante = new Robot(city, 1, 1, Direction.NORTH,10);
        
    }
    public void faceNorth(){
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
    public void faceEast(){
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
    public void faceSouth(){
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
    public void faceWest(){
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
    public void area(){
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
    }

}
    

    
    
    
    
   


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unal.poo.practica;

import becker.robots.Robot;

/**
 *
 * @author Horacio
 */
public class Posicion {
    private int avenue;
    private int streed;
    private Robot robot;

    public Posicion() {
    }
    public int getAvenue() {
        return avenue;
    }

    public void setAvenue(int avenue) {
        this.avenue = avenue;
    }

    public int getStreed() {
        return streed;
    }

    public void setStreed(int streed) {
        this.streed = streed;
    }
    /**
     * @deprecated: gruarda las posicion donde esta el robot para que en la hora que no encuentre ninguna
     * pared sepa si estuvo ahi
     * @param robot 
     */
    public void guardarsiyaestuveaqui(Robot robot){
    this.avenue=robot.getAvenue();
    this.streed=robot.getStreet();
    
    }
}

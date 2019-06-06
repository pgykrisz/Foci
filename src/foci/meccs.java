/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foci;

/**
 *
 * @author krisztian.p-gy
 */
public class meccs {
    private int fordulo;
    private int hazaig;
    private int idegeng;
    private int felidhg;
    private int felidig;
    private String hazaicsnev;
    private String vendegcsnev;
   

    public meccs(String janikamu) {
        String darabol[]=janikamu.split(" ");
        this.fordulo=Integer.parseInt(darabol[0]);
        this.hazaig=Integer.parseInt(darabol[1]);
        this.idegeng=Integer.parseInt(darabol[2]);
        this.felidhg=Integer.parseInt(darabol[3]);
        this.felidig=Integer.parseInt(darabol[4]);
        this.hazaicsnev=darabol[5];
        this.vendegcsnev=darabol[6];
        
        
    }

    public int getFordulo() {
        return fordulo;
    }

    public int getHazaig() {
        return hazaig;
    }

    public int getIdegeng() {
        return idegeng;
    }

    public int getFelidhg() {
        return felidhg;
    }

    public int getFelidig() {
        return felidig;
    }

    public String getHazaicsnev() {
        return hazaicsnev;
    }

    public String getVendegcsnev() {
        return vendegcsnev;
    }
    
    @Override
    public String toString(){
        return(hazaicsnev+"-"+vendegcsnev+":  "+hazaig+"-"+idegeng+" ("+felidhg+"-"+felidig+")");
    }
}

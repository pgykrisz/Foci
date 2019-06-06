/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foci;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krisztian.p-gy
 */
public class Foci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<meccs> meccsek = new ArrayList<>();
        try {
            // TODO code application logic here
            FileReader olvaso = new FileReader("meccs.txt");
            BufferedReader okos = new BufferedReader(olvaso);
            String text = okos.readLine();
            int matchnumber = Integer.parseInt(text);
            for (int i = 0; i < matchnumber; i++) {
                text = okos.readLine();
                meccs aktualis = new meccs(text);
                meccsek.add(aktualis);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Olvasó hiba nincs ilyen file");
        } catch (IOException ex) {
            System.out.println("Olvasási hiba nem lehet olvasni");
        }
        Scanner sc = new Scanner(System.in);
        int szam = sc.nextInt();
        for (meccs m : meccsek) {
            if (m.getFordulo() == szam) {
                System.out.println(m.toString());
            }
        }
        System.out.println("***********");

        Set<String> forditottak = new TreeSet<>();
        for (meccs m : meccsek) {
            int felidogolkul = m.getFelidhg() - m.getFelidig();
            int vegeredmeny = m.getHazaig() - m.getIdegeng();
            if (felidogolkul < 0 && vegeredmeny > 0) {
                forditottak.add(m.getHazaicsnev());
            }
            if (vegeredmeny < 0 && felidogolkul > 0) {
                forditottak.add(m.getVendegcsnev());
            }

        }
        for (String s : forditottak) {
            System.out.println(s);
        }
        sc.nextLine();
        String csapat = sc.nextLine();
        int lott = 0, kapott = 0;
        for (meccs d : meccsek) {
            if (csapat.equals(d.getHazaicsnev())) {
                lott = lott + d.getHazaig();
                kapott = kapott + d.getIdegeng();
            }
            if (csapat.equals(d.getVendegcsnev())){
                lott=lott+d.getIdegeng();
                kapott=kapott+d.getHazaig();
            }
            

        }
        System.out.println(csapat+"   lőtt:"+lott+"    kapott:"+kapott);
    }

}

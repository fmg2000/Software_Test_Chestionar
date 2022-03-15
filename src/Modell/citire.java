package Modell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class citire {

    public String[] Intrebari = new String[40];
    public String[][] Rapusnsuri = new String[40][3];
    public String[] aux = new String[40];
    public String[] Raspuns_corect = new String[40];

    public void citire_fisier() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Intrebari.txt"));
        Scanner scan1 = new Scanner(new File("Raspunsuri.txt"));
        Scanner scan2 = new Scanner(new File("RaspunsCorect.txt"));
        int i = 0;
        while (scan.hasNextLine()) {
            String raspund, intrebari, ras_corect;
            raspund = scan.nextLine();
            intrebari = scan1.nextLine();
            ras_corect = scan2.nextLine();
            aux = intrebari.split(";");
            Rapusnsuri[i][0] = aux[0];
            Rapusnsuri[i][1] = aux[1];
            Rapusnsuri[i][2] = aux[2];
            Raspuns_corect[i] = ras_corect;
            Intrebari[i] = raspund;
            i++;
        }
    }
}

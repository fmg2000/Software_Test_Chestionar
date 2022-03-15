package Modell;

import com.sun.source.tree.BinaryTree;

import java.io.FileNotFoundException;
import java.util.Random;

public class Rabdom {
    citire citire = new citire();
    public String[] Intrebari1 = citire.Intrebari;
    public String[][] Rapusnsuri1 = citire.Rapusnsuri;
    public String[] Raspuns_corect1 = citire.Raspuns_corect;
    public String[] Intrebari_random =  new String[26];
    public String[][] Rapusnsuri_random = new String[26][3];
    public String[] Raspuns_corect_random = new String[26];


    public void random_26() throws FileNotFoundException {

        citire.citire_fisier();
        int n = Intrebari1.length;
        Random random = new Random();
        for(int i=0; i<14; i++) {
            int Indexrandom = random.nextInt(n);
            for(int j=0; j<n;j++)
            {
                if(Intrebari1[j]==Intrebari1[Indexrandom]) {
                    for (int k = j; k < n-1; k++){
                        Intrebari1[k] = Intrebari1[k + 1];
                        Rapusnsuri1[k] = Rapusnsuri1[k + 1];
                        Raspuns_corect1[k] = Raspuns_corect1[k + 1];
                    }
                    n--;

                }
            }
        }
        for (int i=0;i<n;i++){
            Intrebari_random[i] = Intrebari1[i];
            Rapusnsuri_random[i] = Rapusnsuri1[i];
            Raspuns_corect_random[i] = Raspuns_corect1[i];
        }
    }
}

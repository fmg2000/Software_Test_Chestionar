package Modell;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Lucrare_Chestionar {

    public int id1 = 0;
    List<Chestionqr> aux = new ArrayList();

    public List citire() throws IOException, ClassNotFoundException {
        FileInputStream fos = new FileInputStream("Chestionar.txt");
        ObjectInputStream oos = new ObjectInputStream(fos);
        List listaCitita = (List) oos.readObject();
        oos.close();
        fos.close();
        return listaCitita;

    }
    public void scriere(List<Chestionqr> lista) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("Chestionar.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        //aux = citire();
        oos.writeObject(lista);
        oos.close();
        fos.close();
    }

    public void afisare(List<Chestionqr> list)
    {
        for(Chestionqr i : list)
            System.out.println(i);
    }
}


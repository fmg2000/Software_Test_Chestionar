package Modell;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Chestionqr implements Serializable {
    int id;
    int id_chestionar;
    int raspunsuri_corecte;
    int raspunsuri_gresite;
    String[] lista_valori;

    public Chestionqr() {

        this.id = id;
        this.id_chestionar = id_chestionar;
        this.raspunsuri_corecte = raspunsuri_corecte;
        this.raspunsuri_gresite = raspunsuri_gresite;
        this.lista_valori = lista_valori;
    }

    public Chestionqr(int a1, int a2, int a3, int a4, String[] a5) {
        this.id = a1;
        this.id_chestionar = a2;
        this.raspunsuri_corecte = a3;
        this.raspunsuri_gresite = a4;
        this.lista_valori = a5;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_chestionar() {
        return id_chestionar;
    }

    public void setId_chestionar(int id_chestionar) {
        this.id_chestionar = id_chestionar;
    }

    public int getRaspunsuri_corecte() {
        return raspunsuri_corecte;
    }

    public void setRaspunsuri_corecte(int raspunsuri_corecte) {
        this.raspunsuri_corecte = raspunsuri_corecte;
    }

    public int getRaspunsuri_gresite() {
        return raspunsuri_gresite;
    }

    public void setRaspunsuri_gresite(int raspunsuri_gresite) {
        this.raspunsuri_gresite = raspunsuri_gresite;
    }

    public String[] getLista_valori() {
        return lista_valori;
    }

    public void setLista_valori(String[] lista_valori) {
        this.lista_valori = lista_valori;
    }

    @Override
    public String toString() {
        return "Chestionqr{" +
                "id=" + id +
                ", id_chestionar=" + id_chestionar +
                ", raspunsuri_corecte=" + raspunsuri_corecte +
                ", raspunsuri_gresite=" + raspunsuri_gresite +
                ", lista_valori=" + Arrays.toString(lista_valori) +
                '}';
    }

}
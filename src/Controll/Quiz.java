package Controll;

import Modell.Chestionqr;
import Modell.Lucrare_Chestionar;
import Modell.Rabdom;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Quiz implements ActionListener {

    Lucrare_Chestionar chestionar = new Lucrare_Chestionar();
    Rabdom rabdom = new Rabdom();
    Chestionqr ch = new Chestionqr();

    int id1 = chestionar.id1;
    String[] intrebari  = rabdom.Intrebari_random;
    String[][] raspunsuri  = rabdom.Rapusnsuri_random;
    String[] ans = rabdom.Raspuns_corect_random;
    List<Chestionqr> lista = new ArrayList<>();


    int[]  numer = new int[26];
    int l_numar;
    String answer ;
    String ranswer;
    int index;
    int correct_question = 0;
    int intrebari_gresite = 0;
    int total_question = 26;
    int seconds = 00;
    int min = 30;

    JFrame frame  = new JFrame();
    JTextField textfile = new JTextField();
    JTextField wrong_answers = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton Button_Trimite = new JButton();
    JButton Button_Anuleza = new JButton();
    JButton Button_Repeta = new JButton();
    JButton Button_Sari = new JButton();
    JButton Button_Afisare = new JButton();
    JButton Button_Close = new JButton();
    JCheckBox CheckBoxA = new JCheckBox();
    JCheckBox CheckBoxB = new JCheckBox();
    JCheckBox CheckBoxC = new JCheckBox();
    JLabel label_answerA = new JLabel();
    JLabel label_answerB = new JLabel();
    JLabel label_answerC = new JLabel();
    JLabel label_time = new JLabel();
    JLabel label_second = new JLabel();
    JTextField finish = new JTextField();
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            label_second.setText(String.valueOf(min)+":"+String.valueOf(seconds));
            if (seconds <= 0 && min==0)
                rezult();
            else {
                if (seconds == 0) {
                    min--;
                    seconds = 60;
                }
                seconds--;
            }
        }


    });

    public Quiz() throws IOException, ClassNotFoundException {
        rabdom.random_26();
        // List<Chestionqr> lista = new ArrayList<>();
        //Chestionqr aux = new Chestionqr();
        //System.out.println("AAAA"+ intrebari[0]+" "+intrebari[1]+" "+intrebari[2]);

        frame. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,650);  // setam marimimea aplicatie
        frame.getContentPane().setBackground(new Color(50,50,50)); // setam culoarea fundalului
        frame.setLayout(null);
        frame.setResizable(false);

        //Adaugam Text file
        textfile.setBounds(320,0,1000,50);  // setam inaltime
        textfile.setBackground(new Color(25,25,25)); // setam fundalul
        textfile.setForeground(new Color(25,255,0)); // setam culoarea de scris
        textfile.setFont(new Font("Ink Free",Font.BOLD, 30)); // setam fontul
        textfile.setBorder(BorderFactory.createBevelBorder(1)); // //setam o bordura de grosime 1
        textfile.setHorizontalAlignment(JTextField.CENTER); // setam scrisul central
        textfile.setEditable(false);

        wrong_answers.setBounds(0,0,500,50);  // setam inaltime
        wrong_answers.setBackground(new Color(25,25,25)); // setam fundalul
        wrong_answers.setForeground(new Color(25,255,0)); // setam culoarea de scris
        wrong_answers.setFont(new Font("Ink Free",Font.BOLD, 30)); // setam fontul
        wrong_answers.setBorder(BorderFactory.createBevelBorder(1)); // //setam o bordura de grosime 1
        wrong_answers.setHorizontalAlignment(JTextField.CENTER); // setam scrisul central
        wrong_answers.setEditable(false);

        //Adaugam textarea
        textarea.setBounds(0,50,1000,50);  // setam inaltime
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25,25,25)); // setam fundalul
        textarea.setForeground(new Color(25,255,0)); // setam culoarea de scris
        //textarea.setFont(new Font("Bodoni MT",Font.BOLD, 25 )); // setam fontul
        textarea.setBorder(BorderFactory.createBevelBorder(1)); // //setam o bordura de grosime 1
        textarea.setEditable(false);

        //Seteam Button
        Button_Trimite.setBounds(175,510,150,80);
        Button_Trimite.setText(" Trimte");
        Button_Trimite.setFont(new Font("ALGERIAN", Font.BOLD,20));
        Button_Trimite.setFocusable(false);
        Button_Trimite.addActionListener(this);

        Button_Sari.setBounds(350,510,150,80);
        Button_Sari.setText(" Sari");
        Button_Sari.setFont(new Font("ALGERIAN", Font.BOLD,20));
        Button_Sari.setFocusable(false);
        Button_Sari.addActionListener(this);
        Button_Sari.setVisible(true);
        Button_Sari.setEnabled(true);

        Button_Anuleza.setBounds(525,510,150,80);
        Button_Anuleza.setText(" Anuleaza");
        Button_Anuleza.setFont(new Font("ALGERIAN", Font.BOLD,20));
        Button_Anuleza.setFocusable(false);
        Button_Anuleza.addActionListener(this);
        ///....

        Button_Repeta.setBounds(350,510,150,80);
        Button_Repeta.setText("Repeta");
        Button_Repeta.setFont(new Font("ALGERIAN", Font.BOLD,20));
        Button_Repeta.setFocusable(false);
        Button_Repeta.addActionListener(this);
        Button_Repeta.setVisible(false);
        Button_Repeta.setEnabled(false);

        Button_Afisare.setBounds(175,510,150,80);
        Button_Afisare.setText("Istoric");
        Button_Afisare.setFont(new Font("ALGERIAN", Font.BOLD,20));
        Button_Afisare.setFocusable(false);
        Button_Afisare.addActionListener(this);
        Button_Afisare.setVisible(false);
        Button_Afisare.setEnabled(false);

        Button_Close.setBounds(525,510,150,80);
        Button_Close.setText("Close");
        Button_Close.setFont(new Font("ALGERIAN", Font.BOLD,20));
        Button_Close.setFocusable(false);
        Button_Close.addActionListener(this);
        Button_Close.setVisible(false);
        Button_Close.setEnabled(false);



        //Setam CheckBox
        CheckBoxA.setBounds(0,100,100,100);
        CheckBoxA.setText(" A");
        CheckBoxA.setFont(new Font("ALGERIAN", Font.PLAIN,40));
        CheckBoxA.setFocusable(false);

        CheckBoxB.setBounds(0,202,100,100);
        CheckBoxB.setText(" B");
        CheckBoxB.setFont(new Font("ALGERIAN", Font.PLAIN,40));
        CheckBoxB.setFocusable(false);

        CheckBoxC.setBounds(0,304,100,100);
        CheckBoxC.setText(" C");
        CheckBoxC.setFont(new Font("ALGERIAN", Font.PLAIN,40));
        CheckBoxC.setFocusable(false);

        //Setam Labal la raspunsuri
        label_answerA.setBounds(125,100,1000,100);
        label_answerA.setBackground(new Color(50,50,50));
        label_answerA.setForeground(new Color(25,255,0));
        //label_answerA.setFont(new Font("Bodoni MT",Font.PLAIN,20));
        label_answerA.setText("Ana are mere lmusad asjdhasd  dhs daa");

        label_answerB.setBounds(125,200,1000,100);
        label_answerB.setBackground(new Color(50,50,50));
        label_answerB.setForeground(new Color(25,255,0));
        //label_answerB.setFont(new Font("Bodoni MT",Font.PLAIN,20));
        label_answerB.setText("Ana are mere lmusad asjdhasd  dhs daa");

        label_answerC.setBounds(125,300,1000,100);
        label_answerC.setBackground(new Color(50,50,50));
        label_answerC.setForeground(new Color(25,255,0));
        //label_answerC.setFont(new Font("Bodoni MT",Font.PLAIN,20));
        label_answerC.setText("Ana are mere lmusad asjdhasd  dhs daa");

        //Secundele
        label_second.setBounds(890,510,100,100);
        label_second.setBackground(new Color(50,50,50));
        label_second.setForeground(new Color(255,0,0));
        label_second.setFont(new Font("ALGERIAN", Font.PLAIN,25));
        label_second.setBorder(BorderFactory.createBevelBorder(1));
        label_second.setOpaque(true);
        label_second.setHorizontalAlignment(JTextField.CENTER);
        label_second.setText(String.valueOf(min) + ":" +String.valueOf(seconds));

        label_time.setBounds(890,475,100,25);
        label_time.setBackground(new Color(50,50,50));
        label_time.setForeground(new Color(255,0,0));
        label_time.setFont(new Font("ALGERIAN", Font.PLAIN,20));
        label_time.setHorizontalAlignment(JTextField.CENTER);
        label_time.setText("Time: ");

        // Final

        finish.setBounds(350,225,200,100);
        finish.setBackground(new Color(25,25,25));
        finish.setForeground(new Color(25,255 ,0));
        finish.setFont(new Font("ALGERIAN", Font.PLAIN,20));
        finish.setBorder(BorderFactory.createBevelBorder(1));
        finish.setHorizontalAlignment(JTextField.CENTER);
        finish.setEditable(false);

        ///Adaugam
        frame.add(label_time); // timpul
        frame.add(label_second); //secundele
        frame.add(label_answerC);
        frame.add(label_answerB);
        frame.add(label_answerA);
        frame.add(CheckBoxC); // adugam CheckBoxC
        frame.add(CheckBoxB); // adugam CheckBoxB
        frame.add(CheckBoxA); // adugam CheckBoxA
        frame.add(Button_Trimite);
        frame.add(Button_Afisare);
        frame.add(Button_Sari);
        frame.add(Button_Anuleza);
        frame.add(Button_Close);
        frame.add(Button_Repeta);
        frame.add(textarea); // adugam textare
        frame.add(wrong_answers) ;// adaugam wrong_answer
        frame.add(textfile);  // adaugam tect_file
        frame.setVisible(true);


        nextQuiz();
    }

    public void nextQuiz() throws IOException, ClassNotFoundException {

        if(l_numar >= total_question || intrebari_gresite>4) {
            Chestionqr o = new Chestionqr(id1,id1,26-intrebari_gresite,intrebari_gresite,intrebari);
            id1++;
            lista.add(o);
            chestionar.scriere(lista);
            rezult();
        }
        else {
            if (index < total_question) {
                if(numer[index]==0){
                    textfile.setText("Intrebarea: " + (l_numar + 1) + "/26");
                    wrong_answers.setText("Greseli: " + intrebari_gresite + "/4");
                    textarea.setText(intrebari[index]);
                    label_answerA.setText(raspunsuri[index][0]);
                    label_answerB.setText(raspunsuri[index][1]);
                    label_answerC.setText(raspunsuri[index][2]);
                    timer.start();}
                else
                {
                    index++;
                    nextQuiz();
                }

            } else {

                index = 0;
                if(numer[index]==0){
                    textfile.setText("Intrebarea: " + (l_numar + 1) + "/26");
                    wrong_answers.setText("Greseli: " + intrebari_gresite + "/4");
                    textarea.setText(intrebari[index]);
                    label_answerA.setText(raspunsuri[index][0]);
                    label_answerB.setText(raspunsuri[index][1]);
                    label_answerC.setText(raspunsuri[index][2]);
                    timer.start();
                }
                else
                {
                    index++;
                    nextQuiz();
                }

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Button_Trimite.setEnabled(false);
        //Button_Anuleza.setEnabled(false);

        if(e.getSource()==Button_Close) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }

        if(e.getSource()==Button_Afisare) {
            chestionar.afisare(lista);
        }

        if(e.getSource() == Button_Repeta)
        {

            try {
                numer = new int[26];
                l_numar=0;
                index=0;
                correct_question = 0;
                intrebari_gresite = 0;
                total_question = 26;
                seconds = 00;
                min = 30;
                rabdom.random_26();
                List<Chestionqr> listanoua = chestionar.citire();
                lista = listanoua;
                Button_Afisare.setVisible(false);
                Button_Afisare.setEnabled(false);
                Button_Trimite.setVisible(true);
                Button_Trimite.setEnabled(true);
                ///
                Button_Repeta.setVisible(false);
                Button_Repeta.setEnabled(false);
                Button_Sari.setVisible(true);
                Button_Sari.setEnabled(true);
                //
                Button_Close.setVisible(false);
                Button_Close.setEnabled(false);
                Button_Anuleza.setVisible(true);
                Button_Anuleza.setEnabled(true);
                frame.remove(finish);
                nextQuiz();

            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }
        }

        if(e.getSource() == Button_Anuleza){
            CheckBoxA.setSelected(false);
            CheckBoxB.setSelected(false);
            CheckBoxC.setSelected(false);
        }
        if(e.getSource() == Button_Sari){
            index++;
            try {
                nextQuiz();
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource() == Button_Trimite) {
            numer[index] = 1;
            int corect_question_new = correct_question + 1;
            if (CheckBoxA.isSelected() && !CheckBoxB.isSelected() && !CheckBoxC.isSelected()) {
                answer = "A";
                if (answer.equals(ans[index])) {
                    correct_question++;
                }
            }
            if (CheckBoxB.isSelected() && !CheckBoxA.isSelected() && !CheckBoxC.isSelected()) {
                answer = "B";
                if (answer.equals(ans[index])) {
                    correct_question++;
                }
            }
            if (CheckBoxC.isSelected() && !CheckBoxA.isSelected() && !CheckBoxB.isSelected()) {
                answer = "C";
                if (answer.equals(ans[index])) {
                    correct_question++;
                }
            }
            if (CheckBoxA.isSelected() && CheckBoxB.isSelected() && !CheckBoxC.isSelected()) {
                answer = "AB";
                ranswer = "BA";
                if (answer.equals(ans[index]) || ranswer.equals(ans[index])) {
                    correct_question++;
                }
            }
            if (CheckBoxA.isSelected() && CheckBoxC.isSelected() && !CheckBoxB.isSelected()) {
                answer = "AC";
                ranswer = "CA";
                if (answer.equals(ans[index]) || ranswer.equals(ans[index])) {
                    correct_question++;
                }
            }
            if (CheckBoxC.isSelected() && CheckBoxB.isSelected() && !CheckBoxA.isSelected()) {
                answer = "CB";
                ranswer = "BC";
                if (answer.equals(ans[index]) || ranswer.equals(ans[index])) {
                    correct_question++;
                }
            }
            if (CheckBoxC.isSelected() && CheckBoxB.isSelected() && CheckBoxB.isSelected()) {
                answer = "ABC";
                if (answer.equals(ans[index])) {
                    correct_question++;
                }
            }
            if (corect_question_new != correct_question)
                intrebari_gresite++;
            l_numar++;
            AfisareRapuns();
        }
    }
    public void AfisareRapuns(){
        timer.stop(); /// pentru freez la ecran cand asteapta raspunsul
        Button_Trimite.setEnabled(false);
        if(ans[index].equals("A") && !ans[index].equals("B") && !ans[index].equals("C")) {
            label_answerC.setForeground(new Color(255, 0, 0));
            label_answerB.setForeground(new Color(255, 0, 0));
        }
        if(ans[index].equals("B") && !ans[index].equals("C") && !ans[index].equals("A")) {
            label_answerA.setForeground(new Color(255, 0, 0));
            label_answerC.setForeground(new Color(255, 0, 0));
        }
        if(ans[index].equals("C") && !ans[index].equals("A") && !ans[index].equals("B")) {
            label_answerB.setForeground(new Color(255, 0, 0));
            label_answerA.setForeground(new Color(255, 0, 0));
        }
        if(ans[index].equals("AB") || ans[index].equals("BA"))
        {
            label_answerC.setForeground(new Color(255,0,0));
        }
        if(ans[index].equals("AC") || ans[index].equals("CA"))
        {
            label_answerB.setForeground(new Color(255,0,0));

        }
        if(ans[index].equals("BC") || ans[index].equals("CB"))
        {
            label_answerA.setForeground(new Color(255,0,0));
        }

        Timer pause = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                label_answerA.setForeground(new Color(25,255,0));
                label_answerB.setForeground(new Color(25,255,0));
                label_answerC.setForeground(new Color(25,255,0));
                answer = "";
                Button_Trimite.setEnabled(true);
                CheckBoxA.setSelected(false);
                CheckBoxB.setSelected(false);
                CheckBoxC.setSelected(false);
                index++;
                //System.out.println("Daaaa "+index);
                try {
                    nextQuiz();
                } catch (IOException | ClassNotFoundException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        pause.setRepeats(false) ;
        pause.start();
    }
    public void rezult(){

        Button_Afisare.setVisible(true);
        Button_Afisare.setEnabled(true);
        Button_Trimite.setVisible(false);
        Button_Trimite.setEnabled(false);
        ///
        Button_Repeta.setVisible(true);
        Button_Repeta.setEnabled(true);
        Button_Sari.setVisible(false);
        Button_Sari.setEnabled(false);
        //
        Button_Close.setVisible(true);
        Button_Close.setEnabled(true);
        Button_Anuleza.setVisible(false);
        Button_Anuleza.setEnabled(false);


        if(intrebari_gresite>4  || (min==0 && seconds == 0))
        {   timer.stop();
            textfile.setText("");
            wrong_answers.setText("");
            textarea.setText("Picat");
            label_answerA.setText("");
            label_answerB.setText("");
            label_answerC.setText("");
            finish.setText("Mai incearca");
            frame.add(finish);
        }
        else {
            textfile.setText("");
            wrong_answers.setText("");
            textarea.setText("Reusit");
            label_answerA.setText("");
            label_answerB.setText("");
            label_answerC.setText("");
            finish.setText("Ati trecut cu: " + correct_question + "/20");
            frame.add(finish);
        }

    }
}

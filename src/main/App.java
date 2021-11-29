package main;

import java.util.ArrayList;
import java.util.Random;

import Connect_Four.Connect_Four;
import Connect_Four.Turn;

public class App {

    

    public static void main(String[] args) throws Exception {
        Connect_Four cf = new Connect_Four();
        //Hier steht text
        ArrayList<ArrayList<Turn>> list = new ArrayList<ArrayList<Turn>>();
        ArrayList<Thread> l = new ArrayList<Thread>();
        Random r = new Random();

        // for (int i = 0; i < 1; i++) {
        //     l.add(new Thread(new Connect_Four(list)));
        //     //Connect_Four cf = new Connect_Four();
        //     System.out.println("started Ai instance");
        //     l.get(i).start();
        // }

        // l.get(0).join();

        // for (Turn Turn : list.get(0)) {
        //     System.out.println(Turn.getNumber());;
        // }
        
    }

}

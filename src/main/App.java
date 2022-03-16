package main;

import java.util.ArrayList;
import java.util.Random;

import Connect_Four.Connect_Four;
import Connect_Four.Turn;
import Utility.Factory;

public class App {

    

    public static void main(String[] args) throws Exception {
        
        //Hier steht text
        ArrayList<ArrayList<Turn>> list = new ArrayList<ArrayList<Turn>>();
        ArrayList<Thread> l = new ArrayList<Thread>();
        Random r = new Random();
        //Connect_Four cf = new Connect_Four(list);
        for (int i = 0; i < 15; i++) {
            l.add(new Thread(new Connect_Four(list)));
            //l.add(new Thread(new TestThread()));
            //Connect_Four cf = new Connect_Four();
            l.get(i).start();
        }

        l.get(0).join();
        for (Turn Turn : list.get(0)) {
            System.out.println(Turn.getNumber());;
        }
        
    }

}

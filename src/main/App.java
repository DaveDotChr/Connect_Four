package main;

import java.util.ArrayList;
import java.util.Random;

import Connect_Four.Connect_Four;
import Connect_Four.Turn;
import Player.Teams;
import Utility.Factory;

public class App {

    

    public static void main(String[] args) {
        

        System.out.println();
        System.out.println((Teams.Blue == Teams.Red ? Teams.Red : Teams.Blue) == Teams.getOpposite(Teams.Red));
        
        //Hier steht text
        ArrayList<ArrayList<Turn>> list = new ArrayList<ArrayList<Turn>>();
        ArrayList<Thread> l = new ArrayList<Thread>();
        Random r = new Random();
        //Connect_Four cf = new Connect_Four(list);
        for (int i = 0; i < 1; i++) {
            l.add(new Thread(new Connect_Four(list)));
            //l.add(new Thread(new TestThread()));
            //Connect_Four cf = new Connect_Four();
            l.get(i).start();
        }

        try {
            l.get(0).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Turn Turn : list.get(0)) {
            System.out.println(Turn.getNumber());;
        }
        
    }

}

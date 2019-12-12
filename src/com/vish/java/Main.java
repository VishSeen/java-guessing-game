package com.vish.java;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static int input;
    private static int random;
    private static boolean isStop = false;
    private static int counter = 0;


    public static void main(String[] args) {
        //create scanner obj
         scanner = new Scanner(System.in);

        //create random number and converts to int
        double randomNum = Math.random() * 100;
        random = (int) Math.round(randomNum);
        //System.out.println("Random: " + random);


        do {
            //lifecycle
            start();

            logics();


//            try {
//
//            } catch (InputMismatchException e){
//                System.out.println(" ");
//                System.out.println("Invalid input.. Only number are accepted !");
//                System.out.println(" ");
//                System.out.println(" ");
//
//                scanner = new Scanner(System.in);
//            }
        } while (!isStop);
    }



    /* Methods */
    public static void start(){
        System.out.println("=============================");
        System.out.println("|       Guessing Game       |");
        System.out.println("=============================");
        System.out.println("| A random number has been  |");
        System.out.println("| generated. You have 10    |");
        System.out.println("| chances of guessing it.   |");
        System.out.println("|---------------------------|");
        System.out.println("| Fail to do so and it will |");
        System.out.println("| reset.                    |");
        System.out.println("|---------------------------|");
        System.out.println("| The number will be from   |");
        System.out.println("| 1 - 100.                  |");
        System.out.println("=============================");
        System.out.println("|         GOOD LUCK  !!     |");
        System.out.println("=============================");

        userIn();
    }

    public static void userIn(){
        if(counter != 10){
            System.out.println(" ");
            System.out.println(" ");
            System.out.print("Enter number : ");

            input = scanner.nextInt();

            System.out.println(" ");
            System.out.println(" ");
        } else {
            System.out.println(" ");
            System.out.println("No more inputs.. You failed..");
            end();
        }
    }

    public static void logics(){
        //loop 10 times to check for the answer
        while(counter <= 10){
            counter++;

            if(input > random){
                System.out.println(input + " is TOO HIGH...");

                userIn();
            } else if(input < random) {
                System.out.println(input + " is TOO LOW...");

                userIn();
            } else {
                congrats();
                break;
            }
        }

        counter = 1;
    }



    public static void congrats(){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("=============================");
        System.out.println("|    CONGRATULATIONS !!!    |");
        System.out.println("|   You guessed it right.   |");
        System.out.println("=============================");
        System.out.println(" ");
        System.out.println(" ");

        isStop = true;
        end();
    }

    public static void end(){
        System.out.println(" ");
        System.out.println("Do you want to play again ?");
        System.out.println("[Y] - Yes / [N] - No");

        System.out.print("Input : ");
        String ans = scanner.next();

        if(ans.equalsIgnoreCase("y")) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("-----------------------------------------------");
            System.out.println(" ");
            System.out.println(" ");

            counter = 0;
            isStop = false;
        } else if (ans.equalsIgnoreCase("n")){
            System.out.println(" ");
            System.out.println(" ");

            stop();
        } else {
            System.out.println(" ");
            System.out.println(" ");

            System.out.println("Wrong option try again..");
            System.out.println(" ");
            end();
        }
    }


    public static void stop(){
        System.out.println("===================================");
        System.out.println("| Thank you for playing this game. |");
        System.out.println("|         SEE YOU LATER !!!        |");
        System.out.println("===================================");

        isStop = true;
    }

}

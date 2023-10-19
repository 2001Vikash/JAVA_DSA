package com.company;
import java.util.Random;
import java.util.Scanner;
public class CWH_Rock_paper_game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 0 for Rock, 1 for Paper, 2 for Scissor .
        System.out.println("Enter 0 for Rock, 1 for Paper, 2 for Scissor");
       int userInput=sc.nextInt();
        Random rand = new Random();
        int computerInput = rand.nextInt(3);
        if (userInput == computerInput) {
            System.out.println("Game is Draw!");
        }
        else if (userInput == 0 && computerInput == 2 || userInput == 1 && computerInput == 0
                || userInput == 2 && computerInput == 1) {
            System.out.println("You win!");
        }
        else {
            System.out.println("Computer win!");
        }
        System.out.println("Computer choice ="+computerInput);
    }
    }


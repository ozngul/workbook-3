package com.pluralsight;
import java.util.Scanner;


public class FamousQuotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] quotes = {
                "The only limit to our realization of tomorrow is our doubts of today.",
                "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                "Believe you can and you're halfway there.",
                "Do what you can, with what you have, where you are.",
                "What you get by achieving your goals is not as important as what you become by achieving your goals.",
                "The future belongs to those who believe in the beauty of their dreams.",
                "The best way to predict your future is to create it.",
                "Act as if what you do makes a difference. It does.",
                "Keep your face always toward the sunshine—and shadows will fall behind you.",
                "You are never too old to set another goal or to dream a new dream."
        };

      /*  System.out.print("Enter a number between 1 and 10: ");
        int choice = scanner.nextInt();  // Bu satır hataya açık

        System.out.println(quotes[choice - 1]);  // Hatalı sayı girilirse crush olur */

        try {
            System.out.print("Enter a number between 1 and 10: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice >= 1 && choice <= 10) {
                System.out.println(quotes[choice - 1]);
            } else {
                System.out.println("Please enter a number from 1 to 10.");
            }

        } catch (NumberFormatException e) {
            System.out.println("That's not a valid number.");
        }
    }
}

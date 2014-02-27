

import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class JavaApplication1 {
	public static void main(String[] args) {
		int number = new Random().nextInt(100)+1;
                int theGuess = 0;
                Scanner scanner = new Scanner(System.in);
                System.out.print("Guess a number from 1 to 100");
                while(theGuess != number){
                        theGuess = scanner.nextInt();
                        if (theGuess < number){
                                System.out.println("guess higher");
                        }
                        else if (theGuess > number){
                                System.out.println("Guess lower");
                        }
                }
                    
		
		System.out.println(" Aba Yow won");
		
		
				
		
	}
}

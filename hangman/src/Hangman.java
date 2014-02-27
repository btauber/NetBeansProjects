/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.reflect.Array;
import static java.rmi.Naming.list;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author benjamintauber
 */
public class Hangman {

    /**
     //* @param args the command line arguments
     */
    public String [] words = {"people","pizza","airplane","tauber"};
    public int outs = 0;
    public char guesses[];
    public char guess;
    public String theword;
    public int row = 0;    
    public boolean []usedAlpha = new boolean[26];
    public void start(){
        int number = new Random().nextInt(words.length);
        theword = words[number];
        guesses = new char[theword.length()];
        char underline = '_';
        Arrays.fill(guesses,underline);
       
        Scanner scanner = new Scanner(System.in);
        while(outs < 10 ){
        drawScreen();
        System.out.println("guess a letter");
        char guesss = scanner.next().charAt(0);
         guess = Character.toLowerCase(guesss);
        if(usedAlpha[guess - 'a'] == true){
           
            System.out.println("you have already picked " + guess);
           
            continue;
        }else{
             usedAlpha[guess - 'a'] = true;
        }
        checkTheGuess();
        if(checkTheLetter()==false){
            outs++;
        }
           if(row == theword.length()){
               System.out.println("you won");
               break;
           }
        }
        System.out.println("the guessing word was " + theword);
    }
    public void checkTheGuess(){
        for(int i=0;i < theword.length(); i++){
            if(theword.charAt(i) == guess){
                guesses[i] = guess;
              row++;
                
            }
        }   
        
    }
    public boolean checkTheLetter(){
        for(int i=0;i < theword.length(); i++){
            if(theword.charAt(i) == guess){
                return true;
            }    
        
        }
        return false;
    }
    public void drawScreen(){
        drawGuesses();
        drawPerson();
    }
    public void drawGuesses(){
       for(char whitespace : guesses){
           System.out.print(whitespace +" ");
       }
          System.out.print("Used letters are ");
        for(char i = 0; i <usedAlpha.length;i++){
            if(usedAlpha[i] == true){
                
                char c = (char) ('a'+i);
                System.out.print(c);
            }
        }
            System.out.println();  
        
    }
    public void drawPerson(){
        System.out.println("you have " + outs + " outs");
        String newLine = System.getProperty("line.separator");
        if(outs == 1){
            System.out.println("           ______"+newLine+"          |      |"+newLine+"          |      |"+newLine+"          |______|");
        }if(outs == 2){
            System.out.println("           ______"+newLine+"          |    o |"+newLine+"          |      |"+newLine+"          |______|");
        }if(outs == 3){
            System.out.println("           ______"+newLine+"          | o  o |"+newLine+"          |      |"+newLine+"          |______|");
        }if(outs == 4){
            System.out.println("           ______"+newLine+"          | o  o |"+newLine+"          |  ()  |"+newLine+"          |______|");
        }if(outs == 5){
            System.out.println("           ______"+newLine+"          | o  o |"+newLine+"          |  ()  |"+newLine+"          |__<>__|");
        }if(outs == 6){
            System.out.println("           ______"+newLine+"          | o  o |"+newLine+"          |  ()  |"+newLine+"          |__<>__|"+newLine+"             ||  "+newLine+"             ||  ");
        }if(outs == 7){
            System.out.println("           ______"+newLine+"          | o  o |"+newLine+"          |  ()  |"+newLine+"          |__<>__|"+newLine+"             ||  "+newLine+"             ||  "+newLine+"     *_______||");
        }if(outs == 8){
            System.out.println("           ______"+newLine+"          | o  o |"+newLine+"          |  ()  |"+newLine+"          |__<>__|"+newLine+"             ||  "+newLine+"             ||  "+newLine+"     *_______||_______*");
        }if(outs == 9){
            System.out.println("           ______"+newLine+"          | o  o |"+newLine+"          |  ()  |"+newLine+"          |__<>__|"+newLine+"             ||  "+newLine+"             ||  "+newLine+"     *_______||_______*"+newLine+"            /||"+newLine+"           / ||"+newLine+"          /  ||");
        }if(outs == 10){
            System.out.println("           ______"+newLine+"          | o  o |"+newLine+"          |  ()  |"+newLine+"          |__<>__|"+newLine+"             ||  "+newLine+"             ||  "+newLine+"     *_______||_______*"+newLine+"            /||\"+ newLine+"           / || \"+newLine+"          /  ||  \");
        }
    }
  
    
    public static void main(String[] args) {
        // TODO code application logic here
        Hangman hangman = new Hangman();
        hangman.start();
    }
    
}
  /*
           ______
          | o  o |
          |  ()  |
          |__<>__|
          "  ||  "
     *_______||_______*
            /||\
           / || \
          /  ||  \



           ______
          | o  o |
          |  ()  |
          |__<>__|
          "  ||  "
     "*_______||       "
            /||\
           / || \
          /  ||  \


*/ 
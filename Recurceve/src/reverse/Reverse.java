package reverse;

import java.util.Scanner;

public class Reverse {
   
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a sentence for reverse output");
        String theWord = scanner.nextLine();
        quizz(theWord);
        
    }
   
        public static void quizz(String theWord)
        {
            int index = 0;
            int numberOfWords = 1;
            String localVar = "";
            
            for(int i = 0;i<theWord.length();i++){
                if(theWord.charAt(i) == ' '){
                    numberOfWords++;
                }
            } 
            
            String[] myArray = new String[numberOfWords ];
               
            for(int i = 0;i<theWord.length();i++)
            {
                if(theWord.charAt(i) != ' ' ){
                    localVar += theWord.charAt(i);
                }
                else
                {
                    myArray[index] = localVar;
                    localVar ="";
                    index++;
                }
            }
            myArray[index] = localVar;

            for(int i =  myArray.length -1 ;i > -1;i --){
               System.out.print(myArray[i]+" ");
               
            }
          
        }
}


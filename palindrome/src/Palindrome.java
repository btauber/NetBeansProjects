/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benjamintauber
 */
public class Palindrome {

    
    
    
    public static boolean isPalindrome(String aword){
        String theword = "";
        for(int i =0;i < aword.length(); i++){
            if(aword.charAt(i) != ' '){
                theword += aword.charAt(i);
            }
     
        }
        for(int i =0; i < theword.length() /2; i++){
            if (theword.charAt(i) != theword.charAt(theword.length())-i -1){
            return false;
            }
        }
            return true; 
    }

public static void main(String[] args) {
        // TODO code application logic here
        if (args.length == 0){
        System.err.println("Expectedstring argument");
        System.exit(1);
        }
        for(int i = 0; i < args.length; i++){
            String theword = args[i];
        
        if(isPalindrome(theword.toLowerCase())){
            System.out.println(theword + "is a palindrome");
        }else{
            System.out.println(theword + "is not a palindrome");
        }
        }
    }








}






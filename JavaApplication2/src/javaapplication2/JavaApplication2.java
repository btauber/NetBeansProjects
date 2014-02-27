/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

import java.util.Scanner;

/**
 *
 * @author benjamintauber
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter text");
        s = scanner.nextLine();
String result = new StringBuffer(s).reverse().toString();
            System.out.println(result);
    }
    }
    


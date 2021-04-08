package JavaTest;

import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        
        String str=scanner.nextLine();
        
        int location=str.indexOf(".");
        
        int a=Integer.parseInt(str.substring(0,location));
        
        int b=Integer.parseInt(String.valueOf((char)str.charAt(location+1)));

        System.out.println(b>=5?a+1:a);
        
        }
}
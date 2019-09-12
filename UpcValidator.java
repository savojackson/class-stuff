import java.io.File;
import java.util.*;
import java.io.*;

public class UpcValidator{
   public static File file;
   public static int [][]arr;
   
   
         public static void validation(){
         int result;
         for(int row =0; row<arr.length;row++){

        int evenSum =0;
        int oddSum =0;
        int examineSum =0;
         
          for(int colume =0; colume < arr[row].length; colume++){

              if(colume%2==0){
                  oddSum += arr[row][colume];
               }
              else if (colume%2 > 0){
              
                    if(colume !=11 ){
                     evenSum +=arr[row][colume];
                  }
               }
               result =(3* oddSum) +evenSum;
                if( result % 10 ==0){
                    examineSum =0;
                }
                else{
                  examineSum =10 -(result %10);
                  
               }
             }
             printResult(examineSum,row);
           }
         }
         
         public static void printResult(int examineSum, int row){
            for(int colume =0; colume< arr[row].length;colume++){
               System.out.println(arr[row][colume] +"\t\t");
               }
               if (arr[row][arr[row].length -1] != examineSum){
                  System.out.println("\tinvalid: " +examineSum);
                 }
               else{
                     System.out.println("valid");
                   }
             }
         public static void main(String args[])throws FileNotFoundException{
              if(args.length > 0){
                  file = new File(args[0]);
       }
             else {
                   System.out.println("not Found");
       }
          populateArr();
          validation();
      }
        public static void populateArr()throws FileNotFoundException{
      
           int c= 0;
           String upc = "";
         
              try{
                  Scanner input =new Scanner(file);
                  
              while (input.hasNextLine()){
                    upc +=  input.nextLine();
                 }
                 
                arr =new int[ upc.length()/12][12];
                System.out.println(upc);
                int count= 0;
                for(int row =0; row<arr.length;row++){
                     for(int colume =0; colume < arr[row].length; colume++){
                     arr[row][colume] =Character.getNumericValue(upc.charAt(count));
                     count++;
                 }
             }
          }
          catch (FileNotFoundException e ){
            System.out.println(e);
        }
      }
      

        }
               
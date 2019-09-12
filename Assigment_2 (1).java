import java.io.File;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

 
 public class Assigment_2
 {
    int checkSum, result, evenSum,oddSum;

  
      public void addtion(Int[] b){
  
    for (int i = 0; i<= b.length-2; i++){
      
       if(i==0)
         {
          oddSum= oddSum +b[i];
         }
             
           {
             if((i%2==0)){
             oddSum = oddSum + b[i];
            }
         
             else 
            {
             evenSum = evenSum +b[i];
            }
          }
        }
    	step4(b);
      }
  
  public void step4(Int [] b){
      int i;
	  checkSum = (3* oddSum)+evenSum;   
     if(checkSum %10==0)
      System.out.print("0");
    
     else if
     
          (checkSum == b[i])
           
            System.out.println("CheckSum is " + checkSum);
     
       else
            System.out.print("CheckSum "+ checkSum + " Not Vaild");
     }        
     

     }
     public static void main(String[] args) throws FileNotFoundException {
 		
    	 Scanner scan;
    	 char[]array = new char[12];
    	 int[]nums = new int[12];
    	 scan = new Scanner(new File(args[0]));
    	 String text = scan.next();
    	 ArrayList<String> strings = new ArrayList<String>();
    	 int index = 0;

    	 while (index < text.length()) {
    	     strings.add(text.substring(index, Math.min(index + 12,text.length())));
    	     index += 12;
    	 }

    	 Iterator<String> itr = strings.iterator();
    	 		while(itr.hasNext()){
    	          String str = itr.next();
    	          
    	          for(int i = 0;i<=str.length()-1;i++)
    	          {
    	          array[i] = str.charAt(i);
    	          nums[i] = Character.getNumericValue(array[i]);
    	          
    	          }
    	          addition(num);
    	          }
    	       }
    	    }
  }
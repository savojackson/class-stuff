import java.io.File;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

 
 public class Assigment_2
 {
     static int checkSum, result, evenSum,oddSum;

     public static void main(String[] args) throws FileNotFoundException {
      	 Scanner scan;
    	 //char array[12]= {'\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0'};
    	 //int nums[12] = {1, 3, 5, 7, 9, 5, 4, 5, 5, 4, 4, 5};
       char[] array;
       int[] nums;
       array = new char[8+4];
       nums = new int[12];
       
    	 scan = new Scanner(args[0]);
    	 String text = scan.next();
    	 ArrayList<String> strings = new ArrayList<String>();
    	 int index = 0;

    	 while (index < text.length()) {
    	     strings.add(text.substring(index, Math.min(index + 12,text.length())));
    	     index += 12;
    	 }
       array= new char[12];
    	 nums= new int[12];
    	 Iterator<String> itr = strings.iterator();
    	 		while(itr.hasNext()){
    	          String str = itr.next();
    	          
    	          for(int i = 0;i<=11;i++)
    	          {
	    	          array[i] = str.charAt(i);
	    	          nums[i] = Character.getNumericValue(array[i]);

	    	          
    	          }
    	          
    	          for (int i = 0; i<= nums.length-2; i++){
    	              
    	              if(i==0)
    	                {
    	                 oddSum= oddSum +nums[i];
                           	                                   //System.out.println(oddSum);

    	                }
    	                    
    	                  {
    	                    if((i%2==0)){
    	                    oddSum = oddSum + nums[i];
    	                   }
    	                
    	                    else 
    	                   {
    	                    evenSum = evenSum +nums[i];
    	                   }
    	                 }
    	               }
    	          
    	          checkSum = (3* oddSum)+evenSum;  
                              // System.out.println("checksum" + checkSum);

             double total = checkSum % 10;
             double trueChecksum= (10-total);

              // int finaltotal =  total;
                    	                                  // System.out.println(nums[11]+"this");
               //System.out.println("mod" + 79%10);
    	          if(total==0.0)
    	          
    		          System.out.println("Checksum is 0");
 
                
               if(total == nums[11])
                
                  System.out.println("The checksum is: " +total);
                  
               else
                  System.out.println("The checksum should be: " + trueChecksum);
                
                
    	          /*else if(checkSum == nums[11]) {

    	                 System.out.println("CheckSum is " + checkSum);
    	          }
    	            else
    	                 System.out.println("CheckSum "+ checkSum + " Not Vaild");
    	          */
    	          /*
                Add the digits in the odd-numbered positions (first, third, fifth, etc.) together and multiply the total by three: 
6+2+7+9+1+6=31   31x3=93
Add the digits in the even-numbered positions (second, fourth, sixth, etc.).
9+7+1+8+1=26
Add the two results together:
93+26=119
Now what single digit number makes the total a multiple of 10? That’s the check digit.
119 + 1 = 120
1 is the check digit. The full UPC number is now 692771981161
                */
    	          }
    	       }
    	    }
   
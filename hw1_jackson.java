import java.util.*;
public class hw1_jackson{
 
 public static int [] items;
 
 
    public static void inputArray(int inputSize){
     items = new int [inputSize];
       for(int i= 0; i< items.length;i++)
       {
         items[i] = (int)(Math.random()* 1000001 + 1);
       }
      
       Arrays.sort(items);
     }
     
     public static boolean linearSearch(int key){
         for(int i = 0; i< items.length; i++){
         if (key ==items[i]){
         
         return true;
      }
      
     }
         return false;
    }
    
    public static boolean binarySearch(int key){
    
     int low =0; 
     
       int high = items.length - 1;
       int mid;
       
       while( low <= high){
                mid = (low + high)/2;
            if(items[mid]<key){
            
            low = mid +1; 
            }
           else if (items[mid] > key){
           high = mid -1;
          
          }
          else{
             return true;
          }
        }         
         return false;
     }
  public static void main (String args[])
  {
    
    Scanner input = new Scanner(System.in);     
    System.out.println(" Enter input Size");
    int Size = input.nextInt();
    
    int key = (int)(Math.random()* 100001 + 1);

    inputArray(Size);  
    System.out.println("BinarySearch");
    long T1 = System.nanoTime();
    System.out.println("key =" + key +"\n");
    System.out.println("" + binarySearch(key)+ "\n");
    long T2 =System.nanoTime();
    System.out.println(T2-T1 + "\tTime\n\n");
    
    System.out.println("linerSearch");
    long T3 = System.nanoTime();
    System.out.println("key =" + key +"\n");
    System.out.println("" + linearSearch(key)+ "\n");
    long T4 =System.nanoTime();
    System.out.println(T4 - T3 + "\tTime\n\n");

    
    }

   }
   

           
            
           
      
//**************************************************************
//*   Authors: Landon Bullard & Levi Sutton
//*
//*   Date: 11/08/2017   
//*
//*   Class: CS 1302 B
//*
//*   Program: MyMap10
//*
//*   Purpose: Read text file with keywords, search any given
//*            java program and count the ammount any given
//*            keyword is used. Display in alphabetical order
//*            and in descending order
//*
//**************************************************************

import java.util.*;
import java.io.File;

public class MyMap0 //start of MyMap10 class
{
   public static void main(String[] args) throws Exception //beginning of main method 
   {
         
      File file = new File(args[0]); //argument for file to search
      File keyW = new File(args[1]); //text file of all key words
      
      Map<String, Integer> mapW = new TreeMap<>(); //creating the treemap 
      
   

      Scanner scan = new Scanner(keyW); //scan the text file for the keywords 
      while (scan.hasNextLine()) //keeps going until the end
      {
         String keyLines = scan.nextLine().trim(); //trims each line
         String[] keyWords = keyLines.split(" "); //splits each line into words
         if (keyLines.isEmpty()) //skips empty lines
         {
            continue;
         }
         for (int i = 0; i < keyWords.length; i++) //for loop that goes through each keyword
         {
            String key = keyWords[i].toLowerCase(); //puts the key words into lowercase
            if (!mapW.containsKey(key)) //if the keyword is not in the map yet 
            {
            mapW.put(key,0); //adds the keyword and puts a zero as its value
            }
            else 
            {  
               int value = mapW.get(key);
               value++;                   //else if the value is already in the map increase the value by 1
               mapW.put(key,value);
            }
         }        
      }      
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) //scans through the specified program
      {
         String inputLines = input.nextLine().trim(); //splits the program into lines
         String[] inputWords = inputLines.split("[,;.{}()!<> ]"); //splits each line into words
         
         for (int i = 0; i < inputWords.length; i++) //loops through each word in the line
         {
            if (inputWords[i].equals("//")) //if the the loop runs into a comment its breaks to the next line
            {
               break;
            }
            if (mapW.containsKey(inputWords[i])) //if keyword is found in program the value is increased by one
            {
               int value = mapW.get(inputWords[i]);
               value++;
               mapW.put(inputWords[i],value);
            }
         }
       }
         
      System.out.println("Alphabetical Order");
      System.out.println("______________________");
      mapW.forEach ((k, v) -> System.out.printf("\n%-20s%-20d", k,v));   //printing out the tree map in alphabetical order

      System.out.println("\n______________________");
      
      ArrayList<Integer> keyValues = new ArrayList<>(mapW.values()); //adding the values of the map into an arraylist
      ArrayList<String> importantWords = new ArrayList<>(mapW.keySet());//adding the keywords into a seperate arraylist
      
      int count = 0;
      String temp = "";
      for (int i = 0; i < keyValues.size(); i++)         //     
      {                                                  //    
         for (int j = 1; j < keyValues.size() - i; j++)  //  
         {                                               //  
            if (keyValues.get(j-1) < keyValues.get(j))   //    This is a bubble sort 
            {                                            //  to sort the numbers from greatest 
               count = keyValues.get(j-1);               //  to least and it also sorts the corresponding
               keyValues.set(j-1,keyValues.get(j));      //  keywords in the words arraylist
               keyValues.set(j,count);                   //   
               temp = importantWords.get(j-1);           //   
               importantWords.set(j-1,importantWords.get(j));
               importantWords.set(j,temp);
               
            }
         }
      }    
      System.out.println("\n\nDescending Order\n");
      System.out.println("______________________"); //descending order label

      Map<String, Integer> setW = new LinkedHashMap<>(); //creating a linked hash map to put the keys and values in descending order
      
      for (int i = 0; i < keyValues.size(); i++)
      {
         setW.put(importantWords.get(i),keyValues.get(i)); //adds the words and values into the new linked hash map
      }
      setW.forEach ((k, v) -> System.out.printf("\n%-20s%-20d", k,v));//prints out the all words and values in the linked hash map   
      System.out.println("\n______________________");
   }
}
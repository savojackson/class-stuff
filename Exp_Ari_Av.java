import java.io.File;  
import java.io.PrintWriter;
import java.io.FileNotFoundException;  
import java.util.Scanner;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
import java.io.IOException;  
import java.util.Random;

public class Exp_Ari_Av {  	 
	 public static double expAvg(double preExpAvg, int newSample){
	 	     double a = 0.125;
       double estRTT =(1-0.125) *preExpAvg + 0.125 * newSample;
       return estRTT;
	 }
	 
	 public static double ariAvg(double preAriAvg, int newSample, int n){
		// To be completed...
	   double first = (((double)n-1)/(double)n)*preAriAvg;
       double second = (double)newSample/(double)n;
       return first + second;
     }
	 
	 public static void sampleRTT2EstimatedRTT(Scanner in, PrintWriter out)throws IOException{ 
      Random rand = new Random();
      
      double initial1 = rand.nextInt(101);
      double initial2 = rand.nextInt(101);
      in.useDelimiter(" ");

      int n = 1;
      int total = 0;
      int sampleRTT = 0;

      while(in.hasNextLine())
      {
        String nextline = in.nextLine();
        Pattern pattern = Pattern.compile("time=(.*?)ms");
        Matcher matcher = pattern.matcher(nextline);

        while(matcher.find())
        {
          sampleRTT = Integer.parseInt(matcher.group(1));
          double a = (double)initial1;
          double b = (double)initial2;

          total += sampleRTT;
          double expAvg = expAvg(a, sampleRTT);
          double arrAvg = ariAvg(b, sampleRTT, n);

          out.printf("%d \t\t %.2f \t %.2f", sampleRTT, expAvg, arrAvg);
          out.println();

          initial1 = expAvg;
          initial2 = arrAvg;
          n++;
        }
      }
	 }
  
	 public static void main (String[] args){
	 	try{
			
			Scanner fileScanner = new Scanner(new File("data.txt")); 
			PrintWriter filePrinter = new PrintWriter(new File("output.txt"));
			
			filePrinter.print("SampleRTTs\tExpAvgs\tAriAvgs");
			filePrinter.println();
			
			sampleRTT2EstimatedRTT(fileScanner, filePrinter);
			
			fileScanner.close();
			filePrinter.close();
	
		}catch(IOException e){
			System.out.println("Error opening file.");
			System.exit(0);
		}
	 }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
   public class otherUPCChecksum {
           private static void validate(String upc_in)
         {
            int oddSum = 0;
            int evenSum = 0;
            long upc = Long.parseLong(upc_in);
            int checksumFound = (int)(upc % 10);//extract the last digit
    
      //drop the last digit
    
          upc /= 10;
            for(int i = 11; i >= 1; i--)
         {
         int digit = (int)(upc % 10);
         if(i % 2 == 0) //even position
         evenSum += digit;
         else
         oddSum += digit;
     upc /= 10;
    }
         int value = 3 * oddSum + evenSum;
         int remainder = value % 10;
         int calculatedCheckSum;
      if(remainder == 0)
            calculatedCheckSum = 0;
       else
         calculatedCheckSum = 10 - remainder;
         if(calculatedCheckSum == checksumFound)
               System.out.println(upc_in + " valid");
       else
           System.out.println(upc_in + " invalid, correct checksum = " + calculatedCheckSum);
}
        
        
         public static void main(String[] args) {

            if(args.length != 1)
      {
            System.out.println("Usage: java UPCChecksum <inputfilename>");
            return;
   }
         try {
            Scanner infile = new Scanner(new File(args[0]));
            while(infile.hasNext())
   {
         String upc = infile.next();
         validate(upc);
   }
         infile.close();
   } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
   }
   }
}

       

package file;
import GAalgo.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Updateall {
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
      String chosen= "";
        String companyType[]= { "fmcg","it", "banks", "telecom", "heavy", "transport", "channel", "pharma"};
        for (int i=0; i< companyType.length ; i++)
        {
            System.out.println(companyType[i]+"::----");
            FileInputStream f= new FileInputStream(companyType[i]);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine())
            {
                chosen = sc.nextLine();
                System.out.println(chosen+":");
                Read.read(chosen, 1);
                Read.read(chosen,2);
                
            
            }
   
        } 
        Expert e = new Expert();
        e.updateExpert();    
    }
    
}

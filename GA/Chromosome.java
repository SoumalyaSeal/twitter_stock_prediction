
package GAalgo;

import file.Datewise;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author ss
 */
public class Chromosome 
{
  float key[];
  float rho;
  int chr_id;
   
   
   public void generateChromosome(int n)
   {   Keyword kw=new Keyword(); 
       chr_id = n;
       rho=0;
       key = new float[kw.company.length];
       for(int i =0; i<key.length;i++)
            key[i]=0;	    
   }
   public float[] returnKey()
   {
       return key;
   }
   
   
   float returnRho()
   {
       int num=0;
       float total=0;
       try{    
                
             String companyType[]= {"transport","it","telecom", "fmcg", "channel", "pharma","heavy","banks"};
               //String companyType[]= {"it"};
               for(int i=0;i<companyType.length;i++)
               {                     
                   FileInputStream f=new FileInputStream(companyType[i]);
                   Scanner r=new Scanner(f);
                   while(r.hasNextLine())
                   {    
                        String x=r.nextLine();
                        String finame[]=x.split("/");
                        int div=finame.length;
                        String filename=finame[0];
                        FileInputStream filin=new FileInputStream(filename+" analysed final");
                        //FileInputStream filin = new FileInputStream(" analysed final");
                        Scanner sc=new Scanner(filin);
                        String write;
                        File fw=new File("tempcomp");
                        FileWriter fwr=new FileWriter(fw);
                        BufferedWriter bw=new BufferedWriter(fwr);
                        bw.write("");
                        while(sc.hasNextLine())
                        {   
                            String ss=sc.nextLine();
                            String part[]=ss.split("#");
                            String datepart[]=ss.split("//");
                            write=datepart[0]+"//"+"abcd = ";
                            int pos=0;
                            Keyword kw=new Keyword();
                            while(pos<kw.company.length)
                            {   String t[]=kw.company[pos].split("-");
                            
                                if(part[1].equals(t[0]))
                                {  
                                    write=write+key[pos]+"#"+t[0];
                                    //System.out.println(write);
                                    bw.write(write);
                                    bw.newLine();
                                    break;
                                }
                                pos++;
                            } 

                        }
                        bw.close();        
                        Datewise.myfunc("tempcomp", 1, 0, 0,div);    
                        System.out.println("calling calcRho");
                        Rho rw = new Rho();
                        String to=rw.ShowData(filename);
                        String parts[]=to.split("@");
                        System.out.println(filename);
                        //total+= rw.ShowData(filename);    
                       // total+=rw.ShowData("infosys");
                        num=num+Integer.valueOf(parts[1]);
                        total=total+(Float.valueOf(parts[0])*Integer.valueOf(parts[1]));
                    }
               }           
           }
           catch(Exception e)
            {     
                e.printStackTrace();
            } 
       rho= total/num;
       System.out.println("final rho is : "+rho);
       return rho;
      }
}
  
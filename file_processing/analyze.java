package file;
import java.io.*;
import java.util.*;
import file.Read.*;
import java.util.regex.*;
import file.savedata.*;

class Analyze 
{
    
    
    
    public static void analyze(String name, String co)
    {
       
      String x="";
        try {
            FileInputStream fis = new FileInputStream(name);
            Scanner scanner = new Scanner(fis);
            while(scanner.hasNextLine())
            {
                 x=scanner.nextLine();
                 String pattern=co;
       Pattern pat=Pattern.compile(pattern);
       Matcher m=pat.matcher(x);
       boolean val=m.find();
       String[] date=x.split("//Date");
       String dategot=date[1];
       x=date[0];int k=0;
       if(val==true)
       {            String[] temp=x.split("; ");
                if(temp.length==2)
                {   if(temp[1].contains(" rs")||(temp[1].contains(" call"))||(temp[1].contains(" put ")))
                { k=1;
                
                }
                
                }
                            
    	    
                for(int i=0;i<temp.length;i++)
                {   
                   
                    
                    if(temp[i].contains(co)&&k!=1)
                    {   temp[i]=temp[i].concat("//Date");
                        temp[i]=temp[i].concat(dategot);
                        System.out.println(temp[i]);
                        savedata.writenew(name,temp[i]);
                       
                    }
                    
                    else if(k==1)
                    {   temp[0]=temp[0].concat("; ");
                        temp[0]=temp[0].concat(temp[1]);
                        temp[0]=temp[0].concat("//Date");
                        temp[i]=temp[i].concat(dategot);
                        System.out.println(temp[0]);
                        
                       savedata.writenew(name,temp[0]);
                        k=0;
                        break;
                    }
                    
                    
                
                }
                    
           
       }          
            }
        }
      catch (FileNotFoundException e){
            e.printStackTrace();}
        
     
     
    }
    
    
}




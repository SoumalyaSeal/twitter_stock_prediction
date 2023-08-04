package file;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class savedata
{
    
    static public void writenew(String name,String advice)
    {
       
        try {
 
		
			File file = new File("temp");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(advice);
                        bw.newLine();
			bw.close();
 
 
		} catch (IOException e) {
			e.printStackTrace();
		} 
       
    }
    
    static public void overwrite(String name)
    {       
        
            try{
                FileWriter fw = new FileWriter(name);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			bw.close();
               }
            
            catch(IOException e)
            {   e.printStackTrace();
            
            }
        
        
        
       try {
 
		FileWriter fileWritter = new FileWriter(name,true);
		BufferedWriter bufferWriter = new BufferedWriter(fileWritter);	
                     
			// if file doesnt exists, then create it
                  FileInputStream fis = new FileInputStream("temp");
                    Scanner scanner = new Scanner(fis);
                    while(scanner.hasNextLine())
                    {    String remaining=scanner.nextLine();
                         
                        
                         bufferWriter.write(remaining);
                         bufferWriter.newLine();
                         
                         
                    }
                    bufferWriter.close();    
                        
			FileWriter fw = new FileWriter("temp");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
                       
			bw.close();
 
 
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
       
    }
    public static void putvalue(String co,String[] pattern){
        
        try {
            
           int i =0;     
           File file=new File(co+" analysed");
           file.createNewFile();
           FileWriter fileWritter = new FileWriter(file.getName());
    	   BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
           String advice, text;
           String value="3";
            
           //System.out.println("New program part \n\n");
             
            
                FileInputStream fco = new FileInputStream(co);
                Scanner sco = new Scanner(fco);
                while (sco.hasNextLine())
                {   
                    advice = sco.nextLine();
                    String parts [] = advice.split("//");
                    int flag=0;
                    //System.out.println(parts[1]+"&&"+parts[0]);
                    FileInputStream valf = new FileInputStream("value");
                    Scanner sval = new Scanner(valf);
                    boolean flag1 = false, flag2= false;
                   
                    FileInputStream both = new FileInputStream("bothvalue");
                    Scanner sboth = new Scanner(both);
                   
                     if (flag1 == false&&flag!=1)
                     {          flag2=false;
                                while (sboth.hasNextLine())
                                {   
                                   text = sboth.nextLine();
                                   text=text.replaceAll("xxx",pattern[i]);
                                   String word1[]= text.split("-");

                                   if (parts[0].contains(word1[0]))
                                   {   
                                       word1[0]=word1[0].replaceAll(pattern[i], "xxx");
                                       value = word1[1]+ "#"+word1[0];
                                       System.out.println(word1[0]+ "::" + parts[0]+ " //"+parts[1]+ "="+ value);
                                       flag2 =true;
                                       flag=1;
                                       break;
                                   }
                                }
                                if (flag2 == false)
                                {       
                                  while (sval.hasNextLine())
                                    {        flag=0;
                                           text = sval.nextLine();
                                           String wordd[]= text.split("-");
                                           int y=wordd.length;
                                           
                                           if(y>=3)
                                           {    String check=wordd[0];
                                                check=check.concat("-");
                                                check=check.concat(wordd[1]);
                                                if (parts[0].contains(check))
                                           {    
                                               value = wordd[wordd.length-1]+ "#"+check;
                                               System.out.println(wordd[0]+ "::" + parts[0]+ " //"+parts[1]+"="+ value);
                                               flag=1;
                                               break;
                                           }
                                                
                                         
                                            //= long-term#4
                                           }

                                           else if(y<=3)
                                           {if (parts[0].contains(wordd[0]))
                                           {    
                                               value = wordd[1]+ "#"+wordd[0];
                                               System.out.println(wordd[0]+ "::" + parts[0]+ " //"+parts[1]+"="+ value);
                                               flag=1;
                                               break;
                                           }
                                           }
                                    } 
                                  
                                }
                                
                     } 
                    valf.close();
                    both.close();
                    
                    if(flag!=1)
                        value="3#no match";
                    flag=0;
                    bufferWriter.write(parts[1]+"//"+parts[0]+" = "+value);
                    bufferWriter.newLine();
                    flag1=false;
                                flag2=false;
                                
                }
                
                fco.close();
            
          bufferWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(savedata.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
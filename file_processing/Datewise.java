
package file;

import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Calendar.*;

public class Datewise {
    
    public static void myfunc(String filename,int divide,int choice,int d,int div)
    {       String remaining;
            Date dstart=null,dend=null,d2;
            if(choice==1)
           filename=filename+" analysed final";
            String datestart=null;
            String dateend=null;
            
           System.out.println(filename);
           try{ 
               SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                if(d==1)
                {   System.out.println("\nEnter the starting date in DD-MM-YYYY format");
                
                
                Scanner datescan=new Scanner(System.in);
                datestart=datescan.nextLine();
                dstart=sdf.parse(datestart);
                System.out.println("\nEnter the ending date in DD-MM-YYYY format");
                
                
                
                dateend=datescan.nextLine();
                dend=sdf.parse(dateend);
                }
                
                else if(d==0)
                {
                dstart=sdf.parse("01-01-2002");
                dend=sdf.parse("09-09-2020");
                
                
                
                }
                int type=0;
                if(d!=0)
                { System.out.println("\n1. For both value and text\n2. For only value");
                Scanner scanvalue=new Scanner(System.in);
                type=scanvalue.nextInt();
                }
                else if(d==0)
                   type=1; 
                FileInputStream fin=new FileInputStream(filename);
                File file=new File("temporary");
                
                file.createNewFile();
                FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                
                Scanner sc=new Scanner(fin);
                while(sc.hasNextLine())
                {   remaining=sc.nextLine();
                    d2=datemade(remaining);
                    
                    
                    if((d2.equals(dstart)||d2.after(dstart))&&(d2.equals(dend)||d2.before(dend)))
                    {
                       // System.out.println(remaining);
                              
    		 
                
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
                }
    	  
                    }
                    
                 bufferWriter.close();
                 String totfilename=null;
                 if(choice==1)
                     totfilename=filename+" date";
                 
                 else if(choice==0)
                     totfilename="tempdate";
                 
                 File fval=new File(totfilename);
                
                fval.createNewFile();
                FileWriter filevalue = new FileWriter(fval.getName());
    	        BufferedWriter buffvalue = new BufferedWriter(filevalue);
      //12312312131313
                //12131313131
                //12131313
                        //123212131
                 Date d1=getrecent("temporary");
                 String x=copyval(d1,divide,type,div);
                 if(!x.equals("00"))
                 {  System.out.println(x);
                    buffvalue.write(x);
                    buffvalue.newLine();
                 }
                
                 
                 String prev="";
                 d2=d1;
                 try{
                 while(d2!=null)
                 {  
                     d2=getrecent("temporary",d2);
                    
                     if(d2!=null)
                     {  
                        x=copyval(d2,divide,type,div);
                        
                        if(!x.equals("00"))
                        {   prev=x;
                            //System.out.println(x);
                            buffvalue.write(x);
                            buffvalue.newLine();
                        }
                        else if(x.equals(prev))
                         break;
                            
                     }
                     else if(d2==null)
                         break;
                 }
                 
                 buffvalue.close();
                 }catch(NullPointerException e)
                 {  e.printStackTrace();
                 }
                
                 
                 
                 
           }catch(Exception e)
           {  e.printStackTrace();  }
    
    }
    
   public static Date getrecent(String filename,Date d1)throws ParseException, FileNotFoundException
   {    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        FileInputStream fp=new FileInputStream(filename);
        Date d2=d1,recent;
        String indate="Date:19 jul 3000";
        String in=convertDate(indate);
        recent=sdf.parse(in);
        
        Scanner sc=new Scanner(fp);
        while(sc.hasNextLine())
        {   String k=sc.nextLine();
            String p[]=k.split("//");
            String date=convertDate(p[0]);
            d2=sdf.parse(date);
            if(d1.before(d2)&&recent.after(d2))
            {   
                recent=d2;
            }
                
        }
       // System.out.println("inside"+recent);
        if(d1.equals(recent))
            return null;
        else return recent;
        
   }
    
    
    
    public static Date getrecent(String filename) throws ParseException, FileNotFoundException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        FileInputStream fp = new FileInputStream(filename);
        
        Scanner sc = new Scanner(fp);
        String input = sc.nextLine();
        String p[]= input.split("//");
        String date = convertDate(p[0]);
        Date d1= sdf.parse(date);
        Date recent = d1;
        sc.close();     
        FileInputStream fp1 = new FileInputStream(filename);
        Scanner sc1 = new Scanner (fp1);
        while(sc1.hasNext())
        {       
                input = sc1.nextLine();
                String p1[]= input.split("//");
                
                String date1 = convertDate(p1[0]);
                Date d2 = sdf.parse(date1);
                if(d2.before(recent))
                {
                    recent = d2;
                }
          }
          return recent;      
    }
    
    public static Date datemade(String input) throws ParseException, FileNotFoundException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String p[]= input.split("//");
        String date = convertDate(p[0]);
        Date d1= sdf.parse(date);
        Date recent = d1;
       
          return recent;      
    }

    public static String convertDate(String date){
        String parts1[]= date.split(":");
        String p2[]= parts1[1].split(" ");
        String d2 = p2[0];
        
        if (p2[1].equals("jan"))
            d2 = d2+"/"+"01";
        if (p2[1].equals("feb"))
            d2 = d2+"/"+"02";
        if (p2[1].equals("mar"))
            d2 = d2+"/"+"03";
        if (p2[1].equals("apr"))
            d2 = d2+"/"+"04";
        if (p2[1].equals("may"))
            d2 = d2+"/"+"05";
        if (p2[1].equals("jun"))
            d2 = d2+"/"+"06";
        if (p2[1].equals("jul"))
            d2 = d2+"/"+"07";
        if (p2[1].equals("aug"))
            d2 = d2+"/"+"08";
        if (p2[1].equals("sep"))
            d2 = d2+"/"+"09";
        if (p2[1].equals("oct"))
            d2 = d2+"/"+"10";
        if (p2[1].equals("nov"))
            d2 = d2+"/"+"11";
        if (p2[1].equals("dec"))
            d2 = d2+"/"+"12";
        d2 = d2+"/"+p2[2];
        return d2;
    }

public static String copyval(Date recent,int divide,int type,int div)
{               String toprint=null; 
            try{
                 FileInputStream f=new FileInputStream("temporary");
                 Scanner fscan=new Scanner(f);
                 String dateform=null;
                 String toappend="";
                 
                 Date another;
                 String required="";
                 String r=null;
                 float value=0,number=0,avg=0;
                 while(fscan.hasNextLine())
                 {  
                    String line=fscan.nextLine();
                    
                    dateform=convertDate(line);
                    
                    another=datemade(line);
                    if(another.equals(recent))
                    {   
                        toappend=dateform;
                        float t=0;
                        String part1[]=line.split(" = ");
                        String part2[]=part1[1].split("#");
                        if(!part2[1].equals("no match"))
                        {   t=Float.parseFloat(part2[0]);
                        value=value+t;
                        if(t!=0)
                        {
                        number++;
                        }
                        if(type==1)
                        {required="\t"+part2[0]+"#"+part2[1]+required;
                        
                        }
                        
                        else if(type==2)
                        {
                            required="\t"+part2[0]+required;
                        }
                        //for not displaying the advice beside remove part2[1]
                    } 
                    }
                    
                 }
                 avg=value/number;
                 String part1[]=toappend.split("//");
                 toappend=part1[0];
                 
                 
                 float val=0;
                 number=0;
                 if(type==2)
                 {  String h[]=required.split("\t");
                    for(int i=0;i<h.length;i++)
                    {   
                        if(!h[i].isEmpty())
                        {   val=val+Float.parseFloat(h[i]);
                            if(val!=0)
                            number++;
                            
                            
                        }
                    }
                    avg=val/number;
                 }
                 
                 else if(type==1)
                 {  String h[]=required.split("\t");
                    for(int i=0;i<h.length;i++)
                    {   if(!h[i].isEmpty())
                            {   String j[]=h[i].split("#");
                                val=val+Float.parseFloat(j[0]);
                                if(val!=0)
                                number++;
                            }
                    
                    }
                    
                    avg=val/number;
                 }
                 
                 double navg;
                 navg=(double)avg;   
                 navg = Math.round(navg*1000)/1000.0d;
                 toprint=toappend+"\t"+navg+required;
                 if(navg==0)
                 {  toprint="00";
                 
                 }
                
}
            
            catch(Exception e)
            {
                 e.printStackTrace();   
            }
            return toprint;
    }
}
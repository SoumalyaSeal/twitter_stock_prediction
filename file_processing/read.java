package file;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import file.Analyze.*;


class Read
{
    
    public static void main(String args[])
    {
        
        Scanner scan=new Scanner(System.in);
        String x="";
        int p=0;
       
       
       System.out.println("What do you want to do?? \n1. Save the  data for individual companies \n2. Analyze the data \n3. Save the data with a date frame \n4. To sort the data by experts");
       int way=0;
       way=scan.nextInt();
       System.out.println("Which sphere you want to see??");
      
       System.out.println("\n1. IT Companies \n2. FMCG  \n3. Banks  \n4. Pharma  \n5. Transport \n6. Telecom \n7. Channel \n8. Heavy Industries");
       int g=0;
       g=scan.nextInt();
       switch (g)
           {
               case 1: write("it",way); break;
               case 2: write("fmcg",way); break;
               case 3: write("banks",way); break;
               case 4: write("pharma",way); break;
               case 5: write("transport",way); break;  
               case 6: write("telecom",way); break;
               case 7: write("channel",way); break;
               case 8: write("heavy",way); break;
               default : System.out.println("Wrong choice");
           }
    }
    
    
    
public static void write(String filename,int ch)
    {
        String x="";
        int p=0;
        File f = new File(filename);
         try {
            FileInputStream fis = new FileInputStream(f);
            int i=1;
            String val="";
            Scanner scanner = new Scanner(fis);
            while(scanner.hasNextLine())
            {
                 x=scanner.nextLine();
                 System.out.println(i+". "+x);
                 i++;
            }
            System.out.println("\nEnter the position of the company: ");
            Scanner scanagain=new Scanner(System.in);
            p=scanagain.nextInt();
       
         }
          catch (FileNotFoundException e){
                e.printStackTrace();}
          
        if(ch==1)   
        { 
           try 
           {
                FileInputStream is = new FileInputStream(f);
                int i=1;String val="";
                Scanner scanner = new Scanner(is);
                while(scanner.hasNextLine())
                {
                     x=scanner.nextLine();
                     if(i==p)
                         read(x,ch);
                     i++;

                }
           }     
           catch (FileNotFoundException e){
            e.printStackTrace();}
        }
    
     else if(ch==2)
     {   
         try {
            FileInputStream is = new FileInputStream(f);
            int i=1;String val="";
            Scanner scanner = new Scanner(is);
            while(scanner.hasNextLine())
            {
                 x=scanner.nextLine();
                 if(i==p)
                     read(x,ch);
                 i++;
            }
         }          
         catch (FileNotFoundException e){
           e.printStackTrace();}
     }
        
     else if(ch==3)
     {   try 
           {
                FileInputStream is = new FileInputStream(f);
                int i=1;String val="";
                Scanner scanner = new Scanner(is);
                while(scanner.hasNextLine())
                {
                     x=scanner.nextLine();
                     if(i==p)
                     {   String h[]=x.split("/");
                         int hh=h.length;   
                         Datewise.myfunc(h[0],hh,1,1,10);
                     }
                     i++;

                }
           }     
           catch (FileNotFoundException e){
            e.printStackTrace();} 
         
                 
             
     }
        
     else if(ch==4)
     {   
         try {
            FileInputStream is = new FileInputStream(f);
            int i=1;String val="";
            Scanner scanner = new Scanner(is);
            while(scanner.hasNextLine())
            {
                 x=scanner.nextLine();
                 if(i==p)
                     read(x,ch);
                 i++;
            }
         }          
         catch (FileNotFoundException e){
           e.printStackTrace();}
     }   
  
  }
    
    
    
public static void read(String name,int ch)
    {   
       StringTokenizer token = new StringTokenizer(name,"/");
       int k = token.countTokens();
       String patterns[] = new String[k];
       int i=0, j=0;
       while (token.hasMoreTokens())
       {
           patterns[j]= token.nextToken();
           j++;
       }
       String pattern;
       File f = new File(patterns[0]);
       int divide=patterns.length;
       
       if(ch==4)
       {   try{
           String filename=patterns[0]+" analysed final";
           String expertfile="experts";
           FileInputStream fexpet=new FileInputStream(expertfile);
           Scanner scan=new Scanner(fexpet);
           int m=1;
           while(scan.hasNextLine())
           {    String x=scan.nextLine();
                String p[]=x.split("-");
                System.out.println(m+". "+p[0]);
                m++;
           }
           System.out.println("\nEnter your choice: ");
           int choice;
           Scanner mod=new Scanner(System.in);
           choice=mod.nextInt();
           System.out.println("1. With Text\n2. Without text");
           int cval;
           cval=mod.nextInt();
           FileInputStream nfexpert=new FileInputStream(expertfile);
           Scanner scanfx=new Scanner(nfexpert);
           int tap=0;
           String exname=null;
           while(scanfx.hasNextLine())
           {    
               String x=scanfx.nextLine();
               tap++;
               if(tap==choice)
               {String p[]=x.split("-");
                exname=p[0];
               }
           }
           
           FileInputStream divcheck=new FileInputStream(filename);
           Scanner div=new Scanner(divcheck);
           int nol=1;
           while(div.hasNextLine())
           {    String h=div.nextLine();
                nol++;
           
           }
          
           
           File file=new File(exname+" "+filename);
                 
                    
            
                file.createNewFile();
                FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                bufferWriter.write("");
               
    	        
           
           FileInputStream fcomp=new FileInputStream(filename); 
           Scanner scomp=new Scanner(fcomp);
           String tosave=null;
           FileWriter writenow=new FileWriter(file.getName(),true);
           BufferedWriter newbuf=new BufferedWriter(writenow);
           int pcheck=0;
           while(scomp.hasNextLine()&&pcheck<nol)
           {    String x=scomp.nextLine();
                if(x.contains(exname))    
                {   String part[]=x.split("//");
                    String date=Datewise.convertDate(part[0]);
                    if(cval==2)
                    {String point[]=part[1].split(" = ");
                    
                    String val[]=point[1].split("#");
                    
                    tosave=(date+"\t"+val[0]);
                    System.out.println(tosave);
                    newbuf.write(tosave);
                    newbuf.newLine();
                    }
                    
                    else if(cval==1)
                    { String point[]=part[1].split(" = ");
                    
                    
                    
                    tosave=(date+"\t"+point[1]);
                    System.out.println(tosave);
                    newbuf.write(tosave);
                    newbuf.newLine();
                    
                    
                    }
                    
                    
                }
                pcheck++;
                
           }
           
           
           
       newbuf.close();    
       }catch(Exception w)
            {    w.printStackTrace();
            }
      }    
       
       
       else if(ch==2)
       {   while(i<k)
            {   pattern=patterns[i];
                
                
               Analyze.analyze(patterns[0],pattern);
               i++;
            }
            savedata.overwrite(patterns[0]);
            
            savedata.putvalue(patterns[0],patterns);
          
            try{
            String modfile=patterns[0]+" analysed final";
            File file=new File(modfile);
            file.createNewFile();
            
            FileWriter makeblank=new FileWriter(file.getName());
            BufferedWriter mak=new BufferedWriter(makeblank);
            mak.write("");
            
            FileWriter filewriter=new FileWriter(file.getName(),true);
            BufferedWriter buff=new BufferedWriter(filewriter);
            
            FileInputStream fana=new FileInputStream(patterns[0]+" analysed");
            Scanner fanascan=new Scanner(fana);
            
            while(fanascan.hasNextLine())
            {   String v=fanascan.nextLine();
                FileInputStream fexp=new FileInputStream("experts");
                Scanner fexpscan=new Scanner(fexp);
                while(fexpscan.hasNextLine())
                {   String x=fexpscan.nextLine();
                    String p[]=x.split("-");
                    if(v.contains(p[0]))
                    {  
                        String d[]=v.split(" = ");
                        String p2[]=d[1].split("#");
                        Float val=Float.parseFloat(p2[0]);
                        Float bias=Float.parseFloat(p[1]);
                        
                        //
                        //
                        //
                        //function defined here=val=val*bias
                        //can be changed accordingly
                        //
                        //
                        //
                        //
                        //
                        //
                        //
                        
                        val=val*bias;
                        v=d[0]+" = "+val+"#"+p2[1];
                        
                        
                    }
              
                }
                buff.write(v);
                buff.newLine();
            }
            
            buff.close();
            
            }catch(Exception e)
            {   e.printStackTrace();
            
            }
            
       }    
       else if(ch==1)
       {    try{       
                f.createNewFile();
                FileWriter fileWritter = new FileWriter(f.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                
    	        bufferWriter.write("");
               
                
    	        bufferWriter.close();
            }
           catch (IOException e){
                e.printStackTrace();}   
       while(i < k)
       {    
            pattern= patterns[i];
            
            Pattern p=Pattern.compile(pattern);
           
       
      
       String x;
       try {
       FileInputStream fis = new FileInputStream("advice");
       Scanner scanner = new Scanner(fis);
       while(scanner.hasNextLine())
       {    int flag=1;
            x=scanner.nextLine();
            Matcher matcher=p.matcher(x);
            boolean val=matcher.find();
            if(val==true)
            {   int end=matcher.end();
                int start=matcher.start();
                char t=x.charAt(end);
                char r=' ';
                
                if(start!=0)
                {   
                    r=x.charAt(start-1);
                }
                
                if((xyz(t)&&start==0)||(xyz(r)))
                {System.out.println(x);
        
           try{       
                 f.createNewFile();
                 FileWriter fileWritter = new FileWriter(f.getName(),true);
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                
    	        bufferWriter.write(x);
                bufferWriter.newLine();
                
    	        bufferWriter.close();
            }
           catch (IOException e){
                e.printStackTrace();}     
            }
       }
        }
     }
    catch (FileNotFoundException e){
    e.printStackTrace();}
    i++;
       }
    } 
    }
            
    public static boolean xyz(char y)
    {   boolean x=true;
        
        if (Character.isLetter(y))
        {   x=false;
        
        }
        //System.out.println(y);
        return x;
    }
}

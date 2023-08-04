
package GAalgo;
import file.Datewise;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Calendar.*;

public class GenePool {
    
    public static void main(String args[])
    {   
        int pool =0;
        double range = 2;
        int generation =0;
        Scanner scanint=new Scanner(System.in);
        System.out.println("Enter the number  of genes you want : ");
        pool=scanint.nextInt();
        System.out.println("Enter the number of generations you want : ");
        generation=scanint.nextInt();
        
       Chromosome[] old = new Chromosome[pool];
       Chromosome[] next = new Chromosome[pool];
       Chromosome high=new Chromosome();
       high.generateChromosome(0);
       Keyword kw=new Keyword(); 
        for(int i=0;i<pool;i++)
        {   
           old[i]= new Chromosome();
           old[i].generateChromosome(i);
           next[i]= new Chromosome();
           next[i].generateChromosome(i); 
        }
        
 
       float val=-1;
        //Generating 1st gen chromosomes
       int j;
        
        int pp;
        for(pp=0;pp<pool*0.8;pp++)
        {
            while(true)
            {old[pp]=retgene(pp);
            val=old[pp].returnRho();
            if(val>0)
                break;
            else if(val<0)
                System.out.println("unfit sample");
            }
            old[pp].rho=val;
            System.out.println("Gene "+pp+" created");
            System.out.println("rho is ="+old[pp].rho);
        
        }
        for (j=pp; j<pool;j++)
        {   val=-1;
            while(val<0)
            {for (int i=0; i< old[j].key.length;i++)
            {
                
                String S = kw.company[i];
                String k[]=S.split("-");
                float value =Float.parseFloat(k[k.length-1]);  
                float check=value;
                Random r=new Random();
                while(true)
                {value= (float)(value- range);
                    value=value+r.nextFloat()*4;
                  if(value>=1 && value<=5)
                      break;
                        }
                old[j].key[i]=value;     
               
            }
            val=old[j].returnRho();
            if(val>0)
                break;
            else if(val<0)
                System.out.println("unfit sample");
            }
            old[j].rho=val;
            System.out.println("Gene "+j+"created");
            System.out.println("rho is ="+old[j].rho+"\n");
        }
    //Generation loop will start from here
        float ma=old[0].rho;
        for(int i=0;i<pool;i++)
        {   
            
          float rr=old[i].rho;
          if(rr>ma)
              ma=rr;
        
        }
        System.out.println("The gene with highest rho is : "+ma);
        int flag=0;
        float highest=0;
    for(int a= 0 ; a<generation; a++,flag = 0)
    {   
        System.out.println("In generation "+a);
        //Calc Rho             
        Chromosome temp[]=new Chromosome[pool];
        for(int i=0;i<pool;i++)
        {   temp[i]=new Chromosome();
            temp[i].generateChromosome(i);
        }
        Chromosome mating[]= new Chromosome[2];
        Chromosome check1=new Chromosome();
        mating[0]= new Chromosome();
        Chromosome check2=new Chromosome();
        mating[0].generateChromosome(pool+1);
        mating[1]= new Chromosome();
        mating[1].generateChromosome(pool+2);
        
       
        int n=0,p=0;
        Random ran=new Random();
       int choseone=0;
       for(int i=0;i<pool;i++)
        {   int pos=0;
              int maxpos=0;
            while(true)
            {   float cor=ran.nextFloat();
               
                
                {   float maxr=0;
                  
                    for(int f=0;f<2;f++)
                { 
                    pos=ran.nextInt(pool);
                    if(old[pos].rho>maxr)
                    {   maxr=old[pos].rho;
                        maxpos=pos;
                    }
                }
                   if(old[maxpos].rho<=cor)
                        {   n=maxpos;
                            choseone=1;
                            break;
                        }
                
                
                
                if(choseone==1)
                    break;
                }
            }
            
            flag=0;
            mating[flag].chr_id=old[n].chr_id;
            for(int yy=0;yy<old[n].key.length;yy++)
            {mating[flag].key[yy]=old[n].key[yy];}
            mating[flag].rho=old[n].rho;
            choseone=0;
            while(flag==0)
            {   int y=0,maxp=0;
                float maxrho=0;
                    
                while(true)
                {   float cors=ran.nextFloat();
                   
                   
    {                   for(int f=0;f<2;f++)
                        {  y=ran.nextInt(pool);
                           if(old[y].rho>maxrho)
                           {
                               maxrho=old[y].rho;
                               maxp=y;
                           }
                        }
                       if(old[maxp].rho<=cors)
                        {   p=maxp;
                            choseone=1;
                            break;
                        }
                        
                    if(choseone==1)
                        break;
    }
                }
                if(old[p].chr_id!=mating[flag].chr_id)
                {
                    flag=1;
                }
            
            }
            
            mating[flag].chr_id=old[p].chr_id;
            for(int yy=0;yy<old[p].key.length;yy++)
            {mating[flag].key[yy]=old[p].key[yy];}
            mating[flag].rho=old[p].rho;
            
            System.out.println("mated with "+mating[0].chr_id +"  "+mating[1].chr_id);
            check1.rho=mating[0].rho;
            check2.rho=mating[1].rho;
            mating = crossover(mating[0],mating[1]);
           System.out.println("corr of parents= "+check1.rho+ "  &   "+check2.rho);
            
            if(i%4==0)
            for(int kk=0;kk<next[i].key.length;kk++)
            {
            next[i].key[kk]=mating[1].key[kk];
            }
            else
                for(int kk=0;kk<next[i].key.length;kk++)
                {next[i].key[kk]=mating[0].key[kk];}
            
            next[i].rho=next[i].returnRho();
            
             System.out.println("corr of parents= "+check1.rho+ "  &   "+check2.rho);
            System.out.println(" corr of child= "+next[i].rho);
            
            System.out.println("Gene "+i+" of generation "+a);
            next[i].chr_id=i;
            temp[i].rho=next[i].rho;
            for(int yy=0;yy<next[i].key.length;yy++)
            {temp[i].key[yy]=next[i].key[yy];}
           temp[i].chr_id=i;
           
            
        }
       float gnmar=old[0].rho;
       int gp=0;
        for(int i=0;i<pool;i++)
        {
            if(old[i].rho>gnmar)
            {
                gp=i;
                gnmar=old[i].rho;
            }
        }
        
      System.out.println("The gene with highest rho for this gen is: "+old[gp].rho);
      
      if(old[gp].rho>highest)
      {  highest=old[gp].rho;
        for(int i=0;i<old[gp].key.length;i++)
            high.key[i]=old[gp].key[i];
        
        high.rho=old[gp].rho;
      }
      System.out.println("All over highest is :"+highest);
      if(highest==old[gp].rho)
      { System.out.println("Now the file has correlation coefficient="+highest);
      try{
          Keyword k=new Keyword();
          for(int i=0;i<k.company.length;i++)
          { String xy[]=k.company[i].split("-");
            String toshow="";
            for(int jj=0;jj<xy.length-1;jj++)
            {   toshow=toshow+xy[jj]+"-";
            }
            toshow=toshow+old[gp].key[i];
            System.out.println(toshow);
            
          }
          System.out.println("The gene has correlation (highest high) "+old[gp].rho);
      File f=new File("wrkey");
      FileWriter fw=new FileWriter(f);
      BufferedWriter bw=new BufferedWriter(fw);
      for(int i=0;i<kw.company.length;i++)
      { bw.write(old[gp].key[i]+"");
        bw.newLine();
      
      }
      bw.close();
      fw.close();
      
      }catch(IOException e)
      {e.printStackTrace();}
    }
       int check=0;
       int fl=0;
       int fl2=0;
       for(int i=0;i<pool;i++)
       {    if(high.rho>=temp[i].rho)
                {fl=1;
                fl2++;
                }
           
       }
       int pos1[]=new int[2];
       if(a%4==0)
       {
       if(fl==1 && fl2>=0.98*pool)
       {    
       Random r=new Random();
       while(true)
       {   int posv=r.nextInt(pool);
            if(temp[posv].rho<high.rho)
            { 
                
            for(int i=0;i<temp[posv].key.length;i++)
            {temp[posv].key[i]=high.key[i];
            }
        
          
            System.out.println("Initial value of gene "+temp[posv].chr_id+" is "+temp[posv].rho);
            temp[posv].rho=high.rho;
            System.out.println("The new value for gene "+temp[posv].chr_id+" is "+temp[posv].rho);
            check=1;
            break;
       }
       }     
       
       }
    }
       float mnext=0;int mnpos=0;
       for(int i=0;i<pool;i++)
       {   if(next[i].rho>mnext)
            {
                 mnext=next[i].rho;  
                 mnpos=i;
            }
            
           
       }
       System.out.println("Here it is "+mnext);
       Keyword kw2=new Keyword();
       for(int i=0;i<kw.company.length;i++)
       {    
           String part[]=kw.company[i].split("-");
           String toprint=part[0];        
           toprint=toprint+"-"+next[mnpos].key[i];
       
       }
        for(int i=0; i<pool; i++)
        {   
            System.out.println("Earler rho for gene "+old[i].chr_id+" was : "+old[i].rho+"for generation "+a);
            old[i].chr_id=i;
            
            old[i].rho=temp[i].rho;
            for(int oo=0;oo<temp[i].key.length;oo++)
            {   old[i].key[oo]=temp[i].key[oo];
            }
            System.out.println("Now rho for gene "+old[i].chr_id+" is: "+old[i].rho+"for generation "+a+"\n");
        
            
        }
        
    } //gen. loop ends here
   
   Keyword kwnew=new Keyword();
   Chromosome crnew=new Chromosome();
   crnew.generateChromosome(1000);
   int checkgene=0;
   int max=0;
   int pos=0;
   for(pos=0;pos<pool;pos++)
   {    if(old[pos].rho>high.rho)
   {max=pos;
   checkgene=1;
   }
   }
   try{
   File f=new File("keyword 1 year");
   FileWriter fw=new FileWriter(f);
   BufferedWriter bw=new BufferedWriter(fw);
   
   for(int i=0;i<crnew.key.length;i++)
   {   
       if(checkgene==1)
       { String part[]=kwnew.company[i].split("-");
       kwnew.company[i]=part[0]+"-"+old[max].key[i];
       System.out.println(kwnew.company[i]);
       bw.write(kwnew.company[i]);
       bw.newLine();
       }
       else if(checkgene==0)
       {String part[]=kwnew.company[i].split("-");
       kwnew.company[i]=part[0]+"-"+high.key[i];
       System.out.println(kwnew.company[i]);
       bw.write(kwnew.company[i]);
       bw.newLine();}
   }
   bw.close();
   }catch(Exception e)
   {e.printStackTrace();}
   
   if(checkgene==1)
   {System.out.println("The chosen gene has rho="+old[max].rho);
    old[max].returnRho();
   }
   else if(checkgene==0)
   {System.out.println("The chosen gene has rho="+old[max].rho);
    high.returnRho();}
    
}
    //Single crossover
    private static Chromosome[] crossover(Chromosome A, Chromosome B)
    {
        Chromosome X[]= new Chromosome[2];
        X[0]= new Chromosome();
        X[0].generateChromosome(999);
        X[1]= new Chromosome();
        X[1].generateChromosome(998);
        X[0].chr_id= A.chr_id;
        X[0].key=A.key;
        X[0].rho=A.rho;
        
        X[1].chr_id= B.chr_id;
        X[1].key=B.key;
        X[1].rho=B.rho;

        for (int i= 0; i<A.key.length; i++)
        {  
            X[1].key[i]=(A.key[i]+B.key[i])/2;
            if(A.rho>0 && B.rho>0)
            X[0].key[i]=(A.rho*A.key[i]+B.rho*B.key[i])/(A.rho+B.rho);
            else X[0].key[i]=(A.key[i]+B.key[i])/2;
           
        }
         return X;          
    }
    
    private static Chromosome retgene(int k)
    {       Chromosome temp=new Chromosome();
            temp.generateChromosome(k);
            temp.chr_id=k;
            Keyword kw=new Keyword();
            int a[]=new int[kw.company.length];
            
            for(int i=0;i<a.length;i++)
            {a[i]=0;}
            int j=0;
            Random r=new Random();        
            while(j<0.8*a.length)
            {   
               int x=r.nextInt(a.length);
               if(a[x]!=1)
               {    a[x]=1;
                    j++;
               }
            }
            float val1=0;
            int checks=0;
            int chs=0;
        //   String array[]={"tech mahindra"};
         String array[]={"satyam","mphasis","hcl","tech mahindra","infosys/infy","wipro",
"tcs/tata consultancy","pnb/punjab national bank/psu bank",
"ubi/united bank of india/psu bank",
"icici bank",
"hdfc bank",
"sbi/state bank/psu bank",
"axis bank",
"canara bank",
"andhra bank/psu bank",
"yes bank",
"indusind",
"allahabad bank/psu bank",
"dcb",
"dena bank",
"uco bank/psu bank",
"idbi",
"federal bank",
"lic housing","bharti","idea","rcom/reliance communications",
         "shriram transport",
"maruti",
"m&m/mahindra and mahindra",
"tata motors",
"hero",
"bajaj auto",
"jet",
"spicejet",
"kingfisher","voltas",
"exide",
"itc",
"hul/unilever",
"bata",
"chambal","grasim","cummins", 
"reliance power",
"tata steel",
"jsw steel",
"cairn",
"ril/reliance industries limited",
"bhel",
"sail",
"adani",
"ultratech",
"hindalco",
"l&t/larsen & toubro","sun tv","zee","dish tv","reddys", "ranbaxy",
"cipla",
"glenmark",
"wockhardt",
"sun pharma", 
"aurobindo",
        "lupin"};               
             
       
          // String array[]={"mphasis"};
           
            for(int i=0;i<a.length;i++)
            {  float forceval=0;
               int n=0;     
            int find=0;
            if(a[i]==1)   
            {   while(find<4)
                {    
                    int pos=r.nextInt(array.length);
                
                String comp=array[pos];
            try{    
             
                    
                    String part[]=comp.split("/");
                    comp=part[0];
                   
                    String filename=comp+" analysed final";
                   
                 
                    
                    FileInputStream company=new FileInputStream(filename);
                    Scanner st=new Scanner(company);
                   
                    String orgname=comp+"_orgvalue.txt";
                    System.out.println(orgname);
                    FileInputStream orgv=new FileInputStream(orgname);
                    Scanner orgdata=new Scanner(orgv);
                    String advice="";
                    String kk[]=kw.company[i].split("-");
                    val1=Float.parseFloat(kk[kk.length-1]);
                    String check=kk[0];
                    String compare="sell";
                    checks=0;
                    if(check.equalsIgnoreCase("sell")&&compare.equalsIgnoreCase(check))
                        checks=1;
                    else if(check.equalsIgnoreCase("exit")||check.equals("don't buy"))
                        checks=1;
                    else if(check.equalsIgnoreCase("low")||check.equalsIgnoreCase("to xxx"))
                        checks=1;
                    else if(check.equals("fall")||check.equals("from xxx"))
                        checks=1;
                    else if(check.equals("underweight")||check.contains("weak"))
                        checks=1;
                    else if(check.equals("reduce"))
                        checks=1;
                    else if(check.equals("go short")||check.equals("don't buy"))
                        checks=1;
                    else if(check.equals("downside"))
                        checks=1;
                    else if(check.contains("stay away from"))
                        checks=1;
                    else if(check.equals("buy")||check.equals("stay in"))
                        chs=1;
                    else if(check.endsWith("enter"))
                        chs=1;
                    else if(check.equals("optimistic"))
                        chs=1;
                    else if(check.equals("bullish on")||check.equals("long term"))
                        chs=1;
                    
                    else if(check.equals("an excellent pick"))
                        chs=1;
                   
                    while(st.hasNext())
                    {   int flag=0;    
                        advice=st.nextLine();
                        String valpart[]=advice.split(" = ");
                        
                        String keyword[]=valpart[1].split("#");
                        String orgtext="";
                        if(keyword[1].equals(kk[0]))
                        {
                                String datepart[]=advice.split("//");
                                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                                Date d1=sdf.parse(Datewise.convertDate(datepart[0]));
                                if(part.length>=2)
                                {   
                                    while(orgdata.hasNextLine())
                                    {   
                                        orgtext=orgdata.nextLine();
                                        if(!orgtext.equalsIgnoreCase(""))
                                        {  String daval[]=orgtext.split("\t");
                                        Date d2=sdf.parse(daval[0]);
                                        if(daval.length<4)
                                        {   flag=1;
                                            break;
                                        }
                                        if(d1.equals(d2))
                                        {   
                                            forceval=forceval+Float.parseFloat(daval[3]);
                                            n++;
                                           
                                        }
                                        }
                                    }
                                
                                }
                                else
                                {   while(orgdata.hasNextLine())
                                    {   
                                        orgtext=orgdata.nextLine();
                                        if(!orgtext.equalsIgnoreCase(""))
                                        {  String daval[]=orgtext.split("\t");
                                        Date d2=sdf.parse(daval[0]);
                                        if(daval.length<4)
                                        {   flag=1;
                                            break;
                                        }
                                        if(d1.equals(d2))
                                        {   
                                            forceval=forceval+Float.parseFloat(daval[3]);
                                            n++;
                                            
                                     }
                                        else if(d2.after(d1))
                                            break;
                                        }
                                        
                                        
                                        
                                    
                                    }
                                
                                }
                        }
                      if(flag==1)
                          break;
                    
                    }
                
                    find++;
                    
               
            
            }catch(Exception e)
            {e.printStackTrace();}
            }
           
            if(n>0)
            {   float yy=forceval/n;
               if(checks==0 && chs==0)
                {   
                    kw.company[i]=Float.toString(yy);
                }
               
               else if(checks==1)
               {
                   if(yy>3)
                   val1=(float)(3-r.nextFloat()*0.8);
                   else val1=yy;
                   
                   kw.company[i]=Float.toString(val1);
               }
                
               else if(chs==1)
               {
                   if(yy<3)
                       yy=(float)(3+r.nextFloat()*0.8);
                   
                   kw.company[i]=Float.toString(yy);
               }
            }
            }
               
            
            }
            
            for(int i=0;i<kw.company.length;i++)
            {   
                String valpar[]=kw.company[i].split("-");
                if(valpar.length>1)
                {       
                    kw.company[i]=valpar[valpar.length-1];
                }
            
            }
            temp.chr_id=k;
            for(int i=0;i<kw.company.length;i++)
            {   
                temp.key[i]=Float.parseFloat(kw.company[i]);
            
            
            }
            
            return temp;
         
    }    
}

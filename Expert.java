/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GAalgo;

import file.Datewise;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Seal
 */
public class Expert {
    String experts[]={
        "agarwal",
        "angel",
        "baliga",
        "bhamre",
        "doctor",
        "dolat",
        "emkay",
        "firstcall",
        "icici secu",
        "joshi",
        "kapur",
        "lilladher",
        "madan",
        "mehta",
        "merani",
        "mittal",
        "mohinder",
        "motilal",
        "nirmal",
        "sekhar",
        "tulsian",
        "sukhani",
        "tater",
        "vijay",
        "way2wealth"};
    float bias1[]= new float[experts.length];
    float bias2[]= new float[experts.length];
    float bias3[]= new float[experts.length];
    
    int calcBias(int e) throws IOException
    {
        int n[]={0,0,0};
       // String chosen, co[];
        //float v=0;
        //String co1[]={"ultratech", "tech mahindra", "bata", "federal bank","pnb","itc","indusind","m&m",
        //    "andhra bank", "hdfc bank"};
           String co2[]={"indusind","lic housing", "ultratech","allahabad bank","jet", "yes bank", "federal bank", "zee","andhra bank","pnb"};

 //       biasC("hul",e);
//        String companyType[]= {"it", "banks", "telecom", "heavy", "transport", "fmcg", "channel", "pharma"};
        for (int i=0; i< co2.length ; i++)
        {
//            FileInputStream f = null;
            try {
//                System.out.println(companyType[i]+"::----");
//                f = new FileInputStream(companyType[i]);
 //               Scanner sc = new Scanner(f);
 //               while (sc.hasNextLine())
 //               {
 //                   chosen = sc.nextLine();
//                    co= chosen.split("/");
                  float p[]= biasC(co2[i],e);
                  //  bias1[e]+= (p[0]*p[1]);
                  // bias2[e]+= p[2]*p[3];
                   bias3[e]+= p[4]*p[5];
                   // n[0]+=p[1];
                   // n[1]+=p[3];
                    n[2]+=p[5];
                  //  System.out.println(bias2[e]+"\t"+n[1]);
                    System.out.println(bias3[e]+"\t"+n[2]);
 //               }
            }
            catch (Exception ex) {
                Logger.getLogger(Expert.class.getName()).log(Level.SEVERE, null, ex);
            }
           // f.close();
        }
        if (n[0]!= 0)
            bias1[e] /= n[0];
        if (n[1]!=0)
        bias2[e] /= n[1];
        if(n[2]!=0)
        bias3[e] /= n[2];
        return n[1];
    }
    public void updateExpert() throws IOException
    {
        int n;
        File file=new File("experts_bias2yr.txt");
        file.createNewFile();
        FileWriter fileWritter = new FileWriter(file.getName());
        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
//        int i = 0;
//        calcBias(i);
//        System.out.println(experts[i]+"-"+bias1[i]+"-"+bias2[i]+"-"+bias3[i]);
        for(int i=0;i<experts.length;i++)
        {
             System.out.println(experts[i]);
             n= calcBias(i);
//            System.out.println(experts[i]+"-"+bias1[i]+"-"+bias2[i]+"-"+bias3[i]);
//            bufferWriter.write(experts[i]+": "+bias1[i]+"-"+bias2[i]+"-"+bias3[i]);
//            System.out.println(experts[i]+": "+bias2[i]+" - "+ n);
//            bufferWriter.write(experts[i]+": "+bias2[i]+" - "+ n);
            System.out.println(experts[i]+": "+bias3[i]+" - "+ n);
            bufferWriter.write(experts[i]+": "+bias3[i]+" - "+ n);
            bufferWriter.newLine();
        }
        bufferWriter.close();
        
    }
    float[] biasC(String co,int E)
    {
        float ret[]= {0,0,0,0,0,0} ;
        System.out.println(co);
        try {

            
            FileInputStream t= new FileInputStream(co+ " analysed");
            Scanner st = new Scanner(t);
            double x=0, y1,y2,y3, Ex1=0,Ex2=0,Ex3=0,Ey1=0,Ey2=0,Ey3=0,Ex1sq=0,Ex3sq=0,Ex2sq=0, Ey1sq=0,Ey3sq=0,Ey2sq=0, Exy1=0,Exy2=0,Exy3=0;
            int n1=0,n2=0,n3=0;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while(st.hasNextLine())
              {
                  String pre = st.nextLine();
                  if(pre.contains(experts[E]))
                  {
                        System.out.println(pre);
                        String p[]= pre.split("//");
                        String p1 = Datewise.convertDate(p[0]);
                        String p3[] = p[1].split("=");
                        String p2[] = p3[1].split("#");
                        x = Float.valueOf(p2[0]);
                        Date d1= sdf.parse(p1);
                      //  System.out.println(p1+" == "+x);
                        if(Dateexist(co,d1)== false) 
                        {
                            //System.out.println("Advice ignored");
                            continue;
                      }
                        //System.out.println("Searching....");
                        FileInputStream fi = new FileInputStream("E:/stock/new orgvalues/"+co+"_orgvalue.txt");
                        Scanner sc=new Scanner(fi);
                        while (sc.hasNextLine())
                        {
                            String o= sc.nextLine();
                            String org[]=o.split("\t");
                            if (org[0].equals(p1))
                            {
                                   // System.out.println(o);
                                    if (org.length==8)
                                        y2 = Float.parseFloat(org[7]);
                                    else
                                    y2 = Float.parseFloat(org[8]);
                                    Ex2 += x;
                                    Ex2sq +=x*x;
                                    Ey2 +=y2;
                                    Ey2sq+=y2*y2;
                                    Exy2+= x*y2;
                                    n2++;
                                    System.out.print(p1+ " x == "+x);
                                    System.out.println("\t"+org[0]+" :::: "+y2);
                                    System.out.println(n2 + " "+ Exy2+ " "+ Ex2 + " "+ Ey2+ " "+ Ex2sq + " "+ Ey2sq);
                                break;
                            }
                            //System.out.println(org[0]+ "skip!");
                        }
                        fi.close();
                        
                    }
            }
            //System.out.println("End loop!!!!");

            if (n2==0)
            {
                System.out.println("No advice!");
                return ret;
            }
            if (n2==1)
            {
                System.out.println("Single advice!");
                ret[2]= (float)((Ey2-Ex2)/Ex2);
                ret[3] =n2;
                return ret;
            }
            System.out.println(n2 + " "+ Exy2+ " "+ Ex2 + " "+ Ey2+ " "+ Ex2sq + " "+ Ey2sq);
            double a = n2*Exy2 - Ex2*Ey2;
            double c = Math.sqrt(n2*Ex2sq - Ex2*Ex2);
            double d = Math.sqrt(n2*Ey2sq- Ey2*Ey2);
            float b = (float) (a/(c*d));
            System.out.println("a = "+a + " c = " +c+ " d = " +d + " b = "+b);
            if (a==0)
                return ret;
            ret[0] = (float) ((n1*Exy1 - Ex1*Ey1)/((Math.sqrt(n1*Ex1sq - Ex1*Ex1))*Math.sqrt(n1*Ey1sq- Ey1*Ey1)));
            ret[1]=n1;
            ret[2] = (float) ((n2*Exy2 - Ex2*Ey2)/((Math.sqrt(n2*Ex2sq - Ex2*Ex2))*Math.sqrt(n2*Ey2sq- Ey2*Ey2)));
            ret[3]=n2;
            ret[4] = (float) ((n3*Exy3 - Ex3*Ey3)/((Math.sqrt(n3*Ex3sq - Ex3*Ex3))*Math.sqrt(n3*Ey3sq- Ey3*Ey3)));
            ret[5]=n3;
            System.out.println(ret[0]+"@"+ret[1]+"$$"+ret[2]+"@"+ret[3]+"$$"+ret[4]+"@"+ret[5]);
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return ret;
    }      

 boolean Dateexist(String co, Date date) throws FileNotFoundException, ParseException
    {
        boolean exist = false;
        File f= new File(co+"_orgvalue.txt");
        FileInputStream fi = new FileInputStream(f);
        Scanner sc=new Scanner(fi);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while(sc.hasNextLine())
        {
            String s= sc.nextLine();
            String d[]= s.split("\t");
            Date d2= sdf.parse(d[0]);
            //if (date.after(d2))
             //   return false;
            if(date.equals(d2) && d.length >=6)
            {
                exist= true;
                break;
            }
        }
       // System.out.println(exist);
        return exist;
    }
}
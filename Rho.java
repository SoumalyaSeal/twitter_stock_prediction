/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GAalgo;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Calendar.*;

/**
 *
 * @author ss
 */
public class Rho {
    public String ShowData(String co)
    {   float rho=0;int count=0;
        FileInputStream fi=null;
        int n=0;
            
        try {
            File f= new File(co+"_orgvalue.txt");
            fi = new FileInputStream(f);
            Scanner sc=new Scanner(fi);
            FileInputStream t= new FileInputStream("tempdate");
            Scanner st= new Scanner(t);
            float x=0, y, xy, Ex=0, Ey=0, Ex2=0, Ey2=0, Exy=0;
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

                
              while(st.hasNextLine())    
              {     int flag=0;
                  String pre = st.nextLine();
                  String p[]= pre.split("\t");
                  
                  x= Float.parseFloat(p[1]);
                  Date d1=sdf.parse(p[0]);
                  Date d2=d1;
                //  System.out.println(p[0]+" == "+x);
                  
                  while(!d2.after(d1))
                  {    String o= sc.nextLine();
                      String org[]=o.split("\t");  
                      d2=sdf.parse(org[0]);
                      if(d2.equals(d1))
                      {   count++;
                          if(org.length<4)
                          { 
                              flag=1;
                              break;
                          }
                          
                          y = Float.parseFloat(org[3]);
                         // System.out.println(org[0]+" :::: "+y);
                          Ex += x;
                          Ex2 = Ex2 + x*x;
                          Ey +=y;
                          Ey2= Ey2+ y*y;
                          Exy= Exy + x*y;
                          n++;
                          break;
                      
                      }
                   if(flag==1)
                       break;
                  
                  }
   
                
         rho = (float) ((n*Exy - Ex*Ey)/((Math.sqrt(n*Ex2 - Ex*Ex))*Math.sqrt(n*Ey2- Ey*Ey)));         
         
              }
            
        }
        catch(Exception e)
        {
            e.getMessage();
        }
       String ret;
       ret=rho+"@";
       ret=ret+n;
       System.out.println("correlation here is: "+rho);
       System.out.println("number of lines="+n);
        return ret;
               
            
    }
    
}
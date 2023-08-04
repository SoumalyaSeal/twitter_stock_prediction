package webcrawler;
import threads.*;
import java.net.*;
import java.util.Scanner;
import java.io.*;




public class WSDLCrawler implements MessageReceiver {
	public WSDLCrawler(Queue q, int maxLevel, int maxThreads)
		throws InstantiationException, IllegalAccessException {
            
            ThreadController tc = new ThreadController(WSDLCrawlerThread.class,maxThreads,maxLevel,q,0,this);
	}
        int i=0;
        
	public void finishedAll() {
		// ignore
	}
       

	public void receiveMessage(Object o, int threadId) {
		// In our case, the object is already string, but that doesn't matter
	Scanner scan=new Scanner(System.in);
        int global=0;
            i++;
                System.out.println("[" + threadId + "] " + o.toString());                
                
                if(i!=1)
                {  try
                {   URL pageURL=(URL)o;
                    String mimetype = pageURL.openConnection().getContentType();
                    String x=retfile();
                String u=String.valueOf(i);
                String name=x.concat(u);
            // Discard all non-text files
            // Further assumptions on the mime type should not be made, because
            // some WSDLs advertise themselves as text/plain, others as text/xml
            // Anyway, we should try to identify WSDL pages by the definitions-
            // tag rather than by content-type.
                    if (mimetype.startsWith("text"))     
                    SaveURL.writeURLtoFile(new URL(o.toString()),name);
                }catch(Exception e)
                {   System.err.println("Error in saving");
                    i--;
                }
             }
   else if(i==1)
                {    System.out.println("\nEnter your choice: 1)Twitter  2)Moneycontrol ");
                    int choice;
                    choice=scan.nextInt();
                    if(choice==1)
                    {        
            try {   URL url=new URL(o.toString());
                    String x=retfile();
                    String u=String.valueOf(i);
                    String name=x.concat(u);
                    FileOutputStream os = new FileOutputStream(name);
                    byte[] buf = new byte[1048576];
                    InputStream is = url.openStream();
                    URL pageURL = (URL) o;
                    String rawPage = SaveURL.getURL(pageURL);
                    String smallPage = rawPage.toLowerCase().replaceAll("\\s", " ");
                    String fil=SaveURL.savetext(smallPage,name);
                
                    System.out.println(fil);
        }
        catch (IOException e)
        {
            System.out.println("Exception ");       
        }
                }
                    
                    else if(choice==2)
                    {   System.out.println("\nWhat do you want to do??");
                        System.out.println("1. Make a new database");
                        System.out.println("2. Add more data to already existing database");
                        int m;
                        m=scan.nextInt();
                        System.out.println("How many pages??");
                        int nop;
                        nop=scan.nextInt();
                        int pgno=1;
                        for(;pgno<=nop;pgno++)
                        {   String name3="http://www.moneycontrol.com/news/expert-advice-250-1-next-250.html";
                            String name1=name3.substring(0,51);
                            
                            String name2=name3.substring(52, name3.length());
                     
                        String xtra=String.valueOf(pgno);
                        name1=name1.concat(xtra);
                        name1=name1.concat(name2);
                        String x=retfile();
                        String u=String.valueOf(pgno);
                        String name=x;
                        
                        
                      
                         try {   URL url=new URL(name1);
                
                URL pageURL = (new URL(name1));
                String rawPage = SaveURL.getURL(pageURL);
                String smallPage = rawPage.toLowerCase().replaceAll("\\s", " ");
		
               String filename=SaveURL.savemoney(smallPage,name,m,global);
               Character c=filename.charAt(filename.length()-1);
               String temp=Character.toString(c);
               global=Integer.valueOf(temp);
               
               
               filename=filename.substring(0,filename.length()-1);
               
                    if(m==2 && global==1)
                {
                    while(true)
                    { String temporary="temp";
                    FileInputStream fis = new FileInputStream(filename);
                    Scanner scanner = new Scanner(fis);
                    while(scanner.hasNextLine())
                    {    String remaining=scanner.nextLine();
                         FileWriter fileWritter = new FileWriter(temporary,true);
                         BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                         bufferWriter.write(remaining);
                         bufferWriter.newLine();
                         bufferWriter.close();
                         
                    }
                    //Change
                    //Delete file with filename variable\
                    //rename file with temporary string into filename variabble
                    //
                    //
                    //
                    //
                    //
                    //rest job perfect
                    
                  FileWriter filewriter=new FileWriter(filename);
                  BufferedWriter bufferWriter=new BufferedWriter(filewriter);
                  bufferWriter=new BufferedWriter(filewriter);
                  bufferWriter.write("");
                  bufferWriter.close();
                  
                  FileInputStream f = new FileInputStream(temporary);
                    Scanner scanagain = new Scanner(f);
                    while(scanagain.hasNextLine())
                    {    String remaining=scanagain.nextLine();
                         FileWriter fileWritter = new FileWriter(filename,true);
                         BufferedWriter buf = new BufferedWriter(fileWritter);
                         buf.write(remaining);
                         buf.newLine();
                         buf.close();
                         
                    }
                    
                    FileWriter fw=new FileWriter(temporary);
                  BufferedWriter writer=new BufferedWriter(filewriter);
                  writer=new BufferedWriter(filewriter);
                  writer.write("");
                  writer.close();
                  System.out.println("\nFile now updated, contains latest advices");
                  System.exit(-1);
                    
                }   
                    
                }     
                
        }
        catch (IOException e)
        {
            System.out.println("Exception ");       
        }
                       
                        }          }
	}
        
    }
	public void finished(int threadId) {
		System.out.println("[" + threadId + "] finished");
	}
                   
        public static String file;
	public static void main(String[] args) {
		try {   Scanner scan=new Scanner(System.in);
                        
			int maxLevel = 2;
			int maxThreads = 5;
			
                        System.out.println("\nEnter the number of threads you want to operate: ");
                        maxThreads=scan.nextInt();
                        
                        System.out.println("\nEnter the number of levels you want to search for: ");
                        maxLevel=scan.nextInt();
                        
                        System.out.println("\nEnter the File name where you want to save: ");
                        file=scan.next();
			URLQueue q = new URLQueue();
			q.setFilenamePrefix(file);
                                
                                System.out.println("\nEnter the url name where you want to start: ");
                                String url;
                                url=scan.next();
                                URL url1=new URL(url);
                                //SaveURL.writeURLtoFile(url1, file);
				q.push(new URL(url), maxLevel);
				new WSDLCrawler(q, maxLevel, maxThreads);
				return;
                                
                            
                                
			
		} catch (Exception e) {
			System.err.println("An error occured: ");
			e.printStackTrace();
			// System.err.println(e.toString());
		}
		System.err.println("Usage: java WSDLCrawler <url> <filenamePrefix> [<maxLevel> [<maxThreads>]]");
		System.err.println("Crawls the web for WSDL descriptions.");
	}
        public static String retfile()
        {   return file;
        }
        
}

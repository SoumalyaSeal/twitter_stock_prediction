package webcrawler;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class SaveURL
{
 
    public static String savemoney(String page,String name,int per,int global)
    {   String remaining;
        
    
            String modifiedfilename="C:/Users/ss/Documents/NetBeansProjects/stock/";
            name=name.replaceAll("./","");   
            name=modifiedfilename.concat(name);
            String pattern="colr";
            Pattern p=Pattern.compile(pattern);
            Matcher matcher=p.matcher(page);
            String another="title=";
            Pattern pat=Pattern.compile(another);
            Matcher m=pat.matcher(page);
            String datetry="date pt3";
            Pattern attempt=Pattern.compile(datetry);
            Matcher mdate=attempt.matcher(page);
            
            
            while(matcher.find())
            {   
                   
                int k=matcher.end();
            
                m.find(k);
                int h=m.end()+1;
                int j=h;
                while(page.charAt(h)!='"')
                {   
                    h++;
                }
                remaining=page.substring(j, h);
                mdate.find(h);
                int start=mdate.end()+2;
                int g=start;
                
                while(page.charAt(g)!=',')
                {   g++;
                
                }
                String dategot=page.substring(start, g);
                
                
                
                try{          
    		 
                File file=new File(name);
              
            if(!file.exists())
            {    System.out.println("Create new");
                 file.createNewFile();
                 {  FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                remaining=remaining.concat(" //Date:");
                remaining=remaining.concat(dategot);
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
              
    	        bufferWriter.close();
                }
                 System.out.println(remaining);
            }
           
            else if(file.exists())
            {	//true = append file
               
                if(per==1)
                {   
                    {  FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                remaining=remaining.concat(" //Date:");
                remaining=remaining.concat(dategot);
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
              
    	        bufferWriter.close();
                }
                  System.out.println(remaining); 
                }
                else if(per==2)
                {
                    FileInputStream fis = new FileInputStream(file.getName());
                    Scanner scanner = new Scanner(fis);
                    String x=scanner.nextLine();
                    remaining=remaining.concat(" //Date:");
                    remaining=remaining.concat(dategot);
                    String temporary="temp";
                    File temp=new File(temporary);
                    
                    while(!remaining.equals(x)&& global==0)
                    {   System.out.println(remaining);
                       FileWriter fileWritter = new FileWriter(temp.getName(),true);
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
              
    	        bufferWriter.close(); 
                break;
                
                    }
                    
                    if(remaining.equals(x))
                    {   System.out.println(remaining);
                        System.out.println("\nMatch found");
                        System.out.println("\nFiles are being updated.....");
                        global=1;
                        break;
                    
                    }
      
        scanner.close();
                  
                }
            }
    	}catch(IOException e){
    		e.printStackTrace();
}

            }           
           String d="";
           d=d.valueOf(global);
           name=name.concat(d);
           return name;
           
            
    }
    
    
        public static String savetext(String page,String name)
{           int index;
            String modifiedfilename="C:/Users/ss/Documents/NetBeansProjects/stock/";
              name=name.replaceAll("./","");   
            name=modifiedfilename.concat(name);
            System.out.println(name);
            
            String patternString = "js-tweet-text";
            String p="<span class=";
            Pattern pat=Pattern.compile(p);
            Matcher m=pat.matcher(page);
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(page);
            String anstring="js-action-profile-name show-popup-with-id";
            Pattern an=Pattern.compile(anstring);
            Matcher mat=an.matcher(page);
           
            while(mat.find()) {
            
            int k=mat.end()+2;
            int se=k;
            while(page.charAt(k)!='<')
            {   k++;
            
            }
            String sender=page.substring(se,k);
           
            matcher.find();    
            { index=matcher.end();
            index=index+12;
            m.find(index);
            int l=m.start();
            int x=index;
            
            char ch='<'; 
            char t='>';
            String remaining=new String();
            
            while(index<l)
            {   index++;
                if(page.charAt(index)==ch)
                {   String part=page.substring(x, index);
                    remaining=remaining.concat(part);
                    while(page.charAt(index)!=t)
                    {index++;
                    }
                    
                    x=index;
                }    
            }
            
          
            remaining=remaining.replaceAll("Ã¢","");
            remaining=remaining.replaceAll(">","");
            remaining=remaining.replaceAll("/search?q=%23","");
            remaining=remaining.replaceAll("src=hash" ,"");
            remaining=remaining.replaceAll(";class=\"","");
            remaining=remaining.replaceAll("data-query-source=\"hashtag_click\" dir=\"ltr\"","");
            remaining=remaining.replaceAll("twitter-hashtag pretty-link js-nav\"","");
            remaining=remaining.replaceAll("\"/search?q=%23","");
            remaining=remaining.replaceAll("q=%23","");
            remaining=remaining.replaceAll("\" class=\"  ","");
            remaining=remaining.replaceAll("/search?q=%23","");
            remaining=remaining.replaceAll("/search?","");
            remaining=remaining.replaceAll("&quot","");
            remaining=remaining.replaceAll("&#39","");
            remaining=remaining.replaceAll("@","");
            
            remaining=remaining.replaceAll(";","");
            remaining=remaining.replaceAll("<a href=","");
            remaining=remaining.replaceAll("&amp","");
            remaining=remaining.replaceAll("class=\"twitter-atreply pretty-link\" dir=\"ltr\"","");
            remaining=remaining.replaceAll("#","");
            remaining=remaining.replaceAll(" data-query-source=\"hashtag_click\" class=\" dir=\"ltr\"","");
            remaining=remaining.replaceAll("Ã¢??","");
            int length=remaining.length();
            int pos=0;
            while(pos<length)
            {   
                if(remaining.charAt(0)=='"' && remaining.charAt(1)=='?')
                {  while(remaining.charAt(pos)!=' ')
                    {  pos++;
                       
                    }
                pos=pos-2;
              
                remaining=remaining.substring(3+pos,length);
                }
                pos++;
            }
           
            
            String addition=" tweeted: ";
            sender=sender.concat(addition);
            remaining=sender.concat(remaining);
            System.out.println(remaining);
            
             
            
           
   try{          
    		 
                File file=new File(name);
              
            if(!file.exists())
            {    System.out.println("Create new");
                 file.createNewFile();
            }
           
            else if(file.exists())
            {	//true = append file
               
               
                FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
              
    	        bufferWriter.close();
            }
    	}catch(IOException e){
    		e.printStackTrace();
}
            }
}
            return name;
}
        
	/**
	 * Opens a buffered stream on the url and copies the contents to writer
	 */
	public static void saveURL(URL url, Writer writer)
		throws IOException {
		BufferedInputStream in = new BufferedInputStream(url.openStream());
		for (int c = in.read(); c != -1; c = in.read()) {
			writer.write(c);
		}
	}

	/**
	 * Opens a buffered stream on the url and copies the contents to OutputStream
	 */
	public static void saveURL(URL url, OutputStream os)
		throws IOException {
		InputStream is = url.openStream();
		byte[] buf = new byte[1048576];
		int n = is.read(buf);
		while (n != -1) {
			os.write(buf, 0, n);
			n = is.read(buf);
		}
	}

	/**
	 * Writes the contents of the url to a string by calling saveURL with a
	 * string writer as argument
	 */
	public static String getURL(URL url)
		throws IOException {
		StringWriter sw = new StringWriter();
		saveURL(url, sw);   
		return sw.toString();
	}

	/**
	 * Writes the contents of the url to a new file by calling saveURL with
	 * a file writer as argument
	 */
	public static void writeURLtoFile(URL url, String filename)
		throws IOException {
		// FileWriter writer = new FileWriter(filename);
		// saveURL(url, writer);
		// writer.close();
		FileOutputStream os = new FileOutputStream(filename);
		saveURL(url, os);
		os.close();
	}
     
	/**
	 * Extract links directly from a URL by calling extractLinks(getURL())
	 */
	public static Vector extractLinks(URL url)
		throws IOException {
		return extractLinks(getURL(url));
	}

	public static Map extractLinksWithText(URL url)
		throws IOException {
		return extractLinksWithText(getURL(url));
	}

	/**
     * Extract links from a twitter page given as a raw and a lower case string
     * In order to avoid the possible double conversion from mixed to lower case
     * a second method is provided, where the conversion is done externally.
     */
  public static Vector extractLinks(String rawPage, String page) {
		int index = 0;
		Vector links = new Vector();
		while ((index = page.indexOf("data-", index)) != -1)
		{
		    if ((index = page.indexOf("expanded-", index)) == -1) break;
                    if ((index = page.indexOf("url", index)) == -1) break;
		    if ((index = page.indexOf("=", index)) == -1) break;
		    String remaining = rawPage.substring(++index);
		    StringTokenizer st 
				= new StringTokenizer(remaining, "\t\n\r\"'>#");
		    String strLink = st.nextToken();
			if (! links.contains(strLink)) links.add(strLink);
		}
		return links;
    }


	/**
	 * Extract links (key) with link text (value)
	 * Note that due to the nature of a Map only one link text is returned per
	 * URL, even if a link occurs multiple times with different texts.
	 */
	public static Map extractLinksWithText(String rawPage, String page) {
		int index = 0;
		Map links = new HashMap();
		while ((index = page.indexOf("<a ", index)) != -1)
		{
			int tagEnd = page.indexOf(">", index);
		    if ((index = page.indexOf("href", index)) == -1) break;
		    if ((index = page.indexOf("=", index)) == -1) break;
			int endTag = page.indexOf("</a", index);
		    String remaining = rawPage.substring(++index);
		    StringTokenizer st 
				= new StringTokenizer(remaining, "\t\n\r\"'>#");
		    String strLink = st.nextToken();
			String strText = "";
			if (tagEnd != -1 && tagEnd + 1 <= endTag) {
				strText = rawPage.substring(tagEnd + 1, endTag);
			}
			strText = strText.replaceAll("\\s+", " ");
			links.put(strLink, strText);
		}
		return links;
		
	}
    
    /**
	 * Extract links from a html page given as a String
	 * The return value is a vector of strings. This method does neither check
	 * the validity of its results nor does it care about html comments, so
	 * links that are commented out are also retrieved.
	 */
	public static Vector extractLinks(String rawPage) {
        return extractLinks(rawPage, rawPage.toLowerCase().replaceAll("\\s", " "));
	}

	public static Map extractLinksWithText(String rawPage) {
        return extractLinksWithText(rawPage, rawPage.toLowerCase().replaceAll("\\s", " "));
	}

	/**
	 * As a standalone program this class is capable of copying a url to a file
	 */
	
        public static void main(String[] args) {
		try {   String nameurl;
                        Scanner scan=new Scanner(System.in);
                        System.out.println("\nEnter the url whose contents you want to save:");
                        nameurl=scan.next();
                URL url = new URL(nameurl);
                System.out.println("Content-Type: " +
                    url.openConnection().getContentType());
// 				Vector links = extractLinks(url);
// 				for (int n = 0; n < links.size(); n++) {
// 					System.out.println((String) links.elementAt(n));
// 				}
                System.out.println("\nEnter the file where you want to save: ");
                String filename;
                filename=scan.next();
				Set links = extractLinksWithText(url).entrySet();
				Iterator it = links.iterator();
				while (it.hasNext()) {
					Map.Entry en = (Map.Entry) it.next();
					String strLink = (String) en.getKey();
					String strText = (String) en.getValue();
					System.out.println(strLink + " \"" + strText + "\" ");
				}
		
		
				writeURLtoFile(new URL(nameurl),filename);
				
			
		} catch (Exception e) {
			System.err.println("An error occured: ");
			e.printStackTrace();
// 			System.err.println(e.toString());
		}
		// Display usage information
		// (If the program had done anything sensible, we wouldn't be here.)
		System.err.println("Usage: java SaveURL <url> [<file>]");
		System.err.println("Saves a URL to a file.");
		System.err.println("If no file is given, extracts hyperlinks on url to console.");
        }
}

package file;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;



class Company
{
    
    public static void main(String args[])
    {
       
        it();
        banks();
        telecom();
        transport();
        fmcg();
        heavyind();
        channel();
        pharma();
        value();
        conval();
        diffval();
        expert();
       
    }
    
    public static void expert()
    {   String expert[]={
        "sukhani-1",
        "tulsian-1",
        "emkay-1",
        "bhamre-1",
        "tater-1",
        "doctor-1",
        "lilladher-1",
        "angel-1",    
        "icici-1",
        "kapur-1",
        "motilal-1",
        "dolat-1",
        "firstcall-1",
        "mittal-1",
        "mehta-1",
        "agarwal-1",
        "merani-1",
        "nirmal-1",
        "joshi-1",  
        "way2wealth-1",
        "vijay-1",
        "sekhar-1",
        "baliga-1",
        "dolat-1",
        "vijay-1",
        "madan-1"
                        };
    try{          
    		 
                File file=new File("experts");
                String remaining;    
                    
            
                file.createNewFile();
                FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                for(int i=0;i<expert.length;i++)
                {   remaining=expert[i];
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
                }
    	        bufferWriter.close();
             
                 
           
            
            }
             catch(IOException e){
    		e.printStackTrace();
        }
    
    
    
    }
     public static void value()
    { 
        String company[] = {"good trading bets-4",
            "may see more pain-2.4",
            "jump-3.9",
            
            
            "not much upside in-2.8",
            "profit booking-3.8",
            "may go upto-3.7",
            "can appreciate-3.5",
            "may not fall below-3.1",
            "profit booking may happen-3.9",
            "good stock-4",
            "get in-4",
            "excellent stock-4.5",
            "good choice-4",
            "looks promising-3.9",
            "a good midcap stock-3.9",
            "started weakening-2.2",
            "will do well-3.9",
            "good fundamental stock-4",
            "don't sell-3.4",
            "a market performer-4",
            "go down-2",
            "not a portfolio stock-2",
            "good long-term bets-4",
            "speculative buying-3.7",
            "advises to buy-3.8",
            "not good long-term bets-2.5",
            "re-rating story will continue-3",
            "worst over for-3.2",
            "why you should buy-4",
            "will soar-3.9",
            "can pullback-3.8",
            "can come down-2.5",
            "likely to see more short covering-2.5",
            "long-term bets-4",
            "long-term buy-4",
            "long term-4",
            "good short-term bets-3.7",
            "best stock to own-4",
            "core portfolio stock-4",
            "will give good result-4",
            "good for investment-4",
            "a portfolio stock-4",
"can depreciate-2.5",
"do not expect-2",
"can give good returns-4",
"can go up-4",
"a good investmment bet-4",
"can go upto-3.5",
"can hit short term target-3.5",
"can increase-4",
"can jump-4.5",		
"can move up to-4",
"can rise further-4",
"can sell-2",
"can slip-1.5",
"can test-3",
"do not go short in-3.5",
"do not see secular upside in-2",	
"do not see sharp rebound in-2",
"do not see upside in-2",
"do not short-3.5",
"don't buy-1.5",
"don't go long in-1.5",
"don't see major upmove in-2.2",
"don't short-3.5",
"can see smart upmove-4",
"continue to be negative on-1",
"continue to be positive on-4",
"continue to outperform-4.5",			
"could be a safe buy-4",
"expect big upside in-4",
"could be dark horses-3.5",
"likely to appreciate-3.5",
"likely to consolidate-4",
"likely to depreciate-2",
"likely to move down-2",	
"likely to move up-3.5",
"likely to perform well-3.7",
"not likely to outperform-2.5",
"likely to outperform-3.5",
"likely to slip-2",
"looking good-3.5",
"look good-3.5",
"looks good-3.5",
"looks great-3.8",
"look strong-4",
"looks strong-4",
"look weak-2",
"looks weak-2",
"looks attractive-3.5",
"look attractive-3.5",
"looks cheap-3.5",
"look cheap-3.5",
"looks expensive-2.5",
"look expensive-2.5",
"looks good-3.5",
"look good-3.5",
"looks overrated-2.5",
"look overrated-2.5",
"looks strong-3.5",
"look strong-3.5",
"looks weak-2.5",
"look weak-2.5",
"maintains a 'buy'-4",	
"may hit further-1.4",
"may head lower-1.5",
"may appreciate-3.5",
"may bounce back-3.2",
"may damage-2.4",
"may decline to-2.5",
"may dip down-2",
"may dip to-2",
"may do well-3.5",
"may extend rally till-4",
"may fall further-2.5",
"may go above-4",
"may go below-2",
"may increase-3.5",
"may not appreciate-2",	
"may not do well-2.5",
"may not go below-3.5",
"may not go beyond-2.5",
"may outperform-4",
"may overperform-4",	
"may rally-3.5",
"may rise-3.5",
"may rise further-4",
"may see downside-2.5",
"may see further downside-2",	
"may see good-3.5",
"may see upmove-3.5",
"may see upside-4.5",
"may sell-2",
"may slip-2",
"may slip below-1.5",
"may slip further-1.5",	
"may slip to-1.5",
"may test-3",
"may underperform-2",
"momentum can continue-3.5",	
"momentum could continue-3.5",
"momentum likely to continue-3.5",
"more downside seen in-2",
"more upside-4",
"neutral to underweright-2.5",
"next upmove likely to begin-3.5",
"not an outperformer-2.5",
"not an underperformer-3.4",
"not much upside in-2.2",
"offers buying opportunities-4",
"buying opportunity seen in-4.5",
"price decrease-2",
"price increase-4",	
"prices decrease-2",
"prices increase-4",
"profits below-3.5",
"profits dip-3.2",
"profits reduce-3.1",
"remain rangebound-3",
"raises target price-4",
"recommend-3.9",
"rally further-3.5",
"recommends to buy-4",
"recommends to 'reduce'-2.5",
"safe bet-3.8",
"remain invested in-4",
"remain negative on-1.5",
"remains a buy-4",	
"remains a 'buy'-4",
"remains a sell-1",
"remains a 'sell'-1",
"remains neutral-3",
"remains strong bet-4",
"see better performance-3.5",
"see further downside in-2",
"see further upside in-3.5",
"see gain in-4",	
"see higher levels in-3.5",
"see limited downside in-2.5",
"see lower levels in-1.4",
"see more downside in-2",
"see more upside in-4",	
"see profit booking in-4",
"should buy-3.8",
"return in-3.8",
"should you invest-3",
"see smart upmove-3.5",
"see substantial downside in-1.5",
"see substantial upside in-4.5",
"see upmove-4",
"see ups in-4",
"see upside in-3.5",
"sees good for-4",
"see sideways correction-2.7",
"should avoid-2",
"should do well-4",
"should exit-2",
"should invest in-4",
"should not invest in-2",	
"should sell-1",
"stay away from-2",
"stay in-4",
"stay invested-4",	
"stay long in-4",
"stay with-3.5",
"upgrades to buy-3.5",	
"upgrades to 'overweight'-3.5",		
"a better sector to be in-4",
"advises caution-2.5",
"cautious-2.5",
"a good dividend stock to bet on-3.5",
"a good trading bet-3.5",
"a much better story than-3.5",
"a perfect buying opportunity-5",	
"a safe investment-5",
"take long position in-4.7",
"wait for correction to enter in-3.5",
"won't buy-1.5",
"will see smart upmove-4",
"accumulate-4.5",
"accumulating-4.5",
"add-4",
"advises to exit-2",
"an excellent pick-4.9",	
"arbitrage-4.5",
"attractive-4.5",
"attractive bet-4",
"avoid-1.5",
"bearish-2",
"best bet-4.5",	
"best pick-4.6",
"bet-3.5",
"bets-3.5",
"book partial profits in-3.5",
"book profit-3.3",
"book some profits in-3.5",
"bullish on-4",	
"buy-4.5",
"buying opportunity in-4",
"buying opportunity seen in-4",
"buying opportunities seen-4",
"cautions-2",
"consolidate-4",	
"downbeat-2",
"downside-2",
"downgrades-2",
"downside in-2",
"enter-4",	
"exit-1.8",
"expect strong selling-1.5",
"expects the price to rally-3.5",
"expect lower levels-2",	
"expect continued momentum-3.6",
"gainer-3.5",
"go long-4",
"go short-2.5",
"good bet-4",
"good company-4",
"good long term bet-4.5",
"likely to be market performer-4",	
"good performer-4.5",
"good quality stocks-5",
"good short term bets-3.5",	
"have not met our expectations-2",
"hold-3",
"how to trade-3",
"increase-4",
"invest in-4",
"is attractive-3.5",
"like-3.5",
"limited upside-3.5",
"long-4",
"loser-2",
"how to play-3",
"met our expectations-4",	
"multibaggers-4",
"negative on-2",
"neutral on-3",
"'neutral' on-3",
"optimistic-4",
"outperformer-4",
"outperform-4",
"overperform-4",
"overweight-4",	
"pessimistic-1",
"top pick-4.2",
"picks-4",
"pick-4",
"positive on-3.5",
"prefer-4",
"possibility of downgrading-2",
"recommendation-4",
"recommended-4",
"recommends-4",	
"reduce-2",
"safer-3.5",
"safest-4",
"sell on rally-1.5",
"sell partial holding in-2.5",
"to see deep correction-1.8",
"expects correction-3",
"selling pressure-2",
"selling spree-1",
"sell-1.5",
"shares fall-1.5",
"short-2",
"shun-2",
"skeptical-3",
"slips-2",
"stock down-2.5",
"stock up-3.5",
"strongest bet-5",
"surges-4",	
"swing trading opportunities-3.5",
"to remain under pressure-2",	
"to rise-3.5",
"top gainer-4",
"top loser-1",
"top pick-4",
"topping-4",
"traders can book profit in-4",	
"trading opportunities seen in-4",
"underperform-2",
"underweight-1.5",
"raise-3.8",
"upbeat on-4",
"upmove-4",
"upside-4",

"up -4",
"uptrend likely to be over-2.6",
"fall-2",
"rally-4",
"uptrend-4",
"return-4",
"record high-4.9",
                "low-1.8",
                "high-3.9"

        }; 
   
         try{          
    		 
                File file=new File("value");
                String remaining;    
                    
            
                file.createNewFile();
                FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                for(int i=0;i<company.length;i++)
                {   remaining=company[i];
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
                }
    	        bufferWriter.close();
             
                 
           
            
            }
             catch(IOException e){
    		e.printStackTrace();
        }
    
        
    }
     public static void conval()
    { 
        String company[] = {"accumulate xxx advises-4","add xxx to your portfolio-4","avoid xxx says-2","add xxx in your portfolio-4",
"buy xxx advises-4.5","buy xxx on every dip-4",	"buy xxx on correction-3.5","buy xxx on dip-4","sell xxx at higher levels-2.5",		
"buy xxx only on correction-3.9","buy xxx on decline-3.5","cuts xxx rating-2.5",
"do not see xxx above-2.5","do not see xxx below-3.5","exit xxx on rally-2.5","exit xxx at higher level-2.5",
"expect another xx% rally-4","expect xxx to rally to-3.5",	
"expects xx% rally-3.5","hold xxx in portfolio-3","see xxx above-4","see xxx below-2",		
"short xxx with long term view-2.5","target xxx, expects rally-4","short xxx on-2.5",         
"expect xxx to outperform-3.8","like xxx-3.5","than xxx-2.5","prefer xxx-3.5","over xxx-2.5",
"prefer xxx-3.5","to xxx-2.5","switch to xxx-3.5","from xxx-2.5","expect xxx to move up-3.8"        
    };
       
   
try{          
    		 
                File file=new File("bothvalue");
                String remaining="";    
                    
            
                 file.createNewFile();
                 FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                for(int i=0;i<company.length;i++)
                {   remaining=company[i];
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
                }
    	        bufferWriter.close();
             
                 
           
            
    	}catch(IOException e){
    		e.printStackTrace();
}
    }
    
      public static void diffval()
    { 
        String company[] = {"like xxx1than yyy-3.5@2.5","prefer xxx1over yyy-3.5@2.5","switch to xxx1from yyy-3.8@2.5",
"prefer xxx1to yyy-3.5@2.5","switch to xxx1from yyy-3.5@2.5"
        };
   


try{          
    		 
                File file=new File("contrast");
                String remaining="";    
                    
            
                 file.createNewFile();
                 FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                for(int i=0;i<company.length;i++)
                {   remaining=company[i];
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
                }
    	        bufferWriter.close();
             
                 
           
            
    	}catch(IOException e){
    		e.printStackTrace();
}
    }
      
      
    public static void it()
    { 
      String company[] = {"satyam","mphasis","hcl","tech mahindra","infosys/infy","wipro",
"tcs/tata consultancy"};
   
     //   String company[]={"mphasis"};
try{          
    		 
                File file=new File("it");
                String remaining="";    
                    
            
                 file.createNewFile();
                 FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                for(int i=0;i<company.length;i++)
                {   remaining=company[i];
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
                }
    	        bufferWriter.close();
             
                 
           
            
    	}catch(IOException e){
    		e.printStackTrace();
}
    }
    
   
     public static void banks()
    { 
        String company[] = {
"pnb/punjab national bank/psu bank",
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
"lic housing"};
   
try{          
    		 
                File file=new File("banks");
                String remaining="";    
                    
            
                 file.createNewFile();
                 FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                for(int i=0;i<company.length;i++)
                {   remaining=company[i];
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
                }
    	        bufferWriter.close();
             
                 
           
            
    	}catch(IOException e){
    		e.printStackTrace();
}
    }
      public static void telecom()
    {      
        String company[] = {"bharti","idea","rcom/reliance communications"};
   
try{          
    		 
                File file=new File("telecom");
                String remaining="";    
                    
            
                 file.createNewFile();
                 FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                for(int i=0;i<company.length;i++)
                {   remaining=company[i];
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
                }
    	        bufferWriter.close();
             
                 
           
            
    	}catch(IOException e){
    		e.printStackTrace();
}
    }
       public static void transport()
    { 
        String company[] = {
"maruti",
"m&m/mahindra and mahindra",
"tata motors",
"hero",
"bajaj auto",
"jet",
"spicejet",
"kingfisher"
};
   
try{          
    		 
                File file=new File("transport");
                String remaining="";    
                    
            
                 file.createNewFile();
                 FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                for(int i=0;i<company.length;i++)
                {   remaining=company[i];
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
                }
    	        bufferWriter.close();
             
                 
           
            
    	}catch(IOException e){
    		e.printStackTrace();
}
    }
        public static void fmcg()
    { 
        String company[] = {"voltas",
"exide",
"itc",
"hul/unilever",
//"united breweries",
"bata",

//"titan industries",


"chambal",
//"tata global beverage",
//"united phos"
                "grasim"        };
        
       // String company[]={"voltas","itc","hul","godrej"};
         
        
   
try{          
    		 
                File file=new File("fmcg");
                String remaining="";    
                    
            
                 file.createNewFile();
                 FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                for(int i=0;i<company.length;i++)
                {   remaining=company[i];
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
                }
    	        bufferWriter.close();
             
                 
           
            
    	}catch(IOException e){
    		e.printStackTrace();
}
    }
         public static void heavyind()
    { 
        String company[] = {"cummins", 
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
"l&t/larsen & toubro"
};
   
try{          
    		 
                File file=new File("heavy");
                String remaining="";    
                    
            
                 file.createNewFile();
                 FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                for(int i=0;i<company.length;i++)
                {   remaining=company[i];
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
                }
    	        bufferWriter.close();
             
                 
           
            
    	}catch(IOException e){
    		e.printStackTrace();
}
    }
          public static void channel()
    { 
        String company[] = {"sun tv","zee","dish tv"};
   
try{          
    		 
                File file=new File("channel");
                String remaining="";    
                    
            
                 file.createNewFile();
                 FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                for(int i=0;i<company.length;i++)
                {   remaining=company[i];
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
                }
    	        bufferWriter.close();
             
                 
           
            
    	}catch(IOException e){
    		e.printStackTrace();
}
    }
        
 public static void pharma()
    { 
        String company[] = {"reddys", "ranbaxy",
"cipla",
"glenmark",
"wockhardt",
"sun pharma", 
"aurobindo",
        "lupin"};
   
try{          
    		 
                File file=new File("pharma");
                String remaining="";    
                    
            
                 file.createNewFile();
                 FileWriter fileWritter = new FileWriter(file.getName());
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWritter);
                for(int i=0;i<company.length;i++)
                {   remaining=company[i];
    	        bufferWriter.write(remaining);
                bufferWriter.newLine();
                }
    	        bufferWriter.close();
             
                 
           
            
    	}catch(IOException e){
    		e.printStackTrace();
}


   
    }
 
        }

    
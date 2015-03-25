package PO;

import java.util.ArrayList;

import Enum.Season;

public class SeasonListPO {
	 static ArrayList<SeasonPO> seasons;
	 
	 public SeasonListPO(){
		 seasons= new ArrayList<SeasonPO>();
		 seasons.add(new SeasonPO(Season.season12_13));
		 seasons.add(new SeasonPO(Season.season13_14));
		 seasons.add(new SeasonPO(Season.season14_15));
		 
	 }
	 
	 public static SeasonPO findSeasonByYear(String key){
		 SeasonPO theSeason = null ;
		 if(key.substring(0,5).equals("12-13"))
			 return seasons.get(0);
		 else if(key.substring(0,5).equals("13-14"))
			 return seasons.get(1);
		 else if(key.substring(0,5).equals("14-15"))
			 return seasons.get(2);
		 else
			 return null;
	 }
	
}
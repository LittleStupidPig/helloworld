package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class toBeRich {
public static void main(String[] args) {
		
		File f=new File("D:/project/Test/document","hi.txt");
		List<Lottery> lotteries=ReadFile(f);	
		generateFile(lotteries);
	}
	
	private static void generateFile(List<Lottery> lotteries) {
		
	StringBuffer sb=new StringBuffer();
		
	List<Lottery> supOrders=new ArrayList<>();
	List<Lottery> bigOrders=new ArrayList<>();
	List<Lottery> midOrders=new ArrayList<>();
	List<Lottery> litOrders=new ArrayList<>();
	List<List<Lottery>> allLotteries=new ArrayList<>();
	allLotteries.add(supOrders);
	allLotteries.add(bigOrders);
	allLotteries.add(midOrders);
	allLotteries.add(litOrders);
	
	HashMap<String,Float> hashset=new HashMap<>();//B、S、早盘竞价交易、尾盘竞价交易、不明交易
	String keys[]=new String[]{"B","S","早盘竞价交易","尾盘竞价交易","不明交易"}; 
	
	HashMap<Float,Float> priceTable=new HashMap<>();
	List<Float> allKeys=new ArrayList<>();
	List<PriceTable> ptables=new ArrayList<>();
	
	for(Lottery lottery:lotteries){
		lottery.sum=lottery.price*lottery.biShu*100;
		float value=lottery.price;
		if(priceTable.get(value)!=null){
		priceTable.put(value, priceTable.get(value)+lottery.sum);
		}else{
		allKeys.add(value);
		priceTable.put(value, lottery.sum);
		}
		
		
		if(lottery.getBiShu()>=1000){
			supOrders.add(lottery);
		}
		else if(lottery.getBiShu()<1000&&lottery.getBiShu()>=500){
			bigOrders.add(lottery);
		}
		else if(lottery.getBiShu()<500&&lottery.getBiShu()>=100){
			midOrders.add(lottery);
		}
		else{
			litOrders.add(lottery);
		}
		
		Comparator<Lottery> c=new Comparator<Lottery>(){
			public int compare(Lottery o1, Lottery o2) {
				if(o1.sum>=o2.sum)
				return -1;
				else
				return 1;
			}
		};
		Collections.sort(supOrders,c);
		Collections.sort(bigOrders,c);
		Collections.sort(midOrders,c);
		Collections.sort(litOrders,c);
	}
	
	long totalBiShu=0;//全部多少股
	
	for(Lottery lottery:lotteries){
		totalBiShu+=lottery.biShu*100;
		String key=lottery.getBuyOrSell();
		if(hashset.get(key)!=null){
		float value=hashset.get(key)+lottery.biShu*100*lottery.price;
		hashset.put(key, value);
		}
		else{
		float value=lottery.biShu*100*lottery.price;
		hashset.put(key, value);
		}	
	}
	
	float totalSum=0;//全部money
	
	for(String key:keys){
		sb.append("  "+"\r\t"+key+":  "+hashset.get(key)).append("\r\n");
		totalSum+=hashset.get(key);
	}
	
	float averagePrice=totalSum/totalBiShu;
	
	sb.append("  \r\t总计:"+totalSum).append("\r\n");
	sb.append("  \r\t均价:"+averagePrice).append("\r\n");
	sb.append("\r\n");
	
	for(float f:allKeys){
		float value=priceTable.get(f);
		PriceTable pt=new PriceTable();
		pt.setSum(value);
        pt.setPrice(f);
		ptables.add(pt);
	}
	
	Comparator<PriceTable> c=new Comparator<PriceTable>(){
		public int compare(PriceTable o1, PriceTable o2) {
			if(o1.fsum>=o2.fsum)
			    return -1;
			else{
				return 1;
			}
		}
	};
	
	Collections.sort(ptables, c);
	
	for(PriceTable pt:ptables){
		sb.append(pt.toString(pt)).append("\r\n");
	}
	
	sb.append("\r\n");
	
	for(List<Lottery> lotterys:allLotteries){
		AnalyseLottery(lotterys,sb);
	}
	
	writeTxtFile(sb);
}

	private static void writeTxtFile(StringBuffer sb) {
		File report=new File("D:/project/Test/document","report.txt");
		
		if(!report.getParentFile().exists()){
		report.getParentFile().mkdirs();	
		}
		
		try(FileWriter fw=new FileWriter(report);
			PrintWriter pw=new PrintWriter(fw);){
			String sbToStr=sb.toString();
			pw.print(sbToStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void AnalyseLottery(List<Lottery> lotterys,StringBuffer sb) {
	  
      for(Lottery lottery:lotterys){
    	sb.append(lottery.toString(lottery)).append("\r\n");
      }
		
	}

	public static List<Lottery> ReadFile(File f){
		List<Lottery> lotteries=new ArrayList<>();
		try(FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);){
			while(true){
				String line=br.readLine();
				if(null==line)
					break;
				int count=0;
                Lottery lottery=catchWords(line,count);
                lotteries.add(lottery);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return lotteries;
	}

	private static Lottery catchWords(String line,int count) {
		String lines[]=line.split("	");
		Lottery lottery=new Lottery();
		if(lines.length==4||lines.length==5){
			lottery.setTime(lines[0]);
			lottery.setPrice(Float.parseFloat(lines[1]));
			lottery.setBiShu(Integer.parseInt(lines[2]));
			lottery.setDanShu(Integer.parseInt(lines[3]));
			if(lines.length==5){
			lottery.setBuyOrSell(lines[4]);
			}
			else if(lottery.time.equals("9:25")){
			lottery.setBuyOrSell("早盘竞价交易");
			}
			else if(lottery.time.equals("15:00")){
			lottery.setBuyOrSell("尾盘竞价交易");
			}
			else{
			lottery.setBuyOrSell("不明交易");
			}
		}
		return lottery;
	}
}

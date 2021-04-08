package Test;

import java.text.SimpleDateFormat;

public class Lottery {
    SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
    public String time;
    public float price;
    public int biShu;//笔数,一笔等于100股；
    public int danShu;//单数，表示每个价格有多少人成交；
    public String buyOrSell;//buy还是sell
    public float sum;
    
    public String getTime(){
    	return time;
    }
    public void setTime(String time){
    	this.time=time;
    }
    public float getPrice(){
    	return price;
    }
    public void setPrice(float price){
    	this.price=price;
    }
    public int getBiShu(){
    	return biShu;
    }
    public void setBiShu(int biShu){
    	this.biShu=biShu;
    }
    public int getDanShu(){
    	return danShu;
    }
    public void setDanShu(int danShu){
    	this.danShu=danShu;
    }
    public String getBuyOrSell(){
    	return buyOrSell;
    }
    public void setBuyOrSell(String buyOrSell){
    	this.buyOrSell=buyOrSell;
    }
    public float getSum(){
    	return sum;
    }
    public void setSum(float sum){
    	this.sum=sum;
    }
    
    public String toString(Lottery lottery){
    	return "\t 时间-"+lottery.time+"\t 价格-"+lottery.price+"\t 笔数-"+lottery.biShu+"  \t 交易帐户数（假想）-"+lottery.danShu+"\t 被动买还是主动买-"+lottery.buyOrSell+"\t 小计-"+lottery.sum;
    }
}

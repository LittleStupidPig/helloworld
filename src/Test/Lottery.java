package Test;

import java.text.SimpleDateFormat;

public class Lottery {
    SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
    public String time;
    public float price;
    public int biShu;//����,һ�ʵ���100�ɣ�
    public int danShu;//��������ʾÿ���۸��ж����˳ɽ���
    public String buyOrSell;//buy����sell
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
    	return "\t ʱ��-"+lottery.time+"\t �۸�-"+lottery.price+"\t ����-"+lottery.biShu+"  \t �����ʻ��������룩-"+lottery.danShu+"\t ��������������-"+lottery.buyOrSell+"\t С��-"+lottery.sum;
    }
}

package Test;

public class Report {
	    public String time;
	    public float price;
	    public int biShu;//����,һ�ʵ���100�ɣ�
	    public int danShu;//��������ʾÿ���۸��ж����˳ɽ���
	    public String buyOrSell;//buy����sell
        public float totalMoney;
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
	    public float getTotalMoney(){
	    	return totalMoney;
	    }
	    public void setTotalMoney(float totalMoney){
	    	this.totalMoney=totalMoney;
	    }
	    public String toString(Report report){
	    	return "\t ʱ��-"+report.time+"\t �۸�-"+report.price+"\t ����-"+report.biShu+"  \t �����ʻ��������룩-"+report.danShu+"\t ��������������-"+report.buyOrSell+"\t �ܽ��-"+report.totalMoney;
	    }
}

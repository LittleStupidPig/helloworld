package Test;

public class PriceTable {
public float fprice;
public float fsum;
public void setPrice(float fprice){
	this.fprice=fprice;
}
public float getPrice(){
    return fprice;
}
public void setSum(float fsum){
	this.fsum=fsum;
}
public float getSum(){
	return fsum;
}

public String toString(PriceTable pt){
	return " \t �۸�"+pt.fprice+"  "+"\t С�ƣ�"+pt.fsum;
}
}

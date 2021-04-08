package Another;

import other.Item;
import other.LifePotion;

public class ADHero extends Hero{
	int moveSpeed=400; //移动速度
	 public ADHero(String name){
	        super(name);
	        System.out.println("AD Hero的构造方法");
	    }
	     
	    public static void main(String[] args) {
	    	ADHero h= new ADHero("haha");
	         
	        System.out.println(h.getMoveSpeed());
	        System.out.println(h.getMoveSpeed2());
	        
	        LifePotion lp=new LifePotion();
	        h.useItem(lp);
	    }
	    public int getMoveSpeed(){
	        return this.moveSpeed;
	    }
	     
	    public int getMoveSpeed2(){
	        return super.moveSpeed;
	    }
	    public void useItem(Item i){
	    	System.out.println("操你妈的ADHero");
	    	super.useItem(i);
	    }
}

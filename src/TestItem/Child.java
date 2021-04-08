package TestItem;

public class Child {

	public static void main(String[] args) {
		//生成小孩
		String child[]=new String[500];
		for(int i=0;i<500;i++){
			child[i]="第"+(i+1)+"个小孩";
		}
		lastManStanding(child);
	}

	  
	private static void lastManStanding(String child[]) {
        int total=child.length;
       
        if(3<total){
        	int length=total-1;
        	String newChildren[]=new String[length];
            newChildren[length-1]=child[1];//新数组倒数一位是原数组第二位
            newChildren[length-2]=child[0];//新数组倒数第二位是原数组第一位
            System.arraycopy(child, 3 , newChildren , 0 , total-3);//新数组第一位及往后total-3位是....
        	lastManStanding(newChildren);
        }
        else if(3>=total){
        	System.out.println("最后的幸存者:"+child[1]);
        }
	}
}

package TestItem;

import java.util.ArrayList;
import java.util.List;

public class Kid {

	public static void main(String[] args) {
		
		//生成小孩
		List<String> kids=new ArrayList<>();
		for(int i=1;i<=500;i++){
			kids.add("第"+i+"个小孩");
		}
		lastManStanding(kids);
	}

	  
	private static void lastManStanding(List<String> kids) {
        int total=kids.size();
        
        if(3<total){
        	kids.remove(2);
        	List<String> remainKids=reformTheTeam(kids);//每杀死一个小孩，重新整理队伍，让第四名小孩排第一位。
        	lastManStanding(remainKids);
        }
        //当小孩数量小于等于3，就心算了，也没几步...
        else if(3>=total){
        	kids.remove(2);
        	kids.remove(0);
        	System.out.println("最后的幸存者:"+kids.get(0));
        }
	}

	private static List<String> reformTheTeam(List<String> kids) {
		    List<String> remainKids=kids.subList(2,kids.size());
        	remainKids.add(kids.get(0));
        	remainKids.add(kids.get(1));
            return remainKids;
    }
}

package TestItem;

import java.util.ArrayList;
import java.util.List;

public class Kid {

	public static void main(String[] args) {
		
		//����С��
		List<String> kids=new ArrayList<>();
		for(int i=1;i<=500;i++){
			kids.add("��"+i+"��С��");
		}
		lastManStanding(kids);
	}

	  
	private static void lastManStanding(List<String> kids) {
        int total=kids.size();
        
        if(3<total){
        	kids.remove(2);
        	List<String> remainKids=reformTheTeam(kids);//ÿɱ��һ��С��������������飬�õ�����С���ŵ�һλ��
        	lastManStanding(remainKids);
        }
        //��С������С�ڵ���3���������ˣ�Ҳû����...
        else if(3>=total){
        	kids.remove(2);
        	kids.remove(0);
        	System.out.println("�����Ҵ���:"+kids.get(0));
        }
	}

	private static List<String> reformTheTeam(List<String> kids) {
		    List<String> remainKids=kids.subList(2,kids.size());
        	remainKids.add(kids.get(0));
        	remainKids.add(kids.get(1));
            return remainKids;
    }
}

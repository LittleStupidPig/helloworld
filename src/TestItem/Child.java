package TestItem;

public class Child {

	public static void main(String[] args) {
		//����С��
		String child[]=new String[500];
		for(int i=0;i<500;i++){
			child[i]="��"+(i+1)+"��С��";
		}
		lastManStanding(child);
	}

	  
	private static void lastManStanding(String child[]) {
        int total=child.length;
       
        if(3<total){
        	int length=total-1;
        	String newChildren[]=new String[length];
            newChildren[length-1]=child[1];//�����鵹��һλ��ԭ����ڶ�λ
            newChildren[length-2]=child[0];//�����鵹���ڶ�λ��ԭ�����һλ
            System.arraycopy(child, 3 , newChildren , 0 , total-3);//�������һλ������total-3λ��....
        	lastManStanding(newChildren);
        }
        else if(3>=total){
        	System.out.println("�����Ҵ���:"+child[1]);
        }
	}
}

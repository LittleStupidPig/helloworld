package Another;

import other.Item;

public class Hero{
    
    String name; //����
        
    float hp; //Ѫ��
        
    float armor; //����
        
    int moveSpeed; //�ƶ��ٶ�
     
    public Hero(){
        System.out.println("Hero���޲εĹ��췽�� ");
    }
     
    public Hero(String name){
        System.out.println("Hero����һ�������Ĺ��췽�� ");
        this.name = name;
    }
     
    public static void main(String[] args) {
        new Hero();
    }
    
    public void useItem(Item i){
     System.out.println("Hero��Item");
    }
      
}
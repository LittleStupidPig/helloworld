package Test;
import java.util.ArrayList;
import java.util.List;

import pojo.Hero;
 
public class TestCollection {
    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
        	Hero hero=new Hero();
        	hero.setName("hero"+i);
            heros.add(hero);
        }
        String hs[]=(String []) heros.toArray((new Hero().name));
        for(String s:hs){
        	System.out.println(s);
        }
    }
}
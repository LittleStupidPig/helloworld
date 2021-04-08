package JavaTest;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import pojo.VipTest;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, Throwable, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class vip1=Class.forName("pojo.VipTest");
        Constructor cons=vip1.getDeclaredConstructor(int.class,String.class,String.class,boolean.class);
        VipTest obj1=(VipTest) cons.newInstance(1,"Ð¡Ã÷","·ðÉ½",true);
        System.out.println(obj1.toString(obj1));
    }

}


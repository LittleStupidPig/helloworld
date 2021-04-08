package pojo;

public class VipTest {
    int no;
    String name;
    String City;
    boolean Sex;
    public VipTest(int no,String name,String City,boolean Sex){
        this.no=no;
        this.name=name;
        this.City=City;
        this.Sex=Sex;
    }
    public String toString(VipTest v){
     return v.no+" "+v.name+" "+v.City+" "+v.Sex;
    }
}

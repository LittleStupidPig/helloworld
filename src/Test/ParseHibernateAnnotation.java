package Test;

import java.lang.reflect.Method;

import hibernate_annotation.MyColumn;
import hibernate_annotation.MyEntity;
import hibernate_annotation.MyGeneratedValue;
import hibernate_annotation.MyId;
import hibernate_annotation.MyTable;
import pojo.Hero;

public class ParseHibernateAnnotation {

	public static void main(String[] args) {
		Class<Hero> claee=Hero.class;
		MyEntity myEntity=(MyEntity) claee.getAnnotation(MyEntity.class);
			if(null==myEntity){
				System.out.println("Hero不是实体类");
			}
			else{
				System.out.println("Hero是实体类");
				MyTable myTable=(MyTable) claee.getAnnotation(MyTable.class);
				String tableName=myTable.name();
				System.out.println("其对应的表名是："+tableName);
				Method[] methods=claee.getMethods();
				Method primaryKeyMethod=null;
				for(Method m:methods){
					MyId myid=m.getAnnotation(MyId.class);
					if(null!=myid){
						primaryKeyMethod=m;
						String methodname=primaryKeyMethod.getName();
						System.out.println("主键方法名："+methodname);
						System.out.println("找到主键："+method2attribute(methodname));
						MyGeneratedValue myGeneratedValue=primaryKeyMethod.getAnnotation(MyGeneratedValue.class);
						System.out.println("其自增长策略是："+myGeneratedValue.strategy());
						MyColumn myColumn=primaryKeyMethod.getAnnotation(MyColumn.class);
						System.out.println("对应数据库中的字段是："+myColumn.value());
						break;
					}
				}
				
				System.out.println("其他非主键属性分别对应的数据库字段如下：");
				for(Method m:methods){
					if(m!=primaryKeyMethod){
						MyColumn myColumn=m.getAnnotation(MyColumn.class);
						if(null!=myColumn){
						System.out.printf("属性： %s\t对应的数据库字段是:%s%n",method2attribute(m.getName()),myColumn.value());
						}
					}
				}
	
			}
	}

	private static String method2attribute(String methodname) {
		String result=methodname;
		result=result.replaceFirst("get","");
		result=result.replaceFirst("is","");
		if(result.length()<=1){
			return result.toLowerCase();
		}
		else{
			return result.substring(0,1).toLowerCase()+result.substring(1,result.length());
		}
	}
	
	
}

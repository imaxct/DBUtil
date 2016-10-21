package imaxct.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class BeanUtil {

	public static <T> T toBean(Class<T> clazz, ResultSet resultSet) throws Exception {
		if (resultSet==null)
			return null;
		ResultSetMetaData rsmd = resultSet.getMetaData();
		int colCount = rsmd.getColumnCount();
		if (!resultSet.next()) 
			return null;
		Field field;
		T obj =  clazz.newInstance();
		for (int i=1; i<=colCount; ++i){
			field = clazz.getDeclaredField(rsmd.getColumnLabel(i));
			field.setAccessible(true);
			field.set(obj, resultSet.getObject(i));
		}
		return obj;
	}
	
	public static <T> List<T> toBeanList(Class<T> clazz, ResultSet resultSet) throws Exception{
		if (resultSet==null)
			return null;
		ResultSetMetaData rsmd = resultSet.getMetaData();
		int colCount = rsmd.getColumnCount();
		List<T>list = null;
		if (!resultSet.next())
			return null;
		list = new ArrayList<T>();
		Field field;
		do {
			T obj = clazz.newInstance();
			for (int i=1; i<=colCount; ++i){
				field = clazz.getDeclaredField(rsmd.getColumnLabel(i));
				field.setAccessible(true);
				field.set(obj, resultSet.getObject(i));
			}
			list.add(obj);
		}while (resultSet.next());
		return list;
	}
}

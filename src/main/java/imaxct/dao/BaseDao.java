package imaxct.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import imaxct.util.BeanUtil;
import imaxct.util.ConnectionUtil;

public class BaseDao<T> {
	
	public int update(String sql, Object... objects) {
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			if (objects != null)
				for (int i=0; i<objects.length; ++i)
					ps.setObject(i + 1, objects[i]);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			ConnectionUtil.close(connection);
		}
	}

	public T find(Class<T> clazz, String sql, Object... objects) {
		T t = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			if (objects != null)
				for (int i = 0; i < objects.length; ++i)
					ps.setObject(i + 1, objects[i]);
			ps.setMaxRows(1);
			ResultSet rs = ps.executeQuery();
			t = BeanUtil.toBean(clazz, rs);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionUtil.close(connection);
		}
	}
	
	public List<T> list(Class<T>clazz, String sql, Object... objects){
		List<T>list = null;
		Connection connection = null;
		try{
			connection = ConnectionUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			if (objects != null)
				for (int i=0; i<objects.length; ++i)
					ps.setObject(i + 1, objects[i]);
			ResultSet rs = ps.executeQuery();
			list = BeanUtil.toBeanList(clazz, rs);
			return list;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}finally {
			ConnectionUtil.close(connection);
		}
	}
}

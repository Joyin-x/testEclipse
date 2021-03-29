package com.how2java;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.how2java.pojo.Category;
public class TestMybatis {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String resource="mybatis-config.xml";
		InputStream inputstream=Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession session=sqlSessionFactory.openSession();
		Map<String,Object> map=new HashMap<>();
		map.put("id",3);
		map.put("name","Cat");
	    listAll(session,map);
	    session.commit();
	    session.close();
	}
	public static void listAll(SqlSession session,Map<String,Object> map) {
		List<Category> cs=session.selectList("listCategoryByid",map);
		for(Category c :cs) {
			System.out.println(c.getName());
		}
		
	}

}

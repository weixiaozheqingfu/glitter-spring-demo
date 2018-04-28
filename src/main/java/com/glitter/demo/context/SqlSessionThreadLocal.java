package com.glitter.demo.context;


import org.apache.ibatis.session.SqlSession;

public class SqlSessionThreadLocal {

	public static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

	/**
	 * 设置sqlSession
	 * @param sqlSession
	 */
	public static void setSqlSession(SqlSession sqlSession){
		threadLocal.set(sqlSession);
	}

	/**
	 * 删除sqlSession
	 */
	public static void removeSqlSession(){
		threadLocal.remove();
	}

	/**
	 * 获取sqlSession
	 */
	public static SqlSession getSqlSession(){
		return threadLocal.get();
	}
	
}

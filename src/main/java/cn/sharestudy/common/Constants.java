package cn.sharestudy.common;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	/**
	 * 数据有效否
	 */
	public final static int estate_y = 1 ; // 有效
	public final static int estate_n = 2 ; // 无效
	/**
	 * 数据是否显示
	 */
	public final static int eshow_y = 1 ; // 是
	public final static int eshow_n = 2 ; // 否
	
	// session
	public final static String sessionKey = "key" ; // key
	
	// type 
	public final static int type_books = 1 ;
	public final static int type_chapter = 2 ;
	public final static int type_blog = 3 ;
	
	
	/**
	 * 书籍名称和id的对应
	 */
	public static Map<String, Integer> booksMap = new HashMap<String, Integer>() ;
	static {
		booksMap.put("java", 1) ;
		booksMap.put("linux", 2) ;
		booksMap.put("db", 3) ;
		booksMap.put("spring", 4) ;
		booksMap.put("mybatis", 5) ;
		booksMap.put("pattern", 6) ;
	}
	
	/**
	 * properties 常量
	 */
	public static final String local_url_key = "local_url" ;
	public static final String www_url_key = "www_url" ;
}

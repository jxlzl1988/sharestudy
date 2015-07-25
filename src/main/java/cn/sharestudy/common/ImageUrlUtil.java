package cn.sharestudy.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageUrlUtil {

	/**
	 * 本地路径
	 */
//	public static final String local_url = "D:/sharestudy/image/";
//	public static final String www_url = "/data/projects/statics/sharestudy/image/";
	/**
	 * 替换前缀的占位符
	 */
	public static final String base_replace_url = "baseurl/" ;
	// 本地环境的访问url
//	public static final String base_local_url = "http://127.0.0.1/sharestudy/image/" ;
	// 线上访问的url
//	public static final String base_www_url = "http://115.28.230.32/image/" ;
	
	public static String getBooksImageDir(String booksId) {
		
		return "books/" + booksId + "/" ;
	}
	
	public static String getArticleImageDir() {
		
		return "article/" ;
	}
	
	public static String getChapterImageDir(String booksId, String chapterId) {
		
		return "chapter/" + booksId + "/" + chapterId + "/" ;
	}
	
	public static String getBlogImageDir(String blogId) {
		
		return "blog/" + blogId + "/" ;
	}
	
	public static String getImageTag(String imageUrl) {
		
		return "<p><image src='" + base_replace_url + imageUrl + "'></image></p>" ;
	}
	
	private static long oldImageId = 0 ;
	
	public static synchronized long getImageid() {
		
		Date now = new Date() ;
		DateFormat format = new SimpleDateFormat("yyMMddhhmmssS");
		String s = format.format(now) ;
		if(s.length() == 13) {
			s = s.substring(0, 12) + "00" + s.substring(12,13) ;
		} else if(s.length() == 14) {
			s = s.substring(0,12) + "0" + s.substring(12,14) ;
		}
		
		long id = Long.parseLong(s) ;
		if(id == oldImageId) {
			return getImageid() ;
		} else {
			oldImageId = id ;
			return id ;
		}
	}

}

package cn.sharestudy.dbcache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sharestudy.mapper.ArticleMapper;
import cn.sharestudy.mapper.po.Article;
import cn.sharestudy.mapper.po.Category;
import cn.sharestudy.service.vo.ArticleVo;

@Service
public class ArticleCacheService {

	@Resource
	private CategoryCacheService categoryCacheService ;
	@Resource
	private ArticleMapper articleMapper ;
	
	private Map<Integer, Article> articleMap = new HashMap<Integer, Article>() ;
	private Map<Integer, List<ArticleVo>> articleListMap = new HashMap<Integer, List<ArticleVo>>();
	
	@PostConstruct
	public void init() {
		List<Category> categoryList = categoryCacheService.selectAll() ;
		for(Category c : categoryList) {
			init0(c.getId());
		}
	}
	
	private void init0(int categoryId) {
		List<Article> articles = articleMapper.selectByCategoryId(categoryId) ;
		List<ArticleVo> articleVos = new ArrayList<ArticleVo>() ;
		for(Article a : articles) {
			articleMap.put(a.getId(), a) ;
			articleVos.add(new ArticleVo(a)) ;
		}
		Collections.sort(articleVos);
		articleListMap.put(categoryId, articleVos) ;
	}
	
	public boolean add(Article article) {
		
		int flag = articleMapper.insert(article) ;
		if(flag == 1) {
			articleMap.put(article.getId(), article) ;
			articleListMap.get(article.getCategoryid()).add(new ArticleVo(article)) ;
			return true ;
		} else {
			return false ;
		}
	}
	
	public boolean update(Article article) {

		int flag = articleMapper.update(article) ;
		if(flag == 1) {
			articleMap.put(article.getId(), article) ;
			articleListMap.remove(article.getCategoryid()) ;
			return true ; 
		} else {
			return false ;
		}
	}
	
	public Article getById(int id) {
		
		if(articleMap.containsKey(id)) {
			return articleMap.get(id) ;
		} else {
			Article article = articleMapper.selectById(id) ;
			if(article == null) {
				return null ;
			} else {
				articleMap.put(article.getId(), article) ;
				articleListMap.remove(article.getCategoryid()) ;
				return article ;
			}
		}
	}
	
	public List<ArticleVo> getByCategoryId(int categoryId) {
		
		if(!articleListMap.containsKey(categoryId)) {
			init0(categoryId); 
		} 
		return articleListMap.get(categoryId) ;
	}
	
	
}

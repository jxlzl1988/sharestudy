package cn.sharestudy.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sharestudy.common.Constants;
import cn.sharestudy.dbcache.ArticleCacheService;
import cn.sharestudy.mapper.po.Article;
import cn.sharestudy.service.vo.ArticleVo;

@Service
public class ArticleService extends BaseService {

	
	@Resource
	private ArticleCacheService articleCacheService ;
	
	public boolean add(int categoryid, String title, int sort, int show) {
		
		Article article = new Article() ;
		article.setCategoryid(categoryid); 
		article.setTitle(title);
		article.setContent("test");
		article.setSort(sort);
		article.setReadnum(0);
		article.setDigest("");
		article.setEshow(show);
		article.setEstate(Constants.estate_y);
		article.setCreatetime(new Date());
		article.setUpdatetime(new Date());
		
		return articleCacheService.add(article) ;
	}
	
	public boolean update(int id, String content, String digest,String keywords, String bdtext, 
			String bddesc, String bdpic, String bdurl) {
		
		Article article = articleCacheService.getById(id) ;
		article.setContent(content);
		article.setDigest(digest);
		article.setKeywords(keywords); 
		article.setBdtext(bdtext);
		article.setBddesc(bddesc);
		article.setBdpic(bdpic);
		article.setBdurl(bdurl);
		article.setUpdatetime(new Date());
		
		return articleCacheService.update(article) ;
	}
	
	public boolean update(int id, String title, int sort, int eshow) {
		
		Article article = articleCacheService.getById(id) ;
		article.setTitle(title);
		article.setSort(sort);
		article.setEshow(eshow);
		article.setUpdatetime(new Date());
		
		return articleCacheService.update(article) ;
	}
	
	public Article getById(int id) {
		return articleCacheService.getById(id) ;
	}
	
	public List<ArticleVo> getByCategoryId(int categoryId) {
		return articleCacheService.getByCategoryId(categoryId) ;
	}
	
}

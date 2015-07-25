package cn.sharestudy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sharestudy.dbcache.CategoryCacheService;
import cn.sharestudy.mapper.po.Category;

@Service
public class CategoryService extends BaseService {
	
	@Autowired
	private CategoryCacheService categoryCacheService ;

	public boolean add(String title, int sort) {
		Category category = new Category() ;
		category.setTitle(title);
		category.setSort(sort);
		category.setArticlecount(0);
		category.setCreatetime(new Date());
		category.setUpdatetime(new Date());
		
		return categoryCacheService.add(category) ;
	}
	
	public boolean udpate(int id, String title, int sort) {
		
		Category category = categoryCacheService.selectById(id) ;
		category.setTitle(title); 
		category.setSort(sort);
		category.setUpdatetime(new Date());
		return categoryCacheService.update(category) ;
	}
	
	public boolean addArticleCount(int id) {
		
		Category category = categoryCacheService.selectById(id) ;
		category.setArticlecount(category.getArticlecount() + 1);
		category.setUpdatetime(new Date());
		return categoryCacheService.update(category) ;
	}
	
	public Category selectById(int id) {
		return categoryCacheService.selectById(id) ;
	}
	
	public List<Category> selectAll() {
		return categoryCacheService.selectAll() ;
	}
	
}

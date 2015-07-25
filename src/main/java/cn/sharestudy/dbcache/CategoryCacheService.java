package cn.sharestudy.dbcache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sharestudy.mapper.CategoryMapper;
import cn.sharestudy.mapper.po.Category;

@Service
public class CategoryCacheService {

	@Resource
	private CategoryMapper categoryMapper ;
	
	private Map<Integer, Category> categoryMap = new HashMap<Integer, Category>() ;
	private List<Category> categoryList = new ArrayList<Category>() ;
	
	@PostConstruct
	public void init() {
		categoryList = categoryMapper.selectAll() ;
		for(Category c : categoryList) {
			categoryMap.put(c.getId(), c) ;
		}
	}
	
	public boolean add(Category category) {
		
		int flag = categoryMapper.insert(category) ;
		if(flag == 1) {
			categoryList.add(category) ;
			categoryMap.put(category.getId(), category) ;
			return true ;
		} else {
			return false ;
		}
	}
	
	public boolean update(Category category) {

		int flag = categoryMapper.update(category) ;
		if(flag == 1) {
			categoryList.clear(); 
			categoryMap.put(category.getId(), category); 
			return true ; 
		} else {
			return false ;
		}
	}
	
	public Category selectById(int id) {
		
		if(categoryMap.containsKey(id)) {
			return categoryMap.get(id) ;
		} else {
			Category category = categoryMapper.selectById(id) ;
			if(category == null) {
				return null ;
			} else {
				categoryList.clear(); 
				return category ;
			}
		}
	}
	
	public List<Category> selectAll() {
		
		if(categoryList.size() == 0) {
			init(); 
		} 
		Collections.sort(categoryList);
		return categoryList ;
	}
	
	
}

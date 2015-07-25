package cn.sharestudy.action.mis;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sharestudy.mapper.po.Category;
import cn.sharestudy.service.ArticleService;
import cn.sharestudy.service.CategoryService;

/**
 * category mis action
 *
 */
@Controller
@RequestMapping("/mis")
public class MisCategoryAction {
	
	@Resource
	private CategoryService categoryService ;

	/**
	 * 列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/categorys.html")
	public ModelAndView categorys(HttpServletRequest request) {
		
		List<Category> categories = categoryService.selectAll() ;
		ModelAndView mv = new ModelAndView() ;
		mv.addObject("categories", categories) ;
		mv.setViewName("mis/category.ftl");
		return mv ;
	}
	
	/**
	 * 类目详细
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/category.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public String category(HttpServletRequest request) {
		
		int categoryId = ServletRequestUtils.getIntParameter(request, "categoryId", 0) ;
		Category category = categoryService.selectById(categoryId) ;
		if(category == null) 
			return "" ;
		else {
			return new JSONObject(category).toString() ;
		}
	}
	
	/**
	 * 添加类目
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/add_category.do")
	@ResponseBody
	public int addCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = ServletRequestUtils.getStringParameter(request, "title", "" ) ;
		int sort = ServletRequestUtils.getIntParameter(request, "sort", 1) ;
		
		categoryService.add(title, sort) ;
		
		return 1 ;
	}
	
	
	/**
	 * 修改类目
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/update_category.do")
	@ResponseBody
	public int updateCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int id = ServletRequestUtils.getIntParameter(request, "id", 0) ;
		String title = ServletRequestUtils.getStringParameter(request, "title", "" ) ;
		int sort = ServletRequestUtils.getIntParameter(request, "sort", 1) ;
		
		categoryService.udpate(id, title, sort) ;
		
		return 1 ;
	}
	
}

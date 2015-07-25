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

import cn.sharestudy.mapper.po.Article;
import cn.sharestudy.mapper.po.Category;
import cn.sharestudy.service.ArticleService;
import cn.sharestudy.service.CategoryService;
import cn.sharestudy.service.ImagesService;
import cn.sharestudy.service.vo.ArticleVo;
import cn.sharestudy.service.vo.ImageVo;

/**
 * books mis action
 *
 */
@Controller
@RequestMapping("/mis")
public class MisArticleAction {
	
	@Resource
	private ArticleService articleService ;
	@Resource
	private CategoryService categoryService ;
	@Resource
	private ImagesService imagesService ;

	/**
	 * 文章列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/article.html")
	public ModelAndView article(HttpServletRequest request) {
		
		int categoryId = ServletRequestUtils.getIntParameter(request, "categoryId", 0) ;
		List<ArticleVo> articles = articleService.getByCategoryId(categoryId) ;
		Category category = categoryService.selectById(categoryId) ;
		
		ModelAndView mv = new ModelAndView() ;
		mv.addObject("articles", articles) ;
		mv.addObject("category", category) ;
		mv.setViewName("mis/article.ftl");
		return mv ;
	}
	
	/**
	 * 添加文章
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/add_article.do")
	@ResponseBody
	public int addArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int categoryid = ServletRequestUtils.getIntParameter(request, "categoryid", 0) ;
		String title = ServletRequestUtils.getStringParameter(request, "title", "") ;
		int sort = ServletRequestUtils.getIntParameter(request, "sort", 0) ;
		int show = ServletRequestUtils.getIntParameter(request, "show", 2) ;
		
		boolean flag = articleService.add(categoryid, title, sort, show) ;
		if(flag) {
			categoryService.addArticleCount(categoryid) ;
			return 1 ;
		} else 
			return 0 ;
	}
	
	/**
	 * 修改文章 
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/update_article.do")
	@ResponseBody
	public int updateArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int id = ServletRequestUtils.getIntParameter(request, "id", 0) ;
		String title = ServletRequestUtils.getStringParameter(request, "title", "") ;
		int sort = ServletRequestUtils.getIntParameter(request, "sort", 0) ;
		int show = ServletRequestUtils.getIntParameter(request, "show", 2) ;
		
		boolean flag = articleService.update(id, title, sort, show) ;
		if(flag) {
			return 1 ;
		} else 
			return 0 ;
	}
	
	/**
	 * 获取文章 
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/get_article.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int id = ServletRequestUtils.getIntParameter(request, "id", 0) ;
		Article article = articleService.getById(id) ;
		if(article == null) {
			return "" ;
		} else {
			return new JSONObject(article).toString() ;
		}
	}
	

	
	/**
	 * 文章详细
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/article_detail.html")
	public ModelAndView articleDetail(HttpServletRequest request) {
		
		int articleId = ServletRequestUtils.getIntParameter(request, "articleId", 0) ;
		Article article = articleService.getById(articleId) ;
		
		ModelAndView mv = new ModelAndView() ;
		mv.addObject("article", article) ;
		
		List<ImageVo> images = imagesService.selectImages(article.getId()) ;
		mv.addObject("images", images) ;
		
		mv.setViewName("mis/articledetail.ftl");
		return mv ;
	}
	
	/**
	 * 保存文章
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/save_article.do")
	@ResponseBody
	public int saveArticleDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String content = ServletRequestUtils.getStringParameter(request, "descri", "") ;
		String digest = ServletRequestUtils.getStringParameter(request, "digest", "") ;
		String keywords = ServletRequestUtils.getStringParameter(request, "keywords", "") ;
		int id = ServletRequestUtils.getIntParameter(request, "id", 0) ;
		String bdtext = ServletRequestUtils.getStringParameter(request, "bdtext", "") ;
		String bddesc = ServletRequestUtils.getStringParameter(request, "bddesc", "") ;
		String bdpic = ServletRequestUtils.getStringParameter(request, "bdpic", "") ;
		String bdurl = ServletRequestUtils.getStringParameter(request, "bdurl", "") ;

		articleService.update(id,  content, digest,keywords, bdtext, bddesc, bdpic, bdurl) ;
		return 1 ;
	}
}

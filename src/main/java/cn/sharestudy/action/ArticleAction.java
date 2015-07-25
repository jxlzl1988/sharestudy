package cn.sharestudy.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.sharestudy.common.Constants;
import cn.sharestudy.common.ImageUrlUtil;
import cn.sharestudy.mapper.po.Article;
import cn.sharestudy.service.ArticleService;
import cn.sharestudy.service.PropertiesService;
import cn.sharestudy.service.vo.ArticleVo;

@Controller
public class ArticleAction {
	
	@Resource
	private ArticleService articleService ;
	@Resource
	private PropertiesService propertiesService ;

	@RequestMapping("/{type}-{id}.html")
	public ModelAndView mybatis(HttpServletRequest request,@PathVariable("type") String type,@PathVariable("id") int id) {
		
		ModelAndView mv = new ModelAndView() ;
		Article article = null ;
		if(type.equals("category")) {
			List<ArticleVo> articles = articleService.getByCategoryId(id) ;
			article = articleService.getById(getOne(articles).getId()) ;
			mv.addObject("acs", articles) ;
		} else {
			article = articleService.getById(id) ;
			List<ArticleVo> articles = articleService.getByCategoryId(article.getCategoryid()) ;
			mv.addObject("acs", articles) ;
		}
		String wwwUrl = propertiesService.getValue(Constants.www_url_key) ;
		article.setContent(article.getContent().replaceAll(ImageUrlUtil.base_replace_url, wwwUrl));
		if(article.getBdpic() != null) {
			article.setBdpic(article.getBdpic().replace(ImageUrlUtil.base_replace_url, wwwUrl));
		}
		article.setBdurl(getUrl(request));
		mv.addObject("ac", article) ;
		
		mv.setViewName("article.ftl");
		return mv ;
	}
	
	private ArticleVo getOne(List<ArticleVo> list) {
		for(ArticleVo a : list) {
			if(a.getEshow() == Constants.eshow_y) {
				return a ;
			}
		}
		return list.get(0) ;
	}
	
	private String getUrl(HttpServletRequest request) {
		String string =  "http://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI() ; 
		return string ;
	}
}

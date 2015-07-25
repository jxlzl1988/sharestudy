package cn.sharestudy.action.mis;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sharestudy.common.Constants;
import cn.sharestudy.mapper.po.User;
import cn.sharestudy.service.UserService;

/**
 * login mis action
 *
 */
@Controller
@RequestMapping("/mis")
public class MisLoginAction {
	
	@Autowired
	private UserService userService ;

    private static int loginNum = 0 ;
	
	/**
	 * login
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/login.html")
	public ModelAndView login(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("mis/login.ftl");
		return mv ;
	}
	
	/**
	 * login
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login.do", method=RequestMethod.POST,produces="application/json;utf-8")
	@ResponseBody
	public String loginDo(HttpServletRequest request) {
		
		String username = ServletRequestUtils.getStringParameter(request, "username", "") ;
		String password = ServletRequestUtils.getStringParameter(request, "password", "") ;
		
		User user = userService.getByUsername(username) ;
        loginNum ++ ;
        if(user != null && user.getPassword().equals(password) && loginNum < 5) {
			request.getSession().setAttribute(Constants.sessionKey, user);
			return "1" ;
		} else 
			return "0" ;
	}
}

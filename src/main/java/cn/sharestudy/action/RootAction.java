package cn.sharestudy.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootAction {
	
	@RequestMapping("/")
	public void root(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		index(request, response) ;
	}

	@RequestMapping("/index")
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/category-15.html");  
        rd.forward(request, response);  
	}

	@RequestMapping("/index.html")
	public void indexHtml(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		index(request, response);
	}

//    @RequestMapping(value={"/index","/","/index.html"})
//    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher rd = request.getRequestDispatcher("/category-15.html");
//        rd.forward(request, response);
//    }
}

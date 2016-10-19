package au.edu.sydney.seg.jsiento.server.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.edu.sydney.seg.jsiento.server.model.EntityDoc;
import au.edu.sydney.seg.jsiento.server.model.EntityUsers;
import au.edu.sydney.seg.jsiento.server.service.DocFeatureManager;
import au.edu.sydney.seg.jsiento.server.service.UserFeatureManager;

@Controller
public class DocController {
	@Resource(name="DocFeaturesManager")
	private DocFeatureManager docFeaturesManager;
	
	@Resource(name="UserFeaturesManager")
	private UserFeatureManager userFeatureManager;
	
	@RequestMapping(value = "doclogin", method = RequestMethod.POST)
	public String userLogin(HttpServletRequest request, HttpServletResponse response){
		String role = request.getParameter("loginrole");
		if(role.equals("User")){
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			userFeatureManager.loginToTheSys(name, pwd);
			EntityUsers user = userFeatureManager.queryUserByName(name);
			request.getSession().setAttribute("biouser",user);
			request.getSession().setAttribute("userid",user.getId());
			return "redirect:/user_userslist";
		}else{
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			docFeaturesManager.loginToTheSys(name, pwd);
			EntityDoc doc = docFeaturesManager.queryDocByName(name);
			request.getSession().setAttribute("biodoc",doc);
			
			return "redirect:/userslist";
		}
		
	}
	
	@RequestMapping(value = "fit_page", method = RequestMethod.GET)
	public String fitChange(HttpServletRequest request, HttpServletResponse response){
		return "fit";
	}
	
	@RequestMapping(value = "life_page", method = RequestMethod.GET)
	public String lifeChange(HttpServletRequest request, HttpServletResponse response){
		return "lifestyle";
	}
	@RequestMapping(value = "calendar_page", method = RequestMethod.GET)
	public String calendarChange(HttpServletRequest request, HttpServletResponse response){
		return "calendar";
}

package cn.sz.kjy.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserInter extends HandlerInterceptorAdapter{

	private static String [] arr = {
		"uc/islogin"
	};

	public boolean checkUrl(String url){
		//如果当前的请求路径包含在arr数组中，那么返回true
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals(url)){
				return true;
			}
		}
		//判断是否是资源文件，如果是返回true
		if(url!=null&&!"".equals(url)&&url.endsWith(".js")){
			return true;
		}
		return false;
	}

	/**
	 * 实际业务方法执行之前的操作,返回一个boolean值
	 * 如果返回true,表示拦截器通过拦截，继续执行我的业务方法
	 * 如果返回false,表示拦截器拦截停止，不再执行后续业务方法
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("1业务方法执行前");
		//获得session里面存储的信息
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("u");
		if (obj!=null) {
			return true;
		}else{
			//获取当前请求的名字
			String uri = request.getRequestURI();
			System.out.println("获取当前请求的名字uri:"+uri);
			//获取根目录
			String contextpath = request.getContextPath();
			System.out.println("获取根目录contextpath："+contextpath);
			String url = uri.substring(contextpath.length()+1, uri.length());
			System.out.println(url);
			if(this.checkUrl(url)){
				return true;
			}
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			//response.sendRedirect(basePath+"index.jsp");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		//权限验证
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		//System.out.println("2业务方法执行后");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
		//System.out.println("3.请求完成之后的操作");
	}
}

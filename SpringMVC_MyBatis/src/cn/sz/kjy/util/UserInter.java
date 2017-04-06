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
		//�����ǰ������·��������arr�����У���ô����true
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals(url)){
				return true;
			}
		}
		//�ж��Ƿ�����Դ�ļ�������Ƿ���true
		if(url!=null&&!"".equals(url)&&url.endsWith(".js")){
			return true;
		}
		return false;
	}

	/**
	 * ʵ��ҵ�񷽷�ִ��֮ǰ�Ĳ���,����һ��booleanֵ
	 * �������true,��ʾ������ͨ�����أ�����ִ���ҵ�ҵ�񷽷�
	 * �������false,��ʾ����������ֹͣ������ִ�к���ҵ�񷽷�
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("1ҵ�񷽷�ִ��ǰ");
		//���session����洢����Ϣ
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("u");
		if (obj!=null) {
			return true;
		}else{
			//��ȡ��ǰ���������
			String uri = request.getRequestURI();
			System.out.println("��ȡ��ǰ���������uri:"+uri);
			//��ȡ��Ŀ¼
			String contextpath = request.getContextPath();
			System.out.println("��ȡ��Ŀ¼contextpath��"+contextpath);
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
		//Ȩ����֤
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		//System.out.println("2ҵ�񷽷�ִ�к�");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
		//System.out.println("3.�������֮��Ĳ���");
	}
}

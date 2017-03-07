/*
 * Other.java
 * Copyright: TsingSoft (c) 2015
 * Company: 北京清软创新科技有限公司
 */
package first;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 其他的servlet属性
 * @author LT
 * @version 1.0, 2015年9月11日
 */
public class OtherServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public OtherServlet() {
		System.out.println("配置了<load-on-startup>调用otherServlet构造函数");
	}
	/**
	 * 生命周期：
	 * 1.servlet容器创建一个servlet对象：一、请求到达时（存在就直接调用） 二、容器启动时根据配置文件中有web.xml的<servlet>的<load-on-startup>的进行创建（最小值为0，按小到大进行创建）
	 * 2.容器会调用init方法，可调用init-param,之后也可以
	 * 3.容器会调用父类HttpServlet的service方法，若覆盖则调用实现的service方法，否则会按照调用类型调用自己重写的get或post方法
	 * 4.容器销毁此servlet实例，调用destory方法，自己的逻辑可用于释放资源
	 * 5.一个周期会调用一次init和destory，多次service
	 */
	/**
	 * 无参的init()方法进行覆盖的话，不会出现初始化参数不能调用的问题
	 * 一般使用此覆盖方法
	 */
	@Override
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		System.out.println("init()初始化参数："+config.getInitParameter("param"));
	}
	/**
	 * 若覆盖此方法必须调用super
	 * 否则意味着没有调用父类的init方法,则本方法的config可以用，但是之后所有的方法无法调用ServletConfig
	 * 原理是，父类HttpServlet的getServletConfig是取公共变量，而super.init的作用就是给它赋值
	 */
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		System.out.println("init(config)不能去掉super否则不能调用初始化参数:"+config.getInitParameter("param"));
//	}
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("销毁");
	}
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
//			throws ServletException, IOException {
//		System.out.println("service");
//	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		super.doGet(request, response); 
		ServletConfig config = getServletConfig();
		System.out.println("doGet()-super调用方法必须去掉否则报错-重定向-初始化参数："+config.getInitParameter("param2"));
		// 重定向
		response.sendRedirect("index.html");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()-super去掉");
		doGet(request, response);
	}
}

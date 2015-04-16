package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18905")
public class BenchmarkTest18905 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		response.addHeader(bar, "SomeValue");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map36023 = new java.util.HashMap<String,Object>();
		map36023.put("keyA-36023", "a_Value"); // put some stuff in the collection
		map36023.put("keyB-36023", param.toString()); // put it in a collection
		map36023.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map36023.get("keyB-36023"); // get it back out
		bar = (String)map36023.get("keyA-36023"); // get safe value back out
	
		return bar;	
	}
}
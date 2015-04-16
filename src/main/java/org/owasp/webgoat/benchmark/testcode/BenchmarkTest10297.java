package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10297")
public class BenchmarkTest10297 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			java.sql.ResultSet rs = statement.executeQuery( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a43703 = param; //assign
		StringBuilder b43703 = new StringBuilder(a43703);  // stick in stringbuilder
		b43703.append(" SafeStuff"); // append some safe content
		b43703.replace(b43703.length()-"Chars".length(),b43703.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43703 = new java.util.HashMap<String,Object>();
		map43703.put("key43703", b43703.toString()); // put in a collection
		String c43703 = (String)map43703.get("key43703"); // get it back out
		String d43703 = c43703.substring(0,c43703.length()-1); // extract most of it
		String e43703 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43703.getBytes() ) )); // B64 encode and decode it
		String f43703 = e43703.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g43703 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g43703); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
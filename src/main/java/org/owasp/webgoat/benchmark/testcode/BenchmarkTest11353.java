package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11353")
public class BenchmarkTest11353 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo");
        
		String[] argsEnv = { bar };
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd, argsEnv);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a82754 = param; //assign
		StringBuilder b82754 = new StringBuilder(a82754);  // stick in stringbuilder
		b82754.append(" SafeStuff"); // append some safe content
		b82754.replace(b82754.length()-"Chars".length(),b82754.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82754 = new java.util.HashMap<String,Object>();
		map82754.put("key82754", b82754.toString()); // put in a collection
		String c82754 = (String)map82754.get("key82754"); // get it back out
		String d82754 = c82754.substring(0,c82754.length()-1); // extract most of it
		String e82754 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82754.getBytes() ) )); // B64 encode and decode it
		String f82754 = e82754.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g82754 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g82754); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
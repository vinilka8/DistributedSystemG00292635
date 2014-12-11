package ie.gmit;

import java.io.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import javax.servlet.*;
import javax.servlet.http.*;


public class FibServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    FibService fservice;
    
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		System.out.println("This is initilization");
		fservice = new FibService();
		try {
			RemoteFibonacci remote=new Fibonacci(1099);
			LocateRegistry.createRegistry(1099);
				Naming.rebind("remote", remote);
				System.out.println("naming rebind");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		
				//getting parameter from client side, from HomePage.jsp & asign to "value"
				String value = request.getParameter("lengNum");
				//adding the "value" of fib lenght number in to the method "add" in FibService and asign to "number"
				int number = fservice.add(Integer.valueOf(value)); 
				
				String type=request.getParameter("req-leng");
				
				if(type.equals("add")){
					System.out.println("going to add sth");
					request.setAttribute("jobNumber", number);
			        System.out.println("going to jum! ");
			        try {
						RemoteFibonacci fibonacci=(RemoteFibonacci)Naming.lookup("rmi://localhost:1099/remote");
						
						String fibRes=String.valueOf(fibonacci.getFibonacciSequence(Integer.valueOf(value)));
						fservice.add(number,fibRes);
						request.setAttribute("fibres", fibRes);
					} catch (NotBoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        //request.getRequestDispatcher("Request_Page.jsp").forward(request, response);
			        //
			         request.getRequestDispatcher("Request_Page.jsp").forward(request, response);;
//			        if(dispat != null){
//			        	dispat.forward(request, response);
//			        }
			        System.out.println("done");
					
				}
				//asign a "number" by using setAttribute that has been in random method in service => 
				//to => 
				//"JobNumber" , example our "JobNumber" has a random number, start from point 10000000
			
		        
		    


        }
		
	

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//int pollNumber = 0;
			super.doGet(request, response);
			//String[] pollNumber = request.getParameterValues("arr");
			//String fibNumbers = fservice.getResult(pollNumber);
			//request.setAttribute("fibNumbers", fibNumbers);
	}

	public void destroy() {
		super.destroy(); 
		System.out.println("This is destroy");
	}
}

package ie.gmit;

import java.io.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;

import javax.servlet.*;
import javax.servlet.http.*;


public class FibServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    FibService fservice;    //servlet getting a usage of service tools "utility" 
    
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Init method, works just once, when the server is tartup
		//it is initializing the port number for remote object
		//creating regestry to use RMI
		//use a binding
		System.out.println("This is initilization");//chaking while it here, print it out
		fservice = new FibService();
		try {
			RemoteFibonacci remote=new Fibonacci(1099);
			LocateRegistry.createRegistry(1099);
				Naming.rebind("remote", remote);
				System.out.println("naming rebind");//chaking while it here, print it out
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//end of initialization the current port number with remote object 
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
				String type = request.getParameter("req-leng");//registrate a number from client side in to String type
				
				if(type.equals("add")){ //and assign the key value "type " equalent to add value key, if it has been done do next steps
					String value = request.getParameter("lengNum");//getting parameter from client side, from HomePage.jsp & asign to "value"
					int number = fservice.add(Integer.valueOf(value)); 	//adding the "value" of fib lenght number in to the method "add" in FibService and asign to "number"
					//asign a "number" by using setAttribute that has been in random method in service => 
					//to => 
					//"JobNumber" , example our "JobNumber" has a random number, start from point 10000000
					System.out.println("going to add sth");//chaking while it here, print it out
					request.setAttribute("jobNumber", number); //setting attribute of priviouse number as a Jobnumber 
			        System.out.println("going to jum! ");//chaking while it here, print it out
			        try {
						RemoteFibonacci fibonacci = (RemoteFibonacci)Naming.lookup("rmi://localhost:1099/remote");//look for fibonacci numbers in Remote object by the port number
						
						String fibRes = String.valueOf(fibonacci.getFibonacciSequence(Integer.valueOf(value)));
						fservice.add(number,fibRes);
						//request.setAttribute("jobNum", number);
					} catch (NotBoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        
			        System.out.println("Hi there");//chaking while it here, print it out
			         request.getRequestDispatcher("Request_Page.jsp").forward(request, response);;
//			        if(dispat != null){
//			        	dispat.forward(request, response);
//			        }
			        System.out.println("done");//chaking while it here, print it out
					
				}else if (type.equals("poll")){ //else if registered type from first page are equal to poll method in Request page 
					System.out.println("this is poll");//chaking while it here, print it out
					String rType = fservice.getResult(Integer.valueOf(request.getParameter("jobNum"))); // asign rType to result method in service class into jobNum
					//so my job number at this stage should have fibonacci numbers 
					System.out.println(rType); //print out my fibonacci numbers
					
					if(rType != null){ // if my fibonacci numbers are ready for poll && they are not equal to null
						//request.setAttribute("fib",rType);
						response.sendRedirect("Result_Page.jsp?fib="+rType); //Please send them to the Result page where my fib is equal to fibonacci
					}else{
						System.out.println("here you go");
						response.sendRedirect("Request_Page.jsp"); //otherwise just stay at request page 

					}
					
				}
				
		    


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
			super.doGet(request, response);
	}

	public void destroy() {
		super.destroy(); 
		System.out.println("This is destroy");//destroy my initialization from Init when my server is stops
	}
}

package ie.gmit;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Fibonacci extends UnicastRemoteObject implements RemoteFibonacci{
	private static final long serialVersionUID = 1L;
	//private FibRequest fibRequest;
	StringBuffer str=new StringBuffer();
	//int lenght = new Scanner(System.in).nextInt();
	
	
	protected Fibonacci(int port) throws RemoteException {
		super(port);
	}
//	public static void main(String[] args)
//  {
//		System.out.print("Lenght of num : ");
//		int lenght = new Scanner(System.in).nextInt();
//	
//	    System.out.println("\nFibonacci series upto " + lenght +" numbers : ");
//	    for(int i=1; i<=lenght; i++){
//	        System.out.print(fibonacciLoop(i) +" ");
//  	}
//  }

	public String getFibonacciSequence(int max) throws RemoteException{
	
        for(int i= 0; i<= max; i++){  
	        str.append(fibonacciRecusion(i)+",");
         
            }
   return new String(str);
    } 
	
	public static int fibonacciRecusion(int i){
		if(i==0){
			return 0;
		}else if(i==1){
			return 1;
		}
		return fibonacciRecusion(i-1)+fibonacciRecusion(i-2);
	}
}
	
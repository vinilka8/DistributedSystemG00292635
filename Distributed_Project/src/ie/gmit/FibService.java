package ie.gmit;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class FibService implements RemoteFibonacci{
	//private String remoteHost = null;
	//private FibService fS = null;	
	private Map<Integer, String> out_queues = new HashMap<Integer, String>();
	private LinkedList<FibRequest> in_queue = new LinkedList<FibRequest>();
	
	//********************************************************************************
	// you should put get result method in fibService
	//********************************************************************************
	//Job STAFF
	//In-Queue
	//in-queqe method for generate a rundom number for job number 
	public int add(int lengNum){
		int random = new Random().nextInt(1000000000);
		in_queue.addLast(new FibRequest(random, lengNum));
		return random;
	}
	
	//********************************************************************************
	// you should put get result method in fibService
	//********************************************************************************
	//Job STAFF
	//Out-Queue
	public String getResult(int jobNumber){
		if(out_queues.containsKey(jobNumber)){
			String result = out_queues.get(jobNumber);
			out_queues.remove(jobNumber);
			return result;
		}else{
			return null;
		}
	}
	//********************************************************************************

   public void add(int jobNum, String fibonacci){
	   out_queues.put(jobNum, fibonacci); //add method for out queues
   }

	@Override
	public String getFibonacciSequence(int max) throws RemoteException {
		// TODO Auto-generated method stub
		return out_queues.get(max);
	}
//  
//	public boolean hasFib(int jobNum){
//		if(out_queues.get(key))
//	}
}

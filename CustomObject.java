import java.util.*;
import java.lang.*;
import java.lang.Thread;
import java.util.concurrent.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CustomObject{
	long Timestamp;
	public CustomObject(int sec){
	Lock l=new ReentrantLock();
	        try{
			l.lock();
			this.Timestamp=System.currentTimeMillis() + 1000*sec;
		}
		finally{
			l.unlock();
		}
	
	}
	public static void set(){
	try{
	Thread.sleep(10000);
			}
			catch(Exception e){
			}
			
	Iterator<CustomObject> itr=q.iterator();
	while(itr.hasNext()){
		      boolean t=true;
		      while(t){
                              CustomObject entry=itr.next();
                               if (System.currentTimeMillis()>= entry.Timestamp){
                                System.out.println(entry.Timestamp);
                                itr.remove();
                                t=false;          
		      }
		      System.out.println(q);
		      }
        }}
	public static List<CustomObject> q=new ArrayList<>();
	public static void main(String args[]){
		 /*ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);

		 executor.submit(() -> */Runnable run = new Runnable(){
		 public void run(){
		      Random random = new Random();
		      for (int i=0;i<10;i++){
			      int x=random.nextInt(10);
			      q.add(i,new CustomObject(x));
		      }
        	      for(int i=0;i<10;i++){
		               System.out.println(q.get(i));
		      }
		      System.out.println(q);
		      CustomObject.set();
		     
                      try{  
                                boolean x=true;
                                while(x){
			                 boolean b=q.isEmpty();
			                  if(b==true){
				                  x=false;
				                   break;
			                      }
				}
	            	      System.out.println(Thread.currentThread().getName()+" expired");	
                   	}
		      catch(Exception e){}
	
                 }};
                 Thread t=new Thread(run);
		  t.start();
                  
		 /*executor.shutdown();*/
			
	}
}

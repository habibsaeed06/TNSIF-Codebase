package com.tnsif.daytwelve.multithreading;

public class ThreadMethodDemo {
	
	
	public static void main(String[] args) {
		
		
		ChildThread t1=new ChildThread(5, "First");
		ChildThread t2=new ChildThread(10, "Second");
		
		
		t1.start();
		t2.start();
		
		Thread.currentThread().setName("Parent thread");       // assigning name to the main thread
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		System.out.println("Curremt Thread "+ Thread.currentThread());
		
		
		try {
			t1.join(); // wait current thread until t1 is dead
			
			t2.join(); // wait current thread until t2 is dead
		}
		catch (InterruptedException e)
		{
			Thread.currentThread().interrupt(); //Restore Int
			System.err.println("Thread Interrupt: "+e.getMessage());
		}
		System.out.println("--------------End of the Program-------------");

	}
	

}

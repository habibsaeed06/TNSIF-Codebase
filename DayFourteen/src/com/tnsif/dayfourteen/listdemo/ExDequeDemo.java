package com.tnsif.dayfourteen.listdemo;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExDequeDemo {

	public static void main(String[] args) {
	
		Deque<String> deque1=new ArrayDeque<String>();
		deque1.add("Saeed");
		deque1.add("Mukebil");
		deque1.add("Habib");
		deque1.add("Sam");
		
		System.out.println(deque1);
		
		deque1.pollLast();
		System.out.println(deque1);
		
		deque1.pollFirst();
		System.out.println(deque1);
		
		for(String str : deque1)
		{
			System.out.println("queue is :"+ str);
		}
		
		System.out.println(deque1);
		

	}

}
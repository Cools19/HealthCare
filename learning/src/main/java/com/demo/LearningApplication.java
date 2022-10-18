package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
		
		
	//arrayList
		List<Integer> list = new ArrayList<Integer>();
	list.add(1);
	list.add(2);
	System.out.println("ArrayList : "  + list.toString());
		
		
	//Double Brace Initilization Arralist
	
	List<Integer> t= new ArrayList<Integer>() { {
		add(3);
		add(4);
	} };
		System.out.println("ArrayList in Double Brace :" + t.toString() );
		
		//creating mutable list
		List<Integer> lt= new ArrayList<>(
				Arrays.asList(5,6,7));
		System.out.println("List :" + lt.toString());
		
		lt.add(9);
		//print modified 
		System.out.println("modified :" + lt.toString());
	
	
		
		//create an empty list
		List<Integer> f=new ArrayList<Integer>();
		//instantiating list using collections addAll()
		Collections.addAll(f, 9,8,7,6);
		//print the list
		System.out.println("collection list :"+ f.toString());
		
		//creating the list in Singleton
		List<Integer>p=Collections.singletonList(4);
		
		//print the list 
		System.out.println("SingletonList : "+ p.toString());
		
		
		//Using java 8
		
		//Creating a list using Syntax1
		
		List<Integer>lt1=Stream
				.of(3,4,5)
				.collect (Collectors.toList());
		System.out.println("syntax1 :"+ lt1.toString());
		
		
		//Creating a list using syntax2
		
		List<Integer>lt2=Stream
				.of(0,9,8,7)
				.collect (Collectors.toCollection(ArrayList::new));
		System.out.println("syntax2 :"  + lt2.toString());
		
		
		
		//Creating a list using syntax2
		List<Integer>It3=Stream
				.of(4,5,6,7)
				.collect (
			     Collectors
			     .collectingAndThen(
						Collectors.toList(),
				Collections::unmodifiableList));
						
				
	System.out.println("syntax3 :"+ It3.toString());
	}
	
	
	
		
	}



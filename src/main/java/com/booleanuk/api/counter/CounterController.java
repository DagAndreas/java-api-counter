package com.booleanuk.api.counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("counter")
public class CounterController {
	public int counter;


	public CounterController(){
		counter = 0;
	}

	@GetMapping()
	public String getCounter(){
		return withDivAndLink(Integer.toString(counter));
	}

	@GetMapping("increment")
	public String increment(){
		return withDivAndLink(Integer.toString(++counter));
	}

	@GetMapping("decrement")
	public String decrement(){
		return withDivAndLink(Integer.toString(--counter));
	}

	public String withDivAndLink(String s){
		return "<div>" + s + "</div>"
			+"<div><a href=\"http://localhost:4000/counter/increment\">Increment Counter</a></div>"
			+ "<div><a href=\"http://localhost:4000/counter/decrement\">Decrement Counter</a></div>";
	}


}

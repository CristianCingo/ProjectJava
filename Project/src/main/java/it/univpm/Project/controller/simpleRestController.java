package it.univpm.Project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.Project.model.HelloWorldClass;

@RestController
public class simpleRestController {
	
@GetMapping("/hello")
public HelloWorldClass exampleMethod0(@RequestParam(name="param1",defaultValue="World") String param1) {
	System.out.println("Ciao");
	return new HelloWorldClass("Cristian","Cingolani");
	}

@PostMapping("/hello")
public HelloWorldClass exampleMethod1(@RequestBody HelloWorldClass body) {
	return body
}
@PostMapping("/hello")
public HelloWorldClass exampleMethod1(@RequestBody String body) {
return new HelloWorldClass("Christian","Ascani");
}
}

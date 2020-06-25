package com.hello.harry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HarryPotterController {
	 
	 @GetMapping(path="/")
	 public String sayHello() {
	  return "Hello!!We all love HarryPotter";
	 }
}

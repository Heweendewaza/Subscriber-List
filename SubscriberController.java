package com.tts.subscriberlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping 
@Controller
public class SubscriberController {
	
	 @Autowired
	  private SubscriberRepository subscriberRepository;
	
	 @GetMapping (value = "/")
	public String index(Subscriber subscriber) {   //Where we want to go when our application is started
		return "subscriber/index";
	}

	 
	 private Subscriber subscriber;
	 
	 @PostMapping(value = "/")
	 public String addNewSubscriber(Subscriber subscriber, Model model) {
	 	subscriberRepository.save(new Subscriber(subscriber.getFirstName(), 
	    subscriber.getLastName(), subscriber.getUserName(), subscriber.getSignedUp()));
	 	model.addAttribute("firstName", subscriber.getFirstName());
	 	model.addAttribute("lastName", subscriber.getLastName());
	 	model.addAttribute("userName", subscriber.getUserName());
	 	return "subscriber/result";
}
}  

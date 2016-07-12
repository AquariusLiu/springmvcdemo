package com.lxy.test.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.lxy.test.entity.User;

@RestController
@RequestMapping("/api/cname")
public class CNameAction {
	@RequestMapping(path="/hello", method=RequestMethod.POST)
    public String greeting() {
        return "hello";
    }
	
	@RequestMapping(path="/user", method=RequestMethod.GET)
	@JsonView(User.WithPasswordView.class)
	public User getUser() {
		return new User("liu", "liuxy123");
	}
	
	@RequestMapping(path="/username", method=RequestMethod.GET)
	@JsonView(User.WithoutPasswordView.class)
	public User getUsername() {
		return new User("liu", "liuxy123");
	}
}

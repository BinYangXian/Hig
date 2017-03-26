package com.cdsxt.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class UsersAction {

	
	public void execute(){
		System.out.println("UsersAction.execute()");
	}
}

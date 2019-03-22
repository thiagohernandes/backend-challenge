package com.invillia.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.invillia.model.User;

/*
 * Service User In Memory Authentication
 * @since 22-03-2019
 * @author: Thiago Hernandes de Souza
 * */

@Service
public class UserService {
	
	private static List<User> listUsers = 
			new ArrayList<>(Arrays.asList(new User("invillia","123"),
										  new User("teste","147")));
	
	public void addUser(User user) {
    	listUsers.add(user);
    }
    
    public List<User> allUsersList(){
    	return listUsers;
    }

}

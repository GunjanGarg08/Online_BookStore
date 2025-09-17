package com.onlineBookStore.BooksStore.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;
import com.onlineBookStore.BooksStore.Entities.User;
import com.onlineBookStore.BooksStore.repository.UserRepository;

@Service
public class UserCustomConfigService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByUserEmail(username);
            if (user == null) {
                throw new UsernameNotFoundException("Invalid username or password.");
            }
            return new UserCustomConfig(user);
        } catch (Exception e) {
            // log and rethrow a UsernameNotFoundException for Spring Security
            e.printStackTrace();
            throw new UsernameNotFoundException("User retrieval failed.");
        }
    }
}




//package com.onlineBookStore.BooksStore.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.onlineBookStore.BooksStore.Entities.User;
//import com.onlineBookStore.BooksStore.repository.UserRepository;
//
//public class UserCustomConfigService implements UserDetailsService {
//	@Autowired
//	UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//
//		try {
//			User user = userRepository.findByUserEmail(username);
//			System.out.println("User name :  " + username);
//			if (user == null) {
//				throw new UsernameNotFoundException("Invalid User name or passeord !!");
//			} else {
//
//				return new UserCustomConfig(user);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//
//		return null;
//	}
//
//}

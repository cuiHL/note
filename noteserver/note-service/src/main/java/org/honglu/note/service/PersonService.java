//package org.honglu.note.service;
//
//import org.honglu.note.mapper.PersonMapper;
//import org.honglu.note.model.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PersonService implements UserDetailsService {
//
//    @Autowired
//    PersonMapper personMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Person person = personMapper.loadUserByUsername(username);
//        if (person == null) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//        return person;
//    }
//}

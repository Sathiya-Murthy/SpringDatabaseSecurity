package com.studentdatabase.studentdatabase.Security;

import com.studentdatabase.studentdatabase.Models.Students;
import com.studentdatabase.studentdatabase.Repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class StudentDetails implements UserDetailsService {
    @Autowired
    private StudentsRepository studentsRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Students students= this.studentsRepository.findByEmail(username).orElseThrow();
        return students;
    }
}

package com.studentdatabase.studentdatabase.Repository;


import com.studentdatabase.studentdatabase.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentsRepository extends JpaRepository<Students,Integer> {
    Optional<Students> findByEmail(String email);
}

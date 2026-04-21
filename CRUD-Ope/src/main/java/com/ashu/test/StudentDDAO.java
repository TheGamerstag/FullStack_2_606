package com.ashu.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDDAO extends JpaRepository<Student, Integer> {

}

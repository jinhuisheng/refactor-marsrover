package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huisheng.jin
 * @date 2020/4/8.
 */
@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Integer> {
}

package com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.entities.Task;



public interface TaskRepository extends JpaRepository<Task, Long> {

}
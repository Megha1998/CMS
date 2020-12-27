package com.log.login.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.log.login.models.data.Page;


public interface PageRepository extends JpaRepository<Page, Integer> {
	@Override
	List<Page> findAll();
	
	Page findByslug(String slug);

}

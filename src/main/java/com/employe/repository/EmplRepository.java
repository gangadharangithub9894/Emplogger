package com.employe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employe.entity.Empl;

public interface EmplRepository extends JpaRepository<Empl, Integer> {

}

package com.politechnika.housing.repository;

import com.politechnika.housing.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository  extends JpaRepository<Manager, Integer>{

}

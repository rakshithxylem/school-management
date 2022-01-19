package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.Addess;

@Repository
public interface AddressRepository extends JpaRepository<Addess, Integer> {

}

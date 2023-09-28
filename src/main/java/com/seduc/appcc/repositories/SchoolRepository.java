package com.seduc.appcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seduc.appcc.entities.School;


@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

}

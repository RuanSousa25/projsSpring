package com.seduc.appcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seduc.appcc.entities.Crede;


@Repository
public interface CREDERepository extends JpaRepository<Crede, Long> {

}

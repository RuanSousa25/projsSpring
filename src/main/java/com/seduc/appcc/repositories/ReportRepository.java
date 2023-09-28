package com.seduc.appcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seduc.appcc.entities.Report;


@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

}

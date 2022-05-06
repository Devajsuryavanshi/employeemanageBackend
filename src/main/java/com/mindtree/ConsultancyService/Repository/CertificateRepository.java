package com.mindtree.ConsultancyService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.ConsultancyService.Entity.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Integer>{

}
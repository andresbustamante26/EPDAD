package com.bustamante.infraccionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bustamante.infraccionservice.entity.Infraccion;

public interface InfraccionRepository extends JpaRepository<Infraccion, Integer>{

}

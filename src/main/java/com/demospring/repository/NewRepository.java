package com.demospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demospring.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{//JpaRepository:tương đương với interface generic khi build bằng jdbc

}

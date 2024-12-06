package com.yutaproject.yutaapp.entities.class_entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassRepository extends JpaRepository<Class, Long> {
    Optional<Class> findByName(String name);
}

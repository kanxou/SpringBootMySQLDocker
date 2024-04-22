package com.example.springbootmysqldocker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleProductRepository extends JpaRepository<SampleProduct, Long> {
}

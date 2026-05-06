package com.prince.repository;

import com.prince.entity.Prince;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrinceRepository extends JpaRepository<Prince, Long> {
}
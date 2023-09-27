package org.example.repository;

import org.example.model.Rebelde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RebeldeRepositoy extends JpaRepository<Rebelde, Long> {
}

package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Auditorium;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {

}

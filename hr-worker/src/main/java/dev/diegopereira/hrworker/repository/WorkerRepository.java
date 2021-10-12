package dev.diegopereira.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.diegopereira.hrworker.domain.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}

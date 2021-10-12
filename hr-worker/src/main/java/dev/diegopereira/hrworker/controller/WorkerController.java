package dev.diegopereira.hrworker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.diegopereira.hrworker.domain.Worker;
import dev.diegopereira.hrworker.repository.WorkerRepository;
import dev.diegopereira.hrworker.service.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

	@Autowired
	private WorkerService workerService;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> workerList = workerService.findAll();
		return ResponseEntity.ok(workerList);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		Worker worker = workerService.findByIdOrThrowBadRequestException(id);
		return ResponseEntity.ok(worker);
	}
}
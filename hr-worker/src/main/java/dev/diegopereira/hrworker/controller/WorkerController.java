package dev.diegopereira.hrworker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.diegopereira.hrworker.domain.Worker;
import dev.diegopereira.hrworker.service.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
	
	@Autowired
	private Environment env;

	@Autowired
	private WorkerService workerService;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> workerList = workerService.findAll();
		return ResponseEntity.ok(workerList);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker worker = workerService.findByIdOrThrowBadRequestException(id);
		return ResponseEntity.ok(worker);
	}
}
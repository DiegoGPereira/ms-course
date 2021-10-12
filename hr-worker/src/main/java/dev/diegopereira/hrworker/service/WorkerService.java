package dev.diegopereira.hrworker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.diegopereira.hrworker.domain.Worker;
import dev.diegopereira.hrworker.repository.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository workerRepository;

	public List<Worker> findAll() {
		return workerRepository.findAll();
	}

	public Worker findByIdOrThrowBadRequestException(Long id) {
		return workerRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "worker not found"));
	}
}

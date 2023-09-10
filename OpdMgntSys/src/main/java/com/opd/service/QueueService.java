package com.opd.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd.dto.QueueDetails;
import com.opd.entity.Appointment;
import com.opd.entity.Queue;
import com.opd.repository.QueueRepo;

@Service
public class QueueService {

	@Autowired
	private QueueRepo queueRepo;

	public List<Queue> getAllQueue() {
		return queueRepo.findAll();
	}

	public List<QueueDetails> getQueue() {

		return queueRepo.getQueue(LocalDate.now());
	}

	public List<QueueDetails> getAllQueueDetails() {
		return queueRepo.getAllQueueDetails();
	}

	public String updateStatus(int id, String newStatus) {
		Optional<Queue> q = queueRepo.findById(id);
		if (q.isPresent()) {
			Queue queue = q.get();
			queue.setQ_status(newStatus);
			queueRepo.save(queue);
			return "Updated";
		} else
			return "Queue Not Found";
	}

}
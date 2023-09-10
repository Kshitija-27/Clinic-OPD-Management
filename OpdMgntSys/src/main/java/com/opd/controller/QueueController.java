package com.opd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opd.dto.QueueDetails;
import com.opd.entity.Queue;
import com.opd.service.QueueService;
@CrossOrigin
@RestController
@RequestMapping("/queue")
public class QueueController {

	@Autowired
	private QueueService queueService;
	
	@GetMapping("/index")
	public String index() {
		return "Success";
	}
	
	@GetMapping("/allQueue")
	public List<Queue> allQueue(){
		return queueService.getAllQueue();
	}
	
//	@GetMapping("/queueByDate")
//	public List<QueueDetails> queueDetails(){
//		return queueService.getByQueueDetails();
//	}
	
	@GetMapping("/queuedates")
	public List<QueueDetails> queueDetail(){
		return queueService.getQueue();
	}
	@GetMapping("/AllQueues")
    public List<QueueDetails> allQueueDetail() {
        return queueService.getAllQueueDetails();
    }
	
	@PutMapping("/updateStatus/{id}/{newStatus}")
	public String updateStatus(@PathVariable int id, @PathVariable String newStatus) {
		return queueService.updateStatus(id,newStatus);
	}
	
	
}

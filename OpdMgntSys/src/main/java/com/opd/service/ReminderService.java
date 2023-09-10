package com.opd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd.repository.ReminderRepo;

@Service
public class ReminderService {

	@Autowired
	private ReminderRepo reminderRepo;
}

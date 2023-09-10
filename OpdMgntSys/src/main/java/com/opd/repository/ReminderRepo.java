package com.opd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd.entity.Reminder;

@Repository
public interface ReminderRepo extends JpaRepository<Reminder, Integer> {

}

package com.yaksha.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assignment.models.Job;

@RestController
@RequestMapping("/api")
public class JobController {

	@GetMapping("/jobs")
	public List<Job> getJobs() {
		List<Job> jobs = new ArrayList<>();
		jobs.add(new Job(1, "Software Engineer", "IT", 80000));
		jobs.add(new Job(2, "Product Manager", "Business", 100000));
		return jobs; // Returns JSON response
	}
}

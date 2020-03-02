package com.sharath.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sharath.model.Pledge;

@RestController
public class HelloWorldController {
	private List<Pledge> pledges = new ArrayList<>();

	private AtomicLong nextId = new AtomicLong();
	// Pledge pledge=new Pledge();


	@PostMapping("/pledges")
	@ResponseStatus(value=HttpStatus.CREATED)
	public Pledge createNewPledge(@RequestBody Pledge pledge) {
		pledge.setId(nextId.incrementAndGet());
		pledges.add(pledge);
		return pledge;
	}

	@GetMapping("/pledgelist")
	public List<Pledge> getAllPledges() {
		return pledges;
	}

	@GetMapping("/pledge/{id}")
	public Pledge getPledge(@PathVariable("id") long pledgeId) {
		for (Pledge pledge : pledges) {
			if (pledge.getId() == pledgeId) {
				return pledge;
			}
		}
		throw new IllegalArgumentException();
	}
	

	@PutMapping("/pledges/{id}")
	public Pledge editOnePledge(@PathVariable("id") long pledgeId,
			                    @RequestBody Pledge newPledge)
	                       
	{
		for (Pledge pledge : pledges) {
			if (pledge.getId() == pledgeId) {
				pledges.remove(pledge);
				newPledge.setId(pledgeId);
				pledges.add(newPledge);
				return pledge;
			}
		}
		
		throw new IllegalArgumentException();
	}
	 // Convert a predefined exception to an HTTP Status code
	  @ResponseStatus(value=HttpStatus.BAD_REQUEST,
	                  reason="No ID found in the sharath list")  // 400
	  @ExceptionHandler(IllegalArgumentException.class)
	  public void errorCustom() {
	    // Nothing to do
	  }

	
	
	 
}

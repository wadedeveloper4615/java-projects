package com.wade.spring.examples.SpringCucumber;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/things")
public final class BagController {

	private final Bag bag = new Bag();

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addThing(@RequestBody final String something) {
		bag.add(something);
	}

	@GetMapping
	public Bag getBag() {
		return bag;
	}

	@DeleteMapping
	public void removeEverything() {
		bag.removeEverything();
	}
}

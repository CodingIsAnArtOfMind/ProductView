package com.productview.sample.productview.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productview.sample.productview.Entity.Productview;
import com.productview.sample.productview.Exception.UserNotFoundException;
import com.productview.sample.productview.Repository.ProductViewDao;

@RestController
@RefreshScope
public class ProductController {
	@Autowired
	ProductViewDao productViewDao;

	@Value("${message: Hello default}")
	private String message;

	@GetMapping("/message")
	public String getMessage() {
		return this.message;
	}

	@Value("${user.role: Default}")
	private String role;

	@GetMapping(path = "/client/{username}")
	public String helloWorld(@PathVariable("username") String username) {
		return "Hello you are " + username + " your role :- " + role;
	}

	@GetMapping("/productView")
	public ResponseEntity retrieveAllCustomer() {
		return new ResponseEntity(productViewDao.findAll(), HttpStatus.OK);
		// return new ResponseEntity(" Your role :- " + role + "\n" +
		// productViewDao.findAll(), HttpStatus.OK);
	}

	@RequestMapping("/greet")
	public String clientEureka() {
		return "Product-View";
	}

	@GetMapping("/productView/{id}")
	public ResponseEntity<List<Productview>> findOne(@PathVariable int id) {
		List<Productview> productGet = productViewDao.findById(id);
		if (productGet == null)
			throw new UserNotFoundException("id- " + id);

		return new ResponseEntity<List<Productview>>(productGet, HttpStatus.OK);

	}

	@GetMapping("/productViewAvail/{avail}")
	public List<Productview> findByAvail(@PathVariable String avail) {
		List<Productview> productGet = productViewDao.findByAvail(avail);
		if (productGet == null)
			throw new UserNotFoundException("id- " + avail);

		return productGet;

	}

	@PostMapping("/productViewAdd")
	public Boolean createUser(@Valid @RequestBody Productview newProductView) {
		int userdataSaved = productViewDao.insert(newProductView);

		return userdataSaved != 0;

	}

	@DeleteMapping("/productViewDelete/{id}")
	public ResponseEntity deleteUser(@PathVariable int id) {
		int productDelete = productViewDao.deleteById(id);

		if (productDelete == 0)
			throw new UserNotFoundException("id-" + id);
		return new ResponseEntity("Deleted id " + id, HttpStatus.OK);
	}

}

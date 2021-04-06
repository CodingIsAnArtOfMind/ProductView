package com.productview.sample.productview.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Product Not found")
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super("Product Not Found");
		// TODO Auto-generated constructor stub
	}

}

package com.productview.sample.productview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import com.productview.sample.productview.Entity.Productview;
import com.productview.sample.productview.Repository.ProductViewDao;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.productview" })
public class ProductviewApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ProductViewDao productViewDao;

	public static void main(String[] args) {
		SpringApplication.run(ProductviewApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001 -> {}", productViewDao.findById(10001));
		logger.info("User id 10004 -> {}",
				productViewDao.insert(new Productview(10005, "Suzuki", "Yes", "90000 INR", "Bike & Car")));
		logger.info("User Avail -> {}", productViewDao.findByAvail("No"));

	}
}

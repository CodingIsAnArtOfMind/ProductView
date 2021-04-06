package com.productview.sample.productview.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.productview.sample.productview.Entity.Productview;

@Repository
@Component
@Transactional
public class ProductViewDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/*
	 * @PersistenceContext EntityManager entityManager;
	 */

	class CustomerRowMapper implements RowMapper<Productview> {

		@Override
		public Productview mapRow(ResultSet rs, int rowNum) throws SQLException {
			Productview productview = new Productview();
			productview.setProductId(rs.getInt("productId"));
			productview.setProductManufacturer(rs.getString("productManufacturer"));
			productview.setProductAvailability(rs.getString("productAvailability"));
			productview.setProductPrice(rs.getString("productPrice"));
			productview.setProductType(rs.getString("productType"));
			return productview;
		}

	}

	public List<Productview> findAll() {

		return jdbcTemplate.query("select * from productView", new CustomerRowMapper());

	}

	public List<Productview> findById(int id) {
		/* return entityManager.find(Productview.class, id); */

		return jdbcTemplate.query("select * from productView where productId=?", new Object[] { id },
				new BeanPropertyRowMapper(Productview.class));

	}

	public List<Productview> findByAvail(String avail) {
		return jdbcTemplate.query("select * from productView where productAvailability=?", new Object[] { avail },
				new BeanPropertyRowMapper(Productview.class));
	}

	/*
	 * public Productview create(Productview Productview) { return
	 * entityManager.merge(Productview); }
	 */

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from productView where productId=?", new Object[] { id });
	}

	public int insert(Productview productview) {
		return jdbcTemplate.update(
				"insert into productView (productId, productManufacturer, productAvailability, productPrice, productType) "
						+ "values(?,  ?, ?, ?, ?)",
				new Object[] { productview.getProductId(), productview.getProductManufacturer(),
						productview.getProductAvailability(), productview.getProductPrice(),
						productview.getProductType() });
	}

}

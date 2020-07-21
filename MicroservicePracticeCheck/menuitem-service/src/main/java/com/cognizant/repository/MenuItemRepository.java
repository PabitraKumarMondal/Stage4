package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.model.MenuItem;
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Integer> {

	@Query(value="select * from menuitem where id= :id",nativeQuery = true)
	public MenuItem findAllById(@Param("id") Long id);

}

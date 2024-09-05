package com.RouteGaurd.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.RouteGaurd.app.model.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Long> {

	List<Goods> findAll();
	Optional<Goods> findById(Long id);
	Goods save(Goods goods);
	void deleteById(Long id);
	
}

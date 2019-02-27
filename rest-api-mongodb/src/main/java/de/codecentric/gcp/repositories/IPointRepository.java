package de.codecentric.gcp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import de.codecentric.gcp.model.Point;

@Repository("pointRepository")
public interface IPointRepository extends MongoRepository<Point, String>{
	public Point findBy_id(String id);

	@Query(value="{\"_id\":{$in :?0}}")
	public List<Point> findbyLst(List<String> lstid);
}

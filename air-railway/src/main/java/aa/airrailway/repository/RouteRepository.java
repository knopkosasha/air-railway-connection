package aa.airrailway.repository;

import aa.airrailway.RouteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends CrudRepository<RouteEntity, Integer> {

	RouteEntity findById(Long id);

	List<RouteEntity> findAll();

	List<RouteEntity> findAllByDepartureTimeAfterAndStartCity(Long date, String city);

}

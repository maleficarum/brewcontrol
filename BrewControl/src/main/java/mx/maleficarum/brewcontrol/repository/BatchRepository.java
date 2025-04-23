package mx.maleficarum.brewcontrol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import mx.maleficarum.brewcommon.entity.Batch;

@Repository
public interface BatchRepository extends CrudRepository<Batch, Long> {
    
}

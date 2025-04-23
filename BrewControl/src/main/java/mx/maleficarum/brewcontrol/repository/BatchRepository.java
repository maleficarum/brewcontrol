package mx.maleficarum.brewcontrol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import mx.maleficarum.brewcommon.entity.Batch;
import java.util.List;

@Repository
public interface BatchRepository extends CrudRepository<Batch, Long> {
    
    List<Batch> findAll();
}

package mx.maleficarum.brewcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.maleficarum.brewcommon.entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    
}

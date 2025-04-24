package mx.maleficarum.brewcontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.maleficarum.brewcontrol.repository.BatchRepository;
import mx.maleficarum.brewcommon.entity.Batch;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.postgresql.util.PSQLException;
import jakarta.transaction.Transactional;

/**
 * The batch service to "interact" with the persistence layer
 * 
 * @author Oscar I Hernandez [ o at maleficarum dot mx ]
 */

@Service
@Transactional
public class BatchService {
    
    @Autowired
    private BatchRepository batchRepository;
    private final Logger log = LoggerFactory.getLogger(BatchService.class);

    /**
     * List all batches
     * @return
     */
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    /*
     * Save new batch generating ids
     */
    public Batch createBatch(Batch batch) {
        return batchRepository.save(batch);
    }
}

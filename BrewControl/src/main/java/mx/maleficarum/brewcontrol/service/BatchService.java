package mx.maleficarum.brewcontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.maleficarum.brewcontrol.repository.BatchRepository;
import mx.maleficarum.brewcommon.entity.Batch;

@Service
public class BatchService {
    
    @Autowired
    private BatchRepository batchRepository;

    public Iterable<Batch> getAllBatches() {
        return batchRepository.findAll();
    }
}

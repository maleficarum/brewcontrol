package mx.maleficarum.brewcontrol.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import mx.maleficarum.brewcontrol.service.BatchService;

import java.util.List;

import mx.maleficarum.brewcommon.entity.Batch;

/**
 * The batch REST Controller
 *  
 * @author Oscar I Hernandez [ o at maleficarum dot mx ]
 */

@Tag(name = "Batch controller", description = "The batch controller to handle all the operations related to batches.")
@RestController
@RequestMapping("/api/v1/batches")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @Operation(summary = "Fetch all batches",  description = "Get all batches")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation")})
    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<List<Batch>> getBatches() {
        return ResponseEntity.ok(batchService.getAllBatches());
    }

    @Operation(summary = "Create a batch",  description = "Create a new brewing batch")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation")})
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity createBatch(@RequestBody Batch batch) {
        return ResponseEntity.ok(batchService.createBatch(batch));
    }    
    
}
package mx.maleficarum.brewcommon.eos;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

/**
 * Batch data object
 * 
 * @author Oscar Hernandez [ o at maleficarum dot mx ] 
 */

@AllArgsConstructor
@Data
public class Batch {
   
    private int batchId;
    private Date bewDate;
    private int fermentationTimeInDays;
    private Date bottlingDate;
    private BeerStyle BeerStyle;
    private int sizeInLiter;

}

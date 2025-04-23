package mx.maleficarum.brewcommon.eos;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The beer style according BJCP
 * 
 * @author Oscar Hernandez [ o at maleficarum dot mx ] 
 */

@AllArgsConstructor
@Data
public class BeerStyle {

    private BeerType beerType;
    private String name;
    private String style;
    private String bjcpStyle;

}
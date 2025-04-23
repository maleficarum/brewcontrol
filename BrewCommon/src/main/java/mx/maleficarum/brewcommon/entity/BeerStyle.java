package mx.maleficarum.brewcommon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import mx.maleficarum.brewcommon.entity.utils.BeerType;
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
package mx.maleficarum.brewcommon.eos;

/**
 * The beer yeast style
 * 
 * @author Oscar Hernandez [ o at maleficarum dot mx ] 
 */

public enum BeerType {

	LAGER(1),
    ALE(2);

	private final int value;

	BeerType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}    
}
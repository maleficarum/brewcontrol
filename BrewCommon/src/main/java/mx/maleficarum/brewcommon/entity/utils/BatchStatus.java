package mx.maleficarum.brewcommon.entity.utils;

/**
 * The beer yeast style
 * 
 * @author Oscar Hernandez [ o at maleficarum dot mx ] 
 */

public enum BatchStatus {

	PLANNED(1),
	BREWING(2),
	FERMENTING(3),
	CONDITIONING(4),
	BOTTLED(5),
	COMPLETED(6);

	private final int value;

	BatchStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
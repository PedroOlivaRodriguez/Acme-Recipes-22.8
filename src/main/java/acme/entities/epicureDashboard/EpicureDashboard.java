package acme.entities.epicureDashboard;

import java.io.Serializable;
import java.util.Map;

import acme.entities.fineDish.StatusType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EpicureDashboard implements Serializable{

	protected static final long	serialVersionUID	= 1L;
	
	
	protected Map<StatusType,Integer> totalFineDish;
	protected Map<StatusType,Double> averageFineDishRetailPrice;
	protected Map<StatusType,Double> deviationFineDishRetailPrice;
	protected Map<StatusType,Integer> maximumFineDishRetailPrice;
	protected Map<StatusType,Integer> minimumUtensilRetailPrice;
	
	
	
	
	
}

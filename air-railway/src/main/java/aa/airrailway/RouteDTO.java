package aa.airrailway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDTO {
	private Long id;
	private Long departureTime;
	private Long arrivalTime;
	private String startCity;
	private String finishCity;


	public String toString(){

		return startCity +" " + departureTime + " " + finishCity + " " + arrivalTime;
	}
}

package aa.airrailway;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "routes")
public class RouteEntity {
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "departure")
	private Long departureTime;
	@Column(name="arrival")
	private Long arrivalTime;
	@Column(name="start_city")
	private String startCity;
	@Column(name="finish_city")
	private String finishCity;

	public RouteDTO convertToDTO() {
		return new RouteDTO(
			id = this.id,
			departureTime = this.departureTime,
			arrivalTime = this.arrivalTime,
			startCity = this.startCity,
			finishCity = this.finishCity
		);
	}
}

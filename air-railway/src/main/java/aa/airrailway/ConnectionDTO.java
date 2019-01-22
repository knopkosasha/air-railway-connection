package aa.airrailway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionDTO {
	private RouteDTO firstRoute;
	private RouteDTO secondRoute;
	private Time difference;
}

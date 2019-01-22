package aa.airrailway;

import aa.airrailway.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConnectionService {

	private final RouteRepository routeRepository;


	@Transactional
	public List<ConnectionDTO> findAllConnections(Long firstRouteId, String destination) {
		List<ConnectionDTO> connections = new LinkedList<>();
		ConnectionDTO connection = new ConnectionDTO();
		RouteEntity entity = this.routeRepository.findById(firstRouteId);
		//TODO check for null
		RouteDTO firstRoute = entity.convertToDTO();
		connection.setFirstRoute(firstRoute);
		List<RouteDTO> routes = new LinkedList<>();
		List<RouteEntity> routeEntities = this.routeRepository.findAllByDepartureTimeAfterAndStartCity
			(connection.getFirstRoute().getArrivalTime(), connection.getFirstRoute().getFinishCity());
		for (RouteEntity route : routeEntities) {
			connection.setSecondRoute(route.convertToDTO());
			Time difference = new Time();
			Long diff = connection.getSecondRoute().getDepartureTime() - connection.getFirstRoute().getArrivalTime();
			difference.setMinutes(diff % 3600 / 60);
			difference.setHours(diff / 3600);
			connection.setDifference(difference);
			connections.add(connection);
		}
		return connections;
	}

	@Transactional
	public List<RouteDTO> allRoutes() {
		List<RouteDTO> routes = new LinkedList<>();
		List<RouteEntity> routeEntities = this.routeRepository.findAll();
		for (RouteEntity route : routeEntities) {
			routes.add(route.convertToDTO());
		}
		return routes;
	}
}

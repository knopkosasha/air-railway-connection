package aa.airrailway;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ConnectionController {
	private final ConnectionService connectionService;

	@GetMapping("/routes")
	public ModelAndView allRoutes() {
		ModelAndView mav = new ModelAndView();
		List<RouteDTO> dtos = this.connectionService.allRoutes();
		Map<Long, String> routes = new HashMap<>();
		for (RouteDTO dto : dtos) {
			routes.put(dto.getId(), dto.toString());
		}
		mav.addObject("routes", routes);

		return mav;
	}

	@PostMapping("/connection")
	public ModelAndView findAllConnections(
		@RequestParam(name = "firstRouteId") Long firstRouteId,
		@RequestParam(name = "destination") String destination) {

		List<ConnectionDTO> connections = this.connectionService.findAllConnections(firstRouteId, destination);

		ModelAndView mav = this.allRoutes();

		mav.addObject("connections", connections);

		return mav;
	}
}

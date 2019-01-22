package aa.airrailway;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ConnectionController {
	private final ConnectionService connectionService;

	@GetMapping("/connection")
	public List<ConnectionDTO> findAllConnections (RouteDTO firstRoute, String destination)
	{
		return this.connectionService.findAllConnections(firstRoute, destination);
	}

	@GetMapping("/routes")
	public ModelAndView allRoutes()
	{
		ModelAndView mav = new ModelAndView();
		List<RouteDTO> dtos = this.connectionService.allRoutes();
		Map<Long,String> routes = new HashMap<>();
		for (RouteDTO dto : dtos) {
			routes.put(dto.getId(),dto.toString());
		}
		mav.addObject("routes", routes);

		return mav;
	}
}

package viewer.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Justin Ford
 * Date: 10/30/12
 * Time: 4:49 PM
 */
@Controller
public class MapController extends BaseController {

    @RequestMapping("/mapView")
    public String returnUserHomePage()
    {
        return "/mapView";
    }
}

package viewer.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import viewer.web.model.ErrorPageDto;

/**
 * User: Justin Ford
 * Date: 10/30/12
 * Time: 4:49 PM
 */
@Controller
public class NavigationController extends BaseController {

    @RequestMapping("/home")
    public String returnUserHomePage()
    {
        return "/home";
    }

    @RequestMapping(value={"/error"})
    public String goToErrorPage(Model model)
    {
        ErrorPageDto errorDto = new ErrorPageDto();
        errorDto.setMessage("The system encountered an error while working on your request. Please try again later.");
        model.addAttribute("errorDto", errorDto );
        return "/error";
    }
}

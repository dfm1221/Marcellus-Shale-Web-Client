package viewer.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Justin Ford
 * Date: 10/29/12
 * Time: 3:32 PM
 */

@Controller
public class LoginController extends BaseController {

    @Value("${loginpage.warningbanner}")
    private String warningBanner;

    @RequestMapping(value={ "/", "/login" })
    public String goToLoginPage(Model model) {


        System.out.println("We are connected!!!!");

        if (appSecurityContext.isAuthenticated()) {
            return "redirect:/home";
        }

        model.addAttribute("banner", warningBanner);
        return "/login";
    }

    @RequestMapping("/authFailure/badCredentails")
    public String failedLogin(ModelMap model) {
        model.addAttribute("loginError", "Invalid username or password. Please try again.");
        model.addAttribute("banner", warningBanner);
        return "/login";
    }

    @RequestMapping("/authFailure/timeout")
    public String invalidSession(ModelMap model) {
        model.addAttribute("loginError", "Your session has timed out. Please log in again.");
        model.addAttribute("banner", warningBanner);
        return "/login";
    }

    @RequestMapping("/logout")
    public String processLogout(ModelMap model) {
        model.addAttribute("banner", warningBanner);
        return "/login";
    }

    @RequestMapping("/authFailure/accessDenied")
    public String accessDenied(ModelMap model) {
        model.addAttribute("banner", warningBanner);
        return "/accessDenied";
    }
}

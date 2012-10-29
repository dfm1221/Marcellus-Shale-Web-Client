package viewer.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Justin Ford
 * Date: 10/29/12
 * Time: 3:32 PM
 */

@Controller
public class LoginController extends BaseController {

    @RequestMapping(value={ "/", "/login" })
    public String goToLoginPage() {
        return "/login";
    }

}

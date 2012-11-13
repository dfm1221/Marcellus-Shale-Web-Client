package viewer;

import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/**
 * User: Justin Ford
 * Date: 11/12/12
 * Time: 7:33 PM
 */
public class Slf4jMDCFilter extends GenericFilterBean {

    private static final String SESSION_ID = "sessionId";
    private static final String PRINCIPAL = "principal";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httprequest = (HttpServletRequest) request;
        SecurityContext context = (SecurityContext) httprequest.getSession().getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);

        if (context != null) {
            Authentication authentication = context.getAuthentication();
            MDC.put(PRINCIPAL, authentication.getName());
            MDC.put(SESSION_ID, httprequest.getSession().getId());
        } else {
            MDC.put(PRINCIPAL, "");
            MDC.put(SESSION_ID, httprequest.getSession().getId());
        }
        chain.doFilter(request, response);
    }

}

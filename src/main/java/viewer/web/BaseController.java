package viewer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viewer.security.ApplicationSecurityContext;

@Component
public abstract class BaseController {


//    @Autowired
//    protected BeanMapper beanMapper;

    @Autowired
    public ApplicationSecurityContext appSecurityContext;

//    private static final Logger LOG  = LoggerFactory.getLogger(BaseController.class);

    protected Long getCurrentUserId() {
        return appSecurityContext.getUserId();
    }
}

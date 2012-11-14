package viewer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.hibernate.validator.method.MethodValidator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Validator;
import java.util.Set;

/**
 * Intercepts all public Service and DAO methods to perform parameter validation
 * if validation annotations exist. Resulting
 * {@link MethodConstraintViolationException} will be wrapped in an
 * {@link InvalidServiceInputException} for uniformity.
 * <p/>
 * To use, annotate method parameters with JSR-303 validation annotations.
 * <p/>
 * To validate fields/methods within POJOs (e.g. DTOs), annotate with {@link javax.validation.Valid} and
 * specify the validation annotations in the POJOs classes.
 * 
 *
 * 
 *         October 18, 2012
 */
//
public class ValidationAspect {

	@Autowired
	private Validator validator;

	// Match any public methods in viewer.service.* package
//	@Around("execution(public * viewer.service.*.*(..))")
	public Object validateServiceMethodParams(ProceedingJoinPoint pjp) throws Throwable {

		try {
			return validateMethodParametersAndProceed(pjp);
		} catch (MethodConstraintViolationException mcv) {
			throw new InvalidServiceInputException(mcv);
		}
	}

	// Match any public methods in viewer.service.* package
//	@Around("execution(public * viewer.dao.*.*(..))")
	public Object validateDaoMethodParams(ProceedingJoinPoint pjp) throws Throwable {

		try {
			return validateMethodParametersAndProceed(pjp);
		} catch (MethodConstraintViolationException mcv) {
			throw new InvalidDaoInputException(mcv);
		}
	}


	public Object validateMethodInvocation(ProceedingJoinPoint pjp) throws Throwable {
		return validateMethodParametersAndProceed(pjp);
	}

	private Object validateMethodParametersAndProceed(ProceedingJoinPoint pjp) throws Throwable {
		Object result;
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		MethodValidator methodValidator = validator.unwrap(MethodValidator.class);

		Set<MethodConstraintViolation<Object>> parametersViolations = methodValidator.validateAllParameters(pjp.getTarget(), signature.getMethod(), pjp.getArgs());
		if (!parametersViolations.isEmpty()) {
			throw new MethodConstraintViolationException(parametersViolations);
		}

		result = pjp.proceed(); // Execute the method

		Set<MethodConstraintViolation<Object>> returnValueViolations = methodValidator.validateReturnValue(pjp.getTarget(), signature.getMethod(), result);
		if (!returnValueViolations.isEmpty()) {
			throw new MethodConstraintViolationException(returnValueViolations);
		}

		return result;
	}

}

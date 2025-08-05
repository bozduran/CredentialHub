package bozntouran.reviewmycert.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("execution(* bozntouran.reviewmycert.services..*(..))")
    public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        log.info("Entering method: {}", methodName);
        log.debug("Args: {}", args);

        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - start;

            log.info("Method {} completed in {} ms", methodName, duration);
            log.debug("Result: {}", result);

            return result;
        } catch (Throwable ex) {
            log.error("Exception in {}: {}", methodName, ex.getMessage(), ex);
            throw ex;
        }
    }

    @Around("execution(* bozntouran.reviewmycert.config..*(..))")
    public Object logConfigMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        log.info("Entering method: {}", methodName);
        log.debug("Args: {}", args);
        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - start;

            log.info("Method {} completed in {} ms", methodName, duration);
            log.debug("Result: {}", result);

            return result;
        } catch (Throwable ex) {
            log.error("Exception in {}: {}", methodName, ex.getMessage(), ex);
            throw ex;
        }
    }
}
package cn.seu.edu.spring.chapter4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Administrator on 2017/9/16.
 */
@Aspect
public class AudienceUseAround {
    @Pointcut("execution(* cn.seu.edu.spring.chapter4.Performance(..))")
    public void performance(){}

    // 使用环绕通知必须使用ProceedingJoinPoint，用于将控制权交给目标代码，否则就是阻塞目标代码
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println("silence");
            System.out.println("takeSeat");
            proceedingJoinPoint.proceed();
            System.out.println("applause");
        } catch (Throwable throwable) {
            System.out.println("demandRefund");
        }
    }
}

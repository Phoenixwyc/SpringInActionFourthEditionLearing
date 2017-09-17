package cn.seu.edu.spring.chapter4;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Administrator on 2017/9/16.
 */
public class AudienceByPointcut {
    // 这里的performance方法只是一个标识，作为@Pointcut的依附，没有具体含义，用于简化切点表达式
    @Pointcut("execution(* cn.seu.edu.spring.chapter4.Performance(..))")
    public void performance(){}

    @Before("performance()")
    public void silence() {
        System.out.println("silence");
    }

    @Before("performance()")
    public void takeSeat() {
        System.out.println("takeSeat");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("applause");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("demandRefund");
    }
}

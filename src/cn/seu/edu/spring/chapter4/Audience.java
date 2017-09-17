package cn.seu.edu.spring.chapter4;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/9/16.
 */
@Aspect
@Component
public class Audience {
    @Before("execution(* cn.seu.edu.spring.chapter4.Performance(..))")
    public void silence() {
        System.out.println("silence");
    }

    @Before("execution(* cn.seu.edu.spring.chapter4.Performance(..))")
    public void takeSeat() {
        System.out.println("takeSeat");
    }

    @AfterReturning("execution(* cn.seu.edu.spring.chapter4.Performance(..))")
    public void applause() {
        System.out.println("applause");
    }

    @AfterThrowing("execution(* cn.seu.edu.spring.chapter4.Performance(..))")
    public void demandRefund() {
        System.out.println("demandRefund");
    }
}

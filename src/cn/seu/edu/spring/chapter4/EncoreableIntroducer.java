package cn.seu.edu.spring.chapter4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by Administrator on 2017/9/17.
 */
@Aspect
public class EncoreableIntroducer{
    @DeclareParents(value = "cn.seu.edu.spring.chapter4.Performance+",
                    defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}

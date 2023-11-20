package com.wpc.aop.annoaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author wpc
 * @date 2023/10/13 15:21
 */
//切面类
@Aspect
@Component //ioc中进行管理
public class LogAspect {
    //设置切入点和通知类型
    //通知类型: 前置 返回 异常  环绕
    //切入点表达式   execution(权限修饰符 增强方法的返回类型 方法所在类的全路径.方法名(参数)) 可以使用通配符*
    //前置 @Before(value="切入点表达式")
    @Before(value = "execution(public int com.wpc.aop.annoaop.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("logger ---> 前置通知 方法名称" + name + "方法参数 : " +  Arrays.toString(args));
    }
    //返回 @AfterReturning 可以获取方法的返回值
    @AfterReturning(value = "execution(* com.wpc.aop.annoaop.CalculatorImpl.*(..))",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("logger ---> 返回通知 方法名称" + name + "方法参数 : " +  Arrays.toString(args) + "  返回结果为" + result);
    }
    //异常 @AfterThrowing
    @AfterThrowing(value = "com.wpc.aop.annoaop.LogAspect.pointCut()",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("logger ---> 异常通知 方法名称" + name + "方法参数 : " +  Arrays.toString(args) + "  异常为" + ex);
    }
    //后置通知 @After
    //重用切入点表达式
    @After(value = "pointCut()")
    public void afterMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("logger ---> 后置通知 方法名称" + name + "方法参数 : " +  Arrays.toString(args));
    }
    //环绕 @Around
    /**
     * ProceedingJoinPoint具有更强大的功能 可以让目标方法执行
     * 需要有返回值的不然报错
     * @param joinPoint
     */
    @Around(value = "execution(* com.wpc.aop.annoaop.CalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try{
            System.out.println("环绕通知 --->  在方法执行之前执行 方法名称" + name + "方法参数 : " +  Arrays.toString(args));
            //调用目标方法
            result = joinPoint.proceed();
            System.out.println("result = ++++++++ " + result);
            System.out.println("环绕通知  --->  目标方法返回之后执行");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("环绕通知  --->  目标方法出现异常时执行");
        }finally {
            System.out.println("环绕通知  --->  目标方法执行完毕后执行");
        }
        return result;
    }

    //重用接入点表达式
    @Pointcut(value = "execution(* com.wpc.aop.annoaop.CalculatorImpl.*(..))")
    public void pointCut(){}
    @Pointcut(value = "@annotation(AnnoAop)")
    public void pointCut1(){}
}

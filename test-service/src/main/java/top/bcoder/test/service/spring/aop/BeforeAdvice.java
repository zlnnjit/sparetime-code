package top.bcoder.test.service.spring.aop;

import java.lang.reflect.Method;

public class BeforeAdvice implements Advice {

    private Object bean;

    private MethodInvocation methodInvocation;

    public BeforeAdvice(Object bean, MethodInvocation methodInvocation) {
        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        methodInvocation.invoke();
        return method.invoke(bean, objects);
    }
}

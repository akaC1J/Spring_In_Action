package com.kirill.classes;




import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class TigerReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        return "еба.. тигр";
    }
}

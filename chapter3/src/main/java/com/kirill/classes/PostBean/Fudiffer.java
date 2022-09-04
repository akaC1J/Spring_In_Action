package com.kirill.classes.PostBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

public class Fudiffer implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        try {
            for (Field field : fields) { // Преобразует все
                if (field.getType().equals( // строковые свойства
                        String.class)) { // компонентов
                    field.setAccessible(true);
                    String original = (String) field.get(bean);
                    field.set(bean,fuddify(original));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }

    private String fuddify(String orig) { // Преобразует все строковые
        if(orig == null) return orig; // свойства компонентов
        return orig.replaceAll("[рл]", "в")
                .replaceAll("[РЛ]", "В");
    }
}

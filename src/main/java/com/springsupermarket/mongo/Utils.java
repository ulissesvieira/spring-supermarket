package com.springsupermarket.mongo;

import org.springframework.data.mongodb.core.query.Criteria;

import java.lang.reflect.Field;

public class Utils {
    public static <T> Criteria anyFieldCriteria(Class<T> clazz, T instance) {
        Criteria criteria = new Criteria();

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            try {
                String fieldName = field.getName();
                Object fieldValue = field.get(instance);

                if (fieldValue != null) {
                    criteria.andOperator(Criteria.where(fieldName).is(fieldValue));
                }
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return criteria;
    }
}

package com.spring.parkingsystem.utility;

import com.spring.parkingsystem.models.Category;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MapperHelper {
    private static Object getFieldValue(Object object, String fieldName, Class<?> classType){
        try{
            Field field = classType.getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(object);
            return value;
        } catch (Exception exception){
        }
        return null;
    }

    public static Integer getIntegerField(Object object, String fieldName, Class<?> classType){
        return (Integer) getFieldValue(object, fieldName, classType);
    }

    public static Integer getIntegerField(Object object, Integer index){
        return (Integer) ((Object[])object)[index];
    }

    public static String getStringField(Object object, String fieldName, Class<?> classType){
        return getFieldValue(object, fieldName, classType).toString();
    }

    public static String getStringField(Object object, Integer index){
        return ((Object[])object)[index].toString();
    }

    public static LocalDateTime getLocalDateTimeField(Object object, String fieldName, Class<?> classType){
        return (LocalDateTime) getFieldValue(object, fieldName, classType);
    }

    public static LocalDateTime getLocalDateTimeField(Object object, Integer index){
        return (LocalDateTime) ((Object[])object)[index];
    }

    public static LocalDate getLocalDateField(Object object, String fieldName, Class<?> classType){
        return (LocalDate) getFieldValue(object, fieldName, classType);
    }

    public static LocalDate getLocalDateField(Object object, Integer index){
        return (LocalDate) ((Object[])object)[index];
    }

    public static Category getLCategoryField(Object object, String fieldName, Class<?> classType){
        return (Category) getFieldValue(object, fieldName, classType);
    }

    public static Category getCategoryField(Object object, Integer index){
        return (Category) ((Object[])object)[index];
    }

}

package me.ly.project.Enum;

import java.lang.reflect.InvocationTargetException;

/**
 * @author LiYan
 * @date 2018/4/25 12:21
 */
 public class EnumUtil{
    public static <T> T getEnum(Class<T> clazz, Object obj) {
        T result = null;
        try {
            Object invokeResult = clazz.getMethod("values").invoke(null);
            T[] arr = (T[]) invokeResult;
            for (T one : arr) {
                Object obj1 = one.getClass().getMethod("getValue").invoke(one);
                if (obj1.equals(obj)) {
                    result = one;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;

    }
}

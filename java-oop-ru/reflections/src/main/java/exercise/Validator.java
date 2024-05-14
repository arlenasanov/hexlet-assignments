package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> list = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    Object o = field.get(address);
                    if (o == null) {
                        list.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> map = new HashMap<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    Object o = field.get(address);
                    if (o == null) {
                        List<String> list = new ArrayList<>();
                        list.add("can not be null");
                        map.put(field.getName(), list);
                        continue;
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            if (field.isAnnotationPresent(MinLength.class)) {
                List<String> list = new ArrayList<>();
                list.add("length less than " + field.getAnnotation(MinLength.class).minLength());
                map.put(field.getName(), list);
            }
        }
        return map;
    }
}
// END

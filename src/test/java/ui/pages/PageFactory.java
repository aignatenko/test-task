package ui.pages;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class PageFactory {

    public static <T extends BasePage> T create(Class<T> clazz, Object... args) {
        try {
            Class<?>[] constructorParams = Arrays.stream(args).map(arg -> arg.getClass()).toArray(Class<?>[]::new);
            return clazz.getDeclaredConstructor(constructorParams).newInstance(args);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}

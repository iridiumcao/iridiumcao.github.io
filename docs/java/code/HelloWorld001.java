import java.lang.reflect.Method;

public class HelloWorld001 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("HelloWorld002");
        Method method = clazz.getMethod("main", String[].class);
        method.invoke(null, (Object) new String[] { "1", "2" });
    }
}
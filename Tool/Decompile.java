package Tool;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * The type Decompile.
 */
public class Decompile implements MyTool {

    /**
     * 反编译 class 的 field
     *
     * @param referencePath the reference path
     * @return the string
     * @throws ClassNotFoundException the class not found exception
     */
    public static String decompile_field(String referencePath) throws ClassNotFoundException {
        StringBuilder builder = new StringBuilder();

        Class theClass = Class.forName(referencePath);

        builder.append(Modifier.toString(theClass.getModifiers()) + " "
                + theClass.getSimpleName() + " {\n");

        Field[] fields = theClass.getDeclaredFields();

        for (Field field : fields) {
            builder.append("\t");
            builder.append(Modifier.toString(field.getModifiers()));
            builder.append(" ");
            builder.append(field.getType().getSimpleName());
            builder.append(" ");
            builder.append(field.getName());
            builder.append(";\n");
        }

        builder.append("}");
        return builder.toString();
    }


    /**
     * 反编译对象的 field
     *
     * @param o 对象
     * @return the string
     */
    public static String decompile_Object_field(Object o){
        StringBuilder builder = new StringBuilder();

        Class theClass = o.getClass();

        builder.append(theClass.getSimpleName() + " {\n");

        Field[] fields = theClass.getDeclaredFields();

        for (Field field : fields) {
            builder.append("\t");
            builder.append(Modifier.toString(field.getModifiers()));
            builder.append(" ");
            builder.append(field.getType().getSimpleName());
            builder.append(" ");
            builder.append(field.getName());
            try {
                field.setAccessible(true);
                builder.append(" = " + (field.get(o) != null ? field.get(o).toString() : "null") );
            } catch (Exception e) {}
            builder.append(";\n");
        }

        builder.append("}");
        return builder.toString();
    }


    /**
     * 反编译 class 的 Method
     *
     * @param referencePath the reference path
     * @return the string
     * @throws ClassNotFoundException the class not found exception
     */
    public static String decompile_method(String referencePath) throws ClassNotFoundException {
        StringBuilder builder = new StringBuilder();

        Class theClass = Class.forName(referencePath);

        builder.append(Modifier.toString(theClass.getModifiers()) + " "
                + theClass.getSimpleName() + " {\n");

        Method[] methods = theClass.getDeclaredMethods();

        for (Method method : methods) {
            builder.append("\t");
            builder.append(Modifier.toString(method.getModifiers()));
            builder.append(" ");
            builder.append(method.getReturnType().getSimpleName());
            builder.append(" ");
            builder.append(method.getName());
            builder.append(" (");
            Class[] parameterTypes = method.getParameterTypes();
            for(Class parameterType : parameterTypes) {
                builder.append(parameterType.getSimpleName());
                builder.append(",");
            }
            if(parameterTypes.length != 0) builder.deleteCharAt(builder.length() - 1);
            builder.append(") \n");
        }

        builder.append("}");
        return builder.toString();
    }


    /**
     * 反编译 class 的 Constructor
     *
     * @param referencePath the reference path
     * @return the string
     * @throws ClassNotFoundException the class not found exception
     */
    public static String decompile_Constructor(String referencePath) throws ClassNotFoundException {
        StringBuilder builder = new StringBuilder();

        Class theClass = Class.forName(referencePath);

        builder.append(Modifier.toString(theClass.getModifiers()) + " "
                + theClass.getSimpleName() + " {\n");

        Constructor[] constructors = theClass.getConstructors();

        for (Constructor constructor : constructors) {
            builder.append("\t");
            builder.append(Modifier.toString(constructor.getModifiers()));
            builder.append(" ");
            builder.append(theClass.getSimpleName());
            builder.append(" (");
            Class[] parameterTypes = constructor.getParameterTypes();
            for(Class parameterType : parameterTypes) {
                builder.append(parameterType.getSimpleName());
                builder.append(",");
            }
            if(parameterTypes.length != 0) builder.deleteCharAt(builder.length() - 1);
            builder.append(") \n");
        }

        builder.append("}");
        return builder.toString();
    }


    /**
     * 反编译 class 的 super class 和 interface
     *
     * @param referencePath the reference path
     * @return the string
     * @throws ClassNotFoundException the class not found exception
     */
    public static String decompile_super_interfaces(String referencePath) throws ClassNotFoundException {
        StringBuilder builder = new StringBuilder();
        Class theClass = Class.forName(referencePath);

        builder.append("Super class ---> ");
        Class superClass = theClass.getSuperclass();
        builder.append(superClass.getSimpleName());
        builder.append("\nInterfaces ---> ");
        Class[] interfaces = theClass.getInterfaces();
        for(Class inter : interfaces) {
            builder.append(inter.getSimpleName());
            builder.append(" ");
        }

        return builder.toString();
    }





}

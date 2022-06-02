package com.check;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class ClassInspector {

    List<Class> classList;

    public void inspect() {

        classList.forEach(classFile -> {
            System.out.println("---------- CLASS NAME: " + classFile.getName() + " ----------");
            System.out.println("Package: " + classFile.getPackageName() + "\n");

            System.out.println("--------------- FIELDS ---------------");
            Arrays.stream(classFile.getDeclaredFields()).forEach(field -> {
                System.out.println("Type: " + field.getType());
                System.out.println("Name : " + field.getName());
                System.out.println("Access Modifier: " + Modifier.toString(field.getModifiers()));
                System.out.println("Annotations (" + field.getAnnotations().length + "): "
                        + Arrays.toString(field.getDeclaredAnnotations())+ "\n");
            });

            System.out.println("--------------- METHODS ---------------");
            Arrays.stream(classFile.getDeclaredMethods()).forEach(method -> {

                System.out.println("Name: " + method.getName());
                System.out.println("Parameters (" + method.getParameterCount() + "):  "
                        + Arrays.toString(method.getParameters()));
                System.out.println("Return type: " + method.getReturnType());
                System.out.println("Access Modifier: " + Modifier.toString(method.getModifiers()));
                System.out.println("Annotations (" + method.getDeclaredAnnotations().length + "): "
                        + Arrays.toString(method.getDeclaredAnnotations()) + "\n");
            });
        });
    }

    public ClassInspector() { }

    public ClassInspector(List<Class> classList) { this.classList = classList; }

    public void setClassList(List<Class> classList) { this.classList = classList; }
}

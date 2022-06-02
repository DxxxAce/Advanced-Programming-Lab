package com.check;

import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassTester {

    public void runTestCases(List<Class> classList) {

        long start =  System.currentTimeMillis();

        classList.forEach(clazz -> {
            System.out.println("---------- RUNNING FOR " + clazz.getName() + " ----------");

            int passed = 0;
            int failed = 0;

            Random random = new Random();

            for (Method m : clazz.getDeclaredMethods()) {

                if (!m.isAnnotationPresent(Test.class)) { continue; }

                m.setAccessible(true);

                try {

                    List<Object> arguments = new ArrayList<>();

                    //get the required arguments
                    if(m.getParameterTypes().length != 0) {

                      //  arguments = new Class<?>[m.getParameterTypes().length];
                        for(Class<?> param : m.getParameterTypes()) {

                            try {

                                arguments.add(getRandomPrimitiveValue(param.getName()));
                            }
                            catch (Exception e) {

                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                    }

                    if (arguments.size() == 0) {

                        m.invoke(clazz.getDeclaredConstructor(null).newInstance());
                    }
                    else {

                        m.invoke(clazz.getDeclaredConstructor(null).newInstance(),arguments.toArray());
                    }

                    passed++;
                }
                catch (Throwable ex) {

                    System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                    failed++;
                }
            }

            System.out.println();
            System.out.println("--------------- STATS ---------------");
            System.out.println("Time elapsed : " + (System.currentTimeMillis() - start) + "ms");
            System.out.printf("Passed: %d, Failed %d%n", passed, failed);

            float pass = (float) (passed / (passed * 1.00 + failed) * 100);


            System.out.printf("Passing percentage: %.2f %%", pass );
            System.out.println("\n");
        });
    }

    private Object getRandomPrimitiveValue(String name) {

        Random random = new Random();
        Object result = null;

        switch(name) {

            case "int":
                result = random.nextInt();
                break;

            case "byte":
                result = random.nextInt(-128,128);
                break;

            case "short":
                result = random.nextInt(-32768,32768);
                break;

            case "java.lang.Long":
                result = random.nextLong();
                break;

            case "float":
                result = random.nextFloat();
                break;

            case "double":
                result = random.nextDouble();
                break;

            case "boolean":
                result = random.nextBoolean();
                break;

            case "char":
                result = (char) (random.nextInt(26) + 'a');
                break;

            case "java.lang.String":
                int leftLimit = 97; // letter 'a'
                int rightLimit = 122; // letter 'z'
                int targetStringLength = 10;
                result = random.ints(leftLimit, rightLimit + 1)
                        .limit(targetStringLength)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                break;
        }

        return result;
    }
}

import org.testng.annotations.Test;

public class Test1 {

    protected int protectedInt = 3;

    @Test
    public static void m1() { }

    public static void m2() { }

    @Test
    public static void m3() {
        throw new RuntimeException("Boom");
    }

    public static void m4() { }

    @Test
    public static void m5() { }

    public static void m6() { }

    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() { }

    @Test
    public void nonStaticTest() { }

    @Test
    public void nonStaticTestWithArgInt(int someInt) { throw new RuntimeException("IntError"); }

    @Test
    public void staticTestWithArgString(String someString) { };
}
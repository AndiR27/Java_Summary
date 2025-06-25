package Java_ModernFeatures.Lambdas;

@FunctionalInterface
public interface TestInterfaceVoid {
    void executer();

    default void test() {
        System.out.println("test");
    }
}

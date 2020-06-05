package lesson7;

public class Tests {

        @Test
        public static void method1(){
            System.out.println("Метод1");
        }

        @BeforeSuite
        public static void method2(){
            System.out.println("Метод2-Before");
        }

        @AfterSuite
        public static void method3(){
            System.out.println("Метод3-After");
        }

        @Test(priority = 2)
        public static void method4(){
            System.out.println("Метод4");
        }

        @Test(priority = 10)
        public static void method5() {
            System.out.println("Метод5");
        }
}



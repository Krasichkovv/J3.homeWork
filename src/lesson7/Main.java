package lesson7;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {

        check(Tests.class);
    }

    public static void check(Class a) throws Exception {
        ArrayList<Method> methods = new ArrayList<>();

        for (Method m:a.getDeclaredMethods()){
            if (m.isAnnotationPresent(Test.class)){
                if(m.getAnnotation(Test.class).priority() < 1||m.getAnnotation(Test.class).priority() > 10){
                    throw new RuntimeException("Неправильный приоритет");
                }
                methods.add(m);
            }
        }
        methods.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return - (o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority());
            }
        });
        for (Method m:a.getDeclaredMethods()){
            if (m.isAnnotationPresent(BeforeSuite.class)){
                if(methods.get(0).isAnnotationPresent(BeforeSuite.class)){
                    throw new RuntimeException("Много @BeforeSuite");
                }
                methods.add(0, m);
            }
        }
        for (Method m:a.getDeclaredMethods()){
            if (m.isAnnotationPresent(AfterSuite.class)){
                if(methods.get(methods.size()-1).isAnnotationPresent(AfterSuite.class)){
                    throw new RuntimeException("Много @AfterSuite");
                }
                methods.add(m);
            }
        }

        for (int i=0; i<methods.size(); i++){
            methods.get(i).invoke(null);
        }

    }


}

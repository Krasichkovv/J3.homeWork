package lesson4;

public class Main {

    static Object mon = new Object();
    static volatile char c = 'A';


    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (mon) {
                            while (c != 'A') {
                                mon.wait();
                            }
                            System.out.print("A");
                            c = 'B';
                            mon.notifyAll();
                        }
                    }

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (mon) {
                            while (c != 'B') {
                                mon.wait();
                            }
                            System.out.print("B");
                            c = 'C';
                            mon.notifyAll();
                        }
                    }

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (mon) {
                            while (c != 'C') {
                                mon.wait();
                            }
                            System.out.print("C");
                            c = 'A';
                            mon.notifyAll();
                        }
                    }

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        t3.start();


    }


}

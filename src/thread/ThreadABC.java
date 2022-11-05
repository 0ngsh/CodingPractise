package thread;
public class ThreadABC {
    public static class ResourceLock{
        public volatile int flag = 1;
    }

    static class Thread1 extends Thread{

        ResourceLock lock;

        Thread1(ResourceLock lock){
            this.lock = lock;
        }

        @Override
        public void run() {

            try{
                synchronized (lock) {

                    for (int i = 0; i < 100; i++) {

                        while(lock.flag!=1){
                            lock.wait();
                        }

                        System.out.print("A ");
                        Thread.sleep(1000);
                        lock.flag = 2;
                        lock.notifyAll();
                    }

                }
            }catch (Exception e) {
                System.out.println("Exception 1 :"+e.getMessage());
            }

        }
    }

    static class Thread2 extends Thread{

        ResourceLock lock;

        Thread2(ResourceLock lock){
            this.lock = lock;
        }

        @Override
        public void run() {

            try{
                synchronized (lock) {

                    for (int i = 0; i < 100; i++) {

                        while(lock.flag!=2){
                            lock.wait();
                        }

                        System.out.print("B ");
                        Thread.sleep(1000);
                        lock.flag = 3;
                        lock.notifyAll();
                    }

                }
            }catch (Exception e) {
                System.out.println("Exception 2 :"+e.getMessage());
            }

        }
    }

    public static class ThreadC extends Thread{

        ResourceLock lock;

        ThreadC(ResourceLock lock){
            this.lock = lock;
        }

        @Override
        public void run() {

            try{
                synchronized (lock) {

                    for (int i = 0; i < 100; i++) {

                        while(lock.flag!=3){
                            lock.wait();
                        }

                        System.out.print("C ");
                        Thread.sleep(1000);
                        lock.flag = 1;
                        lock.notifyAll();
                    }

                }
            }catch (Exception e) {
                System.out.println("Exception 3 :"+e.getMessage());
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {

        ResourceLock lock = new ResourceLock();

        Thread1 t1 = new Thread1(lock);

        Thread2 t2 = new Thread2(lock);

        ThreadC t3 = new ThreadC(lock);

/*
Thread t3 = new Thread(() -> System.out.println("New Thread"));
*/
        t3.start();
        t1.start();

/*
        t1.yield();
*/

        t2.start();

    }
 /*   public void method(int x){
        System.out.println(x);
    }*/

}

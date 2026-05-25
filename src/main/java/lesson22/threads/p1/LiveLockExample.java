package lesson22.threads.p1;

public class LiveLockExample {

    static class Worker {
        private String name;
        private boolean active;

        public Worker(String name) {
            this.name = name;
            this.active = true;
        }

        public synchronized void work(SharedResource resource, Worker otherWorker) {

            while (active) {

                // Əgər digər worker aktivdirsə
                // ona şans ver
                if (otherWorker.active) {
                    System.out.println(name + ": You go first " + otherWorker.name);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }

                    continue;
                }

                // işi gör
                resource.use();

                active = false;

                System.out.println(name + ": Finished working");
            }
        }
    }

    static class SharedResource {

        public synchronized void use() {
            System.out.println("Resource is being used");
        }
    }

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Worker worker1 = new Worker("Worker-1");
        Worker worker2 = new Worker("Worker-2");

        Thread t1 = new Thread(() -> worker1.work(resource, worker2));
        Thread t2 = new Thread(() -> worker2.work(resource, worker1));

        t1.start();
        t2.start();
    }
}
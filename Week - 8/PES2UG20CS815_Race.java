import java.util.*;

public class PES2UG20CS815_Race {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of runners: ");
        int numRunners = scanner.nextInt();

        Runner[] runners = new Runner[numRunners];
        for (int i = 0; i < numRunners; i++) {
            runners[i] = new Runner("Runner " + (i + 1));
            runners[i].start();
        }

        while (true) {
            Thread.sleep(1000);
            for (Runner runner : runners) {
                System.out.println(runner.getName() + " has run " + runner.getDistance() + " meters.");
                if (runner.getDistance() >= 1000) {
                    System.out.println(runner.getName() + " has finished the race!");
                    Arrays.sort(runners, Comparator.comparingInt(Runner::getDistance).reversed());
                    System.out.println("Top 3 Runners:");
                    for (int i = 0; i < 3 && i < numRunners; i++) {
                        System.out.println(
                                (i + 1) + ". " + runners[i].getName() + " with distance: " + runners[i].getDistance());
                    }
                    System.exit(0);
                }
            }
        }
    }
}

class Runner extends Thread {
    private int distance;

    public Runner(String name) {
        super(name);
        distance = 0;
    }

    public void run() {
        Random random = new Random();
        while (true) {
            distance += random.nextInt(6) + 5; 
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getDistance() {
        return distance;
    }
}

package by.milosh.task2;

import java.util.List;

public class ClerkService {
    public boolean checkQueue(List<Integer> queue) {
        VisitorQueue visitorQueue = new VisitorQueue();
        visitorQueue.initialize(queue);

        Clerk clerk = new Clerk();
        return clerk.checkQueue(visitorQueue);
    }
}

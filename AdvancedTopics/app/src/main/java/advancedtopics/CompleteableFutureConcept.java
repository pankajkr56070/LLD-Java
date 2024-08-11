package advancedtopics;

import java.util.concurrent.CompletableFuture;

public class CompleteableFutureConcept {

    public void handleSingleFuture() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello, world!";
        });
        
        future.thenAccept(result -> System.out.println(result));
    }

    public void handleMutliplesFutures() {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            // Some long-running operation
            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int result = 10; // Causes an ArithmeticException
            return result;
        });

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            // Some long-running operation
            return 20;
        });

        CompletableFuture<Void> allCompletableFutures = CompletableFuture.allOf(future1, future2, future3);

        allCompletableFutures.exceptionally(ex -> {
            System.out.println("Exception occured : " + ex.getMessage());
            return null;

        }).thenRun(() -> {
            int result1 = future1.join();
            int result2 = future2.join();
            int result3 = future3.join();
            System.out.println("result1 : " + result1 + " result2 : " + result2 + " result3 :" + result3);

        });

    }

}

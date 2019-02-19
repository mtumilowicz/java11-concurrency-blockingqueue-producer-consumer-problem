import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by mtumilowicz on 2019-02-15.
 */
class Buffer {
    private final BlockingQueue<String> words = new LinkedBlockingQueue<>(1);

    void produce(String word) {
        try {
            this.words.put(word);
        } catch (InterruptedException e) {
            // not used
        }
    }

    String consume() {
        try {
            return words.take();
        } catch (InterruptedException e) {
            // not used
        }
        
        return null;
    }
}

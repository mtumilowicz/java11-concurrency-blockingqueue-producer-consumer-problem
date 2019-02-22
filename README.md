[![Build Status](https://travis-ci.com/mtumilowicz/java11-concurrency-blockingqueue-producer-consumer-problem.svg?branch=master)](https://travis-ci.com/mtumilowicz/java11-concurrency-blockingqueue-producer-consumer-problem)

# java11-concurrency-blockingqueue-producer-consumer-problem

# preface
* https://github.com/mtumilowicz/java11-concurrency-wait-notify-producer-consumer-problem
* https://github.com/mtumilowicz/java-collections-queue
* `BlockingQueue<E> extends Queue<E>`
* additional methods
    * inserting
        * `boolean offer(E e)`
            * returns `true` if the element was added to this queue, else `false`
            * inserts the specified element into this queue if it is possible to do
              so immediately without violating capacity restrictions
            * **when using a capacity-restricted queue, this method is generally preferable 
            to `add`, which can fail to insert an element only by throwing an exception (because in
            bounded queues it is not an exceptional behaviour**)
        * `boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException`
            * returns `true` if successful, or `false` if
              the specified waiting time elapses before space is available
            * inserts the specified element into this queue, waiting up to the
              specified wait time if necessary for space to become available
        * `void put(E e) throws InterruptedException`
            * inserts the specified element into this queue, waiting if necessary for space to become available
    * removing
        * `E take()`
            * retrieves and removes the head of this queue, waiting if necessary until an element becomes available
        * `E poll(long timeout, TimeUnit unit)`
            * retrieves and removes the head of this queue, waiting up to the
              specified wait time if necessary for an element to become available
            * returns the head of this queue, or `null` if the specified waiting time elapses 
              before an element is available
    * `remainingCapacity()` - returns the number of additional elements that this queue can ideally
       (in the absence of memory or resource constraints) accept without
        blocking, or `Integer.MAX_VALUE` if there is no intrinsic limit
* usually used in a producer/consumer-like situations
* blocking queue does not allow a `null` element
* blocking queue can be bounded or unbounded
* `LinkedBlockingQueue` is one of many implementations of `BlockingQueue` interface
* Just as blocking queues lend themselves to the producer-consumer pattern,
  deques lend themselves to a related pattern called work stealing. A producerconsumer
  design has one shared work queue for all consumers; in a work stealing
  design, every consumer has its own deque. If a consumer exhausts the work in its
  own deque, it can steal work from the tail of someone else’s deque. Work stealing
  can be more scalable than a traditional producer-consumer design because workers
  don’t contend for a shared work queue; most of the time they access only their
  own deque, reducing contention. When a worker has to access another’s queue,
  it does so from the tail rather than the head, further reducing contention.
    * Work stealing is well suited to problems in which consumers are also producers—
      when performing a unit of work is likely to result in the identification of
      more work.
    * For example, processing a page in a web crawler usually results in
      the identification of new pages to be crawled.
    * When a worker identifies a new unit of work, it
      places it at the end of its own deque (or alternatively, in a work sharing design, on
      that of another worker); when its deque is empty, it looks for work at the end of
      someone else’s deque, ensuring that each worker stays busy.
      
# project description
The project is the same as https://github.com/mtumilowicz/java11-concurrency-wait-notify-producer-consumer-problem
but instead of performing synchronization by ourselves we delegate the responsibility to the `LinkedBlockingQueue`.

So, the only change is in the `Buffer` class:
```
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
```
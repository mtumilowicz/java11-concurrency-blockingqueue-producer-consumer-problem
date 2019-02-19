# java11-concurrency-blockingqueue-producer-consumer-problem

https://github.com/mtumilowicz/java11-concurrency-wait-notify-producer-consumer-problem

# preface
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
* blocking queue does not allow a null element
* blocking queue can be bounded or unbounded
* `LinkedBlockingQueue` is one of many implementations of `BlockingQueue` interface
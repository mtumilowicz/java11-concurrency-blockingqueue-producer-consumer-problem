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
        * `E poll(long timeout, TimeUnit unit)`
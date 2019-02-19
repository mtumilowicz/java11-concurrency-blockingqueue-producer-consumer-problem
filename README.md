# java11-concurrency-blockingqueue-producer-consumer-problem

https://github.com/mtumilowicz/java11-concurrency-wait-notify-producer-consumer-problem

# preface

## queue
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html
* `interface Queue<E> extends Collection<E>`
* methods
    * inserting
        * `boolean add(E e)`
        * `boolean offer(E e)`
    * removing
        * `E remove()`
        * `E poll()`
    * examining
        * `E element()`
        * `E peek()`
* for every action we have two methods, because they deal
with extreme cases differently
* what can be extreme cases? for example examining element
when queue is empty or adding element when queue is full
* summary
    |   |throws exception   |returns special value   |
    |---|---|---|
    |insert   |`add(e)`   |`offer(e)`   |
    |remove   |`remove()`   |`poll()`   |
    |examine   |`element()`   |`peek()`   |
* the latter form of the insert operation is designed 
specifically for use with capacity-restricted Queue 
implementations
* in most implementations, insert operations cannot fail
* offer method is designed for use when failure is a normal, 
rather than exceptional occurrence, for example, in 
fixed-capacity (or "bounded") queues
* queue implementations generally do not allow insertion of 
`null` elements (`nulls` in queues make no sense)
* implementations generally do not define element-based 
versions of methods `equals` and `hashCode` (for the same 
elements we may have different ordering properties, so 
element-based equality is not always well defined)
## blocking queue
* `BlockingQueue<E> extends Queue<E>`
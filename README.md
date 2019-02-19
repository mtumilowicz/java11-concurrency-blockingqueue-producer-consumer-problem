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

## blocking queue
* `BlockingQueue<E> extends Queue<E>`
package org.study.비동기

import org.study.동기.pourIntoCup
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

// 점원이 세명이다.
private val executor = Executors.newFixedThreadPool(3)

fun grindBeanAsync(
    beanType: String,
    callback: (String) -> Unit
){
    executor.submit {
        Thread.sleep(1000)
        callback("갈린 $beanType 원두")
    }
}

fun brewCoffeeAsync(
    ground: String,
    callback: (String) -> Unit
){
    executor.submit {
        Thread.sleep(1000)
        callback("${ground}으로 만든 커피")
    }
}

fun pourInCupAsync(
    coffee: String,
    callback: (String) -> Unit
){
    executor.submit {
        Thread.sleep(1000)
        callback("[cup] $coffee")
    }
}

fun grindBeansFuture(beanType: String): CompletableFuture<String> =
    CompletableFuture.supplyAsync({
        Thread.sleep(1000)
        "갈린 #$beanType 원두"
    }, executor)

fun brewCoffeeFuture(ground: String): CompletableFuture<String> =
    CompletableFuture.supplyAsync({
        Thread.sleep(1000)
        "${ground}으로 만든 커피"
    }, executor)

fun pourInCupFuture(coffee: String): CompletableFuture<String> =
    CompletableFuture.supplyAsync({
        Thread.sleep(1000)
        "[cup] $coffee"
    }, executor)

fun main(){
    val orders = listOf("주문1", "주문2", "주문3", "주문2", "주문3", "주문2", "주문3", "주문2", "주문3", "주문2", "주문3")
    val start = System.currentTimeMillis()

    val futures = orders.map {order ->
        grindBeansFuture(order)
            .thenCompose { brewCoffeeFuture(it) }
            .thenCompose { pourInCupFuture(it) }
            .thenApply { result -> "[$order] $result" }
    }
    futures.forEach{println(it.get())}
    executor.shutdown()
    println("총 소요시간: ${System.currentTimeMillis() - start}ms")
}

//fun main(){
//    val StartTime = System.currentTimeMillis()
//
//    // 콜백 지옥 시작
//    grindBeanAsync("콜롬비아"){ground ->
//        brewCoffeeAsync(ground) {coffee ->
//            pourInCupAsync(coffee){result ->
//                println(result)
//                println("총 소요시간: ${System.currentTimeMillis() - StartTime}ms")
//                executor.shutdown()
//            }
//        }
//    }
//    Thread.sleep(4000)
//}
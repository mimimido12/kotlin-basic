package org.study.동기

/*
    점원이 커피 머신 앞에서  대기를 해야될겁니다. Thread.sleep
*/

// 커피 제조 단계별로 함수
fun grindBeans(beanType: String): String {
    Thread.sleep(1000)
    return "갈린 $beanType 원두"
}

fun brewCoffee(gronundBeans: String): String {
    Thread.sleep(1000)
    return "${gronundBeans}으로 만든 커피"
}

fun pourIntoCup(coffee: String): String {
    Thread.sleep(1000)
    return "[cup] $coffee"
}

//fun main(){
//    val startTime = System.currentTimeMillis()
//
//    // 순차적으로 실행
//    val ground = grindBeans("에티오피아")
//    val coffee = brewCoffee(ground)
//    val result = pourIntoCup(coffee)
//
//    println(result)
//    println("총 소요 시간: ${System.currentTimeMillis() - startTime}ms")
//}

fun main(){
    val startTime = System.currentTimeMillis()
    val orders = listOf("주문1","주문2","주문3")

    // 순차적으로 실행
    orders.forEach {
        order ->
        val ground = grindBeans(order)
        val coffee = brewCoffee(ground)
        val result = pourIntoCup(coffee)
        println("[$order] $result")
    }



    println("총 소요 시간: ${System.currentTimeMillis() - startTime}ms")
}
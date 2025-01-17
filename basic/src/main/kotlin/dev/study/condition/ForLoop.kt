package dev.study.condition

fun main(){
    // 범위 연산자 .. 앞과 뒤 숫자를 모두 포함

    for(i in 10..30 step 2){
        println(i)
    }

    // until
    for(i in 0 until 10 step 2){
        println(i)
    }

    // 역순으로 찍어라
    for(i in 10 downTo 0 step 2){
        println(i)
    }

    val array = arrayOf("kotlin","python","kotlin","java")
    for(i in array){
        println(i)
    }

    for(i in array.indices){
        println(i)
    }

    // 요것도 옛날방식(코틀린)
    for((i, name) in array.withIndex()){
        println("$i : $name")
    }
    array.forEachIndexed{i,name->println("$i : $name")}

    val 나라 = mapOf(
        "서울" to "한국"
        ,"동경" to "일본"
    )

    for(entry in 나라.entries){
        println("${entry.key}, ${entry.value}")
    }

    나라.forEach{(capital, country)->
        println("$country, $capital")
    }

}
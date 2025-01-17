package dev.study.condition

fun main(){
    val day = 2
    val result = when(day){
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        5 -> "금요일"
        6 -> "토요일"
        7 -> "일요일"
        else -> "요일을 잘 못 입력하셨습니다."
    }




    println(result)
}
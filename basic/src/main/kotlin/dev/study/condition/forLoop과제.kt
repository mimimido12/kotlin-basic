package dev.study.condition

/*
- 범위 연산을 사용해서 다음 함수를 구현해라
- 정수 n 을 인수로 받고, 0부터 n까지 모든 양의 정수의 제곱을 더한 값을 반환하는 함수
- 정수 n을 인수로 받고, 0부터 n까지 모든 짝수의 합을 반환하는 함수
- start, end, step 세 개의 정수를 받아, start부터 end까지 step씩 감소하는 모습을 보여주는 문자열을 반환하는 함수
- 시작코드는 다음과 같다
*/

// 정수 n 을 인수로 받고, 0부터 n까지 모든 양의 정수의 제곱을 더한 값을 반환하는 함수
fun calculateSumOfSquares(n: Int): Int {
    var sum = 0
    for (i in 0..n){
        sum += i * i
    }
    return sum
}

// 정수 n을 인수로 받고, 0부터 n까지 모든 짝수의 합을 반환하는 함수
fun caculateSumOfEven(n: Int): Int {
    var sum = 0
    for (i in 0..n step 2){
        sum += i
    }
    return sum
}

// start, end, step 세 개의 정수를 받아, start부터 end까지 step씩 감소하는 모습을 보여주는 문자열을 반환하는 함수
fun countDownByStep(
    start: Int,
    end: Int,
    step: Int,
): String {
    var str:String? = ""
    for (i in start..end step step){
        str += i.toString()
    }
    return str?:""
}
fun main(){
    println(calculateSumOfSquares(10))
    println(caculateSumOfEven(20))
    println(countDownByStep(30,2,3))
}
//package dev.study
//
//// 가장 기본적인 함수 선언 스타일
////fun sum(a: Int, b: Int): Int {
////    return a + b
////}
//
//// 표현식 스타일
//fun sum2(a: Int, b: Int): Int = a + b
//
//// 표현식 + 반환 타입 삭제
//fun sum3(a: Int, b: Int) = a + b
//
//// 몸통이 있는 함수의 반환타입을 제거하면 컴파일 오류가 발생한다.
////fun sum4(a: Int, b: Int) {
////    return a + b
////}
//
//fun sum5(a: Int, b: Int) {
//    println("$a + $b")
//}
//
//fun greeting(message: String = "Hello World") {
//    println(message)
//}
//
//fun log(level:String = "INFO", message:String){
//    println("$level: $message")
//}
//
//// 고차 함수
//// - 함수를 매개변수로 받거나 반환
//
//fun calculator(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
//    return operation(a, b)
//}
//
//fun main(){
//
////    log(message = "인포로그")
////    log(level = "DEBUG", message = "디버그 로그")
////    log( "DEBUG",  "워닝 로그")
////    log( "DEBUG", message = "에러 로그")
//    val square:(Int) -> Int = { it * it }
//    println(square(3))
//
//    println(calculator(4, 6){x,y -> x + y})
//
//}
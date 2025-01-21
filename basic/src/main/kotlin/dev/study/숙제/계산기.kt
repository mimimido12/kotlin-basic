package dev.study.숙제

import java.io.BufferedReader
import java.io.InputStreamReader



/**
 * 클래스 Calculator를 만들고 덧셈, 뺄셈, 곱셈, 나눗셈 메서드를 만들고,
 * 각 메서드가 호출될 때 결과를 출력하시면 됩니다.
 * 단, 함수 형태는 고차함수로 대체 할 수 있으면 좋겠습니다.
 */
fun main(){
    var isbool = true
    // https://coding-ga-ding.tistory.com/226 (코틀린 값 입력 참조)
    val br = BufferedReader(InputStreamReader(System.`in`))

    fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }

     while(isbool){
         println("1.더하기 2.빼기 3.곱하기 4.나누기 5.프로그램 종료")
         val choice = br.readLine().toInt()
         if(choice in 1..4){
             println("a 값 입력.")
             val a = br.readLine().toInt()
             println("b 값 입력.")
             val b = br.readLine().toInt()
             val result = when(choice) {
                 1 -> "$a + $b = ${calculate(a, b){ x, y -> x + y }}"
                 2 -> "$a - $b = ${calculate(a, b){ x, y -> x - y }}"
                 3 -> "$a * $b = ${calculate(a, b){ x, y -> x * y }}"
                 4 -> "$a / $b = ${calculate(a, b){ x, y -> x / y }}"
                 else -> continue
             }
             println(result)
         }else if(choice == 5){
             isbool = false
             println("프로그램 종료")
         }else{
             println("잘 못 된 선택입니다.")
         }


    }





}
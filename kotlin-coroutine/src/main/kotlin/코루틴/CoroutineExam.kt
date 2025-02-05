package org.study.코루틴

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// data class
data class User(val id: Int, val name:String)
data class Post(val userId: Int, val content: String)
data class UserWithPosts(val user: User, val posts: List<Post>)

// 가짜 api 호출 함수
suspend fun  getUser(): User {
    delay(1000)
    return User(1,"Kotlin Admin")
}

suspend fun  getPosts(): List<Post> {
    delay(1000)
    return listOf(
        Post(1,"코루틴 강의 노트"),
        Post(1,"동시성 프로그래밍 정리"),
    )
}

suspend fun  fetchData() = coroutineScope {
    val user = async { getUser() }
    val posts = async { getPosts() }
    UserWithPosts(user.await(), posts.await())
}

fun main() = runBlocking {
    // 사용자 데이터 가져오기 테스트
    val fetchTime = measureTimeMillis {
        val result = fetchData()
        println("""
            [사용자 데이터 조회 결과]
            사용자 : ${result.user.name}
            게시물 수: ${result.posts.size}
            첫 게시물: ${result.posts.first().content}
        """.trimIndent())
    }
    println("데이터 조회시간  $fetchTime ms ")
}





package org.study.코루틴

import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis

fun downloadImage(url:String): String{
    Thread.sleep(3000)
    return "이미지 데이터: $url"
}

fun saveToDisk(image: String){
    Thread.sleep(2000)
    println("저장완료: ${image.take(15)}...")
}

// 동기 버전
fun downloadSync(urls: List<String>){
    urls.forEach {url ->
        val image = downloadImage(url)
        saveToDisk(image)
    }
}

// 비동기 버전
fun downloadAsync(urls: List<String>){
    val executor = Executors.newFixedThreadPool(urls.size)
    val futures = urls.map{ url ->
        executor.submit{
            val image = downloadImage(url)
            saveToDisk(image)
        }
    }
    futures.forEach {
        it.get()
    }
    executor.shutdown()
}

suspend fun downloadImageAsync(url: String): String {
    delay(3000) 
    return "이미지 데이터: $url"
}

suspend fun saveToDiskAsync(image: String) {
    delay(2000)
    println("저장완료: ${image.take(15)}...")
}

suspend fun downloadWithCoroutines(urls: List<String>) = coroutineScope {
    urls.map { url ->
        launch {
            val image = downloadImageAsync(url)
            saveToDiskAsync(image)
        }
    }.joinAll() // 모든 작업이 끝날 때까지 대기
}


fun main(){
    //이미지 다운로드 테스트
    val urls = listOf("url1","url2","url3")

    // 동기버전
    val syncTime = measureTimeMillis {
        downloadSync(urls)
    }
    println("동기 다운로드시간: $syncTime ms")

    // 비동기 버전
    val asyncTime = measureTimeMillis {
        downloadAsync(urls)
    }

    println("비동기 다운로드시간: $asyncTime ms")

    // 코루틴 버전
    runBlocking {
        val coroutineTime = measureTimeMillis {
            downloadWithCoroutines(urls)
        }
        println("코루틴 다운로드 시간: $coroutineTime ms")
    }

}













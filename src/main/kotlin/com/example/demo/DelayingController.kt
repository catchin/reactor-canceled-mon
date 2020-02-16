package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.Duration


@RestController
class DelayingController {
    @GetMapping("/")
    fun delayedResponse(): Mono<String> {
        return Mono.just("got it")
                .delayElement(Duration.ofSeconds(10))
                .log()
    }
}

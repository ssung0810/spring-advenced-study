package hello.advenced.app.v1

import hello.advenced.trace.hellotrace.HelloTraceV1
import org.springframework.stereotype.Repository
import java.lang.Exception
import java.lang.Thread.sleep

@Repository
class OrderRepositoryV1(
    private val trace: HelloTraceV1
) {
    fun save(itemId: String) {
        val status = trace.begin("OrderRepository.request()")

        try {
            // 저장 로직
            if(itemId == "ex") {
                throw IllegalStateException("예외 발생!!")
            }

            sleep(1000)
            trace.end(status)
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e // 예외를 꼭 다시 던져주어야 한다.
        }
    }
}

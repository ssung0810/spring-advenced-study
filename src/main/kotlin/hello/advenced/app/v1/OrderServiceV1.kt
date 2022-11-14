package hello.advenced.app.v1

import hello.advenced.trace.hellotrace.HelloTraceV1
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class OrderServiceV1(
    private val orderRepository: OrderRepositoryV1,
    private val trace: HelloTraceV1
) {
    fun orderItem(itemId: String) {
        val status = trace.begin("OrderService.request()")

        try {
            orderRepository.save(itemId)
            trace.end(status)
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e // 예외를 꼭 다시 던져주어야 한다.
        }
    }
}
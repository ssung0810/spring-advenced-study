package hello.advenced.app.v3

import hello.advenced.trace.logtrace.LogTrace
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class OrderServiceV3(
    private val orderRepository: OrderRepositoryV3,
    private val trace: LogTrace
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

package hello.advenced.app.v2

import hello.advenced.trace.TraceId
import hello.advenced.trace.hellotrace.HelloTraceV2
import org.springframework.stereotype.Service

@Service
class OrderServiceV2(
    private val orderRepository: OrderRepositoryV2,
    private val trace: HelloTraceV2
) {
    fun orderItem(traceId: TraceId, itemId: String) {
        val status = trace.beginSync(traceId, "OrderService.request()")

        try {
            orderRepository.save(status.traceId, itemId)
            trace.end(status)
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e // 예외를 꼭 다시 던져주어야 한다.
        }
    }
}

package hello.advenced.app.v1

import hello.advenced.trace.hellotrace.HelloTraceV1
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
class OrderControllerV1(
    private val orderService: OrderServiceV1,
    private val trace: HelloTraceV1
) {
    @GetMapping("/v1/request")
    fun request(itemId: String): String {
        val status = trace.begin("OrderController.request()")

        try {
            orderService.orderItem(itemId)
            trace.end(status)
            return "ok"
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e // 예외를 꼭 다시 던져주어야 한다.
        }
    }
}

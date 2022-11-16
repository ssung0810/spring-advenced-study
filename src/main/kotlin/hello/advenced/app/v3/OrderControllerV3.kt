package hello.advenced.app.v3

import hello.advenced.trace.logtrace.LogTrace
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderControllerV3(
    private val orderService: OrderServiceV3,
    private val trace: LogTrace
) {
    @GetMapping("/v3/request")
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

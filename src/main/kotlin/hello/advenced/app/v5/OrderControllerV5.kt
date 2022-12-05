package hello.advenced.app.v5

import hello.advenced.trace.callback.TraceCallBack
import hello.advenced.trace.callback.TraceTemplate
import hello.advenced.trace.logtrace.LogTrace
import hello.advenced.trace.template.AbstractTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderControllerV5(
    private val orderService: OrderServiceV5,
    private val trace: LogTrace
) {
    val template = TraceTemplate(trace)

    @GetMapping("/v5/request")
    fun request(itemId: String): String {
        return template.execute("OrderController.request()") {
            orderService.orderItem(itemId)
            "ok"
        }
    }
}

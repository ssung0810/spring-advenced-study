package hello.advenced.app.v5

import hello.advenced.trace.callback.TraceCallBack
import hello.advenced.trace.callback.TraceTemplate
import hello.advenced.trace.logtrace.LogTrace
import hello.advenced.trace.template.AbstractTemplate
import org.springframework.stereotype.Service

@Service
class OrderServiceV5(
    private val orderRepository: OrderRepositoryV5,
    private val trace: LogTrace
) {
    val template = TraceTemplate(trace)

    fun orderItem(itemId: String) {
        template.execute("OrderService.request()") { orderRepository.save(itemId) }
    }
}

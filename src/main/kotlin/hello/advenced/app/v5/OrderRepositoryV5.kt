package hello.advenced.app.v5

import hello.advenced.trace.callback.TraceTemplate
import hello.advenced.trace.logtrace.LogTrace
import hello.advenced.trace.template.AbstractTemplate
import org.springframework.stereotype.Repository
import java.lang.Thread.sleep

@Repository
class OrderRepositoryV5(
    private val trace: LogTrace
) {
    fun save(itemId: String) {
        val template = TraceTemplate(trace)

        template.execute("OrderRepository.request()") {
            if(itemId == "ex") {
                throw IllegalStateException("예외 발생!!")
            }

            sleep(1000)
        }
    }
}

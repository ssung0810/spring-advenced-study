package hello.advenced.app.v4

import hello.advenced.trace.logtrace.LogTrace
import hello.advenced.trace.template.AbstractTemplate
import org.springframework.stereotype.Repository
import java.lang.Thread.sleep

@Repository
class OrderRepositoryV4(
    private val trace: LogTrace
) {
    fun save(itemId: String) {
        val template = object : AbstractTemplate<Unit>(trace) {
            override fun call() {
                // 저장 로직
                if(itemId == "ex") {
                    throw IllegalStateException("예외 발생!!")
                }

                sleep(1000)
            }
        }
        return template.execute("OrderRepository.request()")
    }
}

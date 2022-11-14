package hello.advenced.app.v2

import hello.advenced.trace.TraceId
import hello.advenced.trace.hellotrace.HelloTraceV1
import hello.advenced.trace.hellotrace.HelloTraceV2
import org.springframework.stereotype.Repository
import java.lang.Exception
import java.lang.Thread.sleep

@Repository
class OrderRepositoryV2(
    private val trace: HelloTraceV2
) {
    fun save(traceId: TraceId, itemId: String) {
        val status = trace.beginSync(traceId, "OrderRepository.request()")

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

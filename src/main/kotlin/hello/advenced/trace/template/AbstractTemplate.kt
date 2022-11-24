package hello.advenced.trace.template

import hello.advenced.trace.TraceStatus
import hello.advenced.trace.logtrace.LogTrace

abstract class AbstractTemplate<T>(
    private val trace: LogTrace
) {
    fun execute(message: String): T {
        var status: TraceStatus? = null
        try {
            status = trace.begin(message)

            // 로직 호출
            val result: T = call()

            trace.end(status)
            return result
        } catch (e: Exception) {
            trace.exception(status!!, e)
            throw e
        }
    }

    protected abstract fun call(): T
}
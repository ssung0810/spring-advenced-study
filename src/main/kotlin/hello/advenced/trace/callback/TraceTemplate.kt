package hello.advenced.trace.callback

import hello.advenced.trace.TraceStatus
import hello.advenced.trace.logtrace.LogTrace

class TraceTemplate(
    private val trace: LogTrace
) {
    fun <T> execute(message: String, callback: TraceCallBack<T>): T {
        var status: TraceStatus? = null

        try {
            status = trace.begin(message)

            val result = callback.call()

            trace.end(status)
            return result
        } catch (e: Exception) {
            trace.exception(status!!, e)
            throw e
        }
    }
}
package hello.advenced.trace.hellotrace

import hello.advenced.trace.TraceId
import hello.advenced.trace.TraceStatus
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class HelloTraceV1 {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    private val START_PREFIX: String = "-->"
    private val COMPLETE_PREFIX = "<--"
    private val EX_PREFIX = "<X--"

    fun begin(message: String): TraceStatus {
        val traceId = TraceId(TraceId.createId())
        val startTimeMs = System.currentTimeMillis()

        logger.info("[${traceId.id}] ${addSpace(COMPLETE_PREFIX, traceId.level)}${message}")

        return TraceStatus(traceId, startTimeMs, message)
    }

    fun end(status: TraceStatus) {
        complete(status, null)
    }

    fun exception(status: TraceStatus, e: Exception) {
        complete(status, e)
    }

    private fun complete(status: TraceStatus, e: Exception?) {
        val stopTimeMs = System.currentTimeMillis()
        val resultTimeMs = stopTimeMs - status.startTimeMs
        val traceId = status.traceId
        if (e == null) {
            logger.info("[${traceId.id}] ${addSpace(COMPLETE_PREFIX, traceId.level)}${status.message} time=${resultTimeMs}ms")
        } else {
            logger.info("[${traceId.id}] ${addSpace(EX_PREFIX, traceId.level)}${status.message} time=${resultTimeMs}ms ex=$e")
        }
    }

    private fun addSpace(prefix: String, level: Int): String {
        val sb = StringBuilder()
        for(i in 1..level) {
            if(i == level) sb.append("|${prefix}") else sb.append("|   ")
        }

        return sb.toString()
    }
}
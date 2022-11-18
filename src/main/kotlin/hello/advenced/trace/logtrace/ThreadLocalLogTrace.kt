package hello.advenced.trace.logtrace

import hello.advenced.trace.TraceId
import hello.advenced.trace.TraceStatus
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ThreadLocalLogTrace : LogTrace {
    private val logger = LoggerFactory.getLogger(this::class.java)

    private val START_PREFIX: String = "-->"
    private val COMPLETE_PREFIX = "<--"
    private val EX_PREFIX = "<X--"

    private val traceIdHolder: ThreadLocal<TraceId?> = ThreadLocal()

    override fun begin(message: String): TraceStatus {
        syncTraceId()
        val traceId = traceIdHolder.get()!!
        val startTimeMs = System.currentTimeMillis()

        logger.info("[${traceId.id}] ${addSpace(START_PREFIX, traceId.level)}${message}")

        return TraceStatus(traceId, startTimeMs, message)
    }

    override fun end(status: TraceStatus) {
        complete(status, null)
    }

    override fun exception(status: TraceStatus, e: Exception) {
        complete(status, e)
    }

    private fun syncTraceId() {
        val traceId = traceIdHolder.get()
        if (traceId == null) {
            traceIdHolder.set(TraceId(TraceId.createId()))
        } else {
            traceIdHolder.set(traceId.createNextId())
        }
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

        releaseTraceId()
    }

    private fun releaseTraceId() {
        val traceId = traceIdHolder.get()!!
        if (traceId.isFirstLevel()) {
            traceIdHolder.remove()
        } else {
            traceIdHolder.set(traceId.createPreviousId())
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

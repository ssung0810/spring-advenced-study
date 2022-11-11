package hello.advenced.trace

import java.util.UUID

class TraceId(
    var id: String,
    private val level: Int
) {
    init {
        id = createId(id)
    }

    private fun createId(id: String): String {
        return UUID.randomUUID().toString().substring(0, 8)
    }

    fun createNextId(): TraceId {
        return TraceId(id, level+1)
    }
}
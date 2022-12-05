package hello.advenced

import org.slf4j.LoggerFactory

fun Any.logInfo(message: String) {
    val logger = LoggerFactory.getLogger(this::class.java)
    logger.info(message)
}

package hello.advenced.trace.threadlocal.code

import org.slf4j.LoggerFactory
import java.lang.Thread.sleep

class FieldService {
    private val logger = LoggerFactory.getLogger(this::class.java)
    private var storedName: String = ""

    fun logic(name: String): String {
        logger.info("์ ์ฅ name -> storedName : $storedName")
        storedName = name
        sleep(1000)
        logger.info("์กฐํ storedName : $storedName")
        return storedName
    }
}

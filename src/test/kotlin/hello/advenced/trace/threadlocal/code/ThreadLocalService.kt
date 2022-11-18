package hello.advenced.trace.threadlocal.code

import org.slf4j.LoggerFactory
import java.lang.Thread.sleep

class ThreadLocalService {
    private val logger = LoggerFactory.getLogger(this::class.java)
    private val storedName: ThreadLocal<String> = ThreadLocal()

    fun logic(name: String): String {
        logger.info("저장 name -> storedName : ${storedName.get()}")
        storedName.set(name)
        sleep(1000)
        logger.info("조회 storedName : ${storedName.get()}")
        return storedName.get()
    }
}

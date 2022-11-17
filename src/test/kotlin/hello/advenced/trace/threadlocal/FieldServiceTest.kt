package hello.advenced.trace.threadlocal

import hello.advenced.trace.threadlocal.code.FieldService
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import java.lang.Thread.sleep

class FieldServiceTest {
    private val logger = LoggerFactory.getLogger(this::class.java)

    private val fieldService = FieldService()

    @Test   // 동시성 문제 x
    fun field() {
        var userA = Runnable() {
            fieldService.logic("userA")
        }
        var userB = Runnable() {
            fieldService.logic("userB")
        }

        val threadA = Thread(userA)
        threadA.name = "Thread-A"
        val threadB = Thread(userB)
        threadB.name = "Thread-B"

        threadA.start()
        sleep(2000)
        threadB.start()
        sleep(3000)

        logger.info("main exit")
    }

    @Test   // 동시성 문제 o
    fun field2() {
        var userA = Runnable() {
            fieldService.logic("userA")
        }
        var userB = Runnable() {
            fieldService.logic("userB")
        }

        val threadA = Thread(userA)
        threadA.name = "Thread-A"
        val threadB = Thread(userB)
        threadB.name = "Thread-B"

        threadA.start()
        sleep(100)
        threadB.start()
        sleep(3000)

        logger.info("main exit")
    }
}
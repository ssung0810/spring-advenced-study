package hello.advenced.trace.strategy

import hello.advenced.logInfo
import hello.advenced.trace.strategy.code.template.CallBack
import hello.advenced.trace.strategy.code.template.TimeLogTemplate
import org.junit.jupiter.api.Test

class TemplateCallbackTest {
    @Test
    fun callbackV1() {
        val template = TimeLogTemplate()
        template.execute(object : CallBack {
            override fun call() {
                logInfo("비즈니스 로직1 실행")
            }
        })

        template.execute(object : CallBack {
            override fun call() {
                logInfo("비즈니스 로직2 실행")
            }
        })
    }
}
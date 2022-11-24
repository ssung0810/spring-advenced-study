package hello.advenced.trace.template

import hello.advenced.trace.template.code.AbstractTemplate
import hello.advenced.trace.template.code.SubClassLogic1
import hello.advenced.trace.template.code.SubClassLogic2
import org.junit.jupiter.api.Test

class TemplateMethodTest {
    @Test
    fun templateMethodV0() {
        logic1()
        logic2()
    }

    @Test
    fun templateMethodV1() {
        val template1 = SubClassLogic1()
        template1.execute()
        val template2 = SubClassLogic2()
        template2.execute()
    }

    @Test
    fun templateMethod2() {
        val template1 = object : AbstractTemplate() {
            override fun call() {
                println("비즈니스 로직1 실행")
            }
        }

        val template2 = object : AbstractTemplate() {
            override fun call() {
                println("비즈니스 로직2 실행")
            }
        }

        template1.execute()
        template2.execute()
    }

    private fun logic1() {
        val startTime = System.currentTimeMillis()
        // 비즈니스 로직 실행
        println("비즈니스 로직1 실행")
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        println("resultTime = $resultTime")
    }

    private fun logic2() {
        val startTime = System.currentTimeMillis()
        // 비즈니스 로직 실행
        println("비즈니스 로직2 실행")
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        println("resultTime = $resultTime")
    }
}

package hello.advenced.trace.template.code

abstract class AbstractTemplate {
    fun execute() {
        val startTime = System.currentTimeMillis()
        // 비즈니스 로직 실행
        call()
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        println("resultTime = $resultTime")
    }

    protected abstract fun call()
}
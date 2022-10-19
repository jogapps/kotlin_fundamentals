import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class CalculatorSpek : Spek({
    var calculator : Calculator? = null

    beforeEachTest {
        calculator = Calculator(NullResult())
    }

    describe("the calculator") {
        it("should add two numbers") {
            var result = calculator?.add(12, 13)
            assertEquals(25, result)
        }

        it("should accumulate two numbers") {
            calculator?.accumulate(2)
            calculator?.accumulate(3)
            assertEquals(5, calculator?.total)
        }
    }

    describe("the output") {
        val result : Result = mock()
        val calculator = Calculator(result)
        it("should write the output amount") {
            calculator.accumulate(23)
            verify(result).write(23)
        }
    }
})
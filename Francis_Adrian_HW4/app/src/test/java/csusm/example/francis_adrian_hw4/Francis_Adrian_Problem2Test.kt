package csusm.example.francis_adrian_hw4

import org.junit.Assert.*
import org.junit.Test

class Francis_Adrian_Problem2Test {

    val objectUnderTest = Francis_Adrian_Problem2()

    @Test
    fun testingResultOfLowerEndPointerLessThan() {
        //testing for result in last pointer being less that the first pointer
        assertEquals(
            -1,objectUnderTest.searchR(
                arrayOf("test", "", "how", "hello", "", "no"),
                str = "test",
                first = 1,
                last = 0
            )
        )
    }

    @Test
    fun testingMidLocationWhenStrIsEqualToMid(){
        assertEquals(
            2,objectUnderTest.searchR(
                arrayOf("no", " ", "test", " ", "how"),
                str = "test",
                first = 0,
                last = 4
            )
        )
    }

    @Test
    fun searchingStrFromRight(){
        //tests if program is hitting rightmost search returns positive number
        assertEquals(
            4,objectUnderTest.searchR(
                arrayOf("no", "", "how", "", "test"),
                str = "test",
                first = 0,
                last = 4
            )
        )
    }

    @Test
    fun searchingStrFromLeft(){
        //tests if program is hitting leftmost search returns 0
        assertEquals(
            0,objectUnderTest.searchR(
                arrayOf("AAA", "", "BB", "", "C"),
                str = "AAA",
                first = 0,
                last = 4
            )
        )
    }

    @Test
    fun testingResultofLowerEndPointerGreater(){
        assertEquals(
            4,objectUnderTest.searchR(
                arrayOf("no", " ", "how", " ", "test"),
                str = "test",
                first = 0,
                last = 4
            )
        )
    }

    @Test
    fun testingIfSearchIsNull(){
        //testing result if Strings array and str is equal to null
        assertEquals(objectUnderTest.search(null,null),-1)
    }

    @Test
    fun testingSearchRight(){
        assertEquals(
            4, objectUnderTest.search(
                arrayOf("no", " ", "how", " ", "test"),
                str = "test"
            )
        )
    }

    @Test
    fun testingSearchMid(){
        assertEquals(
            2, objectUnderTest.search(
                arrayOf("no", " ", "how", " ", "test"),
                str = "how"
            )
        )
    }

    @Test
    fun testingsearchLeft(){
        assertEquals(
            0, objectUnderTest.search(
                arrayOf("AAA", " ", "BB", " ", "C"),
                str = "AAA"
            )
        )
    }

    @Test
    fun testingIfSearchDNE(){
        assertEquals(
            -1, objectUnderTest.search(
                arrayOf("no", " ", "how", " ", "test"),
                str = "DNE"
            )
        )
    }
}

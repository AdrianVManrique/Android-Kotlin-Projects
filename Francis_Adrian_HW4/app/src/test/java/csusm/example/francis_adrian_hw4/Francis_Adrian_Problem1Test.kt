package csusm.example.francis_adrian_hw4

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

class Francis_Adrian_Problem1Test {

    val objectUnderTest = Francis_Adrian_Problem1()

    @Test
    fun testingStackPointerIndex(){
        assertEquals(-1,objectUnderTest.stackPointer[0])
        assertEquals(-1, objectUnderTest.stackPointer[1])
        assertEquals(-1,objectUnderTest.stackPointer[2])
    }

    @Test
    fun testingBufferSize(){
        assertEquals(300, objectUnderTest.buffer.size)
    }

    @Test
    fun testingStackSizeInitialization(){
        //testing creation of stackSize
        assertEquals(100, objectUnderTest.stackSize)
    }
   @Test
   fun testingisEmpty(){
       //testing if 2nd array is equal is empty
       assertTrue(objectUnderTest.isEmpty(1))
   }

   @Test
   fun testingabsTopOfStack(){
       //testing index for top of stack in second array
       assertEquals(99,objectUnderTest.absTopOfStack(1))
   }

    @Test
    fun testingpeek(){
        //pushing value into 2nd array, searching for value in top of stack
        objectUnderTest.push(2, 2)
        assertEquals(2, objectUnderTest.peek(2))
    }

    @Test
    fun testingPeekafterPushPop(){

        //testing top stack after value is removed
        objectUnderTest.push(2,100)
        objectUnderTest.push(2,59)
        objectUnderTest.push(2,73)
        objectUnderTest.pop(2)
        assertEquals(59, objectUnderTest.peek(2))

    }

    @Test
    fun testingPopException(){
        //testing for exception for pop of empty stack
        val exception = assertThrows(Exception::class.java){
            objectUnderTest.pop(0)
        }
        assertEquals(exception.message,"Trying to pop an empty stack.")
    }

    @Test
    fun testingPushException(){
        //testing for thrown exception after reaching max size
        objectUnderTest.stackSize = 0;
        val exception = assertThrows(Exception::class.java){
            objectUnderTest.push(1,50)
        }
        assertEquals(exception.message, "Out of space.")
    }

    @Test
    fun testingPeekInEmptyArray(){
        //checking if value is initialized to 0 in empty array
        assertNotNull(objectUnderTest.peek(1))
        assertEquals(0, objectUnderTest.peek(1))
    }

    @Test
    fun testingIsEmptyFalse(){
        //testing if isEmpty detects value in array
        objectUnderTest.push(2,99)
        assertFalse(objectUnderTest.isEmpty(2))
    }
}
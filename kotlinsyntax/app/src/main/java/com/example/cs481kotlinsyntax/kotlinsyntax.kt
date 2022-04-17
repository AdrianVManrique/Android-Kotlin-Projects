package com.example.cs481kotlinsyntax
// ref: https://kotlinlang.org/docs/basic-syntax.html

/* This is a block comment
   on multiple lines. */

//An entry point of a Kotlin application is the main function.
fun main() {
    printpractice()
    println(sum(2,3))
    println(sumretinfer(2,3))
    println(printSum(2,3))
    println(printSumRetOmit(2,3))
    variables()
    println(ifmaxOf(2,3))
    println(multipleifelse(40))
    println(maxOfexpress(2,3))
    arraylist()
    collection()
    iterateover()
    forloop()
    whileloop()
    whenexpression(2,3,3)
    checkifnumberinrange()
    checkifnumberoutofrange()
    nullval()
    nonnull()
    nullcheck()
    nullsafeoperator()
    println("The perimeter is ${Rectangle(5.0, 2.0).perimeter}")
    print(sumwithlambda(5, 6, lambdafunc)) // passing lambda to higher order
    //higher order function accept func as parameter and can return a func, lamda a function without name
}

/*
// Another form of main accepts a variable number of String arguments. menu Run -> Edit Configurations -> Program arguments
fun main(args: Array<String>) {
    println(args.contentToString()
} */

fun printpractice(){
    //print prints its argument to the standard output.
    print("Hello ")
    print("world!")
    //println prints its arguments and adds a line break, so that the next thing you print appears on the next line.
    println("Hello world!")
    println(42)
}

//A function with two Int parameters and Int return type.
fun sum(a: Int, b: Int): Int {
    return a + b
}

//A function body can be an expression. Its return type is inferred.
fun sumretinfer(a: Int, b: Int) = a + b


//A function that returns no meaningful value.
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

//Unit return type can be omitted.
fun printSumRetOmit(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun variables(){
    //Read-only local variables are defined using the keyword val. They can be assigned a value only once.
    val a: Int = 1  // immediate assignment
    val b = 2   // `Int` type is inferred
    val c: Int  // Type required when no initializer is provided
    c = 3       // deferred assignment
   // Variables that can be reassigned use the var keyword.
    var x = 5 // `Int` type is inferred
    println(x)
    x += 1
    println(x)
}

fun ifmaxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

//In Kotlin, if can also be used as an expression.
fun maxOfexpress(a: Int, b: Int) = if (a > b) a else b

fun multipleifelse(number: Int):String{
    val result = if (number < 0) {
        " less than 0"
    } else if (number in 0..9) {
        "In between 0 to 9"
    } else if (number in 10..99) {
        "In between 10 to 99"
    } else {
        "More than 100"
    }
    return result
}

//practice arraylist
fun arraylist(){
    val arrayList = ArrayList<String>(5)
    arrayList.add("Programming")
    arrayList.add("Mobile")
    arrayList.add("Security")
    arrayList.add("Usable")
    arrayList.add("Learn")
    for (i in arrayList) {
        println(i)
    }
}

fun collection(){
    //Iterate over a collection.
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
    //Check if a collection contains an object using in operator.
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
    // Using lambda expressions to filter and map collections:
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}

fun iterateover(){
    for (x in 1..5) {
        print(x)
    }
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
}

fun forloop(){
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
    // for loop another way
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

fun whileloop(){
    val items = listOf("apple", "banana", "kiwifruit")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

fun whenexpression(a: Int,b: Int, condition: Int){
    val result = when (condition) {
        1 -> a + b
        2 -> a - b
        3 -> a * b
        4 -> a / b
        else -> "No operation"
    }
    println("result = $result")
}
//Check if a number is within a range using in operator.
fun checkifnumberinrange(){
    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println("fits in range")
    }
}

fun checkifnumberoutofrange(){
    val list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
}

fun nullval(){
    var apival : String = "cs481" // variable is declared as non-nullable
   // apival = null  //compiler error
    print("String length "+apival.length)
}

fun nonnull(){
    var apival : String? = "cs481" // variable is declared as nullable
    //apival = null  //no error
   // print("String length "+apival.length) // But error
}

fun nullcheck(){
    var apival : String? = "cs481" // variable is declared as nullable
    if (apival != null && apival.length > 0) {
        println("String length: ${apival.length}")
    } else {
        println("String is empty")
    }
    apival = null
    println(apival)
    if (apival != null) {
        println("String length: ${apival.length}")
    } else {
        println("String is empty")
    }
}

/* Kotlin has a Safe call operator, ?.
apival?.length is equivalent to:
if(apival != null)
    apival.length
else
    null
*/
fun nullsafeoperator(){
    var apival : String? = "cs481" // variable is declared as nullable
    println(apival?.length)
    apival= null
    println(apival?.length)
}


fun sumlamda(a: Int, b: Int): Int {  // lambda{a, b -> a + b}
    return a + b
}
val lambdafunc: (Int, Int) -> Int = {a, b -> a + b}
fun sumwithlambda(a:Int, b: Int, myFunc: (Int, Int) -> Int){
    var result = myFunc(a,b)
    println("Lambda output " +result)
}



package com.example.cs481kotlinsyntax
//To define a class, use the class keyword.
//Properties of a class can be listed in its declaration or body.
class Rectangle(var height: Double, var length: Double) {
    var perimeter = (height + length) * 2
}
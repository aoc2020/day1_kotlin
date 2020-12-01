@file:JvmName("Main")

package com.github.aoc2020.day1_kotlin

import java.lang.RuntimeException
import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors

fun main() {
    val numbers = readInput()
    val result1 = findAndMultiply2(numbers)
    println("Result (1): $result1")
    val result2 = findAndMultiply3(numbers)
    println("Result (2): $result2")
}

private fun findAndMultiply2(numbers: List<Int>) : Int {
    for (first in numbers.indices) {
        for (second in first + 1..numbers.lastIndex) {
            val n1 = numbers[first]
            val n2 = numbers[second]
//            println("Checking $n1 $n2")
            if (n1 + n2 == 2020) {
                return n1 * n2
            }
        }
    }
    throw RuntimeException("Did not find any matching numbers")
}

private fun findAndMultiply3(numbers: List<Int>) : Int {
    for (first in numbers.indices) {
        for (second in first + 1..numbers.lastIndex) {
            for (third in second + 1..numbers.lastIndex) {
                val n1 = numbers[first]
                val n2 = numbers[second]
                val n3 = numbers[third]
//                println("Checking $n1 $n2")
                if (n1 + n2 + n3 == 2020) {
                    return n1 * n2 * n3
                }
            }
        }
    }
    throw RuntimeException("Did not find any matching numbers")
}


fun readInput(): List<Int>  {
    return Files.lines(Path.of("input.txt")).map(Integer::parseInt).collect(Collectors.toUnmodifiableList())
}
package org.hexchain.adventofcode.y2022

import org.hexchain.adventofcode.utils.readInputAsSequence

fun priority(item: Char) = when (item) {
    in 'a'..'z' -> (item - 'a') + 1
    in 'A'..'Z' -> (item - 'A') + 27
    else -> 0
}

fun main() {
    fun part1(input: Sequence<String>) = input
            .map { it.take(it.length / 2).toSet() intersect it.takeLast(it.length / 2).toSet() }
            .map { priority(it.single()) }
            .reduce(Int::plus)

    fun part2(input: Sequence<String>) = input
            .chunked(3)
            .map { it.map { it.toSet() }.reduce { acc, chars -> acc intersect chars } }
            .map { priority(it.single()) }
            .reduce(Int::plus)

    val input = readInputAsSequence("2022/day3").filter { it.isNotEmpty() }
    println(part1(input))
    println(part2(input))
}

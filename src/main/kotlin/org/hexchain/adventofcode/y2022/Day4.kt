package org.hexchain.adventofcode.y2022

import org.hexchain.adventofcode.utils.readInputAsSequence

typealias IntPair = Pair<Int, Int>

infix fun IntPair.contains(other: IntPair) = this.first <= other.first && this.second >= other.second
infix fun IntPair.overlaps(other: IntPair) = this.first <= other.second && other.first <= this.second

fun main() {
    fun part1(input: Sequence<Pair<IntPair, IntPair>>) = input
        .count { (p1, p2) -> p1 contains p2 || p2 contains p1 }

    fun part2(input: Sequence<Pair<IntPair, IntPair>>) = input
        .count { (p1, p2) -> p1 overlaps p2 }

    val input = readInputAsSequence("2022/day4")
        .filter { it.isNotEmpty() }
        .map {
            it.split(',').map {
                it.split('-').map(String::toInt).zipWithNext().single()
            }.zipWithNext().single()
        }

    println(part1(input))
    println(part2(input))
}

package org.hexchain.adventofcode.y2022

import org.hexchain.adventofcode.utils.readInputAsSequence

fun main() {
    val line = readInputAsSequence("2022/day6").first().asSequence()
    val indexedSeq = line.zip(generateSequence(1) { it + 1 })

    val part1 = indexedSeq.windowed(4).first {
        it.map { p -> p.first }.toSet().size == 4
    }.last().second
    println(part1)

    val part2 = indexedSeq.windowed(14).first {
        it.map { p -> p.first }.toSet().size == 14
    }.last().second
    println(part2)
}

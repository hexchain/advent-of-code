package org.hexchain.adventofcode.y2022

import org.hexchain.adventofcode.utils.*

val shapeMap = mapOf("X" to "A", "Y" to "B", "Z" to "C")
val scoreMap = mapOf("A" to 1, "B" to 2, "C" to 3)

fun score(me: String, opp: String): Int {
    return scoreMap[me]!! + when {
        // draw
        me == opp -> 3

        // win
        me == "A" && opp == "C" -> 6
        me == "B" && opp == "A" -> 6
        me == "C" && opp == "B" -> 6

        // lose
        else -> 0
    }
}

fun choiceForResult(opp: String, res: String) = when (res) {
    // lose
    "X" -> when (opp) {
        "A" -> "C"
        "B" -> "A"
        else -> "B"
    }

    // win
    "Z" -> when (opp) {
        "A" -> "B"
        "B" -> "C"
        else -> "A"
    }

    // draw
    else -> opp
}

fun main() {
    fun part1(input: Sequence<Pair<String, String>>) = input
        .map { (opp, arg) -> score(shapeMap[arg]!!, opp) }
        .reduce(Int::plus)

    fun part2(input: Sequence<Pair<String, String>>) = input
        .map { (opp, arg) -> score(choiceForResult(opp, arg), opp) }
        .reduce(Int::plus)

    val input = readInputAsSequence("2022/day2")
        .filter { it.isNotEmpty() }
        .map { it.split(" ").zipWithNext().single() }

    println(part1(input))
    println(part2(input))
}

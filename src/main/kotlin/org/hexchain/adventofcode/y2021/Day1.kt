package org.hexchain.adventofcode.y2021

import org.hexchain.adventofcode.utils.readInputAsSequence

fun main() {
    val depths = readInputAsSequence("2021/day1")
        .filter { it.isNotEmpty() }
        .map(String::toInt)
    println(depths.windowed(2).count { (a, b) -> a < b})
    println(depths.windowed(4).count { (a, b) -> a < b})
}

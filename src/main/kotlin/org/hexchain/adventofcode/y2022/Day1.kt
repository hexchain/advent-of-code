package org.hexchain.adventofcode.y2022

import org.hexchain.adventofcode.utils.*

fun <T> List<T>.split(predicate: (T) -> Boolean) = this.split(predicate, listOf(), listOf())

tailrec fun <T> List<T>.split(
    predicate: (T) -> Boolean,
    ret: List<List<T>>,
    cur: List<T>
): List<List<T>> = when {
    this.isEmpty() -> ret + listOf(cur)
    predicate(this.first()) -> this.drop(1).split(predicate, ret + listOf(cur), listOf())
    else -> this.drop(1).split(predicate, ret, cur + this.first())
}

fun main() {
    val lines = readInputAsList("2022/day1")
    val calories = lines.split { it.isEmpty() }.map { it.map(String::toInt).sum() }.toMutableList()
    calories.sortDescending()
    println(calories.first())
    println(calories.take(3).sum())
}

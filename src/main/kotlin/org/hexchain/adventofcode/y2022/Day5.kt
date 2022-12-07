package org.hexchain.adventofcode.y2022

import org.hexchain.adventofcode.utils.readInputAsSequence

fun main() {
    fun part(initialStacks: Array<List<Char>>, input: Sequence<String>, reverse: Boolean): String {
        val stacks = initialStacks.map(List<Char>::toMutableList).toTypedArray()
        val opRegex = Regex("""^move (\d+) from (\d+) to (\d+)""")
        input.forEach { line ->
            opRegex.matchEntire(line)?.groupValues?.let { values ->
                val (count, src, dst) = values.drop(1).map(String::toInt)
                val srcIdx = src - 1
                val dstIdx = dst - 1
                stacks[dstIdx].addAll(stacks[srcIdx].takeLast(count).let { if (reverse) it.asReversed() else it })
                stacks[srcIdx].apply {
                    this.subList(this.size - count, this.size).clear()
                }
            }
        }
        return stacks.map { it.last() }.joinToString("")
    }

    val lines = readInputAsSequence("2022/day5")
    val stackLines = lines.takeWhile { it.isNotBlank() }.toList().dropLast(1)
    val initialStacks = Array(9) { listOf<Char>() }
    stackLines.asReversed().forEach { line ->
        (0 until 9).forEach { idx ->
            line.getOrNull(1 + idx * 4)?.takeIf { it.isLetter() }?.let {
                initialStacks[idx] += listOf(it)
            }
        }
    }

    println(part(initialStacks, lines.drop(stackLines.size + 2), true))
    println(part(initialStacks, lines.drop(stackLines.size + 2), false))
}

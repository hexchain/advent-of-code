package org.hexchain.adventofcode.utils

import java.io.File

fun readInput(name: String) = File("data", "$name.txt")
fun readInputAsList(name: String) = readInput(name).readLines()
fun readInputAsSequence(name: String) = readInputAsList(name).asSequence()

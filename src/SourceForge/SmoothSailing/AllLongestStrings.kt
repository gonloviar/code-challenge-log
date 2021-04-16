package SourceForge.SmoothSailing

// top
fun allLongestStrings(inputArray: MutableList<String>): List<String> {
    return inputArray.filter { it.length == inputArray.maxBy { it.length }?.length }
}
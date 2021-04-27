package codeSignal.intro._05_islandOfKnowledge

//==============================================================================
//====================   Ch19 are Equally Strong   ===============================

fun areEquallyStrong(yourLeft: Int, yourRight: Int, friendsLeft: Int, friendsRight: Int) =
        setOf(yourLeft, yourRight) == setOf(friendsLeft, friendsRight)



//==============================================================================
//====================   Ch20 array Maximal Adjacent Difference   ===============================

fun arrayMaximalAdjacentDifference(inputArray: MutableList<Int>): Int =
        inputArray.zipWithNext { a, b -> kotlin.math.abs(a-b) }.max()!!

fun arrayMaximalAdjacentDifference2(inputArray: MutableList<Int>) =
        inputArray.zip(inputArray.drop(1), { a, b -> Math.abs(a - b) }).max()
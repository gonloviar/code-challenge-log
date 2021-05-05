package codeSignal.intro._05_islandOfKnowledge

//==============================================================================
//====================   Ch19 are Equally Strong   ===============================

fun areEquallyStrong(yourLeft: Int, yourRight: Int, friendsLeft: Int, friendsRight: Int) =
        setOf(yourLeft, yourRight) == setOf(friendsLeft, friendsRight)



//==============================================================================
//====================   Ch20 array Maximal Adjacent Difference   ==============

fun arrayMaximalAdjacentDifference(inputArray: MutableList<Int>): Int =
        inputArray.zipWithNext { a, b -> kotlin.math.abs(a-b) }.max()!!

fun arrayMaximalAdjacentDifference2(inputArray: MutableList<Int>) =
        inputArray.zip(inputArray.drop(1), { a, b -> Math.abs(a - b) }).max()



//==============================================================================
//====================   Ch21  =================================================

fun isIPv4Address(inputString: String): Boolean {
    val tokens = inputString.split(".")
    return tokens.size == 4 && tokens.all { it.toIntOrNull() in 0..255 }
}

fun isIPv4Address2(inputString: String): Boolean {
    var n = inputString.split('.')
    n.apply {
        if(n.size!=4) return false
    }.apply {
        n.forEach {
            if( it.toIntOrNull()==null)
                return false
            else if((it[0]=='0'&&it.length>1)||it.toInt()>255)
                return false
        }
    }
    return true
}


//==============================================================================
//====================   Ch22  =================================================

fun avoidObstacles(inputArray: MutableList<Int>): Int =
        (1..Int.MAX_VALUE).first { jump -> inputArray.all { it % jump != 0 } }


fun avoidObstacles2(inputArray: MutableList<Int>): Int {
    var sort = inputArray.sorted()
    var jump = 0
    var found = false
    while(!found){
        jump++
        if(!sort.contains(jump)){
            found = true
            for(x in sort){
                if(x.rem(jump) == 0){
                    found = false
                }
            }
        }
    }
    return jump
}
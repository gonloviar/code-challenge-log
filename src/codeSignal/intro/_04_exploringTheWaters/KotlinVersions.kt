package codeSignal.intro._04_exploringTheWaters

//==============================================================================
//====================   Ch14 Alternating Sums   ===============================

fun alternatingSums(a: List<Int>) =
        a.withIndex()
                .partition { it.index % 2 == 0 }.toList()
                .map { it.sumBy { it.value } }


fun alternatingSums2(a: MutableList<Int>): MutableList<Int> =
        mutableListOf( a.filterIndexed { index, i -> index%2 ==0 }.sum(),
                a.filterIndexed {  index, i -> index%2 !=0 }.sum())



//==============================================================================
//====================   Ch15 Add Border   ===============================

fun addBorder(picture: MutableList<String>): MutableList<String> {
    // Add a star to each row at the start and end.
    val bordered = picture.map { "*$it*" } as MutableList<String>

    // Add the top and bottom borders.
    val starRow: String = "*".repeat(bordered[0].length)
    bordered.add(0, starRow)
    bordered.add(starRow)

    return bordered
}

fun addBorder2(picture: MutableList<String>): MutableList<String> {
    var star="*".repeat(picture[0].length+2)
    picture.replaceAll { "*$it*" }
    picture.add(0,star)
    picture.add(star)
    return picture
}

fun addBorder3(picture: MutableList<String>): MutableList<String> =
        picture.apply { add(0,"*".repeat(picture[0].length)) }
                .apply { add("*".repeat(picture[0].length)) }
                .apply { forEachIndexed { index, s -> picture[index] = "*$s*" } }
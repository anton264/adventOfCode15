fun main() {
    // Första siffran är yttrad siffra, första siffran i paret är i vilken
    // tur det yttrades förrförra gången och sista när det yttrades förra gången
    val spokenInTurns = hashMapOf<Int, Pair<Int, Int>>()
    var turnNumber = 0
    var lastSpokenNumber = -1
    val startingNumbers = mutableListOf(
        1, 0, 15, 2, 10, 13
    )
    //Initiera startnummer
    startingNumbers.forEach {
        turnNumber++
        spokenInTurns[it] = Pair(-1, turnNumber)
        lastSpokenNumber = it
    }
    while (turnNumber != 30_000_000) {
        turnNumber++
        //Om senast yttrade numrets förrförra tur är -1 så har det inte yttrats tidigare och vi säger då 0
        if (spokenInTurns[lastSpokenNumber]?.first == -1) {
            // Senast yttrade siffran blir 0 och vi sätter turerna efter detta
            lastSpokenNumber = 0
            spokenInTurns[0] = Pair(spokenInTurns[0]!!.second, turnNumber)
        } else {
            // Vi räknar ut nästa siffra genom att subtrahera turerna
            lastSpokenNumber = spokenInTurns[lastSpokenNumber]!!.second - spokenInTurns[lastSpokenNumber]!!.first
            // Slutligen uppdaterar vi vilka turer som siffran yttrats, vi flyttar förra till förförra och använder nuvarande tur som förra.
            // Om siffran inte yttrats tidigare finns ingen förra tur, elvis operatorn sätter då -1
            spokenInTurns[lastSpokenNumber] = Pair(spokenInTurns[lastSpokenNumber]?.second ?: -1, turnNumber)
        }
    }
    println(lastSpokenNumber)
}

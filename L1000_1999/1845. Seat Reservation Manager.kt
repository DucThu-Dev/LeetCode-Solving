import java.util.PriorityQueue

class SeatManager(private val n: Int) {
    lateinit var unreservedSeats: PriorityQueue<Int>
    lateinit var reservedSeats: MutableList<Int>

    init {
        unreservedSeats = PriorityQueue(MutableList<Int>(n) {
            it + 1
        }
        )
        reservedSeats = mutableListOf()
    }

    fun reserve(): Int {
        val smallest = unreservedSeats.poll()
        reservedSeats.add(smallest)
        return smallest
    }

    fun unreserve(seatNumber: Int) {
        unreservedSeats.add(seatNumber)
        reservedSeats.remove(seatNumber)
    }
}
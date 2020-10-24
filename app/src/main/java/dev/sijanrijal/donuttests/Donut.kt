package dev.sijanrijal.donuttests

class Donut {

    private val donutOrderList: MutableList<DonutTypes> = mutableListOf()


    /**
     * Add donut to the order list if it isn't null
     * @param donutType Type of donut to be added to the list
     * @return True if the the donut was added and false if it wasn't
     * **/
    fun addToOrder(donutType: DonutTypes?, count: Int): Boolean {
        if (donutType != null) {
            donutType.count += count
            donutOrderList.add(donutType)
            return true
        }
        return false
    }

    /**
     * Get the total price of the order
     * **/
    fun getTotalOfOrder(): Float {
        var total: Float = 0f
        donutOrderList.forEach { donutType ->
            total.plus(donutType.price * donutType.count)
        }
        return total
    }

    /**
     * Remove a donut type from the order
     * **/
    fun removeFromOrder(donutType: DonutTypes) = donutOrderList.remove(donutType)

    /**
     * Get the total counts of donut in the order
     * **/
    fun getTotalNumberOfDonuts(): Int {
        var total = 0
        donutOrderList.forEach { donut ->
            total += donut.count
        }
        return total
    }

    /**
     * Get the first item in the order
     * @return DonutType value if the order isn't empty else null
     * **/
    fun getTheFirstItem(): DonutTypes? = if (donutOrderList.size > 0) donutOrderList[0] else null
}

/**
 * Enum class that holds the type of donuts
 * **/
enum class DonutTypes(val price: Float, var count: Int = 0) {
    GLAZED(2.40f),
    CHOCOLATE(3.20f),
    STRAWBERRY(2.90f),
    CINNAMON(3.10f),
    APPLE(2.80f);
}
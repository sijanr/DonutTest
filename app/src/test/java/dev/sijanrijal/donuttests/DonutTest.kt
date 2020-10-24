package dev.sijanrijal.donuttests

import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DonutTest {

    private lateinit var donut: Donut

    @BeforeAll
    fun init() {
        donut = Donut()
    }

    @Test
    fun simpleTest() {
        donut.addToOrder(null, 0)
    }

    @Nested
    @DisplayName("Donut count test class should")
    inner class DonutCountTest {

        @BeforeEach
        fun init() {
            donut = Donut()
        }

        @Test
        fun `add the total count of donut added to the order`() {
            donut.addToOrder(DonutTypes.GLAZED, 2)
            donut.addToOrder(DonutTypes.APPLE, 3)
            Assertions.assertEquals(5, donut.getTotalNumberOfDonuts())
        }

        @Test
        fun `return zero before if the order is empty`() {
            Assertions.assertEquals(0, donut.getTotalNumberOfDonuts())
        }

    }

    @Test
    fun `Remove a donut type from the order if it is in the order`() {
        donut.addToOrder(DonutTypes.STRAWBERRY, 3)
        donut.addToOrder(DonutTypes.CHOCOLATE, 4)
        Assertions.assertTrue {
            donut.removeFromOrder(DonutTypes.STRAWBERRY)
        }
    }

    @Test
    fun `Return false if the donut type to be removed from the order is not found`() {
        Assertions.assertFalse(donut.removeFromOrder(DonutTypes.CINNAMON))
    }

}
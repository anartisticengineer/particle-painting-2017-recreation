import org.junit.jupiter.api.Test
import org.openrndr.shape.Rectangle
import particlelogic.Cursor
import kotlin.test.assertEquals

class CursorTest {
    private val sampleRectangle = Rectangle(0.0, 0.0, 800.0, 1200.0)
    private val c = Cursor(sampleRectangle)

    @Test
    internal fun testCursorOne() {
        c.setPositionByTime(0.0)
        assertEquals(0.0, c.position.x)
    }

    @Test
    internal fun testCursorHalfway() {
        c.setPositionByTime(50.0)
        assertEquals(320.0, c.position.x)
    }

    @Test
    internal fun testCursorFull() {
        c.setPositionByTime(100.0)
        assertEquals(640.0, c.position.x)
    }
}
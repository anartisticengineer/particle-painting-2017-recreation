import org.junit.jupiter.api.Test
import org.openrndr.math.Vector2
import org.openrndr.shape.Rectangle
import particlelogic.Cursor
import kotlin.test.assertEquals

class CursorTest {
    private val sampleRectangle = Rectangle(Vector2.ZERO, 800.0, 1200.0)
    private val c = Cursor(sampleRectangle, 0.5)

    @Test
    internal fun testCursorYScale() {
        assertEquals(600.0, c.position.y)
    }

    @Test
    internal fun testCursorOne() {
        c.setPositionByTime(0.0)
        assertEquals(0.0, c.position.x)
    }

    @Test
    internal fun testCursorHalfway() {
        c.setPositionByTime(50.0)
        assertEquals(400.0, c.position.x)
    }

    @Test
    internal fun testCursorFull() {
        c.setPositionByTime(100.0)
        assertEquals(800.0, c.position.x)
    }
}
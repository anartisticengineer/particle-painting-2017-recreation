import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.olive.oliveProgram
import org.openrndr.shape.Circle
import particlelogic.Cursor

fun main() = application {
    configure {
        width = 800
        height = 1200
    }

    oliveProgram {
        val yScales = listOf(0.0, 0.25, 0.5, 0.75)
        val cursors = yScales.map { scl -> Cursor(drawer.bounds, scl) }
        extend {
            drawer.clear(ColorRGBa.BLACK)
            drawer.fill = ColorRGBa.RED
            cursors.forEach { cursor -> cursor.setPositionByTime(seconds) }
            drawer.circles(cursors.map { cursor -> Circle(cursor.position, 10.0) })
        }
    }
}

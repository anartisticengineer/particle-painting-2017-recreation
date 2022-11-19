import org.openrndr.application
import org.openrndr.color.ColorRGBa

fun main() = application {
    configure {
        width = 800
        height = 1200
    }

    program {
        extend {
            drawer.clear(ColorRGBa.BLACK)
        }
    }
}

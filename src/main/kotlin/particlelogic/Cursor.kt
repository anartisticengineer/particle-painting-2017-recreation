package particlelogic

import org.openrndr.math.Vector2
import org.openrndr.shape.Rectangle

class Cursor(private var boundRectangle: Rectangle, private var yScale: Double = 0.0, private var maxTime: Double = 100.0) {
    var position = Vector2.ZERO.copy(y = boundRectangle.height * yScale)

    fun setPositionByTime(t: Double){
        val newX = (t / maxTime) * boundRectangle.width
        position = Vector2(newX, boundRectangle.height * yScale)
    }
}
package particlelogic

import org.openrndr.math.Vector2
import org.openrndr.math.map
import org.openrndr.shape.Rectangle

class Cursor(var boundRectangle: Rectangle, var yScale: Double = 0.0) {
    private val tMax = 100.0
    private val paddedBounds = boundRectangle.scaledBy(80.0)
    private val xBoundRange = 0.0.rangeTo(paddedBounds.width)
    private val tRange = 0.0.rangeTo(tMax)
    var position = Vector2.ZERO

    fun setPositionByTime(t: Double){
        val newX = map(tRange, xBoundRange, t/tMax, true)
        position = Vector2(newX, boundRectangle.height * yScale)
    }
}
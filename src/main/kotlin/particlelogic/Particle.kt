package particlelogic

import org.openrndr.color.ColorRGBa
import org.openrndr.extra.noise.Random
import org.openrndr.extra.noise.random
import org.openrndr.math.Vector2

class Particle(initialPosition: Vector2) {
    var position = initialPosition
    var lifespan = 0.0
    val particleColor = ColorRGBa.fromVector(Random.vector3(0.0, 1.0))
    private var velocity = Vector2.ZERO
    private val acceleration = Vector2(0.0, random(0.02, 0.05))
    private val step = random(0.01, 0.05)
    val isDead
        get() = lifespan > 1.0

    fun update(){
        velocity += acceleration
        position += velocity
        lifespan += step
    }
}
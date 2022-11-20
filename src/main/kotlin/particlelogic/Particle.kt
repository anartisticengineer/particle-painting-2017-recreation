package particlelogic

import org.openrndr.extra.noise.random
import org.openrndr.math.Vector2

class Particle(initialPosition: Vector2) {
    var position = initialPosition
    private var velocity = Vector2.ZERO
    private val acceleration = Vector2(0.0, random(0.01, 0.1))
    private var lifespan = 0.0
    private val step = random(0.01, 0.05)
    var isDead = false
        get() = lifespan > 1.0

    fun update(){
        velocity += acceleration
        position += velocity
        lifespan += step
    }
}
package particlelogic

import org.openrndr.math.Vector2
import org.openrndr.shape.Rectangle

class ParticleSystem(boundRectangle: Rectangle, yScale: Double = 0.0) {
    private val cursor = Cursor(boundRectangle, yScale)
    private var particles = mutableListOf<Particle>()
    var allParticlePositions = listOf<Vector2>()
        get() = particles.map { particle -> particle.position }

    var allParticleSizes = listOf<Double>()
        get() = particles.map { particle -> (1.0 - particle.lifespan) * 2.0 }

    fun updateCursor(t: Double){
        cursor.setPositionByTime(t)
    }

    fun addNewParticle(){
        particles.add(Particle(cursor.position))
    }

    fun updateParticles(){
        particles.forEach { particle ->  particle.update() }
        particles = particles.filterNot { particle -> particle.isDead } as MutableList<Particle>
    }
}
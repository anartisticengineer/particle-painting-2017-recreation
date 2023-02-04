package particlelogic

import org.openrndr.shape.Rectangle

class ParticleSystem(boundRectangle: Rectangle, yScale: Double = 0.0, maxTime: Double = 100.0) {
    private val cursor = Cursor(boundRectangle, yScale, maxTime)
    private var particles = mutableListOf<Particle>()
    val numParticles
        get() = particles.size
    val allParticlePositions
        get() = particles.map { it.position }

    val allParticleColors
        get() = particles.map { it.particleColor }

    val allParticleShades
        get() = particles.map { (1.0 - it.lifespan) }

    fun updateCursor(t: Double){
        cursor.setPositionByTime(t)
    }

    fun addNewParticle(){
        particles.add(Particle(cursor.position))
    }

    fun updateParticles(){
        particles.forEach { particle ->  particle.update() }
        particles = particles.filterNot { it.isDead } as MutableList<Particle>
    }
}
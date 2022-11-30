package particlelogic

import org.openrndr.shape.Rectangle

class ParticleSystem(boundRectangle: Rectangle, yScale: Double = 0.0) {
    private val cursor = Cursor(boundRectangle, yScale)
    private var particles = mutableListOf<Particle>()
    val numParticles
        get() = particles.size
    val allParticlePositions
        get() = particles.map { particle -> particle.position }

    val allParticleColors
        get() = particles.map { particle -> particle.particleColor }

    val allParticleShades
        get() = particles.map { particle -> (1.0 - particle.lifespan) }

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
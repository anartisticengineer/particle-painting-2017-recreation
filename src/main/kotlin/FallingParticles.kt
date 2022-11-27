import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.color.presets.PALE_VIOLET_RED
import org.openrndr.math.Vector2
import particlelogic.ParticleSystem

fun main() = application {
    configure {
        width = 480
        height = 720
    }
    program {
        val yScales = listOf(0.0, 0.25, 0.5, 0.75)
        val particleSystems = yScales.map { scl ->  ParticleSystem(drawer.bounds, scl)}
        val particleColor = ColorRGBa.PALE_VIOLET_RED
        extend {
            drawer.clear(ColorRGBa.BLACK)
            drawer.fill = particleColor
            drawer.stroke = null
            drawer.translate(Vector2(width * 0.1, height * 0.1))
            particleSystems.forEach { particleSystem ->
                if (frameCount % 5 == 0 && seconds <= 100.0){
                    particleSystem.updateCursor(seconds)
                    particleSystem.addNewParticle()
                }
                particleSystem.updateParticles()
                drawer.circles(particleSystem.allParticlePositions, particleSystem.allParticleSizes)
            }
        }
    }
}

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.color.presets.PALE_VIOLET_RED
import org.openrndr.extra.olive.oliveProgram
import org.openrndr.math.Vector2
import particlelogic.ParticleSystem

fun main() = application {
    configure {
        width = 400
        height = 600
    }

    oliveProgram {
        val yScales = listOf(0.0, 0.25, 0.5, 0.75)
        val particleSystems = yScales.map { scl ->  ParticleSystem(drawer.bounds, scl)}
        extend {
            drawer.clear(ColorRGBa.BLACK)
            drawer.fill = ColorRGBa.PALE_VIOLET_RED
            drawer.stroke = null
            drawer.translate(Vector2(width * 0.1, height * 0.1))
            particleSystems.forEach { particleSystem ->
                if (frameCount % 5 == 0){
                    particleSystem.updateCursor(seconds)
                    particleSystem.addNewParticle()
                }
                particleSystem.updateParticles()
                drawer.circles(particleSystem.allParticlePositions, particleSystem.allParticleSizes)
            }
        }
    }
}

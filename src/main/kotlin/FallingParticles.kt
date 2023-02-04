import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.Screenshots
import org.openrndr.extra.noclear.NoClear
import org.openrndr.math.Vector2
import particlelogic.ParticleSystem

fun main() = application {
    configure {
        width = 480
        height = 720
    }
    program {
        val maxNumSeconds = 200.0
        val yScales = listOf(0.0, 0.2, 0.4, 0.6, 0.8)
        val particleSystemArea = drawer.bounds.offsetEdges(drawer.width * -0.1, drawer.height * -0.1)
        val particleSystems = yScales.map { ParticleSystem(particleSystemArea, it, maxNumSeconds)}
        backgroundColor = ColorRGBa.BLACK
        extend(NoClear())
        extend(Screenshots()){
            contentScale = 4.0
        }
        extend {
            drawer.translate(Vector2(width * 0.1, height * 0.1))
            particleSystems.forEach { particleSystem ->
                if (frameCount % 5 == 0 && seconds <= maxNumSeconds){
                    particleSystem.updateCursor(seconds)
                    particleSystem.addNewParticle()
                }
                particleSystem.updateParticles()
                drawer.points {
                    val numParticles = particleSystem.numParticles
                    repeat(numParticles){
                        val currentColor = particleSystem.allParticleColors[it]
                        fill = currentColor.shade(particleSystem.allParticleShades[it])
                        point(particleSystem.allParticlePositions[it])
                    }
                }
            }
        }
    }
}

import cn.edu.gxust.jiweihuang.scala.math.function.univariate.QuadraticVertexLogistic

val qvl0: QuadraticVertexLogistic = {
  new QuadraticVertexLogistic(1.0)
}
println(qvl0.integrate(2))
println(s"qvl0.differential(2) = ${qvl0.differential(2)}")
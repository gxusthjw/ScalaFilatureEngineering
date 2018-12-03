import cn.edu.gxust.jiweihuang.scala.math.function.univariate.Logistic


println(s"Logistic(1, 2, 3).logisticM = ${Logistic(1, 2, 3).logisticM}")
println(s"Logistic(1, 2, 3).logisticK = ${Logistic(1, 2, 3).logisticK}")
println(s"Logistic(1, 2, 3).logisticX0 = ${Logistic(1, 2, 3).logisticX0}")
println(s"Logistic(1, 2, 3).formula = ${Logistic(1, 2, 3).formula}")
println(s"Logistic(1, 2, 3).iformula = ${Logistic(1, 2, 3).dformula}")
println(s"Logistic(1, 2, 3).dformula = ${Logistic(1, 2, 3).iformula}")

println(s"Logistic(1,2,3).integrate(-100) = ${Logistic(1, 2, 3).integrate(-100)}")
println(s"Logistic(1,2,3).integrate(-50) = ${Logistic(1, 2, 3).integrate(-50)}")
println(s"Logistic(1,2,3).integrate(0) = ${Logistic(1, 2, 3).integrate(0)}")
println(s"Logistic(1,2,3).integrate(50) = ${Logistic(1, 2, 3).integrate(50)}")
println(s"Logistic(1,2,3).integrate(100) = ${Logistic(1, 2, 3).integrate(100)}")
println(s"Logistic(1,2,3).integrate(200) = ${Logistic(1, 2, 3).integrate(200)}")
println(s"Logistic(1,2,3).integrate(300) = ${Logistic(1, 2, 3).integrate(300)}")

println(s"Logistic(1,2,3).integrate(0,100) = ${Logistic(1, 2, 3).integrate(0, 100)}")
println(s"Logistic(1,2,3).integrateRomberg(0,100)} = ${Logistic(1, 2, 3).integrateRomberg(0, 100)}")
println(s"Logistic(1,2,3).integrateSimpson(0,100)} = ${Logistic(1, 2, 3).integrateSimpson(0, 100)}")
println(s"Logistic(1,2,3).integrateMidPoint(0,100)} = ${Logistic(1, 2, 3).integrateMidPoint(0, 100)}")
println(s"Logistic(1,2,3).integrateTrapezoid(0,100)} = ${Logistic(1, 2, 3).integrateTrapezoid(0, 100)}")
println(s"Logistic(1,2,3).integrateIterativeLegendreGauss(0,100)} = ${Logistic(1, 2, 3).integrateIterativeLegendreGauss(0, 100)}")


println(s"Logistic(1,2,3).derivative(-100) = ${Logistic(1, 2, 3).derivative(-100)}")
println(s"Logistic(1,2,3).derivative(50) = ${Logistic(1, 2, 3).derivative(50)}")
println(s"Logistic(1,2,3).derivative(0) = ${Logistic(1, 2, 3).derivative(0)}")
println(s"Logistic(1,2,3).derivative(50) = ${Logistic(1, 2, 3).derivative(50)}")
println(s"Logistic(1,2,3).derivative(100) = ${Logistic(1, 2, 3).derivative(100)}")
println(s"Logistic(1,2,3).derivative(200) = ${Logistic(1, 2, 3).derivative(200)}")

println(s"Logistic(1,2,3).differential(-100) = ${Logistic(1, 2, 3).differential(-100)}")
println(s"Logistic(1,2,3).differential(50) = ${Logistic(1, 2, 3).differential(50)}")
println(s"Logistic(1,2,3).differential(0) = ${Logistic(1, 2, 3).differential(0)}")
println(s"Logistic(1,2,3).differential(50) = ${Logistic(1, 2, 3).differential(50)}")
println(s"Logistic(1,2,3).differential(100) = ${Logistic(1, 2, 3).differential(100)}")
println(s"Logistic(1,2,3).differential(200) = ${Logistic(1, 2, 3).differential(200)}")
/*
 * Copyright (c) 2018-2019, Jiwei Huang. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.edu.gxust.jiweihuang.scala.math.function.univariate

import cn.edu.gxust.jiweihuang.scala.math.function.{TUnivariateDerivativeFunction, TUnivariateDifferentiableFunction, TUnivariateIntegrableFunction, TUnivariateIntegralFunction}
import org.hipparchus.analysis.differentiation.DerivativeStructure

trait TQuadraticVertexLogistic extends TUnivariateDifferentiableFunction
  with TUnivariateIntegrableFunction
  with TUnivariateDerivativeFunction with TUnivariateIntegralFunction {
  override val formula: String
  override val dformula: String
  override val iformula: String
  val quadraticVertexA: Double
  val quadraticVertexB: Double
  val quadraticVertexC: Double
  val quadraticVertex: QuadraticVertex = QuadraticVertex(quadraticVertexA, quadraticVertexB, quadraticVertexC)
  val logisticM: Double
  val logisticK: Double
  val logisticX0: Double
  val logistic: Logistic = Logistic(logisticM, logisticK, logisticX0)
  val quadraticVertexLogisticD: Double

  override def derivative(x: Double): Double

  override def integrate(x: Double): Double

  override def value(derivativeStructure: DerivativeStructure): DerivativeStructure

  override def value(v: Double): Double
}


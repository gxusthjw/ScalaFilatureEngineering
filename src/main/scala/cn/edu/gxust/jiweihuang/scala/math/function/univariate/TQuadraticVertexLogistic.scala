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

import scala.math._

trait TQuadraticVertexLogistic extends TUnivariateDifferentiableFunction
  with TUnivariateIntegrableFunction
  with TUnivariateDerivativeFunction
  with TUnivariateIntegralFunction {
  override val formula: String = s"($quadraticVertexA*pow(x-$quadraticVertexB,2)+$quadraticVertexC)*$logisticM / (1 + exp(-$logisticK*(x-$logisticX0))) + $quadraticVertexLogisticD"
  override val dformula: String = s"2 * $quadraticVertexA * (x - $quadraticVertexB) * $logisticM / (1 + exp(-$logisticK * (x - $logisticX0))) + ($logisticM * $logisticK * exp(-$logisticK * (x - $logisticX0))) / pow((1 + exp(-$logisticK * (x - $logisticX0))), 2) * $quadraticVertexA * pow(x - $quadraticVertexB, 2) + $quadraticVertexC +$quadraticVertexLogisticD"
  override val iformula: String = s"$quadraticVertexLogisticD * x + $quadraticVertexA * $logisticM * pow(x, 3) / 3 - 2 * $quadraticVertexA * $quadraticVertexB * $logisticM * x * log(1 + exp($logisticK * (x - $logisticX0))) / $logisticK + $quadraticVertexA * pow($quadraticVertexB, 2) * $logisticM * log(exp($logisticK * x) + exp($logisticK * $logisticX0)) / $logisticK + $quadraticVertexC * $logisticM * log(exp($logisticK * x) + exp($logisticK * $logisticX0)) / $logisticK + $quadraticVertexA * $logisticM * pow(x, 2) * log(1 + exp($logisticK * ($logisticX0 - x))) / $logisticK"
  val quadraticVertexA: Double
  val quadraticVertexB: Double
  val quadraticVertexC: Double
  val quadraticVertex: QuadraticVertex = QuadraticVertex(quadraticVertexA, quadraticVertexB, quadraticVertexC)
  val logisticM: Double
  val logisticK: Double
  val logisticX0: Double
  val logistic: Logistic = Logistic(logisticM, logisticK, logisticX0)
  val quadraticVertexLogisticD: Double

  override def derivative(x: Double): Double = quadraticVertex.derivative(x) * logistic.value(x) + logistic.derivative(x) * quadraticVertex.value(x)

  /**
    * omitted the Polylog part.
    *
    * @param x independent variable.
    * @return the integral value.
    */
  override def integrate(x: Double): Double = quadraticVertexLogisticD * x + quadraticVertexA * logisticM * pow(x, 3) / 3 -
    2 * quadraticVertexA * quadraticVertexB * logisticM * x * log(1 + exp(logisticK * (x - logisticX0))) / logisticK +
    quadraticVertexA * pow(quadraticVertexB, 2) * logisticM * log(exp(logisticK * x) + exp(logisticK * logisticX0)) / logisticK +
    quadraticVertexC * logisticM * log(exp(logisticK * x) + exp(logisticK * logisticX0)) / logisticK +
    quadraticVertexA * logisticM * pow(x, 2) * log(1 + exp(logisticK * (logisticX0 - x))) / logisticK

  override def value(ds: DerivativeStructure): DerivativeStructure = quadraticVertex.value(ds).multiply(logistic.value(ds)).add(quadraticVertexLogisticD)

  override def value(x: Double): Double = logistic.value(x) * quadraticVertex.value(x) + quadraticVertexLogisticD
}


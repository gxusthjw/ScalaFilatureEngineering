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

import cn.edu.gxust.jiweihuang.scala.math.function.{
  TUnivariateDerivativeFunction,
  TUnivariateDifferentiableFunction,
  TUnivariateIntegrableFunction,
  TUnivariateIntegralFunction
}
import org.hipparchus.analysis.differentiation.DerivativeStructure
import org.hipparchus.analysis.ParametricUnivariateFunction
import math.{exp, pow, log}


/**
  * <p>The class {@code Logistic} is used for representing
  * the logistic function.</p>
  *
  * <p>the formula:l(x) = m/(1+exp(-k*(x-x0)))</p>
  *
  * @param logisticM  The parameter {m} of logistic function.
  * @param logisticK  The parameter {k} of logistic function.
  * @param logisticX0 The parameter {x0} of logistic function.
  */
final class Logistic(val logisticM: Double = 1.0,
                     val logisticK: Double = (-1.0),
                     val logisticX0: Double = 0.0)
  extends TUnivariateDifferentiableFunction
    with TUnivariateIntegrableFunction
    with TUnivariateDerivativeFunction
    with TUnivariateIntegralFunction {

  if (logisticM == 0) throw new IllegalArgumentException(s"Expected the parameter {logisticM != 0},but get {logisticM = $logisticM}")

  /**
    * to calculate the exp part of logistic function.
    *
    * @param x independent variable.
    * @return { @code exp(-k*(x-x0))}
    **/
  def logisticExp(x: Double): Double = if (checkX(x)) exp(-logisticK * (x - logisticX0))
  else throw new IllegalArgumentException(s"Expected the parameter {$lowerX <= x <= $upperX},but get {x = $x}")

  /**
    * to calculate one add exp part of logistic function.
    *
    * @param x independent variable.
    * @return {1+exp(-k*(x-x0))}.
    */
  def logisticExpAddOne(x: Double): Double = if (checkX(x)) 1 + logisticExp(x)
  else throw new IllegalArgumentException(s"Expected the parameter {$lowerX <= x <= $upperX},but get {x = $x}")

  /**
    * <p>The method {@code derivative(x: Double)} is used to
    * get the derivative  value of univariate derivative function.</p>
    *
    * @param x independent variable.
    * @return the derivative value.
    */
  override def derivative(x: Double): Double = if (checkX(x)) (logisticM * logisticK * logisticExp(x)) / pow(logisticExpAddOne(x), 2)
  else throw new IllegalArgumentException(s"Expected the parameter {$lowerX <= x <= $upperX},but get {x = $x}")

  /**
    * <p>The string form of analysis formula of
    * univariate derivative function.</p>
    */
  override val dformula: String =
    s"($logisticM * $logisticK * exp(-$logisticK * (x - $logisticX0))) / pow((1 + exp(-$logisticK * (x - $logisticX0))), 2)"

  /**
    * The method {@code integrate(x: Double)} is used to get
    * the integral value of univariate integral function.
    *
    * @param x independent variable.
    * @return the integral value.
    */
  override def integrate(x: Double): Double = if (checkX(x)) logisticM * (x + ((log(logisticExpAddOne(x))) / (logisticK)))
  else throw new IllegalArgumentException(s"Expected the parameter {$lowerX <= x <= $upperX},but get {x = $x}")

  /**
    * <p>The string form of analysis formula of
    * univariate integral function.</p>
    */
  override val iformula: String = s"$logisticM * (x + ((log(exp(-$logisticK * (x - $logisticX0)))) / ($logisticK)))"

  /**
    * the method {@code value(t: DerivativeStructure)} is used to get
    * the {@code DerivativeStructure} form of function for {@code differential()}.
    *
    * @param t the { @code DerivativeStructure} form of independent variable.
    * @return the { @code DerivativeStructure} form of function.
    */
  override def value(t: DerivativeStructure): DerivativeStructure = t.subtract(logisticX0).multiply(-logisticK).exp().add(1).pow(-1).multiply(logisticM)

  /**
    * The string form of analysis formula of univariate function.
    */
  override val formula: String = s"$logisticM / (1 + exp(-$logisticK * (x - $logisticX0)))"

  /**
    * the method {@code value(x: Double)} is used to get
    * the function value at {@code x}.
    *
    * @param x independent variable.
    * @return the function value at { @code x}.
    */
  override def value(x: Double): Double =
    if (checkX(x)) logisticM / (1 + exp(-logisticK * (x - logisticX0)))
    else throw new IllegalArgumentException(s"Expected the parameter {$lowerX <= x <= $upperX},but get {x = $x}")

  /**
    *
    */
  final class Parametric extends ParametricUnivariateFunction {
    override def value(x: Double, parameters: Double*): Double = {
      checkParameter(parameters)
      val m = parameters(0)
      val k = parameters(1)
      val x0 = parameters(2)
      m / (1 + exp(-k * (x - x0)))
    }

    override def gradient(x: Double, parameters: Double*): Array[Double] = {
      checkParameter(parameters)
      val m = parameters(0)
      val k = parameters(1)
      val x0 = parameters(2)
      val result = Array[Double](0, 0, 0)
      result(0) = 1 / (1 + exp(-k * (x - x0)))
      result(1) = -(exp(-k * (x - x0)) * m * (x0 - x)) / (pow(1 + exp(-k * (x - x0)), 2))
      result(2) = -(exp(-k * (x - x0)) * k * m) / (pow(1 + exp(-k * (x - x0)), 2))
      result
    }

    def checkParameter(parameters: Seq[Double]): Unit = {
      if (parameters == null) throw new IllegalArgumentException(s"Expected the parameter {parameters != null},but got {parameters = null}}")
      if (parameters.length != 3) throw new IllegalArgumentException(s"Expected the parameter {parameters.length == 3},but got {parameters.length = ${parameters.length}}")
      if (parameters(0) == 0) throw new IllegalArgumentException(s"Expected the parameter {parameters(0) != 0},but got {parameters(0) = ${parameters(0)}}")
    }
  }

}

object Logistic {
  def apply(logisticM: Double, logisticK: Double, logisticX0: Double): Logistic = new Logistic(logisticM, logisticK, logisticX0)

  def unapply(logistic: Logistic): Option[(Double, Double, Double)] =
    if (logistic == null) None
    else Some(logistic.logisticM, logistic.logisticK, logistic.logisticX0)

  def logisticExp(logisticK: Double, logisticX0: Double)(x: Double): Double = exp(-logisticK * (x - logisticX0))

  def logisticExpAddOne(logisticK: Double, logisticX0: Double)(x: Double): Double = 1 + logisticExp(logisticK, logisticX0)(x)

  def logistic(logisticM: Double, logisticK: Double, logisticX0: Double)(x: Double): Double = logisticM / logisticExpAddOne(logisticK, logisticX0)(x)

  def logisticDerivative(logisticM: Double, logisticK: Double, logisticX0: Double)(x: Double): Double = (logisticM * logisticK * logisticExp(logisticK, logisticX0)(x)) / pow(logisticExpAddOne(logisticK, logisticX0)(x), 2)

  def logisticIntegrate(logisticM: Double, logisticK: Double, logisticX0: Double)(x: Double): Double = logisticM * (x + log(logisticExpAddOne(logisticK, logisticX0)(x)) / logisticK)

  def logisticDerivativeM(logisticM: Double, logisticK: Double, logisticX0: Double)(x: Double): Double = 1 / logisticExpAddOne(logisticK, logisticX0)(x)

  def logisticDerivativeK(logisticM: Double, logisticK: Double, logisticX0: Double)(x: Double): Double = -(logisticM * (-x + logisticX0) * logisticExp(logisticK, logisticM)(x)) / pow(logisticExpAddOne(logisticK, logisticX0)(x), 2)

  def logisticDerivativeX0(logisticM: Double, logisticK: Double, logisticX0: Double)(x: Double): Double = -(logisticK * logisticM * logisticExp(logisticK, logisticX0)(x)) / pow(logisticExpAddOne(logisticK, logisticX0)(x), 2)
}


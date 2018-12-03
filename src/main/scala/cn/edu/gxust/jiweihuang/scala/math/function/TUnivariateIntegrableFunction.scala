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
package cn.edu.gxust.jiweihuang.scala.math.function

import cn.edu.gxust.jiweihuang.scala.math.NumericalConstants
import org.hipparchus.analysis.integration._

/**
  * <p>The trait {@code TUnivariateIntegrableFunction} is used for
  * representing univariate integrable function</p>
  *
  * @author JiweiHuang
  * @version 1.0.0_build-20181130
  * @see TUnivariateFunction
  */
trait TUnivariateIntegrableFunction extends TUnivariateFunction {
  private[this] val ITERATIVE_LEGENDRE_GAUSS = 20

  /**
    * <p>to get the definite integral value of univariate function
    * with Romberg algorithm</p>
    *
    * @param x0 the lower limit of integral.
    * @param x1 the upper limit of integral.
    * @return the definite integral value.
    */
  def integrateRomberg(x0: Double = lowerX, x1: Double = upperX): Double =
    new RombergIntegrator().integrate(Int.MaxValue, this, x0, x1)

  /**
    * <p>to get the definite integral value of univariate function
    * with Simpson algorithm</p>
    *
    * @param x0 the lower limit of integral.
    * @param x1 the upper limit of integral.
    * @return the definite integral value.
    */
  def integrateSimpson(x0: Double = lowerX, x1: Double = upperX): Double =
    new SimpsonIntegrator().integrate(Int.MaxValue, this, x0, x1)

  /**
    * <p>to get the definite integral value of univariate function
    * with MidPoint algorithm</p>
    *
    * @param x0 the lower limit of integral.
    * @param x1 the upper limit of integral.
    * @return the definite integral value.
    */
  def integrateMidPoint(x0: Double = lowerX, x1: Double = upperX): Double =
    new MidPointIntegrator().integrate(Int.MaxValue, this, x0, x1)

  /**
    * <p>to get the definite integral value of univariate function
    * with Trapezoid algorithm</p>
    *
    * @param x0 the lower limit of integral.
    * @param x1 the upper limit of integral.
    * @return the definite integral value.
    */
  def integrateTrapezoid(x0: Double = lowerX, x1: Double = upperX): Double =
    new TrapezoidIntegrator().integrate(Int.MaxValue, this, x0, x1)

  /**
    * <p>to get the definite integral value of univariate function
    * with IterativeLegendreGauss algorithm</p>
    *
    * @param x0 the lower limit of integral.
    * @param x1 the upper limit of integral.
    * @return the definite integral value.
    */
  def integrateIterativeLegendreGauss(x0: Double = lowerX, x1: Double = upperX): Double =
    new IterativeLegendreGaussIntegrator(NumericalConstants.ITERATIVE_LEGENDRE_GAUSS,
      BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
      BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY).integrate(Int.MaxValue, this, x0, x1)
}

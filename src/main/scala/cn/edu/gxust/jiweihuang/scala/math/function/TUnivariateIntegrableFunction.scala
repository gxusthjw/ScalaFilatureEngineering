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

import org.hipparchus.analysis.integration._

/**
  * <p>The trait [[TUnivariateIntegrableFunction]] is used for
  * representing univariate integrable function.</p>
  *
  * @author JiweiHuang
  * @version 1.0.0_build-20181130
  * @see TUnivariateFunction
  * @see RombergIntegrator
  * @see SimpsonIntegrator
  * @see MidPointIntegrator
  * @see TrapezoidIntegrator
  * @see IterativeLegendreGaussIntegrator
  */
trait TUnivariateIntegrableFunction extends TUnivariateFunction {

  private[this] val DefaultIntegrationPointsNumber = 32

  /**
    * <p>to get the definite integral value of univariate function
    * with Romberg algorithm</p>
    *
    * @param relativeAccuracy        relative accuracy of the result
    * @param absoluteAccuracy        absolute accuracy of the result
    * @param minimalIterationCount   minimum number of iterations
    * @param maximalIterationCount   maximum number of iterations
    * @param maxIter                 Maximum number of evaluations.
    * @param lowerX                  the lower limit of integral.
    * @param upperX                  the upper limit of integral.
    * @return the definite integral value.
    */
  def integrateRomberg(relativeAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                       absoluteAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY,
                       minimalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
                       maximalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT,
                       maxIter: Int = Int.MaxValue,
                       lowerX: Double = lowerX,
                       upperX: Double = upperX): Double =
    new RombergIntegrator(relativeAccuracy, absoluteAccuracy,
      minimalIterationCount, maximalIterationCount).integrate(maxIter, this, lowerX, upperX)

  /**
    * <p>to get the definite integral value of univariate function
    * with Simpson algorithm</p>
    *
    * @param relativeAccuracy        relative accuracy of the result
    * @param absoluteAccuracy        absolute accuracy of the result
    * @param minimalIterationCount   minimum number of iterations
    * @param maximalIterationCount   maximum number of iterations
    * @param maxIter                 Maximum number of evaluations.
    * @param lowerX                  the lower limit of integral.
    * @param upperX                  the upper limit of integral.
    * @return the definite integral value.
    */
  def integrateSimpson(relativeAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                       absoluteAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY,
                       minimalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
                       maximalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT,
                       maxIter: Int = Int.MaxValue,
                       lowerX: Double = lowerX,
                       upperX: Double = upperX): Double =
    new SimpsonIntegrator(relativeAccuracy, absoluteAccuracy,
      minimalIterationCount, maximalIterationCount).integrate(maxIter, this, lowerX, upperX)

  /**
    * <p>to get the definite integral value of univariate function
    * with MidPoint algorithm</p>
    *
    * @param relativeAccuracy        relative accuracy of the result
    * @param absoluteAccuracy        absolute accuracy of the result
    * @param minimalIterationCount   minimum number of iterations
    * @param maximalIterationCount   maximum number of iterations
    * @param maxIter                 Maximum number of evaluations.
    * @param lowerX                  the lower limit of integral.
    * @param upperX                  the upper limit of integral.
    * @return the definite integral value.
    */
  def integrateMidPoint(relativeAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                        absoluteAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY,
                        minimalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
                        maximalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT,
                        maxIter: Int = Int.MaxValue,
                        lowerX: Double = lowerX,
                        upperX: Double = upperX): Double =
    new MidPointIntegrator(relativeAccuracy, absoluteAccuracy,
      minimalIterationCount, maximalIterationCount).integrate(maxIter, this, lowerX, upperX)

  /**
    * <p>to get the definite integral value of univariate function
    * with Trapezoid algorithm</p>
    *
    * @param relativeAccuracy        relative accuracy of the result
    * @param absoluteAccuracy        absolute accuracy of the result
    * @param minimalIterationCount   minimum number of iterations
    * @param maximalIterationCount   maximum number of iterations
    * @param maxIter                 Maximum number of evaluations.
    * @param lowerX                  the lower limit of integral.
    * @param upperX                  the upper limit of integral.
    * @return the definite integral value.
    */
  def integrateTrapezoid(relativeAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                         absoluteAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY,
                         minimalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
                         maximalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT,
                         maxIter: Int = Int.MaxValue,
                         lowerX: Double = lowerX,
                         upperX: Double = upperX): Double =
    new TrapezoidIntegrator(relativeAccuracy, absoluteAccuracy,
      minimalIterationCount, maximalIterationCount).integrate(maxIter, this, lowerX, upperX)

  /**
    * <p>to get the definite integral value of univariate function
    * with IterativeLegendreGauss algorithm</p>
    *
    * @param relativeAccuracy        relative accuracy of the result
    * @param absoluteAccuracy        absolute accuracy of the result
    * @param minimalIterationCount   minimum number of iterations
    * @param maximalIterationCount   maximum number of iterations
    * @param integrationPointsNumber Number of integration points.
    * @param maxIter                 Maximum number of evaluations.
    * @param lowerX                  the lower limit of integral.
    * @param upperX                  the upper limit of integral.
    * @return the definite integral value.
    */
  def integrateIterativeLegendreGauss(relativeAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                                      absoluteAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY,
                                      minimalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
                                      maximalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT,
                                      integrationPointsNumber: Int = DefaultIntegrationPointsNumber,
                                      maxIter: Int = Int.MaxValue,
                                      lowerX: Double = lowerX,
                                      upperX: Double = upperX): Double =
    new IterativeLegendreGaussIntegrator(integrationPointsNumber,
      relativeAccuracy, absoluteAccuracy, minimalIterationCount,
      maximalIterationCount).integrate(maxIter, this, lowerX, upperX)
}

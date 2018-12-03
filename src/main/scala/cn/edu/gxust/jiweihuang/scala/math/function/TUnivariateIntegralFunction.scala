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

/**
  * <p>The trait {@code TUnivariateIntegralFunction} is used for
  * representing univariate integral function.</p>
  *
  * @author JiweiHuang
  * @version 1.0.0_build-20181130
  * @see TUnivariateFunction
  */
trait TUnivariateIntegralFunction extends TUnivariateFunction {

  /**
    * <p>The string form of analysis formula of
    * univariate integral function.</p>
    */
  val iformula: String
  /**
    * The integral constant of univariate integral function.
    */
  var integralConstant: Double = 0.0

  /**
    * The method {@code integrate(x: Double)} is used to get
    * the integral value of univariate integral function.
    *
    * @param x independent variable.
    * @return the integral value.
    */
  def integrate(x: Double): Double

  /**
    * The method {@code integrate(x: Double)} is used to get
    * the definite integral value of univariate integral function.
    *
    * @param x0 lower limit of integral
    * @param x1 upper limit of integral
    * @return the integral value.
    */
  def integrate(x0: Double = lowerX, x1: Double = upperX): Double = integrate(x1) - integrate(x0)
}

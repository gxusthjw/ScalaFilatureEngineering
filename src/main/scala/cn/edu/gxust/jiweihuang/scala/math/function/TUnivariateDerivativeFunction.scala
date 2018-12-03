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
  * <p>The trait {@code TUnivariateDerivativeFunction} is used for
  * representing analytical univariate derivative function.</p>
  *
  * @author JiweiHuang
  * @version 1.0.0_build-20181130
  * @see TUnivariateFunction
  */
trait TUnivariateDerivativeFunction extends TUnivariateFunction {

  /**
    * <p>The string form of analysis formula of
    * univariate derivative function.</p>
    */
  val dformula: String

  /**
    * <p>The method {@code derivative(x: Double)} is used to
    * get the derivative  value of univariate derivative function.</p>
    *
    * @param x independent variable.
    * @return the derivative value.
    */
  def derivative(x: Double): Double
}

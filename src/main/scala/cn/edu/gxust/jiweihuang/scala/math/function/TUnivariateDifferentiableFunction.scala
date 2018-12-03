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

import org.hipparchus.analysis.differentiation.{DSFactory, UnivariateDifferentiableFunction}

/**
  * <p>The trait [[TUnivariateDifferentiableFunction]] is used for
  * representing univariate differentiable function.it inherit from
  * the interface [[UnivariateDifferentiableFunction]] which in
  * {{{org.hipparchus.analysis.differentiation}}} package of Hipparchus
  * Library for utilizing the tools of numerical differentiation.</p>
  *
  * @author JiweiHuang
  * @version 1.0.0_build-20181130
  * @see TUnivariateFunction
  * @see UnivariateDifferentiableFunction
  */
trait TUnivariateDifferentiableFunction extends TUnivariateFunction
  with UnivariateDifferentiableFunction {
  /**
    * <p>The method {{{differential(x: Double, order: Int = 1)}}} is
    * used to get the differential value of univariate function
    * with any {{{order}}}.</p>
    * <p>it utilizes the algorithm of Rall's numbers.</p>
    *
    * @param x     independent variable.
    * @param order the differential order.
    * @return the differential value.
    */
  def differential(x: Double, order: Int = 1): Double =
    value(new DSFactory(1, order).variable(0,
      x)).getPartialDerivative(order)
}

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

/**
  * The trait {@code TQuadratic} is used for representing quadratic function.
  *
  * @author JiweiHuang.
  * @version 1.0.0_build-20181127.
  * @see TUnivariateDerivativeFunction
  * @see TUnivariateDifferentiableFunction
  * @see TUnivariateIntegrableFunction
  * @see TUnivariateIntegrateFunction
  */
trait TQuadratic extends TUnivariateDifferentiableFunction
  with TUnivariateIntegrableFunction
  with TUnivariateDerivativeFunction
  with TUnivariateIntegralFunction {
  /**
    * The vertex coordinates (x,y) of quadratic function
    */
  val vertex: Array[Double]
  /**
    * <p>whether quadratic function is invert.</p>
    * <p>if invert (i.e. open side down) return true else return false.</p>
    */
  val isInvert: Boolean
  /**
    * the x coordinate of intersection with x axis of function
    */
  val xIntersection: Array[Double]
  /**
    * the y coordinate of intersection with y axis of function
    */
  val yIntersection: Double
  /**
    * The number of intersection with x axis of function
    */
  val xIntersectionNum: Int
}

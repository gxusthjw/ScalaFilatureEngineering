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

import org.hipparchus.analysis.UnivariateFunction

/**
  * <p>The trait [[TUnivariateFunction]] is used for
  * representing univariate function.it inherit from
  * the interface [[UnivariateFunction]] which
  * in {org.hipparchus.analysis} of Hipparchus library
  * for utilizing the tools of numerical calculation.</p>
  *
  * @author JiweiHuang
  * @version 1.0.0_build-20181130
  * @see UnivariateFunction
  * @see Serializable
  */
trait TUnivariateFunction extends UnivariateFunction with Serializable {

  /**
    * The lower limit of independent variable.
    */
  val lowerX: Double = Double.MinValue

  /**
    * The upper limit of independent variable.
    */
  val upperX: Double = Double.MaxValue
  /**
    * The string form of analysis formula of univariate function.
    */
  val formula: String

  /**
    * <p>check the value {x} whether
    * is in interval of independent variable.</p>
    *
    * @param x independent variable.
    * @return boolean for whether the value { @code x} is
    *         in interval of independent variable.
    */
  def checkX(x: Double): Boolean = if (x >= lowerX && x <= upperX) true else false
}

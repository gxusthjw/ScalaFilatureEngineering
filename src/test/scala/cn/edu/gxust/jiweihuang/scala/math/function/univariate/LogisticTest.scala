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

import cn.edu.gxust.jiweihuang.scala.math.MathBase
import cn.edu.gxust.jiweihuang.scala.test.UnitSpec

class LogisticTest extends UnitSpec {

  "a Logistic" should "throw new IllegalArgumentException if {logisticM = 0}" in {
    assertThrows[IllegalArgumentException] {
      Logistic(0, 2, 3)
    }
  }

  it should "not throw new IllegalArgumentException if {logisticM = 0}" in {
    assert(Logistic(1, 2, 3).isInstanceOf[Logistic])
    assert(Logistic(1, 0, 3).isInstanceOf[Logistic])
    assert(Logistic(1, 2, 0).isInstanceOf[Logistic])
  }

  "the derivative of Logistic" should "equal the differential of Logistic" in {
    val logistic = Logistic(1, 2, 3)
    assert(logistic.derivative(0) - logistic.differential(0) <= NumericalConstants.PRECISION)
    assert(logistic.derivative(100) - logistic.differential(100) <= NumericalConstants.PRECISION)
    assert(logistic.derivative(-100) - logistic.differential(-100) <= NumericalConstants.PRECISION)
    assert(logistic.derivative(200) - logistic.differential(200) <= NumericalConstants.PRECISION)
    assert(logistic.derivative(-200) - logistic.differential(-200) <= NumericalConstants.PRECISION)
    assert(logistic.derivative(10) - logistic.differential(10) <= NumericalConstants.PRECISION)
    assert(logistic.derivative(5) - logistic.differential(5) <= NumericalConstants.PRECISION)
  }

  "the integrate of Logistic" should "equal to integralSimson of Logistic" in {
    val logistic = Logistic(1, 2, 3)
    assert(logistic.integrateRomberg(0, 100) - logistic.integrate(0, 100) <= 1e-8)
    //assert(logistic.integrateTrapezoid(0, 100) - logistic.integrate(0, 100) <= 1e-2)
    //assert(logistic.integrateMidPoint(0, 100) - logistic.integrate(0, 100) <= 1e-2)
    assert(logistic.integrateSimpson(0, 100) - logistic.integrate(0, 100) <= 1e-15)
    assert(logistic.integrateIterativeLegendreGauss(0, 100) - logistic.integrate(0, 100) <= 1e-5)
  }

}

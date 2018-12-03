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

import org.scalatest._

class QuadraticVertexTest extends FlatSpec {
  val qv: QuadraticVertex = {
    new QuadraticVertex(2, 3, 5)
  }
  "qv.value(2)" should "equal 7" in {
    assert(qv.value(2) == 7)
    assert(qv.value(3) == 5)
  }

  "qv.derivative" should "qv.differential" in {
    assert(qv.derivative(2.0) == qv.differential(2.0))
    assert(qv.derivative(-2.0) == qv.differential(-2.0))
    assert(qv.derivative(3.0) == qv.differential(3.0))
    assert(qv.derivative(-3.0) == qv.differential(-3.0))
    assert(qv.derivative(0.0) == qv.differential(0.0))
    assert(qv.derivative(-0.0) == qv.differential(-0.0))
    assert(qv.derivative(5.0) == qv.differential(5.0))
    assert(qv.derivative(-5.0) == qv.differential(-5.0))
    assert(qv.derivative(6.0) == qv.differential(6.0))
    assert(qv.derivative(-6.0) == qv.differential(-6.0))
    assert(qv.derivative(8.0) == qv.differential(8.0))
    assert(qv.derivative(9.0) == qv.differential(9.0))
    assert(qv.derivative(10.0) == qv.differential(10.0))
    assert(qv.derivative(12.0) == qv.differential(12.0))

  }

  "qv.integrate" should "qv.integrate****" in {
    println(s"qv.integrate(0, 10)=${qv.integrate(0, 10)}")
    println(s"qv.integrateMidPoint(0, 10)=${qv.integrateMidPoint(0, 10)}")
    println(s"qv.integrateRomberg(0, 10)=${qv.integrateRomberg(0, 10)}")
    println(s"qv.integrateSimpson(0, 10)=${qv.integrateSimpson(0, 10)}")
    println(s"qv.integrateTrapezoid(0, 10)=${qv.integrateTrapezoid(0, 10)}")
    assert(qv.integrate(0, 10) - qv.integrateMidPoint(0, 10) < 1e-3)
    assert(qv.integrate(0, 10) - qv.integrateRomberg(0, 10) < 1e-15)
    assert(qv.integrate(0, 10) - qv.integrateSimpson(0, 10) < 1e-15)
    assert(qv.integrate(0, 10) - qv.integrateTrapezoid(0, 10) < 1e-3)
  }

  "qv.isInvert" should "false" in {
    assert(qv.isInvert == false)
  }

  it should "produce IllegalArgumentException when QuadraticVertex is invoked with {quadraticVertexA=0}" in {
    assertThrows[IllegalArgumentException] {
      new QuadraticVertex(0, 2, 3)
    }
  }

}

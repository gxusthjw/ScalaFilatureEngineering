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

import org.hipparchus.analysis.differentiation.DerivativeStructure

import scala.math._

/**
  * <p>The class {@code QuadraticVertex} is used for representing
  * the vertex form of quadratic function.</p>
  *
  * <p>the formula:{@code q(x)=a*(x-b)^2+c}</p>
  *
  * @author JiweiHuang.
  * @version 1.0.0_build-20181127.
  * @see TQuadratic
  * @param quadraticVertexA the parameter {a} of the vertex form of quadratic function.
  * @param quadraticVertexB the parameter {b} of the vertex form of quadratic function.
  * @param quadraticVertexC the parameter {c} of the vertex form of quadratic function.
  */
final class QuadraticVertex(val quadraticVertexA: Double, val quadraticVertexB: Double,
                            val quadraticVertexC: Double) extends TQuadratic {
  /**
    * Ensure the parameters {@code quadraticVertexA != 0}
    */
  if (quadraticVertexA == 0) throw new IllegalArgumentException(s"Expected the parameter {quadraticVertexA != 0},but got {quadraticVertexA = $quadraticVertexA}.")
  /**
    * The vertex coordinates (x,y) of quadratic function
    */
  override val vertex: Array[Double] = Array(quadraticVertexB, quadraticVertexC)
  /**
    * <p>whether quadratic function is invert.</p>
    * <p>if invert (i.e. open side down) return true else return false.</p>
    */
  override val isInvert: Boolean = if (quadraticVertexA < 0) true else false
  /**
    * the x coordinate of intersection with x axis of function
    */
  override val xIntersection: Array[Double] = {
    val tem = -quadraticVertexC / quadraticVertexA
    if (tem > 0) Array[Double](quadraticVertexB - Math.sqrt(tem), quadraticVertexB + Math.sqrt(tem))
    else if (tem == 0) Array[Double](quadraticVertexB) else Array[Double]()
  }
  /**
    * the y coordinate of intersection with y axis of function
    */
  override val yIntersection: Double = quadraticVertexA * pow(quadraticVertexB, 2) +
    quadraticVertexC

  /**
    * The number of intersection with x axis of function
    */
  override val xIntersectionNum: Int = xIntersection.length
  /**
    * The String form of univariate function.
    */
  override val formula: String = s"$quadraticVertexA * pow(x - $quadraticVertexB, 2) + $quadraticVertexC"
  /**
    * The string form of univariate analytical integral function.
    */
  override val iformula: String = s"$quadraticVertexA * pow($quadraticVertexB, 2) * x + $quadraticVertexC * x - $quadraticVertexA * $quadraticVertexB * Math.pow(x, 2) + $quadraticVertexA * pow(x, 3) / 3"
  /**
    * <p>The string form of univariate analytical derivative function.</p>
    */
  override val dformula: String = s"2 * $quadraticVertexA * (x - $quadraticVertexB)"

  /**
    * <p>override the method of {@code UnivariateFunction},it can be used to
    * get the value of univariate function.</p>
    *
    * @param x independent variable
    * @return the value of univariate function.
    */
  override def value(x: Double): Double = {
    if (checkX(x)) quadraticVertexA * pow(x - quadraticVertexB, 2) + quadraticVertexC
    else
      throw new IllegalArgumentException(s"Expected the parameter {${lowerX} <= x:Double <= ${upperX}}")
  }

  /**
    * <p>override the method of {@code UnivariateDifferentiableFunction},
    * it can be used to get the differential value (i.e. derivative value) of
    * univariate function.</p>
    *
    * @param x independent variable
    * @return the differential value (i.e. derivative value)
    */
  override def value(x: DerivativeStructure): DerivativeStructure =
    x.subtract(quadraticVertexB).pow(2).multiply(quadraticVertexA).add(quadraticVertexC)

  /**
    * <p>The method {@code integrate(x: Double)} is used to
    * get value of analytical integral function.</p>
    *
    * @param x independent variable
    * @return integral value of analytical integral function.
    */
  override def integrate(x: Double): Double = quadraticVertexA * pow(quadraticVertexB, 2.0) * x +
    quadraticVertexC * x - quadraticVertexA * quadraticVertexB * Math.pow(x, 2.0) +
    quadraticVertexA * pow(x, 3) / 3.0 + integralConstant

  /**
    * <p>the method {@code derivative(x: Double)} is used to get the derivative value of
    * function at specified {@code x}.
    *
    * @param x independent variable
    * @return the derivative value of analytical derivative function.
    */
  override def derivative(x: Double): Double = 2 * quadraticVertexA * (x - quadraticVertexB)

  /**
    * The add operation for {@code QuadraticVertex} object and  a double number.
    *
    * @param n the operands
    * @return new { @code QuadraticVertex} object
    */
  def +(n: Double): QuadraticVertex = {
    new QuadraticVertex(quadraticVertexA, quadraticVertexB, quadraticVertexC + n)
  }

  /**
    * The subtraction operation for {@code QuadraticVertex} object and  a double number.
    *
    * @param n the operands
    * @return new { @code QuadraticVertex} object
    */
  def -(n: Double): QuadraticVertex = {
    new QuadraticVertex(quadraticVertexA, quadraticVertexB, quadraticVertexC - n)
  }

  /**
    * The multiplication operation for {@code QuadraticVertex} object and  a double number.
    *
    * @param n the operands
    * @return new { @code QuadraticVertex} object
    */
  def *(n: Double): QuadraticVertex = {
    new QuadraticVertex(quadraticVertexA * n, quadraticVertexB, quadraticVertexC * n)
  }

  /**
    * The division operation for {@code QuadraticVertex} object and  a double number.
    *
    * @param n the operands
    * @return new { @code QuadraticVertex} object
    */
  def /(n: Double): QuadraticVertex = {
    new QuadraticVertex(quadraticVertexA / n, quadraticVertexB, quadraticVertexC / n)
  }

  override def equals(other: Any): Boolean = other match {
    case that: QuadraticVertex =>
      (that canEqual this) &&
        quadraticVertexA == that.quadraticVertexA &&
        quadraticVertexB == that.quadraticVertexB &&
        quadraticVertexC == that.quadraticVertexC
    case _ => false
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[QuadraticVertex]

  override def hashCode(): Int = {
    val state = Seq(quadraticVertexA, quadraticVertexB, quadraticVertexC)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

/**
  * Companion Object for class {@code QuadraticVertex}.
  */
object QuadraticVertex {
  /**
    * in order to acquire ability of constructing {@code QuadraticVertex} object without new.
    */
  def apply(quadraticVertexA: Double, quadraticVertexB: Double, quadraticVertexC: Double): QuadraticVertex =
    new QuadraticVertex(quadraticVertexA, quadraticVertexB, quadraticVertexC)

  /**
    * in order to acquire ability of case information.
    */
  def unapply(qv: QuadraticVertex): Option[(Double, Double, Double)] = {
    if (qv == null) {
      None
    } else {
      Some(qv.quadraticVertexA, qv.quadraticVertexB, qv.quadraticVertexC)
    }
  }

}

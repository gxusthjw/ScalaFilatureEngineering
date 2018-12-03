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

abstract class QuadraticVertexLogistic(override val quadraticVertexA: Double,
                                       override val quadraticVertexB: Double,
                                       override val quadraticVertexC: Double,
                                       override val logisticM: Double,
                                       override val logisticK: Double,
                                       override val logisticX0: Double)
  extends TQuadraticVertexLogistic {

}
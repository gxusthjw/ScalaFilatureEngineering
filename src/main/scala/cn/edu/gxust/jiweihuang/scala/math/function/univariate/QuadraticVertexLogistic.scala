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

final case class QuadraticVertexLogistic(override val quadraticVertexA: Double = 1.0,
                                    override val quadraticVertexB: Double = 0.0,
                                    override val quadraticVertexC: Double = 0.0,
                                    override val logisticM: Double = 1.0,
                                    override val logisticK: Double = -1.0,
                                    override val logisticX0: Double = 0.0,
                                    override val quadraticVertexLogisticD: Double = 0.0)
  extends TQuadraticVertexLogistic
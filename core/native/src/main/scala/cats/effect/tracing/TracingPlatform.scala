/*
 * Copyright 2020-2022 Typelevel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cats.effect.tracing

import org.typelevel.scalaccompat.annotation._

private[tracing] abstract class TracingPlatform { self: Tracing.type =>

  @nowarn212("msg=never used")
  def calculateTracingEvent(key: Any): TracingEvent = null

  @nowarn212("msg=never used")
  private[tracing] def applyStackTraceFilter(
      callSiteClassName: String,
      callSiteMethodName: String,
      callSiteFileName: String): Boolean = false

  private[tracing] def decodeMethodName(name: String): String = name

}

/*
 * Copyright (C) 2016 David Clark
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package groovyx.net.http

import groovy.transform.CompileStatic
import spock.lang.Requires
import spock.lang.Specification;

@Requires(HttpBin)
class StaticCompilationSpec extends Specification {

    @CompileStatic
    def 'typed handlers should compile static'() {
        setup:
        def httpBin = HttpBuilder.configure {
            request.uri = 'http://httpbin.org/';
        }

        def resp = httpBin.get {
            response.success { FromServer fs, Object o ->
                return o.toString();
            }
        }

        String strResp = httpBin.get(String) {
            response.success { FromServer fs, Object o ->
                return o.toString();
            }
        }

        // No checks needed - simply verifying compilation
    }
}

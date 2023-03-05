/*
 * Copyright 2022 gRPC authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.grpc.examples.animals

import io.grpc.testing.GrpcServerRule
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class AnimalsServerTest {

    @get:Rule
    val grpcServerRule: GrpcServerRule = GrpcServerRule().directExecutor()

    @Test
    fun animals() = runBlocking {
        val dogService = AnimalsServer.DogService()
        grpcServerRule.serviceRegistry.addService(dogService)

        val dogStub = DogGrpcKt.DogCoroutineStub(grpcServerRule.channel)
        val dogBark = dogStub.bark(barkRequest { })
        assertEquals("Bark!", dogBark.message)
    }
}

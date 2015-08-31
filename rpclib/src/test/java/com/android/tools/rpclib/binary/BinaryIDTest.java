/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.tools.rpclib.binary;

import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BinaryIDTest extends TestCase {
  public void testDecodeObjectTypeID() throws IOException {
    ByteArrayInputStream input = new ByteArrayInputStream(TypeA.ID.getBytes());
    Decoder d = new Decoder(input);

    BinaryID idFromDecoder = new BinaryID(d);
    assertEquals(TypeA.ID, idFromDecoder);
  }

  public void testRegisterAndLookupObjectTypeID() {
    BinaryClass klass = Namespace.lookup(TypeA.ID);
    assertEquals(klass, TypeA.Klass.INSTANCE);
  }
}
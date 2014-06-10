/*
 * Copyright 2014 Real Logic Ltd.
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
package uk.co.real_logic.aeron.examples;

import uk.co.real_logic.aeron.Aeron;
import uk.co.real_logic.aeron.mediadriver.MediaDriver;

import java.util.concurrent.Executor;

/**
 * Utility functions for examples
 */
public class ExampleUtil
{
    public static MediaDriver createEmbeddedMediaDriver(final Executor executor) throws Exception
    {
        final MediaDriver mediaDriver = new MediaDriver();

        executor.execute(mediaDriver.receiver());
        executor.execute(mediaDriver.sender());
        executor.execute(mediaDriver.conductor());

        return mediaDriver;
    }

    public static Aeron createAeron(final Aeron.Context context, final Executor executor) throws Exception
    {
        final Aeron aeron = Aeron.newSingleMediaDriver(context);

        executor.execute(aeron.conductor());
        return aeron;
    }

    public static Aeron createAeron(final Aeron.Context context) throws Exception
    {
        final Aeron aeron = Aeron.newSingleMediaDriver(context);

        return aeron;
    }

}
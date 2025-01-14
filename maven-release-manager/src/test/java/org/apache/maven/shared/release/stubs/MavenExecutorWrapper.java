package org.apache.maven.shared.release.stubs;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import javax.inject.Named;
import javax.inject.Singleton;

import java.io.File;

import org.apache.maven.shared.release.ReleaseResult;
import org.apache.maven.shared.release.env.ReleaseEnvironment;
import org.apache.maven.shared.release.exec.MavenExecutor;
import org.apache.maven.shared.release.exec.MavenExecutorException;

@Singleton
@Named( "wrapper" )
public class MavenExecutorWrapper implements MavenExecutor
{
    private MavenExecutor executor;

    public void setMavenExecutor( MavenExecutor executor )
    {
        this.executor = executor;
    }

    @Override
    public void executeGoals( File workingDirectory, String goals, ReleaseEnvironment releaseEnvironment,
                              boolean interactive, String additionalArguments, String pomFileName,
                              ReleaseResult result )
        throws MavenExecutorException
    {
        executor.executeGoals( workingDirectory, goals, releaseEnvironment, interactive, additionalArguments,
                               pomFileName, result );
    }
}

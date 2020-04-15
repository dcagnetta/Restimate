/*
 * Copyright 2011-2014 the original author or authors.
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
/**
 * 
 */
package co.za.codeboss.core.command.handler;

import co.za.codeboss.core.annotations.Command;
/**
 * 
 * @author Dillan1
 *
 * @param <TCommand> command
 * @param <TResult> result type - for asynchronous {@link Command}commands (asynchronous=true) should be {@link Void}
 */
public interface ICommandHandler<TCommand, TResult> {
    public TResult handle(TCommand command);
}

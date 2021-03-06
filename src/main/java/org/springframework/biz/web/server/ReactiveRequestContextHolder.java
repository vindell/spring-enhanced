/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.springframework.biz.web.server;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.function.server.ServerResponse.Context;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * ReactiveRequestContextHolder
 *
 * @author L.cm
 */
public class ReactiveRequestContextHolder {
	
    static final Class<ServerWebExchange> EXCHANGE_KEY = ServerWebExchange.class;
    static final Class<ServerHttpRequest> REQUEST_KEY = ServerHttpRequest.class;
    static final Class<ServerHttpResponse> RESPONSE_KEY = ServerHttpResponse.class;
    
    /**
     * Gets the {@code Mono<ServerWebExchange>} from Reactor {@link Context}
     * @return the {@code Mono<ServerWebExchange>}
     */
    public static Mono<ServerWebExchange> getExchange() {
        return Mono.subscriberContext()
            .map(ctx -> ctx.get(EXCHANGE_KEY));
    }
    
    /**
     * Gets the {@code Mono<ServerHttpRequest>} from Reactor {@link Context}
     * @return the {@code Mono<ServerHttpRequest>}
     */
    public static Mono<ServerHttpRequest> getRequest() {
        return Mono.subscriberContext()
            .map(ctx -> ctx.get(REQUEST_KEY));
    }
    
    /**
     * Gets the {@code Mono<ServerHttpResponse>} from Reactor {@link Context}
     * @return the {@code Mono<ServerHttpResponse>}
     */
    public static Mono<ServerHttpResponse> getResponse() {
        return Mono.subscriberContext()
            .map(ctx -> ctx.get(RESPONSE_KEY));
    }

}
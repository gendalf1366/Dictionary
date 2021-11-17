package ru.gendalf13666.repo.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lru/gendalf13666/repo/api/BaseInterceptor;", "Lokhttp3/Interceptor;", "()V", "responseCode", "", "getResponseCode", "Lru/gendalf13666/repo/api/BaseInterceptor$ServerResponseStatusCode;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "ServerResponseStatusCode", "repo_debug"})
public final class BaseInterceptor implements okhttp3.Interceptor {
    private int responseCode = 0;
    public static final ru.gendalf13666.repo.api.BaseInterceptor.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.gendalf13666.repo.api.BaseInterceptor.ServerResponseStatusCode getResponseCode() {
        return null;
    }
    
    private BaseInterceptor() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lru/gendalf13666/repo/api/BaseInterceptor$ServerResponseStatusCode;", "", "(Ljava/lang/String;I)V", "INFO", "SUCCESS", "REDIRECTION", "CLIENT_ERROR", "SERVER_ERROR", "UNDEFINED_ERROR", "repo_debug"})
    public static enum ServerResponseStatusCode {
        /*public static final*/ INFO /* = new INFO() */,
        /*public static final*/ SUCCESS /* = new SUCCESS() */,
        /*public static final*/ REDIRECTION /* = new REDIRECTION() */,
        /*public static final*/ CLIENT_ERROR /* = new CLIENT_ERROR() */,
        /*public static final*/ SERVER_ERROR /* = new SERVER_ERROR() */,
        /*public static final*/ UNDEFINED_ERROR /* = new UNDEFINED_ERROR() */;
        
        ServerResponseStatusCode() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lru/gendalf13666/repo/api/BaseInterceptor$Companion;", "", "()V", "interceptor", "Lru/gendalf13666/repo/api/BaseInterceptor;", "getInterceptor", "()Lru/gendalf13666/repo/api/BaseInterceptor;", "repo_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final ru.gendalf13666.repo.api.BaseInterceptor getInterceptor() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}
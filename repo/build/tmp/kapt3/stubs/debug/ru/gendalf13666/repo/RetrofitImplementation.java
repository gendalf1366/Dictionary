package ru.gendalf13666.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lru/gendalf13666/repo/RetrofitImplementation;", "Lru/gendalf13666/repo/DataSource;", "", "Lru/gendalf13666/repo/model/data/DataModel;", "()V", "createOkHttpClient", "Lokhttp3/OkHttpClient;", "interceptor", "Lokhttp3/Interceptor;", "createRetrofit", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "getData", "word", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getService", "Lru/gendalf13666/repo/api/ApiService;", "Companion", "repo_debug"})
public final class RetrofitImplementation implements ru.gendalf13666.repo.DataSource<java.util.List<? extends ru.gendalf13666.repo.model.data.DataModel>> {
    private static final java.lang.String BASE_URL_LOCATIONS = "https://dictionary.skyeng.ru/api/public/v1/";
    public static final ru.gendalf13666.repo.RetrofitImplementation.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getData(@org.jetbrains.annotations.NotNull()
    java.lang.String word, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<ru.gendalf13666.repo.model.data.DataModel>> p1) {
        return null;
    }
    
    private final ru.gendalf13666.repo.api.ApiService getService(okhttp3.Interceptor interceptor) {
        return null;
    }
    
    private final retrofit2.Retrofit createRetrofit(okhttp3.Interceptor interceptor) {
        return null;
    }
    
    private final okhttp3.OkHttpClient createOkHttpClient(okhttp3.Interceptor interceptor) {
        return null;
    }
    
    public RetrofitImplementation() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lru/gendalf13666/repo/RetrofitImplementation$Companion;", "", "()V", "BASE_URL_LOCATIONS", "", "repo_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
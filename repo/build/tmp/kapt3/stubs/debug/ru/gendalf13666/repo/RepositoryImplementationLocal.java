package ru.gendalf13666.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lru/gendalf13666/repo/RepositoryImplementationLocal;", "Lru/gendalf13666/repo/RepositoryLocal;", "", "Lru/gendalf13666/repo/model/data/DataModel;", "dataSource", "Lru/gendalf13666/repo/DataSourceLocal;", "(Lru/gendalf13666/repo/DataSourceLocal;)V", "getData", "word", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveToDB", "", "appState", "Lru/gendalf13666/repo/model/data/AppState;", "(Lru/gendalf13666/repo/model/data/AppState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "repo_debug"})
public final class RepositoryImplementationLocal implements ru.gendalf13666.repo.RepositoryLocal<java.util.List<? extends ru.gendalf13666.repo.model.data.DataModel>> {
    private final ru.gendalf13666.repo.DataSourceLocal<java.util.List<ru.gendalf13666.repo.model.data.DataModel>> dataSource = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getData(@org.jetbrains.annotations.NotNull()
    java.lang.String word, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<ru.gendalf13666.repo.model.data.DataModel>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object saveToDB(@org.jetbrains.annotations.NotNull()
    ru.gendalf13666.repo.model.data.AppState appState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public RepositoryImplementationLocal(@org.jetbrains.annotations.NotNull()
    ru.gendalf13666.repo.DataSourceLocal<java.util.List<ru.gendalf13666.repo.model.data.DataModel>> dataSource) {
        super();
    }
}
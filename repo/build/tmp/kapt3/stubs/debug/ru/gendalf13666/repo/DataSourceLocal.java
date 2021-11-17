package ru.gendalf13666.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lru/gendalf13666/repo/DataSourceLocal;", "T", "Lru/gendalf13666/repo/DataSource;", "saveToDB", "", "appState", "Lru/gendalf13666/repo/model/data/AppState;", "(Lru/gendalf13666/repo/model/data/AppState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "repo_debug"})
public abstract interface DataSourceLocal<T extends java.lang.Object> extends ru.gendalf13666.repo.DataSource<T> {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveToDB(@org.jetbrains.annotations.NotNull()
    ru.gendalf13666.repo.model.data.AppState appState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
}
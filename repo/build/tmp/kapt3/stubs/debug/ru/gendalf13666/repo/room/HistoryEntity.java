package ru.gendalf13666.repo.room;

import java.lang.System;

@androidx.room.Entity(indices = {@androidx.room.Index(unique = true, value = {"word"})})
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\f"}, d2 = {"Lru/gendalf13666/repo/room/HistoryEntity;", "", "word", "", "description", "(Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getWord", "setWord", "repo_debug"})
public final class HistoryEntity {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "word")
    @androidx.room.PrimaryKey()
    private java.lang.String word;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "description")
    private java.lang.String description;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWord() {
        return null;
    }
    
    public final void setWord(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public HistoryEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String word, @org.jetbrains.annotations.Nullable()
    java.lang.String description) {
        super();
    }
}
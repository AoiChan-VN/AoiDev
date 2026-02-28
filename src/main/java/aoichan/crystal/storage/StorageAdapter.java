package aoidev.crystal.storage;

import aoidev.crystal.gem.Gem;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface StorageAdapter {

    CompletableFuture<Void> save(Gem gem);

    CompletableFuture<Void> delete(UUID id);

    CompletableFuture<List<Gem>> loadAll();

    void shutdown();
}

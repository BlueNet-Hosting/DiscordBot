package com.bluenet.database;

import com.bluenet.cache.*;
import com.bluenet.utils.Ref;
import com.zaxxer.hikari.pool.HikariPool;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SQLDatabase {

    @SuppressWarnings("rawtypes")
    private static final class SQLTimer extends TimerTask {
        private final List<Cache<?, ?>> caches;

        public SQLTimer(final List<Cache<?, ?>> caches) {
            this.caches = caches;
        }

        @Override
        public void run() {
            for (final Cache cache : caches) {
                cache.tick();
            }
        }
    }

    private <A, B> ThreadSafeCache<A, B> newCache(Class<A> clazz, int cacheTime) {
        if (caches.isLocked()) {
            return null;
        }
        ThreadSafeCache<A, B> cache = new ThreadSafeCache<>(clazz, cacheTime);
        caches.get().add(cache);
        return cache;
    }

    private final Timer timer;

    private final Ref<List<Cache<?, ?>>> caches = Ref.of(new ArrayList<>());
    private final ExecutorService service = Executors.newCachedThreadPool();

    private final HikariPool pool;

    public SQLDatabase(Logger logger, final IPoolProvider provider) {
        caches.get();
        this.pool = Objects.requireNonNull(provider, "Provider can not be null").createPool();
        this.timer = new Timer();
        timer.scheduleAtFixedRate(new SQLTimer(caches.set(Collections.unmodifiableList(caches.get())).lock().get()), 0, 1000);
        try (Connection connection = pool.getConnection(15000)) {
            final PreparedStatement statement = connection.prepareStatement("/* ping */  SELECT 1");
            statement.setQueryTimeout(15);
            statement.executeQuery();
            createDatabase();
        } catch (final SQLException exception) {
            shutdown();
            logger.error("MySQL connection test failed: " + exception);
        }
    }

    public Connection connection() throws SQLException {
        return pool.getConnection();
    }

    private void createDatabase() {
        try (Connection connection = connection()){
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void shutdown() {
        try {
            pool.shutdown();
        } catch (final Throwable ignored) {
        }
    }

}

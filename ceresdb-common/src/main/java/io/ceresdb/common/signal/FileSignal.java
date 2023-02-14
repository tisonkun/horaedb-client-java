/*
 * Copyright 2023 CeresDB Project Authors. Licensed under Apache-2.0.
 */
package io.ceresdb.common.signal;

import java.util.Optional;

public enum FileSignal {
    ClearCache("clear_cache.sig", "How to clear route cache"), //
    RwLogging("rw_logging.sig", "How to open or close read/write log(The second execution means close)"), //
    RpcLimit("rpc_limit.sig", "How to open or close rpc limiter(The second execution means close)"), //
    ;

    private final String filename;
    private final String comment;

    FileSignal(String filename, String comment) {
        this.filename = filename;
        this.comment = comment;
    }

    public String getFilename() {
        return filename;
    }

    public String getComment() {
        return comment;
    }

    public static Optional<FileSignal> parse(final String name) {
        for (final FileSignal sig : values()) {
            if (sig.filename.equals(name)) {
                return Optional.of(sig);
            }
        }
        return Optional.empty();
    }
}

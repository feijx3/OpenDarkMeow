/*
 * Decompiled with CFR 0.152.
 */
package dev.babbaj.pathfinder.xz;

import dev.babbaj.pathfinder.xz.af;
import dev.babbaj.pathfinder.xz.f;
import dev.babbaj.pathfinder.xz.w;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class ai {
    private final w a;
    public long a = 0L;
    public long b = 0L;
    public long c = 0L;
    public long d = 0L;

    ai(f f2) {
        this.a = f2;
    }

    public final long a() {
        return (long)(1 + af.a(this.d)) + this.c + 4L;
    }

    public long b() {
        return this.a() + 3L & 0xFFFFFFFFFFFFFFFCL;
    }

    public long c() {
        return 12L + this.a + this.b() + 12L;
    }

    void a(long l2, long l3) {
        this.a += l2 + 3L & 0xFFFFFFFFFFFFFFFCL;
        this.b += l3;
        this.c += (long)(af.a(l2) + af.a(l3));
        ++this.d;
        if (this.a < 0L || this.b < 0L || this.b() > 0x400000000L || this.c() < 0L) {
            throw this.a;
        }
    }
}


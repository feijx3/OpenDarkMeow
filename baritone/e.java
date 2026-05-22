/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lk
 *  lk$b
 *  lk$c
 */
package baritone;

import baritone.api.Settings;
import baritone.api.behavior.ILookBehavior;
import baritone.api.behavior.look.IAimProcessor;
import baritone.api.behavior.look.ITickableAimProcessor;
import baritone.api.event.events.PacketEvent;
import baritone.api.event.events.PlayerUpdateEvent;
import baritone.api.event.events.RotationMoveEvent;
import baritone.api.event.events.TickEvent;
import baritone.api.event.events.WorldEvent;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.Rotation;
import baritone.g;
import baritone.k;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class e
extends baritone.c
implements ILookBehavior {
    public c a;
    public Rotation a;
    private Rotation b;
    public final b a;
    private final Deque<Float> a;
    private final Deque<Float> b;

    public e(baritone.a a2) {
        super(a2);
        this.a = new b(a2.getPlayerContext());
        this.a = new ArrayDeque();
        this.b = new ArrayDeque();
    }

    @Override
    public final void updateTarget(Rotation rotation, boolean bl2) {
        this.a = new c(rotation, c.a.a((IPlayerContext)((Object)this.a), bl2));
    }

    @Override
    public final IAimProcessor getAimProcessor() {
        return this.a;
    }

    @Override
    public final void onTick(TickEvent tickEvent) {
        if (tickEvent.getType() == TickEvent.Type.IN) {
            this.a.tick();
        }
    }

    @Override
    public final void onPlayerUpdate(PlayerUpdateEvent object) {
        if (this.a == null) {
            return;
        }
        switch (((PlayerUpdateEvent)object).getState()) {
            case PRE: {
                if (this.a.a == c.a.b) {
                    return;
                }
                this.b = new Rotation(this.a.player().v, this.a.player().w);
                object = this.a.peekRotation(this.a.a);
                this.a.player().v = ((Rotation)object).getYaw();
                this.a.player().w = ((Rotation)object).getPitch();
                return;
            }
            case POST: {
                if (this.b != null) {
                    this.a.addLast(Float.valueOf(this.a.a.getYaw()));
                    while (this.a.size() > (Integer)baritone.a.a().smoothLookTicks.value) {
                        this.a.removeFirst();
                    }
                    this.b.addLast(Float.valueOf(this.a.a.getPitch()));
                    while (this.b.size() > (Integer)baritone.a.a().smoothLookTicks.value) {
                        this.b.removeFirst();
                    }
                    if (this.a.a == c.a.a) {
                        this.a.player().v = this.b.getYaw();
                        this.a.player().w = this.b.getPitch();
                    } else if ((this.a.player().cP() ? (Boolean)baritone.a.a().elytraSmoothLook.value : (Boolean)baritone.a.a().smoothLook.value).booleanValue()) {
                        this.a.player().v = (float)this.a.stream().mapToDouble(f2 -> f2.floatValue()).average().orElse(this.b.getYaw());
                        if (this.a.player().cP()) {
                            this.a.player().w = (float)this.b.stream().mapToDouble(f2 -> f2.floatValue()).average().orElse(this.b.getPitch());
                        }
                    }
                    this.b = null;
                }
                this.a = null;
            }
        }
    }

    @Override
    public final void onSendPacket(PacketEvent packetEvent) {
        if (!(packetEvent.getPacket() instanceof lk)) {
            return;
        }
        if ((packetEvent = (lk)packetEvent.getPacket()) instanceof lk.c || packetEvent instanceof lk.b) {
            this.a = new Rotation(packetEvent.a(0.0f), packetEvent.b(0.0f));
        }
    }

    @Override
    public final void onWorldEvent(WorldEvent worldEvent) {
        this.a = null;
        this.a = null;
    }

    @Override
    public final void onPlayerRotationMove(RotationMoveEvent rotationMoveEvent) {
        if (this.a != null) {
            Rotation rotation = this.a.peekRotation(this.a.a);
            rotationMoveEvent.setYaw(rotation.getYaw());
            rotationMoveEvent.setPitch(rotation.getPitch());
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    public static final class c {
        public final Rotation a;
        public final int a;

        public c(Rotation rotation, int n2) {
            this.a = rotation;
            this.a = n2;
        }

        public static int a(double d2) {
            return (int)(d2 + 1.073741824E9) - 0x40000000;
        }

        public static int b(double d2) {
            return 0x40000000 - (int)(1.073741824E9 - d2);
        }

        static final class a
        extends Enum<a> {
            public static final int a = 2;
            public static final int b = 3;

            static int a(IPlayerContext iPlayerContext, boolean bl2) {
                Settings settings = baritone.a.a();
                boolean bl3 = (Boolean)settings.antiCheatCompatibility.value;
                boolean bl4 = (Boolean)settings.blockFreeLook.value;
                if (iPlayerContext.player().cP()) {
                    if (((Boolean)settings.elytraFreeLook.value).booleanValue()) {
                        return 2;
                    }
                    return 1;
                }
                if (((Boolean)settings.freeLook.value).booleanValue()) {
                    if (bl2) {
                        if (bl4) {
                            return 2;
                        }
                        return 1;
                    }
                    if (bl3) {
                        return 2;
                    }
                    return 3;
                }
                return 1;
            }

            static {
                int[] nArray = new int[]{1, 2, 3};
            }
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    public static abstract class a
    implements ITickableAimProcessor {
        protected final IPlayerContext a;
        private final k a;
        private double a;
        private double b;

        public a(IPlayerContext iPlayerContext) {
            this.a = iPlayerContext;
            this.a = new k();
        }

        private a(a a2) {
            this.a = a2.a;
            k k2 = a2.a;
            this.a = new k(Arrays.copyOf(k2.a, 4));
            this.a = a2.a;
            this.b = a2.b;
        }

        @Override
        public final Rotation peekRotation(Rotation rotation) {
            Rotation rotation2 = this.a();
            float f2 = rotation.getYaw();
            float f3 = rotation.getPitch();
            if (f3 == rotation2.getPitch()) {
                f3 = f3 < -20.0f ? f3 + 1.0f : (f3 > 10.0f ? f3 - 1.0f : f3);
            }
            f2 = (float)((double)f2 + this.a);
            f3 = (float)((double)f3 + this.b);
            return new Rotation(this.a(rotation2.getYaw(), f2), this.a(rotation2.getPitch(), f3)).clamp();
        }

        @Override
        public final void tick() {
            this.a = (this.a.a() - 0.5) * (Double)baritone.a.a().randomLooking.value;
            this.b = (this.a.a() - 0.5) * (Double)baritone.a.a().randomLooking.value;
        }

        @Override
        public final void advance(int n2) {
            for (int i2 = 0; i2 < n2; ++i2) {
                this.tick();
            }
        }

        @Override
        public Rotation nextRotation(Rotation rotation) {
            rotation = this.peekRotation(rotation);
            this.tick();
            return rotation;
        }

        @Override
        public final ITickableAimProcessor fork() {
            a a2 = this;
            return new g(a2, a2);
        }

        protected abstract Rotation a();

        private float a(float f2, float f3) {
            int n2 = this.a(f3 -= f2);
            return f2 + this.a(n2);
        }

        private int a(float f2) {
            float f3 = this.a(1);
            return Math.round(f2 / f3);
        }

        private float a(int n2) {
            float f2 = this.a.minecraft().t.c * 0.6f + 0.2f;
            return (float)n2 * f2 * f2 * f2 * 8.0f * 0.15f;
        }

        /* synthetic */ a(a a2, byte by2) {
            this(a2);
        }
    }

    public static final class b
    extends a {
        public b(IPlayerContext iPlayerContext) {
            super(iPlayerContext);
        }

        @Override
        protected final Rotation a() {
            return this.a.playerRotations();
        }
    }
}


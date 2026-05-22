/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aed
 *  nf
 *  vg
 *  vi
 *  vq
 */
package baritone.command.defaults;

import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.argument.IArgConsumer;
import baritone.api.command.datatypes.EntityClassById;
import baritone.api.command.datatypes.IDatatypeFor;
import baritone.api.command.datatypes.NearbyPlayer;
import baritone.api.command.exception.CommandErrorMessageException;
import baritone.api.command.helpers.TabCompleteHelper;
import baritone.api.process.IFollowProcess;
import baritone.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public final class FollowCommand
extends Command {
    public FollowCommand(IBaritone iBaritone) {
        super(iBaritone, "follow");
    }

    @Override
    public final void execute(String object, IArgConsumer iArgConsumer) {
        Object object2;
        IFollowProcess iFollowProcess;
        iArgConsumer.requireMin(1);
        ArrayList<vg> arrayList = new ArrayList<vg>();
        ArrayList<Class> arrayList2 = new ArrayList<Class>();
        if (iArgConsumer.hasExactlyOne()) {
            iFollowProcess = this.baritone.getFollowProcess();
            object = iArgConsumer.getEnum(FollowGroup.class);
            object2 = ((FollowGroup)((Object)object)).a;
        } else {
            iArgConsumer.requireMin(2);
            object = null;
            FollowList followList = iArgConsumer.getEnum(FollowList.class);
            while (iArgConsumer.hasAny()) {
                Object t2 = iArgConsumer.getDatatypeFor(followList.a);
                if (t2 instanceof Class) {
                    arrayList2.add((Class)t2);
                    continue;
                }
                if (t2 == null) continue;
                arrayList.add((vg)t2);
            }
            iFollowProcess = this.baritone.getFollowProcess();
            object2 = arrayList2.isEmpty() ? arrayList::contains : vg2 -> arrayList2.stream().anyMatch(clazz -> clazz.isInstance(vg2));
        }
        iFollowProcess.follow((Predicate<vg>)object2);
        if (object != null) {
            this.logDirect(String.format("Following all %s", ((Enum)object).name().toLowerCase(Locale.US)));
            return;
        }
        if (arrayList2.isEmpty()) {
            if (arrayList.isEmpty()) {
                throw new a();
            }
            this.logDirect("Following these entities:");
            arrayList.stream().map(vg::toString).forEach(this::logDirect);
            return;
        }
        this.logDirect("Following these types of entities:");
        arrayList2.stream().map(vi::a).map(Objects::requireNonNull).map(nf::toString).forEach(this::logDirect);
    }

    @Override
    public final Stream<String> tabComplete(String object, IArgConsumer iArgConsumer) {
        if (iArgConsumer.hasExactlyOne()) {
            return new TabCompleteHelper().append(FollowGroup.class).append(FollowList.class).filterPrefix(iArgConsumer.getString()).stream();
        }
        try {
            object = iArgConsumer.getEnum(FollowList.class).a;
        }
        catch (NullPointerException nullPointerException) {
            return Stream.empty();
        }
        while (iArgConsumer.has(2)) {
            if (iArgConsumer.peekDatatypeOrNull(object) == null) {
                return Stream.empty();
            }
            iArgConsumer.get();
        }
        return iArgConsumer.tabCompleteDatatype(object);
    }

    @Override
    public final String getShortDesc() {
        return "Follow entity things";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("The follow command tells Baritone to follow certain kinds of entities.", "", "Usage:", "> follow entities - Follows all entities.", "> follow entity <entity1> <entity2> <...> - Follow certain entities (for example 'skeleton', 'horse' etc.)", "> follow players - Follow players", "> follow player <username1> <username2> <...> - Follow certain players");
    }

    public static final class a
    extends CommandErrorMessageException {
        protected a() {
            super("No valid entities in range!");
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    @b
    static final class FollowList
    extends Enum<FollowList> {
        private static /* enum */ FollowList a = new FollowList(EntityClassById.INSTANCE);
        private static /* enum */ FollowList b = new FollowList(NearbyPlayer.INSTANCE);
        final IDatatypeFor a;
        private static final /* synthetic */ FollowList[] a;

        public static FollowList[] values() {
            return (FollowList[])a.clone();
        }

        public static FollowList valueOf(String string) {
            return Enum.valueOf(FollowList.class, string);
        }

        private FollowList(IDatatypeFor iDatatypeFor) {
            this.a = iDatatypeFor;
        }

        static {
            a = new FollowList[]{a, b};
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    @b
    static final class FollowGroup
    extends Enum<FollowGroup> {
        private static /* enum */ FollowGroup a = new FollowGroup(vq.class::isInstance);
        private static /* enum */ FollowGroup b = new FollowGroup(aed.class::isInstance);
        final Predicate<vg> a;
        private static final /* synthetic */ FollowGroup[] a;

        public static FollowGroup[] values() {
            return (FollowGroup[])a.clone();
        }

        public static FollowGroup valueOf(String string) {
            return Enum.valueOf(FollowGroup.class, string);
        }

        private FollowGroup(Predicate<vg> predicate) {
            this.a = predicate;
        }

        static {
            a = new FollowGroup[]{a, b};
        }
    }
}


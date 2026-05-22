/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  a
 *  hg
 *  hg$a
 *  hh
 *  hj
 *  hj$a
 *  ho
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.cache.IWaypoint;
import baritone.api.cache.IWorldData;
import baritone.api.cache.Waypoint;
import baritone.api.command.Command;
import baritone.api.command.IBaritoneChatControl;
import baritone.api.command.argument.IArgConsumer;
import baritone.api.command.datatypes.ForWaypoints;
import baritone.api.command.datatypes.RelativeBlockPos;
import baritone.api.command.exception.CommandInvalidStateException;
import baritone.api.command.exception.CommandInvalidTypeException;
import baritone.api.command.helpers.Paginator;
import baritone.api.command.helpers.TabCompleteHelper;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.utils.BetterBlockPos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class bs
extends Command {
    private Map<IWorldData, List<IWaypoint>> a = new HashMap<IWorldData, List<IWaypoint>>();

    public bs(IBaritone iBaritone) {
        super(iBaritone, "waypoints", "waypoint", "wp");
    }

    @Override
    public final void execute(String string, IArgConsumer iArgConsumer) {
        a a3 = iArgConsumer.hasAny() ? baritone.bs$a.a(iArgConsumer.getString()) : baritone.bs$a.a;
        if (a3 == null) {
            throw new CommandInvalidTypeException(iArgConsumer.consumed(), "an action");
        }
        Object object2 = (iWaypoint, a2) -> {
            ho ho2 = new ho("");
            ho ho3 = new ho(iWaypoint.getTag().name() + " ");
            ho3.b().a(a.h);
            String string2 = iWaypoint.getName();
            ho ho4 = new ho(!string2.isEmpty() ? string2 : "<empty>");
            ho4.b().a(!string2.isEmpty() ? a.h : a.i);
            string2 = new ho(" @ " + new Date(iWaypoint.getCreationTimestamp()));
            string2.b().a(a.i);
            ho2.a((hh)ho3);
            ho2.a((hh)ho4);
            ho2.a((hh)string2);
            ho2.b().a(new hj(hj.a.a, (hh)new ho("Click to select"))).a(new hg(hg.a.c, String.format("%s%s %s %s @ %d", IBaritoneChatControl.FORCE_COMMAND_PREFIX, string, ((a)a2).a[0], iWaypoint.getTag().getName(), iWaypoint.getCreationTimestamp())));
            return ho2;
        };
        Function<IWaypoint, hh> function = iWaypoint -> (hh)object2.apply(iWaypoint, a3 == baritone.bs$a.a ? baritone.bs$a.d : a3);
        if (a3 == baritone.bs$a.a) {
            IWaypoint[] iWaypointArray;
            IWaypoint.Tag tag = iArgConsumer.hasAny() ? IWaypoint.Tag.getByName(iArgConsumer.peekString()) : null;
            if (tag != null) {
                iArgConsumer.get();
            }
            if ((iWaypointArray = tag != null ? ForWaypoints.getWaypointsByTag(this.baritone, tag) : ForWaypoints.getWaypoints(this.baritone)).length > 0) {
                iArgConsumer.requireMax(1);
                Paginator.paginate(iArgConsumer, iWaypointArray, () -> this.logDirect(tag != null ? String.format("All waypoints by tag %s:", tag.name()) : "All waypoints:"), function, String.format("%s%s %s%s", IBaritoneChatControl.FORCE_COMMAND_PREFIX, string, a3.a[0], tag != null ? " " + tag.getName() : ""));
                return;
            }
            iArgConsumer.requireMax(0);
            throw new CommandInvalidStateException(tag != null ? "No waypoints found by that tag" : "No waypoints found");
        }
        if (a3 == baritone.bs$a.c) {
            IWaypoint.Tag tag = iArgConsumer.hasAny() ? IWaypoint.Tag.getByName(iArgConsumer.peekString()) : null;
            if (tag == null) {
                tag = IWaypoint.Tag.USER;
            } else {
                iArgConsumer.get();
            }
            String string2 = iArgConsumer.hasExactlyOne() || iArgConsumer.hasExactly(4) ? iArgConsumer.getString() : "";
            BetterBlockPos betterBlockPos = iArgConsumer.hasAny() ? (BetterBlockPos)((Object)iArgConsumer.getDatatypePost(RelativeBlockPos.INSTANCE, this.ctx.playerFeet())) : this.ctx.playerFeet();
            iArgConsumer.requireMax(0);
            Waypoint waypoint = new Waypoint(string2, tag, betterBlockPos);
            ForWaypoints.waypoints(this.baritone).addWaypoint(waypoint);
            ho ho2 = new ho("Waypoint added: ");
            ho2.b().a(a.h);
            ho2.a((hh)object2.apply(waypoint, baritone.bs$a.d));
            this.logDirect(new hh[]{ho2});
            return;
        }
        if (a3 == baritone.bs$a.b) {
            ho ho3;
            iArgConsumer.requireMax(1);
            String string3 = iArgConsumer.getString();
            IWaypoint.Tag tag = IWaypoint.Tag.getByName(string3);
            if (tag == null) {
                throw new CommandInvalidStateException("Invalid tag, \"" + string3 + "\"");
            }
            ho ho4 = ho3 = ForWaypoints.getWaypointsByTag(this.baritone, tag);
            int n2 = ((IWaypoint[])ho3).length;
            for (int i2 = 0; i2 < n2; ++i2) {
                IWaypoint iWaypoint2 = ho4[i2];
                ForWaypoints.waypoints(this.baritone).removeWaypoint(iWaypoint2);
            }
            this.a.computeIfAbsent(this.baritone.getWorldProvider().getCurrentWorld(), iWorldData -> new ArrayList()).addAll(Arrays.asList(ho3));
            ho4 = new ho(String.format("Cleared %d waypoints, click to restore them", ((IWaypoint[])ho3).length));
            ho4.b().a(new hg(hg.a.c, String.format("%s%s restore @ %s", IBaritoneChatControl.FORCE_COMMAND_PREFIX, string, Stream.of(ho3).map(iWaypoint -> Long.toString(iWaypoint.getCreationTimestamp())).collect(Collectors.joining(" ")))));
            this.logDirect(new hh[]{ho4});
            return;
        }
        if (a3 == baritone.bs$a.f) {
            ArrayList<Object> arrayList = new ArrayList();
            List list = this.a.getOrDefault(this.baritone.getWorldProvider().getCurrentWorld(), Collections.emptyList());
            if (iArgConsumer.peekString().equals("@")) {
                iArgConsumer.get();
                block5: while (iArgConsumer.hasAny()) {
                    long l2 = iArgConsumer.getAs(Long.class);
                    for (Object object2 : list) {
                        if (object2.getCreationTimestamp() != l2) continue;
                        arrayList.add(object2);
                        continue block5;
                    }
                }
            } else {
                iArgConsumer.requireExactly(1);
                int n3 = list.size();
                int n4 = Math.min(n3, iArgConsumer.getAs(Integer.class));
                arrayList = new ArrayList(list.subList(n3 - n4, n3));
            }
            arrayList.forEach(ForWaypoints.waypoints(this.baritone)::addWaypoint);
            list.removeIf(arrayList::contains);
            this.logDirect(String.format("Restored %d waypoints", arrayList.size()));
            return;
        }
        ho ho5 = (ho)iArgConsumer.getDatatypeFor(ForWaypoints.INSTANCE);
        IWaypoint iWaypoint3 = null;
        if (iArgConsumer.hasAny() && iArgConsumer.peekString().equals("@")) {
            iArgConsumer.requireExactly(2);
            iArgConsumer.get();
            long l3 = iArgConsumer.getAs(Long.class);
            for (IWaypoint iWaypoint4 : ho5) {
                if (iWaypoint4.getCreationTimestamp() != l3) continue;
                iWaypoint3 = iWaypoint4;
                break;
            }
            if (iWaypoint3 == null) {
                throw new CommandInvalidStateException("Timestamp was specified but no waypoint was found");
            }
        } else {
            switch (((IWaypoint[])ho5).length) {
                case 0: {
                    throw new CommandInvalidStateException("No waypoints found");
                }
                case 1: {
                    iWaypoint3 = ho5[0];
                }
            }
        }
        if (iWaypoint3 == null) {
            iArgConsumer.requireMax(1);
            Paginator.paginate(iArgConsumer, ho5, () -> this.logDirect("Multiple waypoints were found:"), function, String.format("%s%s %s %s", IBaritoneChatControl.FORCE_COMMAND_PREFIX, string, a3.a[0], iArgConsumer.consumedString()));
            return;
        }
        if (a3 == baritone.bs$a.d) {
            this.logDirect(function.apply(iWaypoint3));
            this.logDirect(String.format("Position: %s", new Object[]{iWaypoint3.getLocation()}));
            ho ho6 = new ho("Click to delete this waypoint");
            ho6.b().a(new hg(hg.a.c, String.format("%s%s delete %s @ %d", IBaritoneChatControl.FORCE_COMMAND_PREFIX, string, iWaypoint3.getTag().getName(), iWaypoint3.getCreationTimestamp())));
            ho ho7 = new ho("Click to set goal to this waypoint");
            ho7.b().a(new hg(hg.a.c, String.format("%s%s goal %s @ %d", IBaritoneChatControl.FORCE_COMMAND_PREFIX, string, iWaypoint3.getTag().getName(), iWaypoint3.getCreationTimestamp())));
            ho ho8 = new ho("Click to show a command to recreate this waypoint");
            ho8.b().a(new hg(hg.a.d, String.format("%s%s save %s %s %s %s %s", baritone.a.a().prefix.value, string, iWaypoint3.getTag().getName(), iWaypoint3.getName(), iWaypoint3.getLocation().a, iWaypoint3.getLocation().b, iWaypoint3.getLocation().c)));
            ho ho9 = new ho("Click to return to the waypoints list");
            ho9.b().a(new hg(hg.a.c, String.format("%s%s list", IBaritoneChatControl.FORCE_COMMAND_PREFIX, string)));
            this.logDirect(new hh[]{ho6});
            this.logDirect(new hh[]{ho7});
            this.logDirect(new hh[]{ho8});
            this.logDirect(new hh[]{ho9});
            return;
        }
        if (a3 == baritone.bs$a.e) {
            ForWaypoints.waypoints(this.baritone).removeWaypoint(iWaypoint3);
            this.a.computeIfAbsent(this.baritone.getWorldProvider().getCurrentWorld(), iWorldData -> new ArrayList()).add(iWaypoint3);
            ho ho10 = new ho("That waypoint has successfully been deleted, click to restore it");
            ho10.b().a(new hg(hg.a.c, String.format("%s%s restore @ %s", IBaritoneChatControl.FORCE_COMMAND_PREFIX, string, iWaypoint3.getCreationTimestamp())));
            this.logDirect(new hh[]{ho10});
            return;
        }
        if (a3 == baritone.bs$a.g) {
            GoalBlock goalBlock = new GoalBlock(iWaypoint3.getLocation());
            this.baritone.getCustomGoalProcess().setGoal(goalBlock);
            this.logDirect(String.format("Goal: %s", goalBlock));
            return;
        }
        if (a3 == baritone.bs$a.h) {
            GoalBlock goalBlock = new GoalBlock(iWaypoint3.getLocation());
            this.baritone.getCustomGoalProcess().setGoalAndPath(goalBlock);
            this.logDirect(String.format("Going to: %s", goalBlock));
        }
    }

    @Override
    public final Stream<String> tabComplete(String object, IArgConsumer iArgConsumer) {
        if (iArgConsumer.hasAny()) {
            if (iArgConsumer.hasExactlyOne()) {
                return new TabCompleteHelper().append(baritone.bs$a.a()).sortAlphabetically().filterPrefix(iArgConsumer.getString()).stream();
            }
            object = baritone.bs$a.a(iArgConsumer.getString());
            if (iArgConsumer.hasExactlyOne()) {
                if (object == baritone.bs$a.a || object == baritone.bs$a.c || object == baritone.bs$a.b) {
                    return new TabCompleteHelper().append(IWaypoint.Tag.getAllNames()).sortAlphabetically().filterPrefix(iArgConsumer.getString()).stream();
                }
                if (object == baritone.bs$a.f) {
                    return Stream.empty();
                }
                return iArgConsumer.tabCompleteDatatype(ForWaypoints.INSTANCE);
            }
            if (iArgConsumer.has(3) && object == baritone.bs$a.c) {
                iArgConsumer.get();
                iArgConsumer.get();
                return iArgConsumer.tabCompleteDatatype(RelativeBlockPos.INSTANCE);
            }
        }
        return Stream.empty();
    }

    @Override
    public final String getShortDesc() {
        return "Manage waypoints";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("The waypoint command allows you to manage Baritone's waypoints.", "", "Waypoints can be used to mark positions for later. Waypoints are each given a tag and an optional name.", "", "Note that the info, delete, and goal commands let you specify a waypoint by tag. If there is more than one waypoint with a certain tag, then they will let you select which waypoint you mean.", "", "Missing arguments for the save command use the USER tag, creating an unnamed waypoint and your current position as defaults.", "", "Usage:", "> wp [l/list] - List all waypoints.", "> wp <l/list> <tag> - List all waypoints by tag.", "> wp <s/save> - Save an unnamed USER waypoint at your current position", "> wp <s/save> [tag] [name] [pos] - Save a waypoint with the specified tag, name and position.", "> wp <i/info/show> <tag/name> - Show info on a waypoint by tag or name.", "> wp <d/delete> <tag/name> - Delete a waypoint by tag or name.", "> wp <restore> <n> - Restore the last n deleted waypoints.", "> wp <c/clear> <tag> - Delete all waypoints with the specified tag.", "> wp <g/goal> <tag/name> - Set a goal to a waypoint by tag or name.", "> wp <goto> <tag/name> - Set a goal to a waypoint by tag or name and start pathing.");
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a("list", "get", "l");
        public static final /* enum */ a b = new a("clear", "c");
        public static final /* enum */ a c = new a("save", "s");
        public static final /* enum */ a d = new a("info", "show", "i");
        public static final /* enum */ a e = new a("delete", "d");
        public static final /* enum */ a f = new a("restore");
        public static final /* enum */ a g = new a("goal", "g");
        public static final /* enum */ a h = new a("goto");
        private final String[] a;
        private static final /* synthetic */ a[] a;

        public static a[] values() {
            return (a[])a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        private a(String ... stringArray) {
            this.a = stringArray;
        }

        public static a a(String string) {
            for (a a2 : baritone.bs$a.values()) {
                String[] stringArray = a2.a;
                int n2 = a2.a.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (!stringArray[i2].equalsIgnoreCase(string)) continue;
                    return a2;
                }
            }
            return null;
        }

        public static String[] a() {
            HashSet<String> hashSet = new HashSet<String>();
            for (a a2 : baritone.bs$a.values()) {
                hashSet.addAll(Arrays.asList(a2.a));
            }
            return hashSet.toArray(new String[0]);
        }

        static {
            a = new a[]{a, b, c, d, e, f, g, h};
        }
    }
}


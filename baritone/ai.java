/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  a
 *  bse
 *  hg
 *  hg$a
 *  hh
 *  hj
 *  hj$a
 *  ho
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.IBaritoneChatControl;
import baritone.api.command.argument.IArgConsumer;
import baritone.api.command.exception.CommandInvalidStateException;
import baritone.api.command.helpers.TabCompleteHelper;
import baritone.api.pathing.goals.Goal;
import baritone.api.process.IElytraProcess;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ai
extends Command {
    public ai(IBaritone iBaritone) {
        super(iBaritone, "elytra");
    }

    @Override
    public final void execute(String object, IArgConsumer object2) {
        object = this.baritone.getCustomGoalProcess();
        IElytraProcess iElytraProcess = this.baritone.getElytraProcess();
        if (object2.hasExactlyOne() && object2.peekString().equals("supported")) {
            this.logDirect(iElytraProcess.isLoaded() ? "yes" : ai.a());
            return;
        }
        if (!iElytraProcess.isLoaded()) {
            throw new CommandInvalidStateException(ai.a());
        }
        if (!object2.hasAny()) {
            if (((Boolean)baritone.a.a().elytraTermsAccepted.value).booleanValue()) {
                if (this.a()) {
                    long l2;
                    object2 = this;
                    if (((Boolean)baritone.a.a().elytraPredictTerrain.value).booleanValue() && (l2 = ((Long)baritone.a.a().elytraNetherSeed.value).longValue()) != 146008555100680L && l2 != -4100785268875389365L) {
                        object2.logDirect(new hh[]{new ho("It looks like you're on 2b2t, but elytraNetherSeed is incorrect.")});
                        object2.logDirect(ai.a());
                    }
                }
            } else {
                object2 = this;
                ho ho2 = new ho("");
                ho2.a("To disable this message, enable the setting elytraTermsAccepted\n");
                ho2.a("Baritone Elytra is an experimental feature. It is only intended for long distance travel in the Nether using fireworks for vanilla boost. It will not work with any other mods (\"hacks\") for non-vanilla boost. ");
                ho ho3 = new ho("If you want Baritone to attempt to take off from the ground for you, you can enable the elytraAutoJump setting (not advisable on laggy servers!). ");
                ho3.b().a(new hj(hj.a.a, (hh)new ho((String)baritone.a.a().prefix.value + "set elytraAutoJump true")));
                ho2.a((hh)ho3);
                ho ho4 = new ho("If you want Baritone to go slower, enable the elytraConserveFireworks setting and/or decrease the elytraFireworkSpeed setting. ");
                ho4.b().a(new hj(hj.a.a, (hh)new ho((String)baritone.a.a().prefix.value + "set elytraConserveFireworks true\n" + (String)baritone.a.a().prefix.value + "set elytraFireworkSpeed 0.6\n(the 0.6 number is just an example, tweak to your liking)")));
                ho2.a((hh)ho4);
                ho4 = new ho("Baritone Elytra ");
                ho ho5 = new ho("wants to know the seed");
                ho5.b().a(a.m).d(Boolean.TRUE).a(Boolean.TRUE);
                ho4.a((hh)ho5);
                ho4.a(" of the world you are in. If it doesn't have the correct seed, it will frequently backtrack. It uses the seed to generate terrain far beyond what you can see, since terrain obstacles in the Nether can be much larger than your render distance. ");
                ho2.a((hh)ho4);
                ho2.a("\n");
                if (super.a()) {
                    ho4 = new ho("It looks like you're on 2b2t. ");
                    ho4.a(ai.a());
                    if (!((Boolean)baritone.a.a().elytraPredictTerrain.value).booleanValue()) {
                        ho4.a((String)baritone.a.a().prefix.value + "elytraPredictTerrain is currently disabled. ");
                    } else if ((Long)baritone.a.a().elytraNetherSeed.value == 146008555100680L) {
                        ho4.a("You are using the newer seed. ");
                    } else if ((Long)baritone.a.a().elytraNetherSeed.value == -4100785268875389365L) {
                        ho4.a("You are using the older seed. ");
                    } else {
                        ho4.a("Defaulting to the newer seed. ");
                        baritone.a.a().elytraNetherSeed.value = 146008555100680L;
                    }
                    ho2.a((hh)ho4);
                } else if ((Long)baritone.a.a().elytraNetherSeed.value == 146008555100680L) {
                    ho4 = new ho("Baritone doesn't know the seed of your world. Set it with: " + (String)baritone.a.a().prefix.value + "set elytraNetherSeed seedgoeshere\n");
                    ho4.a("For the time being, elytraPredictTerrain is defaulting to false since the seed is unknown.");
                    ho2.a((hh)ho4);
                    baritone.a.a().elytraPredictTerrain.value = Boolean.FALSE;
                } else if (((Boolean)baritone.a.a().elytraPredictTerrain.value).booleanValue()) {
                    ho4 = new ho("Baritone Elytra is predicting terrain assuming that " + baritone.a.a().elytraNetherSeed.value + " is the correct seed. Change that with " + (String)baritone.a.a().prefix.value + "set elytraNetherSeed seedgoeshere, or disable it with " + (String)baritone.a.a().prefix.value + "set elytraPredictTerrain false");
                    ho2.a((hh)ho4);
                } else {
                    ho4 = new ho("Baritone Elytra is not predicting terrain. If you don't know the seed, this is the correct thing to do. If you do know the seed, input it with " + (String)baritone.a.a().prefix.value + "set elytraNetherSeed seedgoeshere, and then enable it with " + (String)baritone.a.a().prefix.value + "set elytraPredictTerrain true");
                    ho2.a((hh)ho4);
                }
                object2.logDirect(new hh[]{ho2});
            }
            if ((object = object.mostRecentGoal()) == null) {
                throw new CommandInvalidStateException("No goal has been set");
            }
            if (this.ctx.player().am != -1) {
                throw new CommandInvalidStateException("Only works in the nether");
            }
            try {
                iElytraProcess.pathTo((Goal)object);
                return;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new CommandInvalidStateException(illegalArgumentException.getMessage());
            }
        }
        switch (object2.getString()) {
            case "reset": {
                iElytraProcess.resetState();
                this.logDirect("Reset state but still flying to same goal");
                return;
            }
            case "repack": {
                iElytraProcess.repackChunks();
                this.logDirect("Queued all loaded chunks for repacking");
                return;
            }
        }
        throw new CommandInvalidStateException("Invalid action");
    }

    private static hh a() {
        ho ho2 = new ho("");
        ho2.a("Within a few hundred blocks of spawn/axis/highways/etc, the terrain is too fragmented to be predictable. Baritone Elytra will still work, just with backtracking. ");
        ho2.a("However, once you get more than a few thousand blocks out, you should try ");
        ho ho3 = new ho("the older seed (click here)");
        ho3.b().d(Boolean.TRUE).a(Boolean.TRUE).a(new hj(hj.a.a, (hh)new ho((String)baritone.a.a().prefix.value + "set elytraNetherSeed -4100785268875389365"))).a(new hg(hg.a.c, IBaritoneChatControl.FORCE_COMMAND_PREFIX + "set elytraNetherSeed -4100785268875389365"));
        ho2.a((hh)ho3);
        ho2.a(". Once you're further out into newer terrain generation (this includes everything up through 1.12), you should try ");
        ho3 = new ho("the newer seed (click here)");
        ho3.b().d(Boolean.TRUE).a(Boolean.TRUE).a(new hj(hj.a.a, (hh)new ho((String)baritone.a.a().prefix.value + "set elytraNetherSeed 146008555100680"))).a(new hg(hg.a.c, IBaritoneChatControl.FORCE_COMMAND_PREFIX + "set elytraNetherSeed 146008555100680"));
        ho2.a((hh)ho3);
        ho2.a(". Once you get into 1.19 terrain, the terrain becomes unpredictable again, due to custom non-vanilla generation, and you should set #elytraPredictTerrain to false. ");
        return ho2;
    }

    private boolean a() {
        bse bse2 = this.ctx.minecraft().C();
        return bse2 != null && bse2.b.toLowerCase().contains("2b2t.org");
    }

    @Override
    public final Stream<String> tabComplete(String object, IArgConsumer iArgConsumer) {
        object = new TabCompleteHelper();
        if (iArgConsumer.hasExactlyOne()) {
            ((TabCompleteHelper)object).append("reset", "repack", "supported");
        }
        return ((TabCompleteHelper)object).filterPrefix(iArgConsumer.getString()).stream();
    }

    @Override
    public final String getShortDesc() {
        return "elytra time";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("The elytra command tells baritone to, in the nether, automatically fly to the current goal.", "", "Usage:", "> elytra - fly to the current goal", "> elytra reset - Resets the state of the process, but will try to keep flying to the same goal.", "> elytra repack - Queues all of the chunks in render distance to be given to the native library.", "> elytra supported - Tells you if baritone ships a native library that is compatible with your PC.");
    }

    private static String a() {
        String string = System.getProperty("os.arch");
        String string2 = System.getProperty("os.name");
        return String.format("Legacy architectures are not supported. Your CPU is %s and your operating system is %s. Supported architectures are 64 bit x86, and 64 bit ARM. Supported operating systems are Windows, Linux, and Mac", string, string2);
    }
}


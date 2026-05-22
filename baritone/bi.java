/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aox
 *  awt
 *  fa
 *  fa$a
 *  fq
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.command.Command;
import baritone.api.command.argument.IArgConsumer;
import baritone.api.command.datatypes.ForAxis;
import baritone.api.command.datatypes.ForBlockOptionalMeta;
import baritone.api.command.datatypes.ForEnumFacing;
import baritone.api.command.datatypes.RelativeBlockPos;
import baritone.api.command.exception.CommandInvalidStateException;
import baritone.api.command.exception.CommandInvalidTypeException;
import baritone.api.command.helpers.TabCompleteHelper;
import baritone.api.schematic.CompositeSchematic;
import baritone.api.schematic.FillSchematic;
import baritone.api.schematic.ISchematic;
import baritone.api.schematic.MaskSchematic;
import baritone.api.schematic.ReplaceSchematic;
import baritone.api.schematic.ShellSchematic;
import baritone.api.schematic.WallsSchematic;
import baritone.api.schematic.mask.shape.CylinderMask;
import baritone.api.schematic.mask.shape.SphereMask;
import baritone.api.selection.ISelection;
import baritone.api.selection.ISelectionManager;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.BlockOptionalMeta;
import baritone.api.utils.BlockOptionalMetaLookup;
import baritone.bj;
import baritone.bk;
import baritone.ex;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bi
extends Command {
    private ISelectionManager a;
    private BetterBlockPos a;
    private ISchematic a;
    private fq a;

    public bi(IBaritone iBaritone) {
        super(iBaritone, "sel", "selection", "s");
        this.a = this.baritone.getSelectionManager();
        this.a = null;
        this.a = null;
        this.a = null;
        iBaritone.getGameEventHandler().registerEventListener(new bj(this));
    }

    @Override
    public final void execute(String object, IArgConsumer a2) {
        object = baritone.bi$a.a(a2.getString());
        if (object == null) {
            throw new CommandInvalidTypeException(a2.consumed(), "an action");
        }
        if (object == baritone.bi$a.a || object == baritone.bi$a.b) {
            if (object == baritone.bi$a.b && this.a == null) {
                throw new CommandInvalidStateException("Set pos1 first before using pos2");
            }
            BetterBlockPos betterBlockPos = this.ctx.viewerPos();
            BetterBlockPos betterBlockPos2 = a2.hasAny() ? (BetterBlockPos)((Object)a2.getDatatypePost(RelativeBlockPos.INSTANCE, betterBlockPos)) : betterBlockPos;
            a2.requireMax(0);
            if (object == baritone.bi$a.a) {
                this.a = betterBlockPos2;
                this.logDirect("Position 1 has been set");
                return;
            }
            this.a.addSelection(this.a, betterBlockPos2);
            this.a = null;
            this.logDirect("Selection added");
            return;
        }
        if (object == baritone.bi$a.c) {
            a2.requireMax(0);
            this.a = null;
            this.logDirect(String.format("Removed %d selections", this.a.removeAllSelections().length));
            return;
        }
        if (object == baritone.bi$a.d) {
            a2.requireMax(0);
            if (this.a != null) {
                this.a = null;
                this.logDirect("Undid pos1");
                return;
            }
            ISelection[] iSelectionArray = this.a.getSelections();
            if (iSelectionArray.length <= 0) {
                throw new CommandInvalidStateException("Nothing to undo!");
            }
            this.a = this.a.removeSelection(iSelectionArray[iSelectionArray.length - 1]).pos1();
            this.logDirect("Undid pos2");
            return;
        }
        if (((a)((Object)object)).a()) {
            BetterBlockPos betterBlockPos;
            int n2;
            BlockOptionalMetaLookup blockOptionalMetaLookup;
            ISelection[] iSelectionArray;
            BlockOptionalMeta blockOptionalMeta;
            BlockOptionalMeta blockOptionalMeta2 = blockOptionalMeta = object == baritone.bi$a.k ? new BlockOptionalMeta(aox.a) : (BlockOptionalMeta)a2.getDatatypeFor(ForBlockOptionalMeta.INSTANCE);
            if (object == baritone.bi$a.l) {
                a2.requireMin(1);
                iSelectionArray = new ArrayList();
                iSelectionArray.add(blockOptionalMeta);
                while (a2.has(2)) {
                    iSelectionArray.add(a2.getDatatypeFor(ForBlockOptionalMeta.INSTANCE));
                }
                blockOptionalMeta = (BlockOptionalMeta)a2.getDatatypeFor(ForBlockOptionalMeta.INSTANCE);
                blockOptionalMetaLookup = new BlockOptionalMetaLookup(iSelectionArray.toArray(new BlockOptionalMeta[0]));
                a2 = null;
            } else if (object == baritone.bi$a.i || object == baritone.bi$a.j) {
                a2.requireMax(1);
                a2 = a2.hasAny() ? (fa.a)a2.getDatatypeFor(ForAxis.INSTANCE) : fa.a.b;
                blockOptionalMetaLookup = null;
            } else {
                a2.requireMax(0);
                blockOptionalMetaLookup = null;
                a2 = null;
            }
            iSelectionArray = this.a.getSelections();
            if (iSelectionArray.length == 0) {
                throw new CommandInvalidStateException("No selections");
            }
            BetterBlockPos betterBlockPos3 = iSelectionArray[0].min();
            CompositeSchematic compositeSchematic = new CompositeSchematic(0, 0, 0);
            ISelection[] iSelectionArray2 = iSelectionArray;
            int n3 = iSelectionArray.length;
            for (n2 = 0; n2 < n3; ++n2) {
                betterBlockPos = iSelectionArray2[n2].min();
                betterBlockPos3 = new BetterBlockPos(Math.min(betterBlockPos3.a, betterBlockPos.a), Math.min(betterBlockPos3.b, betterBlockPos.b), Math.min(betterBlockPos3.c, betterBlockPos.c));
            }
            iSelectionArray2 = iSelectionArray;
            n3 = iSelectionArray.length;
            for (n2 = 0; n2 < n3; ++n2) {
                Object object2 = iSelectionArray2[n2];
                betterBlockPos = object2.size();
                object2 = object2.min();
                ISchematic iSchematic = (ISchematic)((UnaryOperator)arg_0 -> bi.a((a)((Object)object), blockOptionalMetaLookup, a2, arg_0)).apply(new FillSchematic(betterBlockPos.p(), betterBlockPos.q(), betterBlockPos.r(), blockOptionalMeta));
                compositeSchematic.put(iSchematic, ((BetterBlockPos)((Object)object2)).a - betterBlockPos3.a, ((BetterBlockPos)((Object)object2)).b - betterBlockPos3.b, ((BetterBlockPos)((Object)object2)).c - betterBlockPos3.c);
            }
            this.baritone.getBuilderProcess().build("Fill", compositeSchematic, (fq)betterBlockPos3);
            this.logDirect("Filling now");
            return;
        }
        if (object == baritone.bi$a.n) {
            BetterBlockPos betterBlockPos;
            awt[][][] awtArray = this.ctx.viewerPos();
            awt[][][] awtArray2 = a2.hasAny() ? (BetterBlockPos)((Object)a2.getDatatypePost(RelativeBlockPos.INSTANCE, awtArray)) : awtArray;
            a2.requireMax(0);
            a2 = this.a.getSelections();
            if (((ISelection[])a2).length <= 0) {
                throw new CommandInvalidStateException("No selections");
            }
            ex ex2 = new ex(this.ctx);
            BetterBlockPos betterBlockPos4 = a2[0].min();
            CompositeSchematic compositeSchematic = new CompositeSchematic(0, 0, 0);
            fa.a a3 = a2;
            int n4 = ((fa.a)a3).length;
            for (int i2 = 0; i2 < n4; ++i2) {
                betterBlockPos = a3[i2].min();
                betterBlockPos4 = new BetterBlockPos(Math.min(betterBlockPos4.a, betterBlockPos.a), Math.min(betterBlockPos4.b, betterBlockPos.b), Math.min(betterBlockPos4.c, betterBlockPos.c));
            }
            for (Object object3 : a2) {
                betterBlockPos = object3.size();
                object3 = object3.min();
                awtArray = new awt[betterBlockPos.p()][betterBlockPos.r()][betterBlockPos.q()];
                for (int i3 = 0; i3 < betterBlockPos.p(); ++i3) {
                    for (int i4 = 0; i4 < betterBlockPos.q(); ++i4) {
                        for (int i5 = 0; i5 < betterBlockPos.r(); ++i5) {
                            awtArray[i3][i5][i4] = ex2.a(object3.a + i3, object3.b + i4, object3.c + i5);
                        }
                    }
                }
                bk bk2 = new bk(this, awtArray, (fq)betterBlockPos);
                compositeSchematic.put(bk2, object3.a - betterBlockPos4.a, object3.b - betterBlockPos4.b, object3.c - betterBlockPos4.c);
            }
            this.a = compositeSchematic;
            this.a = betterBlockPos4.b((fq)awtArray2);
            this.logDirect("Selection copied");
            return;
        }
        if (object == baritone.bi$a.o) {
            BetterBlockPos betterBlockPos = this.ctx.viewerPos();
            BetterBlockPos betterBlockPos5 = a2.hasAny() ? (BetterBlockPos)((Object)a2.getDatatypePost(RelativeBlockPos.INSTANCE, betterBlockPos)) : betterBlockPos;
            a2.requireMax(0);
            if (this.a == null) {
                throw new CommandInvalidStateException("You need to copy a selection first");
            }
            this.baritone.getBuilderProcess().build("Fill", this.a, (fq)betterBlockPos5.a(this.a));
            this.logDirect("Building now");
            return;
        }
        if (object == baritone.bi$a.m || object == baritone.bi$a.p || object == baritone.bi$a.q) {
            a2.requireExactly(3);
            b b2 = b.a(a2.getString());
            if (b2 == null) {
                throw new CommandInvalidStateException("Invalid transform type");
            }
            fa fa2 = (fa)a2.getDatatypeFor(ForEnumFacing.INSTANCE);
            int n5 = a2.getAs(Integer.class);
            ISelection[] iSelectionArray = this.a.getSelections();
            if (iSelectionArray.length <= 0) {
                throw new CommandInvalidStateException("No selections found");
            }
            iSelectionArray = (ISelection[])b2.a.apply(iSelectionArray);
            ISelection[] iSelectionArray3 = iSelectionArray;
            int n6 = iSelectionArray.length;
            for (int i6 = 0; i6 < n6; ++i6) {
                ISelection iSelection = iSelectionArray3[i6];
                if (object == baritone.bi$a.m) {
                    this.a.expand(iSelection, fa2, n5);
                    continue;
                }
                if (object == baritone.bi$a.p) {
                    this.a.contract(iSelection, fa2, n5);
                    continue;
                }
                this.a.shift(iSelection, fa2, n5);
            }
            this.logDirect(String.format("Transformed %d selections", iSelectionArray.length));
        }
    }

    @Override
    public final Stream<String> tabComplete(String object, IArgConsumer iArgConsumer) {
        if (iArgConsumer.hasExactlyOne()) {
            return new TabCompleteHelper().append(baritone.bi$a.a()).filterPrefix(iArgConsumer.getString()).sortAlphabetically().stream();
        }
        object = baritone.bi$a.a(iArgConsumer.getString());
        if (object != null) {
            if (object == baritone.bi$a.a || object == baritone.bi$a.b) {
                if (iArgConsumer.hasAtMost(3)) {
                    return iArgConsumer.tabCompleteDatatype(RelativeBlockPos.INSTANCE);
                }
            } else if (((a)((Object)object)).a()) {
                if (iArgConsumer.hasExactlyOne() || object == baritone.bi$a.l) {
                    while (iArgConsumer.has(2)) {
                        iArgConsumer.get();
                    }
                    return iArgConsumer.tabCompleteDatatype(ForBlockOptionalMeta.INSTANCE);
                }
                if (iArgConsumer.hasExactly(2) && (object == baritone.bi$a.i || object == baritone.bi$a.j)) {
                    iArgConsumer.get();
                    return iArgConsumer.tabCompleteDatatype(ForAxis.INSTANCE);
                }
            } else if (object == baritone.bi$a.m || object == baritone.bi$a.p || object == baritone.bi$a.q) {
                if (iArgConsumer.hasExactlyOne()) {
                    return new TabCompleteHelper().append(b.a()).filterPrefix(iArgConsumer.getString()).sortAlphabetically().stream();
                }
                if (b.a(iArgConsumer.getString()) != null && iArgConsumer.hasExactlyOne()) {
                    return iArgConsumer.tabCompleteDatatype(ForEnumFacing.INSTANCE);
                }
            }
        }
        return Stream.empty();
    }

    @Override
    public final String getShortDesc() {
        return "WorldEdit-like commands";
    }

    @Override
    public final List<String> getLongDesc() {
        return Arrays.asList("The sel command allows you to manipulate Baritone's selections, similarly to WorldEdit.", "", "Using these selections, you can clear areas, fill them with blocks, or something else.", "", "The expand/contract/shift commands use a kind of selector to choose which selections to target. Supported ones are a/all, n/newest, and o/oldest.", "", "Usage:", "> sel pos1/p1/1 - Set position 1 to your current position.", "> sel pos1/p1/1 <x> <y> <z> - Set position 1 to a relative position.", "> sel pos2/p2/2 - Set position 2 to your current position.", "> sel pos2/p2/2 <x> <y> <z> - Set position 2 to a relative position.", "", "> sel clear/c - Clear the selection.", "> sel undo/u - Undo the last action (setting positions, creating selections, etc.)", "> sel set/fill/s/f [block] - Completely fill all selections with a block.", "> sel walls/w [block] - Fill in the walls of the selection with a specified block.", "> sel shell/shl [block] - The same as walls, but fills in a ceiling and floor too.", "> sel sphere/sph [block] - Fills the selection with a sphere bounded by the sides.", "> sel hsphere/hsph [block] - The same as sphere, but hollow.", "> sel cylinder/cyl [block] <axis> - Fills the selection with a cylinder bounded by the sides, oriented about the given axis. (default=y)", "> sel hcylinder/hcyl [block] <axis> - The same as cylinder, but hollow.", "> sel cleararea/ca - Basically 'set air'.", "> sel replace/r <blocks...> <with> - Replaces blocks with another block.", "> sel copy/cp <x> <y> <z> - Copy the selected area relative to the specified or your position.", "> sel paste/p <x> <y> <z> - Build the copied area relative to the specified or your position.", "", "> sel expand <target> <direction> <blocks> - Expand the targets.", "> sel contract <target> <direction> <blocks> - Contract the targets.", "> sel shift <target> <direction> <blocks> - Shift the targets (does not resize).");
    }

    private static /* synthetic */ ISchematic a(a a2, BlockOptionalMetaLookup blockOptionalMetaLookup, fa.a a3, ISchematic iSchematic) {
        int n2 = iSchematic.widthX();
        int n3 = iSchematic.heightY();
        int n4 = iSchematic.lengthZ();
        switch (a2) {
            case e: {
                return new WallsSchematic(iSchematic);
            }
            case f: {
                return new ShellSchematic(iSchematic);
            }
            case l: {
                return new ReplaceSchematic(iSchematic, blockOptionalMetaLookup);
            }
            case g: {
                return MaskSchematic.create(iSchematic, new SphereMask(n2, n3, n4, true).compute());
            }
            case h: {
                return MaskSchematic.create(iSchematic, new SphereMask(n2, n3, n4, false).compute());
            }
            case i: {
                return MaskSchematic.create(iSchematic, new CylinderMask(n2, n3, n4, true, a3).compute());
            }
            case j: {
                return MaskSchematic.create(iSchematic, new CylinderMask(n2, n3, n4, false, a3).compute());
            }
        }
        return iSchematic;
    }

    static /* synthetic */ BetterBlockPos a(bi bi2) {
        return bi2.a;
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     * Exception performing whole class analysis.
     */
    static final class b
    extends Enum<b> {
        private static /* enum */ b a;
        private static /* enum */ b b;
        private static /* enum */ b c;
        final Function<ISelection[], ISelection[]> a;
        private final String[] a;
        private static final /* synthetic */ b[] a;

        public static b[] values() {
            return (b[])a.clone();
        }

        public static b valueOf(String string) {
            return Enum.valueOf(b.class, string);
        }

        private b(Function<ISelection[], ISelection[]> function, String ... stringArray) {
            super(string, n2);
            this.a = function;
            this.a = stringArray;
        }

        public static b a(String string) {
            for (b b2 : baritone.bi$b.values()) {
                String[] stringArray = b2.a;
                int n2 = b2.a.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (!stringArray[i2].equalsIgnoreCase(string)) continue;
                    return b2;
                }
            }
            return null;
        }

        public static String[] a() {
            HashSet<String> hashSet = new HashSet<String>();
            for (b b2 : baritone.bi$b.values()) {
                hashSet.addAll(Arrays.asList(b2.a));
            }
            return hashSet.toArray(new String[0]);
        }

        private static /* synthetic */ ISelection[] a(ISelection[] iSelectionArray) {
            return new ISelection[]{iSelectionArray[0]};
        }

        /*
         * Exception decompiling
         */
        static {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * 
             * java.lang.UnsupportedOperationException
             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.NewAnonymousArray.getDimSize(NewAnonymousArray.java:142)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.isNewArrayLambda(LambdaRewriter.java:455)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteDynamicExpression(LambdaRewriter.java:409)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteDynamicExpression(LambdaRewriter.java:167)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteExpression(LambdaRewriter.java:105)
             *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExpressionRewriterHelper.applyForwards(ExpressionRewriterHelper.java:12)
             *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractConstructorInvokation.applyExpressionRewriter(AbstractConstructorInvokation.java:65)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteExpression(LambdaRewriter.java:103)
             *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredAssignment.rewriteExpressions(StructuredAssignment.java:146)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewrite(LambdaRewriter.java:88)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.rewriteLambdas(Op04StructuredStatement.java:1137)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:912)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
             *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
             *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:923)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
             *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
             *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
             *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
             *     at org.benf.cfr.reader.Main.main(Main.java:54)
             */
            throw new IllegalStateException("Decompilation failed");
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a("pos1", "p1", "1");
        public static final /* enum */ a b = new a("pos2", "p2", "2");
        public static final /* enum */ a c = new a("clear", "c");
        public static final /* enum */ a d = new a("undo", "u");
        private static /* enum */ a r = new a("set", "fill", "s", "f");
        public static final /* enum */ a e = new a("walls", "w");
        public static final /* enum */ a f = new a("shell", "shl");
        public static final /* enum */ a g = new a("sphere", "sph");
        public static final /* enum */ a h = new a("hsphere", "hsph");
        public static final /* enum */ a i = new a("cylinder", "cyl");
        public static final /* enum */ a j = new a("hcylinder", "hcyl");
        public static final /* enum */ a k = new a("cleararea", "ca");
        public static final /* enum */ a l = new a("replace", "r");
        public static final /* enum */ a m = new a("expand", "ex");
        public static final /* enum */ a n = new a("copy", "cp");
        public static final /* enum */ a o = new a("paste", "p");
        public static final /* enum */ a p = new a("contract", "ct");
        public static final /* enum */ a q = new a("shift", "sh");
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
            for (a a2 : baritone.bi$a.values()) {
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
            for (a a2 : baritone.bi$a.values()) {
                hashSet.addAll(Arrays.asList(a2.a));
            }
            return hashSet.toArray(new String[0]);
        }

        public final boolean a() {
            return this == r || this == e || this == f || this == g || this == h || this == i || this == j || this == k || this == l;
        }

        static {
            a = new a[]{a, b, c, d, r, e, f, g, h, i, j, k, l, m, n, o, p, q};
        }
    }
}


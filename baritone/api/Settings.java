/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ain
 *  aow
 *  aox
 *  bib
 *  fq
 *  hh
 */
package baritone.api;

import baritone.api.utils.NotificationHelper;
import baritone.api.utils.SettingsUtil;
import baritone.api.utils.TypeUtils;
import baritone.api.utils.gui.BaritoneToast;
import java.awt.Color;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class Settings {
    public final Setting<Boolean> allowBreak = new Setting(Boolean.TRUE);
    public final Setting<List<aow>> allowBreakAnyway = new Setting(new ArrayList());
    public final Setting<Boolean> allowSprint = new Setting(Boolean.TRUE);
    public final Setting<Boolean> allowPlace = new Setting(Boolean.TRUE);
    public final Setting<Boolean> allowInventory = new Setting(Boolean.FALSE);
    public final Setting<Integer> ticksBetweenInventoryMoves = new Setting(1);
    public final Setting<Boolean> inventoryMoveOnlyIfStationary = new Setting(Boolean.FALSE);
    public final Setting<Boolean> assumeExternalAutoTool = new Setting(Boolean.FALSE);
    public final Setting<Boolean> autoTool = new Setting(Boolean.TRUE);
    public final Setting<Double> blockPlacementPenalty = new Setting(20.0);
    public final Setting<Double> blockBreakAdditionalPenalty = new Setting(2.0);
    public final Setting<Double> jumpPenalty = new Setting(2.0);
    public final Setting<Double> walkOnWaterOnePenalty = new Setting(3.0);
    public final Setting<Boolean> strictLiquidCheck = new Setting(Boolean.FALSE);
    public final Setting<Boolean> allowWaterBucketFall = new Setting(Boolean.TRUE);
    public final Setting<Boolean> assumeWalkOnWater = new Setting(Boolean.FALSE);
    public final Setting<Boolean> assumeWalkOnLava = new Setting(Boolean.FALSE);
    public final Setting<Boolean> assumeStep = new Setting(Boolean.FALSE);
    public final Setting<Boolean> assumeSafeWalk = new Setting(Boolean.FALSE);
    public final Setting<Boolean> allowJumpAt256 = new Setting(Boolean.FALSE);
    public final Setting<Boolean> allowParkourAscend = new Setting(Boolean.TRUE);
    public final Setting<Boolean> allowDiagonalDescend = new Setting(Boolean.FALSE);
    public final Setting<Boolean> allowDiagonalAscend = new Setting(Boolean.FALSE);
    public final Setting<Boolean> allowDownward = new Setting(Boolean.TRUE);
    public final Setting<List<ain>> acceptableThrowawayItems = new Setting(new ArrayList<ain>(Arrays.asList(ain.a((aow)aox.d), ain.a((aow)aox.e), ain.a((aow)aox.aV), ain.a((aow)aox.b))));
    public final Setting<List<aow>> blocksToAvoid = new Setting(new ArrayList());
    public final Setting<List<aow>> blocksToDisallowBreaking = new Setting(new ArrayList());
    public final Setting<List<aow>> blocksToAvoidBreaking = new Setting(new ArrayList<aow>(Arrays.asList(aox.ai, aox.al, aox.am, aox.ae, aox.cg, aox.an, aox.ax)));
    public final Setting<Double> avoidBreakingMultiplier = new Setting(0.1);
    public final Setting<List<aow>> buildIgnoreBlocks = new Setting(new ArrayList<aow>(Arrays.asList(new aow[0])));
    public final Setting<List<aow>> buildSkipBlocks = new Setting(new ArrayList<aow>(Arrays.asList(new aow[0])));
    public final Setting<Map<aow, List<aow>>> buildValidSubstitutes = new Setting(new HashMap());
    public final Setting<Map<aow, List<aow>>> buildSubstitutes = new Setting(new HashMap());
    public final Setting<List<aow>> okIfAir = new Setting(new ArrayList<aow>(Arrays.asList(new aow[0])));
    public final Setting<Boolean> buildIgnoreExisting = new Setting(Boolean.FALSE);
    public final Setting<Boolean> buildIgnoreDirection = new Setting(Boolean.FALSE);
    public final Setting<List<String>> buildIgnoreProperties = new Setting(new ArrayList<String>(Arrays.asList(new String[0])));
    public final Setting<Boolean> avoidUpdatingFallingBlocks = new Setting(Boolean.TRUE);
    public final Setting<Boolean> allowVines = new Setting(Boolean.FALSE);
    public final Setting<Boolean> allowWalkOnBottomSlab = new Setting(Boolean.TRUE);
    public final Setting<Boolean> allowParkour = new Setting(Boolean.FALSE);
    public final Setting<Boolean> allowParkourPlace = new Setting(Boolean.FALSE);
    public final Setting<Boolean> considerPotionEffects = new Setting(Boolean.TRUE);
    public final Setting<Boolean> sprintAscends = new Setting(Boolean.TRUE);
    public final Setting<Boolean> overshootTraverse = new Setting(Boolean.TRUE);
    public final Setting<Boolean> pauseMiningForFallingBlocks = new Setting(Boolean.TRUE);
    public final Setting<Integer> rightClickSpeed = new Setting(4);
    public final Setting<Float> blockReachDistance = new Setting(Float.valueOf(4.5f));
    public final Setting<Double> randomLooking = new Setting(0.01);
    public final Setting<Double> costHeuristic = new Setting(3.563);
    public final Setting<Integer> pathingMaxChunkBorderFetch = new Setting(50);
    public final Setting<Double> backtrackCostFavoringCoefficient = new Setting(0.5);
    public final Setting<Boolean> avoidance = new Setting(Boolean.FALSE);
    public final Setting<Double> mobSpawnerAvoidanceCoefficient = new Setting(2.0);
    public final Setting<Integer> mobSpawnerAvoidanceRadius = new Setting(16);
    public final Setting<Double> mobAvoidanceCoefficient = new Setting(1.5);
    public final Setting<Integer> mobAvoidanceRadius = new Setting(8);
    public final Setting<Boolean> rightClickContainerOnArrival = new Setting(Boolean.TRUE);
    public final Setting<Boolean> enterPortal = new Setting(Boolean.TRUE);
    public final Setting<Boolean> minimumImprovementRepropagation = new Setting(Boolean.TRUE);
    public final Setting<Boolean> cutoffAtLoadBoundary = new Setting(Boolean.FALSE);
    public final Setting<Double> maxCostIncrease = new Setting(10.0);
    public final Setting<Integer> costVerificationLookahead = new Setting(5);
    public final Setting<Double> pathCutoffFactor = new Setting(0.9);
    public final Setting<Integer> pathCutoffMinimumLength = new Setting(30);
    public final Setting<Integer> planningTickLookahead = new Setting(150);
    public final Setting<Integer> pathingMapDefaultSize = new Setting(1024);
    public final Setting<Float> pathingMapLoadFactor = new Setting(Float.valueOf(0.75f));
    public final Setting<Integer> maxFallHeightNoWater = new Setting(3);
    public final Setting<Integer> maxFallHeightBucket = new Setting(20);
    public final Setting<Boolean> allowOvershootDiagonalDescend = new Setting(Boolean.TRUE);
    public final Setting<Boolean> simplifyUnloadedYCoord = new Setting(Boolean.TRUE);
    public final Setting<Boolean> repackOnAnyBlockChange = new Setting(Boolean.TRUE);
    public final Setting<Integer> movementTimeoutTicks = new Setting(100);
    public final Setting<Long> primaryTimeoutMS = new Setting(500L);
    public final Setting<Long> failureTimeoutMS = new Setting(2000L);
    public final Setting<Long> planAheadPrimaryTimeoutMS = new Setting(4000L);
    public final Setting<Long> planAheadFailureTimeoutMS = new Setting(5000L);
    public final Setting<Boolean> slowPath = new Setting(Boolean.FALSE);
    public final Setting<Long> slowPathTimeDelayMS = new Setting(100L);
    public final Setting<Long> slowPathTimeoutMS = new Setting(40000L);
    public final Setting<Boolean> doBedWaypoints = new Setting(Boolean.TRUE);
    public final Setting<Boolean> doDeathWaypoints = new Setting(Boolean.TRUE);
    public final Setting<Boolean> chunkCaching = new Setting(Boolean.TRUE);
    public final Setting<Boolean> pruneRegionsFromRAM = new Setting(Boolean.TRUE);
    public final Setting<Integer> chunkPackerQueueMaxSize = new Setting(2000);
    public final Setting<Boolean> backfill = new Setting(Boolean.FALSE);
    public final Setting<Boolean> logAsToast = new Setting(Boolean.FALSE);
    public final Setting<Long> toastTimer = new Setting(5000L);
    public final Setting<Boolean> chatDebug = new Setting(Boolean.FALSE);
    public final Setting<Boolean> chatControl = new Setting(Boolean.TRUE);
    public final Setting<Boolean> chatControlAnyway = new Setting(Boolean.FALSE);
    public final Setting<Boolean> renderPath = new Setting(Boolean.TRUE);
    public final Setting<Boolean> renderPathAsLine = new Setting(Boolean.FALSE);
    public final Setting<Boolean> renderGoal = new Setting(Boolean.TRUE);
    public final Setting<Boolean> renderGoalAnimated = new Setting(Boolean.TRUE);
    public final Setting<Boolean> renderSelectionBoxes = new Setting(Boolean.TRUE);
    public final Setting<Boolean> renderGoalIgnoreDepth = new Setting(Boolean.TRUE);
    public final Setting<Boolean> renderGoalXZBeacon = new Setting(Boolean.FALSE);
    public final Setting<Boolean> renderSelectionBoxesIgnoreDepth = new Setting(Boolean.TRUE);
    public final Setting<Boolean> renderPathIgnoreDepth = new Setting(Boolean.TRUE);
    public final Setting<Float> pathRenderLineWidthPixels = new Setting(Float.valueOf(5.0f));
    public final Setting<Float> goalRenderLineWidthPixels = new Setting(Float.valueOf(3.0f));
    public final Setting<Boolean> fadePath = new Setting(Boolean.FALSE);
    public final Setting<Boolean> freeLook = new Setting(Boolean.TRUE);
    public final Setting<Boolean> blockFreeLook = new Setting(Boolean.FALSE);
    public final Setting<Boolean> elytraFreeLook = new Setting(Boolean.FALSE);
    public final Setting<Boolean> smoothLook = new Setting(Boolean.FALSE);
    public final Setting<Boolean> elytraSmoothLook = new Setting(Boolean.TRUE);
    public final Setting<Integer> smoothLookTicks = new Setting(5);
    public final Setting<Boolean> remainWithExistingLookDirection = new Setting(Boolean.TRUE);
    public final Setting<Boolean> antiCheatCompatibility = new Setting(Boolean.TRUE);
    public final Setting<Boolean> pathThroughCachedOnly = new Setting(Boolean.FALSE);
    public final Setting<Boolean> sprintInWater = new Setting(Boolean.TRUE);
    public final Setting<Boolean> blacklistClosestOnFailure = new Setting(Boolean.TRUE);
    public final Setting<Boolean> renderCachedChunks = new Setting(Boolean.FALSE);
    public final Setting<Float> cachedChunksOpacity = new Setting(Float.valueOf(0.5f));
    public final Setting<Boolean> prefixControl = new Setting(Boolean.TRUE);
    public final Setting<String> prefix = new Setting("#");
    public final Setting<Boolean> shortBaritonePrefix = new Setting(Boolean.FALSE);
    public final Setting<Boolean> echoCommands = new Setting(Boolean.TRUE);
    public final Setting<Boolean> censorCoordinates = new Setting(Boolean.FALSE);
    public final Setting<Boolean> censorRanCommands = new Setting(Boolean.FALSE);
    public final Setting<Boolean> itemSaver = new Setting(Boolean.FALSE);
    public final Setting<Integer> itemSaverThreshold = new Setting(10);
    public final Setting<Boolean> preferSilkTouch = new Setting(Boolean.FALSE);
    public final Setting<Boolean> walkWhileBreaking = new Setting(Boolean.TRUE);
    public final Setting<Boolean> splicePath = new Setting(Boolean.TRUE);
    public final Setting<Integer> maxPathHistoryLength = new Setting(300);
    public final Setting<Integer> pathHistoryCutoffAmount = new Setting(50);
    public final Setting<Integer> mineGoalUpdateInterval = new Setting(5);
    public final Setting<Integer> maxCachedWorldScanCount = new Setting(10);
    public final Setting<Integer> minYLevelWhileMining = new Setting(0);
    public final Setting<Integer> maxYLevelWhileMining = new Setting(255);
    public final Setting<Boolean> allowOnlyExposedOres = new Setting(Boolean.FALSE);
    public final Setting<Integer> allowOnlyExposedOresDistance = new Setting(1);
    public final Setting<Boolean> exploreForBlocks = new Setting(Boolean.TRUE);
    public final Setting<Integer> worldExploringChunkOffset = new Setting(0);
    public final Setting<Integer> exploreChunkSetMinimumSize = new Setting(10);
    public final Setting<Integer> exploreMaintainY = new Setting(64);
    public final Setting<Boolean> replantCrops = new Setting(Boolean.TRUE);
    public final Setting<Boolean> replantNetherWart = new Setting(Boolean.FALSE);
    public final Setting<Boolean> extendCacheOnThreshold = new Setting(Boolean.FALSE);
    public final Setting<Boolean> buildInLayers = new Setting(Boolean.FALSE);
    public final Setting<Boolean> layerOrder = new Setting(Boolean.FALSE);
    public final Setting<Integer> layerHeight = new Setting(1);
    public final Setting<Integer> startAtLayer = new Setting(0);
    public final Setting<Boolean> skipFailedLayers = new Setting(Boolean.FALSE);
    public final Setting<Boolean> buildOnlySelection = new Setting(Boolean.FALSE);
    public final Setting<fq> buildRepeat = new Setting(new fq(0, 0, 0));
    public final Setting<Integer> buildRepeatCount = new Setting(-1);
    public final Setting<Boolean> buildRepeatSneaky = new Setting(Boolean.TRUE);
    public final Setting<Boolean> breakFromAbove = new Setting(Boolean.FALSE);
    public final Setting<Boolean> goalBreakFromAbove = new Setting(Boolean.FALSE);
    public final Setting<Boolean> mapArtMode = new Setting(Boolean.FALSE);
    public final Setting<Boolean> okIfWater = new Setting(Boolean.FALSE);
    public final Setting<Integer> incorrectSize = new Setting(100);
    public final Setting<Double> breakCorrectBlockPenaltyMultiplier = new Setting(10.0);
    public final Setting<Boolean> schematicOrientationX = new Setting(Boolean.FALSE);
    public final Setting<Boolean> schematicOrientationY = new Setting(Boolean.FALSE);
    public final Setting<Boolean> schematicOrientationZ = new Setting(Boolean.FALSE);
    public final Setting<String> schematicFallbackExtension = new Setting("schematic");
    public final Setting<Integer> builderTickScanRadius = new Setting(5);
    public final Setting<Boolean> mineScanDroppedItems = new Setting(Boolean.TRUE);
    public final Setting<Long> mineDropLoiterDurationMSThanksLouca = new Setting(250L);
    public final Setting<Boolean> distanceTrim = new Setting(Boolean.TRUE);
    public final Setting<Boolean> cancelOnGoalInvalidation = new Setting(Boolean.TRUE);
    public final Setting<Integer> axisHeight = new Setting(120);
    public final Setting<Boolean> disconnectOnArrival = new Setting(Boolean.FALSE);
    public final Setting<Boolean> legitMine = new Setting(Boolean.FALSE);
    public final Setting<Integer> legitMineYLevel = new Setting(11);
    public final Setting<Boolean> legitMineIncludeDiagonals = new Setting(Boolean.FALSE);
    public final Setting<Boolean> forceInternalMining = new Setting(Boolean.TRUE);
    public final Setting<Boolean> internalMiningAirException = new Setting(Boolean.TRUE);
    public final Setting<Double> followOffsetDistance = new Setting(0.0);
    public final Setting<Float> followOffsetDirection = new Setting(Float.valueOf(0.0f));
    public final Setting<Integer> followRadius = new Setting(3);
    public final Setting<Boolean> disableCompletionCheck = new Setting(Boolean.FALSE);
    public final Setting<Long> cachedChunksExpirySeconds = new Setting(-1L);
    @JavaOnly
    public final Setting<Consumer<hh>> logger = new Setting(hh2 -> bib.z().q.d().a(hh2));
    @JavaOnly
    public final Setting<BiConsumer<String, Boolean>> notifier = new Setting(NotificationHelper::notify);
    @JavaOnly
    public final Setting<BiConsumer<hh, hh>> toaster = new Setting(BaritoneToast::addOrUpdate);
    public final Setting<Double> yLevelBoxSize = new Setting(15.0);
    public final Setting<Color> colorCurrentPath = new Setting(Color.RED);
    public final Setting<Color> colorNextPath = new Setting(Color.MAGENTA);
    public final Setting<Color> colorBlocksToBreak = new Setting(Color.RED);
    public final Setting<Color> colorBlocksToPlace = new Setting(Color.GREEN);
    public final Setting<Color> colorBlocksToWalkInto = new Setting(Color.MAGENTA);
    public final Setting<Color> colorBestPathSoFar = new Setting(Color.BLUE);
    public final Setting<Color> colorMostRecentConsidered = new Setting(Color.CYAN);
    public final Setting<Color> colorGoalBox = new Setting(Color.GREEN);
    public final Setting<Color> colorInvertedGoalBox = new Setting(Color.RED);
    public final Setting<Color> colorSelection = new Setting(Color.CYAN);
    public final Setting<Color> colorSelectionPos1 = new Setting(Color.BLACK);
    public final Setting<Color> colorSelectionPos2 = new Setting(Color.ORANGE);
    public final Setting<Float> selectionOpacity = new Setting(Float.valueOf(0.5f));
    public final Setting<Float> selectionLineWidth = new Setting(Float.valueOf(2.0f));
    public final Setting<Boolean> renderSelection = new Setting(Boolean.TRUE);
    public final Setting<Boolean> renderSelectionIgnoreDepth = new Setting(Boolean.TRUE);
    public final Setting<Boolean> renderSelectionCorners = new Setting(Boolean.TRUE);
    public final Setting<Boolean> useSwordToMine = new Setting(Boolean.TRUE);
    public final Setting<Boolean> desktopNotifications = new Setting(Boolean.FALSE);
    public final Setting<Boolean> notificationOnPathComplete = new Setting(Boolean.TRUE);
    public final Setting<Boolean> notificationOnFarmFail = new Setting(Boolean.TRUE);
    public final Setting<Boolean> notificationOnBuildFinished = new Setting(Boolean.TRUE);
    public final Setting<Boolean> notificationOnExploreFinished = new Setting(Boolean.TRUE);
    public final Setting<Boolean> notificationOnMineFail = new Setting(Boolean.TRUE);
    public final Setting<Integer> elytraSimulationTicks = new Setting(20);
    public final Setting<Integer> elytraPitchRange = new Setting(25);
    public final Setting<Double> elytraFireworkSpeed = new Setting(1.2);
    public final Setting<Integer> elytraFireworkSetbackUseDelay = new Setting(15);
    public final Setting<Double> elytraMinimumAvoidance = new Setting(0.2);
    public final Setting<Boolean> elytraConserveFireworks = new Setting(Boolean.FALSE);
    public final Setting<Boolean> elytraRenderRaytraces = new Setting(Boolean.FALSE);
    public final Setting<Boolean> elytraRenderHitboxRaytraces = new Setting(Boolean.FALSE);
    public final Setting<Boolean> elytraRenderSimulation = new Setting(Boolean.TRUE);
    public final Setting<Boolean> elytraAutoJump = new Setting(Boolean.FALSE);
    public final Setting<Long> elytraNetherSeed = new Setting(146008555100680L);
    public final Setting<Boolean> elytraPredictTerrain = new Setting(Boolean.TRUE);
    public final Setting<Boolean> elytraAutoSwap = new Setting(Boolean.TRUE);
    public final Setting<Integer> elytraMinimumDurability = new Setting(5);
    public final Setting<Integer> elytraMinFireworksBeforeLanding = new Setting(5);
    public final Setting<Boolean> elytraAllowEmergencyLand = new Setting(Boolean.TRUE);
    public final Setting<Long> elytraTimeBetweenCacheCullSecs = new Setting(TimeUnit.MINUTES.toSeconds(3L));
    public final Setting<Integer> elytraCacheCullDistance = new Setting(5000);
    public final Setting<Boolean> elytraAllowLandOnNetherFortress = new Setting(Boolean.FALSE);
    public final Setting<Boolean> elytraTermsAccepted = new Setting(Boolean.FALSE);
    public final Map<String, Setting<?>> byLowerName;
    public final List<Setting<?>> allSettings;
    public final Map<Setting<?>, Type> settingTypes;

    Settings() {
        Field[] fieldArray = this.getClass().getFields();
        HashMap<String, Setting> hashMap = new HashMap<String, Setting>();
        ArrayList<Setting> arrayList = new ArrayList<Setting>();
        HashMap<Setting, Type> hashMap2 = new HashMap<Setting, Type>();
        try {
            for (Field field : fieldArray) {
                if (!field.getType().equals(Setting.class)) continue;
                Setting setting = (Setting)field.get(this);
                String string = field.getName();
                setting.name = string;
                setting.javaOnly = field.isAnnotationPresent(JavaOnly.class);
                string = string.toLowerCase();
                if (hashMap.containsKey(string)) {
                    throw new IllegalStateException("Duplicate setting name");
                }
                hashMap.put(string, setting);
                arrayList.add(setting);
                hashMap2.put(setting, ((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0]);
            }
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException(illegalAccessException);
        }
        this.byLowerName = Collections.unmodifiableMap(hashMap);
        this.allSettings = Collections.unmodifiableList(arrayList);
        this.settingTypes = Collections.unmodifiableMap(hashMap2);
    }

    public final <T> List<Setting<T>> getAllValuesByType(Class<T> clazz) {
        ArrayList<Setting<T>> arrayList = new ArrayList<Setting<T>>();
        for (Setting<?> setting : this.allSettings) {
            if (!setting.getValueClass().equals(clazz)) continue;
            arrayList.add(setting);
        }
        return arrayList;
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.FIELD})
    static @interface JavaOnly {
    }

    public final class Setting<T> {
        public T value;
        public final T defaultValue;
        private String name;
        private boolean javaOnly;

        private Setting(T t2) {
            if (t2 == null) {
                throw new IllegalArgumentException("Cannot determine value type class from null");
            }
            this.value = t2;
            this.defaultValue = t2;
            this.javaOnly = false;
        }

        @Deprecated
        public final T get() {
            return this.value;
        }

        public final String getName() {
            return this.name;
        }

        public final Class<T> getValueClass() {
            return TypeUtils.resolveBaseClass(this.getType());
        }

        public final String toString() {
            return SettingsUtil.settingToString(this);
        }

        public final void reset() {
            this.value = this.defaultValue;
        }

        public final Type getType() {
            return Settings.this.settingTypes.get(this);
        }

        public final boolean isJavaOnly() {
            return this.javaOnly;
        }
    }
}


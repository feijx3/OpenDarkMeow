/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.cache.IWaypoint;
import baritone.api.cache.IWaypointCollection;
import baritone.api.cache.Waypoint;
import baritone.api.utils.BetterBlockPos;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class r
implements IWaypointCollection {
    private final Path a;
    private final Map<IWaypoint.Tag, Set<IWaypoint>> a;

    r(Path path) {
        this.a = path;
        if (!Files.exists(path, new LinkOption[0])) {
            try {
                Files.createDirectories(path, new FileAttribute[0]);
            }
            catch (IOException iOException) {}
        }
        System.out.println("Would save waypoints to ".concat(String.valueOf(path)));
        this.a = new HashMap();
        this.a();
    }

    private void a() {
        for (IWaypoint.Tag tag : IWaypoint.Tag.values()) {
            this.a(tag);
        }
    }

    private synchronized void a(IWaypoint.Tag tag) {
        this.a.put(tag, new HashSet());
        Object object = this.a.resolve(tag.name().toLowerCase() + ".mp4");
        if (!Files.exists((Path)object, new LinkOption[0])) {
            return;
        }
        try {
            object = new FileInputStream(object.toFile());
            Throwable throwable = null;
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream((InputStream)object);
                Throwable throwable2 = null;
                try {
                    DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
                    Throwable throwable3 = null;
                    try {
                        long l2 = dataInputStream.readLong();
                        if (l2 != 121977993584L) {
                            throw new IOException("Bad magic value ".concat(String.valueOf(l2)));
                        }
                        long l3 = dataInputStream.readLong();
                        while (l3-- > 0L) {
                            String string = dataInputStream.readUTF();
                            long l4 = dataInputStream.readLong();
                            int n2 = dataInputStream.readInt();
                            int n3 = dataInputStream.readInt();
                            int n4 = dataInputStream.readInt();
                            ((Set)this.a.get((Object)tag)).add(new Waypoint(string, tag, new BetterBlockPos(n2, n3, n4), l4));
                        }
                    }
                    catch (Throwable throwable4) {
                        try {
                            Throwable throwable5 = throwable4;
                            throwable3 = throwable4;
                            throw throwable5;
                        }
                        catch (Throwable throwable6) {
                            if (throwable3 != null) {
                                try {
                                    dataInputStream.close();
                                }
                                catch (Throwable throwable7) {
                                    throwable3.addSuppressed(throwable7);
                                }
                            } else {
                                dataInputStream.close();
                            }
                            throw throwable6;
                        }
                    }
                    dataInputStream.close();
                }
                catch (Throwable throwable8) {
                    try {
                        Throwable throwable9 = throwable8;
                        throwable2 = throwable8;
                        throw throwable9;
                    }
                    catch (Throwable throwable10) {
                        if (throwable2 != null) {
                            try {
                                bufferedInputStream.close();
                            }
                            catch (Throwable throwable11) {
                                throwable2.addSuppressed(throwable11);
                            }
                        } else {
                            bufferedInputStream.close();
                        }
                        throw throwable10;
                    }
                }
                bufferedInputStream.close();
            }
            catch (Throwable throwable12) {
                try {
                    Throwable throwable13 = throwable12;
                    throwable = throwable12;
                    throw throwable13;
                }
                catch (Throwable throwable14) {
                    if (throwable != null) {
                        try {
                            ((FileInputStream)object).close();
                        }
                        catch (Throwable throwable15) {
                            throwable.addSuppressed(throwable15);
                        }
                    } else {
                        ((FileInputStream)object).close();
                    }
                    throw throwable14;
                }
            }
            ((FileInputStream)object).close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    private synchronized void b(IWaypoint.Tag object) {
        Object object2 = this.a.resolve(((Enum)object).name().toLowerCase() + ".mp4");
        try {
            object2 = new FileOutputStream(object2.toFile());
            Throwable throwable = null;
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream((OutputStream)object2);
                Throwable throwable2 = null;
                try {
                    DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
                    Throwable throwable3 = null;
                    try {
                        dataOutputStream.writeLong(121977993584L);
                        dataOutputStream.writeLong(((Set)this.a.get(object)).size());
                        for (IWaypoint iWaypoint : (Set)this.a.get(object)) {
                            dataOutputStream.writeUTF(iWaypoint.getName());
                            dataOutputStream.writeLong(iWaypoint.getCreationTimestamp());
                            dataOutputStream.writeInt(iWaypoint.getLocation().p());
                            dataOutputStream.writeInt(iWaypoint.getLocation().q());
                            dataOutputStream.writeInt(iWaypoint.getLocation().r());
                        }
                    }
                    catch (Throwable throwable4) {
                        try {
                            object = throwable4;
                            throwable3 = throwable4;
                            throw object;
                        }
                        catch (Throwable throwable5) {
                            if (throwable3 != null) {
                                try {
                                    dataOutputStream.close();
                                }
                                catch (Throwable throwable6) {
                                    throwable3.addSuppressed(throwable6);
                                }
                            } else {
                                dataOutputStream.close();
                            }
                            throw throwable5;
                        }
                    }
                    dataOutputStream.close();
                }
                catch (Throwable throwable7) {
                    try {
                        Throwable throwable8 = throwable7;
                        throwable2 = throwable7;
                        throw throwable8;
                    }
                    catch (Throwable throwable9) {
                        if (throwable2 != null) {
                            try {
                                bufferedOutputStream.close();
                            }
                            catch (Throwable throwable10) {
                                throwable2.addSuppressed(throwable10);
                            }
                        } else {
                            bufferedOutputStream.close();
                        }
                        throw throwable9;
                    }
                }
                bufferedOutputStream.close();
            }
            catch (Throwable throwable11) {
                try {
                    Throwable throwable12 = throwable11;
                    throwable = throwable11;
                    throw throwable12;
                }
                catch (Throwable throwable13) {
                    if (throwable != null) {
                        try {
                            ((FileOutputStream)object2).close();
                        }
                        catch (Throwable throwable14) {
                            throwable.addSuppressed(throwable14);
                        }
                    } else {
                        ((FileOutputStream)object2).close();
                    }
                    throw throwable13;
                }
            }
            ((FileOutputStream)object2).close();
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
    }

    @Override
    public final void addWaypoint(IWaypoint iWaypoint) {
        if (((Set)this.a.get((Object)iWaypoint.getTag())).add(iWaypoint)) {
            this.b(iWaypoint.getTag());
        }
    }

    @Override
    public final void removeWaypoint(IWaypoint iWaypoint) {
        if (((Set)this.a.get((Object)iWaypoint.getTag())).remove(iWaypoint)) {
            this.b(iWaypoint.getTag());
        }
    }

    @Override
    public final IWaypoint getMostRecentByTag(IWaypoint.Tag tag) {
        return ((Set)this.a.get((Object)tag)).stream().min(Comparator.comparingLong(iWaypoint -> -iWaypoint.getCreationTimestamp())).orElse(null);
    }

    @Override
    public final Set<IWaypoint> getByTag(IWaypoint.Tag tag) {
        return Collections.unmodifiableSet((Set)this.a.get((Object)tag));
    }

    @Override
    public final Set<IWaypoint> getAllWaypoints() {
        return this.a.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }
}


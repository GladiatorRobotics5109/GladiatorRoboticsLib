package org.gladiatorrobotics.gladiatorroboticslib;

import java.util.ArrayList;
import java.util.List;

public final class PeriodicUtil {
    public static abstract class PeriodicBase {
        public PeriodicBase() {
            PeriodicUtil.registerPeriodic(this);
        }

        public abstract void periodic();
    }

    private static List<Runnable> s_periodics = new ArrayList<>();

    public static void registerPeriodic(PeriodicBase periodic) {
        s_periodics.add(periodic::periodic);
    }

    public static void registerPeriodic(Runnable runnable) {
        s_periodics.add(runnable);
    }

    public static void periodic() {
        for (Runnable runnable : s_periodics) {
            runnable.run();
        }
    }
}

package org.gladiatorrobotics.gladiatorroboticslib.constants.swerveModuleConstants;

public final class SwerveDriveSpecialtiesConstants {
    public static final class MK4Constants {
        public static final double kTurnGearRatio = 12.8;

        public static final double kL1DriveGearRatio = 8.14;
        public static final double kL2DriveGearRatio = 6.75;
        public static final double kL3DriveGearRatio = 6.12;
        public static final double kL4DriveGearRatio = 5.14;

        public enum MK4GearRatio {
            L1,
            L2,
            L3,
            L4
        }

        public static double getDriveGearRatio(MK4GearRatio ratio) {
            return switch (ratio) {
                case L1 -> kL1DriveGearRatio;
                case L2 -> kL2DriveGearRatio;
                case L3 -> kL3DriveGearRatio;
                case L4 -> kL4DriveGearRatio;
            };
        }
    }
}

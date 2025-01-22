package com.github.gladiatorrobotics5109.gladiatorroboticslib.math;

import com.github.gladiatorrobotics5109.gladiatorroboticslib.constants.swerveModuleConstants.SwerveDriveSpecialtiesConstants.MK4Constants;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;

public class ConversionsBase {
    protected ConversionsBase() {
        throw new UnsupportedOperationException("This is a utility class!");
    }

    // Most of these functions just call their respective functions in the Units utility class because of the conflict
    // in naming between edu.wpi.first.math.util.Units and edu.wpi.first.units.Units classes (I HATE this conflict).

    public static double poundsToKilograms(double lbs) {
        return 0.4535924 * lbs;
    }

    public static double inchesToMeters(double in) {
        return Units.inchesToMeters(in);
    }

    public static double metersToInches(double m) {
        return Units.metersToInches(m);
    }

    public static double degreesToRadians(double deg) {
        return Units.degreesToRadians(deg);
    }

    public static double radiansToDegrees(double rad) {
        return Units.radiansToDegrees(rad);
    }

    public static double radiansToRotations(double rad) {
        return radiansToRotations(rad, 1);
    }

    public static double radiansToRotations(double rad, double gearRatio) {
        return Units.radiansToRotations(rad * gearRatio);
    }

    public static double rotationsToRadians(double rot) {
        return rotationsToRadians(rot, 1);
    }

    public static double rotationsToRadians(double rot, double gearRatio) {
        return Units.rotationsToRadians(rot * gearRatio);
    }

    public static double rotationsPerMinuteToRadiansPerSecond(double rotPerMin) {
        return rotationsPerMinuteToRadiansPerSecond(rotPerMin, 1);
    }

    public static double rotationsPerMinuteToRadiansPerSecond(double rotPerMin, double gearRatio) {
        return Units.rotationsPerMinuteToRadiansPerSecond(rotPerMin * gearRatio);
    }

    public static double radiansPerSecondToRotationsPerMinute(double radPerSec) {
        return radiansPerSecondToRotationsPerMinute(radPerSec, 1);
    }

    public static double radiansPerSecondToRotationsPerMinute(double radPerSec, double gearRatio) {
        return Units.radiansPerSecondToRotationsPerMinute(radPerSec * gearRatio);
    }

    public static double driveMotorRotationsToDriveWheelRadians(double rot, MK4Constants.MK4GearRatio gearRatio) {
        return rotationsToRadians(rot, 1 / gearRatio.asDouble());
    }

    public static double driveWheelRotationsToDriveMotorRadians(double rot, MK4Constants.MK4GearRatio gearRatio) {
        return rotationsToRadians(rot, gearRatio.asDouble());
    }

    public static double driveMotorRadiansToDriveWheelMeters(
        double rad,
        double effectiveWheelRadiusM,
        MK4Constants.MK4GearRatio gearRatio
    ) {
        return radiansToMeters(rad * gearRatio.asDouble(), effectiveWheelRadiusM);
    }

    public static double radiansToMeters(double rad, double radiusM) {
        return radiansToMeters(rad, radiusM, 1);
    }

    public static double radiansToMeters(double rad, double radiusM, double gearRatio) {
        return (rad * gearRatio) * radiusM;
    }

    public static double metersToRadians(double m, double radiusM, double gearRatio) {
        // m / C * 2PI
        // m / (2PI * r) * 2PI
        // m / r
        return (m / radiusM) * gearRatio;
    }

    public static double driveWheelMetersToDriveMotorRadians(
        double m,
        double effectiveWheelRadiusMeters,
        MK4Constants.MK4GearRatio gearRatio
    ) {
        return metersToRadians(m, effectiveWheelRadiusMeters, gearRatio.asDouble());
    }

    public static double turnMotorRotationsToDriveWheelRadians(double rot) {
        return rotationsToRadians(rot, 1 / MK4Constants.kTurnGearRatio);
    }

    public static final Rotation2d turnMotorRadiansToDriveWheelRotation2d(double rad) {
        return Rotation2d.fromRadians(rad / MK4Constants.kTurnGearRatio);
    }

    public static Rotation2d turnMotorRotationsToDriveWheelRotation2d(double rot) {
        return Rotation2d.fromRadians(turnMotorRotationsToDriveWheelRadians(rot));
    }

    public static Rotation2d driveWheelAngleRotation2dToTurnMotorRotation2d(Rotation2d angle, double gearRatio) {
        return angle.times(gearRatio);
    }

    public static double driveWheelRadiansToWheelMeters(double rad, double effectiveWheelRadiusMeters) {
        return radiansToMeters(rad, effectiveWheelRadiusMeters);
    }

    public static double driveWheelMetersToWheelRadians(double m, double effectiveWheelRadiusMeters) {
        return metersToRadians(m, effectiveWheelRadiusMeters, 1);
    }

    public static double feetToMeters(double ft) {
        return Units.feetToMeters(ft);
    }

    public static double metersToFeet(double m) {
        return Units.metersToFeet(m);
    }
}

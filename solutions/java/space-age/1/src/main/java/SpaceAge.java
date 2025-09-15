class SpaceAge {
    private double ageInSeconds;
    SpaceAge(double seconds) {
        ageInSeconds = seconds;
    }

    double getSeconds() {
        return ageInSeconds;
    }

    double onEarth() {
        return ageInSeconds/31557600.0;
    }

    double onMercury() {
        return ageInSeconds/(0.2408467 * 31557600.0);
    }

    double onVenus() {
        return ageInSeconds/(0.61519726 * 31557600.0);
    }

    double onMars() {
        return ageInSeconds/(1.8808158 * 31557600.0);
    }

    double onJupiter() {
        return ageInSeconds/(11.862615 * 31557600.0);
    }

    double onSaturn() {
        return ageInSeconds/(29.447498 * 31557600.0);
    }

    double onUranus() {
        return ageInSeconds/(84.016846 * 31557600.0);
    }

    double onNeptune() {
        return ageInSeconds/(164.79132 * 31557600.0);
    }

}

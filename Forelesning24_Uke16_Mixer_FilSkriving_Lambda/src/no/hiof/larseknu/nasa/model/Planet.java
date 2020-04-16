package no.hiof.larseknu.nasa.model;

public class Planet {
    public String name, discoveryMethod;
    public double orbitalPeriod, mass, radius;

    public Planet(String name, String discoveryMethod, double orbitalPeriod, double mass, double radius) {
        this.name = name;
        this.discoveryMethod = discoveryMethod;
        this.orbitalPeriod = orbitalPeriod;
        this.mass = mass;
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscoveryMethod() {
        return discoveryMethod;
    }

    public void setDiscoveryMethod(String discoveryMethod) {
        this.discoveryMethod = discoveryMethod;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

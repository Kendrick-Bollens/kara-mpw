package de.unistuttgart.hamster.main;

public enum Example {
    EXAMPLE_1("de.unistuttgart.hamster.territories/example01.ter"),
    EXAMPLE_2("de.unistuttgart.hamster.territories/example02.ter"),
    EXAMPLE_3("de.unistuttgart.hamster.territories/example03.ter");

    private final String src;

    Example(String src) {
        this.src = src;
    }

    public String getSrc() {
        return src;
    }
}

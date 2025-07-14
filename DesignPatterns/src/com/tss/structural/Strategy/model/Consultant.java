package com.tss.structural.Strategy.model;

public class Consultant implements IRole {
    @Override
    public String description() {
        return "Consultant";
    }

    @Override
    public String responsibility() {
        return "Write code";
    }
}

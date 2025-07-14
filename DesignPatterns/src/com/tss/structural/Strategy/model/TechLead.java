package com.tss.structural.Strategy.model;

public class TechLead implements IRole {
    @Override
    public String description() {
        return "Tech Lead";
    }

    @Override
    public String responsibility() {
        return "Assign work and lead team";
    }
}

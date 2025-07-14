package com.tss.structural.Strategy.model;

public class SeniorConsultant implements IRole {
    @Override
    public String description() {
        return "Senior Consultant";
    }

    @Override
    public String responsibility() {
        return "Review code";
    }
}

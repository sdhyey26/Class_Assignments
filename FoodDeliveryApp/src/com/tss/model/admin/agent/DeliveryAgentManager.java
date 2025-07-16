package com.tss.model.admin.agent;

import com.tss.model.admin.storage.FileStorage;
import com.tss.model.DeliveryAgents.*;

import java.util.ArrayList;
import java.util.Scanner;

public class DeliveryAgentManager {
    private static final String FILE = "agent.ser";

    public void addAgents() {
        Scanner sc = new Scanner(System.in);
        ArrayList<DeliveryAgent> list = FileStorage.loadListFromFile(FILE, DeliveryAgent.class);
        for (int i = 0; i < 2; i++) {
            DeliveryAgent agent = new DeliveryAgent();
            System.out.print("Enter agent name: ");
            agent.setName(sc.nextLine());
            list.add(agent);
        }
        FileStorage.saveListToFile(list, FILE);
    }

    public ArrayList<DeliveryAgent> getAgents() {
        return FileStorage.loadListFromFile(FILE, DeliveryAgent.class);
    }
}

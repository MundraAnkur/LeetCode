package com.problem.coding.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ankurmundra
 * September 27, 2021
 */
public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String local = email.split("@")[0];
            local = local.split("\\+")[0];
            local = local.replace(".", "");
            set.add(local +"@"+ email.split("@")[1]);
        }
        return set.size();
    }
}

package com.ganga;

import org.clamshellcli.api.Context;
import org.clamshellcli.api.Prompt;

public class Expromat implements Prompt{
    private static final String PROMPT = "Ganga > ";
    public String getValue(Context ctx) {
        return PROMPT;
    }

    public void plug(Context plug) {
        // nothing to do
    }
}

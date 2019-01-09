package com.ericsson.bss.rm.eps.controller;

import org.clamshellcli.api.Context;
import org.clamshellcli.api.Prompt;

public class EpsPrompt implements Prompt
{
    private static final String PROMPT = "EPS>";

   // @Override
    public String getValue(Context ctx)
    {
        return PROMPT;
    }

    //@Override
    public void plug(Context plug)
    {
        // do nothing
    }

}

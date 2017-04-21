package com.methodlookup;
public abstract class CommandManager {

    public Object process() {
        // grab a new instance of the appropriate Command interface
        Command command = createCommand();
        System.out.println("The command object = "+command);
        return command.execute();
    }

    // okay... but where is the implementation of this method?
    protected abstract Command createCommand();
}
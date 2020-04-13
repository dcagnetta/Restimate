package co.za.codeboss.setup;

import co.za.codeboss.annotations.Command;

@Command
public class TestCommand {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestCommand(String name) {
        this.name = name;
    }
}

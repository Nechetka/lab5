package client.comands;

import system.SpaceMarinesManager;

public class ClearCommand implements BaseCommand{
    private final String name = "clear";

    @Override
    public void execute(String[] str) {
        SpaceMarinesManager colMan = SpaceMarinesManager.getInstance();
        colMan.clearCollection();
    }

    @Override
    public String descr() {
        return "Очищает коллекцию";
    }

    @Override
    public String getName() {
        return this.name;
    }

}

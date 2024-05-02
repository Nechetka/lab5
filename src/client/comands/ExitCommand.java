package client.comands;

public class ExitCommand implements BaseCommand{
    private final String name = "exit";

        @Override
        public void execute(String[] str) {
            System.exit(0);
        }

        @Override
        public String descr() {
            return "Завершает работу";
        }

        @Override
        public String getName() {
            return this.name;
        }

}

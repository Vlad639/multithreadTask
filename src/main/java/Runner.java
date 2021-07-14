class Runner extends Thread  {
    private final String name;
    private final String teamName;
    private final int distance = Race.raceDistance;
    private Runner nextRunner = null;

    public Runner(String name, String teamName){
        this.name = name;
        this.teamName = teamName;
    }

    public Runner(String name, String teamName, Runner nextRunner){
        this.name = name;
        this.nextRunner = nextRunner;
        this.teamName = teamName;
    }


    public void run(){
        try {
            if (nextRunner != null)
                nextRunner.join();

            for (int i = 1; i <= distance; i++) {
                if (Math.random() > 0.5)
                        sleep((long) (Math.random() * 100));

                System.out.println("Участник " + name + " [" + teamName + "]" + " пробежал " + i + " метров");
            }

            System.out.println("Участник " + name + " [" + teamName + "]" + " передал эстафету");

        }catch (Exception e){
            System.err.println("Началась гроза");
            e.printStackTrace();
        }
    }
}

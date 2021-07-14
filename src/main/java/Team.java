public class Team extends Thread {
    private final String teamName;
    private final String[] runnersNames;

    public Team(String teamName, String[] runnersNames) {
        this.teamName = teamName;
        this.runnersNames = runnersNames;
    }

    public void run(){
        try {
            Runner runner1 = new Runner(runnersNames[0], teamName);
            Runner runner2 = new Runner(runnersNames[1], teamName, runner1);
            Runner runner3 = new Runner(runnersNames[2], teamName, runner2);
            Runner runner4 = new Runner(runnersNames[3], teamName, runner3);

            runner1.start();
            runner2.start();
            runner3.start();
            runner4.start();

            runner4.join();

            System.err.println("Участник " + runnersNames[3] + " [" + teamName + "]" + " финишировал");

            if (Race.winnerTeamName == null)
                Race.winnerTeamName = teamName;

            Thread.yield();

        }catch (Exception e){
            System.err.println("Началась гроза");
            e.printStackTrace();
        }

    }

}

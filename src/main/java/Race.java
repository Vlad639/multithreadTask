class Race extends Thread{

    public static String winnerTeamName = null;
    public static int raceDistance = 350;

    public void run(){
        try {
            Team vita = new Team("Вита", new String[]{"Петр", "Василий", "Иван", "Глафира"});
            Team berkut = new Team("Беркут", new String[]{"Юрий", "Оксана", "Александр", "Анна"});

            vita.start();
            berkut.start();

            vita.join();
            berkut.join();

            System.err.println("Победила команда "+winnerTeamName);

        }catch (Exception e){
            System.err.println("Началась гроза");
            e.printStackTrace();
        }

    }
}

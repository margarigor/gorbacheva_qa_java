package lesson3;

public class Park {
    private String name;

    public Park(String name) {
        this.name = name;
    }

    public class Attraction{
        private String attractionName;
        private String operatingHours;
        private int cost;

        public Attraction (String attractionName, String operatingHours, int cost){
            this.attractionName = attractionName;
            this.operatingHours = operatingHours;
            this.cost = cost;
        }


        @Override
        public String toString() {
            return "Attraction{" +
                    "name='" + name + '\'' +
                    "attractionName='" + attractionName + '\'' +
                    ", operatingHours='" + operatingHours + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }
}

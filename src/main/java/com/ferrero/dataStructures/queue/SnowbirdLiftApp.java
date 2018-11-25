package com.ferrero.dataStructures.queue;


import lombok.Data;

public class SnowbirdLiftApp {
    /*
        Notare l'uso dell'interfaccia "CustomQueue" per dare la possibilità di utilizzare classi/tipologie di implementazione differenti.
        E' possibile quindi a questo punto instanziare una delle classi che implementano tale interfaccia (e.g. BasicQueue o ArrayListQueue)
    */
    CustomQueue<Gad2Chair> queue = new ArrayListQueue<>();

    public static void startSnowbirdLiftApp() {
        SnowbirdLiftApp app = new SnowbirdLiftApp();
        app.runLift();
    }

    public void runLift() {
        loadLift();

        //print out the lift size
        System.out.println(queue.size());

        //does the lift contain skiers Mary and Anna
        System.out.println("Lift has Mary and Anna on it: " + queue.contains(new Gad2Chair("Mary", "Anna")));

        //who's at the 2nd position - remember 0 based index
        System.out.println("2nd chair has: " + queue.access(1).listChairRiders());

        unloadLift();

        //if the lift is unloaded again, an error should occur since no one is left on it
        try {
            unloadLift();
        } catch (IllegalStateException t) {
            System.out.println("Can't unload any more skiers because the lift is empty: " + t.getMessage());
        }
    }

    private void loadLift() {
        //skiers in line to get on lift
        Gad2Chair chair1 = new Gad2Chair("John", "Dave");
        Gad2Chair chair2 = new Gad2Chair("Samantha", "Kelly");
        Gad2Chair chair3 = new Gad2Chair("Mary", "Anna");
        Gad2Chair chair4 = new Gad2Chair("Robert", "Chad");
        Gad2Chair chair5 = new Gad2Chair("Sarah", "Bill");

        //load them onto the lift
        queue.enQueue(chair1);
        queue.enQueue(chair2);
        queue.enQueue(chair3);
        queue.enQueue(chair4);
        queue.enQueue(chair5);
    }

    private void unloadLift() {
        Gad2Chair chair = queue.deQueue();

        //should be John and Dave
        System.out.println(chair.listChairRiders());

        chair = queue.deQueue();

        //should be Samantha and Kelly
        System.out.println(chair.listChairRiders());

        chair = queue.deQueue();

        //should be Mary and Anna
        System.out.println(chair.listChairRiders());

        chair = queue.deQueue();

        //should be Robert and Chad
        System.out.println(chair.listChairRiders());

        chair = queue.deQueue();

        //should be Sarah and Bill
        System.out.println(chair.listChairRiders());
    }

    @Data
    class Gad2Chair {
        private String seat1Name;
        private String seat2Name;

        public Gad2Chair(String skierInFirstSeat, String skierInSecondSeat) {
            this.seat1Name = skierInFirstSeat;
            this.seat2Name = skierInSecondSeat;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((seat1Name == null) ? 0 : seat1Name.hashCode());
            result = prime * result + ((seat2Name == null) ? 0 : seat2Name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Gad2Chair other = (Gad2Chair) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (seat1Name == null) {
                if (other.seat1Name != null)
                    return false;
            } else if (!seat1Name.equals(other.seat1Name))
                return false;
            if (seat2Name == null) {
                if (other.seat2Name != null)
                    return false;
            } else if (!seat2Name.equals(other.seat2Name))
                return false;
            else if ((getSeat1Name().equals(((Gad2Chair) obj).getSeat1Name()) ) && (getSeat2Name().equals(((Gad2Chair) obj).getSeat2Name())))
                return true;
            return true;
        }

        public String listChairRiders() {
            return this.seat1Name + ", " + this.seat2Name;
        }

        private SnowbirdLiftApp getOuterType() {
            return SnowbirdLiftApp.this;
        }
    }
}
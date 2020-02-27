package no.hiof.larseknu.lambda;

public class Main {

    public static void main(String[] args) {
        // Lambda uttrykk for å få et tilfeldig tall mellom 0 og 99
        SimpleMath randomNumber = () -> (int) (Math.random() * 100);

        // Tilsvarende med en anonym indre klasse
        SimpleMath randomNumberAnon = new SimpleMath() {
            @Override
            public int doMath() {
                return (int) (Math.random() * 100);
            }
        };

        System.out.println("Random Lambda: " + randomNumber.doMath());
        System.out.println("Random Lambda: " + randomNumber.doMath());
        System.out.println("Random Anon: " + randomNumberAnon.doMath());
        System.out.println("Random Anon: " + randomNumberAnon.doMath());

        // Lambda for å generere et tilfeldig tall fra 0 opp til n
        MediocreMath randomToMax = (n) -> (int) (Math.random() * n);

        System.out.println("RandomToMax: " + randomToMax.doMath(40));
        System.out.println("RandomToMax: " + randomToMax.doMath(10));
        System.out.println("RandomToMax: " + randomToMax.doMath(1000));

        // Lambda for å sjekke om et tall er større enn et annet
        MediumMath lessThan = (n, m) -> n < m;

        System.out.println("5 less than 6? " + lessThan.doMath(5, 6));


        AdvancedMath isPartOfFibonacciSequence = n -> {
            int x1 = 5*n*n + 4;
            int x2 = 5*n*n - 4;

            int s1 = (int) Math.sqrt(x1);
            int s2 = (int) Math.sqrt(x2);

            return (Math.pow(s1, 2) == x1 || Math.pow(s2, 2) == x2);
        };

        int fibonacci = 0;
        int i = 0;
        int j = 1;

        while (fibonacci < 1000) {
            System.out.println(fibonacci + " - " + isPartOfFibonacciSequence.doMath(fibonacci));
            fibonacci = i + j;
            j = i;
            i = fibonacci;
        }

        // Sjekker at 987 er en del av fibonacci-rekken
        System.out.println(isPartOfFibonacciSequence.doMath(987));
        // Sjekker at 420 ikke er en del av fibonacci-rekken
        System.out.println(isPartOfFibonacciSequence.doMath(420));
    }

}

interface SimpleMath {
    int doMath();
}

interface MediocreMath {
    int doMath(int number);
}

interface MediumMath {
    boolean doMath(int num1, int num2);
}

interface AdvancedMath {
    boolean doMath(int number);
}


public class Cat
{
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

   public static int catCount = 0 ;
    public  Cat()


    {
        catCount++;
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

    }

    public void meow()
    {
        if (weight>= 1000.0 || weight <= 9000.0){
            System.out.println("Meow");
            weight = weight - 1;

            if (weight < 1000 || weight > 9000) {
                catCount--;
            }

        }
    }

    public void feed(Double amount) {
        if (weight >= 1000.0 && weight <= 9000.0) {
            weight = weight + amount;
             if (weight < 1000.0 || weight > 9000.0) {
                 catCount--;
             }
        }

    }
    public double getFeed() // возвращает кол-во съеденой еды
    {
        return (weight - originWeight) ;
    }

    public static int getCatCount() {
        return catCount;
    }

    public void drink(Double amount) {
        if (weight >= 1000.0 && weight <= 9000.0) {
            weight = weight + amount;
            if (weight < 1000.0 || weight > 9000.0) {
                catCount--;
            }
        }
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }

    }
}
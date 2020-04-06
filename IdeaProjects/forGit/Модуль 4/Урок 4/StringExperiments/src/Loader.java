public class Loader {
    public static void main(String[] args) {
        String text = "As of 2019, 110 Nobel Prizes in Physiology or Medicine have been awarded to 207 men and 12 women. The first one was awarded in 1901 to the German physiologist Emil von Behring, for his work on serum therapy and the development of a vaccine against diphtheria. The first woman to receive the Nobel Prize in Physiology or Medicine, Gerty Cori, received it in 1947 for her role in elucidating the metabolism of glucose, important in many aspects of medicine, including treatment of diabetes. Some awards have been controversial. This includes one to António Egas Moniz in 1949 for the prefrontal lobotomy, bestowed despite protests from the medical establishment. Other controversies resulted from disagreements over who was included in the award. The 1952 prize to Selman Waksman was litigated in court, and half the patent rights awarded to his co-discoverer Albert Schatz who was not recognized by the prize. The 1962 prize awarded to James D. Watson, Francis Crick, and Maurice Wilkins for their work on DNA structure and properties did not acknowledge the contributing work from others, such as Oswald Avery and Rosalind Franklin who had died by the time of the nomination. Since the Nobel Prize rules forbid nominations of the deceased, longevity is an asset, considering prizes are awarded as long as 50 years after the discovery. Also forbidden is awarding any one prize to more than three recipients. In the last half century, there has been an increasing tendency for scientists to work as teams, resulting in controversial exclusions.";
        String[] splitText = text.split(" ");

        for (int i = 0; i < splitText.length; i++)    {
            System.out.println(splitText[i]);
        }

    }
}
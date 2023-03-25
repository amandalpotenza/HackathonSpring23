import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MoodJournal {

    private static String[] moods = {"Happy", "Sad", "Relaxed", "Excited", "Stressed", "Angry", "Confused", "Indifferent"};
    private static String[][] affirmations = {
            {"The point is not to pay back kindness but to pass it on.","Being happy never goes out of style.","Happiness depends upon ourselves.","What makes you happy doesn't need to make sense to others.","It's a good day to have a good day."},
            {"If all you did today was hold yourself together, I'm proud of you.","Healing is not linear.","You are not a drop in the ocean. You are an entire ocean in a drop.","Life isn't about waiting for the storm to pass, it's about learning to dance in the rain.","It is often in the darkest skies that we see the brightest stars."},
            {"It's all about finding the calm in the chaos.","The best cure for the body is the quiet mind.","Sometimes the most productive thing you can do is relax.","Take time to do what makes your soul happy.","Happiness is the art of relaxation."},
            {"Always believe that something wonderful is about to happen.","Grateful for where I'm at. Excited for where I'm going.","I choose to make the rest of my life, the best of my life.","Believe in yourself and you will be unstoppable.","It always seems impossible until it's done."},
            {"Worrying doesn't empty tomorrow of its sorrows; it empties today of its strengths.","You don't have to see the whole staircase, just take the first step.","Every moment is a fresh beginning.","Stress should be a powerful driving force, not an obstacle.","The time to relax is when you don't have time for it."},
            {"To be angry is to let others mistakes punish yourself.","If you are patient in one moment of anger, you will escape a hundred days of sorrow.","The greatest remedy for anger is delay.","Anger is a bad advisor.","ANGER IS ONE LETTER SHORT OF DANGER."},
            {"When you are confused and can not conclude, follow your instincts.","Confusion is the mother of new learning.","Confusion shows something inside you is waiting to be explored and discovered.","Part of being successful is about asking questions and listening to the answers.","I hear and I forget. I see and I remember. I do and I understand."},
            {"Do not go where the path may lead, go instead where there is no path and leave a trail.","You have brains in your head. You have feet in your shoes. You can steer yourself any direction you choose.","The only impossible journey is the one you never begin.","Live in the sunshine, swim the sea, drink the wild air.","Life itself is the most wonderful fairy tale."}
    };

    //The journal will hold mood entries for 365 days
    private static String[] moodEntries = new String[365];

    private static int currentDay = LocalDate.now().getDayOfYear();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static int currentMood;

    public static void main(String[] args) {
        boolean askedToday = false;
        while (true) {
            // Check if the day has changed
            int newDay = LocalDate.now().getDayOfYear();
            if (newDay > currentDay) {

                // Reset the mood journal
                currentDay = newDay;
                moodEntries[currentDay - 1] = String.valueOf(currentMood);
                askedToday = false;
            }

            //Ensures that the mood question is only asked once per day
            if (!askedToday) {
                // The user looks at the mood list
                System.out.println("Choose the number that corresponds to how you're feeling: ");
                for (int i = 0; i < moods.length; i++) {
                    System.out.printf("%d. %s\n", i+1, moods[i]);
                }

                // The user picks their mood from the given list!
                System.out.print("I'm feeling: ");
                int moodOptions = scanner.nextInt() - 1;

                //If the user enters and invalid input
                if (moodOptions < 0 || moodOptions >= moods.length) {
                    System.out.println("Sorry! That's not a valid mood. Please try again.");
                    continue;
                }

                // Update the current mood and print a random affirmation
                currentMood = moodOptions;
                String affirmation = getRandomAffirmation(currentMood);
                System.out.println("I see that you are feeling " + moodOptions);
                System.out.println("Here is a motivational affirmation to match your mood: " + affirmation);
                askedToday = true;
            }
        }
    }

    private static String getRandomAffirmation(int moodOptions) {
        String[] moodAffirmations = affirmations[moodOptions];
        int randomIndex = random.nextInt(moodAffirmations.length);
        return moodAffirmations[randomIndex];
    }
}

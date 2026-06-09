package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;
import static java.lang.String.format;

public class RandomUtils {

    public static String getRandomString(int length) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        SecureRandom rnd = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int index = rnd.nextInt(LETTERS.length());
            sb.append(LETTERS.charAt(index));
        }
        return sb.toString();
    }

    public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }

    public static String getRandomEmail() {

        return format("%s@%s.com", getRandomString(6), getRandomString(6));

    }

    public static String getRandomPhone() {

        return format("%s%s%s%s", getRandomInt(111,999), getRandomInt(111,999),
                getRandomInt(11,99), getRandomInt(11,99));

    }

    public static String getRandomArray(String[] stringArray){
        int stringLength = stringArray.length;
        int randomIndex = getRandomInt(0, stringLength-1);

        return stringArray[randomIndex];
    }

    public static String getRandomGender(){
        String[] genders = {"Male", "Female", "Other"};

        return getRandomArray(genders);
    }

    public static String getRandomMonth(){
        String[] month = {"January", "February", "March", "April", "May","June",
        "July", "August", "September", "October", "November", "December"};

        return getRandomArray(month);
    }

    public static String getRandomSubjects(){
        String[] subjects = {"Maths", "Accounting", "Arts", "Social Studies",
                "Biology", "Physics", "Chemistry", "Computer Science", "Commerce",
                "Economics", "Civics", "Hindi", "English", "History"};

        return getRandomArray(subjects);
    }

    public static String getRandomHobbies(){
        String[] hobbies = {"Sports", "Reading", "Music"};

        return getRandomArray(hobbies);
    }

    public static String getRandomPicture(){
        String[] picture = {"image.jpg", "111.jpg", "222.jpg"};

        return getRandomArray(picture);
    }

    public static String getRandomState(){
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return getRandomArray(state);
    }

    public static String getRandomCity(String state){
        switch(state){
            case "NCR":
                 return getRandomArray(new String[]{"Delhi", "Gurgaon", "Noida"});
            case "Uttar Pradesh":
                 return getRandomArray(new String[]{"Agra", "Lucknow", "Merrut"});
            case "Haryana":
                return getRandomArray(new String[]{"Karnal", "Panipat"});
            case "Rajasthan":
                return getRandomArray(new String[]{"Jaipur", "Jaiselmer"});
            default:
                return state;

        }
    }

    public static String getRandomInvalidPhone() {

        return format("%s-%s-%s-%s", getRandomInt(111,999), getRandomInt(111,999),
                getRandomInt(11,99), getRandomInt(11,99));

    }

}

package streamapi;

import java.util.Arrays;
import java.util.List;

public class StreamApi {
    public static List<People> peoples() {
        List<People> peoples = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Егор", 18, Sex.APACHE_HELICOPTER),
                new People("Женя", 27, Sex.TRANSNIGGER),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN));

//        System.out.println("пойдут служить: " + peoples.stream().filter(goToArmy -> (goToArmy.getAge() >= 18) && (goToArmy.getAge() <= 27)).toList());
//        System.out.println("средний возраст среди мужчин " + peoples.stream().filter(averageAgeMen -> averageAgeMen.getSex().equals(Sex.MAN)).mapToInt(x -> x.getAge()).average());
//        System.out.println("потенциально работоспособные люди " + peoples.stream().filter(potentiallyWorkingPeople ->
//                ((potentiallyWorkingPeople.getSex().equals(Sex.MAN) && (potentiallyWorkingPeople.getAge() < 60)))
//                        || ((potentiallyWorkingPeople.getSex().equals(Sex.WOMEN)) && (potentiallyWorkingPeople.getAge() < 55))).toList());
        return peoples;
    }
}


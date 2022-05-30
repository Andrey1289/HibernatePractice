package andrey.view;

import andrey.controller.DeveloperController;
import andrey.model.Skill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeveloperView {
    public static void main(String[] args) {
        DeveloperView developerView = new DeveloperView();
        developerView.devView();
    }
    private final DeveloperController dCont =new DeveloperController();
    public  void devView() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.println("Меню для создания Developer");
            System.out.println("Для завершения нажмите 'Exit'");

            String strUser ="";

            while(!strUser.equals("Exit")) {
                System.out.println("Введите действие: 'create' 'get' 'getAll' 'update' 'delete' ");
                strUser= br.readLine().trim();
                switch (strUser) {
                    case "create":
                        System.out.println("Введите developer 'firstName'");
                        String firstName = br.readLine().trim();
                        System.out.println("Введите developer 'lastName'");
                        String lastName = br.readLine().trim();
                        System.out.println("Введите 'developer skill'");
                        String devSkill = br.readLine().trim();
                        Skill skill = new Skill();
                        Set<Skill> skills = new HashSet<>();
                        skill.setName(devSkill);
                        skills.add(skill);
                        System.out.println("Введите 'team_id'");
                        Long team_id = Long.parseLong(br.readLine().trim());
                        dCont.create(firstName,lastName, team_id,skills);
                        System.out.println("Developer успешно создан");
                        break;
                    case "get":
                        Long id;
                        System.out.println("Введите 'ID' ");
                        try {
                            id = Long.parseLong(br.readLine().trim());
                        }catch (NumberFormatException e){
                            System.out.println("Вы ввели не число");
                            System.out.println("Введите 'ID'");
                            id = Long.parseLong(br.readLine().trim());
                        }
                        dCont.get(id);
                        break;
                    case "getAll":
                        dCont.getAll();
                        break;
                    case "update":
                        id = 0L;
                        System.out.println("Введите 'ID' имя которого хотите изменить");
                        try {
                            id = Long.parseLong(br.readLine().trim());
                            dCont.get(id);
                        }catch (NumberFormatException e){
                            System.out.println("Вы ввели не число");
                            System.out.println("Введите 'ID' имя которого хотите изменить");
                            id = Long.parseLong(br.readLine().trim());
                            dCont.get(id);
                        }
                        System.out.println("Введите 'firstName'");
                        firstName = br.readLine().trim();
                        System.out.println("ВВедите 'lastName'");
                        lastName = br.readLine().trim();
                        System.out.println("Введите 'team_id");
                        team_id = Long.parseLong(br.readLine().trim());
                        dCont.update(id,firstName,lastName,team_id);
                        System.out.println("Developer успешно изменен");
                        break;
                    case "delete":
                        System.out.println("ВВедите 'ID' для удаления");
                        try {
                            id = Long.parseLong(br.readLine().trim());
                            dCont.get(id);
                        }catch (NumberFormatException e){
                            System.out.println("Вы ввели не число");
                            System.out.println("ВВедите 'ID' для удаления");
                            id = Long.parseLong(br.readLine().trim());
                            dCont.get(id);
                        }
                        dCont.delete(id);
                        System.out.println("Developer успешно удален");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

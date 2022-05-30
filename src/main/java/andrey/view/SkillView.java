package andrey.view;

import andrey.controller.SkillController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class SkillView {
    public static void main(String[] args) {
        SkillView skv = new SkillView();
        skv.Skillview();
    }

    private final SkillController sCont =new SkillController();
    public  void Skillview() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.println("Меню создания 'Skill' ");
            System.out.println("Для завершения нажмите 'Exit'");
            String strUser ="";
            while(!strUser.equals("Exit")) {
                System.out.println("Введите действие: 'create' 'get' 'getAll' 'update' 'delete' ");
                strUser= br.readLine().trim();
                switch (strUser) {
                    case "create":
                        System.out.println("Введите 'Name'");
                        String name = br.readLine().trim();
                        sCont.create( name);
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
                        sCont.get(id);
                        break;
                    case "getAll":
                        sCont.getAll();
                        break;
                    case "update":
                        id = 0L;
                        System.out.println("Введите 'ID' имя которого хотите изменить");
                        try {
                            id = Long.parseLong(br.readLine().trim());
                        }catch (NumberFormatException e){
                            System.out.println("Вы ввели не число");
                            System.out.println("Введите 'ID' имя которого хотите изменить");
                            id = Long.parseLong(br.readLine().trim());
                        }
                        System.out.println("Введите 'Newname'");
                        name = br.readLine().trim();
                        sCont.update(id,name);
                        break;
                    case "delete":
                        System.out.println("ВВедите 'ID' для удаления");
                        try {
                            id = Long.parseLong(br.readLine().trim());
                        }catch (NumberFormatException e){
                            System.out.println("Вы ввели не число");
                            System.out.println("ВВедите 'ID' для удаления");
                            id = Long.parseLong(br.readLine().trim());
                        }
                        sCont.delete(id);
                        break;
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }
}
